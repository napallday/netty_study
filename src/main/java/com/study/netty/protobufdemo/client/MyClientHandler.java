package com.study.netty.protobufdemo.client;

import com.study.netty.protobufdemo.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.Person person = MyDataInfo.Person.newBuilder().
                setName("Bob").setAge(22).setAddress("Peking").build();
        ctx.channel().writeAndFlush(person);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Person msg) throws Exception {

    }
}
