package com.talabat.splash.core.di;

import com.talabat.notifications.brazemigrator.BrazeUserMigrator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class ApplicationModule_ProvideBrazeUserMigratorFactory implements Factory<BrazeUserMigrator> {
    private final ApplicationModule module;

    public ApplicationModule_ProvideBrazeUserMigratorFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public static ApplicationModule_ProvideBrazeUserMigratorFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideBrazeUserMigratorFactory(applicationModule);
    }

    public static BrazeUserMigrator provideBrazeUserMigrator(ApplicationModule applicationModule) {
        return (BrazeUserMigrator) Preconditions.checkNotNullFromProvides(applicationModule.provideBrazeUserMigrator());
    }

    public BrazeUserMigrator get() {
        return provideBrazeUserMigrator(this.module);
    }
}
