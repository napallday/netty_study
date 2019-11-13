package com.study.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
// 文件操作
public class NioTest4 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputchannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(3);
        while (true) {
//            byteBuffer.clear();
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
