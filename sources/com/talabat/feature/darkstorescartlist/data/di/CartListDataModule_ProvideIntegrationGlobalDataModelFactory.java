package com.talabat.feature.darkstorescartlist.data.di;

import com.integration.IntegrationGlobalDataModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartListDataModule_ProvideIntegrationGlobalDataModelFactory implements Factory<IntegrationGlobalDataModel.Companion> {
    private final CartListDataModule module;

    public CartListDataModule_ProvideIntegrationGlobalDataModelFactory(CartListDataModule cartListDataModule) {
        this.module = cartListDataModule;
    }

    public static CartListDataModule_ProvideIntegrationGlobalDataModelFactory create(CartListDataModule cartListDataModule) {
        return new CartListDataModule_ProvideIntegrationGlobalDataModelFactory(cartListDataModule);
    }

    public static IntegrationGlobalDataModel.Companion provideIntegrationGlobalDataModel(CartListDataModule cartListDataModule) {
        return (IntegrationGlobalDataModel.Companion) Preconditions.checkNotNullFromProvides(cartListDataModule.provideIntegrationGlobalDataModel());
    }

    public IntegrationGlobalDataModel.Companion get() {
        return provideIntegrationGlobalDataModel(this.module);
    }
}
