package com.talabat.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.AddAddressScreen2;
import com.talabat.AddAddressScreen2_MembersInjector;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.MutableConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.pinless.checkout.domain.GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.di.AddAddressScreen2Component;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.ModelsRepository;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import library.talabat.mvp.addressV2.AddAddressScreenEventsTalabatTracker;
import library.talabat.mvp.addressV2.AddressFormFormatJsonProvider;

@DaggerGenerated
public final class DaggerAddAddressScreen2Component {

    public static final class AddAddressScreen2ComponentImpl implements AddAddressScreen2Component {
        private final AddAddressScreen2ComponentImpl addAddressScreen2ComponentImpl;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final MapsCoreLibApi mapsCoreLibApi;
        private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;
        private final PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi;
        private final ITalabatExperiment talabatExperiment;
        private final TrackingCoreLibApi trackingCoreLibApi;

        private AddAddressScreen2ComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2, MapsCoreLibApi mapsCoreLibApi2, PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ITalabatExperiment iTalabatExperiment) {
            this.addAddressScreen2ComponentImpl = this;
            this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.pinlessCheckoutCoreLibApi = pinlessCheckoutCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.mapsCoreLibApi = mapsCoreLibApi2;
            this.talabatExperiment = iTalabatExperiment;
        }

        private AddAddressScreenEventsTalabatTracker addAddressScreenEventsTalabatTracker() {
            return new AddAddressScreenEventsTalabatTracker((TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()), (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
        }

        private AddressFormFormatJsonProvider addressFormFormatJsonProvider() {
            return new AddressFormFormatJsonProvider(this.talabatExperiment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
        }

        @CanIgnoreReturnValue
        private AddAddressScreen2 injectAddAddressScreen2(AddAddressScreen2 addAddressScreen2) {
            AddAddressScreen2_MembersInjector.injectAppVersionProvider(addAddressScreen2, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getAppVersionProvider()));
            AddAddressScreen2_MembersInjector.injectConfigurationLocalRepository(addAddressScreen2, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            AddAddressScreen2_MembersInjector.injectMutableLocationConfigurationRepository(addAddressScreen2, (MutableLocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getMutableLocationConfigurationRepository()));
            AddAddressScreen2_MembersInjector.injectGetHasUserPinnedLocationInCurrentOnboardingSessionUseCase(addAddressScreen2, (GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase) Preconditions.checkNotNullFromComponent(this.pinlessCheckoutCoreLibApi.getGetHasUserPinnedLocationInCurrentOnboardingSessionUseCase()));
            AddAddressScreen2_MembersInjector.injectUserAddAddressScreenEventsListener(addAddressScreen2, addAddressScreenEventsTalabatTracker());
            AddAddressScreen2_MembersInjector.injectTalabatTracker(addAddressScreen2, (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()));
            AddAddressScreen2_MembersInjector.injectTalabatFeatureFlag(addAddressScreen2, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            AddAddressScreen2_MembersInjector.injectModelsRepository(addAddressScreen2, (ModelsRepository) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getModelsRepository()));
            AddAddressScreen2_MembersInjector.injectLatLngFactory(addAddressScreen2, (LatLngFactory) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getLatLngFactory()));
            AddAddressScreen2_MembersInjector.injectMapsInitializer(addAddressScreen2, (MapsInitializer) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getMapsInitializer()));
            AddAddressScreen2_MembersInjector.injectCameraUpdateFactory(addAddressScreen2, (CameraUpdateFactory) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getCameraUpdateFactory()));
            AddAddressScreen2_MembersInjector.injectAddressJsonProvider(addAddressScreen2, addressFormFormatJsonProvider());
            return addAddressScreen2;
        }

        public void inject(AddAddressScreen2 addAddressScreen2) {
            injectAddAddressScreen2(addAddressScreen2);
        }
    }

    public static final class Factory implements AddAddressScreen2Component.Factory {
        private Factory() {
        }

        public AddAddressScreen2Component create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi, MapsCoreLibApi mapsCoreLibApi, PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ITalabatExperiment iTalabatExperiment) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(mutableConfigurationRemoteCoreLibApi);
            Preconditions.checkNotNull(mapsCoreLibApi);
            Preconditions.checkNotNull(pinlessCheckoutCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(iTalabatExperiment);
            return new AddAddressScreen2ComponentImpl(configurationLocalCoreLibApi, mutableConfigurationRemoteCoreLibApi, mapsCoreLibApi, pinlessCheckoutCoreLibApi, trackingCoreLibApi, featureFlagCoreLibApi, iTalabatExperiment);
        }
    }

    private DaggerAddAddressScreen2Component() {
    }

    public static AddAddressScreen2Component.Factory factory() {
        return new Factory();
    }
}
