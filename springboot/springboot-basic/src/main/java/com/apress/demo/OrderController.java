package com.apress.demo;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/orders")
	public ResponseBodyEmitter orders() {
		ResponseBodyEmitter emitter = new ResponseBodyEmitter();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> {
			Iterable<Order> orders = orderService.findAll();
			try {
				for (Order order : orders) {
					randomDelay();
					emitter.send(order);
				}
				emitter.complete();
			} catch (IOException e) {
				emitter.completeWithError(e);
			}
		});
		executor.shutdown();
		return emitter;
	}

	@GetMapping("/orders2")
	public SseEmitter orders2() {
		SseEmitter emitter = new SseEmitter();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(() -> {
			Iterable<Order> orders = orderService.findAll();
			try {
				for (Order order : orders) {
					randomDelay();
					emitter.send(
							SseEmitter.event()
							.data(order)
							.name("order-created")
							.id(String.valueOf(order.hashCode())));
				}
				emitter.complete();
			} catch (IOException e) {
				emitter.completeWithError(e);
			}
		});
		executor.shutdown();
		return emitter;
	}

	private void randomDelay() {
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(1500));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
