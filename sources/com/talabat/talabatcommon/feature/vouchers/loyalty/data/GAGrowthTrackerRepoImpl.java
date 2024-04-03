package com.talabat.talabatcommon.feature.vouchers.loyalty.data;

import android.content.Context;
import buisnessmodels.Cart;
import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.data.GrowthTrackerRepo;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.AppVoucherAppliedTrackingEvent;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.AppVoucherRedeemedTrackingEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.TalabatAdjust;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ*\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J*\u0010\u0014\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0016J(\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0016\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/data/GAGrowthTrackerRepoImpl;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/data/GrowthTrackerRepo;", "context", "Landroid/content/Context;", "cart", "Lbuisnessmodels/Cart;", "talabatGTM", "Ltracking/gtm/TalabatGTM$Companion;", "(Landroid/content/Context;Lbuisnessmodels/Cart;Ltracking/gtm/TalabatGTM$Companion;)V", "trackingToolName", "", "getTrackingToolName", "()Ljava/lang/String;", "onVoucherRemoved", "", "voucherId", "voucherCode", "discountAmount", "", "voucherOptionType", "voucherFailToApply", "errorMessage", "voucherSuccessToApply", "vouchersLoadedSuccess", "vouchersIds", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GAGrowthTrackerRepoImpl implements GrowthTrackerRepo {
    @NotNull
    private final Cart cart;
    @NotNull
    private final Context context;
    @NotNull
    private final TalabatGTM.Companion talabatGTM;

    public GAGrowthTrackerRepoImpl(@NotNull Context context2, @NotNull Cart cart2, @NotNull TalabatGTM.Companion companion) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(cart2, "cart");
        Intrinsics.checkNotNullParameter(companion, "talabatGTM");
        this.context = context2;
        this.cart = cart2;
        this.talabatGTM = companion;
    }

    @NotNull
    public String getTrackingToolName() {
        return "GA";
    }

    public void logEvent(@NotNull String str) {
        GrowthTrackerRepo.DefaultImpls.logEvent(this, str);
    }

    public void onRewardsScreenLoaded() {
        GrowthTrackerRepo.DefaultImpls.onRewardsScreenLoaded(this);
    }

    public void onVoucherRedeemed(@NotNull AppVoucherRedeemedTrackingEvent appVoucherRedeemedTrackingEvent) {
        GrowthTrackerRepo.DefaultImpls.onVoucherRedeemed(this, appVoucherRedeemedTrackingEvent);
    }

    public void onVoucherRemoved(@Nullable String str, @NotNull String str2, float f11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str2, "voucherCode");
        Intrinsics.checkNotNullParameter(str3, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        this.talabatGTM.voucherRemoved(this.context, str, str2, String.valueOf(f11), this.cart.getRestaurant(), str3);
    }

    public void voucherFailToApply(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str2, "voucherCode");
        Intrinsics.checkNotNullParameter(str3, "errorMessage");
        Intrinsics.checkNotNullParameter(str4, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        TalabatAdjust.voucherRejected(this.cart.getCartItems(), this.cart.getRestaurant(), str2, str3);
    }

    public void voucherSuccessToApply(@NotNull AppVoucherAppliedTrackingEvent appVoucherAppliedTrackingEvent) {
        GrowthTrackerRepo.DefaultImpls.voucherSuccessToApply(this, appVoucherAppliedTrackingEvent);
    }

    public void vouchersLoadedSuccess(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "vouchersIds");
        this.talabatGTM.vouchersLoadedSuccess(this.context, list, this.cart.getRestaurant());
    }

    public void voucherSuccessToApply(@NotNull String str, @NotNull String str2, float f11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(str2, "voucherCode");
        Intrinsics.checkNotNullParameter(str3, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        this.talabatGTM.voucherRedeemSuccess(this.context, str, str2, String.valueOf(f11), this.cart.getRestaurant(), str3);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GAGrowthTrackerRepoImpl(android.content.Context r1, buisnessmodels.Cart r2, tracking.gtm.TalabatGTM.Companion r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000d
            buisnessmodels.Cart r2 = buisnessmodels.Cart.getInstance()
            java.lang.String r5 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
        L_0x000d:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0013
            tracking.gtm.TalabatGTM$Companion r3 = tracking.gtm.TalabatGTM.Companion
        L_0x0013:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.vouchers.loyalty.data.GAGrowthTrackerRepoImpl.<init>(android.content.Context, buisnessmodels.Cart, tracking.gtm.TalabatGTM$Companion, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
