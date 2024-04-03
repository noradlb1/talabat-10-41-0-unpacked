package com.talabat.growth.ui.loyalty.burn.details;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.viewModel.BurnOptionsDetailsViewModel;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.viewModel.BurnOptionsDetailsViewModelBuilder;
import com.talabat.talabatcore.testframework.ViewModelInjectorKt;
import com.talabat.talabatcore.viewmodel.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/viewModel/BurnOptionsDetailsViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionsDetailsDialogFragment$viewModel$2 extends Lambda implements Function0<BurnOptionsDetailsViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BurnOptionsDetailsDialogFragment f60635g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BurnOptionsDetailsDialogFragment$viewModel$2(BurnOptionsDetailsDialogFragment burnOptionsDetailsDialogFragment) {
        super(0);
        this.f60635g = burnOptionsDetailsDialogFragment;
    }

    @NotNull
    public final BurnOptionsDetailsViewModel invoke() {
        final BurnOptionsDetailsDialogFragment burnOptionsDetailsDialogFragment = this.f60635g;
        return (BurnOptionsDetailsViewModel) ViewModelInjectorKt.injectViewModel((Fragment) burnOptionsDetailsDialogFragment, BurnOptionsDetailsViewModel.class, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<BurnOptionsDetailsViewModel>() {
            @NotNull
            public final BurnOptionsDetailsViewModel invoke() {
                BurnOptionsDetailsViewModelBuilder.Companion companion = BurnOptionsDetailsViewModelBuilder.Companion;
                Context requireContext = burnOptionsDetailsDialogFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return companion.getBurnOptionsDetailsViewModel(requireContext, burnOptionsDetailsDialogFragment.getTalabatTracker(), burnOptionsDetailsDialogFragment.getConfigurationLocalRepository(), burnOptionsDetailsDialogFragment.coroutineScope);
            }
        }));
    }
}
