package com.talabat.configuration.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013Jn\u0010\u001f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\f\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0004\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\t\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0006\u0010\u0013R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\r\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lcom/talabat/configuration/remote/model/RootAppInfoEntity;", "", "appInfoEntity", "Lcom/talabat/configuration/remote/model/AppInfoEntity;", "isFirstInstall", "", "isLoggedIn", "screenType", "Lcom/talabat/configuration/remote/model/AppInfoScreenType;", "isForceUpdate", "forceUpdateMsg", "", "isCountryDetected", "isShowAd", "(Lcom/talabat/configuration/remote/model/AppInfoEntity;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/talabat/configuration/remote/model/AppInfoScreenType;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAppInfoEntity", "()Lcom/talabat/configuration/remote/model/AppInfoEntity;", "getForceUpdateMsg", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getScreenType", "()Lcom/talabat/configuration/remote/model/AppInfoScreenType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Lcom/talabat/configuration/remote/model/AppInfoEntity;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/talabat/configuration/remote/model/AppInfoScreenType;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/talabat/configuration/remote/model/RootAppInfoEntity;", "equals", "other", "hashCode", "", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RootAppInfoEntity {
    @Nullable
    private final AppInfoEntity appInfoEntity;
    @Nullable
    private final String forceUpdateMsg;
    @Nullable
    private final Boolean isCountryDetected;
    @Nullable
    private final Boolean isFirstInstall;
    @Nullable
    private final Boolean isForceUpdate;
    @Nullable
    private final Boolean isLoggedIn;
    @Nullable
    private final Boolean isShowAd;
    @Nullable
    private final AppInfoScreenType screenType;

    public RootAppInfoEntity() {
        this((AppInfoEntity) null, (Boolean) null, (Boolean) null, (AppInfoScreenType) null, (Boolean) null, (String) null, (Boolean) null, (Boolean) null, 255, (DefaultConstructorMarker) null);
    }

    public RootAppInfoEntity(@Nullable @Json(name = "appInfoResponse") AppInfoEntity appInfoEntity2, @Nullable @Json(name = "isFirstInstall") Boolean bool, @Nullable @Json(name = "isLoggedIn") Boolean bool2, @Nullable @Json(name = "screenType") AppInfoScreenType appInfoScreenType, @Nullable @Json(name = "isForceUpdate") Boolean bool3, @Nullable @Json(name = "forceUpdateMsg") String str, @Nullable @Json(name = "isCountryDetected") Boolean bool4, @Nullable @Json(name = "isShowAd") Boolean bool5) {
        this.appInfoEntity = appInfoEntity2;
        this.isFirstInstall = bool;
        this.isLoggedIn = bool2;
        this.screenType = appInfoScreenType;
        this.isForceUpdate = bool3;
        this.forceUpdateMsg = str;
        this.isCountryDetected = bool4;
        this.isShowAd = bool5;
    }

    public static /* synthetic */ RootAppInfoEntity copy$default(RootAppInfoEntity rootAppInfoEntity, AppInfoEntity appInfoEntity2, Boolean bool, Boolean bool2, AppInfoScreenType appInfoScreenType, Boolean bool3, String str, Boolean bool4, Boolean bool5, int i11, Object obj) {
        RootAppInfoEntity rootAppInfoEntity2 = rootAppInfoEntity;
        int i12 = i11;
        return rootAppInfoEntity.copy((i12 & 1) != 0 ? rootAppInfoEntity2.appInfoEntity : appInfoEntity2, (i12 & 2) != 0 ? rootAppInfoEntity2.isFirstInstall : bool, (i12 & 4) != 0 ? rootAppInfoEntity2.isLoggedIn : bool2, (i12 & 8) != 0 ? rootAppInfoEntity2.screenType : appInfoScreenType, (i12 & 16) != 0 ? rootAppInfoEntity2.isForceUpdate : bool3, (i12 & 32) != 0 ? rootAppInfoEntity2.forceUpdateMsg : str, (i12 & 64) != 0 ? rootAppInfoEntity2.isCountryDetected : bool4, (i12 & 128) != 0 ? rootAppInfoEntity2.isShowAd : bool5);
    }

    @Nullable
    public final AppInfoEntity component1() {
        return this.appInfoEntity;
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
    public final AppInfoScreenType component4() {
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
        return this.isCountryDetected;
    }

    @Nullable
    public final Boolean component8() {
        return this.isShowAd;
    }

    @NotNull
    public final RootAppInfoEntity copy(@Nullable @Json(name = "appInfoResponse") AppInfoEntity appInfoEntity2, @Nullable @Json(name = "isFirstInstall") Boolean bool, @Nullable @Json(name = "isLoggedIn") Boolean bool2, @Nullable @Json(name = "screenType") AppInfoScreenType appInfoScreenType, @Nullable @Json(name = "isForceUpdate") Boolean bool3, @Nullable @Json(name = "forceUpdateMsg") String str, @Nullable @Json(name = "isCountryDetected") Boolean bool4, @Nullable @Json(name = "isShowAd") Boolean bool5) {
        return new RootAppInfoEntity(appInfoEntity2, bool, bool2, appInfoScreenType, bool3, str, bool4, bool5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RootAppInfoEntity)) {
            return false;
        }
        RootAppInfoEntity rootAppInfoEntity = (RootAppInfoEntity) obj;
        return Intrinsics.areEqual((Object) this.appInfoEntity, (Object) rootAppInfoEntity.appInfoEntity) && Intrinsics.areEqual((Object) this.isFirstInstall, (Object) rootAppInfoEntity.isFirstInstall) && Intrinsics.areEqual((Object) this.isLoggedIn, (Object) rootAppInfoEntity.isLoggedIn) && Intrinsics.areEqual((Object) this.screenType, (Object) rootAppInfoEntity.screenType) && Intrinsics.areEqual((Object) this.isForceUpdate, (Object) rootAppInfoEntity.isForceUpdate) && Intrinsics.areEqual((Object) this.forceUpdateMsg, (Object) rootAppInfoEntity.forceUpdateMsg) && Intrinsics.areEqual((Object) this.isCountryDetected, (Object) rootAppInfoEntity.isCountryDetected) && Intrinsics.areEqual((Object) this.isShowAd, (Object) rootAppInfoEntity.isShowAd);
    }

    @Nullable
    public final AppInfoEntity getAppInfoEntity() {
        return this.appInfoEntity;
    }

    @Nullable
    public final String getForceUpdateMsg() {
        return this.forceUpdateMsg;
    }

    @Nullable
    public final AppInfoScreenType getScreenType() {
        return this.screenType;
    }

    public int hashCode() {
        AppInfoEntity appInfoEntity2 = this.appInfoEntity;
        int i11 = 0;
        int hashCode = (appInfoEntity2 == null ? 0 : appInfoEntity2.hashCode()) * 31;
        Boolean bool = this.isFirstInstall;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isLoggedIn;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        AppInfoScreenType appInfoScreenType = this.screenType;
        int hashCode4 = (hashCode3 + (appInfoScreenType == null ? 0 : appInfoScreenType.hashCode())) * 31;
        Boolean bool3 = this.isForceUpdate;
        int hashCode5 = (hashCode4 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str = this.forceUpdateMsg;
        int hashCode6 = (hashCode5 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool4 = this.isCountryDetected;
        int hashCode7 = (hashCode6 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.isShowAd;
        if (bool5 != null) {
            i11 = bool5.hashCode();
        }
        return hashCode7 + i11;
    }

    @Nullable
    public final Boolean isCountryDetected() {
        return this.isCountryDetected;
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

    @NotNull
    public String toString() {
        AppInfoEntity appInfoEntity2 = this.appInfoEntity;
        Boolean bool = this.isFirstInstall;
        Boolean bool2 = this.isLoggedIn;
        AppInfoScreenType appInfoScreenType = this.screenType;
        Boolean bool3 = this.isForceUpdate;
        String str = this.forceUpdateMsg;
        Boolean bool4 = this.isCountryDetected;
        Boolean bool5 = this.isShowAd;
        return "RootAppInfoEntity(appInfoEntity=" + appInfoEntity2 + ", isFirstInstall=" + bool + ", isLoggedIn=" + bool2 + ", screenType=" + appInfoScreenType + ", isForceUpdate=" + bool3 + ", forceUpdateMsg=" + str + ", isCountryDetected=" + bool4 + ", isShowAd=" + bool5 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RootAppInfoEntity(com.talabat.configuration.remote.model.AppInfoEntity r10, java.lang.Boolean r11, java.lang.Boolean r12, com.talabat.configuration.remote.model.AppInfoScreenType r13, java.lang.Boolean r14, java.lang.String r15, java.lang.Boolean r16, java.lang.Boolean r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.remote.model.RootAppInfoEntity.<init>(com.talabat.configuration.remote.model.AppInfoEntity, java.lang.Boolean, java.lang.Boolean, com.talabat.configuration.remote.model.AppInfoScreenType, java.lang.Boolean, java.lang.String, java.lang.Boolean, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
