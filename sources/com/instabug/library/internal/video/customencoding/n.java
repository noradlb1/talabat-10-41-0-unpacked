package com.instabug.library.internal.video.customencoding;

import android.media.projection.MediaProjection;

class n extends MediaProjection.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f51184a;

    public n(q qVar) {
        this.f51184a = qVar;
    }

    public void onStop() {
        this.f51184a.c();
    }
}
