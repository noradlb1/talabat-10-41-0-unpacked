package com.talabat.core.featureflag.domain.flags.flagskeys;

import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKeyObject;", "countryId", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GrowthFeatureFlagConstantKt$FunWithFlagEnableTmartVouchersKey$1 extends Lambda implements Function1<Integer, FWFKeyObject> {
    public static final GrowthFeatureFlagConstantKt$FunWithFlagEnableTmartVouchersKey$1 INSTANCE = new GrowthFeatureFlagConstantKt$FunWithFlagEnableTmartVouchersKey$1();

    public GrowthFeatureFlagConstantKt$FunWithFlagEnableTmartVouchersKey$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public final FWFKeyObject invoke(int i11) {
        String countryAbbreviation = TalabatCountryAbbreviation.Companion.getCountryAbbreviation(i11);
        return new FWFKeyObject("vouchers-andy-tmart_enabled-" + countryAbbreviation, (FWFProjectName) null, 2, (DefaultConstructorMarker) null);
    }
}
