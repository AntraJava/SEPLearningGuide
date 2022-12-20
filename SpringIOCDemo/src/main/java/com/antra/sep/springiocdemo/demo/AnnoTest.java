package com.antra.sep.springiocdemo.demo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AnnoTest {

    @Timer
    public void doSomething() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sleep over");
    }

    @Timer
    public void doSomething2(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
