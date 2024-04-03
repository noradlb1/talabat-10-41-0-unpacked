package com.talabat.app.di;

import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CoreLibsModule_NavigationCoreLibApiFactory implements Factory<NavigationCoreLibApi> {
    private final CoreLibsModule module;

    public CoreLibsModule_NavigationCoreLibApiFactory(CoreLibsModule coreLibsModule) {
        this.module = coreLibsModule;
    }

    public static CoreLibsModule_NavigationCoreLibApiFactory create(CoreLibsModule coreLibsModule) {
        return new CoreLibsModule_NavigationCoreLibApiFactory(coreLibsModule);
    }

    public static NavigationCoreLibApi navigationCoreLibApi(CoreLibsModule coreLibsModule) {
        return (NavigationCoreLibApi) Preconditions.checkNotNullFromProvides(coreLibsModule.navigationCoreLibApi());
    }

    public NavigationCoreLibApi get() {
        return navigationCoreLibApi(this.module);
    }
}
