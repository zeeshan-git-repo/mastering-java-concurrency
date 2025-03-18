/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.concurrency.synchronizers.semaphore2;

/**
 *
 * @author ZAhmad
 */
public class Producer implements Runnable {

    CustomSemaphore p;

    Producer(CustomSemaphore p) {
        this.p = p;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            p.put(i);
        }
    }
    
}
