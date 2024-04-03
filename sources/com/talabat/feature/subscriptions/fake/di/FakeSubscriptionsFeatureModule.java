package com.talabat.feature.subscriptions.fake.di;

import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import com.talabat.feature.subscriptions.domain.usecase.SubscriptionPaymentOTPUseCase;
import com.talabat.feature.subscriptions.fake.FakeGetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.fake.FakeGetTProOrderStatusUseCase;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionPaymentOTPUseCase;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionsRepository;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionsStatusRepository;
import com.talabat.feature.subscriptions.fake.FakeSubscriptionsTracker;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0011H'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0014H'J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0017H'J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u001aH'¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/subscriptions/fake/di/FakeSubscriptionsFeatureModule;", "", "getProCentralizationStatusUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetProCentralizationStatusUseCase;", "impl", "Lcom/talabat/feature/subscriptions/fake/FakeGetProCentralizationStatusUseCase;", "getSubscriptionPaymentOTPPointUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/SubscriptionPaymentOTPUseCase;", "Lcom/talabat/feature/subscriptions/fake/FakeSubscriptionPaymentOTPUseCase;", "getSubscriptionsCustomerRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;", "Lcom/talabat/feature/subscriptions/fake/FakeSubscriptionsCustomerRepository;", "getTProOrderStatusUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetTProOrderStatusUseCase;", "Lcom/talabat/feature/subscriptions/fake/FakeGetTProOrderStatusUseCase;", "subscriptionsFeatureFlagsRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "Lcom/talabat/feature/subscriptions/fake/FakeSubscriptionsFeatureFlagsRepository;", "subscriptionsRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "Lcom/talabat/feature/subscriptions/fake/FakeSubscriptionsRepository;", "subscriptionsStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "Lcom/talabat/feature/subscriptions/fake/FakeSubscriptionsStatusRepository;", "subscriptionsTracker", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "Lcom/talabat/feature/subscriptions/fake/FakeSubscriptionsTracker;", "com_talabat_feature_subscriptions_fake_fake"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface FakeSubscriptionsFeatureModule {
    @NotNull
    @Binds
    @Reusable
    GetProCentralizationStatusUseCase getProCentralizationStatusUseCase(@NotNull FakeGetProCentralizationStatusUseCase fakeGetProCentralizationStatusUseCase);

    @NotNull
    @Binds
    @Reusable
    SubscriptionPaymentOTPUseCase getSubscriptionPaymentOTPPointUseCase(@NotNull FakeSubscriptionPaymentOTPUseCase fakeSubscriptionPaymentOTPUseCase);

    @NotNull
    @Binds
    @Reusable
    ISubscriptionsCustomerRepository getSubscriptionsCustomerRepository(@NotNull FakeSubscriptionsCustomerRepository fakeSubscriptionsCustomerRepository);

    @NotNull
    @Binds
    @Reusable
    GetTProOrderStatusUseCase getTProOrderStatusUseCase(@NotNull FakeGetTProOrderStatusUseCase fakeGetTProOrderStatusUseCase);

    @NotNull
    @Binds
    @Reusable
    ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlagsRepository(@NotNull FakeSubscriptionsFeatureFlagsRepository fakeSubscriptionsFeatureFlagsRepository);

    @NotNull
    @Binds
    @Reusable
    ISubscriptionsRepository subscriptionsRepository(@NotNull FakeSubscriptionsRepository fakeSubscriptionsRepository);

    @NotNull
    @Binds
    @Reusable
    ISubscriptionStatusRepository subscriptionsStatusRepository(@NotNull FakeSubscriptionsStatusRepository fakeSubscriptionsStatusRepository);

    @NotNull
    @Binds
    @Reusable
    ISubscriptionsTracker subscriptionsTracker(@NotNull FakeSubscriptionsTracker fakeSubscriptionsTracker);
}
