package com.talabat.growth.ui.vouchers.details;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/growth/ui/vouchers/details/VoucherDetailsViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VoucherDetailsFragment$onViewCreated$1 extends Lambda implements Function0<VoucherDetailsViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VoucherDetailsFragment f60696g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoucherDetailsFragment$onViewCreated$1(VoucherDetailsFragment voucherDetailsFragment) {
        super(0);
        this.f60696g = voucherDetailsFragment;
    }

    @NotNull
    public final VoucherDetailsViewModel invoke() {
        Context requireContext = this.f60696g.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return VoucherDetailsViewModelBuilderKt.getVoucherDetailsViewModelBuilder(requireContext, this.f60696g.getObservabilityManager());
    }
}
