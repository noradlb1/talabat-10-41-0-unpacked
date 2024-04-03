package com.talabat.splash.domain.model;

import com.talabat.splash.domain.entity.AppInitRootEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002BK\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0017Jb\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\fHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0005\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\n\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0007\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\r\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00060"}, d2 = {"Lcom/talabat/splash/domain/model/AppInfoResponseWrapper;", "", "()V", "appInfoResponse", "Lcom/talabat/splash/domain/entity/AppInitRootEntity;", "isFirstInstall", "", "isLoggedIn", "screenType", "Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;", "isForceUpdate", "forceUpdateMsg", "", "isShowAd", "(Lcom/talabat/splash/domain/entity/AppInitRootEntity;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAppInfoResponse", "()Lcom/talabat/splash/domain/entity/AppInitRootEntity;", "setAppInfoResponse", "(Lcom/talabat/splash/domain/entity/AppInitRootEntity;)V", "getForceUpdateMsg", "()Ljava/lang/String;", "setForceUpdateMsg", "(Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setFirstInstall", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setForceUpdate", "setLoggedIn", "setShowAd", "getScreenType", "()Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;", "setScreenType", "(Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/talabat/splash/domain/entity/AppInitRootEntity;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/splash/domain/model/AppInfoResponseWrapper;", "equals", "other", "hashCode", "", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInfoResponseWrapper {
    @Nullable
    private AppInitRootEntity appInfoResponse;
    @Nullable
    private String forceUpdateMsg;
    @Nullable
    private Boolean isFirstInstall;
    @Nullable
    private Boolean isForceUpdate;
    @Nullable
    private Boolean isLoggedIn;
    @Nullable
    private Boolean isShowAd;
    @Nullable
    private SplashRedirectionWrapper screenType;

    public AppInfoResponseWrapper(@Nullable AppInitRootEntity appInitRootEntity, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable SplashRedirectionWrapper splashRedirectionWrapper, @Nullable Boolean bool3, @Nullable String str, @Nullable Boolean bool4) {
        this.appInfoResponse = appInitRootEntity;
        this.isFirstInstall = bool;
        this.isLoggedIn = bool2;
        this.screenType = splashRedirectionWrapper;
        this.isForceUpdate = bool3;
        this.forceUpdateMsg = str;
        this.isShowAd = bool4;
    }

    public static /* synthetic */ AppInfoResponseWrapper copy$default(AppInfoResponseWrapper appInfoResponseWrapper, AppInitRootEntity appInitRootEntity, Boolean bool, Boolean bool2, SplashRedirectionWrapper splashRedirectionWrapper, Boolean bool3, String str, Boolean bool4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            appInitRootEntity = appInfoResponseWrapper.appInfoResponse;
        }
        if ((i11 & 2) != 0) {
            bool = appInfoResponseWrapper.isFirstInstall;
        }
        Boolean bool5 = bool;
        if ((i11 & 4) != 0) {
            bool2 = appInfoResponseWrapper.isLoggedIn;
        }
        Boolean bool6 = bool2;
        if ((i11 & 8) != 0) {
            splashRedirectionWrapper = appInfoResponseWrapper.screenType;
        }
        SplashRedirectionWrapper splashRedirectionWrapper2 = splashRedirectionWrapper;
        if ((i11 & 16) != 0) {
            bool3 = appInfoResponseWrapper.isForceUpdate;
        }
        Boolean bool7 = bool3;
        if ((i11 & 32) != 0) {
            str = appInfoResponseWrapper.forceUpdateMsg;
        }
        String str2 = str;
        if ((i11 & 64) != 0) {
            bool4 = appInfoResponseWrapper.isShowAd;
        }
        return appInfoResponseWrapper.copy(appInitRootEntity, bool5, bool6, splashRedirectionWrapper2, bool7, str2, bool4);
    }

    @Nullable
    public final AppInitRootEntity component1() {
        return this.appInfoResponse;
    }

    @Nullable
    public final Boolean component2() {
        return this.isFirstInstall;
    }

    @Nullable
    public final Boolean component3() {
        return this.isLoggedIn;
    }

    @Nullable
    public final SplashRedirectionWrapper component4() {
        return this.screenType;
    }

    @Nullable
    public final Boolean component5() {
        return this.isForceUpdate;
    }

    @Nullable
    public final String component6() {
        return this.forceUpdateMsg;
    }

    @Nullable
    public final Boolean component7() {
        return this.isShowAd;
    }

    @NotNull
    public final AppInfoResponseWrapper copy(@Nullable AppInitRootEntity appInitRootEntity, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable SplashRedirectionWrapper splashRedirectionWrapper, @Nullable Boolean bool3, @Nullable String str, @Nullable Boolean bool4) {
        return new AppInfoResponseWrapper(appInitRootEntity, bool, bool2, splashRedirectionWrapper, bool3, str, bool4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppInfoResponseWrapper)) {
            return false;
        }
        AppInfoResponseWrapper appInfoResponseWrapper = (AppInfoResponseWrapper) obj;
        return Intrinsics.areEqual((Object) this.appInfoResponse, (Object) appInfoResponseWrapper.appInfoResponse) && Intrinsics.areEqual((Object) this.isFirstInstall, (Object) appInfoResponseWrapper.isFirstInstall) && Intrinsics.areEqual((Object) this.isLoggedIn, (Object) appInfoResponseWrapper.isLoggedIn) && Intrinsics.areEqual((Object) this.screenType, (Object) appInfoResponseWrapper.screenType) && Intrinsics.areEqual((Object) this.isForceUpdate, (Object) appInfoResponseWrapper.isForceUpdate) && Intrinsics.areEqual((Object) this.forceUpdateMsg, (Object) appInfoResponseWrapper.forceUpdateMsg) && Intrinsics.areEqual((Object) this.isShowAd, (Object) appInfoResponseWrapper.isShowAd);
    }

    @Nullable
    public final AppInitRootEntity getAppInfoResponse() {
        return this.appInfoResponse;
    }

    @Nullable
    public final String getForceUpdateMsg() {
        return this.forceUpdateMsg;
    }

    @Nullable
    public final SplashRedirectionWrapper getScreenType() {
        return this.screenType;
    }

    public int hashCode() {
        AppInitRootEntity appInitRootEntity = this.appInfoResponse;
        int i11 = 0;
        int hashCode = (appInitRootEntity == null ? 0 : appInitRootEntity.hashCode()) * 31;
        Boolean bool = this.isFirstInstall;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isLoggedIn;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        SplashRedirectionWrapper splashRedirectionWrapper = this.screenType;
        int hashCode4 = (hashCode3 + (splashRedirectionWrapper == null ? 0 : splashRedirectionWrapper.hashCode())) * 31;
        Boolean bool3 = this.isForceUpdate;
        int hashCode5 = (hashCode4 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str = this.forceUpdateMsg;
        int hashCode6 = (hashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool4 = this.isShowAd;
        if (bool4 != null) {
            i11 = bool4.hashCode();
        }
        return hashCode6 + i11;
    }

    @Nullable
    public final Boolean isFirstInstall() {
        return this.isFirstInstall;
    }

    @Nullable
    public final Boolean isForceUpdate() {
        return this.isForceUpdate;
    }

    @Nullable
    public final Boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    @Nullable
    public final Boolean isShowAd() {
        return this.isShowAd;
    }

    public final void setAppInfoResponse(@Nullable AppInitRootEntity appInitRootEntity) {
        this.appInfoResponse = appInitRootEntity;
    }

    public final void setFirstInstall(@Nullable Boolean bool) {
        this.isFirstInstall = bool;
    }

    public final void setForceUpdate(@Nullable Boolean bool) {
        this.isForceUpdate = bool;
    }

    public final void setForceUpdateMsg(@Nullable String str) {
        this.forceUpdateMsg = str;
    }

    public final void setLoggedIn(@Nullable Boolean bool) {
        this.isLoggedIn = bool;
    }

    public final void setScreenType(@Nullable SplashRedirectionWrapper splashRedirectionWrapper) {
        this.screenType = splashRedirectionWrapper;
    }

    public final void setShowAd(@Nullable Boolean bool) {
        this.isShowAd = bool;
    }

    @NotNull
    public String toString() {
        AppInitRootEntity appInitRootEntity = this.appInfoResponse;
        Boolean bool = this.isFirstInstall;
        Boolean bool2 = this.isLoggedIn;
        SplashRedirectionWrapper splashRedirectionWrapper = this.screenType;
        Boolean bool3 = this.isForceUpdate;
        String str = this.forceUpdateMsg;
        Boolean bool4 = this.isShowAd;
        return "AppInfoResponseWrapper(appInfoResponse=" + appInitRootEntity + ", isFirstInstall=" + bool + ", isLoggedIn=" + bool2 + ", screenType=" + splashRedirectionWrapper + ", isForceUpdate=" + bool3 + ", forceUpdateMsg=" + str + ", isShowAd=" + bool4 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppInfoResponseWrapper() {
        /*
            r8 = this;
            r1 = 0
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            com.talabat.splash.domain.model.SplashRedirectionWrapper r4 = new com.talabat.splash.domain.model.SplashRedirectionWrapper
            com.talabat.splash.domain.model.SplashDataUtils r0 = com.talabat.splash.domain.model.SplashDataUtils.INSTANCE
            int r0 = r0.getNORMAL_FLOW()
            r2 = 1
            r4.<init>(r2, r0)
            java.lang.String r6 = ""
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            r0 = r8
            r2 = r5
            r3 = r5
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.domain.model.AppInfoResponseWrapper.<init>():void");
    }
}
