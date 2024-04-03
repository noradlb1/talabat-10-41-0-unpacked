package com.talabat.core.flutter.channels.impl.data.tpro;

import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.usecase.GetTProVendorMovUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.ProCentralizationStatusWrapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TProChannelCallbackImpl_Factory implements Factory<TProChannelCallbackImpl> {
    private final Provider<GetTProVendorMovUseCase> getProMovUseCaseProvider;
    private final Provider<ProCentralizationStatusWrapper> proCentralizationStatusWrapperProvider;
    private final Provider<ISubscriptionStatusRepository> subscriptionStatusRepositoryProvider;
    private final Provider<Float> tProPlanMovProvider;

    public TProChannelCallbackImpl_Factory(Provider<GetTProVendorMovUseCase> provider, Provider<ISubscriptionStatusRepository> provider2, Provider<Float> provider3, Provider<ProCentralizationStatusWrapper> provider4) {
        this.getProMovUseCaseProvider = provider;
        this.subscriptionStatusRepositoryProvider = provider2;
        this.tProPlanMovProvider = provider3;
        this.proCentralizationStatusWrapperProvider = provider4;
    }

    public static TProChannelCallbackImpl_Factory create(Provider<GetTProVendorMovUseCase> provider, Provider<ISubscriptionStatusRepository> provider2, Provider<Float> provider3, Provider<ProCentralizationStatusWrapper> provider4) {
        return new TProChannelCallbackImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static TProChannelCallbackImpl newInstance(GetTProVendorMovUseCase getTProVendorMovUseCase, ISubscriptionStatusRepository iSubscriptionStatusRepository, float f11, ProCentralizationStatusWrapper proCentralizationStatusWrapper) {
        return new TProChannelCallbackImpl(getTProVendorMovUseCase, iSubscriptionStatusRepository, f11, proCentralizationStatusWrapper);
    }

    public TProChannelCallbackImpl get() {
        return newInstance(this.getProMovUseCaseProvider.get(), this.subscriptionStatusRepositoryProvider.get(), this.tProPlanMovProvider.get().floatValue(), this.proCentralizationStatusWrapperProvider.get());
    }
}
