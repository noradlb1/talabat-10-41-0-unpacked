package com.talabat.feature.tpro.presentation.benefits.viewmodel;

import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionMultiPlanUseCase;
import com.talabat.feature.tpro.presentation.model.mapper.TProMultiPlanDisplayModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class MultiPlanParams_Factory implements Factory<MultiPlanParams> {
    private final Provider<GetSubscriptionMultiPlanUseCase> getSubscriptionMultiPlanUseCaseProvider;
    private final Provider<String> multiPlanDurationsProvider;
    private final Provider<TProMultiPlanDisplayModelMapper> multiPlanMapperProvider;

    public MultiPlanParams_Factory(Provider<GetSubscriptionMultiPlanUseCase> provider, Provider<TProMultiPlanDisplayModelMapper> provider2, Provider<String> provider3) {
        this.getSubscriptionMultiPlanUseCaseProvider = provider;
        this.multiPlanMapperProvider = provider2;
        this.multiPlanDurationsProvider = provider3;
    }

    public static MultiPlanParams_Factory create(Provider<GetSubscriptionMultiPlanUseCase> provider, Provider<TProMultiPlanDisplayModelMapper> provider2, Provider<String> provider3) {
        return new MultiPlanParams_Factory(provider, provider2, provider3);
    }

    public static MultiPlanParams newInstance(GetSubscriptionMultiPlanUseCase getSubscriptionMultiPlanUseCase, TProMultiPlanDisplayModelMapper tProMultiPlanDisplayModelMapper, String str) {
        return new MultiPlanParams(getSubscriptionMultiPlanUseCase, tProMultiPlanDisplayModelMapper, str);
    }

    public MultiPlanParams get() {
        return newInstance(this.getSubscriptionMultiPlanUseCaseProvider.get(), this.multiPlanMapperProvider.get(), this.multiPlanDurationsProvider.get());
    }
}
