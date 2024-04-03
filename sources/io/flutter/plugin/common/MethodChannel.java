package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;

public class MethodChannel {
    private static final String TAG = "MethodChannel#";
    /* access modifiers changed from: private */
    public final MethodCodec codec;
    private final BinaryMessenger messenger;
    /* access modifiers changed from: private */

    /* renamed from: name  reason: collision with root package name */
    public final String f14237name;
    private final BinaryMessenger.TaskQueue taskQueue;

    public final class IncomingMethodCallHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MethodCallHandler handler;

        public IncomingMethodCallHandler(MethodCallHandler methodCallHandler) {
            this.handler = methodCallHandler;
        }

        @UiThread
        public void onMessage(ByteBuffer byteBuffer, final BinaryMessenger.BinaryReply binaryReply) {
            try {
                this.handler.onMethodCall(MethodChannel.this.codec.decodeMethodCall(byteBuffer), new Result() {
                    public void error(String str, String str2, Object obj) {
                        binaryReply.reply(MethodChannel.this.codec.encodeErrorEnvelope(str, str2, obj));
                    }

                    public void notImplemented() {
                        binaryReply.reply((ByteBuffer) null);
                    }

                    public void success(Object obj) {
                        binaryReply.reply(MethodChannel.this.codec.encodeSuccessEnvelope(obj));
                    }
                });
            } catch (RuntimeException e11) {
                Log.e(MethodChannel.TAG + MethodChannel.this.f14237name, "Failed to handle method call", e11);
                binaryReply.reply(MethodChannel.this.codec.encodeErrorEnvelopeWithStacktrace("error", e11.getMessage(), (Object) null, Log.getStackTraceString(e11)));
            }
        }
    }

    public final class IncomingResultHandler implements BinaryMessenger.BinaryReply {
        private final Result callback;

        public IncomingResultHandler(Result result) {
            this.callback = result;
        }

        @UiThread
        public void reply(ByteBuffer byteBuffer) {
            if (byteBuffer == null) {
                try {
                    this.callback.notImplemented();
                } catch (RuntimeException e11) {
                    Log.e(MethodChannel.TAG + MethodChannel.this.f14237name, "Failed to handle method call result", e11);
                }
            } else {
                try {
                    this.callback.success(MethodChannel.this.codec.decodeEnvelope(byteBuffer));
                } catch (FlutterException e12) {
                    this.callback.error(e12.code, e12.getMessage(), e12.details);
                }
            }
        }
    }

    public interface MethodCallHandler {
        @UiThread
        void onMethodCall(@NonNull MethodCall methodCall, @NonNull Result result);
    }

    public interface Result {
        void error(@NonNull String str, @Nullable String str2, @Nullable Object obj);

        void notImplemented();

        void success(@Nullable Object obj);
    }

    public MethodChannel(@NonNull BinaryMessenger binaryMessenger, @NonNull String str) {
        this(binaryMessenger, str, StandardMethodCodec.INSTANCE);
    }

    @UiThread
    public void invokeMethod(@NonNull String str, @Nullable Object obj) {
        invokeMethod(str, obj, (Result) null);
    }

    public void resizeChannelBuffer(int i11) {
        BasicMessageChannel.c(this.messenger, this.f14237name, i11);
    }

    @UiThread
    public void setMethodCallHandler(@Nullable MethodCallHandler methodCallHandler) {
        IncomingMethodCallHandler incomingMethodCallHandler = null;
        if (this.taskQueue != null) {
            BinaryMessenger binaryMessenger = this.messenger;
            String str = this.f14237name;
            if (methodCallHandler != null) {
                incomingMethodCallHandler = new IncomingMethodCallHandler(methodCallHandler);
            }
            binaryMessenger.setMessageHandler(str, incomingMethodCallHandler, this.taskQueue);
            return;
        }
        BinaryMessenger binaryMessenger2 = this.messenger;
        String str2 = this.f14237name;
        if (methodCallHandler != null) {
            incomingMethodCallHandler = new IncomingMethodCallHandler(methodCallHandler);
        }
        binaryMessenger2.setMessageHandler(str2, incomingMethodCallHandler);
    }

    public MethodChannel(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, @NonNull MethodCodec methodCodec) {
        this(binaryMessenger, str, methodCodec, (BinaryMessenger.TaskQueue) null);
    }

    @UiThread
    public void invokeMethod(@NonNull String str, @Nullable Object obj, @Nullable Result result) {
        IncomingResultHandler incomingResultHandler;
        BinaryMessenger binaryMessenger = this.messenger;
        String str2 = this.f14237name;
        ByteBuffer encodeMethodCall = this.codec.encodeMethodCall(new MethodCall(str, obj));
        if (result == null) {
            incomingResultHandler = null;
        } else {
            incomingResultHandler = new IncomingResultHandler(result);
        }
        binaryMessenger.send(str2, encodeMethodCall, incomingResultHandler);
    }

    public MethodChannel(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, @NonNull MethodCodec methodCodec, @Nullable BinaryMessenger.TaskQueue taskQueue2) {
        this.messenger = binaryMessenger;
        this.f14237name = str;
        this.codec = methodCodec;
        this.taskQueue = taskQueue2;
    }
}
