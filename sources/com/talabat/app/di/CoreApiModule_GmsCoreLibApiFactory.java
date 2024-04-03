package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_GmsCoreLibApiFactory implements Factory<Api> {
    private final Provider<GmsBaseCoreLibApi> gmsBaseCoreLibApiProvider;

    public CoreApiModule_GmsCoreLibApiFactory(Provider<GmsBaseCoreLibApi> provider) {
        this.gmsBaseCoreLibApiProvider = provider;
    }

    public static CoreApiModule_GmsCoreLibApiFactory create(Provider<GmsBaseCoreLibApi> provider) {
        return new CoreApiModule_GmsCoreLibApiFactory(provider);
    }

    public static Api gmsCoreLibApi(GmsBaseCoreLibApi gmsBaseCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.gmsCoreLibApi(gmsBaseCoreLibApi));
    }

    public Api get() {
        return gmsCoreLibApi(this.gmsBaseCoreLibApiProvider.get());
    }
}
