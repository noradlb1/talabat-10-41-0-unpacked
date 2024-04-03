package com.talabat.core.safety.data.datasource.info.impl;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.advertisement.google.domain.GoogleAdvertisementRepository;
import com.talabat.core.perseus.domain.TalabatPerseusRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.safety.data.di.AndroidId", "com.talabat.core.safety.data.di.PackageName", "com.talabat.core.safety.data.di.InstallationPath", "com.talabat.core.safety.data.di.DeviceName"})
public final class DefaultShieldInfoDtoFactory_Factory implements Factory<DefaultShieldInfoDtoFactory> {
    private final Provider<GoogleAdvertisementRepository> advertisementRepositoryProvider;
    private final Provider<String> androidIdProvider;
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<String> deviceNameProvider;
    private final Provider<String> installationPathProvider;
    private final Provider<String> packageNameProvider;
    private final Provider<TalabatPerseusRepository> perseusRepositoryProvider;

    public DefaultShieldInfoDtoFactory_Factory(Provider<GoogleAdvertisementRepository> provider, Provider<AppVersionProvider> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<TalabatPerseusRepository> provider4, Provider<String> provider5, Provider<String> provider6, Provider<String> provider7, Provider<String> provider8) {
        this.advertisementRepositoryProvider = provider;
        this.appVersionProvider = provider2;
        this.configurationLocalRepositoryProvider = provider3;
        this.perseusRepositoryProvider = provider4;
        this.androidIdProvider = provider5;
        this.packageNameProvider = provider6;
        this.installationPathProvider = provider7;
        this.deviceNameProvider = provider8;
    }

    public static DefaultShieldInfoDtoFactory_Factory create(Provider<GoogleAdvertisementRepository> provider, Provider<AppVersionProvider> provider2, Provider<ConfigurationLocalRepository> provider3, Provider<TalabatPerseusRepository> provider4, Provider<String> provider5, Provider<String> provider6, Provider<String> provider7, Provider<String> provider8) {
        return new DefaultShieldInfoDtoFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static DefaultShieldInfoDtoFactory newInstance(GoogleAdvertisementRepository googleAdvertisementRepository, AppVersionProvider appVersionProvider2, ConfigurationLocalRepository configurationLocalRepository, TalabatPerseusRepository talabatPerseusRepository, String str, String str2, String str3, String str4) {
        return new DefaultShieldInfoDtoFactory(googleAdvertisementRepository, appVersionProvider2, configurationLocalRepository, talabatPerseusRepository, str, str2, str3, str4);
    }

    public DefaultShieldInfoDtoFactory get() {
        return newInstance(this.advertisementRepositoryProvider.get(), this.appVersionProvider.get(), this.configurationLocalRepositoryProvider.get(), this.perseusRepositoryProvider.get(), this.androidIdProvider.get(), this.packageNameProvider.get(), this.installationPathProvider.get(), this.deviceNameProvider.get());
    }
}
