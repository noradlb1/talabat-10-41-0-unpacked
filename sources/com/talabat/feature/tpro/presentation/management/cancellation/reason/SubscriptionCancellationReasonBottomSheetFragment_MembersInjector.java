package com.talabat.feature.tpro.presentation.management.cancellation.reason;

import com.talabat.feature.tpro.presentation.management.cancellation.reason.viewModel.SubscriptionCancellationReasonsViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class SubscriptionCancellationReasonBottomSheetFragment_MembersInjector implements MembersInjector<SubscriptionCancellationReasonBottomSheetFragment> {
    private final Provider<SubscriptionCancellationReasonsViewModelFactory> viewModelFactoryProvider;

    public SubscriptionCancellationReasonBottomSheetFragment_MembersInjector(Provider<SubscriptionCancellationReasonsViewModelFactory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<SubscriptionCancellationReasonBottomSheetFragment> create(Provider<SubscriptionCancellationReasonsViewModelFactory> provider) {
        return new SubscriptionCancellationReasonBottomSheetFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.tpro.presentation.management.cancellation.reason.SubscriptionCancellationReasonBottomSheetFragment.viewModelFactory")
    public static void injectViewModelFactory(SubscriptionCancellationReasonBottomSheetFragment subscriptionCancellationReasonBottomSheetFragment, SubscriptionCancellationReasonsViewModelFactory subscriptionCancellationReasonsViewModelFactory) {
        subscriptionCancellationReasonBottomSheetFragment.viewModelFactory = subscriptionCancellationReasonsViewModelFactory;
    }

    public void injectMembers(SubscriptionCancellationReasonBottomSheetFragment subscriptionCancellationReasonBottomSheetFragment) {
        injectViewModelFactory(subscriptionCancellationReasonBottomSheetFragment, this.viewModelFactoryProvider.get());
    }
}
