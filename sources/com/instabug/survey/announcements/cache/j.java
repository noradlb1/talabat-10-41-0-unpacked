package com.instabug.survey.announcements.cache;

import com.instabug.library.model.AssetEntity;

class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetEntity f52233b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f52234c;

    public j(k kVar, AssetEntity assetEntity) {
        this.f52234c = kVar;
        this.f52233b = assetEntity;
    }

    public void run() {
        l lVar = this.f52234c.f52236b;
        e.a(lVar.f52238b, lVar.f52237a.c(), this.f52233b.getFile().getPath());
        this.f52234c.f52235a.onNext(this.f52233b);
        this.f52234c.f52235a.onComplete();
    }
}
