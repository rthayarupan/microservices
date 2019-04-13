package com.apress.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private final TaskExecutor taskExecutor;

	public HelloWorldController(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	@GetMapping("/asyncsample")
	public Callable<String> hello() {
		return () -> {
			Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
			return "Async Sample from Spring Boot!";
		};
	}

	@GetMapping("/asyncsample2")
	public CompletableFuture<String> hello2() {
		return CompletableFuture.supplyAsync(() -> {
			randomDelay();
			return "Hello World, from Spring Boot 2!";
		}, taskExecutor);

	}

	private void randomDelay() {
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
