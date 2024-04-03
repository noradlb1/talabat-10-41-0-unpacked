package com.talabat.splash.domain.model;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Singleton
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000fJF\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0007\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006'"}, d2 = {"Lcom/talabat/splash/domain/model/ScreenInfoWrapper;", "", "screenName", "", "forceUpdateMessage", "screenType", "Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;", "isForceUpdate", "", "shouldForceLocationSelectLocationInHome", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getForceUpdateMessage", "()Ljava/lang/String;", "setForceUpdateMessage", "(Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setForceUpdate", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getScreenName", "setScreenName", "getScreenType", "()Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;", "setScreenType", "(Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;)V", "getShouldForceLocationSelectLocationInHome", "setShouldForceLocationSelectLocationInHome", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/talabat/splash/domain/model/ScreenInfoWrapper;", "equals", "other", "hashCode", "", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenInfoWrapper {
    @NotNull
    private String forceUpdateMessage;
    @Nullable
    private Boolean isForceUpdate;
    @Nullable
    private String screenName;
    @NotNull
    private SplashRedirectionWrapper screenType;
    @Nullable
    private Boolean shouldForceLocationSelectLocationInHome;

    @Inject
    public ScreenInfoWrapper(@Nullable String str, @NotNull String str2, @NotNull SplashRedirectionWrapper splashRedirectionWrapper, @Nullable Boolean bool, @Nullable Boolean bool2) {
        Intrinsics.checkNotNullParameter(str2, "forceUpdateMessage");
        Intrinsics.checkNotNullParameter(splashRedirectionWrapper, "screenType");
        this.screenName = str;
        this.forceUpdateMessage = str2;
        this.screenType = splashRedirectionWrapper;
        this.isForceUpdate = bool;
        this.shouldForceLocationSelectLocationInHome = bool2;
    }

    public static /* synthetic */ ScreenInfoWrapper copy$default(ScreenInfoWrapper screenInfoWrapper, String str, String str2, SplashRedirectionWrapper splashRedirectionWrapper, Boolean bool, Boolean bool2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = screenInfoWrapper.screenName;
        }
        if ((i11 & 2) != 0) {
            str2 = screenInfoWrapper.forceUpdateMessage;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            splashRedirectionWrapper = screenInfoWrapper.screenType;
        }
        SplashRedirectionWrapper splashRedirectionWrapper2 = splashRedirectionWrapper;
        if ((i11 & 8) != 0) {
            bool = screenInfoWrapper.isForceUpdate;
        }
        Boolean bool3 = bool;
        if ((i11 & 16) != 0) {
            bool2 = screenInfoWrapper.shouldForceLocationSelectLocationInHome;
        }
        return screenInfoWrapper.copy(str, str3, splashRedirectionWrapper2, bool3, bool2);
    }

    @Nullable
    public final String component1() {
        return this.screenName;
    }

    @NotNull
    public final String component2() {
        return this.forceUpdateMessage;
    }

    @NotNull
    public final SplashRedirectionWrapper component3() {
        return this.screenType;
    }

    @Nullable
    public final Boolean component4() {
        return this.isForceUpdate;
    }

    @Nullable
    public final Boolean component5() {
        return this.shouldForceLocationSelectLocationInHome;
    }

    @NotNull
    public final ScreenInfoWrapper copy(@Nullable String str, @NotNull String str2, @NotNull SplashRedirectionWrapper splashRedirectionWrapper, @Nullable Boolean bool, @Nullable Boolean bool2) {
        Intrinsics.checkNotNullParameter(str2, "forceUpdateMessage");
        Intrinsics.checkNotNullParameter(splashRedirectionWrapper, "screenType");
        return new ScreenInfoWrapper(str, str2, splashRedirectionWrapper, bool, bool2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScreenInfoWrapper)) {
            return false;
        }
        ScreenInfoWrapper screenInfoWrapper = (ScreenInfoWrapper) obj;
        return Intrinsics.areEqual((Object) this.screenName, (Object) screenInfoWrapper.screenName) && Intrinsics.areEqual((Object) this.forceUpdateMessage, (Object) screenInfoWrapper.forceUpdateMessage) && Intrinsics.areEqual((Object) this.screenType, (Object) screenInfoWrapper.screenType) && Intrinsics.areEqual((Object) this.isForceUpdate, (Object) screenInfoWrapper.isForceUpdate) && Intrinsics.areEqual((Object) this.shouldForceLocationSelectLocationInHome, (Object) screenInfoWrapper.shouldForceLocationSelectLocationInHome);
    }

    @NotNull
    public final String getForceUpdateMessage() {
        return this.forceUpdateMessage;
    }

    @Nullable
    public final String getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final SplashRedirectionWrapper getScreenType() {
        return this.screenType;
    }

    @Nullable
    public final Boolean getShouldForceLocationSelectLocationInHome() {
        return this.shouldForceLocationSelectLocationInHome;
    }

    public int hashCode() {
        String str = this.screenName;
        int i11 = 0;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.forceUpdateMessage.hashCode()) * 31) + this.screenType.hashCode()) * 31;
        Boolean bool = this.isForceUpdate;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.shouldForceLocationSelectLocationInHome;
        if (bool2 != null) {
            i11 = bool2.hashCode();
        }
        return hashCode2 + i11;
    }

    @Nullable
    public final Boolean isForceUpdate() {
        return this.isForceUpdate;
    }

    public final void setForceUpdate(@Nullable Boolean bool) {
        this.isForceUpdate = bool;
    }

    public final void setForceUpdateMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.forceUpdateMessage = str;
    }

    public final void setScreenName(@Nullable String str) {
        this.screenName = str;
    }

    public final void setScreenType(@NotNull SplashRedirectionWrapper splashRedirectionWrapper) {
        Intrinsics.checkNotNullParameter(splashRedirectionWrapper, "<set-?>");
        this.screenType = splashRedirectionWrapper;
    }

    public final void setShouldForceLocationSelectLocationInHome(@Nullable Boolean bool) {
        this.shouldForceLocationSelectLocationInHome = bool;
    }

    @NotNull
    public String toString() {
        String str = this.screenName;
        String str2 = this.forceUpdateMessage;
        SplashRedirectionWrapper splashRedirectionWrapper = this.screenType;
        Boolean bool = this.isForceUpdate;
        Boolean bool2 = this.shouldForceLocationSelectLocationInHome;
        return "ScreenInfoWrapper(screenName=" + str + ", forceUpdateMessage=" + str2 + ", screenType=" + splashRedirectionWrapper + ", isForceUpdate=" + bool + ", shouldForceLocationSelectLocationInHome=" + bool2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScreenInfoWrapper(String str, String str2, SplashRedirectionWrapper splashRedirectionWrapper, Boolean bool, Boolean bool2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? "" : str2, splashRedirectionWrapper, bool, bool2);
    }
}
