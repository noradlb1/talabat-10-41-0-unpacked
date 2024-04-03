package com.talabat.app.di;

import com.talabat.core.di.Api;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis"})
public final class CoreApiModule_NavigationCoreLibApiFactory implements Factory<Api> {
    private final Provider<NavigationCoreLibApi> navigationCoreLibApiProvider;

    public CoreApiModule_NavigationCoreLibApiFactory(Provider<NavigationCoreLibApi> provider) {
        this.navigationCoreLibApiProvider = provider;
    }

    public static CoreApiModule_NavigationCoreLibApiFactory create(Provider<NavigationCoreLibApi> provider) {
        return new CoreApiModule_NavigationCoreLibApiFactory(provider);
    }

    public static Api navigationCoreLibApi(NavigationCoreLibApi navigationCoreLibApi) {
        return (Api) Preconditions.checkNotNullFromProvides(CoreApiModule.INSTANCE.navigationCoreLibApi(navigationCoreLibApi));
    }

    public Api get() {
        return navigationCoreLibApi(this.navigationCoreLibApiProvider.get());
    }
}
