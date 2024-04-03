package com.talabat.fragments;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.talabat.rating.domain.usecases.StarRatingFeatureToggleUseCase;
import com.talabat.rating.presentation.viewmodel.RateVendorViewModel;
import com.talabat.talabatcore.testframework.ViewModelInjectorKt;
import com.talabat.talabatcore.viewmodel.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/rating/presentation/viewmodel/RateVendorViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RateRestaurantFragment$viewModel$2 extends Lambda implements Function0<RateVendorViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RateRestaurantFragment f59815g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RateRestaurantFragment$viewModel$2(RateRestaurantFragment rateRestaurantFragment) {
        super(0);
        this.f59815g = rateRestaurantFragment;
    }

    @NotNull
    public final RateVendorViewModel invoke() {
        final RateRestaurantFragment rateRestaurantFragment = this.f59815g;
        return (RateVendorViewModel) ViewModelInjectorKt.injectViewModel((Fragment) rateRestaurantFragment, RateVendorViewModel.class, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<RateVendorViewModel>() {
            @NotNull
            public final RateVendorViewModel invoke() {
                return new RateVendorViewModel(rateRestaurantFragment.getTalabatFeatureFlag(), (StarRatingFeatureToggleUseCase) null, 2, (DefaultConstructorMarker) null);
            }
        }));
    }
}
