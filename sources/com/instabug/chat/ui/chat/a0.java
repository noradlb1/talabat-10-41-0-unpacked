package com.instabug.chat.ui.chat;

import com.instabug.chat.model.g;
import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.model.AssetEntity;

class a0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f46186b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g0 f46187c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ h0 f46188d;

    public a0(h0 h0Var, g gVar, g0 g0Var) {
        this.f46188d = h0Var;
        this.f46186b = gVar;
        this.f46187c = g0Var;
    }

    public void run() {
        String h11 = this.f46186b.h();
        if (h11 != null) {
            AssetsCacheManager.getAssetEntity(AssetsCacheManager.createEmptyEntity(this.f46188d.f46218d, h11, AssetEntity.AssetType.VIDEO), new z(this));
        }
    }
}
