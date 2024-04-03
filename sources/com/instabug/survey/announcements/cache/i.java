package com.instabug.survey.announcements.cache;

import com.instabug.library.model.AssetEntity;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.survey.announcements.models.a;
import io.reactivex.observers.DisposableObserver;

class i extends DisposableObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f52232b;

    public i(a aVar) {
        this.f52232b = aVar;
    }

    /* renamed from: a */
    public void onNext(AssetEntity assetEntity) {
        InstabugSDKLogger.d("IBG-Surveys", "downloading announcement " + this.f52232b.i() + " asset started");
    }

    public void onComplete() {
        InstabugSDKLogger.d("IBG-Surveys", "downloading announcement " + this.f52232b.i() + " assets completed");
        this.f52232b.a(1);
        PoolProvider.postIOTask(new h(this));
    }

    public void onError(Throwable th2) {
        InstabugSDKLogger.e("IBG-Surveys", "downloading announcement " + this.f52232b.i() + " assets failed");
        PoolProvider.postIOTask(new g(this));
    }
}
