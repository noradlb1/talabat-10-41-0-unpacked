package com.talabat.talabatcommon.feature.vouchers.loyalty.tracking;

import buisnessmodels.Cart;
import com.talabat.talabatcommon.feature.vouchers.loyalty.data.GrowthTrackerRepo;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import datamodels.RedeemedVoucher;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GrowthTracker$voucherSuccessToApply$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VoucherData f61683g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f61684h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GrowthTracker$voucherSuccessToApply$1(VoucherData voucherData, float f11) {
        super(0);
        this.f61683g = voucherData;
        this.f61684h = f11;
    }

    public final void invoke() {
        GrowthTracker.gaGrowthTrackerRepoImpl.voucherSuccessToApply(this.f61683g.getId(), this.f61683g.getTitle(), this.f61684h, this.f61683g.getVoucherOptionType().name());
        if (Cart.getInstance().getRedeemedVoucher() == null) {
            Cart instance = Cart.getInstance();
            String id2 = this.f61683g.getId();
            String title = this.f61683g.getTitle();
            String voucherCode = this.f61683g.getVoucherCode();
            float discountValue = this.f61683g.getDiscountValue();
            String upperCase = this.f61683g.getDiscountType().getValue().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            float maxDiscountCap = this.f61683g.getMaxDiscountCap();
            float minOrderValue = this.f61683g.getMinOrderValue();
            String tag = this.f61683g.getTag();
            String validTil = this.f61683g.getValidTil();
            String termsAndConditions = this.f61683g.getTermsAndConditions();
            String deepLink = this.f61683g.getDeepLink();
            String description = this.f61683g.getDescription();
            String campaignReferenceId = this.f61683g.getCampaignReferenceId();
            RedeemedVoucher redeemedVoucher = r3;
            RedeemedVoucher redeemedVoucher2 = new RedeemedVoucher(id2, title, Float.valueOf(discountValue), upperCase, Float.valueOf(maxDiscountCap), Float.valueOf(minOrderValue), tag, validTil, termsAndConditions, deepLink, description, voucherCode, campaignReferenceId, (Integer) null, 8192, (DefaultConstructorMarker) null);
            instance.setRedeemedVoucher(redeemedVoucher);
        }
        GrowthTrackerRepo access$getBrazeGrowthTrackerRepoImpl$p = GrowthTracker.brazeGrowthTrackerRepoImpl;
        RedeemedVoucher redeemedVoucher3 = Cart.getInstance().getRedeemedVoucher();
        Intrinsics.checkNotNullExpressionValue(redeemedVoucher3, "getInstance().redeemedVoucher");
        access$getBrazeGrowthTrackerRepoImpl$p.voucherSuccessToApply(new AppVoucherAppliedTrackingEvent(redeemedVoucher3));
    }
}
