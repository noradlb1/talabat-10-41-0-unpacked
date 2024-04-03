package com.talabat.app.di;

import com.talabat.core.context.domain.ContextCoreLibApi;
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
public final class CoreApiModule_ContextCoreLibApiFactory implements Factory<Api> {
    private final Provider<ContextCoreLibApi> contextCoreLibApiProvider;

    public CoreApiModule_ContextCoreLibApiFactory(Provider<ContextCoreLibApi> provider) {
        this.contextCoreLibApiProvider = provider;
    }

    public static Api contextCoreLibApi(ContextCoreLibApi contextCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.contextCoreLibApi(contextCoreLibApi));
    }

    public static CoreApiModule_ContextCoreLibApiFactory create(Provider<ContextCoreLibApi> provider) {
        return new CoreApiModule_ContextCoreLibApiFactory(provider);
    }

    public Api get() {
        return contextCoreLibApi(this.contextCoreLibApiProvider.get());
    }
}
