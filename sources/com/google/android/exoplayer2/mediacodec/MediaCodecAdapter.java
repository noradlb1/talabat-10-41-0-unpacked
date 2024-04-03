package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface MediaCodecAdapter {

    public static final class Configuration {
        public final MediaCodecInfo codecInfo;
        @Nullable
        public final MediaCrypto crypto;
        public final int flags;
        public final Format format;
        public final MediaFormat mediaFormat;
        @Nullable
        public final Surface surface;

        private Configuration(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat2, Format format2, @Nullable Surface surface2, @Nullable MediaCrypto mediaCrypto, int i11) {
            this.codecInfo = mediaCodecInfo;
            this.mediaFormat = mediaFormat2;
            this.format = format2;
            this.surface = surface2;
            this.crypto = mediaCrypto;
            this.flags = i11;
        }

        public static Configuration createForAudioDecoding(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat2, Format format2, @Nullable MediaCrypto mediaCrypto) {
            return new Configuration(mediaCodecInfo, mediaFormat2, format2, (Surface) null, mediaCrypto, 0);
        }

        public static Configuration createForVideoDecoding(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat2, Format format2, @Nullable Surface surface2, @Nullable MediaCrypto mediaCrypto) {
            return new Configuration(mediaCodecInfo, mediaFormat2, format2, surface2, mediaCrypto, 0);
        }
    }

    public interface Factory {
        public static final Factory DEFAULT = new DefaultMediaCodecAdapterFactory();

        MediaCodecAdapter createAdapter(Configuration configuration) throws IOException;
    }

    public interface OnFrameRenderedListener {
        void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long j11, long j12);
    }

    int dequeueInputBufferIndex();

    int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo);

    void flush();

    @Nullable
    ByteBuffer getInputBuffer(int i11);

    @RequiresApi(26)
    PersistableBundle getMetrics();

    @Nullable
    ByteBuffer getOutputBuffer(int i11);

    MediaFormat getOutputFormat();

    boolean needsReconfiguration();

    void queueInputBuffer(int i11, int i12, int i13, long j11, int i14);

    void queueSecureInputBuffer(int i11, int i12, CryptoInfo cryptoInfo, long j11, int i13);

    void release();

    @RequiresApi(21)
    void releaseOutputBuffer(int i11, long j11);

    void releaseOutputBuffer(int i11, boolean z11);

    @RequiresApi(23)
    void setOnFrameRenderedListener(OnFrameRenderedListener onFrameRenderedListener, Handler handler);

    @RequiresApi(23)
    void setOutputSurface(Surface surface);

    @RequiresApi(19)
    void setParameters(Bundle bundle);

    void setVideoScalingMode(int i11);
}
