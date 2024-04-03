package com.talabat.feature.tpro.presentation.helperview.mov;

import com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class VendorMovViewModel_Factory implements Factory<VendorMovViewModel> {
    private final Provider<GetTProVendorMovUseCase> getProMovUseCaseProvider;
    private final Provider<Boolean> isNfvFlagEnabledProvider;
    private final Provider<Boolean> isTProUserProvider;
    private final Provider<Float> tProPlanMovProvider;

    public VendorMovViewModel_Factory(Provider<GetTProVendorMovUseCase> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Float> provider4) {
        this.getProMovUseCaseProvider = provider;
        this.isNfvFlagEnabledProvider = provider2;
        this.isTProUserProvider = provider3;
        this.tProPlanMovProvider = provider4;
    }

    public static VendorMovViewModel_Factory create(Provider<GetTProVendorMovUseCase> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Float> provider4) {
        return new VendorMovViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static VendorMovViewModel newInstance(GetTProVendorMovUseCase getTProVendorMovUseCase, Provider<Boolean> provider, boolean z11, float f11) {
        return new VendorMovViewModel(getTProVendorMovUseCase, provider, z11, f11);
    }

    public VendorMovViewModel get() {
        return newInstance(this.getProMovUseCaseProvider.get(), this.isNfvFlagEnabledProvider, this.isTProUserProvider.get().booleanValue(), this.tProPlanMovProvider.get().floatValue());
    }
}
