package com.talabat.core.featureflag.domain.flags.flagskeys;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\"+\u0010\u0000\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00018\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000\"+\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00018\u0006X\u0004¢\u0006\u0002\n\u0000\"+\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u00018\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\r\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000f\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000\"\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"FunWithFlagEnableBasketVouchersKey", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "countryId", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "FunWithFlagEnableHomeLifecycleVoucher", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "FunWithFlagEnableLoginLifecycleVoucher", "FunWithFlagEnableRedeemVoucherBottomSheet", "FunWithFlagEnableTmartVouchersKey", "FunWithFlagEnableVoucherCodesKey", "FunWithFlagSideMenuVoucherCount", "FunWithFlagsEnableBinRestrictionForAppliedVoucher", "FunWithFlagsEnableCompoundingStackedIncentives", "FunWithFlagsEnableFreeDeliveryTypeVoucher", "GrowthFlags", "Lkotlin/Function0;", "", "getGrowthFlags", "()Lkotlin/jvm/functions/Function0;", "com_talabat_core_feature-flag_domain_domain"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GrowthFeatureFlagConstantKt {
    @NotNull
    @JvmField
    public static final Function1<Integer, FWFKey> FunWithFlagEnableBasketVouchersKey = GrowthFeatureFlagConstantKt$FunWithFlagEnableBasketVouchersKey$1.INSTANCE;
    @NotNull
    @JvmField
    public static final FWFKeyObject FunWithFlagEnableHomeLifecycleVoucher = new FWFKeyObject("home-lifecycle-voucher", (FWFProjectName) null, 2, (DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final FWFKeyObject FunWithFlagEnableLoginLifecycleVoucher = new FWFKeyObject("login-lifecycle-voucher", (FWFProjectName) null, 2, (DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final FWFKeyObject FunWithFlagEnableRedeemVoucherBottomSheet = new FWFKeyObject("redeem-voucher-bottom-sheet", (FWFProjectName) null, 2, (DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final Function1<Integer, FWFKey> FunWithFlagEnableTmartVouchersKey = GrowthFeatureFlagConstantKt$FunWithFlagEnableTmartVouchersKey$1.INSTANCE;
    @NotNull
    @JvmField
    public static final Function1<Integer, FWFKey> FunWithFlagEnableVoucherCodesKey = GrowthFeatureFlagConstantKt$FunWithFlagEnableVoucherCodesKey$1.INSTANCE;
    @NotNull
    @JvmField
    public static final FWFKeyObject FunWithFlagSideMenuVoucherCount = new FWFKeyObject("sidemenu-vouchers-count", (FWFProjectName) null, 2, (DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final FWFKeyObject FunWithFlagsEnableBinRestrictionForAppliedVoucher = new FWFKeyObject("is-bin-restriction-for-applied-voucher-enabled", (FWFProjectName) null, 2, (DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final FWFKeyObject FunWithFlagsEnableCompoundingStackedIncentives = new FWFKeyObject("is-compounding-stacked-incentives-enabled", (FWFProjectName) null, 2, (DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final FWFKeyObject FunWithFlagsEnableFreeDeliveryTypeVoucher = new FWFKeyObject("free-delivery-voucher", (FWFProjectName) null, 2, (DefaultConstructorMarker) null);
    @NotNull
    private static final Function0<List<FWFKey>> GrowthFlags = GrowthFeatureFlagConstantKt$GrowthFlags$1.INSTANCE;

    @NotNull
    public static final Function0<List<FWFKey>> getGrowthFlags() {
        return GrowthFlags;
    }
}
