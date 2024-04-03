package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_HmsCoreLibApiFactory implements Factory<Api> {
    private final Provider<HmsBaseCoreLibApi> hmsBaseCoreLibApiProvider;

    public CoreApiModule_HmsCoreLibApiFactory(Provider<HmsBaseCoreLibApi> provider) {
        this.hmsBaseCoreLibApiProvider = provider;
    }

    public static CoreApiModule_HmsCoreLibApiFactory create(Provider<HmsBaseCoreLibApi> provider) {
        return new CoreApiModule_HmsCoreLibApiFactory(provider);
    }

    public static Api hmsCoreLibApi(HmsBaseCoreLibApi hmsBaseCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.hmsCoreLibApi(hmsBaseCoreLibApi));
    }

    public Api get() {
        return hmsCoreLibApi(this.hmsBaseCoreLibApiProvider.get());
    }
}
