package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import buisnessmodels.Cart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ApplyVoucherViewModelBuilderKt$getPossibleVouchersUseCase$1 extends Lambda implements Function0<Boolean> {
    public static final ApplyVoucherViewModelBuilderKt$getPossibleVouchersUseCase$1 INSTANCE = new ApplyVoucherViewModelBuilderKt$getPossibleVouchersUseCase$1();

    public ApplyVoucherViewModelBuilderKt$getPossibleVouchersUseCase$1() {
        super(0);
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(Cart.getInstance().isTProApplied());
    }
}
