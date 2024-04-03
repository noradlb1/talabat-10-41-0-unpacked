package com.talabat.feature.tpro.presentation.di;

import android.content.Context;
import android.content.res.Resources;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.CancelFreeTrialUseCase;
import com.talabat.feature.subscriptions.domain.usecase.CancelFreeTrialUseCase_Factory;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetActiveSubscriptionsUseCase_Factory;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase_Factory;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionCancellationReasonsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionCancellationReasonsUseCase_Factory;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionDetailsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionDetailsUseCase_Factory;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionMultiPlanUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionMultiPlanUseCase_Factory;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionPaymentUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionPaymentUseCase_Factory;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionWithB2BVoucherUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionWithB2BVoucherUseCase_Factory;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionsUseCase_Factory;
import com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase_Factory;
import com.talabat.feature.subscriptions.domain.usecase.SendCancellationFeedbackUseCase;
import com.talabat.feature.subscriptions.domain.usecase.SendCancellationFeedbackUseCase_Factory;
import com.talabat.feature.subscriptions.domain.usecase.SubscriptionPaymentOTPUseCase;
import com.talabat.feature.subscriptions.domain.usecase.TProOnBoardingBannerAndPlansUseCase;
import com.talabat.feature.subscriptions.domain.usecase.TProOnBoardingBannerAndPlansUseCase_Factory;
import com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase;
import com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase_Factory;
import com.talabat.feature.subscriptions.domain.usecase.UpgradeSubscriptionPlanUseCase;
import com.talabat.feature.subscriptions.domain.usecase.UpgradeSubscriptionPlanUseCase_Factory;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper_Factory;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsActivity;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment;
import com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment_MembersInjector;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.MultiPlanParams;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.MultiPlanParams_Factory;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModelFactory;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel_Factory;
import com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerView;
import com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerViewModel;
import com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerViewModelFactory;
import com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerViewModel_Factory;
import com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerView_MembersInjector;
import com.talabat.feature.tpro.presentation.di.TproPresentationComponent;
import com.talabat.feature.tpro.presentation.helperview.mov.TProVendorMovView;
import com.talabat.feature.tpro.presentation.helperview.mov.TProVendorMovView_MembersInjector;
import com.talabat.feature.tpro.presentation.helperview.mov.VendorMovViewModel;
import com.talabat.feature.tpro.presentation.helperview.mov.VendorMovViewModelFactory;
import com.talabat.feature.tpro.presentation.helperview.mov.VendorMovViewModel_Factory;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.SubscriptionCancellationReasonBottomSheetFragment;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.SubscriptionCancellationReasonBottomSheetFragment_MembersInjector;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.viewModel.SubscriptionCancellationReasonsViewModel;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.viewModel.SubscriptionCancellationReasonsViewModelFactory;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.viewModel.SubscriptionCancellationReasonsViewModel_Factory;
import com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment;
import com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment_MembersInjector;
import com.talabat.feature.tpro.presentation.management.details.upgrade.details.TproUpgradeDetailsBottomSheetFragment;
import com.talabat.feature.tpro.presentation.management.details.upgrade.details.TproUpgradeDetailsBottomSheetFragment_MembersInjector;
import com.talabat.feature.tpro.presentation.management.details.upgrade.details.viewModel.TproUpgradeDetailsViewModel;
import com.talabat.feature.tpro.presentation.management.details.upgrade.details.viewModel.TproUpgradeDetailsViewModelFactory;
import com.talabat.feature.tpro.presentation.management.details.upgrade.details.viewModel.TproUpgradeDetailsViewModel_Factory;
import com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel;
import com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModelFactory;
import com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel_Factory;
import com.talabat.feature.tpro.presentation.multiplan.TProPlanSelectionFragment;
import com.talabat.feature.tpro.presentation.multiplan.TProPlanSelectionFragment_MembersInjector;
import com.talabat.feature.tpro.presentation.multiplan.viewmodel.TProPlanSelectionViewModel;
import com.talabat.feature.tpro.presentation.multiplan.viewmodel.TProPlanSelectionViewModelFactory;
import com.talabat.feature.tpro.presentation.multiplan.viewmodel.TProPlanSelectionViewModel_Factory;
import com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragment;
import com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragment_MembersInjector;
import com.talabat.feature.tpro.presentation.payment.viewmodel.TProPaymentBottomSheetViewModel;
import com.talabat.feature.tpro.presentation.payment.viewmodel.TProPaymentBottomSheetViewModelFactory;
import com.talabat.feature.tpro.presentation.payment.viewmodel.TProPaymentBottomSheetViewModel_Factory;
import com.talabat.feature.tpro.presentation.savings.TProSavingsCancellationBottomSheetFragment;
import com.talabat.feature.tpro.presentation.savings.TProSavingsCancellationBottomSheetFragment_MembersInjector;
import com.talabat.feature.tpro.presentation.welcome.TProWelcomeBottomSheetFragment;
import com.talabat.feature.tpro.presentation.welcome.TProWelcomeBottomSheetFragment_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerTproPresentationComponent {

    public static final class Factory implements TproPresentationComponent.Factory {
        private Factory() {
        }

        public TproPresentationComponent create(Context context, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi, NavigationCoreLibApi navigationCoreLibApi, DeepLinkCoreLibApi deepLinkCoreLibApi, ObservabilityCoreLibApi observabilityCoreLibApi) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            Preconditions.checkNotNull(navigationCoreLibApi);
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            Preconditions.checkNotNull(observabilityCoreLibApi);
            return new TproPresentationComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, subscriptionsFeatureApi, navigationCoreLibApi, deepLinkCoreLibApi, observabilityCoreLibApi, context);
        }
    }

    public static final class TproPresentationComponentImpl implements TproPresentationComponent {
        private Provider<CancelFreeTrialUseCase> cancelFreeTrialUseCaseProvider;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private Provider<Context> contextProvider;
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private Provider<GetActiveSubscriptionsUseCase> getActiveSubscriptionsUseCaseProvider;
        private Provider<GetProCentralizationStatusUseCase> getGetProCentralizationStatusUseCaseProvider;
        private Provider<ConfigurationLocalRepository> getRepositoryProvider;
        private Provider<ISubscriptionsRepository> getRepositoryProvider2;
        private Provider<GetSavingsInfoUseCase> getSavingsInfoUseCaseProvider;
        private Provider<GetSubscriptionCancellationReasonsUseCase> getSubscriptionCancellationReasonsUseCaseProvider;
        private Provider<GetSubscriptionDetailsUseCase> getSubscriptionDetailsUseCaseProvider;
        private Provider<GetSubscriptionMultiPlanUseCase> getSubscriptionMultiPlanUseCaseProvider;
        private Provider<SubscriptionPaymentOTPUseCase> getSubscriptionPaymentOTPUseCaseProvider;
        private Provider<GetSubscriptionPaymentUseCase> getSubscriptionPaymentUseCaseProvider;
        private Provider<ISubscriptionStatusRepository> getSubscriptionStatusRepositoryProvider;
        private Provider<GetSubscriptionWithB2BVoucherUseCase> getSubscriptionWithB2BVoucherUseCaseProvider;
        private Provider<ISubscriptionsCustomerRepository> getSubscriptionsCustomerRepositoryProvider;
        private Provider<ISubscriptionsFeatureFlagsRepository> getSubscriptionsFeatureFlagRepositoryProvider;
        private Provider<GetSubscriptionsUseCase> getSubscriptionsUseCaseProvider;
        private Provider<GetTProVendorMovUseCase> getTProVendorMovUseCaseProvider;
        private Provider<ISubscriptionsTracker> getTrackerProvider;
        private Provider<MultiPlanParams> multiPlanParamsProvider;
        private final NavigationCoreLibApi navigationCoreLibApi;
        private final ObservabilityCoreLibApi observabilityCoreLibApi;
        private Provider<ProCentralizationStatusWrapper> proCentralizationStatusWrapperProvider;
        private Provider<Integer> provideCountryIdProvider;
        private Provider<Boolean> provideIsTproNfvEnabledProvider;
        private Provider<Boolean> provideIsTproUserProvider;
        private Provider<Resources> provideResourcesProvider;
        private Provider<SendCancellationFeedbackUseCase> sendCancellationFeedbackUseCaseProvider;
        private Provider<SubscriptionAtCheckoutBannerViewModel> subscriptionAtCheckoutBannerViewModelProvider;
        private Provider<SubscriptionCancellationReasonsViewModel> subscriptionCancellationReasonsViewModelProvider;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;
        private Provider<TProOnBoardingBannerAndPlansUseCase> tProOnBoardingBannerAndPlansUseCaseProvider;
        private Provider<TProPaymentBottomSheetViewModel> tProPaymentBottomSheetViewModelProvider;
        private Provider<TProPlanSelectionViewModel> tProPlanSelectionViewModelProvider;
        private Provider<TproBenefitsViewModel> tproBenefitsViewModelProvider;
        private final TproPresentationComponentImpl tproPresentationComponentImpl;
        private Provider<TproSubscriptionDetailsViewModel> tproSubscriptionDetailsViewModelProvider;
        private Provider<TproUpgradeDetailsViewModel> tproUpgradeDetailsViewModelProvider;
        private Provider<UpdateAutoRenewalUseCase> updateAutoRenewalUseCaseProvider;
        private Provider<UpgradeSubscriptionPlanUseCase> upgradeSubscriptionPlanUseCaseProvider;
        private Provider<VendorMovViewModel> vendorMovViewModelProvider;

        public static final class GetGetProCentralizationStatusUseCaseProvider implements Provider<GetProCentralizationStatusUseCase> {
            private final SubscriptionsFeatureApi subscriptionsFeatureApi;

            public GetGetProCentralizationStatusUseCaseProvider(SubscriptionsFeatureApi subscriptionsFeatureApi2) {
                this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            }

            public GetProCentralizationStatusUseCase get() {
                return (GetProCentralizationStatusUseCase) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getGetProCentralizationStatusUseCase());
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

        public static final class GetRepositoryProvider2 implements Provider<ISubscriptionsRepository> {
            private final SubscriptionsFeatureApi subscriptionsFeatureApi;

            public GetRepositoryProvider2(SubscriptionsFeatureApi subscriptionsFeatureApi2) {
                this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            }

            public ISubscriptionsRepository get() {
                return (ISubscriptionsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getRepository());
            }
        }

        public static final class GetSubscriptionPaymentOTPUseCaseProvider implements Provider<SubscriptionPaymentOTPUseCase> {
            private final SubscriptionsFeatureApi subscriptionsFeatureApi;

            public GetSubscriptionPaymentOTPUseCaseProvider(SubscriptionsFeatureApi subscriptionsFeatureApi2) {
                this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            }

            public SubscriptionPaymentOTPUseCase get() {
                return (SubscriptionPaymentOTPUseCase) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionPaymentOTPUseCase());
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

        public static final class GetSubscriptionsCustomerRepositoryProvider implements Provider<ISubscriptionsCustomerRepository> {
            private final SubscriptionsFeatureApi subscriptionsFeatureApi;

            public GetSubscriptionsCustomerRepositoryProvider(SubscriptionsFeatureApi subscriptionsFeatureApi2) {
                this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            }

            public ISubscriptionsCustomerRepository get() {
                return (ISubscriptionsCustomerRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsCustomerRepository());
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

        public static final class GetTrackerProvider implements Provider<ISubscriptionsTracker> {
            private final SubscriptionsFeatureApi subscriptionsFeatureApi;

            public GetTrackerProvider(SubscriptionsFeatureApi subscriptionsFeatureApi2) {
                this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            }

            public ISubscriptionsTracker get() {
                return (ISubscriptionsTracker) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getTracker());
            }
        }

        private TproPresentationComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, NavigationCoreLibApi navigationCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, Context context) {
            this.tproPresentationComponentImpl = this;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
            this.observabilityCoreLibApi = observabilityCoreLibApi2;
            this.navigationCoreLibApi = navigationCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            initialize(configurationLocalCoreLibApi, configurationRemoteCoreLibApi2, subscriptionsFeatureApi2, navigationCoreLibApi2, deepLinkCoreLibApi2, observabilityCoreLibApi2, context);
        }

        private void initialize(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2, NavigationCoreLibApi navigationCoreLibApi2, DeepLinkCoreLibApi deepLinkCoreLibApi2, ObservabilityCoreLibApi observabilityCoreLibApi2, Context context) {
            SubscriptionsFeatureApi subscriptionsFeatureApi3 = subscriptionsFeatureApi2;
            dagger.internal.Factory create = InstanceFactory.create(context);
            this.contextProvider = create;
            this.provideResourcesProvider = TproPresentationModule_ProvideResourcesFactory.create(create);
            ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2 = configurationLocalCoreLibApi;
            GetRepositoryProvider getRepositoryProvider3 = new GetRepositoryProvider(configurationLocalCoreLibApi);
            this.getRepositoryProvider = getRepositoryProvider3;
            this.provideCountryIdProvider = TproPresentationModule_ProvideCountryIdFactory.create(getRepositoryProvider3);
            GetRepositoryProvider2 getRepositoryProvider22 = new GetRepositoryProvider2(subscriptionsFeatureApi3);
            this.getRepositoryProvider2 = getRepositoryProvider22;
            GetSubscriptionMultiPlanUseCase_Factory create2 = GetSubscriptionMultiPlanUseCase_Factory.create(getRepositoryProvider22);
            this.getSubscriptionMultiPlanUseCaseProvider = create2;
            this.multiPlanParamsProvider = MultiPlanParams_Factory.create(create2, TproPresentationModule_ProvideTProMultiPlanDisplayModelMapperFactory.create(), TproPresentationModule_ProvideTProMultiPlanDurationsFactory.create());
            this.getTrackerProvider = new GetTrackerProvider(subscriptionsFeatureApi3);
            this.getSubscriptionWithB2BVoucherUseCaseProvider = GetSubscriptionWithB2BVoucherUseCase_Factory.create(this.getRepositoryProvider2);
            GetSubscriptionStatusRepositoryProvider getSubscriptionStatusRepositoryProvider2 = new GetSubscriptionStatusRepositoryProvider(subscriptionsFeatureApi3);
            this.getSubscriptionStatusRepositoryProvider = getSubscriptionStatusRepositoryProvider2;
            this.getActiveSubscriptionsUseCaseProvider = GetActiveSubscriptionsUseCase_Factory.create(this.getRepositoryProvider2, this.getRepositoryProvider, getSubscriptionStatusRepositoryProvider2);
            this.tProOnBoardingBannerAndPlansUseCaseProvider = TProOnBoardingBannerAndPlansUseCase_Factory.create(this.getRepositoryProvider2);
            this.getGetProCentralizationStatusUseCaseProvider = new GetGetProCentralizationStatusUseCaseProvider(subscriptionsFeatureApi3);
            GetSubscriptionsCustomerRepositoryProvider getSubscriptionsCustomerRepositoryProvider2 = new GetSubscriptionsCustomerRepositoryProvider(subscriptionsFeatureApi3);
            this.getSubscriptionsCustomerRepositoryProvider = getSubscriptionsCustomerRepositoryProvider2;
            ProCentralizationStatusWrapper_Factory create3 = ProCentralizationStatusWrapper_Factory.create(this.getGetProCentralizationStatusUseCaseProvider, getSubscriptionsCustomerRepositoryProvider2);
            this.proCentralizationStatusWrapperProvider = create3;
            this.tproBenefitsViewModelProvider = TproBenefitsViewModel_Factory.create(this.provideResourcesProvider, this.provideCountryIdProvider, this.multiPlanParamsProvider, this.getTrackerProvider, this.getSubscriptionWithB2BVoucherUseCaseProvider, this.getActiveSubscriptionsUseCaseProvider, this.getRepositoryProvider, this.getSubscriptionStatusRepositoryProvider, this.tProOnBoardingBannerAndPlansUseCaseProvider, create3);
            this.getSubscriptionPaymentUseCaseProvider = GetSubscriptionPaymentUseCase_Factory.create(this.getRepositoryProvider2);
            GetSubscriptionPaymentOTPUseCaseProvider getSubscriptionPaymentOTPUseCaseProvider2 = new GetSubscriptionPaymentOTPUseCaseProvider(subscriptionsFeatureApi3);
            this.getSubscriptionPaymentOTPUseCaseProvider = getSubscriptionPaymentOTPUseCaseProvider2;
            this.tProPaymentBottomSheetViewModelProvider = TProPaymentBottomSheetViewModel_Factory.create(this.getSubscriptionPaymentUseCaseProvider, this.getActiveSubscriptionsUseCaseProvider, this.getRepositoryProvider, this.getSubscriptionStatusRepositoryProvider, this.getSubscriptionWithB2BVoucherUseCaseProvider, this.multiPlanParamsProvider, getSubscriptionPaymentOTPUseCaseProvider2, TproPresentationModule_ProvideTalabatRemoteConfigFactory.create());
            this.tProPlanSelectionViewModelProvider = TProPlanSelectionViewModel_Factory.create(this.getTrackerProvider);
            GetSubscriptionsFeatureFlagRepositoryProvider getSubscriptionsFeatureFlagRepositoryProvider2 = new GetSubscriptionsFeatureFlagRepositoryProvider(subscriptionsFeatureApi3);
            this.getSubscriptionsFeatureFlagRepositoryProvider = getSubscriptionsFeatureFlagRepositoryProvider2;
            this.provideIsTproNfvEnabledProvider = TProVendorMovModule_ProvideIsTproNfvEnabledFactory.create(getSubscriptionsFeatureFlagRepositoryProvider2);
            this.getTProVendorMovUseCaseProvider = GetTProVendorMovUseCase_Factory.create(this.getRepositoryProvider2);
            TProVendorMovModule_ProvideIsTproUserFactory create4 = TProVendorMovModule_ProvideIsTproUserFactory.create(this.getSubscriptionStatusRepositoryProvider);
            this.provideIsTproUserProvider = create4;
            this.vendorMovViewModelProvider = VendorMovViewModel_Factory.create(this.getTProVendorMovUseCaseProvider, this.provideIsTproNfvEnabledProvider, create4, TProVendorMovModule_ProvideTproPlanMOVFactory.create());
            this.getSubscriptionCancellationReasonsUseCaseProvider = GetSubscriptionCancellationReasonsUseCase_Factory.create(this.getRepositoryProvider2);
            SendCancellationFeedbackUseCase_Factory create5 = SendCancellationFeedbackUseCase_Factory.create(this.getRepositoryProvider2);
            this.sendCancellationFeedbackUseCaseProvider = create5;
            this.subscriptionCancellationReasonsViewModelProvider = SubscriptionCancellationReasonsViewModel_Factory.create(this.getSubscriptionCancellationReasonsUseCaseProvider, create5);
            this.getSubscriptionDetailsUseCaseProvider = GetSubscriptionDetailsUseCase_Factory.create(this.getRepositoryProvider2);
            this.getSavingsInfoUseCaseProvider = GetSavingsInfoUseCase_Factory.create(this.getRepositoryProvider2);
            GetSubscriptionsUseCase_Factory create6 = GetSubscriptionsUseCase_Factory.create(this.getRepositoryProvider2, this.getRepositoryProvider);
            this.getSubscriptionsUseCaseProvider = create6;
            this.updateAutoRenewalUseCaseProvider = UpdateAutoRenewalUseCase_Factory.create(this.getRepositoryProvider2, this.getSubscriptionStatusRepositoryProvider, create6, this.getRepositoryProvider);
            CancelFreeTrialUseCase_Factory create7 = CancelFreeTrialUseCase_Factory.create(this.getRepositoryProvider2);
            this.cancelFreeTrialUseCaseProvider = create7;
            this.tproSubscriptionDetailsViewModelProvider = TproSubscriptionDetailsViewModel_Factory.create(this.getSubscriptionDetailsUseCaseProvider, this.getSavingsInfoUseCaseProvider, this.updateAutoRenewalUseCaseProvider, create7, this.getSubscriptionsCustomerRepositoryProvider, this.getSubscriptionStatusRepositoryProvider, this.getRepositoryProvider, this.proCentralizationStatusWrapperProvider);
            this.subscriptionAtCheckoutBannerViewModelProvider = SubscriptionAtCheckoutBannerViewModel_Factory.create(this.multiPlanParamsProvider, this.getRepositoryProvider, this.getSubscriptionStatusRepositoryProvider, this.getTrackerProvider);
            UpgradeSubscriptionPlanUseCase_Factory create8 = UpgradeSubscriptionPlanUseCase_Factory.create(this.getRepositoryProvider2);
            this.upgradeSubscriptionPlanUseCaseProvider = create8;
            this.tproUpgradeDetailsViewModelProvider = TproUpgradeDetailsViewModel_Factory.create(create8, this.getActiveSubscriptionsUseCaseProvider, this.getRepositoryProvider, this.getSubscriptionStatusRepositoryProvider);
        }

        private SubscriptionAtCheckoutBannerView injectSubscriptionAtCheckoutBannerView(SubscriptionAtCheckoutBannerView subscriptionAtCheckoutBannerView) {
            SubscriptionAtCheckoutBannerView_MembersInjector.injectViewModelFactory(subscriptionAtCheckoutBannerView, subscriptionAtCheckoutBannerViewModelFactory());
            return subscriptionAtCheckoutBannerView;
        }

        private SubscriptionCancellationReasonBottomSheetFragment injectSubscriptionCancellationReasonBottomSheetFragment(SubscriptionCancellationReasonBottomSheetFragment subscriptionCancellationReasonBottomSheetFragment) {
            SubscriptionCancellationReasonBottomSheetFragment_MembersInjector.injectViewModelFactory(subscriptionCancellationReasonBottomSheetFragment, subscriptionCancellationReasonsViewModelFactory());
            return subscriptionCancellationReasonBottomSheetFragment;
        }

        private TProPaymentBottomSheetFragment injectTProPaymentBottomSheetFragment(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment) {
            TProPaymentBottomSheetFragment_MembersInjector.injectViewModelFactory(tProPaymentBottomSheetFragment, tProPaymentBottomSheetViewModelFactory());
            TProPaymentBottomSheetFragment_MembersInjector.injectSubscriptionsTracker(tProPaymentBottomSheetFragment, (ISubscriptionsTracker) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getTracker()));
            TProPaymentBottomSheetFragment_MembersInjector.injectSubscriptionsFeatureFlagsRepository(tProPaymentBottomSheetFragment, (ISubscriptionsFeatureFlagsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsFeatureFlagRepository()));
            TProPaymentBottomSheetFragment_MembersInjector.injectIsCoffeeEnabled(tProPaymentBottomSheetFragment, TproPresentationModule.INSTANCE.provideTProIsCoffeeEnabled());
            return tProPaymentBottomSheetFragment;
        }

        private TProPlanSelectionFragment injectTProPlanSelectionFragment(TProPlanSelectionFragment tProPlanSelectionFragment) {
            TProPlanSelectionFragment_MembersInjector.injectViewModelFactory(tProPlanSelectionFragment, tProPlanSelectionViewModelFactory());
            return tProPlanSelectionFragment;
        }

        private TProSavingsCancellationBottomSheetFragment injectTProSavingsCancellationBottomSheetFragment(TProSavingsCancellationBottomSheetFragment tProSavingsCancellationBottomSheetFragment) {
            TProSavingsCancellationBottomSheetFragment_MembersInjector.injectLocationConfigurationRepository(tProSavingsCancellationBottomSheetFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            return tProSavingsCancellationBottomSheetFragment;
        }

        private TProSubscriptionDetailsFragment injectTProSubscriptionDetailsFragment(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment) {
            TProSubscriptionDetailsFragment_MembersInjector.injectLocationRepository(tProSubscriptionDetailsFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            TProSubscriptionDetailsFragment_MembersInjector.injectSubscriptionsFeatureFlag(tProSubscriptionDetailsFragment, (ISubscriptionsFeatureFlagsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsFeatureFlagRepository()));
            TProSubscriptionDetailsFragment_MembersInjector.injectSubscriptionStatusRepository(tProSubscriptionDetailsFragment, (ISubscriptionStatusRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionStatusRepository()));
            TProSubscriptionDetailsFragment_MembersInjector.injectSubscriptionsTracker(tProSubscriptionDetailsFragment, (ISubscriptionsTracker) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getTracker()));
            TProSubscriptionDetailsFragment_MembersInjector.injectNavigator(tProSubscriptionDetailsFragment, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            TProSubscriptionDetailsFragment_MembersInjector.injectViewModelFactory(tProSubscriptionDetailsFragment, tproSubscriptionDetailsViewModelFactory());
            TProSubscriptionDetailsFragment_MembersInjector.injectDeepLinkNavigator(tProSubscriptionDetailsFragment, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            return tProSubscriptionDetailsFragment;
        }

        private TProVendorMovView injectTProVendorMovView(TProVendorMovView tProVendorMovView) {
            TProVendorMovView_MembersInjector.injectLocationConfigurationRepository(tProVendorMovView, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            TProVendorMovView_MembersInjector.injectIsNfvFlagEnabled(tProVendorMovView, this.provideIsTproNfvEnabledProvider);
            TProVendorMovView_MembersInjector.injectViewModelFactory(tProVendorMovView, vendorMovViewModelFactory());
            return tProVendorMovView;
        }

        private TProWelcomeBottomSheetFragment injectTProWelcomeBottomSheetFragment(TProWelcomeBottomSheetFragment tProWelcomeBottomSheetFragment) {
            TProWelcomeBottomSheetFragment_MembersInjector.injectNavigator(tProWelcomeBottomSheetFragment, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            return tProWelcomeBottomSheetFragment;
        }

        private TproBenefitsFragment injectTproBenefitsFragment(TproBenefitsFragment tproBenefitsFragment) {
            TproBenefitsFragment_MembersInjector.injectViewModelFactory(tproBenefitsFragment, tproBenefitsViewModelFactory());
            TproBenefitsFragment_MembersInjector.injectSubscriptionsFlags(tproBenefitsFragment, (ISubscriptionsFeatureFlagsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsFeatureFlagRepository()));
            TproBenefitsFragment_MembersInjector.injectSubcriptionStatusRepository(tproBenefitsFragment, (ISubscriptionStatusRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionStatusRepository()));
            TproBenefitsFragment_MembersInjector.injectDeepLinkNavigator(tproBenefitsFragment, (DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
            TproBenefitsFragment_MembersInjector.injectObservabilityManager(tproBenefitsFragment, (IObservabilityManager) Preconditions.checkNotNullFromComponent(this.observabilityCoreLibApi.getObservabilityManager()));
            TproBenefitsFragment_MembersInjector.injectNavigator(tproBenefitsFragment, (Navigator) Preconditions.checkNotNullFromComponent(this.navigationCoreLibApi.getNavigator()));
            return tproBenefitsFragment;
        }

        private TproUpgradeDetailsBottomSheetFragment injectTproUpgradeDetailsBottomSheetFragment(TproUpgradeDetailsBottomSheetFragment tproUpgradeDetailsBottomSheetFragment) {
            TproUpgradeDetailsBottomSheetFragment_MembersInjector.injectViewModelFactory(tproUpgradeDetailsBottomSheetFragment, tproUpgradeDetailsViewModelFactory());
            TproUpgradeDetailsBottomSheetFragment_MembersInjector.injectSubscriptionsTracker(tproUpgradeDetailsBottomSheetFragment, (ISubscriptionsTracker) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getTracker()));
            return tproUpgradeDetailsBottomSheetFragment;
        }

        private SubscriptionAtCheckoutBannerViewModelFactory subscriptionAtCheckoutBannerViewModelFactory() {
            return new SubscriptionAtCheckoutBannerViewModelFactory(this.subscriptionAtCheckoutBannerViewModelProvider);
        }

        private SubscriptionCancellationReasonsViewModelFactory subscriptionCancellationReasonsViewModelFactory() {
            return new SubscriptionCancellationReasonsViewModelFactory(this.subscriptionCancellationReasonsViewModelProvider);
        }

        private TProPaymentBottomSheetViewModelFactory tProPaymentBottomSheetViewModelFactory() {
            return new TProPaymentBottomSheetViewModelFactory(this.tProPaymentBottomSheetViewModelProvider);
        }

        private TProPlanSelectionViewModelFactory tProPlanSelectionViewModelFactory() {
            return new TProPlanSelectionViewModelFactory(this.tProPlanSelectionViewModelProvider);
        }

        private TproBenefitsViewModelFactory tproBenefitsViewModelFactory() {
            return new TproBenefitsViewModelFactory(this.tproBenefitsViewModelProvider);
        }

        private TproSubscriptionDetailsViewModelFactory tproSubscriptionDetailsViewModelFactory() {
            return new TproSubscriptionDetailsViewModelFactory(this.tproSubscriptionDetailsViewModelProvider);
        }

        private TproUpgradeDetailsViewModelFactory tproUpgradeDetailsViewModelFactory() {
            return new TproUpgradeDetailsViewModelFactory(this.tproUpgradeDetailsViewModelProvider);
        }

        private VendorMovViewModelFactory vendorMovViewModelFactory() {
            return new VendorMovViewModelFactory(this.vendorMovViewModelProvider);
        }

        public void inject(TproBenefitsActivity tproBenefitsActivity) {
        }

        public void inject(TproBenefitsFragment tproBenefitsFragment) {
            injectTproBenefitsFragment(tproBenefitsFragment);
        }

        public void inject(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment) {
            injectTProPaymentBottomSheetFragment(tProPaymentBottomSheetFragment);
        }

        public void inject(TProWelcomeBottomSheetFragment tProWelcomeBottomSheetFragment) {
            injectTProWelcomeBottomSheetFragment(tProWelcomeBottomSheetFragment);
        }

        public void inject(TProPlanSelectionFragment tProPlanSelectionFragment) {
            injectTProPlanSelectionFragment(tProPlanSelectionFragment);
        }

        public void inject(TProVendorMovView tProVendorMovView) {
            injectTProVendorMovView(tProVendorMovView);
        }

        public void inject(TProSavingsCancellationBottomSheetFragment tProSavingsCancellationBottomSheetFragment) {
            injectTProSavingsCancellationBottomSheetFragment(tProSavingsCancellationBottomSheetFragment);
        }

        public void inject(SubscriptionCancellationReasonBottomSheetFragment subscriptionCancellationReasonBottomSheetFragment) {
            injectSubscriptionCancellationReasonBottomSheetFragment(subscriptionCancellationReasonBottomSheetFragment);
        }

        public void inject(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment) {
            injectTProSubscriptionDetailsFragment(tProSubscriptionDetailsFragment);
        }

        public void inject(SubscriptionAtCheckoutBannerView subscriptionAtCheckoutBannerView) {
            injectSubscriptionAtCheckoutBannerView(subscriptionAtCheckoutBannerView);
        }

        public void inject(TproUpgradeDetailsBottomSheetFragment tproUpgradeDetailsBottomSheetFragment) {
            injectTproUpgradeDetailsBottomSheetFragment(tproUpgradeDetailsBottomSheetFragment);
        }
    }

    private DaggerTproPresentationComponent() {
    }

    public static TproPresentationComponent.Factory factory() {
        return new Factory();
    }
}
