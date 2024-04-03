package com.talabat.splash.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.splash.domain.model.AppInfoGlobalCustomerWrapper;
import com.talabat.splash.presentation.infrastructure.device.CommonUtils;
import com.talabat.splash.presentation.infrastructure.device.PresentationUtils;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class SplashPreferences_Factory implements Factory<SplashPreferences> {
    private final Provider<AppInfoGlobalCustomerWrapper> appInfoGlobalCustomerWrapperProvider;
    private final Provider<CommonUtils> commonUtilsProvider;
    private final Provider<Context> contextProvider;
    private final Provider<MutableConfigurationLocalRepository> mutableConfigurationLocalRepositoryProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<PresentationUtils> presentationUtilsProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public SplashPreferences_Factory(Provider<SharedPreferences> provider, Provider<PresentationUtils> provider2, Provider<CommonUtils> provider3, Provider<Context> provider4, Provider<AppInfoGlobalCustomerWrapper> provider5, Provider<MutableConfigurationLocalRepository> provider6, Provider<IObservabilityManager> provider7) {
        this.sharedPreferencesProvider = provider;
        this.presentationUtilsProvider = provider2;
        this.commonUtilsProvider = provider3;
        this.contextProvider = provider4;
        this.appInfoGlobalCustomerWrapperProvider = provider5;
        this.mutableConfigurationLocalRepositoryProvider = provider6;
        this.observabilityManagerProvider = provider7;
    }

    public static SplashPreferences_Factory create(Provider<SharedPreferences> provider, Provider<PresentationUtils> provider2, Provider<CommonUtils> provider3, Provider<Context> provider4, Provider<AppInfoGlobalCustomerWrapper> provider5, Provider<MutableConfigurationLocalRepository> provider6, Provider<IObservabilityManager> provider7) {
        return new SplashPreferences_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static SplashPreferences newInstance(SharedPreferences sharedPreferences, PresentationUtils presentationUtils, CommonUtils commonUtils, Context context, AppInfoGlobalCustomerWrapper appInfoGlobalCustomerWrapper, MutableConfigurationLocalRepository mutableConfigurationLocalRepository, IObservabilityManager iObservabilityManager) {
        return new SplashPreferences(sharedPreferences, presentationUtils, commonUtils, context, appInfoGlobalCustomerWrapper, mutableConfigurationLocalRepository, iObservabilityManager);
    }

    public SplashPreferences get() {
        return newInstance(this.sharedPreferencesProvider.get(), this.presentationUtilsProvider.get(), this.commonUtilsProvider.get(), this.contextProvider.get(), this.appInfoGlobalCustomerWrapperProvider.get(), this.mutableConfigurationLocalRepositoryProvider.get(), this.observabilityManagerProvider.get());
    }
}
