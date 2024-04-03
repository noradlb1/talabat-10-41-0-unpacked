package com.talabat.feature.subscriptions.data.di;

import com.integration.IntegrationGlobalDataModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionsUserDataModule_ProvideGlobalDataModelFactory implements Factory<IntegrationGlobalDataModel.Companion> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SubscriptionsUserDataModule_ProvideGlobalDataModelFactory INSTANCE = new SubscriptionsUserDataModule_ProvideGlobalDataModelFactory();

        private InstanceHolder() {
        }
    }

    public static SubscriptionsUserDataModule_ProvideGlobalDataModelFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IntegrationGlobalDataModel.Companion provideGlobalDataModel() {
        return (IntegrationGlobalDataModel.Companion) Preconditions.checkNotNullFromProvides(SubscriptionsUserDataModule.INSTANCE.provideGlobalDataModel());
    }

    public IntegrationGlobalDataModel.Companion get() {
        return provideGlobalDataModel();
    }
}
