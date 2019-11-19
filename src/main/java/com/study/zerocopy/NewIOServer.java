package com.study.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIOServer {
    public static void main(String[] args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(8899);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();

        // 处理TIME_WAIT的状态时的端口复用
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true) {
            SocketChannel channel = serverSocketChannel.accept();

            channel.configureBlocking(true);

            int readCount = 0;
            while(-1 != readCount) {
                try{
                    readCount = channel.read(byteBuffer);
                    //重放操作
                    byteBuffer.rewind();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}