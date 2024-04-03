package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;

public final class BasicMessageChannel<T> {
    public static final String CHANNEL_BUFFERS_CHANNEL = "dev.flutter/channel-buffers";
    private static final String TAG = "BasicMessageChannel#";
    /* access modifiers changed from: private */
    @NonNull
    public final MessageCodec<T> codec;
    @NonNull
    private final BinaryMessenger messenger;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: name  reason: collision with root package name */
    public final String f14228name;
    @Nullable
    private final BinaryMessenger.TaskQueue taskQueue;

    public final class IncomingMessageHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MessageHandler<T> handler;

        public void onMessage(@Nullable ByteBuffer byteBuffer, @NonNull final BinaryMessenger.BinaryReply binaryReply) {
            try {
                this.handler.onMessage(BasicMessageChannel.this.codec.decodeMessage(byteBuffer), new Reply<T>() {
                    public void reply(T t11) {
                        binaryReply.reply(BasicMessageChannel.this.codec.encodeMessage(t11));
                    }
                });
            } catch (RuntimeException e11) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.f14228name, "Failed to handle message", e11);
                binaryReply.reply((ByteBuffer) null);
            }
        }

        private IncomingMessageHandler(@NonNull MessageHandler<T> messageHandler) {
            this.handler = messageHandler;
        }
    }

    public final class IncomingReplyHandler implements BinaryMessenger.BinaryReply {
        private final Reply<T> callback;

        public void reply(@Nullable ByteBuffer byteBuffer) {
            try {
                this.callback.reply(BasicMessageChannel.this.codec.decodeMessage(byteBuffer));
            } catch (RuntimeException e11) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.f14228name, "Failed to handle message reply", e11);
            }
        }

        private IncomingReplyHandler(@NonNull Reply<T> reply) {
            this.callback = reply;
        }
    }

    public interface MessageHandler<T> {
        void onMessage(@Nullable T t11, @NonNull Reply<T> reply);
    }

    public interface Reply<T> {
        void reply(@Nullable T t11);
    }

    public BasicMessageChannel(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, @NonNull MessageCodec<T> messageCodec) {
        this(binaryMessenger, str, messageCodec, (BinaryMessenger.TaskQueue) null);
    }

    public static void c(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, int i11) {
        binaryMessenger.send(CHANNEL_BUFFERS_CHANNEL, ByteBuffer.wrap(String.format(Locale.US, "resize\r%s\r%d", new Object[]{str, Integer.valueOf(i11)}).getBytes(Charset.forName("UTF-8"))));
    }

    public void resizeChannelBuffer(int i11) {
        c(this.messenger, this.f14228name, i11);
    }

    public void send(@Nullable T t11) {
        send(t11, (Reply) null);
    }

    @UiThread
    public void setMessageHandler(@Nullable MessageHandler<T> messageHandler) {
        IncomingMessageHandler incomingMessageHandler = null;
        if (this.taskQueue != null) {
            BinaryMessenger binaryMessenger = this.messenger;
            String str = this.f14228name;
            if (messageHandler != null) {
                incomingMessageHandler = new IncomingMessageHandler(messageHandler);
            }
            binaryMessenger.setMessageHandler(str, incomingMessageHandler, this.taskQueue);
            return;
        }
        BinaryMessenger binaryMessenger2 = this.messenger;
        String str2 = this.f14228name;
        if (messageHandler != null) {
            incomingMessageHandler = new IncomingMessageHandler(messageHandler);
        }
        binaryMessenger2.setMessageHandler(str2, incomingMessageHandler);
    }

    public BasicMessageChannel(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, @NonNull MessageCodec<T> messageCodec, BinaryMessenger.TaskQueue taskQueue2) {
        this.messenger = binaryMessenger;
        this.f14228name = str;
        this.codec = messageCodec;
        this.taskQueue = taskQueue2;
    }

    @UiThread
    public void send(@Nullable T t11, @Nullable Reply<T> reply) {
        BinaryMessenger binaryMessenger = this.messenger;
        String str = this.f14228name;
        ByteBuffer encodeMessage = this.codec.encodeMessage(t11);
        IncomingReplyHandler incomingReplyHandler = null;
        if (reply != null) {
            incomingReplyHandler = new IncomingReplyHandler(reply);
        }
        binaryMessenger.send(str, encodeMessage, incomingReplyHandler);
    }
}
