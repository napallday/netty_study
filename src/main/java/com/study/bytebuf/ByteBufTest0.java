package com.study.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ByteBufTest0 {
    public static void main(String[] args) {
        ByteBuf buffer = Unpooled.buffer(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.writeByte(i);
        }

        while (buffer.isReadable()) {
            System.out.println(buffer.readByte());
        }
    }
}
