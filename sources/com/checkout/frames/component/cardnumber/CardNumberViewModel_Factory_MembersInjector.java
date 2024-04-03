package com.checkout.frames.component.cardnumber;

import com.checkout.frames.component.cardnumber.CardNumberViewModel;
import com.checkout.frames.di.component.CardNumberViewModelSubComponent;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class CardNumberViewModel_Factory_MembersInjector implements MembersInjector<CardNumberViewModel.Factory> {
    private final Provider<CardNumberViewModelSubComponent.Builder> subComponentProvider;

    public CardNumberViewModel_Factory_MembersInjector(Provider<CardNumberViewModelSubComponent.Builder> provider) {
        this.subComponentProvider = provider;
    }

    public static MembersInjector<CardNumberViewModel.Factory> create(Provider<CardNumberViewModelSubComponent.Builder> provider) {
        return new CardNumberViewModel_Factory_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.checkout.frames.component.cardnumber.CardNumberViewModel.Factory.subComponentProvider")
    public static void injectSubComponentProvider(CardNumberViewModel.Factory factory, Provider<CardNumberViewModelSubComponent.Builder> provider) {
        factory.subComponentProvider = provider;
    }

    public void injectMembers(CardNumberViewModel.Factory factory) {
        injectSubComponentProvider(factory, this.subComponentProvider);
    }
}
