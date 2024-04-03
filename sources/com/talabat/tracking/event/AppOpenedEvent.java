package com.talabat.tracking.event;

import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÂ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÂ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nHÂ\u0003JI\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0002J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/tracking/event/AppOpenedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "screenType", "", "isFWFSDKinFlutter", "", "campaignId", "", "locationStatus", "campaignParams", "", "", "(Ljava/lang/String;ZILjava/lang/String;Ljava/util/Map;)V", "attributes", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "featureName", "getCampaignCode", "hashCode", "isCampaign", "name", "platforms", "", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppOpenedEvent extends TalabatEvent {
    private final int campaignId;
    @NotNull
    private final Map<String, Object> campaignParams;
    private final boolean isFWFSDKinFlutter;
    @NotNull
    private final String locationStatus;
    @NotNull
    private final String screenType;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AppOpenedEvent(@NotNull String str, boolean z11, int i11, @NotNull String str2) {
        this(str, z11, i11, str2, (Map) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "locationStatus");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppOpenedEvent(String str, boolean z11, int i11, String str2, Map map, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z11, i11, str2, (i12 & 16) != 0 ? MapsKt__MapsKt.emptyMap() : map);
    }

    private final String component1() {
        return this.screenType;
    }

    private final boolean component2() {
        return this.isFWFSDKinFlutter;
    }

    private final int component3() {
        return this.campaignId;
    }

    private final String component4() {
        return this.locationStatus;
    }

    private final Map<String, Object> component5() {
        return this.campaignParams;
    }

    public static /* synthetic */ AppOpenedEvent copy$default(AppOpenedEvent appOpenedEvent, String str, boolean z11, int i11, String str2, Map<String, Object> map, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = appOpenedEvent.screenType;
        }
        if ((i12 & 2) != 0) {
            z11 = appOpenedEvent.isFWFSDKinFlutter;
        }
        boolean z12 = z11;
        if ((i12 & 4) != 0) {
            i11 = appOpenedEvent.campaignId;
        }
        int i13 = i11;
        if ((i12 & 8) != 0) {
            str2 = appOpenedEvent.locationStatus;
        }
        String str3 = str2;
        if ((i12 & 16) != 0) {
            map = appOpenedEvent.campaignParams;
        }
        return appOpenedEvent.copy(str, z12, i13, str3, map);
    }

    private final String getCampaignCode() {
        return isCampaign() ? String.valueOf(this.campaignId) : "N/A";
    }

    private final boolean isCampaign() {
        return this.campaignId > 0;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.plus(MapsKt__MapsKt.mapOf(TuplesKt.to("screenType", this.screenType), TuplesKt.to("screenName", ScreenNames.SPLASHSCREEN), TuplesKt.to("gpsStatus", this.locationStatus), TuplesKt.to("campaignCode", getCampaignCode()), TuplesKt.to("isCampaign", String.valueOf(isCampaign())), TuplesKt.to("isFWFSDKinFlutter", Boolean.valueOf(this.isFWFSDKinFlutter)), TuplesKt.to(FunWithFlags.FLUTTER_MIGRATION_VERIFY_KEY, FunWithFlags.FLUTTER_MIGRATION_VERIFY_VALUE)), (Map) this.campaignParams);
    }

    @NotNull
    public final AppOpenedEvent copy(@NotNull String str, boolean z11, int i11, @NotNull String str2, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "locationStatus");
        Intrinsics.checkNotNullParameter(map, "campaignParams");
        return new AppOpenedEvent(str, z11, i11, str2, map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppOpenedEvent)) {
            return false;
        }
        AppOpenedEvent appOpenedEvent = (AppOpenedEvent) obj;
        return Intrinsics.areEqual((Object) this.screenType, (Object) appOpenedEvent.screenType) && this.isFWFSDKinFlutter == appOpenedEvent.isFWFSDKinFlutter && this.campaignId == appOpenedEvent.campaignId && Intrinsics.areEqual((Object) this.locationStatus, (Object) appOpenedEvent.locationStatus) && Intrinsics.areEqual((Object) this.campaignParams, (Object) appOpenedEvent.campaignParams);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "talabat";
    }

    public int hashCode() {
        int hashCode = this.screenType.hashCode() * 31;
        boolean z11 = this.isFWFSDKinFlutter;
        if (z11) {
            z11 = true;
        }
        return ((((((hashCode + (z11 ? 1 : 0)) * 31) + this.campaignId) * 31) + this.locationStatus.hashCode()) * 31) + this.campaignParams.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "app_opened";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }

    @NotNull
    public String toString() {
        String str = this.screenType;
        boolean z11 = this.isFWFSDKinFlutter;
        int i11 = this.campaignId;
        String str2 = this.locationStatus;
        Map<String, Object> map = this.campaignParams;
        return "AppOpenedEvent(screenType=" + str + ", isFWFSDKinFlutter=" + z11 + ", campaignId=" + i11 + ", locationStatus=" + str2 + ", campaignParams=" + map + ")";
    }

    @JvmOverloads
    public AppOpenedEvent(@NotNull String str, boolean z11, int i11, @NotNull String str2, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        Intrinsics.checkNotNullParameter(str2, "locationStatus");
        Intrinsics.checkNotNullParameter(map, "campaignParams");
        this.screenType = str;
        this.isFWFSDKinFlutter = z11;
        this.campaignId = i11;
        this.locationStatus = str2;
        this.campaignParams = map;
    }
}
