package com.instabug.survey.announcements.cache;

import com.instabug.library.Instabug;
import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.model.AssetEntity;
import com.instabug.survey.announcements.models.e;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

class l implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f52237a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f52238b;

    public l(e eVar, long j11) {
        this.f52237a = eVar;
        this.f52238b = j11;
    }

    public void subscribe(ObservableEmitter observableEmitter) {
        if (Instabug.getApplicationContext() != null && this.f52237a.b() != null) {
            AssetsCacheManager.getAssetEntity(AssetsCacheManager.createEmptyEntity(Instabug.getApplicationContext(), this.f52237a.b(), AssetEntity.AssetType.IMAGE), new k(this, observableEmitter));
        }
    }
}
