package com.accenture.excercise;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

public class MySubscriber<T> extends BaseSubscriber<T> {
    public void hookOnSubscribe(Subscription subscription){
        System.out.println("Estoy subscrito");
        request(2);
    }

    public void hookOnNext(T value){
        System.out.println(value.toString() + " procesado");
        request(1);
    }

    public void hookOnComplete(){
        System.out.println("Termino!");
    }
}
