package com.talabat.wallet.ui.subscriptionManagement.view.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementFragment;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementFragment_MembersInjector;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionPlanFragment;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionPlanFragment_MembersInjector;
import com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment;
import com.talabat.wallet.ui.subscriptionManagement.view.bottomsheet.SubscriptionCancellationFragment_MembersInjector;
import com.talabat.wallet.ui.subscriptionManagement.view.di.SubscriptionComponent;
import com.talabat.wallet.ui.subscriptionManagement.view.fragment.SubscriptionDetailFragment;
import com.talabat.wallet.ui.subscriptionManagement.view.fragment.SubscriptionDetailFragment_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerSubscriptionComponent {

    public static final class Factory implements SubscriptionComponent.Factory {
        private Factory() {
        }

        public SubscriptionComponent create(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, SubscriptionsFeatureApi subscriptionsFeatureApi) {
            Preconditions.checkNotNull(configurationLocalCoreLibApi);
            Preconditions.checkNotNull(configurationRemoteCoreLibApi);
            Preconditions.checkNotNull(featureFlagCoreLibApi);
            Preconditions.checkNotNull(subscriptionsFeatureApi);
            return new SubscriptionComponentImpl(configurationLocalCoreLibApi, configurationRemoteCoreLibApi, featureFlagCoreLibApi, subscriptionsFeatureApi);
        }
    }

    public static final class SubscriptionComponentImpl implements SubscriptionComponent {
        private final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
        private final ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi;
        private final FeatureFlagCoreLibApi featureFlagCoreLibApi;
        private final SubscriptionComponentImpl subscriptionComponentImpl;
        private final SubscriptionsFeatureApi subscriptionsFeatureApi;

        private SubscriptionComponentImpl(ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi2, FeatureFlagCoreLibApi featureFlagCoreLibApi2, SubscriptionsFeatureApi subscriptionsFeatureApi2) {
            this.subscriptionComponentImpl = this;
            this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
            this.configurationRemoteCoreLibApi = configurationRemoteCoreLibApi2;
            this.featureFlagCoreLibApi = featureFlagCoreLibApi2;
            this.subscriptionsFeatureApi = subscriptionsFeatureApi2;
        }

        private GetSavingsInfoUseCase getSavingsInfoUseCase() {
            return new GetSavingsInfoUseCase((ISubscriptionsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getRepository()));
        }

        private SubscriptionCancellationFragment injectSubscriptionCancellationFragment(SubscriptionCancellationFragment subscriptionCancellationFragment) {
            SubscriptionCancellationFragment_MembersInjector.injectFeatureFlagRepo(subscriptionCancellationFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            SubscriptionCancellationFragment_MembersInjector.injectGetSavingsInfoUseCase(subscriptionCancellationFragment, getSavingsInfoUseCase());
            SubscriptionCancellationFragment_MembersInjector.injectSubscriptionsFeatureFlag(subscriptionCancellationFragment, (ISubscriptionsFeatureFlagsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsFeatureFlagRepository()));
            return subscriptionCancellationFragment;
        }

        private SubscriptionDetailFragment injectSubscriptionDetailFragment(SubscriptionDetailFragment subscriptionDetailFragment) {
            SubscriptionDetailFragment_MembersInjector.injectConfigurationLocalRepository(subscriptionDetailFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            SubscriptionDetailFragment_MembersInjector.injectLocationConfigurationRepository(subscriptionDetailFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            SubscriptionDetailFragment_MembersInjector.injectFeatureFlagRepo(subscriptionDetailFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            SubscriptionDetailFragment_MembersInjector.injectSubscriptionsFeatureFlag(subscriptionDetailFragment, (ISubscriptionsFeatureFlagsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsFeatureFlagRepository()));
            SubscriptionDetailFragment_MembersInjector.injectGetSavingsInfoUseCase(subscriptionDetailFragment, getSavingsInfoUseCase());
            return subscriptionDetailFragment;
        }

        private SubscriptionManagementFragment injectSubscriptionManagementFragment(SubscriptionManagementFragment subscriptionManagementFragment) {
            SubscriptionManagementFragment_MembersInjector.injectConfigurationLocalRepository(subscriptionManagementFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            SubscriptionManagementFragment_MembersInjector.injectLocationConfigurationRepository(subscriptionManagementFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            SubscriptionManagementFragment_MembersInjector.injectFeatureFlagRepo(subscriptionManagementFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            SubscriptionManagementFragment_MembersInjector.injectGetSavingsInfoUseCase(subscriptionManagementFragment, getSavingsInfoUseCase());
            SubscriptionManagementFragment_MembersInjector.injectSubscriptionsFeatureFlag(subscriptionManagementFragment, (ISubscriptionsFeatureFlagsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsFeatureFlagRepository()));
            return subscriptionManagementFragment;
        }

        private SubscriptionPlanFragment injectSubscriptionPlanFragment(SubscriptionPlanFragment subscriptionPlanFragment) {
            SubscriptionPlanFragment_MembersInjector.injectConfigurationLocalRepository(subscriptionPlanFragment, (ConfigurationLocalRepository) Preconditions.checkNotNullFromComponent(this.configurationLocalCoreLibApi.getRepository()));
            SubscriptionPlanFragment_MembersInjector.injectLocationConfigurationRepository(subscriptionPlanFragment, (LocationConfigurationRepository) Preconditions.checkNotNullFromComponent(this.configurationRemoteCoreLibApi.getLocationConfigurationRepository()));
            SubscriptionPlanFragment_MembersInjector.injectFeatureFlagRepo(subscriptionPlanFragment, (ITalabatFeatureFlag) Preconditions.checkNotNullFromComponent(this.featureFlagCoreLibApi.getTalabatFeatureFlag()));
            SubscriptionPlanFragment_MembersInjector.injectGetSavingsInfoUseCase(subscriptionPlanFragment, getSavingsInfoUseCase());
            SubscriptionPlanFragment_MembersInjector.injectSubscriptionsFeatureFlag(subscriptionPlanFragment, (ISubscriptionsFeatureFlagsRepository) Preconditions.checkNotNullFromComponent(this.subscriptionsFeatureApi.getSubscriptionsFeatureFlagRepository()));
            return subscriptionPlanFragment;
        }

        public void inject(SubscriptionPlanFragment subscriptionPlanFragment) {
            injectSubscriptionPlanFragment(subscriptionPlanFragment);
        }

        public void inject(SubscriptionManagementFragment subscriptionManagementFragment) {
            injectSubscriptionManagementFragment(subscriptionManagementFragment);
        }

        public void inject(SubscriptionCancellationFragment subscriptionCancellationFragment) {
            injectSubscriptionCancellationFragment(subscriptionCancellationFragment);
        }

        public void inject(SubscriptionDetailFragment subscriptionDetailFragment) {
            injectSubscriptionDetailFragment(subscriptionDetailFragment);
        }
    }

    private DaggerSubscriptionComponent() {
    }

    public static SubscriptionComponent.Factory factory() {
        return new Factory();
    }
}
