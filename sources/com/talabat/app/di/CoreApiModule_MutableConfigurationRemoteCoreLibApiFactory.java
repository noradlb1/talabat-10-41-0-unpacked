package com.talabat.app.di;

import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
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
public final class CoreApiModule_MutableConfigurationRemoteCoreLibApiFactory implements Factory<Api> {
    private final Provider<MutableConfigurationRemoteCoreLibApi> mutableConfigurationRemoteCoreLibApiProvider;

    public CoreApiModule_MutableConfigurationRemoteCoreLibApiFactory(Provider<MutableConfigurationRemoteCoreLibApi> provider) {
        this.mutableConfigurationRemoteCoreLibApiProvider = provider;
    }

    public static CoreApiModule_MutableConfigurationRemoteCoreLibApiFactory create(Provider<MutableConfigurationRemoteCoreLibApi> provider) {
        return new CoreApiModule_MutableConfigurationRemoteCoreLibApiFactory(provider);
    }

    public static Api mutableConfigurationRemoteCoreLibApi(MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.mutableConfigurationRemoteCoreLibApi(mutableConfigurationRemoteCoreLibApi));
    }

    public Api get() {
        return mutableConfigurationRemoteCoreLibApi(this.mutableConfigurationRemoteCoreLibApiProvider.get());
    }
}
