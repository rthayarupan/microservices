package com.apress.demo;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

	@PostConstruct
	public void sayHallo() {
		System.out.println("PostConstruct Hallo Boot!");
	}
}
