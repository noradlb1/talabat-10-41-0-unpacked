package com.talabat.splash.core.di;

import com.talabat.splash.data.remote.DownloadManager;
import com.talabat.splash.domain.repository.DownloadsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApplicationModule_ProvideDownloadsRepositoryFactory implements Factory<DownloadsRepository> {
    private final Provider<DownloadManager> downloadManagerProvider;
    private final ApplicationModule module;

    public ApplicationModule_ProvideDownloadsRepositoryFactory(ApplicationModule applicationModule, Provider<DownloadManager> provider) {
        this.module = applicationModule;
        this.downloadManagerProvider = provider;
    }

    public static ApplicationModule_ProvideDownloadsRepositoryFactory create(ApplicationModule applicationModule, Provider<DownloadManager> provider) {
        return new ApplicationModule_ProvideDownloadsRepositoryFactory(applicationModule, provider);
    }

    public static DownloadsRepository provideDownloadsRepository(ApplicationModule applicationModule, DownloadManager downloadManager) {
        return (DownloadsRepository) Preconditions.checkNotNullFromProvides(applicationModule.provideDownloadsRepository(downloadManager));
    }

    public DownloadsRepository get() {
        return provideDownloadsRepository(this.module, this.downloadManagerProvider.get());
    }
}
