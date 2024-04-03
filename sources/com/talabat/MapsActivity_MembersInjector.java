package com.talabat;

import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.ModelsRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class MapsActivity_MembersInjector implements MembersInjector<MapsActivity> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<CameraUpdateFactory> cameraUpdateFactoryProvider;
    private final Provider<LatLngFactory> latLngFactoryProvider;
    private final Provider<LocationConfigurationRepository> locationConfigurationRepositoryProvider;
    private final Provider<MapsInitializer> mapsInitializerProvider;
    private final Provider<ModelsRepository> modelsRepositoryProvider;
    private final Provider<SecretProvider> secretProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public MapsActivity_MembersInjector(Provider<CameraUpdateFactory> provider, Provider<AppVersionProvider> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<LocationConfigurationRepository> provider4, Provider<ModelsRepository> provider5, Provider<LatLngFactory> provider6, Provider<MapsInitializer> provider7, Provider<SecretProvider> provider8) {
        this.cameraUpdateFactoryProvider = provider;
        this.appVersionProvider = provider2;
        this.talabatFeatureFlagProvider = provider3;
        this.locationConfigurationRepositoryProvider = provider4;
        this.modelsRepositoryProvider = provider5;
        this.latLngFactoryProvider = provider6;
        this.mapsInitializerProvider = provider7;
        this.secretProvider = provider8;
    }

    public static MembersInjector<MapsActivity> create(Provider<CameraUpdateFactory> provider, Provider<AppVersionProvider> provider2, Provider<ITalabatFeatureFlag> provider3, Provider<LocationConfigurationRepository> provider4, Provider<ModelsRepository> provider5, Provider<LatLngFactory> provider6, Provider<MapsInitializer> provider7, Provider<SecretProvider> provider8) {
        return new MapsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @InjectedFieldSignature("com.talabat.MapsActivity.appVersionProvider")
    public static void injectAppVersionProvider(MapsActivity mapsActivity, AppVersionProvider appVersionProvider2) {
        mapsActivity.B = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.MapsActivity.cameraUpdateFactory")
    public static void injectCameraUpdateFactory(MapsActivity mapsActivity, CameraUpdateFactory cameraUpdateFactory) {
        mapsActivity.f54322i = cameraUpdateFactory;
    }

    @InjectedFieldSignature("com.talabat.MapsActivity.latLngFactory")
    public static void injectLatLngFactory(MapsActivity mapsActivity, LatLngFactory latLngFactory) {
        mapsActivity.F = latLngFactory;
    }

    @InjectedFieldSignature("com.talabat.MapsActivity.locationConfigurationRepository")
    public static void injectLocationConfigurationRepository(MapsActivity mapsActivity, LocationConfigurationRepository locationConfigurationRepository) {
        mapsActivity.D = locationConfigurationRepository;
    }

    @InjectedFieldSignature("com.talabat.MapsActivity.mapsInitializer")
    public static void injectMapsInitializer(MapsActivity mapsActivity, MapsInitializer mapsInitializer) {
        mapsActivity.G = mapsInitializer;
    }

    @InjectedFieldSignature("com.talabat.MapsActivity.modelsRepository")
    public static void injectModelsRepository(MapsActivity mapsActivity, ModelsRepository modelsRepository) {
        mapsActivity.E = modelsRepository;
    }

    @InjectedFieldSignature("com.talabat.MapsActivity.secretProvider")
    public static void injectSecretProvider(MapsActivity mapsActivity, SecretProvider secretProvider2) {
        mapsActivity.H = secretProvider2;
    }

    @InjectedFieldSignature("com.talabat.MapsActivity.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(MapsActivity mapsActivity, ITalabatFeatureFlag iTalabatFeatureFlag) {
        mapsActivity.C = iTalabatFeatureFlag;
    }

    public void injectMembers(MapsActivity mapsActivity) {
        injectCameraUpdateFactory(mapsActivity, this.cameraUpdateFactoryProvider.get());
        injectAppVersionProvider(mapsActivity, this.appVersionProvider.get());
        injectTalabatFeatureFlag(mapsActivity, this.talabatFeatureFlagProvider.get());
        injectLocationConfigurationRepository(mapsActivity, this.locationConfigurationRepositoryProvider.get());
        injectModelsRepository(mapsActivity, this.modelsRepositoryProvider.get());
        injectLatLngFactory(mapsActivity, this.latLngFactoryProvider.get());
        injectMapsInitializer(mapsActivity, this.mapsInitializerProvider.get());
        injectSecretProvider(mapsActivity, this.secretProvider.get());
    }
}
