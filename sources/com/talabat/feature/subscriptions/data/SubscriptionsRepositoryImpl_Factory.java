package com.talabat.feature.subscriptions.data;

import com.talabat.feature.subscriptions.data.model.ProVendorMovModelMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionCancellationReasonModelMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionMultiPlanModelMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionOTPPaymentStatusMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionPaymentStatusModelMapper;
import com.talabat.feature.subscriptions.data.model.SubscriptionSavingsModelMapper;
import com.talabat.feature.subscriptions.data.model.TProOnBoardingBannerAndPlansMapper;
import com.talabat.feature.subscriptions.data.remote.SubscriptionsDataSource;
import com.talabat.feature.subscriptions.data.remote.model.ProCentralizationResponseResult;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel;
import com.talabat.feature.subscriptions.domain.model.ProCentralization;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.mapper.ModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionsRepositoryImpl_Factory implements Factory<SubscriptionsRepositoryImpl> {
    private final Provider<SubscriptionMultiPlanModelMapper> multiPlanModelMapperProvider;
    private final Provider<SubscriptionPaymentStatusModelMapper> paymentStatusModelMapperProvider;
    private final Provider<ModelMapper<ProCentralizationResponseResult, ProCentralization>> proCentralizationModelMapperProvider;
    private final Provider<ProVendorMovModelMapper> proVendorMovModelMapperProvider;
    private final Provider<SubscriptionSavingsModelMapper> savingsInfoModelMapperProvider;
    private final Provider<SubscriptionCancellationReasonModelMapper> subscriptionCancellationReasonModelMapperProvider;
    private final Provider<ModelMapper<SubscriptionResponseModel, Subscription>> subscriptionModelMapperProvider;
    private final Provider<SubscriptionOTPPaymentStatusMapper> subscriptionOTPPaymentStatusMapperProvider;
    private final Provider<SubscriptionsDataSource> subscriptionsDataSourceProvider;
    private final Provider<TProOnBoardingBannerAndPlansMapper> tProOnBoardingBannerAndPlansMapperProvider;

    public SubscriptionsRepositoryImpl_Factory(Provider<SubscriptionsDataSource> provider, Provider<SubscriptionPaymentStatusModelMapper> provider2, Provider<ModelMapper<SubscriptionResponseModel, Subscription>> provider3, Provider<ModelMapper<ProCentralizationResponseResult, ProCentralization>> provider4, Provider<SubscriptionMultiPlanModelMapper> provider5, Provider<ProVendorMovModelMapper> provider6, Provider<SubscriptionSavingsModelMapper> provider7, Provider<SubscriptionCancellationReasonModelMapper> provider8, Provider<SubscriptionOTPPaymentStatusMapper> provider9, Provider<TProOnBoardingBannerAndPlansMapper> provider10) {
        this.subscriptionsDataSourceProvider = provider;
        this.paymentStatusModelMapperProvider = provider2;
        this.subscriptionModelMapperProvider = provider3;
        this.proCentralizationModelMapperProvider = provider4;
        this.multiPlanModelMapperProvider = provider5;
        this.proVendorMovModelMapperProvider = provider6;
        this.savingsInfoModelMapperProvider = provider7;
        this.subscriptionCancellationReasonModelMapperProvider = provider8;
        this.subscriptionOTPPaymentStatusMapperProvider = provider9;
        this.tProOnBoardingBannerAndPlansMapperProvider = provider10;
    }

    public static SubscriptionsRepositoryImpl_Factory create(Provider<SubscriptionsDataSource> provider, Provider<SubscriptionPaymentStatusModelMapper> provider2, Provider<ModelMapper<SubscriptionResponseModel, Subscription>> provider3, Provider<ModelMapper<ProCentralizationResponseResult, ProCentralization>> provider4, Provider<SubscriptionMultiPlanModelMapper> provider5, Provider<ProVendorMovModelMapper> provider6, Provider<SubscriptionSavingsModelMapper> provider7, Provider<SubscriptionCancellationReasonModelMapper> provider8, Provider<SubscriptionOTPPaymentStatusMapper> provider9, Provider<TProOnBoardingBannerAndPlansMapper> provider10) {
        return new SubscriptionsRepositoryImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static SubscriptionsRepositoryImpl newInstance(SubscriptionsDataSource subscriptionsDataSource, SubscriptionPaymentStatusModelMapper subscriptionPaymentStatusModelMapper, ModelMapper<SubscriptionResponseModel, Subscription> modelMapper, ModelMapper<ProCentralizationResponseResult, ProCentralization> modelMapper2, SubscriptionMultiPlanModelMapper subscriptionMultiPlanModelMapper, ProVendorMovModelMapper proVendorMovModelMapper, SubscriptionSavingsModelMapper subscriptionSavingsModelMapper, SubscriptionCancellationReasonModelMapper subscriptionCancellationReasonModelMapper, SubscriptionOTPPaymentStatusMapper subscriptionOTPPaymentStatusMapper, TProOnBoardingBannerAndPlansMapper tProOnBoardingBannerAndPlansMapper) {
        return new SubscriptionsRepositoryImpl(subscriptionsDataSource, subscriptionPaymentStatusModelMapper, modelMapper, modelMapper2, subscriptionMultiPlanModelMapper, proVendorMovModelMapper, subscriptionSavingsModelMapper, subscriptionCancellationReasonModelMapper, subscriptionOTPPaymentStatusMapper, tProOnBoardingBannerAndPlansMapper);
    }

    public SubscriptionsRepositoryImpl get() {
        return newInstance(this.subscriptionsDataSourceProvider.get(), this.paymentStatusModelMapperProvider.get(), this.subscriptionModelMapperProvider.get(), this.proCentralizationModelMapperProvider.get(), this.multiPlanModelMapperProvider.get(), this.proVendorMovModelMapperProvider.get(), this.savingsInfoModelMapperProvider.get(), this.subscriptionCancellationReasonModelMapperProvider.get(), this.subscriptionOTPPaymentStatusMapperProvider.get(), this.tProOnBoardingBannerAndPlansMapperProvider.get());
    }
}
