package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ApplyVoucherViewModelImpl$checkApplyVoucherFeaturesEnabled$1$isLoyaltyVoucherEnabled$1 extends Lambda implements Function0<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ApplyVoucherViewModelImpl f11798g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f11799h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f11800i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVoucherViewModelImpl$checkApplyVoucherFeaturesEnabled$1$isLoyaltyVoucherEnabled$1(ApplyVoucherViewModelImpl applyVoucherViewModelImpl, boolean z11, boolean z12) {
        super(0);
        this.f11798g = applyVoucherViewModelImpl;
        this.f11799h = z11;
        this.f11800i = z12;
    }

    @NotNull
    public final Boolean invoke() {
        boolean z11;
        if (this.f11798g.isDarkStore()) {
            z11 = this.f11799h;
        } else {
            z11 = this.f11800i;
        }
        return Boolean.valueOf(z11);
    }
}
