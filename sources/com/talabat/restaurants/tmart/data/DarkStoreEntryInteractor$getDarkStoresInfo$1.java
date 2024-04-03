package com.talabat.restaurants.tmart.data;

import JsonModels.Response.Darkstores.DarkStoresEntryPointResponse;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/talabat/restaurants/tmart/data/DarkStoreEntryInteractor$getDarkStoresInfo$1", "Lio/reactivex/Observer;", "LJsonModels/Response/Darkstores/DarkStoresEntryPointResponse;", "onComplete", "", "onError", "e", "", "onNext", "data", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkStoreEntryInteractor$getDarkStoresInfo$1 implements Observer<DarkStoresEntryPointResponse> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkStoreEntryListener f61226b;

    public DarkStoreEntryInteractor$getDarkStoresInfo$1(DarkStoreEntryListener darkStoreEntryListener) {
        this.f61226b = darkStoreEntryListener;
    }

    public void onComplete() {
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        this.f61226b.onDarkStoresEntryFailure();
    }

    public void onSubscribe(@NotNull Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "d");
    }

    public void onNext(@NotNull DarkStoresEntryPointResponse darkStoresEntryPointResponse) {
        Intrinsics.checkNotNullParameter(darkStoresEntryPointResponse, "data");
        if (darkStoresEntryPointResponse.getResult() != null) {
            this.f61226b.onDarkStoresEntrySuccess(darkStoresEntryPointResponse.getResult());
        } else {
            this.f61226b.onDarkStoresEntryFailure();
        }
    }
}
