package com.talabat.app.di;

import com.talabat.authentication.aaa.di.SecretCoreLibApi;
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
public final class CoreApiModule_SecretCoreLibApiFactory implements Factory<Api> {
    private final Provider<SecretCoreLibApi> secretCoreLibApiProvider;

    public CoreApiModule_SecretCoreLibApiFactory(Provider<SecretCoreLibApi> provider) {
        this.secretCoreLibApiProvider = provider;
    }

    public static CoreApiModule_SecretCoreLibApiFactory create(Provider<SecretCoreLibApi> provider) {
        return new CoreApiModule_SecretCoreLibApiFactory(provider);
    }

    public static Api secretCoreLibApi(SecretCoreLibApi secretCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.secretCoreLibApi(secretCoreLibApi));
    }

    public Api get() {
        return secretCoreLibApi(this.secretCoreLibApiProvider.get());
    }
}
