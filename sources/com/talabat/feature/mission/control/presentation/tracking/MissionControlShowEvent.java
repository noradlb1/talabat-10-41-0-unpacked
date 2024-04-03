package com.talabat.feature.mission.control.presentation.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0014\u001a\u00020\tHÂ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\rHÖ\u0003J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fH\u0002J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/mission/control/presentation/tracking/MissionControlShowEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "vendorId", "", "isDarkstores", "", "widgetType", "widgetName", "widgetPosition", "", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;I)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "featureName", "getAttributes", "hashCode", "name", "toString", "com_talabat_feature_mission-control_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionControlShowEvent extends TalabatEvent {
    private final boolean isDarkstores;
    @NotNull
    private final String vendorId;
    @NotNull
    private final String widgetName;
    private final int widgetPosition;
    @NotNull
    private final String widgetType;

    public MissionControlShowEvent(@NotNull String str, boolean z11, @NotNull String str2, @NotNull String str3, int i11) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, "widgetType");
        Intrinsics.checkNotNullParameter(str3, "widgetName");
        this.vendorId = str;
        this.isDarkstores = z11;
        this.widgetType = str2;
        this.widgetName = str3;
        this.widgetPosition = i11;
    }

    private final String component1() {
        return this.vendorId;
    }

    private final boolean component2() {
        return this.isDarkstores;
    }

    private final String component3() {
        return this.widgetType;
    }

    private final String component4() {
        return this.widgetName;
    }

    private final int component5() {
        return this.widgetPosition;
    }

    public static /* synthetic */ MissionControlShowEvent copy$default(MissionControlShowEvent missionControlShowEvent, String str, boolean z11, String str2, String str3, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = missionControlShowEvent.vendorId;
        }
        if ((i12 & 2) != 0) {
            z11 = missionControlShowEvent.isDarkstores;
        }
        boolean z12 = z11;
        if ((i12 & 4) != 0) {
            str2 = missionControlShowEvent.widgetType;
        }
        String str4 = str2;
        if ((i12 & 8) != 0) {
            str3 = missionControlShowEvent.widgetName;
        }
        String str5 = str3;
        if ((i12 & 16) != 0) {
            i11 = missionControlShowEvent.widgetPosition;
        }
        return missionControlShowEvent.copy(str, z12, str4, str5, i11);
    }

    private final Map<String, Object> getAttributes() {
        String str;
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("screenName", "shop_details");
        pairArr[1] = TuplesKt.to("screenType", "shop_details");
        pairArr[2] = TuplesKt.to("shopId", this.vendorId);
        if (this.isDarkstores) {
            str = "darkstore";
        } else {
            str = null;
        }
        if (str == null) {
            str = "groceries";
        }
        pairArr[3] = TuplesKt.to("listingPageType", str);
        pairArr[4] = TuplesKt.to("widgetType", this.widgetType);
        pairArr[5] = TuplesKt.to("widgetName", this.widgetName);
        pairArr[6] = TuplesKt.to("widgetPosition", Integer.valueOf(this.widgetPosition));
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return getAttributes();
    }

    @NotNull
    public final MissionControlShowEvent copy(@NotNull String str, boolean z11, @NotNull String str2, @NotNull String str3, int i11) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, "widgetType");
        Intrinsics.checkNotNullParameter(str3, "widgetName");
        return new MissionControlShowEvent(str, z11, str2, str3, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MissionControlShowEvent)) {
            return false;
        }
        MissionControlShowEvent missionControlShowEvent = (MissionControlShowEvent) obj;
        return Intrinsics.areEqual((Object) this.vendorId, (Object) missionControlShowEvent.vendorId) && this.isDarkstores == missionControlShowEvent.isDarkstores && Intrinsics.areEqual((Object) this.widgetType, (Object) missionControlShowEvent.widgetType) && Intrinsics.areEqual((Object) this.widgetName, (Object) missionControlShowEvent.widgetName) && this.widgetPosition == missionControlShowEvent.widgetPosition;
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "darkstores";
    }

    public int hashCode() {
        int hashCode = this.vendorId.hashCode() * 31;
        boolean z11 = this.isDarkstores;
        if (z11) {
            z11 = true;
        }
        return ((((((hashCode + (z11 ? 1 : 0)) * 31) + this.widgetType.hashCode()) * 31) + this.widgetName.hashCode()) * 31) + this.widgetPosition;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "mission_control_shown";
    }

    @NotNull
    public String toString() {
        String str = this.vendorId;
        boolean z11 = this.isDarkstores;
        String str2 = this.widgetType;
        String str3 = this.widgetName;
        int i11 = this.widgetPosition;
        return "MissionControlShowEvent(vendorId=" + str + ", isDarkstores=" + z11 + ", widgetType=" + str2 + ", widgetName=" + str3 + ", widgetPosition=" + i11 + ")";
    }
}
