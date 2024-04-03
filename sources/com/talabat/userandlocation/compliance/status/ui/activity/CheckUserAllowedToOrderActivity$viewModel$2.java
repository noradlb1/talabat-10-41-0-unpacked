package com.talabat.userandlocation.compliance.status.ui.activity;

import com.talabat.userandlocation.compliance.status.di.factory.CheckUserAllowedToOrderViewModelFactory;
import com.talabat.userandlocation.compliance.status.presentation.viewmodel.CheckUserAllowedToOrderViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/userandlocation/compliance/status/presentation/viewmodel/CheckUserAllowedToOrderViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CheckUserAllowedToOrderActivity$viewModel$2 extends Lambda implements Function0<CheckUserAllowedToOrderViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CheckUserAllowedToOrderActivity f12303g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckUserAllowedToOrderActivity$viewModel$2(CheckUserAllowedToOrderActivity checkUserAllowedToOrderActivity) {
        super(0);
        this.f12303g = checkUserAllowedToOrderActivity;
    }

    @NotNull
    public final CheckUserAllowedToOrderViewModel invoke() {
        return CheckUserAllowedToOrderViewModelFactory.Companion.create(this.f12303g);
    }
}
