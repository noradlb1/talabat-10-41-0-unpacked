package com.talabat.growth.ui.loyalty.burn.confirmation;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.talabat.growth.ui.loyalty.burn.burnConfirmation.viewModel.RedeemConfirmationViewModel;
import com.talabat.talabatcore.testframework.ViewModelInjectorKt;
import com.talabat.talabatcore.viewmodel.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RedeemConfirmationDialogFragment$viewModel$2 extends Lambda implements Function0<RedeemConfirmationViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RedeemConfirmationDialogFragment f60627g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedeemConfirmationDialogFragment$viewModel$2(RedeemConfirmationDialogFragment redeemConfirmationDialogFragment) {
        super(0);
        this.f60627g = redeemConfirmationDialogFragment;
    }

    @NotNull
    public final RedeemConfirmationViewModel invoke() {
        final RedeemConfirmationDialogFragment redeemConfirmationDialogFragment = this.f60627g;
        return (RedeemConfirmationViewModel) ViewModelInjectorKt.injectViewModel((Fragment) redeemConfirmationDialogFragment, RedeemConfirmationViewModel.class, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<RedeemConfirmationViewModel>() {
            @NotNull
            public final RedeemConfirmationViewModel invoke() {
                return RedeemConfirmationViewModel.Companion.getInstance(redeemConfirmationDialogFragment.getTalabatTracker(), redeemConfirmationDialogFragment.getRewardsTracker());
            }
        }));
    }
}
