package com.evol;

import com.evol.config.ServerConfig;
import com.evol.decoder.InstructDecoder;
import com.evol.handler.InstructServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 铁塔设备转移服务器
 */
public class TransNettyServer {

    private int port;

    public TransNettyServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap(); // (2)
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // (3)
                    .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            //ch.pipeline().addLast(new InstructServerHandler());
                            ch.pipeline().addLast(new InstructDecoder(), new InstructServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

            // Bind and start to accept incoming connections.
            ChannelFuture f = b.bind(port).sync(); // (7)

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {

        System.out.print("start TransNettyServer main");
        ServerConfig serverConfig = new ServerConfig();
        // 9090;
        try {
            int port = serverConfig.getNettyPort();
            if (args.length > 0) {
                port = Integer.parseInt(args[0]);
            }

            new TransNettyServer(port).run();
        }catch (Exception ex){
            System.out.print(ex);
        }


        System.out.print("started TransNettyServer main");

    }
}
