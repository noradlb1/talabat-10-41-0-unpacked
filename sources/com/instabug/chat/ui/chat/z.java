package com.instabug.chat.ui.chat;

import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;

class z implements AssetsCacheManager.OnDownloadFinished {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a0 f46258a;

    public z(a0 a0Var) {
        this.f46258a = a0Var;
    }

    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-BR", "Asset Entity downloading got error: " + th2.getMessage());
    }

    public void onSuccess(AssetEntity assetEntity) {
        InstabugSDKLogger.v("IBG-BR", "Asset Entity download succeeded: ");
        PoolProvider.postMainThreadTask(new y(this, assetEntity));
    }
}
