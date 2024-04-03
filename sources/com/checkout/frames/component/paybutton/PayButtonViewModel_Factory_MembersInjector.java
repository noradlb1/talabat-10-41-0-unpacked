package com.checkout.frames.component.paybutton;

import com.checkout.frames.component.paybutton.PayButtonViewModel;
import com.checkout.frames.di.component.PayButtonViewModelSubComponent;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class PayButtonViewModel_Factory_MembersInjector implements MembersInjector<PayButtonViewModel.Factory> {
    private final Provider<PayButtonViewModelSubComponent.Builder> subComponentProvider;

    public PayButtonViewModel_Factory_MembersInjector(Provider<PayButtonViewModelSubComponent.Builder> provider) {
        this.subComponentProvider = provider;
    }

    public static MembersInjector<PayButtonViewModel.Factory> create(Provider<PayButtonViewModelSubComponent.Builder> provider) {
        return new PayButtonViewModel_Factory_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.checkout.frames.component.paybutton.PayButtonViewModel.Factory.subComponentProvider")
    public static void injectSubComponentProvider(PayButtonViewModel.Factory factory, Provider<PayButtonViewModelSubComponent.Builder> provider) {
        factory.subComponentProvider = provider;
    }

    public void injectMembers(PayButtonViewModel.Factory factory) {
        injectSubComponentProvider(factory, this.subComponentProvider);
    }
}
