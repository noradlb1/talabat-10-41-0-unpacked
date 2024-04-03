package com.talabat.app;

import com.talabat.core.di.Api;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import java.util.Map;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class App_MembersInjector implements MembersInjector<App> {
    private final Provider<Map<Class<?>, Provider<Api>>> mergedMapProvider;

    public App_MembersInjector(Provider<Map<Class<?>, Provider<Api>>> provider) {
        this.mergedMapProvider = provider;
    }

    public static MembersInjector<App> create(Provider<Map<Class<?>, Provider<Api>>> provider) {
        return new App_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.app.App.mergedMap")
    public static void injectMergedMap(App app, Map<Class<?>, Provider<Api>> map) {
        app.mergedMap = map;
    }

    public void injectMembers(App app) {
        injectMergedMap(app, this.mergedMapProvider.get());
    }
}
