package com.instabug.library.util;

import com.instabug.library.model.AssetEntity;
import com.instabug.library.util.BitmapUtils;

class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetEntity f52057b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BitmapUtils.e f52058c;

    public d(BitmapUtils.e eVar, AssetEntity assetEntity) {
        this.f52058c = eVar;
        this.f52057b = assetEntity;
    }

    public void run() {
        BitmapUtils.decodeBitmap(this.f52057b, this.f52058c.f52032a);
    }
}
