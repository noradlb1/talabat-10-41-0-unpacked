package com.instabug.featuresrequest.ui.featuredetails;

import com.instabug.library.model.AssetEntity;
import com.instabug.library.util.InstabugSDKLogger;

class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetEntity f46767b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ i f46768c;

    public h(i iVar, AssetEntity assetEntity) {
        this.f46768c = iVar;
        this.f46767b = assetEntity;
    }

    public void run() {
        this.f46768c.f46769a.b(this.f46767b.getFile().getAbsolutePath());
        if (!this.f46767b.getFile().exists()) {
            InstabugSDKLogger.e("IBG-FR", "Asset Entity downloading got FileNotFoundException error");
        }
        this.f46768c.f46770b.notifyDataSetChanged();
    }
}
