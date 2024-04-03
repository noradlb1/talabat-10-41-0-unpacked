package com.instabug.survey.announcements.cache;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.ObservableEmitter;

class k implements AssetsCacheManager.OnDownloadFinished {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ObservableEmitter f52235a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f52236b;

    public k(l lVar, ObservableEmitter observableEmitter) {
        this.f52236b = lVar;
        this.f52235a = observableEmitter;
    }

    public void onFailed(Throwable th2) {
        if (!this.f52235a.isDisposed()) {
            this.f52235a.onError(th2);
            return;
        }
        InstabugSDKLogger.e("IBG-Surveys", "Assets Request got error: " + th2);
    }

    public void onSuccess(AssetEntity assetEntity) {
        InstabugCore.doOnBackground(new j(this, assetEntity));
    }
}
