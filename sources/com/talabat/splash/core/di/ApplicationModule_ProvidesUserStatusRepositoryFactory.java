package com.talabat.splash.core.di;

import com.talabat.userandlocation.compliance.status.domain.repository.UserStatusRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvidesUserStatusRepositoryFactory implements Factory<UserStatusRepository> {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesUserStatusRepositoryFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvidesUserStatusRepositoryFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesUserStatusRepositoryFactory(applicationModule);
    }

    public static UserStatusRepository providesUserStatusRepository(ApplicationModule applicationModule) {
        return (UserStatusRepository) Preconditions.checkNotNullFromProvides(applicationModule.providesUserStatusRepository());
    }

    public UserStatusRepository get() {
        return providesUserStatusRepository(this.module);
    }
}
