package com.talabat.splash.domain.model;

import com.talabat.splash.domain.entity.AppInitRootEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002JI\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/splash/domain/model/AppInfoResponseMapper;", "", "()V", "mapToDisplayModel", "Lcom/talabat/splash/domain/model/AppInfoResponseWrapper;", "appInitRootEntity", "Lcom/talabat/splash/domain/entity/AppInitRootEntity;", "isFirstInstall", "", "isLoggedIn", "flowType", "Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;", "isForceUpdate", "ForceUpdateMsg", "", "isShowAd", "(Lcom/talabat/splash/domain/entity/AppInitRootEntity;ZZLcom/talabat/splash/domain/model/SplashRedirectionWrapper;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/splash/domain/model/AppInfoResponseWrapper;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInfoResponseMapper {
    @NotNull
    public final AppInfoResponseWrapper mapToDisplayModel(@NotNull AppInitRootEntity appInitRootEntity, boolean z11, boolean z12, @NotNull SplashRedirectionWrapper splashRedirectionWrapper, @Nullable Boolean bool, @Nullable String str, @Nullable Boolean bool2) {
        Intrinsics.checkNotNullParameter(appInitRootEntity, "appInitRootEntity");
        Intrinsics.checkNotNullParameter(splashRedirectionWrapper, "flowType");
        return new AppInfoResponseWrapper(appInitRootEntity, Boolean.valueOf(z11), Boolean.valueOf(z12), splashRedirectionWrapper, bool, str, bool2);
    }
}
