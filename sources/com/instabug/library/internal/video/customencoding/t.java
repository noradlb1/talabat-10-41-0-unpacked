package com.instabug.library.internal.video.customencoding;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.Nullable;
import java.util.Objects;

@TargetApi(21)
class t extends e {

    /* renamed from: e  reason: collision with root package name */
    private s f51219e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Surface f51220f;

    public t(s sVar) {
        super(sVar.a());
        this.f51219e = sVar;
    }

    public MediaFormat b() {
        return this.f51219e.e();
    }

    public void d(MediaCodec mediaCodec) {
        this.f51220f = mediaCodec.createInputSurface();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public Surface g() {
        Surface surface = this.f51220f;
        Objects.requireNonNull(surface, "doesn't prepare()");
        return surface;
    }

    public void d() {
        Surface surface = this.f51220f;
        if (surface != null) {
            surface.release();
            this.f51220f = null;
        }
        super.d();
    }
}
