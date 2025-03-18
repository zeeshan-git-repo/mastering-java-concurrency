/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.concurrency.synchronizers.semaphore1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZAhmad
 */
public class IncThread implements Runnable {

    private static final Logger logger = Logger.getLogger(IncThread.class.getName());
    String incThread;
    Semaphore incSemaphore;

    public IncThread(Semaphore incSemaphore, String incThread) {
        this.incThread = incThread;
        this.incSemaphore = incSemaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println(incThread + " is waiting for permission");
            incSemaphore.acquire();
            System.out.println(incThread + " got permission");
            for (int idx = 0; idx < 5; idx++) {   
                Shared.count++;
                System.out.println(incThread + ": " + Shared.count);                
                Thread.sleep(2000);
            }
            incSemaphore.release();
        } catch (InterruptedException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
    }

}
