package com.talabat.di.map;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.MapsActivity;
import com.talabat.MapsActivity_MembersInjector;
import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.di.map.MapsActivityComponent;
import com.talabat.location.domain.di.LocationCoreLibApi;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.ModelsRepository;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerMapsActivityComponent {

    public static final class Factory implements MapsActivityComponent.Factory {
        private Factory() {
        }

        public MapsActivityComponent create(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, LocationCoreLibApi locationCoreLibApi, MapsCoreLibApi mapsCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(locationCoreLibApi);
            Preconditions.checkNotNull(mapsCoreLibApi);
            Preconditions.checkNotNull(secretCoreLibApi);
            return new MapsActivityComponentImpl(configurationRemoteCoreLibApi, featureFlagCoreLibApi, locationCoreLibApi, mapsCoreLibApi, secretCoreLibApi);
        }
    }

    public static final class MapsActivityComponentImpl implements MapsActivityComponent {
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final MapsActivityComponentImpl mapsActivityComponentImpl;
        private final MapsCoreLibApi mapsCoreLibApi;
        private final SecretCoreLibApi secretCoreLibApi;

        private MapsActivityComponentImpl(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, LocationCoreLibApi locationCoreLibApi, MapsCoreLibApi mapsCoreLibApi2, SecretCoreLibApi secretCoreLibApi2) {
            this.mapsActivityComponentImpl = this;
            this.mapsCoreLibApi = mapsCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.secretCoreLibApi = secretCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private MapsActivity injectMapsActivity(MapsActivity mapsActivity) {
            MapsActivity_MembersInjector.injectCameraUpdateFactory(mapsActivity, (CameraUpdateFactory) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getCameraUpdateFactory()));
            MapsActivity_MembersInjector.injectAppVersionProvider(mapsActivity, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            MapsActivity_MembersInjector.injectTalabatFeatureFlag(mapsActivity, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            MapsActivity_MembersInjector.injectLocationConfigurationRepository(mapsActivity, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            MapsActivity_MembersInjector.injectModelsRepository(mapsActivity, (ModelsRepository) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getModelsRepository()));
            MapsActivity_MembersInjector.injectLatLngFactory(mapsActivity, (LatLngFactory) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getLatLngFactory()));
            MapsActivity_MembersInjector.injectMapsInitializer(mapsActivity, (MapsInitializer) Preconditions.checkNotNullFromComponent(this.mapsCoreLibApi.getMapsInitializer()));
            MapsActivity_MembersInjector.injectSecretProvider(mapsActivity, (SecretProvider) Preconditions.checkNotNullFromComponent(this.secretCoreLibApi.getSecretProvider()));
            return mapsActivity;
        }

        public void inject(MapsActivity mapsActivity) {
            injectMapsActivity(mapsActivity);
        }
    }

    private DaggerMapsActivityComponent() {
    }

    public static MapsActivityComponent.Factory factory() {
        return new Factory();
    }
}
