import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelHandlerAdapter
import io.netty.channel.ChannelHandlerContext

class EchoServerHandler: ChannelHandlerAdapter() {

    override fun channelRead(ctx: ChannelHandlerContext, msg: Any) { // (2)
        val inBf: ByteBuf = msg as ByteBuf
        val str: String = inBf.toString(io.netty.util.CharsetUtil.US_ASCII) + "hamza"
        ctx.write(Unpooled.wrappedBuffer(str.toByteArray())); // (1)
        ctx.flush(); // (2)
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace()
        ctx.close()
    }
}