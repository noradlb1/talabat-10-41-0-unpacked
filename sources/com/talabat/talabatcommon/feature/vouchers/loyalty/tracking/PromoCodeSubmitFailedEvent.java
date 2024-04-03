package com.talabat.talabatcommon.feature.vouchers.loyalty.tracking;

import com.talabat.core.observabilityNew.domain.common.EventType;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001eH\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/PromoCodeSubmitFailedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "screenName", "", "screenType", "voucherId", "voucherCode", "voucherOptionType", "discountValue", "", "couponRejectedMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)V", "getCouponRejectedMessage", "()Ljava/lang/String;", "getDiscountValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getScreenName", "getScreenType", "getVoucherCode", "getVoucherId", "getVoucherOptionType", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PromoCodeSubmitFailedEvent extends TalabatEvent {
    @NotNull
    private final String couponRejectedMessage;
    @Nullable
    private final Float discountValue;
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;
    @NotNull
    private final String voucherCode;
    @Nullable
    private final String voucherId;
    @NotNull
    private final String voucherOptionType;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PromoCodeSubmitFailedEvent(String str, String str2, String str3, String str4, String str5, Float f11, String str6, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? null : str3, str4, str5, (i11 & 32) != 0 ? null : f11, str6);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("screenName", PromoCodeSubmitFailedEventKt.orDefault(this.screenName)), TuplesKt.to(GrowthTrackerConstants.SCREEN_TYPE, PromoCodeSubmitFailedEventKt.orDefault(this.screenType)), TuplesKt.to("offerVoucherId", PromoCodeSubmitFailedEventKt.orDefault(this.voucherId)), TuplesKt.to("coupon", PromoCodeSubmitFailedEventKt.orDefault(this.voucherCode)), TuplesKt.to(GrowthTrackerConstants.COUPON_VALUE, this.discountValue), TuplesKt.to(GrowthTrackerConstants.SUBMITTED_VOUCHER, PromoCodeSubmitFailedEventKt.orDefault(this.voucherOptionType)), TuplesKt.to(GrowthTrackerConstants.REJECTED_MEESSAGE, PromoCodeSubmitFailedEventKt.orDefault(this.couponRejectedMessage)));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return EventType.TrackingAnalyticsEvents.name();
    }

    @NotNull
    public final String getCouponRejectedMessage() {
        return this.couponRejectedMessage;
    }

    @Nullable
    public final Float getDiscountValue() {
        return this.discountValue;
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
    public final String getVoucherCode() {
        return this.voucherCode;
    }

    @Nullable
    public final String getVoucherId() {
        return this.voucherId;
    }

    @NotNull
    public final String getVoucherOptionType() {
        return this.voucherOptionType;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "order_coupon_failed";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsKt.listOf(PlatformName.GOOGLE_ANALYTICS, PlatformName.NEW_RELIC);
    }

    public PromoCodeSubmitFailedEvent(@NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5, @Nullable Float f11, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "screenType");
        Intrinsics.checkNotNullParameter(str4, "voucherCode");
        Intrinsics.checkNotNullParameter(str5, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        Intrinsics.checkNotNullParameter(str6, GrowthTrackerConstants.REJECTED_MEESSAGE);
        this.screenName = str;
        this.screenType = str2;
        this.voucherId = str3;
        this.voucherCode = str4;
        this.voucherOptionType = str5;
        this.discountValue = f11;
        this.couponRejectedMessage = str6;
    }
}
