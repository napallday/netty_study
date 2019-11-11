package com.study.netty.protobufdemo.server;

import com.study.netty.protobufdemo.MyDataInfo1;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyServerHandler1 extends SimpleChannelInboundHandler<MyDataInfo1.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo1.MyMessage msg) throws Exception {
        MyDataInfo1.MyMessage.DataType dataType = msg.getDataType();
        if (dataType == MyDataInfo1.MyMessage.DataType.PersonType) {
            MyDataInfo1.Person person = msg.getPerson();
            System.out.println(person);
        } else if(dataType == MyDataInfo1.MyMessage.DataType.DogType){
            MyDataInfo1.Dog dog = msg.getDog();
            System.out.println(dog);
        } else {
            MyDataInfo1.Cat cat = msg.getCat();
            System.out.println(cat);
        }


    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("##################################################");
        System.out.println("##################################################");
        System.out.println("##################################################");
        cause.printStackTrace();
        ctx.close();
    }
}
