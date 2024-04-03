package com.talabat.feature.tmart.growth.data.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.io.File;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthCacheModule_ProvideFileDirectoryFactory implements Factory<File> {
    private final Provider<Context> contextProvider;

    public TMartGrowthCacheModule_ProvideFileDirectoryFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static TMartGrowthCacheModule_ProvideFileDirectoryFactory create(Provider<Context> provider) {
        return new TMartGrowthCacheModule_ProvideFileDirectoryFactory(provider);
    }

    public static File provideFileDirectory(Context context) {
        return (File) Preconditions.checkNotNullFromProvides(TMartGrowthCacheModule.INSTANCE.provideFileDirectory(context));
    }

    public File get() {
        return provideFileDirectory(this.contextProvider.get());
    }
}
