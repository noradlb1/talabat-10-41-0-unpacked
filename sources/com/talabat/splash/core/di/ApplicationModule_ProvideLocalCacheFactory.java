package com.talabat.splash.core.di;

import com.talabat.splash.data.local.LocalCache;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideLocalCacheFactory implements Factory<LocalCache> {
    private final ApplicationModule module;

    public ApplicationModule_ProvideLocalCacheFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideLocalCacheFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideLocalCacheFactory(applicationModule);
    }

    public static LocalCache provideLocalCache(ApplicationModule applicationModule) {
        return (LocalCache) Preconditions.checkNotNullFromProvides(applicationModule.provideLocalCache());
    }

    public LocalCache get() {
        return provideLocalCache(this.module);
    }
}
