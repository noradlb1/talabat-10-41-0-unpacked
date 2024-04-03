package com.talabat.feature.subscriptions.data.di;

import com.talabat.feature.subscriptions.data.LegacySubscriptionStatusRepository;
import com.talabat.feature.subscriptions.data.SubscriptionsCustomerRepositoryImpl;
import com.talabat.feature.subscriptions.data.SubscriptionsFeatureFlagsRepositoryImpl;
import com.talabat.feature.subscriptions.data.SubscriptionsRepositoryImpl;
import com.talabat.feature.subscriptions.data.model.ProCentralizationModelMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionModelMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionPlanModelMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionUpgradePlanModelMapper;
import com.talabat.feature.subscriptions.data.remote.model.ProCentralizationResponseResult;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPlanResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionUpgradePlanResponseModel;
import com.talabat.feature.subscriptions.data.tracking.SubscriptionsTracker;
import com.talabat.feature.subscriptions.data.usecase.GetProCentralizationStatusUseCaseImpl;
import com.talabat.feature.subscriptions.data.usecase.GetTProOrderStatusUseCaseImpl;
import com.talabat.feature.subscriptions.data.usecase.SubscriptionPaymentOTPUseCaseImpl;
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
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0004\u001a\u00020\u0013H'J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0016H'J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0019H'J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00102\u0006\u0010\u0004\u001a\u00020\u001dH'J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u00102\u0006\u0010\u0004\u001a\u00020!H'J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020$H'J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020'H'J\u001c\u0010(\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0\u00102\u0006\u0010\u0004\u001a\u00020+H'¨\u0006,"}, d2 = {"Lcom/talabat/feature/subscriptions/data/di/SubscriptionsFeatureModule;", "", "getProCentralizationStatusUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetProCentralizationStatusUseCase;", "impl", "Lcom/talabat/feature/subscriptions/data/usecase/GetProCentralizationStatusUseCaseImpl;", "getSubscriptionPaymentOTPUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/SubscriptionPaymentOTPUseCase;", "Lcom/talabat/feature/subscriptions/data/usecase/SubscriptionPaymentOTPUseCaseImpl;", "getSubscriptionsCustomerRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsCustomerRepository;", "Lcom/talabat/feature/subscriptions/data/SubscriptionsCustomerRepositoryImpl;", "getTProOrderStatusUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetTProOrderStatusUseCase;", "Lcom/talabat/feature/subscriptions/data/usecase/GetTProOrderStatusUseCaseImpl;", "proCentralizationModelMapperMapper", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/ProCentralizationResponseResult;", "Lcom/talabat/feature/subscriptions/domain/model/ProCentralization;", "Lcom/talabat/feature/subscriptions/data/model/ProCentralizationModelMapper;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "Lcom/talabat/feature/subscriptions/data/LegacySubscriptionStatusRepository;", "subscriptionsFeatureFlagsRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "Lcom/talabat/feature/subscriptions/data/SubscriptionsFeatureFlagsRepositoryImpl;", "subscriptionsMapper", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "Lcom/talabat/feature/subscriptions/data/model/SubscriptionModelMapper;", "subscriptionsPlanMapper", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPlanResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPlan;", "Lcom/talabat/feature/subscriptions/data/model/SubscriptionPlanModelMapper;", "subscriptionsRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsRepository;", "Lcom/talabat/feature/subscriptions/data/SubscriptionsRepositoryImpl;", "subscriptionsTracker", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "Lcom/talabat/feature/subscriptions/data/tracking/SubscriptionsTracker;", "subscriptionsUpgradePlanMapper", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionUpgradePlanResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionUpgradePlan;", "Lcom/talabat/feature/subscriptions/data/model/SubscriptionUpgradePlanModelMapper;", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {SubscriptionsNetworkModule.class, SubscriptionsUserDataModule.class, SecretsModule.class})
public interface SubscriptionsFeatureModule {
    @NotNull
    @Binds
    @Reusable
    GetProCentralizationStatusUseCase getProCentralizationStatusUseCase(@NotNull GetProCentralizationStatusUseCaseImpl getProCentralizationStatusUseCaseImpl);

    @NotNull
    @Binds
    @Reusable
    SubscriptionPaymentOTPUseCase getSubscriptionPaymentOTPUseCase(@NotNull SubscriptionPaymentOTPUseCaseImpl subscriptionPaymentOTPUseCaseImpl);

    @NotNull
    @Binds
    @Reusable
    ISubscriptionsCustomerRepository getSubscriptionsCustomerRepository(@NotNull SubscriptionsCustomerRepositoryImpl subscriptionsCustomerRepositoryImpl);

    @NotNull
    @Binds
    @Reusable
    GetTProOrderStatusUseCase getTProOrderStatusUseCase(@NotNull GetTProOrderStatusUseCaseImpl getTProOrderStatusUseCaseImpl);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<ProCentralizationResponseResult, ProCentralization> proCentralizationModelMapperMapper(@NotNull ProCentralizationModelMapper proCentralizationModelMapper);

    @NotNull
    @Binds
    @Reusable
    ISubscriptionStatusRepository subscriptionStatusRepository(@NotNull LegacySubscriptionStatusRepository legacySubscriptionStatusRepository);

    @NotNull
    @Binds
    @Reusable
    ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlagsRepository(@NotNull SubscriptionsFeatureFlagsRepositoryImpl subscriptionsFeatureFlagsRepositoryImpl);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<SubscriptionResponseModel, Subscription> subscriptionsMapper(@NotNull SubscriptionModelMapper subscriptionModelMapper);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<SubscriptionPlanResponseModel, SubscriptionPlan> subscriptionsPlanMapper(@NotNull SubscriptionPlanModelMapper subscriptionPlanModelMapper);

    @NotNull
    @Binds
    @Reusable
    ISubscriptionsRepository subscriptionsRepository(@NotNull SubscriptionsRepositoryImpl subscriptionsRepositoryImpl);

    @NotNull
    @Binds
    @Reusable
    ISubscriptionsTracker subscriptionsTracker(@NotNull SubscriptionsTracker subscriptionsTracker);

    @Binds
    @NotNull
    @Reusable
    ModelMapper<SubscriptionUpgradePlanResponseModel, SubscriptionUpgradePlan> subscriptionsUpgradePlanMapper(@NotNull SubscriptionUpgradePlanModelMapper subscriptionUpgradePlanModelMapper);
}
