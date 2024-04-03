package com.talabat.wallet.bnplmanager.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.wallet.bnplmanager.data.local.BNPLManagerLocalDataSourceImpl;
import com.talabat.wallet.bnplmanager.di.factory.BNPLManagerViewModelFactory;
import com.talabat.wallet.bnplmanager.presentation.viewmodel.BNPLManagerViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/wallet/bnplmanager/presentation/viewmodel/BNPLManagerViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BNPLInitiatePlaceOrderFragment$viewModel$2 extends Lambda implements Function0<BNPLManagerViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BNPLInitiatePlaceOrderFragment f12509g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BNPLInitiatePlaceOrderFragment$viewModel$2(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment) {
        super(0);
        this.f12509g = bNPLInitiatePlaceOrderFragment;
    }

    @NotNull
    public final BNPLManagerViewModel invoke() {
        BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment = this.f12509g;
        BNPLManagerViewModelFactory.Companion companion = BNPLManagerViewModelFactory.Companion;
        FragmentActivity requireActivity = bNPLInitiatePlaceOrderFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return (BNPLManagerViewModel) ViewModelProviders.of((Fragment) bNPLInitiatePlaceOrderFragment, (ViewModelProvider.Factory) companion.create(requireActivity, this.f12509g.getFeatureFlagRepository(), this.f12509g.getObservabilityManager(), this.f12509g.getConfigurationLocalRepository(), this.f12509g.getLocationConfigurationRepository(), new BNPLManagerLocalDataSourceImpl())).get(BNPLManagerViewModel.class);
    }
}
