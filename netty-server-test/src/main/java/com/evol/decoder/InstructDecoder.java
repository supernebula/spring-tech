package com.evol.decoder;

import com.evol.domain.pojo.TDVDto;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 指令解码
 */
public class InstructDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
//        int length = byteBuf.readInt();
//        String str = byteBuf.readCharSequence(length, StandardCharsets.UTF_8).toString();
        String str = byteBuf.toString(StandardCharsets.UTF_8);
        byteBuf.skipBytes(byteBuf.readableBytes());
        list.add(new TDVDto(str));

    }
}
