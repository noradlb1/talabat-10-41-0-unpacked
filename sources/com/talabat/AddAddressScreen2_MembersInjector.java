package com.talabat;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.pinless.checkout.domain.GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.ModelsRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;
import kotlin.jvm.functions.Function0;
import library.talabat.mvp.addressV2.UserAddAddressScreenEventsListener;

@QualifierMetadata
@DaggerGenerated
public final class AddAddressScreen2_MembersInjector implements MembersInjector<AddAddressScreen2> {
    private final Provider<Function0<String>> addressJsonProvider;
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<CameraUpdateFactory> cameraUpdateFactoryProvider;
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase> getHasUserPinnedLocationInCurrentOnboardingSessionUseCaseProvider;
    private final Provider<LatLngFactory> latLngFactoryProvider;
    private final Provider<MapsInitializer> mapsInitializerProvider;
    private final Provider<ModelsRepository> modelsRepositoryProvider;
    private final Provider<MutableLocationConfigurationRepository> mutableLocationConfigurationRepositoryProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;
    private final Provider<UserAddAddressScreenEventsListener> userAddAddressScreenEventsListenerProvider;

    public AddAddressScreen2_MembersInjector(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<MutableLocationConfigurationRepository> provider3, Provider<GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase> provider4, Provider<UserAddAddressScreenEventsListener> provider5, Provider<TalabatTracker> provider6, Provider<ITalabatFeatureFlag> provider7, Provider<ModelsRepository> provider8, Provider<LatLngFactory> provider9, Provider<MapsInitializer> provider10, Provider<CameraUpdateFactory> provider11, Provider<Function0<String>> provider12) {
        this.appVersionProvider = provider;
        this.configurationLocalRepositoryProvider = provider2;
        this.mutableLocationConfigurationRepositoryProvider = provider3;
        this.getHasUserPinnedLocationInCurrentOnboardingSessionUseCaseProvider = provider4;
        this.userAddAddressScreenEventsListenerProvider = provider5;
        this.talabatTrackerProvider = provider6;
        this.talabatFeatureFlagProvider = provider7;
        this.modelsRepositoryProvider = provider8;
        this.latLngFactoryProvider = provider9;
        this.mapsInitializerProvider = provider10;
        this.cameraUpdateFactoryProvider = provider11;
        this.addressJsonProvider = provider12;
    }

