package com.instabug.featuresrequest.ui.featuredetails;

import com.instabug.featuresrequest.models.a;
import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;

class i implements AssetsCacheManager.OnDownloadFinished {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f46769a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f46770b;

    public i(k kVar, a aVar) {
        this.f46770b = kVar;
        this.f46769a = aVar;
    }

    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-FR", "Asset Entity downloading got error", th2);
    }

    public void onSuccess(AssetEntity assetEntity) {
        PoolProvider.postMainThreadTask(new h(this, assetEntity));
    }
}
