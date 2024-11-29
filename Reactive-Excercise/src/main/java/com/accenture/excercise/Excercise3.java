package com.accenture.excercise;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

import java.io.IOException;
import java.time.Duration;

public class Excercise3 {
    public static void main(String[] args) throws IOException {

        //Unresponsive
        //String foo = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));

        //Error
//        ReactiveSources.intNumbersFluxWithException()
//                        .subscribe(System.out::println,
//                                err-> System.out.println(err.getMessage()));

//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(e-> System.out.println("Error "+e.getMessage()))
//                .subscribe(System.out::println);

//Continuar con Error
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorContinue((e,item)-> System.out.println("Error en "+item+" "+e.getMessage()))
//                .subscribe(System.out::println);

 //Continuar con otro flujo cuando hay error
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorResume(err -> Flux.just(-1,-2).delayElements(Duration.ofSeconds(1)))
//                .subscribe(System.out::println);
//doFinally
        ReactiveSources.intNumbersFluxWithException()
                        .doFinally(signalType -> {
                            if(signalType== SignalType.ON_COMPLETE){
                                System.out.println("Terminó correctamente");
                            }else if(signalType == SignalType.ON_ERROR){
                                System.out.println("Terminó con Error");
                            }
                        })
                .subscribe(System.out::println);


        System.out.println("Presiona Enter");
        System.in.read();
    }
}
