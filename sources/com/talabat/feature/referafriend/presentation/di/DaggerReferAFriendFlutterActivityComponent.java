package com.talabat.feature.referafriend.presentation.di;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.referafriend.domain.di.ReferAFriendFeatureApi;
import com.talabat.feature.referafriend.presentation.di.ReferAFriendFlutterActivityComponent;
import com.talabat.feature.referafriend.presentation.ui.ReferAFriendReceiverFlutterActivity;
import com.talabat.feature.referafriend.presentation.ui.ReferAFriendReceiverFlutterActivity_MembersInjector;
import com.talabat.feature.referafriend.presentation.viewmodel.ReferAFriendViewModel;
import com.talabat.feature.referafriend.presentation.viewmodel.ReferAFriendViewModelFactory;
import com.talabat.feature.referafriend.presentation.viewmodel.ReferAFriendViewModel_Factory;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase_Factory;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepositoryImpl;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerReferAFriendFlutterActivityComponent {

    public static final class Factory implements ReferAFriendFlutterActivityComponent.Factory {
        private Factory() {
        }

        public ReferAFriendFlutterActivityComponent create(ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ReferAFriendFeatureApi referAFriendFeatureApi) {
            Preconditions.checkNotNull(contextCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            Preconditions.checkNotNull(referAFriendFeatureApi);
            return new ReferAFriendFlutterActivityComponentImpl(contextCoreLibApi, featureFlagCoreLibApi, trackingCoreLibApi, configurationLocalCoreLibApi, dispatcherCoreLibApi, referAFriendFeatureApi);
        }
    }

    public static final class ReferAFriendFlutterActivityComponentImpl implements ReferAFriendFlutterActivityComponent {
        private Provider<Context> getContextProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider;
        private Provider<ITalabatFeatureFlag> getTalabatFeatureFlagProvider;
        private Provider<TalabatTracker> getTalabatTrackerProvider;
        private Provider<GrowthTracker> provideGrowthTrackerProvider;
        private Provider<VoucherRepositoryImpl> provideVoucherRepositoryProvider;
        private Provider<RedeemVoucherCodeUseCase> redeemVoucherCodeUseCaseProvider;
        private final ReferAFriendFlutterActivityComponentImpl referAFriendFlutterActivityComponentImpl;
        private Provider<ReferAFriendViewModel> referAFriendViewModelProvider;

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

        public static final class GetRepositoryProvider implements Provider<ConfigurationLocalRepository> {
            private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;

            public GetRepositoryProvider(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
                this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            }

            public ConfigurationLocalRepository get() {
                return (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository());
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

        private ReferAFriendFlutterActivityComponentImpl(ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ReferAFriendFeatureApi referAFriendFeatureApi) {
            this.referAFriendFlutterActivityComponentImpl = this;
            initialize(contextCoreLibApi, featureFlagCoreLibApi, trackingCoreLibApi, configurationLocalCoreLibApi, dispatcherCoreLibApi, referAFriendFeatureApi);
        }

        private void initialize(ContextCoreLibApi contextCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, TrackingCoreLibApi trackingCoreLibApi, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi, ReferAFriendFeatureApi referAFriendFeatureApi) {
            GetContextProvider getContextProvider2 = new GetContextProvider(contextCoreLibApi);
            this.getContextProvider = getContextProvider2;
            this.provideVoucherRepositoryProvider = SingleCheck.provider(VoucherRepositoryModule_ProvideVoucherRepositoryFactory.create(getContextProvider2));
            GetTalabatTrackerProvider getTalabatTrackerProvider2 = new GetTalabatTrackerProvider(trackingCoreLibApi);
            this.getTalabatTrackerProvider = getTalabatTrackerProvider2;
            this.provideGrowthTrackerProvider = GrowthTrackerModule_ProvideGrowthTrackerFactory.create(getTalabatTrackerProvider2);
            GetTalabatFeatureFlagProvider getTalabatFeatureFlagProvider2 = new GetTalabatFeatureFlagProvider(featureFlagCoreLibApi);
            this.getTalabatFeatureFlagProvider = getTalabatFeatureFlagProvider2;
            this.redeemVoucherCodeUseCaseProvider = RedeemVoucherCodeUseCase_Factory.create(this.provideVoucherRepositoryProvider, this.provideGrowthTrackerProvider, getTalabatFeatureFlagProvider2);
            this.getRepositoryProvider = new GetRepositoryProvider(configurationLocalCoreLibApi);
            GetCoroutineDispatchersFactoryProvider getCoroutineDispatchersFactoryProvider2 = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi);
            this.getCoroutineDispatchersFactoryProvider = getCoroutineDispatchersFactoryProvider2;
            this.referAFriendViewModelProvider = ReferAFriendViewModel_Factory.create(this.redeemVoucherCodeUseCaseProvider, this.getRepositoryProvider, getCoroutineDispatchersFactoryProvider2);
        }

        private ReferAFriendReceiverFlutterActivity injectReferAFriendReceiverFlutterActivity(ReferAFriendReceiverFlutterActivity referAFriendReceiverFlutterActivity) {
            ReferAFriendReceiverFlutterActivity_MembersInjector.injectFactory(referAFriendReceiverFlutterActivity, referAFriendViewModelFactory());
            return referAFriendReceiverFlutterActivity;
        }

        private ReferAFriendViewModelFactory referAFriendViewModelFactory() {
            return new ReferAFriendViewModelFactory(this.referAFriendViewModelProvider);
        }

        public void inject(ReferAFriendReceiverFlutterActivity referAFriendReceiverFlutterActivity) {
            injectReferAFriendReceiverFlutterActivity(referAFriendReceiverFlutterActivity);
        }
    }

    private DaggerReferAFriendFlutterActivityComponent() {
    }

    public static ReferAFriendFlutterActivityComponent.Factory factory() {
        return new Factory();
    }
}
