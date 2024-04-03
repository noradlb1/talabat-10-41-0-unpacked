package com.talabat.core.featureflag.domain.flags.flagskeys;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GrowthFeatureFlagConstantKt$GrowthFlags$1 extends Lambda implements Function0<List<? extends FWFKey>> {
    public static final GrowthFeatureFlagConstantKt$GrowthFlags$1 INSTANCE = new GrowthFeatureFlagConstantKt$GrowthFlags$1();

    public GrowthFeatureFlagConstantKt$GrowthFlags$1() {
        super(0);
    }

    @NotNull
    public final List<FWFKey> invoke() {
        TalabatCountryAbbreviation[] values = TalabatCountryAbbreviation.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (TalabatCountryAbbreviation countryId : values) {
            arrayList.add(GrowthFeatureFlagConstantKt.FunWithFlagEnableBasketVouchersKey.invoke(Integer.valueOf(countryId.getCountryId())));
        }
        TalabatCountryAbbreviation[] values2 = TalabatCountryAbbreviation.values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (TalabatCountryAbbreviation countryId2 : values2) {
            arrayList2.add(GrowthFeatureFlagConstantKt.FunWithFlagEnableTmartVouchersKey.invoke(Integer.valueOf(countryId2.getCountryId())));
        }
        Collection plus = CollectionsKt___CollectionsKt.plus(arrayList, arrayList2);
        TalabatCountryAbbreviation[] values3 = TalabatCountryAbbreviation.values();
        ArrayList arrayList3 = new ArrayList(values3.length);
        for (TalabatCountryAbbreviation countryId3 : values3) {
            arrayList3.add(GrowthFeatureFlagConstantKt.FunWithFlagEnableVoucherCodesKey.invoke(Integer.valueOf(countryId3.getCountryId())));
        }
        return CollectionsKt___CollectionsKt.plus(CollectionsKt___CollectionsKt.plus(CollectionsKt___CollectionsKt.plus(CollectionsKt___CollectionsKt.plus(CollectionsKt___CollectionsKt.plus(CollectionsKt___CollectionsKt.plus(CollectionsKt___CollectionsKt.plus(plus, arrayList3), GrowthFeatureFlagConstantKt.FunWithFlagEnableRedeemVoucherBottomSheet), CollectionsKt__CollectionsKt.arrayListOf(GrowthFeatureFlagConstantKt.FunWithFlagEnableLoginLifecycleVoucher, GrowthFeatureFlagConstantKt.FunWithFlagEnableHomeLifecycleVoucher)), GrowthFeatureFlagConstantKt.FunWithFlagSideMenuVoucherCount), GrowthFeatureFlagConstantKt.FunWithFlagsEnableFreeDeliveryTypeVoucher), GrowthFeatureFlagConstantKt.FunWithFlagsEnableCompoundingStackedIncentives), GrowthFeatureFlagConstantKt.FunWithFlagsEnableBinRestrictionForAppliedVoucher);
    }
}
