package com.study.nio;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.security.SecureRandom;

public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        for (int i = 0; i < 5; i++) {
            int randomNumber = new SecureRandom().nextInt(20);
            buffer.put(randomNumber);
        }

        System.out.println("Before flip limit: " + buffer.limit());//10

        buffer.flip();

        System.out.println("After flip limit: " + buffer.limit());//5

        System.out.println("Enter while loop");
        while (buffer.hasRemaining()) {
            System.out.println("Position: " + buffer.position());//0-4
            System.out.println("Limit: " + buffer.limit());//5
            System.out.println("Capacity: " + buffer.capacity());//10
            System.out.println(buffer.get());
        }
    }
}