    public static MembersInjector<AddAddressScreen2> create(Provider<AppVersionProvider> provider, Provider<ConfigurationLocalRepository> provider2, Provider<MutableLocationConfigurationRepository> provider3, Provider<GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase> provider4, Provider<UserAddAddressScreenEventsListener> provider5, Provider<TalabatTracker> provider6, Provider<ITalabatFeatureFlag> provider7, Provider<ModelsRepository> provider8, Provider<LatLngFactory> provider9, Provider<MapsInitializer> provider10, Provider<CameraUpdateFactory> provider11, Provider<Function0<String>> provider12) {
        return new AddAddressScreen2_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    @InjectedFieldSignature("com.talabat.AddAddressScreen2.addressJsonProvider")
    public static void injectAddressJsonProvider(AddAddressScreen2 addAddressScreen2, Function0<String> function0) {
        addAddressScreen2.C = function0;
    }

    @InjectedFieldSignature("com.talabat.AddAddressScreen2.appVersionProvider")
    public static void injectAppVersionProvider(AddAddressScreen2 addAddressScreen2, AppVersionProvider appVersionProvider2) {
        addAddressScreen2.f53497i = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.AddAddressScreen2.cameraUpdateFactory")
    public static void injectCameraUpdateFactory(AddAddressScreen2 addAddressScreen2, CameraUpdateFactory cameraUpdateFactory) {
        addAddressScreen2.f53507s = cameraUpdateFactory;
    }

    @InjectedFieldSignature("com.talabat.AddAddressScreen2.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(AddAddressScreen2 addAddressScreen2, ConfigurationLocalRepository configurationLocalRepository) {
        addAddressScreen2.f53498j = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.AddAddressScreen2.getHasUserPinnedLocationInCurrentOnboardingSessionUseCase")
    public static void injectGetHasUserPinnedLocationInCurrentOnboardingSessionUseCase(AddAddressScreen2 addAddressScreen2, GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase getHasUserPinnedLocationInCurrentOnboardingSessionUseCase) {
        addAddressScreen2.f53500l = getHasUserPinnedLocationInCurrentOnboardingSessionUseCase;
    }

    @InjectedFieldSignature("com.talabat.AddAddressScreen2.latLngFactory")
    public static void injectLatLngFactory(AddAddressScreen2 addAddressScreen2, LatLngFactory latLngFactory) {
        addAddressScreen2.f53505q = latLngFactory;
    }

    @InjectedFieldSignature("com.talabat.AddAddressScreen2.mapsInitializer")
    public static void injectMapsInitializer(AddAddressScreen2 addAddressScreen2, MapsInitializer mapsInitializer) {
        addAddressScreen2.f53506r = mapsInitializer;
    }

    @InjectedFieldSignature("com.talabat.AddAddressScreen2.modelsRepository")
    public static void injectModelsRepository(AddAddressScreen2 addAddressScreen2, ModelsRepository modelsRepository) {
        addAddressScreen2.f53504p = modelsRepository;
    }

    @InjectedFieldSignature("com.talabat.AddAddressScreen2.mutableLocationConfigurationRepository")
    public static void injectMutableLocationConfigurationRepository(AddAddressScreen2 addAddressScreen2, MutableLocationConfigurationRepository mutableLocationConfigurationRepository) {
        addAddressScreen2.f53499k = mutableLocationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.AddAddressScreen2.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(AddAddressScreen2 addAddressScreen2, ITalabatFeatureFlag iTalabatFeatureFlag) {
        addAddressScreen2.f53503o = iTalabatFeatureFlag;
    }

    @InjectedFieldSignature("com.talabat.AddAddressScreen2.talabatTracker")
    public static void injectTalabatTracker(AddAddressScreen2 addAddressScreen2, TalabatTracker talabatTracker) {
        addAddressScreen2.f53502n = talabatTracker;
    }

    @InjectedFieldSignature("com.talabat.AddAddressScreen2.userAddAddressScreenEventsListener")
    public static void injectUserAddAddressScreenEventsListener(AddAddressScreen2 addAddressScreen2, UserAddAddressScreenEventsListener userAddAddressScreenEventsListener) {
        addAddressScreen2.f53501m = userAddAddressScreenEventsListener;
    }

    public void injectMembers(AddAddressScreen2 addAddressScreen2) {
        injectAppVersionProvider(addAddressScreen2, this.appVersionProvider.get());
        injectConfigurationLocalRepository(addAddressScreen2, this.configurationLocalRepositoryProvider.get());
        injectMutableLocationConfigurationRepository(addAddressScreen2, this.mutableLocationConfigurationRepositoryProvider.get());
        injectGetHasUserPinnedLocationInCurrentOnboardingSessionUseCase(addAddressScreen2, this.getHasUserPinnedLocationInCurrentOnboardingSessionUseCaseProvider.get());
        injectUserAddAddressScreenEventsListener(addAddressScreen2, this.userAddAddressScreenEventsListenerProvider.get());
        injectTalabatTracker(addAddressScreen2, this.talabatTrackerProvider.get());
        injectTalabatFeatureFlag(addAddressScreen2, this.talabatFeatureFlagProvider.get());
        injectModelsRepository(addAddressScreen2, this.modelsRepositoryProvider.get());
        injectLatLngFactory(addAddressScreen2, this.latLngFactoryProvider.get());
        injectMapsInitializer(addAddressScreen2, this.mapsInitializerProvider.get());
        injectCameraUpdateFactory(addAddressScreen2, this.cameraUpdateFactoryProvider.get());
        injectAddressJsonProvider(addAddressScreen2, this.addressJsonProvider.get());
    }
}
