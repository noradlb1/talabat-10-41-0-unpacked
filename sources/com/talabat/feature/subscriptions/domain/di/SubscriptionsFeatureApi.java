package com.talabat.feature.subscriptions.domain.di;

import com.talabat.core.di.Api;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsCustomerRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.usecase.GetProCentralizationStatusUseCase;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import com.talabat.feature.subscriptions.domain.usecase.SubscriptionPaymentOTPUseCase;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/talabat/feature/subscriptions/domain/di/SubscriptionsFeatureApi;", "Lcom/talabat/core/di/Api;", "getProCentralizationStatusUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetProCentralizationStatusUseCase;", "getGetProCentralizationStatusUseCase", "()Lcom/talabat/feature/subscriptions/domain/usecase/GetProCentralizationStatusUseCase;", "getTProOrderStatusUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetTProOrderStatusUseCase;", "getGetTProOrderStatusUseCase", "()Lcom/talabat/feature/subscriptions/domain/usecase/GetTProOrderStatusUseCase;", "repository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "getRepository", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "subscriptionPaymentOTPUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/SubscriptionPaymentOTPUseCase;", "getSubscriptionPaymentOTPUseCase", "()Lcom/talabat/feature/subscriptions/domain/usecase/SubscriptionPaymentOTPUseCase;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "getSubscriptionStatusRepository", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "subscriptionsCustomerRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;", "getSubscriptionsCustomerRepository", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;", "subscriptionsFeatureFlagRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "getSubscriptionsFeatureFlagRepository", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "tracker", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "getTracker", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SubscriptionsFeatureApi extends Api {
    @NotNull
    GetProCentralizationStatusUseCase getGetProCentralizationStatusUseCase();

    @NotNull
    GetTProOrderStatusUseCase getGetTProOrderStatusUseCase();

    @NotNull
    ISubscriptionsRepository getRepository();

    @NotNull
    SubscriptionPaymentOTPUseCase getSubscriptionPaymentOTPUseCase();

    @NotNull
    ISubscriptionStatusRepository getSubscriptionStatusRepository();

    @NotNull
    ISubscriptionsCustomerRepository getSubscriptionsCustomerRepository();

    @NotNull
    ISubscriptionsFeatureFlagsRepository getSubscriptionsFeatureFlagRepository();

    @NotNull
    ISubscriptionsTracker getTracker();
}
