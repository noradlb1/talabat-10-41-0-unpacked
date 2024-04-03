package com.talabat.feature.subscriptions.data.di;

import com.talabat.authentication.aaa.di.SecretCoreLibApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.subscriptions.data.LegacySubscriptionStatusRepository_Factory;
import com.talabat.feature.subscriptions.data.SubscriptionsCustomerRepositoryImpl_Factory;
import com.talabat.feature.subscriptions.data.SubscriptionsFeatureFlagsRepositoryImpl;
import com.talabat.feature.subscriptions.data.SubscriptionsFeatureFlagsRepositoryImpl_Factory;
import com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl;
import com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl_Factory;
import com.talabat.feature.subscriptions.data.di.SubscriptionsFeatureComponent;
import com.talabat.feature.subscriptions.data.model.HeroBannerModelMapper_Factory;
import com.talabat.feature.subscriptions.data.model.ProCentralizationModelMapper;
import com.talabat.feature.subscriptions.data.model.ProCentralizationModelMapper_Factory;
import com.talabat.feature.subscriptions.data.model.ProVendorMovModelMapper_Factory;
import com.talabat.feature.subscriptions.data.model.SubscriptionCancellationReasonModelMapper_Factory;
import com.talabat.feature.subscriptions.data.model.SubscriptionModelMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionModelMapper_Factory;
import com.talabat.feature.subscriptions.data.model.SubscriptionMultiPlanModelMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionMultiPlanModelMapper_Factory;
import com.talabat.feature.subscriptions.data.model.SubscriptionOTPPaymentStatusMapper_Factory;
import com.talabat.feature.subscriptions.data.model.SubscriptionPaymentStatusModelMapper_Factory;
import com.talabat.feature.subscriptions.data.model.SubscriptionPlanModelMapper_Factory;
import com.talabat.feature.subscriptions.data.model.SubscriptionSavingsModelMapper_Factory;
import com.talabat.feature.subscriptions.data.model.SubscriptionUpgradePlanModelMapper_Factory;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingBannerAndPlansMapper;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingBannerAndPlansMapper_Factory;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingCapsuleCardMapper;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingCapsuleCardMapper_Factory;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingCardMapper;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingCardMapper_Factory;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingCardMoreContentItemMapper_Factory;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingCardMoreContentMapper;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingCardMoreContentMapper_Factory;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingCardSpanningTitleMapper_Factory;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingCarouselCardMapper;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingCarouselCardMapper_Factory;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingGridCardMapper;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingGridCardMapper_Factory;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingLottieCardMapper;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingLottieCardMapper_Factory;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingTagsCardMapper;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingTagsCardMapper_Factory;
import com.talabat.feature.subscriptions.data.remote.ProApi;
import com.talabat.feature.subscriptions.data.remote.ProBaseUrl_Factory;
import com.talabat.feature.subscriptions.data.remote.SubscriptionsApi;
import com.talabat.feature.subscriptions.data.remote.SubscriptionsBaseUrl_Factory;
import com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource;
import com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource_Factory;
import com.talabat.feature.subscriptions.data.remote.model.ProCentralizationResponseResult;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPlanResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionUpgradePlanResponseModel;
import com.talabat.feature.subscriptions.data.tracking.SubscriptionsTracker;
import com.talabat.feature.subscriptions.data.tracking.SubscriptionsTracker_Factory;
import com.talabat.feature.subscriptions.data.usecase.GetProCentralizationStatusUseCaseImpl;
import com.talabat.feature.subscriptions.data.usecase.GetProCentralizationStatusUseCaseImpl_Factory;
import com.talabat.feature.subscriptions.data.usecase.GetTProOrderStatusUseCaseImpl;
import com.talabat.feature.subscriptions.data.usecase.GetTProOrderStatusUseCaseImpl_Factory;
import com.talabat.feature.subscriptions.data.usecase.SubscriptionPaymentOTPUseCaseImpl;
import com.talabat.feature.subscriptions.data.usecase.SubscriptionPaymentOTPUseCaseImpl_Factory;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.model.ProCentralization;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionUpgradePlan;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import com.talabat.feature.subscriptions.domain.usecase.SubscriptionPaymentOTPUseCase;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
public final class DaggerSubscriptionsFeatureComponent {

    public static final class Factory implements SubscriptionsFeatureComponent.Factory {
        private Factory() {
        }

