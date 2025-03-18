/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.concurrency.synchronizers.semaphore2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZAhmad
 */
public class CustomSemaphore {

    int num;
    Semaphore semCon = new Semaphore(0);
    Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(CustomSemaphore.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Got: " + num);
        semProd.release();
        System.out.println("semProd released");
    }

    void put(int num) {
        try {
            semProd.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(CustomSemaphore.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.num = num;
        System.out.println("Put: " + num);
        semCon.release();
        System.out.println("semCon released");
    }

}
