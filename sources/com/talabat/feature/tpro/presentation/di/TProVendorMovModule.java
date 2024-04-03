package com.talabat.feature.tpro.presentation.di;

import buisnessmodels.Customer;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import dagger.Module;
import dagger.Provides;
import datamodels.CustomerInfo;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/tpro/presentation/di/TProVendorMovModule;", "", "()V", "IS_TPRO_NFV_ENABLED", "", "IS_TPRO_USER", "TPRO_PLAN_MOV", "provideIsTproNfvEnabled", "", "flagsRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "provideIsTproUser", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "provideTproPlanMOV", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class TProVendorMovModule {
    @NotNull
    public static final TProVendorMovModule INSTANCE = new TProVendorMovModule();
    @NotNull
    public static final String IS_TPRO_NFV_ENABLED = "isTproNfvEnabled";
    @NotNull
    public static final String IS_TPRO_USER = "isTproUser";
    @NotNull
    public static final String TPRO_PLAN_MOV = "TProPlanMOV";

    private TProVendorMovModule() {
    }

    @Provides
    @Named("isTproNfvEnabled")
    public final boolean provideIsTproNfvEnabled(@NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "flagsRepository");
        return iSubscriptionsFeatureFlagsRepository.isTProEnabledForNFV();
    }

    @Provides
    @Named("isTproUser")
    public final boolean provideIsTproUser(@NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "subscriptionStatusRepository");
        return iSubscriptionStatusRepository.isTProUser();
    }

    @Provides
    @Named("TProPlanMOV")
    public final float provideTproPlanMOV() {
        CustomerInfo customerInfo;
        Customer instance = Customer.getInstance();
        if (instance == null || (customerInfo = instance.getCustomerInfo()) == null) {
            return 0.0f;
        }
        return customerInfo.minimOrderValueToEnableTproDiscount;
    }
}
