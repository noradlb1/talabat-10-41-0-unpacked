package com.talabat.flutter.groceryhome.presentation.handler;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.flutter.groceryhome.domain.usecase.GetClosestDarkstoreInfoUseCase;
import com.talabat.flutter.groceryhome.domain.usecase.GetMigratedVendorInfoUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GroceryHomeMethodHandlerFactoryImpl_Factory implements Factory<GroceryHomeMethodHandlerFactoryImpl> {
    private final Provider<GetClosestDarkstoreInfoUseCase> getClosestDarkstoreInfoUseCaseProvider;
    private final Provider<GetMigratedVendorInfoUseCase> getMigratedVendorInfoUseCaseProvider;
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public GroceryHomeMethodHandlerFactoryImpl_Factory(Provider<RxSchedulersFactory> provider, Provider<ITalabatExperiment> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<GetClosestDarkstoreInfoUseCase> provider4, Provider<GetMigratedVendorInfoUseCase> provider5) {
        this.rxSchedulersFactoryProvider = provider;
        this.talabatExperimentProvider = provider2;
        this.talabatFeatureFlagProvider = provider3;
        this.getClosestDarkstoreInfoUseCaseProvider = provider4;
        this.getMigratedVendorInfoUseCaseProvider = provider5;
    }

    public static GroceryHomeMethodHandlerFactoryImpl_Factory create(Provider<RxSchedulersFactory> provider, Provider<ITalabatExperiment> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<GetClosestDarkstoreInfoUseCase> provider4, Provider<GetMigratedVendorInfoUseCase> provider5) {
        return new GroceryHomeMethodHandlerFactoryImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static GroceryHomeMethodHandlerFactoryImpl newInstance(RxSchedulersFactory rxSchedulersFactory, ITalabatExperiment iTalabatExperiment, ITalabatFeatureFlag iTalabatFeatureFlag, GetClosestDarkstoreInfoUseCase getClosestDarkstoreInfoUseCase, GetMigratedVendorInfoUseCase getMigratedVendorInfoUseCase) {
        return new GroceryHomeMethodHandlerFactoryImpl(rxSchedulersFactory, iTalabatExperiment, iTalabatFeatureFlag, getClosestDarkstoreInfoUseCase, getMigratedVendorInfoUseCase);
    }

    public GroceryHomeMethodHandlerFactoryImpl get() {
        return newInstance(this.rxSchedulersFactoryProvider.get(), this.talabatExperimentProvider.get(), this.talabatFeatureFlagProvider.get(), this.getClosestDarkstoreInfoUseCaseProvider.get(), this.getMigratedVendorInfoUseCaseProvider.get());
    }
}
