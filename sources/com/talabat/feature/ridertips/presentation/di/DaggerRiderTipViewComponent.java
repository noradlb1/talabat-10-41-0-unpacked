package com.talabat.feature.ridertips.presentation.di;

import android.content.Context;
import android.content.res.Resources;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.feature.ridertips.domain.IRiderTipObservability;
import com.talabat.feature.ridertips.domain.IRiderTipRepository;
import com.talabat.feature.ridertips.domain.IRiderTipTracker;
import com.talabat.feature.ridertips.domain.RiderTipFeatureApi;
import com.talabat.feature.ridertips.domain.usecases.GetRiderTipUseCase;
import com.talabat.feature.ridertips.domain.usecases.GetRiderTipUseCase_Factory;
import com.talabat.feature.ridertips.domain.usecases.SaveRiderTipUseCase;
import com.talabat.feature.ridertips.domain.usecases.SaveRiderTipUseCase_Factory;
import com.talabat.feature.ridertips.presentation.IResourceProvider;
import com.talabat.feature.ridertips.presentation.di.RiderTipViewComponent;
import com.talabat.feature.ridertips.presentation.mapper.IRiderTipDisplayModelMapper;
import com.talabat.feature.ridertips.presentation.view.RiderTipView;
import com.talabat.feature.ridertips.presentation.view.RiderTipView_MembersInjector;
import com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModel;
import com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModelFactory;
import com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModel_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerRiderTipViewComponent {

    public static final class Factory implements RiderTipViewComponent.Factory {
        private Factory() {
        }

        public RiderTipViewComponent create(Context context, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, RiderTipFeatureApi riderTipFeatureApi) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(riderTipFeatureApi);
            return new RiderTipViewComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, riderTipFeatureApi, context);
        }
    }

    public static final class RiderTipViewComponentImpl implements RiderTipViewComponent {
        private Provider<Context> contextProvider;
        private Provider<LocationConfigurationRepository> getLocationConfigurationRepositoryProvider;
        private Provider<IRiderTipRepository> getRepositoryProvider;
        private Provider<IRiderTipObservability> getRiderTipObservabilityProvider;
        private Provider<GetRiderTipUseCase> getRiderTipUseCaseProvider;
        private Provider<IRiderTipTracker> getTrackerProvider;
        private Provider<String> provideCurrencySymbolProvider;
        private Provider<String> provideDecimalPatternProvider;
        private Provider<Integer> provideNumOfDecimalPlacesProvider;
        private Provider<IResourceProvider> provideResourceProvider;
        private Provider<Resources> provideResourcesProvider;
        private Provider<IRiderTipDisplayModelMapper> provideRiderTipDisplayModelMapperProvider;
        private final RiderTipViewComponentImpl riderTipViewComponentImpl;
        private Provider<RiderTipViewModel> riderTipViewModelProvider;
        private Provider<SaveRiderTipUseCase> saveRiderTipUseCaseProvider;

        public static final class GetLocationConfigurationRepositoryProvider implements Provider<LocationConfigurationRepository> {
            private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;

            public GetLocationConfigurationRepositoryProvider(ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2) {
                this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            }

            public LocationConfigurationRepository get() {
                return (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository());
            }
        }

        public static final class GetRepositoryProvider implements Provider<IRiderTipRepository> {
            private final RiderTipFeatureApi riderTipFeatureApi;

            public GetRepositoryProvider(RiderTipFeatureApi riderTipFeatureApi2) {
                this.riderTipFeatureApi = riderTipFeatureApi2;
            }

            public IRiderTipRepository get() {
                return (IRiderTipRepository) Preconditions.checkNotNullFromComponent(this.riderTipFeatureApi.getRepository());
            }
        }

        public static final class GetRiderTipObservabilityProvider implements Provider<IRiderTipObservability> {
            private final RiderTipFeatureApi riderTipFeatureApi;

            public GetRiderTipObservabilityProvider(RiderTipFeatureApi riderTipFeatureApi2) {
                this.riderTipFeatureApi = riderTipFeatureApi2;
            }

            public IRiderTipObservability get() {
                return (IRiderTipObservability) Preconditions.checkNotNullFromComponent(this.riderTipFeatureApi.getRiderTipObservability());
            }
        }

        public static final class GetTrackerProvider implements Provider<IRiderTipTracker> {
            private final RiderTipFeatureApi riderTipFeatureApi;

            public GetTrackerProvider(RiderTipFeatureApi riderTipFeatureApi2) {
                this.riderTipFeatureApi = riderTipFeatureApi2;
            }

            public IRiderTipTracker get() {
                return (IRiderTipTracker) Preconditions.checkNotNullFromComponent(this.riderTipFeatureApi.getTracker());
            }
        }

        private RiderTipViewComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, RiderTipFeatureApi riderTipFeatureApi, Context context) {
            this.riderTipViewComponentImpl = this;
            initialize(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, riderTipFeatureApi, context);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, RiderTipFeatureApi riderTipFeatureApi, Context context) {
            GetRepositoryProvider getRepositoryProvider2 = new GetRepositoryProvider(riderTipFeatureApi);
            this.getRepositoryProvider = getRepositoryProvider2;
            this.getRiderTipUseCaseProvider = GetRiderTipUseCase_Factory.create(getRepositoryProvider2);
            GetLocationConfigurationRepositoryProvider getLocationConfigurationRepositoryProvider2 = new GetLocationConfigurationRepositoryProvider(configurationRemoteCoreLibApi);
            this.getLocationConfigurationRepositoryProvider = getLocationConfigurationRepositoryProvider2;
            this.provideCurrencySymbolProvider = RiderTipPresentationModule_ProvideCurrencySymbolFactory.create(getLocationConfigurationRepositoryProvider2);
            this.provideNumOfDecimalPlacesProvider = RiderTipPresentationModule_ProvideNumOfDecimalPlacesFactory.create(this.getLocationConfigurationRepositoryProvider);
            this.provideDecimalPatternProvider = RiderTipPresentationModule_ProvideDecimalPatternFactory.create(this.getLocationConfigurationRepositoryProvider);
            dagger.internal.Factory create = InstanceFactory.create(context);
            this.contextProvider = create;
            RiderTipPresentationModule_ProvideResourcesFactory create2 = RiderTipPresentationModule_ProvideResourcesFactory.create(create);
            this.provideResourcesProvider = create2;
            RiderTipPresentationModule_ProvideResourceProviderFactory create3 = RiderTipPresentationModule_ProvideResourceProviderFactory.create(create2);
            this.provideResourceProvider = create3;
            this.provideRiderTipDisplayModelMapperProvider = RiderTipPresentationModule_ProvideRiderTipDisplayModelMapperFactory.create(this.provideCurrencySymbolProvider, this.provideNumOfDecimalPlacesProvider, this.provideDecimalPatternProvider, create3);
            this.getTrackerProvider = new GetTrackerProvider(riderTipFeatureApi);
            GetRiderTipObservabilityProvider getRiderTipObservabilityProvider2 = new GetRiderTipObservabilityProvider(riderTipFeatureApi);
            this.getRiderTipObservabilityProvider = getRiderTipObservabilityProvider2;
            SaveRiderTipUseCase_Factory create4 = SaveRiderTipUseCase_Factory.create(this.getRepositoryProvider, getRiderTipObservabilityProvider2);
            this.saveRiderTipUseCaseProvider = create4;
            this.riderTipViewModelProvider = RiderTipViewModel_Factory.create(this.getRiderTipUseCaseProvider, this.provideRiderTipDisplayModelMapperProvider, this.getTrackerProvider, create4);
        }

        private RiderTipView injectRiderTipView(RiderTipView riderTipView) {
            RiderTipView_MembersInjector.injectFactory(riderTipView, riderTipViewModelFactory());
            return riderTipView;
        }

        private RiderTipViewModelFactory riderTipViewModelFactory() {
            return new RiderTipViewModelFactory(this.riderTipViewModelProvider);
        }

        public void inject(RiderTipView riderTipView) {
            injectRiderTipView(riderTipView);
        }
    }

    private DaggerRiderTipViewComponent() {
    }

    public static RiderTipViewComponent.Factory factory() {
        return new Factory();
    }
}
