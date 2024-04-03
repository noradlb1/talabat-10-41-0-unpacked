package com.instabug.library.util;

import com.instabug.library.util.BitmapUtils;

class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BitmapUtils.f f52059b;

    public e(BitmapUtils.f fVar) {
        this.f52059b = fVar;
    }

    public void run() {
        BitmapUtils.f fVar = this.f52059b;
        float[] e11 = BitmapUtils.getTargetDimensions(fVar.f52035d, fVar.f52036e);
        BitmapUtils.f fVar2 = this.f52059b;
        fVar2.f52037f.onBitmapReady(BitmapUtils.resizeBitmap(fVar2.f52038g, e11[0], e11[1]));
    }
}
