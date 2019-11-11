package com.study.netty.protobufdemo.client;

import com.study.netty.protobufdemo.MyDataInfo;
import com.study.netty.protobufdemo.MyDataInfo1;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class MyClientHandler1 extends SimpleChannelInboundHandler<MyDataInfo1.MyMessage> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randomInt = new Random().nextInt(3);
        MyDataInfo1.MyMessage myMessage = null;
        if (randomInt == 0) {
            myMessage = MyDataInfo1.MyMessage.newBuilder().
                    setDataType(MyDataInfo1.MyMessage.DataType.PersonType).
                    setPerson(MyDataInfo1.Person.newBuilder().
                            setName("Bob").setAge(22).
                            setAddress("Peking").build()).
                    build();

        } else if (randomInt == 1) {
            myMessage = MyDataInfo1.MyMessage.newBuilder().
                    setDataType(MyDataInfo1.MyMessage.DataType.DogType).
                    setDog(MyDataInfo1.Dog.newBuilder().
                            setName("A Dog").setAge(22).
                            build()).
                    build();
        } else {
            myMessage = MyDataInfo1.MyMessage.newBuilder().
                    setDataType(MyDataInfo1.MyMessage.DataType.CatType).
                    setCat(MyDataInfo1.Cat.newBuilder().
                            setName("A Cat").setCity("Peking").
                            build()).
                    build();
        }
        ctx.channel().writeAndFlush(myMessage);
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo1.MyMessage msg) throws Exception {

    }
}
