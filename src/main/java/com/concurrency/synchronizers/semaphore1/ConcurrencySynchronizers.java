/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.concurrency.synchronizers.semaphore1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author ZAhmad
 */
public class ConcurrencySynchronizers {
    // This program explains how semaphore control access to shared data, only one thread at a time will access Shared.count.
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Semaphore semaphore = new Semaphore(1);
        new Thread(new IncThread(semaphore, "Thread1")).start();
        new Thread(new DecThread(semaphore, "Thread2")).start();
    }
}
