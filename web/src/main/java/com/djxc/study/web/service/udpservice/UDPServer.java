package com.djxc.study.web.service.udpservice;


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootStrap = new Bootstrap();
        bootStrap.group(group)
                .channel(NioDatagramChannel.class) // 指定传输数据包，可支持UDP
                .option(ChannelOption.SO_BROADCAST, true) // 广播模式
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT) // 线程池复用缓冲区
                .handler(new UDPServerHandler());
        Channel channel = bootStrap.bind(8888).sync().channel();
        // 这里阻塞
        channel.closeFuture().await();
    }

    static class UDPServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

        public void channelRead(ChannelHandlerContext ctx, DatagramPacket packet) {
            // 读取数据
            ByteBuf byteBuf = packet.content();
            byte[] bytes = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(bytes);
            System.out.println("receive client msg:" + new String(bytes));
            String test = "我是server";
            byte[] resBytes = test.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(Unpooled.copiedBuffer(resBytes), packet.sender());
            ctx.writeAndFlush(sendPacket);
        }

        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {

        }
    }
}
