package com.talabat.talabatcommon.feature.vouchers.loyalty.tracking;

import com.talabat.core.observabilityNew.domain.common.EventType;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/PromoCodeSubmitSuccessfullyEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "screenName", "", "screenType", "voucherData", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;)V", "getScreenName", "()Ljava/lang/String;", "getScreenType", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PromoCodeSubmitSuccessfullyEvent extends TalabatEvent {
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;
    @NotNull
    private final VoucherData voucherData;

    public PromoCodeSubmitSuccessfullyEvent(@NotNull String str, @NotNull String str2, @NotNull VoucherData voucherData2) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "screenType");
        Intrinsics.checkNotNullParameter(voucherData2, "voucherData");
        this.screenName = str;
        this.screenType = str2;
        this.voucherData = voucherData2;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("screenName", PromoCodeSubmitSuccessfullyEventKt.orDefault(this.screenName)), TuplesKt.to(GrowthTrackerConstants.SCREEN_TYPE, PromoCodeSubmitSuccessfullyEventKt.orDefault(this.screenType)), TuplesKt.to("offerVoucherId", PromoCodeSubmitSuccessfullyEventKt.orDefault(this.voucherData.getId())), TuplesKt.to("coupon", PromoCodeSubmitSuccessfullyEventKt.orDefault(this.voucherData.getVoucherCode())), TuplesKt.to(GrowthTrackerConstants.COUPON_VALUE, Float.valueOf(this.voucherData.getDiscountValue())), TuplesKt.to(GrowthTrackerConstants.SUBMITTED_VOUCHER, PromoCodeSubmitSuccessfullyEventKt.orDefault(this.voucherData.getVoucherOptionType().name())));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return EventType.TrackingAnalyticsEvents.name();
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final String getScreenType() {
        return this.screenType;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "order_coupon_submitted";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsKt.listOf(PlatformName.GOOGLE_ANALYTICS, PlatformName.NEW_RELIC);
    }
}
