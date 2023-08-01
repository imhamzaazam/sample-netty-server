import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerAdapter
import io.netty.channel.ChannelHandlerContext
import io.netty.util.ReferenceCountUtil


class DiscardServerHandler: ChannelHandlerAdapter() {

    override fun channelRead(ctx: ChannelHandlerContext?, msg: Any) { // (2)
        val inBf: ByteBuf = msg as ByteBuf
        val str: String = inBf.toString()
        try {
            while(inBf.isReadable) {
                print(inBf.readByte().toInt().toChar())
                System.out.flush()
            }
        } finally {
            ReferenceCountUtil.release(msg)
        }
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace()
        ctx.close()
    }

}