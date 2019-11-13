package com.study.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
// Direct 内存
public class NioTest8 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("input2.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output2.txt");

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputchannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(512);
        while (true) {
            byteBuffer.clear();
            System.out.println(byteBuffer.position());
            System.out.println(byteBuffer.limit());

            int read = inputChannel.read(byteBuffer);
            System.out.println("read: " + read);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();

            outputchannel.write(byteBuffer);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
