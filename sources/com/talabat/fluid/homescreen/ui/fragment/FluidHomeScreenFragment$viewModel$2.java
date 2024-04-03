package com.talabat.fluid.homescreen.ui.fragment;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.talabat.fluid.homescreen.di.factory.FluidHomeScreenViewModelFactory;
import com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/fluid/homescreen/presentation/viewmodel/FluidHomeScreenViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenFragment$viewModel$2 extends Lambda implements Function0<FluidHomeScreenViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FluidHomeScreenFragment f59750g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidHomeScreenFragment$viewModel$2(FluidHomeScreenFragment fluidHomeScreenFragment) {
        super(0);
        this.f59750g = fluidHomeScreenFragment;
    }

    @NotNull
    public final FluidHomeScreenViewModel invoke() {
        FragmentActivity requireActivity = this.f59750g.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        FluidHomeScreenViewModelFactory.Companion companion = FluidHomeScreenViewModelFactory.Companion;
        Context requireContext = this.f59750g.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return (FluidHomeScreenViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity, (ViewModelProvider.Factory) companion.newInstance(requireContext, this.f59750g.getConfigurationLocalRepository(), this.f59750g.getTalabatFeatureFlag(), this.f59750g.getObservabilityManager(), this.f59750g.getTalabatTracker(), this.f59750g.getParseConfig(), this.f59750g.getCampaignCacheUseCase(), this.f59750g.getCampaignMigratorSharedPreferences(), this.f59750g.getScreenTracker(), this.f59750g.getHomeScreenPerformanceObservability())).get(FluidHomeScreenViewModel.class);
    }
}
