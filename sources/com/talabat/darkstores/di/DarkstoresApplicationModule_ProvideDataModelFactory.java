package com.talabat.darkstores.di;

import com.integration.IntegrationGlobalDataModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresApplicationModule_ProvideDataModelFactory implements Factory<IntegrationGlobalDataModel.Companion> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresApplicationModule_ProvideDataModelFactory INSTANCE = new DarkstoresApplicationModule_ProvideDataModelFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresApplicationModule_ProvideDataModelFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IntegrationGlobalDataModel.Companion provideDataModel() {
        return (IntegrationGlobalDataModel.Companion) Preconditions.checkNotNullFromProvides(DarkstoresApplicationModule.INSTANCE.provideDataModel());
    }

    public IntegrationGlobalDataModel.Companion get() {
        return provideDataModel();
    }
}
