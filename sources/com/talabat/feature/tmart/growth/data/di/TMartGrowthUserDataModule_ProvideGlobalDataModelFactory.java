package com.talabat.feature.tmart.growth.data.di;

import com.integration.IntegrationGlobalDataModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthUserDataModule_ProvideGlobalDataModelFactory implements Factory<IntegrationGlobalDataModel.Companion> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TMartGrowthUserDataModule_ProvideGlobalDataModelFactory INSTANCE = new TMartGrowthUserDataModule_ProvideGlobalDataModelFactory();

        private InstanceHolder() {
        }
    }

    public static TMartGrowthUserDataModule_ProvideGlobalDataModelFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IntegrationGlobalDataModel.Companion provideGlobalDataModel() {
        return (IntegrationGlobalDataModel.Companion) Preconditions.checkNotNullFromProvides(TMartGrowthUserDataModule.INSTANCE.provideGlobalDataModel());
    }

    public IntegrationGlobalDataModel.Companion get() {
        return provideGlobalDataModel();
    }
}
