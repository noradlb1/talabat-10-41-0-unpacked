package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.pinless.checkout.domain.GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapsInitializer;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;
import kotlin.jvm.functions.Function0;
import library.talabat.mvp.addressV2.UserAddAddressScreenEventsListener;

@QualifierMetadata
@DaggerGenerated
public final class QuickOrderScreen_MembersInjector implements MembersInjector<QuickOrderScreen> {
    private final Provider<Function0<String>> addressJsonProvider;
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<CameraUpdateFactory> cameraUpdateFactoryProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase> getHasUserPinnedLocationInCurrentOnboardingSessionUseCaseProvider;
    private final Provider<LatLngFactory> latLngFactoryProvider;
    private final Provider<MapsInitializer> mapsInitializerProvider;
    private final Provider<MutableLocationConfigurationRepository> mutableLocationConfigurationRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<UserAddAddressScreenEventsListener> userAddAddressScreenEventsListenerProvider;

    public QuickOrderScreen_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<MutableLocationConfigurationRepository> provider3, Provider<GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase> provider4, Provider<UserAddAddressScreenEventsListener> provider5, Provider<Function0<String>> provider6, Provider<ITalabatFeatureFlag> provider7, Provider<LatLngFactory> provider8, Provider<MapsInitializer> provider9, Provider<CameraUpdateFactory> provider10) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.mutableLocationConfigurationRepositoryProvider = provider3;
        this.getHasUserPinnedLocationInCurrentOnboardingSessionUseCaseProvider = provider4;
        this.userAddAddressScreenEventsListenerProvider = provider5;
        this.addressJsonProvider = provider6;
        this.talabatFeatureFlagProvider = provider7;
        this.latLngFactoryProvider = provider8;
        this.mapsInitializerProvider = provider9;
        this.cameraUpdateFactoryProvider = provider10;
    }

    public static MembersInjector<QuickOrderScreen> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<MutableLocationConfigurationRepository> provider3, Provider<GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase> provider4, Provider<UserAddAddressScreenEventsListener> provider5, Provider<Function0<String>> provider6, Provider<ITalabatFeatureFlag> provider7, Provider<LatLngFactory> provider8, Provider<MapsInitializer> provider9, Provider<CameraUpdateFactory> provider10) {
        return new QuickOrderScreen_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @InjectedFieldSignature("com.talabat.QuickOrderScreen.addressJsonProvider")
    public static void injectAddressJsonProvider(QuickOrderScreen quickOrderScreen, Function0<String> function0) {
        quickOrderScreen.f54579n = function0;
    }

    @InjectedFieldSignature("com.talabat.QuickOrderScreen.appVersionProvider")
    public static void injectAppVersionProvider(QuickOrderScreen quickOrderScreen, AppVersionProvider appVersionProvider2) {
        quickOrderScreen.f54574i = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.QuickOrderScreen.cameraUpdateFactory")
    public static void injectCameraUpdateFactory(QuickOrderScreen quickOrderScreen, CameraUpdateFactory cameraUpdateFactory) {
        quickOrderScreen.f54583r = cameraUpdateFactory;
    }

    @InjectedFieldSignature("com.talabat.QuickOrderScreen.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(QuickOrderScreen quickOrderScreen, ConfigurationLocalRepository configurationLocalRepository) {
        quickOrderScreen.f54575j = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.QuickOrderScreen.getHasUserPinnedLocationInCurrentOnboardingSessionUseCase")
    public static void injectGetHasUserPinnedLocationInCurrentOnboardingSessionUseCase(QuickOrderScreen quickOrderScreen, GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase getHasUserPinnedLocationInCurrentOnboardingSessionUseCase) {
        quickOrderScreen.f54577l = getHasUserPinnedLocationInCurrentOnboardingSessionUseCase;
    }

    @InjectedFieldSignature("com.talabat.QuickOrderScreen.latLngFactory")
    public static void injectLatLngFactory(QuickOrderScreen quickOrderScreen, LatLngFactory latLngFactory) {
        quickOrderScreen.f54581p = latLngFactory;
    }

    @InjectedFieldSignature("com.talabat.QuickOrderScreen.mapsInitializer")
    public static void injectMapsInitializer(QuickOrderScreen quickOrderScreen, MapsInitializer mapsInitializer) {
        quickOrderScreen.f54582q = mapsInitializer;
    }

    @InjectedFieldSignature("com.talabat.QuickOrderScreen.mutableLocationConfigurationRepository")
    public static void injectMutableLocationConfigurationRepository(QuickOrderScreen quickOrderScreen, MutableLocationConfigurationRepository mutableLocationConfigurationRepository) {
        quickOrderScreen.f54576k = mutableLocationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.QuickOrderScreen.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(QuickOrderScreen quickOrderScreen, ITalabatFeatureFlag iTalabatFeatureFlag) {
        quickOrderScreen.f54580o = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.QuickOrderScreen.userAddAddressScreenEventsListener")
    public static void injectUserAddAddressScreenEventsListener(QuickOrderScreen quickOrderScreen, UserAddAddressScreenEventsListener userAddAddressScreenEventsListener) {
        quickOrderScreen.f54578m = userAddAddressScreenEventsListener;
    }

    public void injectMembers(QuickOrderScreen quickOrderScreen) {
        injectAppVersionProvider(quickOrderScreen, this.appVersionProvider.get());
        injectConfigurationLocalRepository(quickOrderScreen, this.configurationLocalRepositoryProvider.get());
        injectMutableLocationConfigurationRepository(quickOrderScreen, this.mutableLocationConfigurationRepositoryProvider.get());
        injectGetHasUserPinnedLocationInCurrentOnboardingSessionUseCase(quickOrderScreen, this.getHasUserPinnedLocationInCurrentOnboardingSessionUseCaseProvider.get());
        injectUserAddAddressScreenEventsListener(quickOrderScreen, this.userAddAddressScreenEventsListenerProvider.get());
        injectAddressJsonProvider(quickOrderScreen, this.addressJsonProvider.get());
        injectTalabatFeatureFlag(quickOrderScreen, this.talabatFeatureFlagProvider.get());
        injectLatLngFactory(quickOrderScreen, this.latLngFactoryProvider.get());
        injectMapsInitializer(quickOrderScreen, this.mapsInitializerProvider.get());
        injectCameraUpdateFactory(quickOrderScreen, this.cameraUpdateFactoryProvider.get());
    }
}
