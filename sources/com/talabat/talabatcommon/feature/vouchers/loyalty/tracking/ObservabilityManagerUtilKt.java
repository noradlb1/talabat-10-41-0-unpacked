package com.talabat.talabatcommon.feature.vouchers.loyalty.tracking;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000\u001a&\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003\u001a\u0016\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003\u001a\u0016\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003\u001a0\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0000¨\u0006\u0010"}, d2 = {"observeFailToApplyVoucherCode", "", "reasonMessage", "", "voucherCode", "voucherId", "observeFailToGetGuestVoucherDetails", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "countryCode", "observeFailToGetGuestWelcomeVoucherDetails", "observeFailToGetPossibleBinRestrictedVoucher", "customerVoucherId", "observeFailToRedeemVoucherCode", "brandId", "screenName", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ObservabilityManagerUtilKt {
    public static final void observeFailToApplyVoucherCode(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "reasonMessage");
        Intrinsics.checkNotNullParameter(str2, "voucherCode");
        Intrinsics.checkNotNullParameter(str3, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        ObservabilityManager.trackUnExpectedScenario("FailToApplyVoucher", MapsKt__MapsKt.mapOf(TuplesKt.to("message", str), TuplesKt.to("voucherCode", str2), TuplesKt.to(VoucherUrlConstantsKt.PATH_VOUCHER_ID, str3)));
    }

    public static final void observeFailToGetGuestVoucherDetails(@NotNull IObservabilityManager iObservabilityManager, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(str, "reasonMessage");
        Intrinsics.checkNotNullParameter(str2, "voucherCode");
        Intrinsics.checkNotNullParameter(str3, "countryCode");
        iObservabilityManager.trackUnExpectedScenario("FailToGetGuestVoucher", MapsKt__MapsKt.mapOf(TuplesKt.to("message", str), TuplesKt.to("voucherCode", str2), TuplesKt.to("countryCode", str3)));
    }

    public static final void observeFailToGetGuestWelcomeVoucherDetails(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "reasonMessage");
        Intrinsics.checkNotNullParameter(str2, "countryCode");
        ObservabilityManager.trackUnExpectedScenario("FailToGetGuestWelcomeVoucher", MapsKt__MapsKt.mapOf(TuplesKt.to("message", str), TuplesKt.to("countryCode", str2)));
    }

    public static final void observeFailToGetPossibleBinRestrictedVoucher(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "reasonMessage");
        Intrinsics.checkNotNullParameter(str2, VoucherUrlConstantsKt.QUERY_CUSTOMER_VOUCHER_ID);
        ObservabilityManager.trackUnExpectedScenario("FailToGetPossibleBinRestrictedVoucher", MapsKt__MapsKt.mapOf(TuplesKt.to("message", str), TuplesKt.to(VoucherUrlConstantsKt.QUERY_CUSTOMER_VOUCHER_ID, str2)));
    }

    public static final void observeFailToRedeemVoucherCode(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "reasonMessage");
        Intrinsics.checkNotNullParameter(str2, "voucherCode");
        Intrinsics.checkNotNullParameter(str3, "brandId");
        Intrinsics.checkNotNullParameter(str4, "countryCode");
        Intrinsics.checkNotNullParameter(str5, "screenName");
        ObservabilityManager.trackUnExpectedScenario("FailToRedeemVoucherCode", MapsKt__MapsKt.mapOf(TuplesKt.to("message", str), TuplesKt.to("voucherCode", str2), TuplesKt.to("brandId", str3), TuplesKt.to("countryCode", str4), TuplesKt.to("screenName", str5)));
    }
}
