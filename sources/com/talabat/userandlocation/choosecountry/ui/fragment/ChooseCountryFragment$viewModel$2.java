package com.talabat.userandlocation.choosecountry.ui.fragment;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.talabat.userandlocation.choosecountry.di.factory.ChooseCountryViewModelFactory;
import com.talabat.userandlocation.choosecountry.presentation.viewmodel.ChooseCountryViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/userandlocation/choosecountry/presentation/viewmodel/ChooseCountryViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChooseCountryFragment$viewModel$2 extends Lambda implements Function0<ChooseCountryViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ChooseCountryFragment f12269g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChooseCountryFragment$viewModel$2(ChooseCountryFragment chooseCountryFragment) {
        super(0);
        this.f12269g = chooseCountryFragment;
    }

    @NotNull
    public final ChooseCountryViewModel invoke() {
        ChooseCountryFragment chooseCountryFragment = this.f12269g;
        ChooseCountryViewModelFactory.Companion companion = ChooseCountryViewModelFactory.Companion;
        FragmentActivity requireActivity = chooseCountryFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return (ChooseCountryViewModel) new ViewModelProvider((ViewModelStoreOwner) chooseCountryFragment, (ViewModelProvider.Factory) companion.newInstance(requireActivity)).get(ChooseCountryViewModel.class);
    }
}
