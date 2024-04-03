package com.talabat.feature.uladdressform.data.di;

import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.uladdressform.data.di.AddressFormFeatureComponent;
import com.talabat.feature.uladdressform.data.repository.AddressFormFWFRepositoryImpl;
import com.talabat.feature.uladdressform.data.repository.AddressFormFWFRepositoryImpl_Factory;
import com.talabat.feature.uladdressform.domain.repository.AddressFormFWFRepository;
import com.talabat.feature.uladdressform.domain.usecase.AddressFormRouteUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerAddressFormFeatureComponent {

    public static final class AddressFormFeatureComponentImpl implements AddressFormFeatureComponent {
        private Provider<AddressFormFWFRepositoryImpl> addressFormFWFRepositoryImplProvider;
        private Provider<AddressFormFWFRepository> addressFormFWFRepositoryImplProvider2;
        private final AddressFormFeatureComponentImpl addressFormFeatureComponentImpl;
        private Provider<ITalabatExperiment> getExperimentProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;

        public static final class GetExperimentProviderProvider implements Provider<ITalabatExperiment> {
            private final ExperimentCoreLibApi experimentCoreLibApi;

            public GetExperimentProviderProvider(ExperimentCoreLibApi experimentCoreLibApi2) {
                this.experimentCoreLibApi = experimentCoreLibApi2;
            }

            public ITalabatExperiment get() {
                return (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider());
            }
        }

        public static final class GetTalabatFeatureFlagProvider implements Provider<ITalabatFeatureFlag> {
            private final FeatureFlagCoreLibApi featureFlagCoreLibApi;

            public GetTalabatFeatureFlagProvider(FeatureFlagCoreLibApi featureFlagCoreLibApi2) {
                this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            }

            public ITalabatFeatureFlag get() {
                return (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag());
            }
        }

        private AddressFormFeatureComponentImpl(ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            this.addressFormFeatureComponentImpl = this;
            initialize(experimentCoreLibApi, featureFlagCoreLibApi);
        }

        private void initialize(ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            this.getExperimentProvider = new GetExperimentProviderProvider(experimentCoreLibApi);
            GetTalabatFeatureFlagProvider getTalabatFeatureFlagProvider2 = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            this.getTalabatFeatureFlagProvider = getTalabatFeatureFlagProvider2;
            AddressFormFWFRepositoryImpl_Factory create = AddressFormFWFRepositoryImpl_Factory.create(this.getExperimentProvider, getTalabatFeatureFlagProvider2);
            this.addressFormFWFRepositoryImplProvider = create;
            this.addressFormFWFRepositoryImplProvider2 = SingleCheck.provider(create);
        }

        public AddressFormRouteUseCase getAddressFormRouteUseCase() {
            return new AddressFormRouteUseCase(this.addressFormFWFRepositoryImplProvider2.get());
        }
    }

    public static final class Factory implements AddressFormFeatureComponent.Factory {
        private Factory() {
        }

        public AddressFormFeatureComponent create(ExperimentCoreLibApi experimentCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi) {
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            return new AddressFormFeatureComponentImpl(experimentCoreLibApi, featureFlagCoreLibApi);
        }
    }

    private DaggerAddressFormFeatureComponent() {
    }

    public static AddressFormFeatureComponent.Factory factory() {
        return new Factory();
    }
}
