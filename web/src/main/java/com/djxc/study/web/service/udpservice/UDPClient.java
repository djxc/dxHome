package com.djxc.study.web.service.udpservice;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetSocketAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .handler(new UdpClientHandler());
        Channel ch = b.bind(7777).sync().channel();
        String test = "我是client";
        byte[] bytes = test.getBytes();
        ByteBuf byteBuf = Unpooled.copiedBuffer(bytes);
        ch.writeAndFlush(new DatagramPacket(byteBuf,
                new InetSocketAddress("127.0.0.1", 8888))).sync();
        // 客户端等待10s用于接收服务端的应答消息，然后退出并释放资源
        ch.closeFuture().await(10000);

    }

    private static class UdpClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {
        public void channelRead(ChannelHandlerContext ctx, DatagramPacket msg) {
            ByteBuf byteBuf = msg.content();
            byte[] bytes = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(bytes);
            System.out.println("receive server msg:" + new String(bytes));
        }

        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {

        }
    }
}
