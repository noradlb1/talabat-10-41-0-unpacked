package com.talabat.splash.data.preferences;

import android.content.SharedPreferences;
import com.squareup.moshi.Moshi;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AppInfoLocalDataSourceImp_Factory implements Factory<AppInfoLocalDataSourceImp> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<MutableConfigurationRemoteRepository> mutableConfigurationRemoteRepositoryProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public AppInfoLocalDataSourceImp_Factory(Provider<AppVersionProvider> provider, Provider<SharedPreferences> provider2, Provider<MutableConfigurationRemoteRepository> provider3, Provider<Moshi> provider4) {
        this.appVersionProvider = provider;
        this.sharedPreferencesProvider = provider2;
        this.mutableConfigurationRemoteRepositoryProvider = provider3;
        this.moshiProvider = provider4;
    }

    public static AppInfoLocalDataSourceImp_Factory create(Provider<AppVersionProvider> provider, Provider<SharedPreferences> provider2, Provider<MutableConfigurationRemoteRepository> provider3, Provider<Moshi> provider4) {
        return new AppInfoLocalDataSourceImp_Factory(provider, provider2, provider3, provider4);
    }

    public static AppInfoLocalDataSourceImp newInstance(AppVersionProvider appVersionProvider2, SharedPreferences sharedPreferences, MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository, Moshi moshi) {
        return new AppInfoLocalDataSourceImp(appVersionProvider2, sharedPreferences, mutableConfigurationRemoteRepository, moshi);
    }

    public AppInfoLocalDataSourceImp get() {
        return newInstance(this.appVersionProvider.get(), this.sharedPreferencesProvider.get(), this.mutableConfigurationRemoteRepositoryProvider.get(), this.moshiProvider.get());
    }
}
