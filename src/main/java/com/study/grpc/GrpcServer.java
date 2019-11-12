package com.study.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GrpcServer {
    private Server server;
    private void start() throws IOException {
        this.server = ServerBuilder.forPort(8899).addService(new StudentServiceImpl()).build().start();
        System.out.println("Server Started!");

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("JVM 关闭");
            GrpcServer.this.stop();
        }));

        System.out.println("执行到这里");

    }

    private void stop(){
        if (null != this.server) {
            this.server.shutdown();
        }
    }
    private void awaitTermination() throws InterruptedException {
        if (null != this.server) {
            this.server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer server = new GrpcServer();
        server.start();
        server.awaitTermination();
    }
}
