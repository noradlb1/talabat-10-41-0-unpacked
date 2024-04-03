package com.talabat.feature.tmart.growth.data.di;

import com.bumptech.glide.load.engine.cache.DiskCache;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.io.File;
import javax.inject.Provider;
import org.jetbrains.annotations.Nullable;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthCacheModule_ProvideDiskCacheFactory implements Factory<DiskCache> {
    private final Provider<File> fileDirectoryProvider;

    public TMartGrowthCacheModule_ProvideDiskCacheFactory(Provider<File> provider) {
        this.fileDirectoryProvider = provider;
    }

    public static TMartGrowthCacheModule_ProvideDiskCacheFactory create(Provider<File> provider) {
        return new TMartGrowthCacheModule_ProvideDiskCacheFactory(provider);
    }

    @Nullable
    public static DiskCache provideDiskCache(File file) {
        return TMartGrowthCacheModule.INSTANCE.provideDiskCache(file);
    }

    @Nullable
    public DiskCache get() {
        return provideDiskCache(this.fileDirectoryProvider.get());
    }
}
