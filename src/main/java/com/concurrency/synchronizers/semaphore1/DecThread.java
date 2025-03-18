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
public class DecThread implements Runnable {

    private static final Logger logger = Logger.getLogger(DecThread.class.getName());
    String decThread;
    Semaphore decSemaphore;

    public DecThread(Semaphore decSemaphore, String decThread) {
        this.decThread = decThread;
        this.decSemaphore = decSemaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println(decThread + " is waiting for permission");
            decSemaphore.acquire();
            System.out.println(decThread + " got permission");
            for (int idx = 0; idx < 5; idx++) {
                System.out.println(decThread + ": " + Shared.count);                
                Shared.count--;
                Thread.sleep(2000);
            }
            decSemaphore.release();
        } catch (InterruptedException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }
    }

}
