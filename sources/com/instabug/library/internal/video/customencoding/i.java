package com.instabug.library.internal.video.customencoding;

import android.media.MediaFormat;

class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f51160b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaFormat f51161c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k f51162d;

    public i(k kVar, e eVar, MediaFormat mediaFormat) {
        this.f51162d = kVar;
        this.f51160b = eVar;
        this.f51161c = mediaFormat;
    }

    public void run() {
        if (this.f51162d.f51167a != null) {
            this.f51162d.f51167a.a(this.f51160b, this.f51161c);
        }
    }
}
