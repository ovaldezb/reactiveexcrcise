package com.accenture.excercise;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReactiveSources {
    public static Flux<String> stringNumbersFlux(){
        return Flux.just("uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diex")
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> intNumbersFlux(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> intNumbersRepeat(){
        return Flux.just(1,2,2,3,4,5,6,3,2,4)
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> intNumbersFluxWithException(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .map(e->{
                    if(e==5) throw new RuntimeException("Ha ocurrido un error");
                    return e;
                });
    }

    public static Flux<Integer> intNumberFluxFilter(){
        return Flux.just(1,2,4,6);
    }

    public static Flux<User> userFlux(){
        return Flux.just(
                new User(1,"Lionel","Messi"),
                new User(2,"Cristiano","Ronaldo"),
                new User(3,"Diego","Maradona"),
                new User(4,"Zinedine","Zidane"),
                new User(5,"Jurgen","Klinsman"),
                new User(6,"Gareth","Bale")
        ).delayElements(Duration.ofSeconds(1));
    }

    public static Mono<User> userMono(){
        return Mono.just(new User(1,"Diego","Maradona")).delayElement(Duration.ofSeconds(1));
    }

    public static Mono<List<User>> userListMono(){
        return Mono.just(Arrays.asList(
                new User(1,"Lionel","Mesi"),
                new User(2,"Cristiano","Ronaldo"),
                new User(3,"Diego","Maradona"),
                new User(4,"Zinedine","Zidane"),
                new User(5,"Jurgen","Klinsman"),
                new User(6,"Gareth","Bale")
                ));
    }

    public static Mono<String> unresponsiveMono(){
        return Mono.never();
    }

    public static IntStream stremNumber(){
        return IntStream.range(1,10);
    }
}