        public SubscriptionsFeatureComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, NetworkCoreLibApi networkCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(secretCoreLibApi);
            return new SubscriptionsFeatureComponentImpl(configurationLocalCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi, networkCoreLibApi, trackingCoreLibApi, featureFlagCoreLibApi, experimentCoreLibApi, secretCoreLibApi);
        }
    }

    public static final class SubscriptionsFeatureComponentImpl implements SubscriptionsFeatureComponent {
        private Provider<BaseUrlFactory> getBaseUrlFactoryProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<ITalabatExperiment> getExperimentProvider;
        private Provider<OkHttpClient> getOkHttpClientProvider;
        private Provider<GetProCentralizationStatusUseCaseImpl> getProCentralizationStatusUseCaseImplProvider;
        private Provider<GetProCentralizationStatusUseCase> getProCentralizationStatusUseCaseProvider;
        private Provider<Retrofit.Builder> getRetrofitWithMoshiProvider;
        private Provider<SecretProvider> getSecretProvider;
        private Provider<SubscriptionPaymentOTPUseCase> getSubscriptionPaymentOTPUseCaseProvider;
        private Provider<ISubscriptionsCustomerRepository> getSubscriptionsCustomerRepositoryProvider;
        private Provider<GetTProOrderStatusUseCaseImpl> getTProOrderStatusUseCaseImplProvider;
        private Provider<GetTProOrderStatusUseCase> getTProOrderStatusUseCaseProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<TalabatTracker> getTalabatTrackerProvider;
        private Provider<ModelMapper<ProCentralizationResponseResult, ProCentralization>> proCentralizationModelMapperMapperProvider;
        private Provider<ProCentralizationModelMapper> proCentralizationModelMapperProvider;
        private Provider<String> provideBaseUrlProvider;
        private Provider<ProApi> provideProApiProvider;
        private Provider<String> provideProBaseUrlProvider;
        private Provider<SubscriptionsApi> provideSubscriptionsApiProvider;
        private Provider<SubscriptionModelMapper> subscriptionModelMapperProvider;
        private Provider<SubscriptionMultiPlanModelMapper> subscriptionMultiPlanModelMapperProvider;
        private Provider<SubscriptionPaymentOTPUseCaseImpl> subscriptionPaymentOTPUseCaseImplProvider;
        private Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;
        private Provider<SubscriptionsDataSource> subscriptionsDataSourceProvider;
        private final SubscriptionsFeatureComponentImpl subscriptionsFeatureComponentImpl;
        private Provider<SubscriptionsFeatureFlagsRepositoryImpl> subscriptionsFeatureFlagsRepositoryImplProvider;
        private Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFeatureFlagsRepositoryProvider;
        private Provider<ModelMapper<SubscriptionResponseModel, Subscription>> subscriptionsMapperProvider;
        private Provider<ModelMapper<SubscriptionPlanResponseModel, SubscriptionPlan>> subscriptionsPlanMapperProvider;
        private Provider<SubscriptionsRepositoryImpl> subscriptionsRepositoryImplProvider;
        private Provider<ISubscriptionsRepository> subscriptionsRepositoryProvider;
        private Provider<SubscriptionsTracker> subscriptionsTrackerProvider;
        private Provider<ISubscriptionsTracker> subscriptionsTrackerProvider2;
        private Provider<ModelMapper<SubscriptionUpgradePlanResponseModel, SubscriptionUpgradePlan>> subscriptionsUpgradePlanMapperProvider;
        private Provider<TProOnBoardingBannerAndPlansMapper> tProOnBoardingBannerAndPlansMapperProvider;
        private Provider<TProOnBoardingCapsuleCardMapper> tProOnBoardingCapsuleCardMapperProvider;
        private Provider<TProOnBoardingCardMapper> tProOnBoardingCardMapperProvider;
        private Provider<TProOnBoardingCardMoreContentMapper> tProOnBoardingCardMoreContentMapperProvider;
        private Provider<TProOnBoardingCarouselCardMapper> tProOnBoardingCarouselCardMapperProvider;
        private Provider<TProOnBoardingGridCardMapper> tProOnBoardingGridCardMapperProvider;
        private Provider<TProOnBoardingLottieCardMapper> tProOnBoardingLottieCardMapperProvider;
        private Provider<TProOnBoardingTagsCardMapper> tProOnBoardingTagsCardMapperProvider;

        public static final class GetBaseUrlFactoryProvider implements Provider<BaseUrlFactory> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetBaseUrlFactoryProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public BaseUrlFactory get() {
                return (BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory());
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

        public static final class GetExperimentProviderProvider implements Provider<ITalabatExperiment> {
            private final ExperimentCoreLibApi experimentCoreLibApi;

            public GetExperimentProviderProvider(ExperimentCoreLibApi experimentCoreLibApi2) {
                this.experimentCoreLibApi = experimentCoreLibApi2;
            }

            public ITalabatExperiment get() {
                return (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider());
            }
        }

        public static final class GetOkHttpClientProvider implements Provider<OkHttpClient> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetOkHttpClientProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public OkHttpClient get() {
                return (OkHttpClient) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getOkHttpClient());
            }
        }

        public static final class GetRetrofitWithMoshiProvider implements Provider<Retrofit.Builder> {
            private final NetworkCoreLibApi networkCoreLibApi;

            public GetRetrofitWithMoshiProvider(NetworkCoreLibApi networkCoreLibApi2) {
                this.networkCoreLibApi = networkCoreLibApi2;
            }

            public Retrofit.Builder get() {
                return (Retrofit.Builder) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getRetrofitWithMoshi());
            }
        }

        public static final class GetSecretProviderProvider implements Provider<SecretProvider> {
            private final SecretCoreLibApi secretCoreLibApi;

            public GetSecretProviderProvider(SecretCoreLibApi secretCoreLibApi2) {
                this.secretCoreLibApi = secretCoreLibApi2;
            }

            public SecretProvider get() {
                return (SecretProvider) Preconditions.checkNotNullFromComponent(this.secretCoreLibApi.getSecretProvider());
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

        private SubscriptionsFeatureComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, NetworkCoreLibApi networkCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            this.subscriptionsFeatureComponentImpl = this;
            initialize(configurationLocalCoreLibApi, contextCoreLibApi, dispatcherCoreLibApi, networkCoreLibApi, trackingCoreLibApi, featureFlagCoreLibApi, experimentCoreLibApi, secretCoreLibApi);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ContextCoreLibApi contextCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, NetworkCoreLibApi networkCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi, SecretCoreLibApi secretCoreLibApi) {
            NetworkCoreLibApi networkCoreLibApi2 = networkCoreLibApi;
            GetBaseUrlFactoryProvider getBaseUrlFactoryProvider2 = new GetBaseUrlFactoryProvider(networkCoreLibApi2);
            this.getBaseUrlFactoryProvider = getBaseUrlFactoryProvider2;
            this.provideBaseUrlProvider = SubscriptionsNetworkModule_ProvideBaseUrlFactory.create(getBaseUrlFactoryProvider2, SubscriptionsBaseUrl_Factory.create());
            this.getOkHttpClientProvider = new GetOkHttpClientProvider(networkCoreLibApi2);
            GetRetrofitWithMoshiProvider getRetrofitWithMoshiProvider2 = new GetRetrofitWithMoshiProvider(networkCoreLibApi2);
            this.getRetrofitWithMoshiProvider = getRetrofitWithMoshiProvider2;
            this.provideSubscriptionsApiProvider = SubscriptionsNetworkModule_ProvideSubscriptionsApiFactory.create(this.provideBaseUrlProvider, this.getOkHttpClientProvider, getRetrofitWithMoshiProvider2);
            SubscriptionsNetworkModule_ProvideProBaseUrlFactory create = SubscriptionsNetworkModule_ProvideProBaseUrlFactory.create(this.getBaseUrlFactoryProvider, ProBaseUrl_Factory.create());
            this.provideProBaseUrlProvider = create;
            this.provideProApiProvider = SubscriptionsNetworkModule_ProvideProApiFactory.create(create, this.getOkHttpClientProvider);
            GetSecretProviderProvider getSecretProviderProvider = new GetSecretProviderProvider(secretCoreLibApi);
            this.getSecretProvider = getSecretProviderProvider;
            this.subscriptionsDataSourceProvider = SubscriptionsDataSource_Factory.create(this.provideSubscriptionsApiProvider, this.provideProApiProvider, getSecretProviderProvider);
            this.subscriptionsPlanMapperProvider = SingleCheck.provider(SubscriptionPlanModelMapper_Factory.create());
            Provider<ModelMapper<SubscriptionUpgradePlanResponseModel, SubscriptionUpgradePlan>> provider = SingleCheck.provider(SubscriptionUpgradePlanModelMapper_Factory.create());
            this.subscriptionsUpgradePlanMapperProvider = provider;
            SubscriptionModelMapper_Factory create2 = SubscriptionModelMapper_Factory.create(this.subscriptionsPlanMapperProvider, provider);
            this.subscriptionModelMapperProvider = create2;
            Provider<ModelMapper<SubscriptionResponseModel, Subscription>> provider2 = SingleCheck.provider(create2);
            this.subscriptionsMapperProvider = provider2;
            ProCentralizationModelMapper_Factory create3 = ProCentralizationModelMapper_Factory.create(provider2);
            this.proCentralizationModelMapperProvider = create3;
            this.proCentralizationModelMapperMapperProvider = SingleCheck.provider(create3);
            this.subscriptionMultiPlanModelMapperProvider = SubscriptionMultiPlanModelMapper_Factory.create(SubscriptionPlanModelMapper_Factory.create());
            this.tProOnBoardingCardMoreContentMapperProvider = TProOnBoardingCardMoreContentMapper_Factory.create(TProOnBoardingCardMoreContentItemMapper_Factory.create());
            this.tProOnBoardingCapsuleCardMapperProvider = TProOnBoardingCapsuleCardMapper_Factory.create(TProOnBoardingCardSpanningTitleMapper_Factory.create(), this.tProOnBoardingCardMoreContentMapperProvider);
            this.tProOnBoardingTagsCardMapperProvider = TProOnBoardingTagsCardMapper_Factory.create(TProOnBoardingCardSpanningTitleMapper_Factory.create(), this.tProOnBoardingCardMoreContentMapperProvider);
            this.tProOnBoardingGridCardMapperProvider = TProOnBoardingGridCardMapper_Factory.create(TProOnBoardingCardSpanningTitleMapper_Factory.create(), this.tProOnBoardingCardMoreContentMapperProvider);
            this.tProOnBoardingLottieCardMapperProvider = TProOnBoardingLottieCardMapper_Factory.create(TProOnBoardingCardSpanningTitleMapper_Factory.create(), this.tProOnBoardingCardMoreContentMapperProvider);
            TProOnBoardingCarouselCardMapper_Factory create4 = TProOnBoardingCarouselCardMapper_Factory.create(TProOnBoardingCardSpanningTitleMapper_Factory.create(), this.tProOnBoardingCardMoreContentMapperProvider);
            this.tProOnBoardingCarouselCardMapperProvider = create4;
            this.tProOnBoardingCardMapperProvider = TProOnBoardingCardMapper_Factory.create(this.tProOnBoardingCapsuleCardMapperProvider, this.tProOnBoardingTagsCardMapperProvider, this.tProOnBoardingGridCardMapperProvider, this.tProOnBoardingLottieCardMapperProvider, create4);
            this.tProOnBoardingBannerAndPlansMapperProvider = TProOnBoardingBannerAndPlansMapper_Factory.create(this.subscriptionMultiPlanModelMapperProvider, HeroBannerModelMapper_Factory.create(), this.tProOnBoardingCardMapperProvider, TProOnBoardingCardSpanningTitleMapper_Factory.create());
            SubscriptionsRepositoryImpl_Factory create5 = SubscriptionsRepositoryImpl_Factory.create(this.subscriptionsDataSourceProvider, SubscriptionPaymentStatusModelMapper_Factory.create(), this.subscriptionsMapperProvider, this.proCentralizationModelMapperMapperProvider, this.subscriptionMultiPlanModelMapperProvider, ProVendorMovModelMapper_Factory.create(), SubscriptionSavingsModelMapper_Factory.create(), SubscriptionCancellationReasonModelMapper_Factory.create(), SubscriptionOTPPaymentStatusMapper_Factory.create(), this.tProOnBoardingBannerAndPlansMapperProvider);
            this.subscriptionsRepositoryImplProvider = create5;
            this.subscriptionsRepositoryProvider = SingleCheck.provider(create5);
            GetTalabatTrackerProvider getTalabatTrackerProvider2 = new GetTalabatTrackerProvider(trackingCoreLibApi);
            this.getTalabatTrackerProvider = getTalabatTrackerProvider2;
            SubscriptionsTracker_Factory create6 = SubscriptionsTracker_Factory.create(getTalabatTrackerProvider2, SubscriptionsUserDataModule_ProvideGlobalDataModelFactory.create(), SubscriptionsUserDataModule_ProvidesDateUtilsFactory.create());
            this.subscriptionsTrackerProvider = create6;
            this.subscriptionsTrackerProvider2 = SingleCheck.provider(create6);
            this.getTalabatFeatureFlagProvider = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            GetExperimentProviderProvider getExperimentProviderProvider = new GetExperimentProviderProvider(experimentCoreLibApi);
            this.getExperimentProvider = getExperimentProviderProvider;
            SubscriptionsFeatureFlagsRepositoryImpl_Factory create7 = SubscriptionsFeatureFlagsRepositoryImpl_Factory.create(this.getTalabatFeatureFlagProvider, getExperimentProviderProvider);
            this.subscriptionsFeatureFlagsRepositoryImplProvider = create7;
            this.subscriptionsFeatureFlagsRepositoryProvider = SingleCheck.provider(create7);
            this.subscriptionStatusRepositoryProvider = SingleCheck.provider(LegacySubscriptionStatusRepository_Factory.create());
            DispatcherCoreLibApi dispatcherCoreLibApi2 = dispatcherCoreLibApi;
            GetCoroutineDispatchersFactoryProvider getCoroutineDispatchersFactoryProvider2 = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi);
            this.getCoroutineDispatchersFactoryProvider = getCoroutineDispatchersFactoryProvider2;
            GetTProOrderStatusUseCaseImpl_Factory create8 = GetTProOrderStatusUseCaseImpl_Factory.create(this.subscriptionsFeatureFlagsRepositoryProvider, this.subscriptionStatusRepositoryProvider, this.subscriptionsTrackerProvider2, this.subscriptionsRepositoryImplProvider, getCoroutineDispatchersFactoryProvider2);
            this.getTProOrderStatusUseCaseImplProvider = create8;
            this.getTProOrderStatusUseCaseProvider = SingleCheck.provider(create8);
            this.getSubscriptionsCustomerRepositoryProvider = SingleCheck.provider(SubscriptionsCustomerRepositoryImpl_Factory.create());
            SubscriptionPaymentOTPUseCaseImpl_Factory create9 = SubscriptionPaymentOTPUseCaseImpl_Factory.create(this.subscriptionsRepositoryProvider);
            this.subscriptionPaymentOTPUseCaseImplProvider = create9;
            this.getSubscriptionPaymentOTPUseCaseProvider = SingleCheck.provider(create9);
            GetProCentralizationStatusUseCaseImpl_Factory create10 = GetProCentralizationStatusUseCaseImpl_Factory.create(this.subscriptionsRepositoryProvider, this.subscriptionStatusRepositoryProvider);
            this.getProCentralizationStatusUseCaseImplProvider = create10;
            this.getProCentralizationStatusUseCaseProvider = SingleCheck.provider(create10);
        }

        public GetProCentralizationStatusUseCase getGetProCentralizationStatusUseCase() {
            return this.getProCentralizationStatusUseCaseProvider.get();
        }

        public GetTProOrderStatusUseCase getGetTProOrderStatusUseCase() {
            return this.getTProOrderStatusUseCaseProvider.get();
        }

        public ISubscriptionsRepository getRepository() {
            return this.subscriptionsRepositoryProvider.get();
        }

        public SubscriptionPaymentOTPUseCase getSubscriptionPaymentOTPUseCase() {
            return this.getSubscriptionPaymentOTPUseCaseProvider.get();
        }

        public ISubscriptionStatusRepository getSubscriptionStatusRepository() {
            return this.subscriptionStatusRepositoryProvider.get();
        }

        public ISubscriptionsCustomerRepository getSubscriptionsCustomerRepository() {
            return this.getSubscriptionsCustomerRepositoryProvider.get();
        }

        public ISubscriptionsFeatureFlagsRepository getSubscriptionsFeatureFlagRepository() {
            return this.subscriptionsFeatureFlagsRepositoryProvider.get();
        }

        public ISubscriptionsTracker getTracker() {
            return this.subscriptionsTrackerProvider2.get();
        }
    }

    private DaggerSubscriptionsFeatureComponent() {
    }

    public static SubscriptionsFeatureComponent.Factory factory() {
        return new Factory();
    }
}
