package com.google.android.exoplayer2.video;

import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;

public class MediaCodecVideoDecoderException extends MediaCodecDecoderException {
    public final boolean isSurfaceValid;
    public final int surfaceIdentityHashCode;

    public MediaCodecVideoDecoderException(Throwable th2, @Nullable MediaCodecInfo mediaCodecInfo, @Nullable Surface surface) {
        super(th2, mediaCodecInfo);
        boolean z11;
        this.surfaceIdentityHashCode = System.identityHashCode(surface);
        if (surface == null || surface.isValid()) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.isSurfaceValid = z11;
    }
}
