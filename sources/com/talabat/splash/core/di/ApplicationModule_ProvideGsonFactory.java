package com.talabat.splash.core.di;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"JsonModels.parser.UniversalGsonQualifier"})
public final class ApplicationModule_ProvideGsonFactory implements Factory<Gson> {
    private final ApplicationModule module;

    public ApplicationModule_ProvideGsonFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideGsonFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideGsonFactory(applicationModule);
    }

    public static Gson provideGson(ApplicationModule applicationModule) {
        return (Gson) Preconditions.checkNotNullFromProvides(applicationModule.provideGson());
    }

    public Gson get() {
        return provideGson(this.module);
    }
}
