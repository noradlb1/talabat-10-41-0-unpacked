package com.uxcam.internals;

import java.io.Closeable;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public interface gb extends ByteChannel, Channel, Closeable, ReadableByteChannel, WritableByteChannel {
}
