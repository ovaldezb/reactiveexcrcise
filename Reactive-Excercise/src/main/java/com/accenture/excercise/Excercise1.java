package com.accenture.excercise;

import java.io.IOException;

public class Excercise1 {
    public static void main(String[] args) throws IOException {
        //Imprimir lista de numeros Strem
        ReactiveSources.stremNumber().forEach(
                value -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(value);
                }
        );

        //Imprimir la lista de números Flux

        //ReactiveSources.intNumbersFlux().subscribe(System.out::println);

        //ReactiveSources.userFlux().subscribe(System.out::println);

        //Convertir reactive a stream
        //List<Integer> numeros = ReactiveSources.intNumbersFlux().toStream().toList();
        //System.out.println(numeros);



        System.out.println(Thread.currentThread().getName());
        //System.in.read();
    }


}
