package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import com.integration.IntegrationGlobalDataModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ApplyVoucherViewModelBuilder$getApplyVoucherViewModel$1 extends Lambda implements Function0<Integer> {
    public static final ApplyVoucherViewModelBuilder$getApplyVoucherViewModel$1 INSTANCE = new ApplyVoucherViewModelBuilder$getApplyVoucherViewModel$1();

    public ApplyVoucherViewModelBuilder$getApplyVoucherViewModel$1() {
        super(0);
    }

    @NotNull
    public final Integer invoke() {
        return Integer.valueOf(IntegrationGlobalDataModel.Companion.selectedCountryCode());
    }
}
