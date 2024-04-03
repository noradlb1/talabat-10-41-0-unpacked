package com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTrackerConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/events/VoucherEntryPointClickedTrackingEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "navigationOption", "", "screenName", "screenType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherEntryPointClickedTrackingEvent extends TalabatEvent {
    @NotNull
    private final String navigationOption;
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;

    public VoucherEntryPointClickedTrackingEvent(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "navigationOption");
        Intrinsics.checkNotNullParameter(str2, "screenName");
        Intrinsics.checkNotNullParameter(str3, "screenType");
        this.navigationOption = str;
        this.screenName = str2;
        this.screenType = str3;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("navigationOption", this.navigationOption), TuplesKt.to("screenName", this.screenName), TuplesKt.to(GrowthTrackerConstants.SCREEN_TYPE, this.screenType));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return GrowthTrackerConstants.VOUCHERS_FEATURE_NAME;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "navigation_option_clicked";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.GOOGLE_ANALYTICS);
    }
}
