package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PersistableBundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.common.base.Supplier;
import java.nio.ByteBuffer;
import v7.b;
import v7.c;

@RequiresApi(23)
final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter {
    private static final int STATE_CREATED = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final int STATE_SHUT_DOWN = 2;
    private final AsynchronousMediaCodecCallback asynchronousMediaCodecCallback;
    private final AsynchronousMediaCodecBufferEnqueuer bufferEnqueuer;
    private final MediaCodec codec;
    private boolean codecReleased;
    private int state;
    private final boolean synchronizeCodecInteractionsWithQueueing;

    public static final class Factory implements MediaCodecAdapter.Factory {
        private final Supplier<HandlerThread> callbackThreadSupplier;
        private final Supplier<HandlerThread> queueingThreadSupplier;
        private final boolean synchronizeCodecInteractionsWithQueueing;

        public Factory(int i11, boolean z11) {
            this(new b(i11), new c(i11), z11);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ HandlerThread lambda$new$0(int i11) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.createCallbackThreadLabel(i11));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ HandlerThread lambda$new$1(int i11) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.createQueueingThreadLabel(i11));
        }

        @VisibleForTesting
        public Factory(Supplier<HandlerThread> supplier, Supplier<HandlerThread> supplier2, boolean z11) {
            this.callbackThreadSupplier = supplier;
            this.queueingThreadSupplier = supplier2;
            this.synchronizeCodecInteractionsWithQueueing = z11;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter createAdapter(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.Configuration r10) throws java.io.IOException {
            /*
                r9 = this;
                com.google.android.exoplayer2.mediacodec.MediaCodecInfo r0 = r10.codecInfo
                java.lang.String r0 = r0.f34956name
                r1 = 0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004d }
                r2.<init>()     // Catch:{ Exception -> 0x004d }
                java.lang.String r3 = "createCodec:"
                r2.append(r3)     // Catch:{ Exception -> 0x004d }
                r2.append(r0)     // Catch:{ Exception -> 0x004d }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x004d }
                com.google.android.exoplayer2.util.TraceUtil.beginSection(r2)     // Catch:{ Exception -> 0x004d }
                android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x004d }
                com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter r2 = new com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter     // Catch:{ Exception -> 0x004b }
                com.google.common.base.Supplier<android.os.HandlerThread> r3 = r9.callbackThreadSupplier     // Catch:{ Exception -> 0x004b }
                java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x004b }
                r5 = r3
                android.os.HandlerThread r5 = (android.os.HandlerThread) r5     // Catch:{ Exception -> 0x004b }
                com.google.common.base.Supplier<android.os.HandlerThread> r3 = r9.queueingThreadSupplier     // Catch:{ Exception -> 0x004b }
                java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x004b }
                r6 = r3
                android.os.HandlerThread r6 = (android.os.HandlerThread) r6     // Catch:{ Exception -> 0x004b }
                boolean r7 = r9.synchronizeCodecInteractionsWithQueueing     // Catch:{ Exception -> 0x004b }
                r8 = 0
                r3 = r2
                r4 = r0
                r3.<init>(r4, r5, r6, r7)     // Catch:{ Exception -> 0x004b }
                com.google.android.exoplayer2.util.TraceUtil.endSection()     // Catch:{ Exception -> 0x0048 }
                android.media.MediaFormat r1 = r10.mediaFormat     // Catch:{ Exception -> 0x0048 }
                android.view.Surface r3 = r10.surface     // Catch:{ Exception -> 0x0048 }
                android.media.MediaCrypto r4 = r10.crypto     // Catch:{ Exception -> 0x0048 }
                int r10 = r10.flags     // Catch:{ Exception -> 0x0048 }
                r2.initialize(r1, r3, r4, r10)     // Catch:{ Exception -> 0x0048 }
                return r2
            L_0x0048:
                r10 = move-exception
                r1 = r2
                goto L_0x004f
            L_0x004b:
                r10 = move-exception
                goto L_0x004f
            L_0x004d:
                r10 = move-exception
                r0 = r1
            L_0x004f:
                if (r1 != 0) goto L_0x0057
                if (r0 == 0) goto L_0x005a
                r0.release()
                goto L_0x005a
            L_0x0057:
                r1.release()
            L_0x005a:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter.Factory.createAdapter(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Configuration):com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter");
        }
    }

    /* access modifiers changed from: private */
    public static String createCallbackThreadLabel(int i11) {
        return createThreadLabel(i11, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* access modifiers changed from: private */
    public static String createQueueingThreadLabel(int i11) {
        return createThreadLabel(i11, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String createThreadLabel(int i11, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (i11 == 1) {
            sb2.append("Audio");
        } else if (i11 == 2) {
            sb2.append("Video");
        } else {
            sb2.append("Unknown(");
            sb2.append(i11);
            sb2.append(")");
        }
        return sb2.toString();
    }

    /* access modifiers changed from: private */
    public void initialize(@Nullable MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i11) {
        this.asynchronousMediaCodecCallback.initialize(this.codec);
        TraceUtil.beginSection("configureCodec");
        this.codec.configure(mediaFormat, surface, mediaCrypto, i11);
        TraceUtil.endSection();
        this.bufferEnqueuer.start();
        TraceUtil.beginSection("startCodec");
        this.codec.start();
        TraceUtil.endSection();
        this.state = 1;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnFrameRenderedListener$0(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j11, long j12) {
        onFrameRenderedListener.onFrameRendered(this, j11, j12);
    }

    private void maybeBlockOnQueueing() {
        if (this.synchronizeCodecInteractionsWithQueueing) {
            try {
                this.bufferEnqueuer.waitUntilQueueingComplete();
            } catch (InterruptedException e11) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e11);
            }
        }
    }

    public int dequeueInputBufferIndex() {
        this.bufferEnqueuer.maybeThrowException();
        return this.asynchronousMediaCodecCallback.dequeueInputBufferIndex();
    }

    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        this.bufferEnqueuer.maybeThrowException();
        return this.asynchronousMediaCodecCallback.dequeueOutputBufferIndex(bufferInfo);
    }

    public void flush() {
        this.bufferEnqueuer.flush();
        this.codec.flush();
        this.asynchronousMediaCodecCallback.flush();
        this.codec.start();
    }

    @Nullable
    public ByteBuffer getInputBuffer(int i11) {
        return this.codec.getInputBuffer(i11);
    }

    @RequiresApi(26)
    public PersistableBundle getMetrics() {
        maybeBlockOnQueueing();
        return this.codec.getMetrics();
    }

    @Nullable
    public ByteBuffer getOutputBuffer(int i11) {
        return this.codec.getOutputBuffer(i11);
    }

    public MediaFormat getOutputFormat() {
        return this.asynchronousMediaCodecCallback.getOutputFormat();
    }

    public boolean needsReconfiguration() {
        return false;
    }

    @VisibleForTesting
    public void onError(MediaCodec.CodecException codecException) {
        this.asynchronousMediaCodecCallback.onError(this.codec, codecException);
    }

    @VisibleForTesting
    public void onOutputFormatChanged(MediaFormat mediaFormat) {
        this.asynchronousMediaCodecCallback.onOutputFormatChanged(this.codec, mediaFormat);
    }

    public void queueInputBuffer(int i11, int i12, int i13, long j11, int i14) {
        this.bufferEnqueuer.queueInputBuffer(i11, i12, i13, j11, i14);
    }

    public void queueSecureInputBuffer(int i11, int i12, CryptoInfo cryptoInfo, long j11, int i13) {
        this.bufferEnqueuer.queueSecureInputBuffer(i11, i12, cryptoInfo, j11, i13);
    }

    public void release() {
        try {
            if (this.state == 1) {
                this.bufferEnqueuer.shutdown();
                this.asynchronousMediaCodecCallback.shutdown();
            }
            this.state = 2;
        } finally {
            if (!this.codecReleased) {
                this.codec.release();
                this.codecReleased = true;
            }
        }
    }

    public void releaseOutputBuffer(int i11, boolean z11) {
        this.codec.releaseOutputBuffer(i11, z11);
    }

    public void setOnFrameRenderedListener(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        maybeBlockOnQueueing();
        this.codec.setOnFrameRenderedListener(new a(this, onFrameRenderedListener), handler);
    }

    public void setOutputSurface(Surface surface) {
        maybeBlockOnQueueing();
        this.codec.setOutputSurface(surface);
    }

    public void setParameters(Bundle bundle) {
        maybeBlockOnQueueing();
        this.codec.setParameters(bundle);
    }

    public void setVideoScalingMode(int i11) {
        maybeBlockOnQueueing();
        this.codec.setVideoScalingMode(i11);
    }

    private AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z11) {
        this.codec = mediaCodec;
        this.asynchronousMediaCodecCallback = new AsynchronousMediaCodecCallback(handlerThread);
        this.bufferEnqueuer = new AsynchronousMediaCodecBufferEnqueuer(mediaCodec, handlerThread2);
        this.synchronizeCodecInteractionsWithQueueing = z11;
        this.state = 0;
    }

    public void releaseOutputBuffer(int i11, long j11) {
        this.codec.releaseOutputBuffer(i11, j11);
    }
}
