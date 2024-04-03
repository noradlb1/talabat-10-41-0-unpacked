package com.instabug.library.internal.video.customencoding;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class k extends Handler {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public d f51167a;

    public k(@NonNull Looper looper, @Nullable d dVar) {
        super(looper);
        this.f51167a = dVar;
    }

    public void b(e eVar, int i11, MediaCodec.BufferInfo bufferInfo) {
        Message.obtain(this, new j(this, eVar, i11, bufferInfo)).sendToTarget();
    }

    public void c(e eVar, MediaFormat mediaFormat) {
        Message.obtain(this, new i(this, eVar, mediaFormat)).sendToTarget();
    }

    public void d(g gVar, Exception exc) {
        Message.obtain(this, new h(this, gVar, exc)).sendToTarget();
    }
}
