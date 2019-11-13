package com.study.nio;

import java.nio.ByteBuffer;

// 只读 Buffer
public class NioTest7 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);

        System.out.println(byteBuffer.getClass());
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }

        ByteBuffer readonlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println(readonlyBuffer.getClass());

        readonlyBuffer.position(0);
        readonlyBuffer.put((byte) 2);
    }
}
