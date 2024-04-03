package com.talabat.feature.subscriptions.domain.wrapper;

import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionPaymentWithErrorHandlingUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PostSubscriptionPaymentRxWrapper_Factory implements Factory<PostSubscriptionPaymentRxWrapper> {
    private final Provider<GetSubscriptionPaymentWithErrorHandlingUseCase> getSubscriptionPaymentUseCaseProvider;

    public PostSubscriptionPaymentRxWrapper_Factory(Provider<GetSubscriptionPaymentWithErrorHandlingUseCase> provider) {
        this.getSubscriptionPaymentUseCaseProvider = provider;
    }

    public static PostSubscriptionPaymentRxWrapper_Factory create(Provider<GetSubscriptionPaymentWithErrorHandlingUseCase> provider) {
        return new PostSubscriptionPaymentRxWrapper_Factory(provider);
    }

    public static PostSubscriptionPaymentRxWrapper newInstance(GetSubscriptionPaymentWithErrorHandlingUseCase getSubscriptionPaymentWithErrorHandlingUseCase) {
        return new PostSubscriptionPaymentRxWrapper(getSubscriptionPaymentWithErrorHandlingUseCase);
    }

    public PostSubscriptionPaymentRxWrapper get() {
        return newInstance(this.getSubscriptionPaymentUseCaseProvider.get());
    }
}
