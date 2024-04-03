package com.talabat.talabatcommon.feature.vouchers.loyalty.tracking;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import datamodels.RedeemedVoucher;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.TalabatAppBoy;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/AppVoucherAppliedTrackingEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "voucherData", "Ldatamodels/RedeemedVoucher;", "(Ldatamodels/RedeemedVoucher;)V", "attributes", "", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppVoucherAppliedTrackingEvent extends TalabatEvent {
    @NotNull
    private final RedeemedVoucher voucherData;

    public AppVoucherAppliedTrackingEvent(@NotNull RedeemedVoucher redeemedVoucher) {
        Intrinsics.checkNotNullParameter(redeemedVoucher, "voucherData");
        this.voucherData = redeemedVoucher;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("customer_voucher_id", this.voucherData.getId()), TuplesKt.to("voucher_title", this.voucherData.getTitle()), TuplesKt.to("voucher_code", this.voucherData.getVoucherCode()), TuplesKt.to("voucher_tag", this.voucherData.getTag()), TuplesKt.to("voucher_valid_till_date", this.voucherData.getValidTil()), TuplesKt.to("voucher_discount_type", this.voucherData.getDiscountType()), TuplesKt.to("voucher_discount_value", this.voucherData.getDiscountValue()), TuplesKt.to("voucher_discount_cap", this.voucherData.getMaxDiscountCap()), TuplesKt.to("voucher_min_order_value", this.voucherData.getMinOrderValue()), TuplesKt.to("voucher_deeplink", this.voucherData.getDeepLink()), TuplesKt.to("voucher_description", this.voucherData.getDescription()), TuplesKt.to("terms_and_conditions", this.voucherData.getTermsAndConditions()), TuplesKt.to("voucher_campaign_reference_id", this.voucherData.getCampaignReferenceId()));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "voucher_applied";
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return TalabatAppBoy.EVENT_NAME_APP_VOUCHER_APPLIED;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.BRAZE);
    }
}
