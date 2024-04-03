package com.talabat.feature.tmart.growth.data.files;

import com.bumptech.glide.load.engine.cache.DiskCache;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthFileManager_Factory implements Factory<TMartGrowthFileManager> {
    private final Provider<DiskCache> discCacheProvider;
    private final Provider<CoroutineDispatchersFactory> dispatchersFactoryProvider;
    private final Provider<FileDownloadManager> downloadManagerProvider;

    public TMartGrowthFileManager_Factory(Provider<DiskCache> provider, Provider<FileDownloadManager> provider2, Provider<CoroutineDispatchersFactory> provider3) {
        this.discCacheProvider = provider;
        this.downloadManagerProvider = provider2;
        this.dispatchersFactoryProvider = provider3;
    }

    public static TMartGrowthFileManager_Factory create(Provider<DiskCache> provider, Provider<FileDownloadManager> provider2, Provider<CoroutineDispatchersFactory> provider3) {
        return new TMartGrowthFileManager_Factory(provider, provider2, provider3);
    }

    public static TMartGrowthFileManager newInstance(DiskCache diskCache, FileDownloadManager fileDownloadManager, CoroutineDispatchersFactory coroutineDispatchersFactory) {
        return new TMartGrowthFileManager(diskCache, fileDownloadManager, coroutineDispatchersFactory);
    }

    public TMartGrowthFileManager get() {
        return newInstance(this.discCacheProvider.get(), this.downloadManagerProvider.get(), this.dispatchersFactoryProvider.get());
    }
}
