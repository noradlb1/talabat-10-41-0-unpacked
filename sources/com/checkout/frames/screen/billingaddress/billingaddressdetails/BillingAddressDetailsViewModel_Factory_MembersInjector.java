package com.checkout.frames.screen.billingaddress.billingaddressdetails;

import com.checkout.frames.di.component.BillingFormViewModelSubComponent;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class BillingAddressDetailsViewModel_Factory_MembersInjector implements MembersInjector<BillingAddressDetailsViewModel.Factory> {
    private final Provider<BillingFormViewModelSubComponent.Builder> subComponentProvider;

    public BillingAddressDetailsViewModel_Factory_MembersInjector(Provider<BillingFormViewModelSubComponent.Builder> provider) {
        this.subComponentProvider = provider;
    }

    public static MembersInjector<BillingAddressDetailsViewModel.Factory> create(Provider<BillingFormViewModelSubComponent.Builder> provider) {
        return new BillingAddressDetailsViewModel_Factory_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.checkout.frames.screen.billingaddress.billingaddressdetails.BillingAddressDetailsViewModel.Factory.subComponentProvider")
    public static void injectSubComponentProvider(BillingAddressDetailsViewModel.Factory factory, Provider<BillingFormViewModelSubComponent.Builder> provider) {
        factory.subComponentProvider = provider;
    }

    public void injectMembers(BillingAddressDetailsViewModel.Factory factory) {
        injectSubComponentProvider(factory, this.subComponentProvider);
    }
}
