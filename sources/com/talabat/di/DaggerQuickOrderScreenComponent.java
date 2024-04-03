package com.talabat.di;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.QuickOrderScreen;
import com.talabat.QuickOrderScreen_MembersInjector;
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
import com.talabat.di.QuickOrderScreenComponent;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import library.talabat.mvp.addressV2.AddAddressScreenEventsTalabatTracker;
import library.talabat.mvp.addressV2.AddressFormFormatJsonProvider;

@DaggerGenerated
public final class DaggerQuickOrderScreenComponent {

    public static final class Factory implements QuickOrderScreenComponent.Factory {
        private Factory() {
        }

        public QuickOrderScreenComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi, MapsCoreLibApi mapsCoreLibApi, PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ITalabatExperiment iTalabatExperiment) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(mutableConfigurationRemoteCoreLibApi);
            Preconditions.checkNotNull(mapsCoreLibApi);
            Preconditions.checkNotNull(pinlessCheckoutCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(iTalabatExperiment);
            return new QuickOrderScreenComponentImpl(configurationLocalCoreLibApi, mutableConfigurationRemoteCoreLibApi, mapsCoreLibApi, pinlessCheckoutCoreLibApi, trackingCoreLibApi, featureFlagCoreLibApi, iTalabatExperiment);
        }
    }

    public static final class QuickOrderScreenComponentImpl implements QuickOrderScreenComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final MapsCoreLibApi mapsCoreLibApi;
        private final MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi;
        private final PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi;
        private final QuickOrderScreenComponentImpl quickOrderScreenComponentImpl;
        private final ITalabatExperiment talabatExperiment;
        private final TrackingCoreLibApi trackingCoreLibApi;

        private QuickOrderScreenComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, MutableConfigurationRemoteCoreLibApi mutableConfigurationRemoteCoreLibApi2, MapsCoreLibApi mapsCoreLibApi2, PinlessCheckoutCoreLibApi pinlessCheckoutCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ITalabatExperiment iTalabatExperiment) {
            this.quickOrderScreenComponentImpl = this;
            this.mutableConfigurationRemoteCoreLibApi = mutableConfigurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.pinlessCheckoutCoreLibApi = pinlessCheckoutCoreLibApi2;
            this.trackingCoreLibApi = trackingCoreLibApi2;
            this.talabatExperiment = iTalabatExperiment;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.mapsCoreLibApi = mapsCoreLibApi2;
        }

        private AddAddressScreenEventsTalabatTracker addAddressScreenEventsTalabatTracker() {
            return new AddAddressScreenEventsTalabatTracker((TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker()), (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
        }

        private AddressFormFormatJsonProvider addressFormFormatJsonProvider() {
            return new AddressFormFormatJsonProvider(this.talabatExperiment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
        }

        @CanIgnoreReturnValue
        private QuickOrderScreen injectQuickOrderScreen(QuickOrderScreen quickOrderScreen) {
            QuickOrderScreen_MembersInjector.injectAppVersionProvider(quickOrderScreen, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getAppVersionProvider()));
            QuickOrderScreen_MembersInjector.injectConfigurationLocalRepository(quickOrderScreen, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            QuickOrderScreen_MembersInjector.injectMutableLocationConfigurationRepository(quickOrderScreen, (MutableLocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.mutableConfigurationRemoteCoreLibApi.getMutableLocationConfigurationRepository()));
            QuickOrderScreen_MembersInjector.injectGetHasUserPinnedLocationInCurrentOnboardingSessionUseCase(quickOrderScreen, (GetHasUserPinnedLocationInCurrentOnboardingSessionUseCase) Preconditions.checkNotNullFromComponent(this.pinlessCheckoutCoreLibApi.getGetHasUserPinnedLocationInCurrentOnboardingSessionUseCase()));
            QuickOrderScreen_MembersInjector.injectUserAddAddressScreenEventsListener(quickOrderScreen, addAddressScreenEventsTalabatTracker());
            QuickOrderScreen_MembersInjector.injectAddressJsonProvider(quickOrderScreen, addressFormFormatJsonProvider());
            QuickOrderScreen_MembersInjector.injectTalabatFeatureFlag(quickOrderScreen, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            QuickOrderScreen_MembersInjector.injectLatLngFactory(quickOrderScreen, (LatLngFactory) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getLatLngFactory()));
            QuickOrderScreen_MembersInjector.injectMapsInitializer(quickOrderScreen, (MapsInitializer) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getMapsInitializer()));
            QuickOrderScreen_MembersInjector.injectCameraUpdateFactory(quickOrderScreen, (CameraUpdateFactory) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getCameraUpdateFactory()));
            return quickOrderScreen;
        }

        public void inject(QuickOrderScreen quickOrderScreen) {
            injectQuickOrderScreen(quickOrderScreen);
        }
    }

    private DaggerQuickOrderScreenComponent() {
    }

    public static QuickOrderScreenComponent.Factory factory() {
        return new Factory();
    }
}
