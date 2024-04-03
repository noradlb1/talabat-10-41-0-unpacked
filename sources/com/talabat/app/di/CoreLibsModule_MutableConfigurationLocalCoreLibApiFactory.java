package com.talabat.app.di;

import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_MutableConfigurationLocalCoreLibApiFactory implements Factory<MutableConfigurationLocalCoreLibApi> {
    private final CoreLibsModule module;

    public CoreLibsModule_MutableConfigurationLocalCoreLibApiFactory(CoreLibsModule coreLibsModule) {
        this.module = coreLibsModule;
    }

    public static CoreLibsModule_MutableConfigurationLocalCoreLibApiFactory create(CoreLibsModule coreLibsModule) {
        return new CoreLibsModule_MutableConfigurationLocalCoreLibApiFactory(coreLibsModule);
    }

    public static MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi(CoreLibsModule coreLibsModule) {
        return (MutableConfigurationLocalCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.mutableConfigurationLocalCoreLibApi());
    }

    public MutableConfigurationLocalCoreLibApi get() {
        return mutableConfigurationLocalCoreLibApi(this.module);
    }
}
