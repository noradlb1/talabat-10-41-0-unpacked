package com.talabat.splash.core.di;

import androidx.work.WorkManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideWorkManagerFactory implements Factory<WorkManager> {
    private final ApplicationModule module;

    public ApplicationModule_ProvideWorkManagerFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideWorkManagerFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideWorkManagerFactory(applicationModule);
    }

    public static WorkManager provideWorkManager(ApplicationModule applicationModule) {
        return (WorkManager) Preconditions.checkNotNullFromProvides(applicationModule.provideWorkManager());
    }

    public WorkManager get() {
        return provideWorkManager(this.module);
    }
}
