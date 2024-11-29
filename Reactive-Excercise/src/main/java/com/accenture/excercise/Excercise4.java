package com.accenture.excercise;

import java.io.IOException;

public class Excercise4 {

    public static void main(String[] args) throws IOException {
        //Mono vs Flux
        ReactiveSources.userMono().log().subscribe(System.out::println);

        //log
//        ReactiveSources.intNumbersFlux()
//                //.log()
//                .filter(e-> e>5)
//                .log()
//                .subscribe(System.out::println);

        //Filtra los numeros mayores a 5, multiplicalos por 10 y toma los primeros 3
//        ReactiveSources.intNumbersFlux()
//                .filter(e -> e>5)
//                .take(3)
//                .map(e->e*10)
//                .subscribe(System.out::println);

        //Mostrar números únicos
//        ReactiveSources.intNumbersRepeat()
//                .distinct()
//                .log()
//                .subscribe();
//
//        ReactiveSources.intNumbersFlux()
//                .buffer(2)
//                .map(list -> list.get(0) + list.get(1))
//                .subscribe(System.out::println);

        System.out.println("Presiona Enter");
        System.in.read();
    }
}
