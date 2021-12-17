package com.company;
import java.io.*;

class Thread3 implements Runnable{
    Thread thread;
    //tworzymy nowy wątek
    Thread3(String name){
        thread = new Thread(this, name); //wątek otrzymuje nazwe
    }
    //metoda, która tworzy i uruchamia wątek
    public static Thread3 createAndStart(String name){
        Thread3 Thread3 = new Thread3(name);
        Thread3.thread.start();
        return Thread3;
    }
    //ropoczyna wykonywanie nowego wątku
    public void run(){
        System.out.println(thread.getName() + "rozpoczyna działanie...");
        try{
            for(int count = 0; count < 10; count++){
                Thread.sleep(400);
                System.out.println(thread.getName() + "jest wykonywany, wartość licznika: " + count);
            }
        }catch (InterruptedException e){
            System.out.println(thread.getName() + "został przerwany...");
        }
        System.out.println(thread.getName() + "kończy działanie...");
    }
}


public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Główny wątek rozpoczyna działanie.");
        //wątek zostaje uruchomiony w trackie tworzenia
        Thread3 myThread1 = Thread3.createAndStart("Wątek potomny numer 1 ");
            try{
                myThread1.thread.join();
            }catch (InterruptedException e){
                System.out.println("Wątek główny został przerwany...");
            }
        Thread3 myThread2 = Thread3.createAndStart("Wątek potomny numer 2 ");
            try{
                myThread2.thread.join();
            }catch (InterruptedException e){
                System.out.println("Wątek główny został przerwany...");
            }
        Thread3 myThread3 = Thread3.createAndStart("Wątek potomny numer 3 ");
            try{
                myThread3.thread.join();
            }catch (InterruptedException e){
                System.out.println("Wątek główny został przerwany...");
            }
        System.out.println("\nWątek główny kończy działanie...");
    }
}
