package com.huntercodexs.example.controller;

import com.huntercodexs.example.service.HelloService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
public class HelloController implements BaseController {

    @Autowired
    private HelloService service;

    @GetMapping("hello")
    public Mono<ResponseEntity<?>> hello(ServerWebExchange exchange) {
        return service.sayHello()
                .doFirst(() -> log.info("Start endpoint hello"))
                .flatMap(addressResponse -> Mono.just(ResponseEntity
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(addressResponse)));
    }
}
