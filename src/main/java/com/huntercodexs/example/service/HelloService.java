package com.huntercodexs.example.service;

import reactor.core.publisher.Mono;

public interface HelloService {
    Mono<?> sayHello();
}
