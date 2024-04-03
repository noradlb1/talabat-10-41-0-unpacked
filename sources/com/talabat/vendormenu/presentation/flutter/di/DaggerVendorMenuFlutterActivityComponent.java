package com.talabat.vendormenu.presentation.flutter.di;

import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase_Factory;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.feature.tpro.presentation.di.TProVendorMovModule_ProvideIsTproNfvEnabledFactory;
import com.talabat.feature.tpro.presentation.di.TProVendorMovModule_ProvideIsTproUserFactory;
import com.talabat.feature.tpro.presentation.di.TProVendorMovModule_ProvideTproPlanMOVFactory;
import com.talabat.feature.tpro.presentation.helperview.mov.VendorMovViewModel;
import com.talabat.feature.tpro.presentation.helperview.mov.VendorMovViewModelFactory;
import com.talabat.feature.tpro.presentation.helperview.mov.VendorMovViewModel_Factory;
import com.talabat.vendormenu.presentation.flutter.VendorMenuFlutterActivity;
import com.talabat.vendormenu.presentation.flutter.VendorMenuFlutterActivity_MembersInjector;
import com.talabat.vendormenu.presentation.flutter.di.VendorMenuFlutterActivityComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;

@DaggerGenerated
public final class DaggerVendorMenuFlutterActivityComponent {

    public static final class Factory implements VendorMenuFlutterActivityComponent.Factory {
        private Factory() {
        }

        public VendorMenuFlutterActivityComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi, TrackingCoreLibApi trackingCoreLibApi, CoroutineScope coroutineScope) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(coroutineScope);
            return new VendorMenuFlutterActivityComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, observabilityCoreLibApi, subscriptionsFeatureApi, trackingCoreLibApi, coroutineScope);
        }
    }

    public static final class VendorMenuFlutterActivityComponentImpl implements VendorMenuFlutterActivityComponent {
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private Provider<ISubscriptionsRepository> getRepositoryProvider;
        private Provider<ISubscriptionStatusRepository> getSubscriptionStatusRepositoryProvider;
        private Provider<ISubscriptionsFeatureFlagsRepository> getSubscriptionsFeatureFlagRepositoryProvider;
        private Provider<GetTProVendorMovUseCase> getTProVendorMovUseCaseProvider;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private Provider<Boolean> provideIsTproNfvEnabledProvider;
        private Provider<Boolean> provideIsTproUserProvider;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;
        private final VendorMenuFlutterActivityComponentImpl vendorMenuFlutterActivityComponentImpl;
        private Provider<VendorMovViewModel> vendorMovViewModelProvider;

        public static final class GetRepositoryProvider implements Provider<ISubscriptionsRepository> {
            private final SubscriptionsFeatureApi subscriptionsFeatureApi;

            public GetRepositoryProvider(SubscriptionsFeatureApi subscriptionsFeatureApi2) {
                this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            }

            public ISubscriptionsRepository get() {
                return (ISubscriptionsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getRepository());
            }
        }

        public static final class GetSubscriptionStatusRepositoryProvider implements Provider<ISubscriptionStatusRepository> {
            private final SubscriptionsFeatureApi subscriptionsFeatureApi;

            public GetSubscriptionStatusRepositoryProvider(SubscriptionsFeatureApi subscriptionsFeatureApi2) {
                this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            }

            public ISubscriptionStatusRepository get() {
                return (ISubscriptionStatusRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionStatusRepository());
            }
        }

        public static final class GetSubscriptionsFeatureFlagRepositoryProvider implements Provider<ISubscriptionsFeatureFlagsRepository> {
            private final SubscriptionsFeatureApi subscriptionsFeatureApi;

            public GetSubscriptionsFeatureFlagRepositoryProvider(SubscriptionsFeatureApi subscriptionsFeatureApi2) {
                this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            }

            public ISubscriptionsFeatureFlagsRepository get() {
                return (ISubscriptionsFeatureFlagsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsFeatureFlagRepository());
            }
        }

        private VendorMenuFlutterActivityComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, TrackingCoreLibApi trackingCoreLibApi, CoroutineScope coroutineScope) {
            this.vendorMenuFlutterActivityComponentImpl = this;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            initialize(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi2, observabilityCoreLibApi2, subscriptionsFeatureApi2, trackingCoreLibApi, coroutineScope);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, TrackingCoreLibApi trackingCoreLibApi, CoroutineScope coroutineScope) {
            GetRepositoryProvider getRepositoryProvider2 = new GetRepositoryProvider(subscriptionsFeatureApi2);
            this.getRepositoryProvider = getRepositoryProvider2;
            this.getTProVendorMovUseCaseProvider = GetTProVendorMovUseCase_Factory.create(getRepositoryProvider2);
            GetSubscriptionsFeatureFlagRepositoryProvider getSubscriptionsFeatureFlagRepositoryProvider2 = new GetSubscriptionsFeatureFlagRepositoryProvider(subscriptionsFeatureApi2);
            this.getSubscriptionsFeatureFlagRepositoryProvider = getSubscriptionsFeatureFlagRepositoryProvider2;
            this.provideIsTproNfvEnabledProvider = TProVendorMovModule_ProvideIsTproNfvEnabledFactory.create(getSubscriptionsFeatureFlagRepositoryProvider2);
            GetSubscriptionStatusRepositoryProvider getSubscriptionStatusRepositoryProvider2 = new GetSubscriptionStatusRepositoryProvider(subscriptionsFeatureApi2);
            this.getSubscriptionStatusRepositoryProvider = getSubscriptionStatusRepositoryProvider2;
            TProVendorMovModule_ProvideIsTproUserFactory create = TProVendorMovModule_ProvideIsTproUserFactory.create(getSubscriptionStatusRepositoryProvider2);
            this.provideIsTproUserProvider = create;
            this.vendorMovViewModelProvider = VendorMovViewModel_Factory.create(this.getTProVendorMovUseCaseProvider, this.provideIsTproNfvEnabledProvider, create, TProVendorMovModule_ProvideTproPlanMOVFactory.create());
        }

        private VendorMenuFlutterActivity injectVendorMenuFlutterActivity(VendorMenuFlutterActivity vendorMenuFlutterActivity) {
            VendorMenuFlutterActivity_MembersInjector.injectTalabatFeatureFlag(vendorMenuFlutterActivity, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            VendorMenuFlutterActivity_MembersInjector.injectScreenTracker(vendorMenuFlutterActivity, (IScreenTracker) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getScreenTracker()));
            VendorMenuFlutterActivity_MembersInjector.injectVendorMovViewModelFactory(vendorMenuFlutterActivity, vendorMovViewModelFactory());
            VendorMenuFlutterActivity_MembersInjector.injectSubscriptionStatusRepository(vendorMenuFlutterActivity, (ISubscriptionStatusRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionStatusRepository()));
            VendorMenuFlutterActivity_MembersInjector.injectProCentralizationStatusWrapper(vendorMenuFlutterActivity, proCentralizationStatusWrapper());
            return vendorMenuFlutterActivity;
        }

        private ProCentralizationStatusWrapper proCentralizationStatusWrapper() {
            return new ProCentralizationStatusWrapper((GetProCentralizationStatusUseCase) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getGetProCentralizationStatusUseCase()), (ISubscriptionsCustomerRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsCustomerRepository()));
        }

        private VendorMovViewModelFactory vendorMovViewModelFactory() {
            return new VendorMovViewModelFactory(this.vendorMovViewModelProvider);
        }

        public void inject(VendorMenuFlutterActivity vendorMenuFlutterActivity) {
            injectVendorMenuFlutterActivity(vendorMenuFlutterActivity);
        }
    }

    private DaggerVendorMenuFlutterActivityComponent() {
    }

    public static VendorMenuFlutterActivityComponent.Factory factory() {
        return new Factory();
    }
}
