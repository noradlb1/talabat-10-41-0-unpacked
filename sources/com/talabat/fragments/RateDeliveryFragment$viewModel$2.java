package com.talabat.fragments;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.talabat.rating.domain.usecases.StarRatingFeatureToggleUseCase;
import com.talabat.rating.presentation.viewmodel.RateDeliveryViewModel;
import com.talabat.talabatcore.testframework.ViewModelInjectorKt;
import com.talabat.talabatcore.viewmodel.BaseViewModelFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/rating/presentation/viewmodel/RateDeliveryViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RateDeliveryFragment$viewModel$2 extends Lambda implements Function0<RateDeliveryViewModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RateDeliveryFragment f59809g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RateDeliveryFragment$viewModel$2(RateDeliveryFragment rateDeliveryFragment) {
        super(0);
        this.f59809g = rateDeliveryFragment;
    }

    @NotNull
    public final RateDeliveryViewModel invoke() {
        final RateDeliveryFragment rateDeliveryFragment = this.f59809g;
        return (RateDeliveryViewModel) ViewModelInjectorKt.injectViewModel((Fragment) rateDeliveryFragment, RateDeliveryViewModel.class, (ViewModelProvider.Factory) new BaseViewModelFactory(new Function0<RateDeliveryViewModel>() {
            @NotNull
            public final RateDeliveryViewModel invoke() {
                return new RateDeliveryViewModel(rateDeliveryFragment.getTalabatFeatureFlag(), (StarRatingFeatureToggleUseCase) null, 2, (DefaultConstructorMarker) null);
            }
        }));
    }
}
