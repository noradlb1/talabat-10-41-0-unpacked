package com.talabat.app.di;

import com.talabat.configuration.di.MutableConfigurationLocalCoreLibApi;
import com.talabat.core.di.Api;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_MutableConfigurationLocalCoreLibApiFactory implements Factory<Api> {
    private final Provider<MutableConfigurationLocalCoreLibApi> mutableConfigurationLocalCoreLibApiProvider;

    public CoreApiModule_MutableConfigurationLocalCoreLibApiFactory(Provider<MutableConfigurationLocalCoreLibApi> provider) {
        this.mutableConfigurationLocalCoreLibApiProvider = provider;
    }

    public static CoreApiModule_MutableConfigurationLocalCoreLibApiFactory create(Provider<MutableConfigurationLocalCoreLibApi> provider) {
        return new CoreApiModule_MutableConfigurationLocalCoreLibApiFactory(provider);
    }

    public static Api mutableConfigurationLocalCoreLibApi(MutableConfigurationLocalCoreLibApi mutableConfigurationLocalCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.mutableConfigurationLocalCoreLibApi(mutableConfigurationLocalCoreLibApi));
    }

    public Api get() {
        return mutableConfigurationLocalCoreLibApi(this.mutableConfigurationLocalCoreLibApiProvider.get());
    }
}
