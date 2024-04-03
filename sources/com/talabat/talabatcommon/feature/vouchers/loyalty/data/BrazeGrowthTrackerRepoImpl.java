package com.talabat.talabatcommon.feature.vouchers.loyalty.data;

import android.content.Context;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.talabatcommon.feature.vouchers.loyalty.data.GrowthTrackerRepo;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.AppVoucherAppliedTrackingEvent;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.AppVoucherRedeemedTrackingEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.TalabatAppBoy;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/data/BrazeGrowthTrackerRepoImpl;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/data/GrowthTrackerRepo;", "context", "Landroid/content/Context;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Landroid/content/Context;Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "trackingToolName", "", "getTrackingToolName", "()Ljava/lang/String;", "onRewardsScreenLoaded", "", "onVoucherRedeemed", "appVoucherRedeemedTrackingEvent", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/AppVoucherRedeemedTrackingEvent;", "setTalabatTracker", "voucherSuccessToApply", "appVoucherAppliedTrackingEvent", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/AppVoucherAppliedTrackingEvent;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeGrowthTrackerRepoImpl implements GrowthTrackerRepo {
    @NotNull
    private final Context context;
    @Nullable
    private TalabatTracker talabatTracker;

    public BrazeGrowthTrackerRepoImpl(@NotNull Context context2, @Nullable TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.talabatTracker = talabatTracker2;
    }

    @NotNull
    public String getTrackingToolName() {
        return "Braze";
    }

    public void logEvent(@NotNull String str) {
        GrowthTrackerRepo.DefaultImpls.logEvent(this, str);
    }

    public void onRewardsScreenLoaded() {
        logEvent(TalabatAppBoy.EVENT_NAME_OPENED_REDEEM_OFFERS);
        TalabatAppBoy.landOnRewardsScreen(this.context);
    }

    public void onVoucherRedeemed(@NotNull AppVoucherRedeemedTrackingEvent appVoucherRedeemedTrackingEvent) {
        Intrinsics.checkNotNullParameter(appVoucherRedeemedTrackingEvent, "appVoucherRedeemedTrackingEvent");
        logEvent(TalabatAppBoy.EVENT_NAME_VOUCHER_REDEEMED);
        TalabatTracker talabatTracker2 = this.talabatTracker;
        if (talabatTracker2 != null) {
            talabatTracker2.track(appVoucherRedeemedTrackingEvent);
        }
    }

    public void onVoucherRemoved(@Nullable String str, @NotNull String str2, float f11, @NotNull String str3) {
        GrowthTrackerRepo.DefaultImpls.onVoucherRemoved(this, str, str2, f11, str3);
    }

    public final void setTalabatTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
    }

    public void voucherFailToApply(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        GrowthTrackerRepo.DefaultImpls.voucherFailToApply(this, str, str2, str3, str4);
    }

    public void voucherSuccessToApply(@NotNull String str, @NotNull String str2, float f11, @NotNull String str3) {
        GrowthTrackerRepo.DefaultImpls.voucherSuccessToApply(this, str, str2, f11, str3);
    }

    public void vouchersLoadedSuccess(@NotNull List<String> list) {
        GrowthTrackerRepo.DefaultImpls.vouchersLoadedSuccess(this, list);
    }

    public void voucherSuccessToApply(@NotNull AppVoucherAppliedTrackingEvent appVoucherAppliedTrackingEvent) {
        Intrinsics.checkNotNullParameter(appVoucherAppliedTrackingEvent, "appVoucherAppliedTrackingEvent");
        logEvent(TalabatAppBoy.EVENT_NAME_APP_VOUCHER_APPLIED);
        TalabatTracker talabatTracker2 = this.talabatTracker;
        if (talabatTracker2 != null) {
            talabatTracker2.track(appVoucherAppliedTrackingEvent);
        }
    }
}
