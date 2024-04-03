package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.perseus.domain.TalabatPerseusCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_PerseusCoreLibApiFactory implements Factory<Api> {
    private final Provider<TalabatPerseusCoreLibApi> perseusCoreLibApiProvider;

    public CoreApiModule_PerseusCoreLibApiFactory(Provider<TalabatPerseusCoreLibApi> provider) {
        this.perseusCoreLibApiProvider = provider;
    }

    public static CoreApiModule_PerseusCoreLibApiFactory create(Provider<TalabatPerseusCoreLibApi> provider) {
        return new CoreApiModule_PerseusCoreLibApiFactory(provider);
    }

    public static Api perseusCoreLibApi(TalabatPerseusCoreLibApi talabatPerseusCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.perseusCoreLibApi(talabatPerseusCoreLibApi));
    }

    public Api get() {
        return perseusCoreLibApi(this.perseusCoreLibApiProvider.get());
    }
}
