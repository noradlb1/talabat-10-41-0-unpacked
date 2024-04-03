package com.checkout.frames.screen.paymentdetails;

import com.checkout.frames.di.screen.PaymentDetailsViewModelSubComponent;
import com.checkout.frames.screen.paymentdetails.PaymentDetailsViewModel;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class PaymentDetailsViewModel_Factory_MembersInjector implements MembersInjector<PaymentDetailsViewModel.Factory> {
    private final Provider<PaymentDetailsViewModelSubComponent.Builder> subComponentProvider;

    public PaymentDetailsViewModel_Factory_MembersInjector(Provider<PaymentDetailsViewModelSubComponent.Builder> provider) {
        this.subComponentProvider = provider;
    }

    public static MembersInjector<PaymentDetailsViewModel.Factory> create(Provider<PaymentDetailsViewModelSubComponent.Builder> provider) {
        return new PaymentDetailsViewModel_Factory_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.checkout.frames.screen.paymentdetails.PaymentDetailsViewModel.Factory.subComponentProvider")
    public static void injectSubComponentProvider(PaymentDetailsViewModel.Factory factory, Provider<PaymentDetailsViewModelSubComponent.Builder> provider) {
        factory.subComponentProvider = provider;
    }

    public void injectMembers(PaymentDetailsViewModel.Factory factory) {
        injectSubComponentProvider(factory, this.subComponentProvider);
    }
}
