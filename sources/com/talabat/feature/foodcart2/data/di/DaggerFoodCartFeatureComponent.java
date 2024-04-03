package com.talabat.feature.foodcart2.data.di;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.feature.foodcart2.data.FoodCartRepository;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import com.talabat.feature.foodcart2.data.di.FoodCartFeatureComponent;
import com.talabat.feature.foodcart2.domain.IFoodCartRepository;
import com.talabat.fluttercore.engine.EngineProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerFoodCartFeatureComponent {

    public static final class Factory implements FoodCartFeatureComponent.Factory {
        private Factory() {
        }

        public FoodCartFeatureComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, ContextCoreLibApi contextCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new FoodCartFeatureComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, contextCoreLibApi, observabilityCoreLibApi, experimentCoreLibApi, featureFlagCoreLibApi);
        }
    }

    public static final class FoodCartFeatureComponentImpl implements FoodCartFeatureComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final ContextCoreLibApi contextCoreLibApi;
        private final ExperimentCoreLibApi experimentCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final FoodCartFeatureComponentImpl foodCartFeatureComponentImpl;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;

        private FoodCartFeatureComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, ContextCoreLibApi contextCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, ExperimentCoreLibApi experimentCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
            this.foodCartFeatureComponentImpl = this;
            this.contextCoreLibApi = contextCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.experimentCoreLibApi = experimentCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
        }

        private EngineProvider engineProvider() {
            return new EngineProvider((Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext()), (AppVersionProvider) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getAppVersionProvider()), (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()), (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()), (PaymentConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getPaymentConfigurationRepository()), (TermsAndConditionsConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getTermsAndConditionsConfigurationRepository()), (IScreenTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getScreenTracker()), (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
        }

        private FoodCartFlutterDataSourceImpl foodCartFlutterDataSourceImpl() {
            return new FoodCartFlutterDataSourceImpl(engineProvider(), (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider()), (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()), (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
        }

        private FoodCartRepository foodCartRepository() {
            return new FoodCartRepository(foodCartFlutterDataSourceImpl());
        }

        public IFoodCartRepository getRepository() {
            return foodCartRepository();
        }
    }

    private DaggerFoodCartFeatureComponent() {
    }

    public static FoodCartFeatureComponent.Factory factory() {
        return new Factory();
    }
}
