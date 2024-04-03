package com.talabat.splash.data.repositories;

import com.talabat.splash.domain.entity.AppInitRootEntity;
import com.talabat.splash.domain.model.AppInfoRequestModel;
import com.talabat.splash.domain.model.AppInfoResponseWrapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/splash/domain/model/AppInfoResponseWrapper;", "it", "Lcom/talabat/splash/domain/entity/AppInitRootEntity;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AppInfoRepositoryImpl$makeAppInfoRequest$1 extends Lambda implements Function1<AppInitRootEntity, AppInfoResponseWrapper> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AppInfoRepositoryImpl f61455g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AppInfoRequestModel f61456h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppInfoRepositoryImpl$makeAppInfoRequest$1(AppInfoRepositoryImpl appInfoRepositoryImpl, AppInfoRequestModel appInfoRequestModel) {
        super(1);
        this.f61455g = appInfoRepositoryImpl;
        this.f61456h = appInfoRequestModel;
    }

    @NotNull
    public final AppInfoResponseWrapper invoke(@NotNull AppInitRootEntity appInitRootEntity) {
        Intrinsics.checkNotNullParameter(appInitRootEntity, "it");
        return this.f61455g.mapToAppInfoResponseWrapper(appInitRootEntity, this.f61456h);
    }
}
