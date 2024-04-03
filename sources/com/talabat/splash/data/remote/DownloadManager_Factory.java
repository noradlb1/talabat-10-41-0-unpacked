package com.talabat.splash.data.remote;

import android.content.Context;
import androidx.work.WorkManager;
import com.talabat.splash.data.local.LocalCache;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DownloadManager_Factory implements Factory<DownloadManager> {
    private final Provider<Context> contextProvider;
    private final Provider<LocalCache> localCacheProvider;
    private final Provider<WorkManager> workManagerProvider;

    public DownloadManager_Factory(Provider<WorkManager> provider, Provider<LocalCache> provider2, Provider<Context> provider3) {
        this.workManagerProvider = provider;
        this.localCacheProvider = provider2;
        this.contextProvider = provider3;
    }

    public static DownloadManager_Factory create(Provider<WorkManager> provider, Provider<LocalCache> provider2, Provider<Context> provider3) {
        return new DownloadManager_Factory(provider, provider2, provider3);
    }

    public static DownloadManager newInstance(WorkManager workManager, LocalCache localCache, Context context) {
        return new DownloadManager(workManager, localCache, context);
    }

    public DownloadManager get() {
        return newInstance(this.workManagerProvider.get(), this.localCacheProvider.get(), this.contextProvider.get());
    }
}
