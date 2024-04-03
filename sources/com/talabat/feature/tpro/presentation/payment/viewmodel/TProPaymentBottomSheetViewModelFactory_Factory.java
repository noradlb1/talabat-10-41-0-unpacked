package com.talabat.feature.tpro.presentation.payment.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TProPaymentBottomSheetViewModelFactory_Factory implements Factory<TProPaymentBottomSheetViewModelFactory> {
    private final Provider<TProPaymentBottomSheetViewModel> providerProvider;

    public TProPaymentBottomSheetViewModelFactory_Factory(Provider<TProPaymentBottomSheetViewModel> provider) {
        this.providerProvider = provider;
    }

    public static TProPaymentBottomSheetViewModelFactory_Factory create(Provider<TProPaymentBottomSheetViewModel> provider) {
        return new TProPaymentBottomSheetViewModelFactory_Factory(provider);
    }

    public static TProPaymentBottomSheetViewModelFactory newInstance(Provider<TProPaymentBottomSheetViewModel> provider) {
        return new TProPaymentBottomSheetViewModelFactory(provider);
    }

    public TProPaymentBottomSheetViewModelFactory get() {
        return newInstance(this.providerProvider);
    }
}
