package com.talabat.gem.adapters.data;

import com.talabat.gem.domain.entities.Location;
import com.talabat.gem.ports.data.UserInfoDataSourcesPort;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oq.h;
import oq.i;
import oq.j;
import oq.k;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/gem/adapters/data/UserInfoDataSources;", "Lcom/talabat/gem/ports/data/UserInfoDataSourcesPort;", "()V", "observeOnLocalization", "Lio/reactivex/Observable;", "", "observeOnUserLocation", "Lcom/talabat/gem/domain/entities/Location;", "observeOnUserName", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserInfoDataSources implements UserInfoDataSourcesPort {
    /* access modifiers changed from: private */
    /* renamed from: observeOnLocalization$lambda-2  reason: not valid java name */
    public static final boolean m10529observeOnLocalization$lambda2(ObservedData observedData) {
        Intrinsics.checkNotNullParameter(observedData, "it");
        if (observedData.getLocalization() != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: observeOnLocalization$lambda-3  reason: not valid java name */
    public static final String m10530observeOnLocalization$lambda3(ObservedData observedData) {
        Intrinsics.checkNotNullParameter(observedData, "it");
        return observedData.getLocalization();
    }

    /* access modifiers changed from: private */
    /* renamed from: observeOnUserLocation$lambda-1  reason: not valid java name */
    public static final Location m10531observeOnUserLocation$lambda1(ObservedData observedData) {
        Intrinsics.checkNotNullParameter(observedData, "it");
        return observedData.getUserLocation();
    }

    /* access modifiers changed from: private */
    /* renamed from: observeOnUserName$lambda-0  reason: not valid java name */
    public static final String m10532observeOnUserName$lambda0(ObservedData observedData) {
        Intrinsics.checkNotNullParameter(observedData, "it");
        return observedData.getUserName();
    }

    @NotNull
    public Observable<String> observeOnLocalization() {
        Observable<R> map = CacheKt.getCacheObservable().share().filter(new h()).map(new i());
        Intrinsics.checkNotNullExpressionValue(map, "cacheObservable\n        … .map { it.localization }");
        return map;
    }

    @NotNull
    public Observable<Location> observeOnUserLocation() {
        Observable<R> map = CacheKt.getCacheObservable().share().map(new k());
        Intrinsics.checkNotNullExpressionValue(map, "cacheObservable\n        … .map { it.userLocation }");
        return map;
    }

    @NotNull
    public Observable<String> observeOnUserName() {
        Observable<R> map = CacheKt.getCacheObservable().share().map(new j());
        Intrinsics.checkNotNullExpressionValue(map, "cacheObservable\n        …     .map { it.userName }");
        return map;
    }
}
