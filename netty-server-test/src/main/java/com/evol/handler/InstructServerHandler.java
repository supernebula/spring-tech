package com.evol.handler;

import com.evol.domain.pojo.TDVDto;
import com.evol.util.ExcelUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 指令处理器
 * @author admin
 */
public class InstructServerHandler extends ChannelInboundHandlerAdapter { // (1)

    private static Logger logger = Logger.getLogger(InstructServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        TDVDto dto = (TDVDto) msg;
        System.out.println(dto);

        Map<String, String> deviceInfoMap = ExcelUtil.getTieTaDeviceInfo();
        String deviceNo = deviceInfoMap.get(dto.getImei());

        String downInstruct = "TDV#" + (deviceNo == null ? "none": deviceNo);

        ctx.writeAndFlush(Unpooled.copiedBuffer(downInstruct, StandardCharsets.UTF_8));
        logger.debug("设备请求：" + StringUtils.trim(dto.getInstructStr()) + "，服务返回：" + downInstruct);
        //ctx.close();

//        ctx.write(msg); // (1)
//        ctx.flush(); // (2)

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
