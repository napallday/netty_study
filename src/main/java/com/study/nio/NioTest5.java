package com.study.nio;

import java.nio.ByteBuffer;
// ByteBuffer的一些特殊函数
public class NioTest5 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);
        buffer.putInt(123);
        buffer.putLong(3131L);
        buffer.putChar('你');
        buffer.putShort((short)123);

        buffer.flip();
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
    }
}
