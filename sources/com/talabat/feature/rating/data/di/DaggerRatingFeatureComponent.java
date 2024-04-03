package com.talabat.feature.rating.data.di;

import android.content.Context;
import com.talabat.authentication.token.data.local.EncryptedStorageProvider;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.rating.data.RatingDataManagerImpl_Factory;
import com.talabat.feature.rating.data.RatingDataRepositoryImpl;
import com.talabat.feature.rating.data.RatingDataRepositoryImpl_Factory;
import com.talabat.feature.rating.data.RatingEventTracker;
import com.talabat.feature.rating.data.RatingEventTracker_Factory;
import com.talabat.feature.rating.data.RatingReasonMapperImpl_Factory;
import com.talabat.feature.rating.data.di.RatingFeatureComponent;
import com.talabat.feature.rating.data.remote.GetPastOrderApi;
import com.talabat.feature.rating.data.remote.GetPastOrdersService;
import com.talabat.feature.rating.data.remote.RatingFeedBackBaseUrl;
import com.talabat.feature.rating.data.remote.SubFeedBackApi;
import com.talabat.feature.rating.data.remote.SubmitFeedBackService;
import com.talabat.feature.rating.domain.EventTracker;
import com.talabat.feature.rating.domain.RatingDataManager;
import com.talabat.feature.rating.domain.RatingReasonMapper;
import com.talabat.feature.rating.domain.model.GetPastOrdersRequestParamsProvider;
import com.talabat.feature.rating.domain.repo.GetPastOrdersRepository;
import com.talabat.feature.rating.domain.repo.RatingDataRepository;
import com.talabat.feature.rating.domain.repo.RatingSession;
import com.talabat.feature.rating.domain.repo.SubmitFeedBackRepository;
import com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCase;
import com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl;
import com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerRatingFeatureComponent {

    public static final class Factory implements RatingFeatureComponent.Factory {
        private Factory() {
        }

        public RatingFeatureComponent create(ContextCoreLibApi contextCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, NetworkCoreLibApi networkCoreLibApi, TokenCoreLibApi tokenCoreLibApi, TrackingCoreLibApi trackingCoreLibApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(networkCoreLibApi);
            Preconditions.checkNotNull(tokenCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            return new RatingFeatureComponentImpl(contextCoreLibApi, configurationLocalCoreLibApi, networkCoreLibApi, tokenCoreLibApi, trackingCoreLibApi);
        }
    }

    public static final class RatingFeatureComponentImpl implements RatingFeatureComponent {
        private Provider<ConfigurationLocalCoreLibApi> configurationLocalCoreLibApiProvider;
        private final ContextCoreLibApi contextCoreLibApi;
        private Provider<Context> getContextProvider;
        private Provider<EncryptedStorageProvider> getEncryptedStorageProvider;
        private Provider<TalabatTracker> getTalabatTrackerProvider;
        private final NetworkCoreLibApi networkCoreLibApi;
        private Provider<Integer> provideCountryIdProvider;
        private Provider<GetPastOrdersRepository> provideGetPastOrderRepositoryProvider;
        private Provider<GetPastOrdersService> provideGetPastOrderServiceProvider;
        private Provider<GetPastOrdersRequestParamsProvider> provideGetPastOrdersRequestParamsProvider;
        private Provider<GetPastOrderApi> providePastOrderApiProvider;
        private Provider<ShouldRateLastOrderUseCase> provideProvider;
        private Provider<RatingReasonMapper> provideRateReasonMapperProvider;
        private Provider<RatingSession> provideRatingSessionProvider;
        private Provider<EventTracker> provideRatingTrackerProvider;
        private Provider<RatingDataManager> provideReasonMapperProvider;
        private Provider<RatingDataRepositoryImpl> ratingDataRepositoryImplProvider;
        private Provider<RatingDataRepository> ratingDataRepositoryProvider;
        private Provider<RatingEventTracker> ratingEventTrackerProvider;
        private final RatingFeatureComponentImpl ratingFeatureComponentImpl;
        private Provider<ShouldRateLastOrderUseCaseImpl> shouldRateLastOrderUseCaseImplProvider;
        private final TokenCoreLibApi tokenCoreLibApi;

        public static final class GetContextProvider implements Provider<Context> {
            private final ContextCoreLibApi contextCoreLibApi;

            public GetContextProvider(ContextCoreLibApi contextCoreLibApi2) {
                this.contextCoreLibApi = contextCoreLibApi2;
            }

            public Context get() {
                return (Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext());
            }
        }

        public static final class GetEncryptedStorageProviderProvider implements Provider<EncryptedStorageProvider> {
            private final TokenCoreLibApi tokenCoreLibApi;

            public GetEncryptedStorageProviderProvider(TokenCoreLibApi tokenCoreLibApi2) {
                this.tokenCoreLibApi = tokenCoreLibApi2;
            }

            public EncryptedStorageProvider get() {
                return (EncryptedStorageProvider) Preconditions.checkNotNullFromComponent(this.tokenCoreLibApi.getEncryptedStorageProvider());
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

        private RatingFeatureComponentImpl(ContextCoreLibApi contextCoreLibApi2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, NetworkCoreLibApi networkCoreLibApi2, TokenCoreLibApi tokenCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi) {
            this.ratingFeatureComponentImpl = this;
            this.networkCoreLibApi = networkCoreLibApi2;
            this.contextCoreLibApi = contextCoreLibApi2;
            this.tokenCoreLibApi = tokenCoreLibApi2;
            initialize(contextCoreLibApi2, configurationLocalCoreLibApi, networkCoreLibApi2, tokenCoreLibApi2, trackingCoreLibApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, NetworkCoreLibApi networkCoreLibApi2, TokenCoreLibApi tokenCoreLibApi2, TrackingCoreLibApi trackingCoreLibApi) {
            RatingNetworkModule_ProvidePastOrderApiFactory create = RatingNetworkModule_ProvidePastOrderApiFactory.create(RatingNetworkModule_ProvideBaseUrlFactory.create());
            this.providePastOrderApiProvider = create;
            RatingNetworkModule_ProvideGetPastOrderServiceFactory create2 = RatingNetworkModule_ProvideGetPastOrderServiceFactory.create(create);
            this.provideGetPastOrderServiceProvider = create2;
            this.provideGetPastOrderRepositoryProvider = RatingUserDataModule_ProvideGetPastOrderRepositoryFactory.create(create2);
            this.getContextProvider = new GetContextProvider(contextCoreLibApi2);
            GetEncryptedStorageProviderProvider getEncryptedStorageProviderProvider = new GetEncryptedStorageProviderProvider(tokenCoreLibApi2);
            this.getEncryptedStorageProvider = getEncryptedStorageProviderProvider;
            this.provideRatingSessionProvider = RatingUserDataModule_ProvideRatingSessionFactory.create(this.getContextProvider, getEncryptedStorageProviderProvider);
            dagger.internal.Factory create3 = InstanceFactory.create(configurationLocalCoreLibApi);
            this.configurationLocalCoreLibApiProvider = create3;
            RatingUserDataModule_ProvideCountryIdFactory create4 = RatingUserDataModule_ProvideCountryIdFactory.create(create3);
            this.provideCountryIdProvider = create4;
            RatingUserDataModule_ProvideGetPastOrdersRequestParamsFactory create5 = RatingUserDataModule_ProvideGetPastOrdersRequestParamsFactory.create(create4);
            this.provideGetPastOrdersRequestParamsProvider = create5;
            ShouldRateLastOrderUseCaseImpl_Factory create6 = ShouldRateLastOrderUseCaseImpl_Factory.create(this.provideGetPastOrderRepositoryProvider, this.provideRatingSessionProvider, create5);
            this.shouldRateLastOrderUseCaseImplProvider = create6;
            this.provideProvider = SingleCheck.provider(create6);
            this.provideRateReasonMapperProvider = SingleCheck.provider(RatingReasonMapperImpl_Factory.create());
            Provider<RatingDataManager> provider = SingleCheck.provider(RatingDataManagerImpl_Factory.create());
            this.provideReasonMapperProvider = provider;
            RatingDataRepositoryImpl_Factory create7 = RatingDataRepositoryImpl_Factory.create(this.provideRateReasonMapperProvider, provider);
            this.ratingDataRepositoryImplProvider = create7;
            this.ratingDataRepositoryProvider = SingleCheck.provider(create7);
            GetTalabatTrackerProvider getTalabatTrackerProvider2 = new GetTalabatTrackerProvider(trackingCoreLibApi);
            this.getTalabatTrackerProvider = getTalabatTrackerProvider2;
            RatingEventTracker_Factory create8 = RatingEventTracker_Factory.create(getTalabatTrackerProvider2);
            this.ratingEventTrackerProvider = create8;
            this.provideRatingTrackerProvider = SingleCheck.provider(create8);
        }

        private String namedString() {
            return RatingNetworkModule_ProvideBaseUrlForFeedbackFactory.provideBaseUrlForFeedback((BaseUrlFactory) Preconditions.checkNotNullFromComponent(this.networkCoreLibApi.getBaseUrlFactory()), new RatingFeedBackBaseUrl());
        }

        private SubFeedBackApi subFeedBackApi() {
            return RatingNetworkModule_ProvideSubFeedBackApiFactory.provideSubFeedBackApi(namedString());
        }

        private SubmitFeedBackService submitFeedBackService() {
            return RatingNetworkModule_ProvideSubmitFeedBackServiceFactory.provideSubmitFeedBackService(subFeedBackApi());
        }

        public RatingDataManager getRatingDataManager() {
            return this.provideReasonMapperProvider.get();
        }

        public RatingDataRepository getRatingDataRepository() {
            return this.ratingDataRepositoryProvider.get();
        }

        public EventTracker getRatingEventTracker() {
            return this.provideRatingTrackerProvider.get();
        }

        public RatingSession getRatingSession() {
            return RatingUserDataModule_ProvideRatingSessionFactory.provideRatingSession((Context) Preconditions.checkNotNullFromComponent(this.contextCoreLibApi.getContext()), (EncryptedStorageProvider) Preconditions.checkNotNullFromComponent(this.tokenCoreLibApi.getEncryptedStorageProvider()));
        }

        public ShouldRateLastOrderUseCase getShouldRateLastOrderUseCase() {
            return this.provideProvider.get();
        }

        public SubmitFeedBackRepository getSubmitFeedBackRepository() {
            return RatingUserDataModule_ProvideSubmitFeedBackRepositoryFactory.provideSubmitFeedBackRepository(submitFeedBackService());
        }
    }

    private DaggerRatingFeatureComponent() {
    }

    public static RatingFeatureComponent.Factory factory() {
        return new Factory();
    }
}
