package com.talabat.splash.presentation.ui;

import com.talabat.authentication.token.domain.repository.ClearOwinStartupUseCase;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCase;
import com.talabat.splash.domain.usecase.GetAppInfoUseCase;
import com.talabat.splash.domain.usecase.GetAppLanguageUseCase;
import com.talabat.splash.domain.usecase.GetAppPreferncesUseCase;
import com.talabat.splash.domain.usecase.GetAuthenticationTokenUseCase;
import com.talabat.splash.domain.usecase.GetCurrentLocationUseCase;
import com.talabat.splash.domain.usecase.GetDeviceDeepLinkUseCase;
import com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase;
import com.talabat.splash.domain.usecase.GetGpsStausUseCase;
import com.talabat.splash.domain.usecase.GetLocationPermissionStatusUseCase;
import com.talabat.splash.domain.usecase.GetRedirectionFlowUseCase;
import com.talabat.splash.domain.usecase.GetReverseGeoCodeCountryUseCase;
import com.talabat.splash.domain.usecase.GetSplashPhaseOneUseCase;
import com.talabat.splash.domain.usecase.GetThirdPartyInitUseCase;
import com.talabat.splash.domain.usecase.SetAppConfigUseCase;
import com.talabat.splash.presentation.infrastructure.device.PresentationUtils;
import com.talabat.splash.presentation.infrastructure.thirdparty.SplashConfig;
import com.talabat.splash.presentation.infrastructure.thirdparty.Tracking;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SplashActivitySharedViewModel_Factory implements Factory<SplashActivitySharedViewModel> {
    private final Provider<ClearOwinStartupUseCase> clearOwinUseCaseProvider;
    private final Provider<MutableConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<GetAppInfoUseCase> getAppInfoUseCaseProvider;
    private final Provider<GetAppLanguageUseCase> getAppLanguageUseCaseProvider;
    private final Provider<GetAppPreferncesUseCase> getAppPreferencesUseCaseProvider;
    private final Provider<GetAuthenticationTokenUseCase> getAuthenticationTokenUseCaseProvider;
    private final Provider<GetCurrentLocationUseCase> getCurrentLocationUseCaseProvider;
    private final Provider<GetDeviceDeepLinkUseCase> getDeepLinkFlowProvider;
    private final Provider<GetDynamicSplashContentUseCase> getDynamicSplashContentUseCaseProvider;
    private final Provider<GetGpsStausUseCase> getGpsStatusUseCaseProvider;
    private final Provider<GetLocationPermissionStatusUseCase> getLocationPermissionStatusUseCaseProvider;
    private final Provider<GetRedirectionFlowUseCase> getRedirectionFlowUseCaseProvider;
    private final Provider<GetReverseGeoCodeCountryUseCase> getReverseGeoCodeCountryUseCaseProvider;
    private final Provider<GetSplashPhaseOneUseCase> getSplashPhaseOneUseCaseProvider;
    private final Provider<GetThirdPartyInitUseCase> getThirdPartyInitUseCaseProvider;
    private final Provider<IsOnboardingExperimentEnabledUseCase> isOnboardingExperimentEnabledUseCaseImplProvider;
    private final Provider<PresentationUtils> presentationUtilsProvider;
    private final Provider<SetAppConfigUseCase> setAppConfigUseCaseProvider;
    private final Provider<SplashConfig> splashConfigProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<Tracking> trackingProvider;

    public SplashActivitySharedViewModel_Factory(Provider<GetAuthenticationTokenUseCase> provider, Provider<GetAppInfoUseCase> provider2, Provider<SetAppConfigUseCase> provider3, Provider<GetAppPreferncesUseCase> provider4, Provider<GetAppLanguageUseCase> provider5, Provider<GetThirdPartyInitUseCase> provider6, Provider<GetRedirectionFlowUseCase> provider7, Provider<PresentationUtils> provider8, Provider<GetSplashPhaseOneUseCase> provider9, Provider<GetCurrentLocationUseCase> provider10, Provider<GetGpsStausUseCase> provider11, Provider<GetLocationPermissionStatusUseCase> provider12, Provider<GetReverseGeoCodeCountryUseCase> provider13, Provider<GetDeviceDeepLinkUseCase> provider14, Provider<Tracking> provider15, Provider<GetDynamicSplashContentUseCase> provider16, Provider<MutableConfigurationLocalRepository> provider17, Provider<ITalabatFeatureFlag> provider18, Provider<SplashConfig> provider19, Provider<ClearOwinStartupUseCase> provider20, Provider<IsOnboardingExperimentEnabledUseCase> provider21) {
        this.getAuthenticationTokenUseCaseProvider = provider;
        this.getAppInfoUseCaseProvider = provider2;
        this.setAppConfigUseCaseProvider = provider3;
        this.getAppPreferencesUseCaseProvider = provider4;
        this.getAppLanguageUseCaseProvider = provider5;
        this.getThirdPartyInitUseCaseProvider = provider6;
        this.getRedirectionFlowUseCaseProvider = provider7;
        this.presentationUtilsProvider = provider8;
        this.getSplashPhaseOneUseCaseProvider = provider9;
        this.getCurrentLocationUseCaseProvider = provider10;
        this.getGpsStatusUseCaseProvider = provider11;
        this.getLocationPermissionStatusUseCaseProvider = provider12;
        this.getReverseGeoCodeCountryUseCaseProvider = provider13;
        this.getDeepLinkFlowProvider = provider14;
        this.trackingProvider = provider15;
        this.getDynamicSplashContentUseCaseProvider = provider16;
        this.configurationLocalRepositoryProvider = provider17;
        this.talabatFeatureFlagProvider = provider18;
        this.splashConfigProvider = provider19;
        this.clearOwinUseCaseProvider = provider20;
        this.isOnboardingExperimentEnabledUseCaseImplProvider = provider21;
    }

    public static SplashActivitySharedViewModel_Factory create(Provider<GetAuthenticationTokenUseCase> provider, Provider<GetAppInfoUseCase> provider2, Provider<SetAppConfigUseCase> provider3, Provider<GetAppPreferncesUseCase> provider4, Provider<GetAppLanguageUseCase> provider5, Provider<GetThirdPartyInitUseCase> provider6, Provider<GetRedirectionFlowUseCase> provider7, Provider<PresentationUtils> provider8, Provider<GetSplashPhaseOneUseCase> provider9, Provider<GetCurrentLocationUseCase> provider10, Provider<GetGpsStausUseCase> provider11, Provider<GetLocationPermissionStatusUseCase> provider12, Provider<GetReverseGeoCodeCountryUseCase> provider13, Provider<GetDeviceDeepLinkUseCase> provider14, Provider<Tracking> provider15, Provider<GetDynamicSplashContentUseCase> provider16, Provider<MutableConfigurationLocalRepository> provider17, Provider<ITalabatFeatureFlag> provider18, Provider<SplashConfig> provider19, Provider<ClearOwinStartupUseCase> provider20, Provider<IsOnboardingExperimentEnabledUseCase> provider21) {
        return new SplashActivitySharedViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21);
    }

    public static SplashActivitySharedViewModel newInstance(GetAuthenticationTokenUseCase getAuthenticationTokenUseCase, GetAppInfoUseCase getAppInfoUseCase, SetAppConfigUseCase setAppConfigUseCase, GetAppPreferncesUseCase getAppPreferncesUseCase, GetAppLanguageUseCase getAppLanguageUseCase, GetThirdPartyInitUseCase getThirdPartyInitUseCase, GetRedirectionFlowUseCase getRedirectionFlowUseCase, PresentationUtils presentationUtils, GetSplashPhaseOneUseCase getSplashPhaseOneUseCase, GetCurrentLocationUseCase getCurrentLocationUseCase, GetGpsStausUseCase getGpsStausUseCase, GetLocationPermissionStatusUseCase getLocationPermissionStatusUseCase, GetReverseGeoCodeCountryUseCase getReverseGeoCodeCountryUseCase, GetDeviceDeepLinkUseCase getDeviceDeepLinkUseCase, Tracking tracking2, GetDynamicSplashContentUseCase getDynamicSplashContentUseCase, MutableConfigurationLocalRepository mutableConfigurationLocalRepository, ITalabatFeatureFlag iTalabatFeatureFlag, SplashConfig splashConfig, ClearOwinStartupUseCase clearOwinStartupUseCase, IsOnboardingExperimentEnabledUseCase isOnboardingExperimentEnabledUseCase) {
        return new SplashActivitySharedViewModel(getAuthenticationTokenUseCase, getAppInfoUseCase, setAppConfigUseCase, getAppPreferncesUseCase, getAppLanguageUseCase, getThirdPartyInitUseCase, getRedirectionFlowUseCase, presentationUtils, getSplashPhaseOneUseCase, getCurrentLocationUseCase, getGpsStausUseCase, getLocationPermissionStatusUseCase, getReverseGeoCodeCountryUseCase, getDeviceDeepLinkUseCase, tracking2, getDynamicSplashContentUseCase, mutableConfigurationLocalRepository, iTalabatFeatureFlag, splashConfig, clearOwinStartupUseCase, isOnboardingExperimentEnabledUseCase);
    }

    public SplashActivitySharedViewModel get() {
        return newInstance(this.getAuthenticationTokenUseCaseProvider.get(), this.getAppInfoUseCaseProvider.get(), this.setAppConfigUseCaseProvider.get(), this.getAppPreferencesUseCaseProvider.get(), this.getAppLanguageUseCaseProvider.get(), this.getThirdPartyInitUseCaseProvider.get(), this.getRedirectionFlowUseCaseProvider.get(), this.presentationUtilsProvider.get(), this.getSplashPhaseOneUseCaseProvider.get(), this.getCurrentLocationUseCaseProvider.get(), this.getGpsStatusUseCaseProvider.get(), this.getLocationPermissionStatusUseCaseProvider.get(), this.getReverseGeoCodeCountryUseCaseProvider.get(), this.getDeepLinkFlowProvider.get(), this.trackingProvider.get(), this.getDynamicSplashContentUseCaseProvider.get(), this.configurationLocalRepositoryProvider.get(), this.talabatFeatureFlagProvider.get(), this.splashConfigProvider.get(), this.clearOwinUseCaseProvider.get(), this.isOnboardingExperimentEnabledUseCaseImplProvider.get());
    }
}
