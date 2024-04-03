package com.talabat.talabatcommon.feature.vouchers.loyalty.data;

import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.AppVoucherAppliedTrackingEvent;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.AppVoucherRedeemedTrackingEvent;
import com.talabat.talabatcore.logger.LogManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J*\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J*\u0010\u0013\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J(\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0018\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/data/GrowthTrackerRepo;", "", "trackingToolName", "", "getTrackingToolName", "()Ljava/lang/String;", "logEvent", "", "eventName", "onRewardsScreenLoaded", "onVoucherRedeemed", "appVoucherRedeemedTrackingEvent", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/AppVoucherRedeemedTrackingEvent;", "onVoucherRemoved", "voucherId", "voucherCode", "discountAmount", "", "voucherOptionType", "voucherFailToApply", "errorMessage", "voucherSuccessToApply", "appVoucherAppliedTrackingEvent", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/AppVoucherAppliedTrackingEvent;", "vouchersLoadedSuccess", "vouchersIds", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GrowthTrackerRepo {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void logEvent(@NotNull GrowthTrackerRepo growthTrackerRepo, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "eventName");
            String trackingToolName = growthTrackerRepo.getTrackingToolName();
            LogManager.debug("Growth - " + trackingToolName + " >> " + str);
        }

        public static void onRewardsScreenLoaded(@NotNull GrowthTrackerRepo growthTrackerRepo) {
        }

        public static void onVoucherRedeemed(@NotNull GrowthTrackerRepo growthTrackerRepo, @NotNull AppVoucherRedeemedTrackingEvent appVoucherRedeemedTrackingEvent) {
            Intrinsics.checkNotNullParameter(appVoucherRedeemedTrackingEvent, "appVoucherRedeemedTrackingEvent");
        }

        public static void onVoucherRemoved(@NotNull GrowthTrackerRepo growthTrackerRepo, @Nullable String str, @NotNull String str2, float f11, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str2, "voucherCode");
            Intrinsics.checkNotNullParameter(str3, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        }

        public static void voucherFailToApply(@NotNull GrowthTrackerRepo growthTrackerRepo, @Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str2, "voucherCode");
            Intrinsics.checkNotNullParameter(str3, "errorMessage");
            Intrinsics.checkNotNullParameter(str4, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        }

        public static void voucherSuccessToApply(@NotNull GrowthTrackerRepo growthTrackerRepo, @NotNull AppVoucherAppliedTrackingEvent appVoucherAppliedTrackingEvent) {
            Intrinsics.checkNotNullParameter(appVoucherAppliedTrackingEvent, "appVoucherAppliedTrackingEvent");
        }

        public static void voucherSuccessToApply(@NotNull GrowthTrackerRepo growthTrackerRepo, @NotNull String str, @NotNull String str2, float f11, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
            Intrinsics.checkNotNullParameter(str2, "voucherCode");
            Intrinsics.checkNotNullParameter(str3, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        }

        public static void vouchersLoadedSuccess(@NotNull GrowthTrackerRepo growthTrackerRepo, @NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "vouchersIds");
        }
    }

    @NotNull
    String getTrackingToolName();

    void logEvent(@NotNull String str);

    void onRewardsScreenLoaded();

    void onVoucherRedeemed(@NotNull AppVoucherRedeemedTrackingEvent appVoucherRedeemedTrackingEvent);

    void onVoucherRemoved(@Nullable String str, @NotNull String str2, float f11, @NotNull String str3);

    void voucherFailToApply(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    void voucherSuccessToApply(@NotNull AppVoucherAppliedTrackingEvent appVoucherAppliedTrackingEvent);

    void voucherSuccessToApply(@NotNull String str, @NotNull String str2, float f11, @NotNull String str3);

    void vouchersLoadedSuccess(@NotNull List<String> list);
}
