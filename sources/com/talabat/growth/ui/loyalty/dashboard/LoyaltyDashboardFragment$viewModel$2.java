package com.talabat.growth.ui.loyalty.dashboard;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.talabat.growth.ui.loyalty.dashboard.viewModel.LoyaltyDashboardViewModel;
import com.talabat.growth.ui.loyalty.dashboard.viewModel.LoyaltyDashboardViewModelBuilder;
import com.talabat.talabatcore.testframework.ViewModelInjectorKt;
import com.talabat.talabatcore.viewmodel.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/growth/ui/loyalty/dashboard/viewModel/LoyaltyDashboardViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardFragment$viewModel$2 extends Lambda implements Function0<LoyaltyDashboardViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LoyaltyDashboardFragment f60656g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoyaltyDashboardFragment$viewModel$2(LoyaltyDashboardFragment loyaltyDashboardFragment) {
        super(0);
        this.f60656g = loyaltyDashboardFragment;
    }

    @NotNull
    public final LoyaltyDashboardViewModel invoke() {
        final LoyaltyDashboardFragment loyaltyDashboardFragment = this.f60656g;
        return (LoyaltyDashboardViewModel) ViewModelInjectorKt.injectViewModel((Fragment) loyaltyDashboardFragment, LoyaltyDashboardViewModel.class, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<LoyaltyDashboardViewModel>() {
            @NotNull
            public final LoyaltyDashboardViewModel invoke() {
                LoyaltyDashboardViewModelBuilder.Companion companion = LoyaltyDashboardViewModelBuilder.Companion;
                Context requireContext = loyaltyDashboardFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                return companion.getLoyaltyDashboardViewModel(requireContext, loyaltyDashboardFragment.coroutineScope, loyaltyDashboardFragment.getFeatureFlagRepository(), loyaltyDashboardFragment.getLocationConfigurationRepository(), loyaltyDashboardFragment.getConfigurationLocalRepository());
            }
        }));
    }
}
