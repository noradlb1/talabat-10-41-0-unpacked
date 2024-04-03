package com.checkout.frames.screen.paymentform;

import com.checkout.frames.screen.paymentform.PaymentFormViewModel;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class PaymentFormViewModel_Factory_MembersInjector implements MembersInjector<PaymentFormViewModel.Factory> {
    private final Provider<PaymentFormViewModel> viewModelProvider;

    public PaymentFormViewModel_Factory_MembersInjector(Provider<PaymentFormViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<PaymentFormViewModel.Factory> create(Provider<PaymentFormViewModel> provider) {
        return new PaymentFormViewModel_Factory_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.checkout.frames.screen.paymentform.PaymentFormViewModel.Factory.viewModel")
    public static void injectViewModel(PaymentFormViewModel.Factory factory, PaymentFormViewModel paymentFormViewModel) {
        factory.viewModel = paymentFormViewModel;
    }

    public void injectMembers(PaymentFormViewModel.Factory factory) {
        injectViewModel(factory, this.viewModelProvider.get());
    }
}
