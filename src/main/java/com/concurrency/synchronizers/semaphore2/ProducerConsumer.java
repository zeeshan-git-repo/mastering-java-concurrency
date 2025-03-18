/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.concurrency.synchronizers.semaphore2;

/**
 *
 * @author ZAhmad
 */
public class ProducerConsumer {
    // This program explains how semaphore is executed on priority basis, get method will give priority to put.

    public static void main(String[] args) {
        CustomSemaphore p = new CustomSemaphore();        
        new Thread(new Consumer(p), "Consumer").start();
        new Thread(new Producer(p), "Producer").start();
    }

}
