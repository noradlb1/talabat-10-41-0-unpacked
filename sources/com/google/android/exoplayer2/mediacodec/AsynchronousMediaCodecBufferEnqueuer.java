package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.Util;
import i.b;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

@RequiresApi(23)
class AsynchronousMediaCodecBufferEnqueuer {
    @GuardedBy("MESSAGE_PARAMS_INSTANCE_POOL")
    private static final ArrayDeque<MessageParams> MESSAGE_PARAMS_INSTANCE_POOL = new ArrayDeque<>();
    private static final int MSG_OPEN_CV = 2;
    private static final int MSG_QUEUE_INPUT_BUFFER = 0;
    private static final int MSG_QUEUE_SECURE_INPUT_BUFFER = 1;
    private static final Object QUEUE_SECURE_LOCK = new Object();
    private final MediaCodec codec;
    private final ConditionVariable conditionVariable;
    private Handler handler;
    private final HandlerThread handlerThread;
    private final AtomicReference<RuntimeException> pendingRuntimeException;
    private boolean started;

    public static class MessageParams {
        public final MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        public int flags;
        public int index;
        public int offset;
        public long presentationTimeUs;
        public int size;

        public void setQueueParams(int i11, int i12, int i13, long j11, int i14) {
            this.index = i11;
            this.offset = i12;
            this.size = i13;
            this.presentationTimeUs = j11;
            this.flags = i14;
        }
    }

