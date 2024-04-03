package com.instabug.library.internal.video.customencoding;

import android.media.MediaCodec;

class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f51163b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f51164c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaCodec.BufferInfo f51165d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ k f51166e;

    public j(k kVar, e eVar, int i11, MediaCodec.BufferInfo bufferInfo) {
        this.f51166e = kVar;
        this.f51163b = eVar;
        this.f51164c = i11;
        this.f51165d = bufferInfo;
    }

    public void run() {
        if (this.f51166e.f51167a != null) {
            this.f51166e.f51167a.a(this.f51163b, this.f51164c, this.f51165d);
        }
    }
}
