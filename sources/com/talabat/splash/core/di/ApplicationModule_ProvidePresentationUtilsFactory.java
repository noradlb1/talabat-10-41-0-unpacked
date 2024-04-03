package com.talabat.splash.core.di;

import android.content.Context;
import com.talabat.splash.presentation.infrastructure.device.PresentationUtils;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvidePresentationUtilsFactory implements Factory<PresentationUtils> {
    private final Provider<Context> contextProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvidePresentationUtilsFactory(ApplicationModule applicationModule, Provider<Context> provider) {
        this.module = applicationModule;
        this.contextProvider = provider;
    }

    public static ApplicationModule_ProvidePresentationUtilsFactory create(ApplicationModule applicationModule, Provider<Context> provider) {
        return new ApplicationModule_ProvidePresentationUtilsFactory(applicationModule, provider);
    }

    public static PresentationUtils providePresentationUtils(ApplicationModule applicationModule, Context context) {
        return (PresentationUtils) Preconditions.checkNotNullFromProvides(applicationModule.providePresentationUtils(context));
    }

    public PresentationUtils get() {
        return providePresentationUtils(this.module, this.contextProvider.get());
    }
}
