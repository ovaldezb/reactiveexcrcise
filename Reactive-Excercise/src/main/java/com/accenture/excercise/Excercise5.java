package com.accenture.excercise;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

public class Excercise5 {
    public static void main(String[] args) throws IOException {
        ReactiveSources.intNumberFluxFilter()
                .flatMap(id -> ReactiveSources.userFlux().filter(user -> user.getId()==id))
                .map(User::getName)
                .subscribe(System.out::println);

        Function<String, Publisher<String>> mapper = s -> Flux.just(s.toUpperCase().split(""));
        Flux<String> inFlux = Flux.just("accenture",".","com");
        //Flux<String> outFlux = inFlux.flatMap(mapper);
        //outFlux.subscribe(System.out::println);
        inFlux.flatMap(e->Flux.just(e.toUpperCase().split(""))).log()
                .subscribe(System.out::println);


        //Function<Mono<List<User>>, Flux<User>> mapper = mlu -> mlu.flatMapMany(Flux::fromIterable);
        Flux<User> outFlux = ReactiveSources.userListMono().flatMapMany(Flux::fromIterable).delayElements(Duration.ofSeconds(1));
        outFlux.subscribe(System.out::println);

        System.out.println("Press enter");
        int read = System.in.read();
    }
}
