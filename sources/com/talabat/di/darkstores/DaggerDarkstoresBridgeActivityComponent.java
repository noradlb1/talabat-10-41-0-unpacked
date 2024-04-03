package com.talabat.di.darkstores;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.darkstores.view.DarkstoresBridgeActivity;
import com.talabat.darkstores.view.DarkstoresBridgeActivity_MembersInjector;
import com.talabat.di.darkstores.DarkstoresBridgeActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerDarkstoresBridgeActivityComponent {

    public static final class DarkstoresBridgeActivityComponentImpl implements DarkstoresBridgeActivityComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DarkstoresBridgeActivityComponentImpl darkstoresBridgeActivityComponentImpl;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;

        private DarkstoresBridgeActivityComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2) {
            this.darkstoresBridgeActivityComponentImpl = this;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
        }

        @CanIgnoreReturnValue
        private DarkstoresBridgeActivity injectDarkstoresBridgeActivity(DarkstoresBridgeActivity darkstoresBridgeActivity) {
            DarkstoresBridgeActivity_MembersInjector.injectAppVersionProvider(darkstoresBridgeActivity, (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()));
            DarkstoresBridgeActivity_MembersInjector.injectDiscoveryConfigurationRepository(darkstoresBridgeActivity, (DiscoveryConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getDiscoveryConfigurationRepository()));
            DarkstoresBridgeActivity_MembersInjector.injectConfigurationLocalRepository(darkstoresBridgeActivity, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            DarkstoresBridgeActivity_MembersInjector.injectTalabatFeatureFlag(darkstoresBridgeActivity, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            DarkstoresBridgeActivity_MembersInjector.injectLocationConfigRepository(darkstoresBridgeActivity, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            DarkstoresBridgeActivity_MembersInjector.injectObservabilityManager(darkstoresBridgeActivity, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            return darkstoresBridgeActivity;
        }

        public void inject(DarkstoresBridgeActivity darkstoresBridgeActivity) {
            injectDarkstoresBridgeActivity(darkstoresBridgeActivity);
        }
    }

    public static final class Factory implements DarkstoresBridgeActivityComponent.Factory {
        private Factory() {
        }

        public DarkstoresBridgeActivityComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new DarkstoresBridgeActivityComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi);
        }
    }

    private DaggerDarkstoresBridgeActivityComponent() {
    }

    public static DarkstoresBridgeActivityComponent.Factory factory() {
        return new Factory();
    }
}
