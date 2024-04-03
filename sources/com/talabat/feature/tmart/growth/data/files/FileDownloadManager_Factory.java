package com.talabat.feature.tmart.growth.data.files;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FileDownloadManager_Factory implements Factory<FileDownloadManager> {
    private final Provider<OkHttpClient> clientProvider;

    public FileDownloadManager_Factory(Provider<OkHttpClient> provider) {
        this.clientProvider = provider;
    }

    public static FileDownloadManager_Factory create(Provider<OkHttpClient> provider) {
        return new FileDownloadManager_Factory(provider);
    }

    public static FileDownloadManager newInstance(OkHttpClient okHttpClient) {
        return new FileDownloadManager(okHttpClient);
    }

    public FileDownloadManager get() {
        return newInstance(this.clientProvider.get());
    }
}
