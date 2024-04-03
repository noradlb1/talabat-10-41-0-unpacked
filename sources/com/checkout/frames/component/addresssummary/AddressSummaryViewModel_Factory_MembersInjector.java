package com.checkout.frames.component.addresssummary;

import com.checkout.frames.component.addresssummary.AddressSummaryViewModel;
import com.checkout.frames.di.component.AddressSummaryViewModelSubComponent;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class AddressSummaryViewModel_Factory_MembersInjector implements MembersInjector<AddressSummaryViewModel.Factory> {
    private final Provider<AddressSummaryViewModelSubComponent.Builder> subComponentProvider;

    public AddressSummaryViewModel_Factory_MembersInjector(Provider<AddressSummaryViewModelSubComponent.Builder> provider) {
        this.subComponentProvider = provider;
    }

    public static MembersInjector<AddressSummaryViewModel.Factory> create(Provider<AddressSummaryViewModelSubComponent.Builder> provider) {
        return new AddressSummaryViewModel_Factory_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.checkout.frames.component.addresssummary.AddressSummaryViewModel.Factory.subComponentProvider")
    public static void injectSubComponentProvider(AddressSummaryViewModel.Factory factory, Provider<AddressSummaryViewModelSubComponent.Builder> provider) {
        factory.subComponentProvider = provider;
    }

    public void injectMembers(AddressSummaryViewModel.Factory factory) {
        injectSubComponentProvider(factory, this.subComponentProvider);
    }
}
