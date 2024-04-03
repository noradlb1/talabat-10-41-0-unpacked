package com.talabat.splash.core.di;

import android.content.Context;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.user.address.domain.usecases.RetrieveAndCacheCustomerAddressesUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvidesRetrieveAndCacheCustomerAddressesUseCaseFactory implements Factory<RetrieveAndCacheCustomerAddressesUseCase> {
    private final Provider<Context> contextProvider;
    private final ApplicationModule module;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public ApplicationModule_ProvidesRetrieveAndCacheCustomerAddressesUseCaseFactory(ApplicationModule applicationModule, Provider<Context> provider, Provider<ITalabatFeatureFlag> provider2) {
        this.module = applicationModule;
        this.contextProvider = provider;
        this.talabatFeatureFlagProvider = provider2;
    }

    public static ApplicationModule_ProvidesRetrieveAndCacheCustomerAddressesUseCaseFactory create(ApplicationModule applicationModule, Provider<Context> provider, Provider<ITalabatFeatureFlag> provider2) {
        return new ApplicationModule_ProvidesRetrieveAndCacheCustomerAddressesUseCaseFactory(applicationModule, provider, provider2);
    }

    public static RetrieveAndCacheCustomerAddressesUseCase providesRetrieveAndCacheCustomerAddressesUseCase(ApplicationModule applicationModule, Context context, ITalabatFeatureFlag iTalabatFeatureFlag) {
        return (RetrieveAndCacheCustomerAddressesUseCase) Preconditions.checkNotNullFromProvides(applicationModule.providesRetrieveAndCacheCustomerAddressesUseCase(context, iTalabatFeatureFlag));
    }

    public RetrieveAndCacheCustomerAddressesUseCase get() {
        return providesRetrieveAndCacheCustomerAddressesUseCase(this.module, this.contextProvider.get(), this.talabatFeatureFlagProvider.get());
    }
}
