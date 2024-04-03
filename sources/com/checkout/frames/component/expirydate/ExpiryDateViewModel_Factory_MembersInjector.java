package com.checkout.frames.component.expirydate;

import com.checkout.frames.component.expirydate.ExpiryDateViewModel;
import com.checkout.frames.di.component.ExpiryDateViewModelSubComponent;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class ExpiryDateViewModel_Factory_MembersInjector implements MembersInjector<ExpiryDateViewModel.Factory> {
    private final Provider<ExpiryDateViewModelSubComponent.Builder> subComponentProvider;

    public ExpiryDateViewModel_Factory_MembersInjector(Provider<ExpiryDateViewModelSubComponent.Builder> provider) {
        this.subComponentProvider = provider;
    }

    public static MembersInjector<ExpiryDateViewModel.Factory> create(Provider<ExpiryDateViewModelSubComponent.Builder> provider) {
        return new ExpiryDateViewModel_Factory_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.checkout.frames.component.expirydate.ExpiryDateViewModel.Factory.subComponentProvider")
    public static void injectSubComponentProvider(ExpiryDateViewModel.Factory factory, Provider<ExpiryDateViewModelSubComponent.Builder> provider) {
        factory.subComponentProvider = provider;
    }

    public void injectMembers(ExpiryDateViewModel.Factory factory) {
        injectSubComponentProvider(factory, this.subComponentProvider);
    }
}
