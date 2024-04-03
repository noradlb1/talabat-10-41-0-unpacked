package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import v7.l;

public final class SynchronousMediaCodecAdapter implements MediaCodecAdapter {
    private final MediaCodec codec;
    @Nullable
    private ByteBuffer[] inputByteBuffers;
    @Nullable
    private ByteBuffer[] outputByteBuffers;

    public static class Factory implements MediaCodecAdapter.Factory {
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.exoplayer2.mediacodec.MediaCodecAdapter createAdapter(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.Configuration r6) throws java.io.IOException {
            /*
                r5 = this;
                r0 = 0
                android.media.MediaCodec r1 = r5.createCodec(r6)     // Catch:{ IOException -> 0x0030, RuntimeException -> 0x002e }
                java.lang.String r2 = "configureCodec"
                com.google.android.exoplayer2.util.TraceUtil.beginSection(r2)     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                android.media.MediaFormat r2 = r6.mediaFormat     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                android.view.Surface r3 = r6.surface     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                android.media.MediaCrypto r4 = r6.crypto     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                int r6 = r6.flags     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                r1.configure(r2, r3, r4, r6)     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                com.google.android.exoplayer2.util.TraceUtil.endSection()     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                java.lang.String r6 = "startCodec"
                com.google.android.exoplayer2.util.TraceUtil.beginSection(r6)     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                r1.start()     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                com.google.android.exoplayer2.util.TraceUtil.endSection()     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter r6 = new com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                r6.<init>(r1)     // Catch:{ IOException -> 0x002b, RuntimeException -> 0x0029 }
                return r6
            L_0x0029:
                r6 = move-exception
                goto L_0x002c
            L_0x002b:
                r6 = move-exception
            L_0x002c:
                r0 = r1
                goto L_0x0031
            L_0x002e:
                r6 = move-exception
                goto L_0x0031
            L_0x0030:
                r6 = move-exception
            L_0x0031:
                if (r0 == 0) goto L_0x0036
                r0.release()
            L_0x0036:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter.Factory.createAdapter(com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Configuration):com.google.android.exoplayer2.mediacodec.MediaCodecAdapter");
        }

        public MediaCodec createCodec(MediaCodecAdapter.Configuration configuration) throws IOException {
            Assertions.checkNotNull(configuration.codecInfo);
            String str = configuration.codecInfo.f34956name;
            TraceUtil.beginSection("createCodec:" + str);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            TraceUtil.endSection();
            return createByCodecName;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnFrameRenderedListener$0(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j11, long j12) {
        onFrameRenderedListener.onFrameRendered(this, j11, j12);
    }

    public int dequeueInputBufferIndex() {
        return this.codec.dequeueInputBuffer(0);
    }

    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer == -3 && Util.SDK_INT < 21) {
                this.outputByteBuffers = this.codec.getOutputBuffers();
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    public void flush() {
        this.codec.flush();
    }

    @Nullable
    public ByteBuffer getInputBuffer(int i11) {
        if (Util.SDK_INT >= 21) {
            return this.codec.getInputBuffer(i11);
        }
        return ((ByteBuffer[]) Util.castNonNull(this.inputByteBuffers))[i11];
    }

    @RequiresApi(26)
    public PersistableBundle getMetrics() {
        return this.codec.getMetrics();
    }

    @Nullable
    public ByteBuffer getOutputBuffer(int i11) {
        if (Util.SDK_INT >= 21) {
            return this.codec.getOutputBuffer(i11);
        }
        return ((ByteBuffer[]) Util.castNonNull(this.outputByteBuffers))[i11];
    }

    public MediaFormat getOutputFormat() {
        return this.codec.getOutputFormat();
    }

    public boolean needsReconfiguration() {
        return false;
    }

    public void queueInputBuffer(int i11, int i12, int i13, long j11, int i14) {
        this.codec.queueInputBuffer(i11, i12, i13, j11, i14);
    }

    public void queueSecureInputBuffer(int i11, int i12, CryptoInfo cryptoInfo, long j11, int i13) {
        this.codec.queueSecureInputBuffer(i11, i12, cryptoInfo.getFrameworkCryptoInfo(), j11, i13);
    }

    public void release() {
        this.inputByteBuffers = null;
        this.outputByteBuffers = null;
        this.codec.release();
    }

    public void releaseOutputBuffer(int i11, boolean z11) {
        this.codec.releaseOutputBuffer(i11, z11);
    }

    @RequiresApi(23)
    public void setOnFrameRenderedListener(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        this.codec.setOnFrameRenderedListener(new l(this, onFrameRenderedListener), handler);
    }

    @RequiresApi(23)
    public void setOutputSurface(Surface surface) {
        this.codec.setOutputSurface(surface);
    }

    @RequiresApi(19)
    public void setParameters(Bundle bundle) {
        this.codec.setParameters(bundle);
    }

    public void setVideoScalingMode(int i11) {
        this.codec.setVideoScalingMode(i11);
    }

    private SynchronousMediaCodecAdapter(MediaCodec mediaCodec) {
        this.codec = mediaCodec;
        if (Util.SDK_INT < 21) {
            this.inputByteBuffers = mediaCodec.getInputBuffers();
            this.outputByteBuffers = mediaCodec.getOutputBuffers();
        }
    }

    @RequiresApi(21)
    public void releaseOutputBuffer(int i11, long j11) {
        this.codec.releaseOutputBuffer(i11, j11);
    }
}
