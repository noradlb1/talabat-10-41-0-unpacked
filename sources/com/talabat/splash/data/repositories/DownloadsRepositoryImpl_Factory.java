package com.talabat.splash.data.repositories;

import com.talabat.splash.data.remote.DownloadManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DownloadsRepositoryImpl_Factory implements Factory<DownloadsRepositoryImpl> {
    private final Provider<DownloadManager> downloadManagerProvider;

    public DownloadsRepositoryImpl_Factory(Provider<DownloadManager> provider) {
        this.downloadManagerProvider = provider;
    }

    public static DownloadsRepositoryImpl_Factory create(Provider<DownloadManager> provider) {
        return new DownloadsRepositoryImpl_Factory(provider);
    }

    public static DownloadsRepositoryImpl newInstance(DownloadManager downloadManager) {
        return new DownloadsRepositoryImpl(downloadManager);
    }

    public DownloadsRepositoryImpl get() {
        return newInstance(this.downloadManagerProvider.get());
    }
}
