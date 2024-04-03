package com.talabat.feature.tpro.presentation.management.cancellation.reason.viewModel;

import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionCancellationReasonsUseCase;
import com.talabat.feature.subscriptions.domain.usecase.SendCancellationFeedbackUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionCancellationReasonsViewModel_Factory implements Factory<SubscriptionCancellationReasonsViewModel> {
    private final Provider<GetSubscriptionCancellationReasonsUseCase> getSubscriptionCancellationReasonsUseCaseProvider;
    private final Provider<SendCancellationFeedbackUseCase> sendCancellationFeedbackUseCaseProvider;

    public SubscriptionCancellationReasonsViewModel_Factory(Provider<GetSubscriptionCancellationReasonsUseCase> provider, Provider<SendCancellationFeedbackUseCase> provider2) {
        this.getSubscriptionCancellationReasonsUseCaseProvider = provider;
        this.sendCancellationFeedbackUseCaseProvider = provider2;
    }

    public static SubscriptionCancellationReasonsViewModel_Factory create(Provider<GetSubscriptionCancellationReasonsUseCase> provider, Provider<SendCancellationFeedbackUseCase> provider2) {
        return new SubscriptionCancellationReasonsViewModel_Factory(provider, provider2);
    }

    public static SubscriptionCancellationReasonsViewModel newInstance(GetSubscriptionCancellationReasonsUseCase getSubscriptionCancellationReasonsUseCase, SendCancellationFeedbackUseCase sendCancellationFeedbackUseCase) {
        return new SubscriptionCancellationReasonsViewModel(getSubscriptionCancellationReasonsUseCase, sendCancellationFeedbackUseCase);
    }

    public SubscriptionCancellationReasonsViewModel get() {
        return newInstance(this.getSubscriptionCancellationReasonsUseCaseProvider.get(), this.sendCancellationFeedbackUseCaseProvider.get());
    }
}