    public AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread2) {
        this(mediaCodec, handlerThread2, new ConditionVariable());
    }

    private void blockUntilHandlerThreadIsIdle() throws InterruptedException {
        this.conditionVariable.close();
        ((Handler) Assertions.checkNotNull(this.handler)).obtainMessage(2).sendToTarget();
        this.conditionVariable.block();
    }

    private static void copy(CryptoInfo cryptoInfo, MediaCodec.CryptoInfo cryptoInfo2) {
        cryptoInfo2.numSubSamples = cryptoInfo.numSubSamples;
        cryptoInfo2.numBytesOfClearData = copy(cryptoInfo.numBytesOfClearData, cryptoInfo2.numBytesOfClearData);
        cryptoInfo2.numBytesOfEncryptedData = copy(cryptoInfo.numBytesOfEncryptedData, cryptoInfo2.numBytesOfEncryptedData);
        cryptoInfo2.key = (byte[]) Assertions.checkNotNull(copy(cryptoInfo.key, cryptoInfo2.key));
        cryptoInfo2.iv = (byte[]) Assertions.checkNotNull(copy(cryptoInfo.f34923iv, cryptoInfo2.iv));
        cryptoInfo2.mode = cryptoInfo.mode;
        if (Util.SDK_INT >= 24) {
            cryptoInfo2.setPattern(new MediaCodec.CryptoInfo.Pattern(cryptoInfo.encryptedBlocks, cryptoInfo.clearBlocks));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doHandleMessage(android.os.Message r11) {
        /*
            r10 = this;
            int r0 = r11.what
            if (r0 == 0) goto L_0x0036
            r1 = 1
            if (r0 == r1) goto L_0x0022
            r1 = 2
            r2 = 0
            if (r0 == r1) goto L_0x001c
            java.util.concurrent.atomic.AtomicReference<java.lang.RuntimeException> r0 = r10.pendingRuntimeException
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            int r11 = r11.what
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r1.<init>(r11)
            i.b.a(r0, r2, r1)
            goto L_0x0049
        L_0x001c:
            com.google.android.exoplayer2.util.ConditionVariable r11 = r10.conditionVariable
            r11.open()
            goto L_0x0049
        L_0x0022:
            java.lang.Object r11 = r11.obj
            r2 = r11
            com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams r2 = (com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) r2
            int r4 = r2.index
            int r5 = r2.offset
            android.media.MediaCodec$CryptoInfo r6 = r2.cryptoInfo
            long r7 = r2.presentationTimeUs
            int r9 = r2.flags
            r3 = r10
            r3.doQueueSecureInputBuffer(r4, r5, r6, r7, r9)
            goto L_0x0049
        L_0x0036:
            java.lang.Object r11 = r11.obj
            r2 = r11
            com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer$MessageParams r2 = (com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.MessageParams) r2
            int r4 = r2.index
            int r5 = r2.offset
            int r6 = r2.size
            long r7 = r2.presentationTimeUs
            int r9 = r2.flags
            r3 = r10
            r3.doQueueInputBuffer(r4, r5, r6, r7, r9)
        L_0x0049:
            if (r2 == 0) goto L_0x004e
            recycleMessageParams(r2)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.doHandleMessage(android.os.Message):void");
    }

    private void doQueueInputBuffer(int i11, int i12, int i13, long j11, int i14) {
        try {
            this.codec.queueInputBuffer(i11, i12, i13, j11, i14);
        } catch (RuntimeException e11) {
            b.a(this.pendingRuntimeException, (Object) null, e11);
        }
    }

    private void doQueueSecureInputBuffer(int i11, int i12, MediaCodec.CryptoInfo cryptoInfo, long j11, int i13) {
        try {
            synchronized (QUEUE_SECURE_LOCK) {
                this.codec.queueSecureInputBuffer(i11, i12, cryptoInfo, j11, i13);
            }
        } catch (RuntimeException e11) {
            b.a(this.pendingRuntimeException, (Object) null, e11);
        }
    }

    private void flushHandlerThread() throws InterruptedException {
        ((Handler) Assertions.checkNotNull(this.handler)).removeCallbacksAndMessages((Object) null);
        blockUntilHandlerThreadIsIdle();
    }

    private static MessageParams getMessageParams() {
        ArrayDeque<MessageParams> arrayDeque = MESSAGE_PARAMS_INSTANCE_POOL;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                MessageParams messageParams = new MessageParams();
                return messageParams;
            }
            MessageParams removeFirst = arrayDeque.removeFirst();
            return removeFirst;
        }
    }

    private static void recycleMessageParams(MessageParams messageParams) {
        ArrayDeque<MessageParams> arrayDeque = MESSAGE_PARAMS_INSTANCE_POOL;
        synchronized (arrayDeque) {
            arrayDeque.add(messageParams);
        }
    }

    public void flush() {
        if (this.started) {
            try {
                flushHandlerThread();
            } catch (InterruptedException e11) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e11);
            }
        }
    }

    public void maybeThrowException() {
        RuntimeException andSet = this.pendingRuntimeException.getAndSet((Object) null);
        if (andSet != null) {
            throw andSet;
        }
    }

    public void queueInputBuffer(int i11, int i12, int i13, long j11, int i14) {
        maybeThrowException();
        MessageParams messageParams = getMessageParams();
        messageParams.setQueueParams(i11, i12, i13, j11, i14);
        ((Handler) Util.castNonNull(this.handler)).obtainMessage(0, messageParams).sendToTarget();
    }

    public void queueSecureInputBuffer(int i11, int i12, CryptoInfo cryptoInfo, long j11, int i13) {
        maybeThrowException();
        MessageParams messageParams = getMessageParams();
        messageParams.setQueueParams(i11, i12, 0, j11, i13);
        copy(cryptoInfo, messageParams.cryptoInfo);
        ((Handler) Util.castNonNull(this.handler)).obtainMessage(1, messageParams).sendToTarget();
    }

    @VisibleForTesting(otherwise = 5)
    public void setPendingRuntimeException(RuntimeException runtimeException) {
        this.pendingRuntimeException.set(runtimeException);
    }

    public void shutdown() {
        if (this.started) {
            flush();
            this.handlerThread.quit();
        }
        this.started = false;
    }

    public void start() {
        if (!this.started) {
            this.handlerThread.start();
            this.handler = new Handler(this.handlerThread.getLooper()) {
                public void handleMessage(Message message) {
                    AsynchronousMediaCodecBufferEnqueuer.this.doHandleMessage(message);
                }
            };
            this.started = true;
        }
    }

    public void waitUntilQueueingComplete() throws InterruptedException {
        blockUntilHandlerThreadIsIdle();
    }

    @VisibleForTesting
    public AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread2, ConditionVariable conditionVariable2) {
        this.codec = mediaCodec;
        this.handlerThread = handlerThread2;
        this.conditionVariable = conditionVariable2;
        this.pendingRuntimeException = new AtomicReference<>();
    }

    @Nullable
    private static int[] copy(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    @Nullable
    private static byte[] copy(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
