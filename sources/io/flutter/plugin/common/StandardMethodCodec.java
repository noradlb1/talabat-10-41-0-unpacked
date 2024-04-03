package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.plugin.common.StandardMessageCodec;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class StandardMethodCodec implements MethodCodec {
    public static final StandardMethodCodec INSTANCE = new StandardMethodCodec(StandardMessageCodec.INSTANCE);
    private final StandardMessageCodec messageCodec;

    public StandardMethodCodec(@NonNull StandardMessageCodec standardMessageCodec) {
        this.messageCodec = standardMessageCodec;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r0 == 1) goto L_0x001e;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decodeEnvelope(@androidx.annotation.NonNull java.nio.ByteBuffer r5) {
        /*
            r4 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            r5.order(r0)
            byte r0 = r5.get()
            if (r0 == 0) goto L_0x0011
            r1 = 1
            if (r0 != r1) goto L_0x004a
            goto L_0x001e
        L_0x0011:
            io.flutter.plugin.common.StandardMessageCodec r0 = r4.messageCodec
            java.lang.Object r0 = r0.d(r5)
            boolean r1 = r5.hasRemaining()
            if (r1 != 0) goto L_0x001e
            return r0
        L_0x001e:
            io.flutter.plugin.common.StandardMessageCodec r0 = r4.messageCodec
            java.lang.Object r0 = r0.d(r5)
            io.flutter.plugin.common.StandardMessageCodec r1 = r4.messageCodec
            java.lang.Object r1 = r1.d(r5)
            io.flutter.plugin.common.StandardMessageCodec r2 = r4.messageCodec
            java.lang.Object r2 = r2.d(r5)
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L_0x004a
            if (r1 == 0) goto L_0x003a
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L_0x004a
        L_0x003a:
            boolean r5 = r5.hasRemaining()
            if (r5 != 0) goto L_0x004a
            io.flutter.plugin.common.FlutterException r5 = new io.flutter.plugin.common.FlutterException
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = (java.lang.String) r1
            r5.<init>(r0, r1, r2)
            throw r5
        L_0x004a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Envelope corrupted"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.common.StandardMethodCodec.decodeEnvelope(java.nio.ByteBuffer):java.lang.Object");
    }

    @NonNull
    public MethodCall decodeMethodCall(@NonNull ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        Object d11 = this.messageCodec.d(byteBuffer);
        Object d12 = this.messageCodec.d(byteBuffer);
        if ((d11 instanceof String) && !byteBuffer.hasRemaining()) {
            return new MethodCall((String) d11, d12);
        }
        throw new IllegalArgumentException("Method call corrupted");
    }

    @NonNull
    public ByteBuffer encodeErrorEnvelope(@NonNull String str, @NonNull String str2, @NonNull Object obj) {
        StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        exposedByteArrayOutputStream.write(1);
        this.messageCodec.n(exposedByteArrayOutputStream, str);
        this.messageCodec.n(exposedByteArrayOutputStream, str2);
        if (obj instanceof Throwable) {
            this.messageCodec.n(exposedByteArrayOutputStream, Log.getStackTraceString((Throwable) obj));
        } else {
            this.messageCodec.n(exposedByteArrayOutputStream, obj);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        allocateDirect.put(exposedByteArrayOutputStream.a(), 0, exposedByteArrayOutputStream.size());
        return allocateDirect;
    }

    @NonNull
    public ByteBuffer encodeErrorEnvelopeWithStacktrace(@NonNull String str, @NonNull String str2, @NonNull Object obj, @NonNull String str3) {
        StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        exposedByteArrayOutputStream.write(1);
        this.messageCodec.n(exposedByteArrayOutputStream, str);
        this.messageCodec.n(exposedByteArrayOutputStream, str2);
        if (obj instanceof Throwable) {
            this.messageCodec.n(exposedByteArrayOutputStream, Log.getStackTraceString((Throwable) obj));
        } else {
            this.messageCodec.n(exposedByteArrayOutputStream, obj);
        }
        this.messageCodec.n(exposedByteArrayOutputStream, str3);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        allocateDirect.put(exposedByteArrayOutputStream.a(), 0, exposedByteArrayOutputStream.size());
        return allocateDirect;
    }

    @NonNull
    public ByteBuffer encodeMethodCall(@NonNull MethodCall methodCall) {
        StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        this.messageCodec.n(exposedByteArrayOutputStream, methodCall.method);
        this.messageCodec.n(exposedByteArrayOutputStream, methodCall.arguments);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        allocateDirect.put(exposedByteArrayOutputStream.a(), 0, exposedByteArrayOutputStream.size());
        return allocateDirect;
    }

    @NonNull
    public ByteBuffer encodeSuccessEnvelope(@NonNull Object obj) {
        StandardMessageCodec.ExposedByteArrayOutputStream exposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
        exposedByteArrayOutputStream.write(0);
        this.messageCodec.n(exposedByteArrayOutputStream, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        allocateDirect.put(exposedByteArrayOutputStream.a(), 0, exposedByteArrayOutputStream.size());
        return allocateDirect;
    }
}
