package com.checkout.frames.component.cardscheme;

import com.checkout.frames.component.cardscheme.CardSchemeViewModel;
import com.checkout.frames.di.component.CardSchemeViewModelSubComponent;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class CardSchemeViewModel_Factory_MembersInjector implements MembersInjector<CardSchemeViewModel.Factory> {
    private final Provider<CardSchemeViewModelSubComponent.Builder> subComponentProvider;

    public CardSchemeViewModel_Factory_MembersInjector(Provider<CardSchemeViewModelSubComponent.Builder> provider) {
        this.subComponentProvider = provider;
    }

    public static MembersInjector<CardSchemeViewModel.Factory> create(Provider<CardSchemeViewModelSubComponent.Builder> provider) {
        return new CardSchemeViewModel_Factory_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.checkout.frames.component.cardscheme.CardSchemeViewModel.Factory.subComponentProvider")
    public static void injectSubComponentProvider(CardSchemeViewModel.Factory factory, Provider<CardSchemeViewModelSubComponent.Builder> provider) {
        factory.subComponentProvider = provider;
    }

    public void injectMembers(CardSchemeViewModel.Factory factory) {
        injectSubComponentProvider(factory, this.subComponentProvider);
    }
}
