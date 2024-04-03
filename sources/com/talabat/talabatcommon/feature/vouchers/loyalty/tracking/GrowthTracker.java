package com.talabat.talabatcommon.feature.vouchers.loyalty.tracking;

import android.app.Application;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import buisnessmodels.Cart;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.core.tracking.data.events.rewards.RedeemEventParams;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import com.talabat.lib.Integration;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcommon.feature.vouchers.loyalty.data.BrazeGrowthTrackerRepoImpl;
import com.talabat.talabatcommon.feature.vouchers.loyalty.data.GAGrowthTrackerRepoImpl;
import com.talabat.talabatcommon.feature.vouchers.loyalty.data.GrowthTrackerRepo;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bJ.\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013J.\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013J.\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u000fJ&\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013J,\u0010 \u001a\u00020\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00132\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0013H\u0007J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0007J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010-\u001a\u00020\u000f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0/H\u0002J\u001e\u00100\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u0013J\u001e\u00102\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u0013JS\u00103\u001a\u00020\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00132\u0006\u0010\"\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00132\n\b\u0002\u00105\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u00106J\u0016\u00107\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0014\u00108\u001a\u00020\u000f2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00130:R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/GrowthTracker;", "", "()V", "VOUCHER_LOADED_IMPRESSION_SIZE", "", "brazeGrowthTrackerRepoImpl", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/data/GrowthTrackerRepo;", "context", "Landroid/content/Context;", "gaGrowthTrackerRepoImpl", "isGrowthTrackerEnabled", "", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "enableTracker", "", "isTrackerEnabled", "onRedeemPointsCompleted", "screenName", "", "points", "title", "screenType", "Lcom/talabat/core/tracking/data/events/rewards/RedeemEventParams$ScreenType;", "offerVoucherId", "onRedeemVoucherClicked", "onRedeemVoucherFailed", "reason", "onRewardsScreenLoaded", "onVoucherRedeemed", "voucherData", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "onVoucherRemoved", "voucherId", "voucherCode", "discountAmount", "", "voucherOptionType", "setGrowthTrackerRepos", "brazeRepo", "gaRepo", "setTalabatTracker", "trackObservability", "featureName", "eventName", "trackerEnabled", "blockToRun", "Lkotlin/Function0;", "voucherEntryPointClicked", "navigationOption", "voucherEntryPointLoaded", "voucherFailToApply", "errorMessage", "discountValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;)V", "voucherSuccessToApply", "vouchersLoadedSuccess", "vouchersIds", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GrowthTracker {
    @NotNull
    public static final GrowthTracker INSTANCE = new GrowthTracker();
    public static final int VOUCHER_LOADED_IMPRESSION_SIZE = 6;
    /* access modifiers changed from: private */
    @NotNull
    public static GrowthTrackerRepo brazeGrowthTrackerRepoImpl;
    @NotNull
    private static Context context;
    /* access modifiers changed from: private */
    @NotNull
    public static GrowthTrackerRepo gaGrowthTrackerRepoImpl = new GAGrowthTrackerRepoImpl(context, (Cart) null, (TalabatGTM.Companion) null, 6, (DefaultConstructorMarker) null);
    private static boolean isGrowthTrackerEnabled = true;
    /* access modifiers changed from: private */
    @Nullable
    public static TalabatTracker talabatTracker;

    static {
        Application appContext = Integration.getAppContext();
        context = appContext;
        brazeGrowthTrackerRepoImpl = new BrazeGrowthTrackerRepoImpl(appContext, talabatTracker);
    }

    private GrowthTracker() {
    }

    public static /* synthetic */ void onVoucherRedeemed$default(GrowthTracker growthTracker, VoucherData voucherData, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        growthTracker.onVoucherRedeemed(voucherData, str, str2);
    }

    public static /* synthetic */ void onVoucherRemoved$default(GrowthTracker growthTracker, String str, String str2, float f11, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        growthTracker.onVoucherRemoved(str, str2, f11, str3);
    }

    private final void trackerEnabled(Function0<Unit> function0) {
        if (isGrowthTrackerEnabled) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void voucherFailToApply$default(GrowthTracker growthTracker, String str, String str2, String str3, String str4, Float f11, String str5, String str6, int i11, Object obj) {
        growthTracker.voucherFailToApply((i11 & 1) != 0 ? null : str, str2, str3, str4, (i11 & 16) != 0 ? null : f11, (i11 & 32) != 0 ? null : str5, (i11 & 64) != 0 ? null : str6);
    }

    public final void enableTracker(boolean z11) {
        isGrowthTrackerEnabled = z11;
    }

    public final void onRedeemPointsCompleted(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull RedeemEventParams.ScreenType screenType, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, Param.POINTS);
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(screenType, "screenType");
        Intrinsics.checkNotNullParameter(str4, "offerVoucherId");
        trackerEnabled(new GrowthTracker$onRedeemPointsCompleted$1(str, str2, str3, screenType, str4));
    }

    public final void onRedeemVoucherClicked(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull RedeemEventParams.ScreenType screenType, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, Param.POINTS);
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(screenType, "screenType");
        Intrinsics.checkNotNullParameter(str4, "offerVoucherId");
        trackerEnabled(new GrowthTracker$onRedeemVoucherClicked$1(str, str2, str3, screenType, str4));
    }

    public final void onRedeemVoucherFailed(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull RedeemEventParams.ScreenType screenType, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "reason");
        Intrinsics.checkNotNullParameter(screenType, "screenType");
        Intrinsics.checkNotNullParameter(str4, "offerVoucherId");
        trackerEnabled(new GrowthTracker$onRedeemVoucherFailed$1(str, str2, screenType, str4, str3));
    }

    public final void onRewardsScreenLoaded() {
        trackerEnabled(GrowthTracker$onRewardsScreenLoaded$1.INSTANCE);
    }

    public final void onVoucherRedeemed(@NotNull VoucherData voucherData, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(voucherData, "voucherData");
        trackerEnabled(new GrowthTracker$onVoucherRedeemed$1(voucherData, str2, str));
    }

    @JvmOverloads
    public final void onVoucherRemoved(@NotNull String str, float f11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "voucherCode");
        Intrinsics.checkNotNullParameter(str2, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        onVoucherRemoved$default(this, (String) null, str, f11, str2, 1, (Object) null);
    }

    @JvmOverloads
    public final void onVoucherRemoved(@Nullable String str, @NotNull String str2, float f11, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str2, "voucherCode");
        Intrinsics.checkNotNullParameter(str3, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        trackerEnabled(new GrowthTracker$onVoucherRemoved$1(str, str2, f11, str3));
    }

    @VisibleForTesting
    public final void setGrowthTrackerRepos(@NotNull GrowthTrackerRepo growthTrackerRepo, @NotNull GrowthTrackerRepo growthTrackerRepo2) {
        Intrinsics.checkNotNullParameter(growthTrackerRepo, "brazeRepo");
        Intrinsics.checkNotNullParameter(growthTrackerRepo2, "gaRepo");
        brazeGrowthTrackerRepoImpl = growthTrackerRepo;
        gaGrowthTrackerRepoImpl = growthTrackerRepo2;
    }

    @NotNull
    public final GrowthTracker setTalabatTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        talabatTracker = talabatTracker2;
        ((BrazeGrowthTrackerRepoImpl) brazeGrowthTrackerRepoImpl).setTalabatTracker(talabatTracker2);
        return this;
    }

    public final void trackObservability(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "featureName");
        Intrinsics.checkNotNullParameter(str2, "eventName");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        ObservabilityManager.track(str, str2, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("screenName", str3)));
    }

    public final void voucherEntryPointClicked(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "screenType");
        Intrinsics.checkNotNullParameter(str3, "navigationOption");
        trackerEnabled(new GrowthTracker$voucherEntryPointClicked$1(str3, str, str2));
    }

    public final void voucherEntryPointLoaded(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "screenType");
        Intrinsics.checkNotNullParameter(str3, "navigationOption");
        trackerEnabled(new GrowthTracker$voucherEntryPointLoaded$1(str3, str, str2));
    }

    public final void voucherFailToApply(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable Float f11, @Nullable String str5, @Nullable String str6) {
        Intrinsics.checkNotNullParameter(str2, "voucherCode");
        Intrinsics.checkNotNullParameter(str3, "errorMessage");
        Intrinsics.checkNotNullParameter(str4, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        String str7 = str5;
        String str8 = str6;
        String str9 = str;
        trackerEnabled(new GrowthTracker$voucherFailToApply$1(str7, str8, str9, str2, str4, f11, str3));
    }

    public final void voucherSuccessToApply(float f11, @NotNull VoucherData voucherData) {
        Intrinsics.checkNotNullParameter(voucherData, "voucherData");
        trackerEnabled(new GrowthTracker$voucherSuccessToApply$1(voucherData, f11));
    }

    public final void vouchersLoadedSuccess(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "vouchersIds");
        trackerEnabled(new GrowthTracker$vouchersLoadedSuccess$1(list));
    }
}
