package com.accenture.excercise;

import org.reactivestreams.Publisher;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Excercise2 {
    public static void main(String[] args) throws IOException {

        ReactiveSources.userFlux().subscribe(System.out::println,
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Llego al final!"));

// BackPresure
        ReactiveSources.intNumbersFlux()
                .subscribe(new MySubscriber<>());

        System.out.println("Presiona enter");
        System.in.read();
    }
}
