package com.huntercodexs.example.service.impl;

import com.huntercodexs.example.service.HelloService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class Hello implements HelloService {

    @Override
    public Mono<?> sayHello() {
        return Mono.just("Hello From Web Flux");
    }

}
