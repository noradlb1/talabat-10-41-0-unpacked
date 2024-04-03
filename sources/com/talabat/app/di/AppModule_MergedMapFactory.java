package com.talabat.app.di;

import com.talabat.core.di.Api;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Map;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.app.di.CoreApis", "com.talabat.app.di.FeatureApis"})
public final class AppModule_MergedMapFactory implements Factory<Map<Class<?>, Provider<Api>>> {
    private final Provider<Map<Class<?>, Provider<Api>>> coreApisProvider;
    private final Provider<Map<Class<?>, Provider<Api>>> featureApisProvider;

    public AppModule_MergedMapFactory(Provider<Map<Class<?>, Provider<Api>>> provider, Provider<Map<Class<?>, Provider<Api>>> provider2) {
        this.coreApisProvider = provider;
        this.featureApisProvider = provider2;
    }

    public static AppModule_MergedMapFactory create(Provider<Map<Class<?>, Provider<Api>>> provider, Provider<Map<Class<?>, Provider<Api>>> provider2) {
        return new AppModule_MergedMapFactory(provider, provider2);
    }

    public static Map<Class<?>, Provider<Api>> mergedMap(Map<Class<?>, Provider<Api>> map, Map<Class<?>, Provider<Api>> map2) {
        return (Map) Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.mergedMap(map, map2));
    }

    public Map<Class<?>, Provider<Api>> get() {
        return mergedMap(this.coreApisProvider.get(), this.featureApisProvider.get());
    }
}
