package com.instabug.library.internal.video.customencoding;

import android.media.MediaCodec;
import android.media.MediaFormat;
import androidx.annotation.NonNull;

class c extends MediaCodec.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f51152a;

    public c(e eVar) {
        this.f51152a = eVar;
    }

    public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
        if (this.f51152a.f51155c != null) {
            this.f51152a.f51155c.a(this.f51152a, codecException);
        }
    }

    public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i11) {
        if (this.f51152a.f51155c != null) {
            this.f51152a.f51155c.a(this.f51152a, i11);
        }
    }

    public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i11, @NonNull MediaCodec.BufferInfo bufferInfo) {
        if (this.f51152a.f51155c != null) {
            this.f51152a.f51155c.a(this.f51152a, i11, bufferInfo);
        }
    }

    public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
        if (this.f51152a.f51155c != null) {
            this.f51152a.f51155c.a(this.f51152a, mediaFormat);
        }
    }
}
