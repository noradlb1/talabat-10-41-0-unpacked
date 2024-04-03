package com.talabat.splash.core.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.functions.Function;
import kotlin.Unit;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvidePilotSetterFactory implements Factory<Function<String, Unit>> {
    private final ApplicationModule module;

    public ApplicationModule_ProvidePilotSetterFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidePilotSetterFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidePilotSetterFactory(applicationModule);
    }

    public static Function<String, Unit> providePilotSetter(ApplicationModule applicationModule) {
        return (Function) Preconditions.checkNotNullFromProvides(applicationModule.providePilotSetter());
    }

    public Function<String, Unit> get() {
        return providePilotSetter(this.module);
    }
}
