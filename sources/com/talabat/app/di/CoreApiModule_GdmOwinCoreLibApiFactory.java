package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.gdm.owin.domain.GdmOwinTokenApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_GdmOwinCoreLibApiFactory implements Factory<Api> {
    private final Provider<GdmOwinTokenApi> gdmOwinTokenApiProvider;

    public CoreApiModule_GdmOwinCoreLibApiFactory(Provider<GdmOwinTokenApi> provider) {
        this.gdmOwinTokenApiProvider = provider;
    }

    public static CoreApiModule_GdmOwinCoreLibApiFactory create(Provider<GdmOwinTokenApi> provider) {
        return new CoreApiModule_GdmOwinCoreLibApiFactory(provider);
    }

    public static Api gdmOwinCoreLibApi(GdmOwinTokenApi gdmOwinTokenApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.gdmOwinCoreLibApi(gdmOwinTokenApi));
    }

    public Api get() {
        return gdmOwinCoreLibApi(this.gdmOwinTokenApiProvider.get());
    }
}
