package com.talabat.feature.subscriptions.domain.usecase;

import com.talabat.feature.subscriptions.domain.ISubscriptionsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SendCancellationFeedbackUseCase_Factory implements Factory<SendCancellationFeedbackUseCase> {
    private final Provider<ISubscriptionsRepository> repositoryProvider;

    public SendCancellationFeedbackUseCase_Factory(Provider<ISubscriptionsRepository> provider) {
        this.repositoryProvider = provider;
    }

    public static SendCancellationFeedbackUseCase_Factory create(Provider<ISubscriptionsRepository> provider) {
        return new SendCancellationFeedbackUseCase_Factory(provider);
    }

    public static SendCancellationFeedbackUseCase newInstance(ISubscriptionsRepository iSubscriptionsRepository) {
        return new SendCancellationFeedbackUseCase(iSubscriptionsRepository);
    }

    public SendCancellationFeedbackUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }
}
