package com.talabat.feature.subscriptions.fake.di;

import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import com.talabat.feature.subscriptions.domain.usecase.SubscriptionPaymentOTPUseCase;
import com.talabat.feature.subscriptions.fake.FakeGetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.fake.FakeGetProCentralizationStatusUseCase_Factory;
import com.talabat.feature.subscriptions.fake.FakeGetTProOrderStatusUseCase_Factory;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionPaymentOTPUseCase;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionPaymentOTPUseCase_Factory;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionsCustomerRepository_Factory;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionsFeatureFlagsRepository_Factory;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionsRepository;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionsRepository_Factory;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionsStatusRepository_Factory;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionsTracker_Factory;
import com.talabat.feature.subscriptions.fake.di.FakeSubscriptionsFeatureComponent;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerFakeSubscriptionsFeatureComponent {

    public static final class Factory implements FakeSubscriptionsFeatureComponent.Factory {
        private Factory() {
        }

        public FakeSubscriptionsFeatureComponent create(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, SubscriptionSavingsInfo subscriptionSavingsInfo) {
            Preconditions.checkNotNull(Boolean.valueOf(z11));
            Preconditions.checkNotNull(Boolean.valueOf(z12));
            Preconditions.checkNotNull(Boolean.valueOf(z13));
            Preconditions.checkNotNull(Boolean.valueOf(z14));
            Preconditions.checkNotNull(Boolean.valueOf(z15));
            Preconditions.checkNotNull(Boolean.valueOf(z16));
            Preconditions.checkNotNull(Boolean.valueOf(z17));
            Preconditions.checkNotNull(subscriptionSavingsInfo);
            return new FakeSubscriptionsFeatureComponentImpl(Boolean.valueOf(z11), Boolean.valueOf(z12), Boolean.valueOf(z13), Boolean.valueOf(z14), Boolean.valueOf(z15), Boolean.valueOf(z16), Boolean.valueOf(z17), subscriptionSavingsInfo);
        }
    }

    public static final class FakeSubscriptionsFeatureComponentImpl implements FakeSubscriptionsFeatureComponent {
        private Provider<FakeGetProCentralizationStatusUseCase> fakeGetProCentralizationStatusUseCaseProvider;
        private Provider<FakeSubscriptionPaymentOTPUseCase> fakeSubscriptionPaymentOTPUseCaseProvider;
        private final FakeSubscriptionsFeatureComponentImpl fakeSubscriptionsFeatureComponentImpl;
        private Provider<FakeSubscriptionsFeatureFlagsRepository> fakeSubscriptionsFeatureFlagsRepositoryProvider;
        private Provider<FakeSubscriptionsRepository> fakeSubscriptionsRepositoryProvider;
        private Provider<Boolean> flagDefaultProvider;
        private Provider<Boolean> flagIsNewBrandEnabledProvider;
        private Provider<Boolean> flagIsSavingsBannerEnabledProvider;
        private Provider<Boolean> flagIsSavingsFlowEnabledProvider;
        private Provider<Boolean> flagIsTProEnabledProvider;
        private Provider<Boolean> flagIsTProFeatureEnabledProvider;
        private Provider<GetProCentralizationStatusUseCase> getProCentralizationStatusUseCaseProvider;
        private Provider<SubscriptionPaymentOTPUseCase> getSubscriptionPaymentOTPPointUseCaseProvider;
        private Provider<ISubscriptionsCustomerRepository> getSubscriptionsCustomerRepositoryProvider;
        private Provider<GetTProOrderStatusUseCase> getTProOrderStatusUseCaseProvider;
        private Provider<SubscriptionSavingsInfo> repositorySavingsInfoProvider;
        private Provider<Boolean> repositoryThrowErrorProvider;
        private Provider<ISubscriptionsFeatureFlagsRepository> subscriptionsFeatureFlagsRepositoryProvider;
        private Provider<ISubscriptionsRepository> subscriptionsRepositoryProvider;
        private Provider<ISubscriptionStatusRepository> subscriptionsStatusRepositoryProvider;
        private Provider<ISubscriptionsTracker> subscriptionsTrackerProvider;

        private FakeSubscriptionsFeatureComponentImpl(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, SubscriptionSavingsInfo subscriptionSavingsInfo) {
            this.fakeSubscriptionsFeatureComponentImpl = this;
            initialize(bool, bool2, bool3, bool4, bool5, bool6, bool7, subscriptionSavingsInfo);
        }

        private void initialize(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, SubscriptionSavingsInfo subscriptionSavingsInfo) {
            this.repositoryThrowErrorProvider = InstanceFactory.create(bool7);
            dagger.internal.Factory create = InstanceFactory.create(subscriptionSavingsInfo);
            this.repositorySavingsInfoProvider = create;
            FakeSubscriptionsRepository_Factory create2 = FakeSubscriptionsRepository_Factory.create(this.repositoryThrowErrorProvider, create);
            this.fakeSubscriptionsRepositoryProvider = create2;
            this.subscriptionsRepositoryProvider = SingleCheck.provider(create2);
            this.subscriptionsTrackerProvider = SingleCheck.provider(FakeSubscriptionsTracker_Factory.create());
            this.getTProOrderStatusUseCaseProvider = SingleCheck.provider(FakeGetTProOrderStatusUseCase_Factory.create());
            this.getSubscriptionsCustomerRepositoryProvider = SingleCheck.provider(FakeSubscriptionsCustomerRepository_Factory.create());
            this.flagIsTProEnabledProvider = InstanceFactory.create(bool);
            this.flagIsSavingsFlowEnabledProvider = InstanceFactory.create(bool2);
            this.flagIsSavingsBannerEnabledProvider = InstanceFactory.create(bool3);
            this.flagIsNewBrandEnabledProvider = InstanceFactory.create(bool4);
            this.flagIsTProFeatureEnabledProvider = InstanceFactory.create(bool5);
            dagger.internal.Factory create3 = InstanceFactory.create(bool6);
            this.flagDefaultProvider = create3;
            FakeSubscriptionsFeatureFlagsRepository_Factory create4 = FakeSubscriptionsFeatureFlagsRepository_Factory.create(this.flagIsTProEnabledProvider, this.flagIsSavingsFlowEnabledProvider, this.flagIsSavingsBannerEnabledProvider, this.flagIsNewBrandEnabledProvider, this.flagIsTProFeatureEnabledProvider, create3);
            this.fakeSubscriptionsFeatureFlagsRepositoryProvider = create4;
            this.subscriptionsFeatureFlagsRepositoryProvider = SingleCheck.provider(create4);
            this.subscriptionsStatusRepositoryProvider = SingleCheck.provider(FakeSubscriptionsStatusRepository_Factory.create());
            FakeSubscriptionPaymentOTPUseCase_Factory create5 = FakeSubscriptionPaymentOTPUseCase_Factory.create(this.subscriptionsRepositoryProvider);
            this.fakeSubscriptionPaymentOTPUseCaseProvider = create5;
            this.getSubscriptionPaymentOTPPointUseCaseProvider = SingleCheck.provider(create5);
            FakeGetProCentralizationStatusUseCase_Factory create6 = FakeGetProCentralizationStatusUseCase_Factory.create(this.subscriptionsRepositoryProvider, this.subscriptionsStatusRepositoryProvider);
            this.fakeGetProCentralizationStatusUseCaseProvider = create6;
            this.getProCentralizationStatusUseCaseProvider = SingleCheck.provider(create6);
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
            return this.getSubscriptionPaymentOTPPointUseCaseProvider.get();
        }

        public ISubscriptionStatusRepository getSubscriptionStatusRepository() {
            return this.subscriptionsStatusRepositoryProvider.get();
        }

        public ISubscriptionsCustomerRepository getSubscriptionsCustomerRepository() {
            return this.getSubscriptionsCustomerRepositoryProvider.get();
        }

        public ISubscriptionsFeatureFlagsRepository getSubscriptionsFeatureFlagRepository() {
            return this.subscriptionsFeatureFlagsRepositoryProvider.get();
        }

        public ISubscriptionsTracker getTracker() {
            return this.subscriptionsTrackerProvider.get();
        }
    }

    private DaggerFakeSubscriptionsFeatureComponent() {
    }

    public static FakeSubscriptionsFeatureComponent.Factory factory() {
        return new Factory();
    }
}
