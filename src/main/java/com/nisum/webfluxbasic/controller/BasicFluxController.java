package com.nisum.webfluxbasic.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
public class BasicFluxController {

	@RequestMapping(value = "/mono")
	public Mono<Integer> getMonoData() {
		return Mono.just(1);
	}

	@RequestMapping(value = "/flux", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Integer> getFluxData() {
		return Flux.just(1, 2, 3, 4, 5,6, 7, 8, 9, 10, 11, 12).log();//.delayElements(Duration.ofSeconds(3));
	}
}
