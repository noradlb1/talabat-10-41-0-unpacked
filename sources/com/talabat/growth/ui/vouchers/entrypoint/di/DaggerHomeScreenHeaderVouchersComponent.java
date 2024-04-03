package com.talabat.growth.ui.vouchers.entrypoint.di;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.referafriend.presentation.di.GrowthTrackerModule_ProvideGrowthTrackerFactory;
import com.talabat.feature.referafriend.presentation.di.VoucherRepositoryModule_ProvideVoucherRepositoryFactory;
import com.talabat.growth.ui.vouchers.entrypoint.HomeScreenHeaderVouchersView;
import com.talabat.growth.ui.vouchers.entrypoint.HomeScreenHeaderVouchersView_MembersInjector;
import com.talabat.growth.ui.vouchers.entrypoint.di.HomeScreenHeaderVouchersComponent;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModel;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModelFactory;
import com.talabat.growth.ui.vouchers.entrypoint.viewmodel.VoucherEntryPointViewModel_Factory;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ActiveVouchersUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ActiveVouchersUseCase_Factory;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.VoucherCountTextUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.VoucherCountTextUseCase_Factory;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerHomeScreenHeaderVouchersComponent {

    public static final class Factory implements HomeScreenHeaderVouchersComponent.Factory {
        private Factory() {
        }

        public HomeScreenHeaderVouchersComponent create(ContextCoreLibApi contextCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, NavigationCoreLibApi navigationCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            return new HomeScreenHeaderVouchersComponentImpl(contextCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, dispatcherCoreLibApi, observabilityCoreLibApi, configurationLocalCoreLibApi, navigationCoreLibApi, trackingCoreLibApi);
        }
    }

    public static final class HomeScreenHeaderVouchersComponentImpl implements HomeScreenHeaderVouchersComponent {
        private Provider<ActiveVouchersUseCase> activeVouchersUseCaseProvider;
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final DispatcherCoreLibApi dispatcherCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private Provider<Context> getContextProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<IObservabilityManager> getObservabilityManagerProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<TalabatTracker> getTalabatTrackerProvider;
        private final HomeScreenHeaderVouchersComponentImpl homeScreenHeaderVouchersComponentImpl;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private Provider<GrowthTracker> provideGrowthTrackerProvider;
        private Provider<VoucherRepositoryImpl> provideVoucherRepositoryProvider;
        private Provider<VoucherCountTextUseCase> voucherCountTextUseCaseProvider;
        private Provider<VoucherEntryPointViewModel> voucherEntryPointViewModelProvider;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        public static final class GetCoroutineDispatchersFactoryProvider implements Provider<CoroutineDispatchersFactory> {
            private final DispatcherCoreLibApi dispatcherCoreLibApi;

            public GetCoroutineDispatchersFactoryProvider(DispatcherCoreLibApi dispatcherCoreLibApi2) {
                this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            }

            public CoroutineDispatchersFactory get() {
                return (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory());
            }
        }

        public static final class GetObservabilityManagerProvider implements Provider<IObservabilityManager> {
            private final ObservabilityCoreLibApi observabilityCoreLibApi;

            public GetObservabilityManagerProvider(ObservabilityCoreLibApi observabilityCoreLibApi2) {
                this.observabilityCoreLibApi = observabilityCoreLibApi2;
            }

            public IObservabilityManager get() {
                return (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager());
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

        public static final class GetTalabatTrackerProvider implements Provider<TalabatTracker> {
            private final TrackingCoreLibApi trackingCoreLibApi;

            public GetTalabatTrackerProvider(TrackingCoreLibApi trackingCoreLibApi2) {
                this.trackingCoreLibApi = trackingCoreLibApi2;
            }

            public TalabatTracker get() {
                return (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker());
            }
        }

        private HomeScreenHeaderVouchersComponentImpl(ContextCoreLibApi contextCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi) {
            this.homeScreenHeaderVouchersComponentImpl = this;
            this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            initialize(contextCoreLibApi, configurationRemoteCoreLibApi2, featureFlagCoreLibApi2, dispatcherCoreLibApi2, observabilityCoreLibApi, configurationLocalCoreLibApi2, navigationCoreLibApi2, trackingCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, DispatcherCoreLibApi dispatcherCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, NavigationCoreLibApi navigationCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi) {
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            this.provideVoucherRepositoryProvider = SingleCheck.provider(VoucherRepositoryModule_ProvideVoucherRepositoryFactory.create(getContextProvider2));
            GetObservabilityManagerProvider getObservabilityManagerProvider2 = new GetObservabilityManagerProvider(observabilityCoreLibApi);
            this.getObservabilityManagerProvider = getObservabilityManagerProvider2;
            this.activeVouchersUseCaseProvider = ActiveVouchersUseCase_Factory.create(this.provideVoucherRepositoryProvider, getObservabilityManagerProvider2);
            this.voucherCountTextUseCaseProvider = VoucherCountTextUseCase_Factory.create(this.getContextProvider);
            this.configurationLocalCoreLibApiProvider = InstanceFactory.create(configurationLocalCoreLibApi2);
            this.getCoroutineDispatchersFactoryProvider = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi2);
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi2);
            GetTalabatTrackerProvider getTalabatTrackerProvider2 = new GetTalabatTrackerProvider(trackingCoreLibApi);
            this.getTalabatTrackerProvider = getTalabatTrackerProvider2;
            GrowthTrackerModule_ProvideGrowthTrackerFactory create = GrowthTrackerModule_ProvideGrowthTrackerFactory.create(getTalabatTrackerProvider2);
            this.provideGrowthTrackerProvider = create;
            this.voucherEntryPointViewModelProvider = VoucherEntryPointViewModel_Factory.create(this.activeVouchersUseCaseProvider, this.voucherCountTextUseCaseProvider, this.configurationLocalCoreLibApiProvider, this.getCoroutineDispatchersFactoryProvider, this.getTalabatFeatureFlagProvider, this.getObservabilityManagerProvider, create);
        }

        private HomeScreenHeaderVouchersView injectHomeScreenHeaderVouchersView(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView) {
            HomeScreenHeaderVouchersView_MembersInjector.injectCoroutineDispatchersFactory(homeScreenHeaderVouchersView, (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory()));
            HomeScreenHeaderVouchersView_MembersInjector.injectFeatureFlagRepo(homeScreenHeaderVouchersView, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            HomeScreenHeaderVouchersView_MembersInjector.injectLocationConfigurationRepository(homeScreenHeaderVouchersView, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            HomeScreenHeaderVouchersView_MembersInjector.injectConfigurationLocalRepository(homeScreenHeaderVouchersView, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            HomeScreenHeaderVouchersView_MembersInjector.injectNavigator(homeScreenHeaderVouchersView, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            HomeScreenHeaderVouchersView_MembersInjector.injectFactory(homeScreenHeaderVouchersView, voucherEntryPointViewModelFactory());
            return homeScreenHeaderVouchersView;
        }

        private VoucherEntryPointViewModelFactory voucherEntryPointViewModelFactory() {
            return new VoucherEntryPointViewModelFactory(this.voucherEntryPointViewModelProvider);
        }

        public void inject(HomeScreenHeaderVouchersView homeScreenHeaderVouchersView) {
            injectHomeScreenHeaderVouchersView(homeScreenHeaderVouchersView);
        }
    }

    private DaggerHomeScreenHeaderVouchersComponent() {
    }

    public static HomeScreenHeaderVouchersComponent.Factory factory() {
        return new Factory();
    }
}
