package com.talabat.splash.core.di;

import com.google.gson.Gson;
import com.talabat.splash.presentation.infrastructure.device.CommonUtils;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata({"JsonModels.parser.UniversalGsonQualifier"})
public final class ApplicationModule_ProvideCommonUtilsFactory implements Factory<CommonUtils> {
    private final Provider<Gson> gsonProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideCommonUtilsFactory(ApplicationModule applicationModule, Provider<Gson> provider) {
        this.module = applicationModule;
        this.gsonProvider = provider;
    }

    public static ApplicationModule_ProvideCommonUtilsFactory create(ApplicationModule applicationModule, Provider<Gson> provider) {
        return new ApplicationModule_ProvideCommonUtilsFactory(applicationModule, provider);
    }

    public static CommonUtils provideCommonUtils(ApplicationModule applicationModule, Gson gson) {
        return (CommonUtils) Preconditions.checkNotNullFromProvides(applicationModule.provideCommonUtils(gson));
    }

    public CommonUtils get() {
        return provideCommonUtils(this.module, this.gsonProvider.get());
    }
}
