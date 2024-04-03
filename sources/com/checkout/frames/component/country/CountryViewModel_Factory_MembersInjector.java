package com.checkout.frames.component.country;

import com.checkout.frames.component.country.CountryViewModel;
import com.checkout.frames.di.component.CountryViewModelSubComponent;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class CountryViewModel_Factory_MembersInjector implements MembersInjector<CountryViewModel.Factory> {
    private final Provider<CountryViewModelSubComponent.Builder> subComponentProvider;

    public CountryViewModel_Factory_MembersInjector(Provider<CountryViewModelSubComponent.Builder> provider) {
        this.subComponentProvider = provider;
    }

    public static MembersInjector<CountryViewModel.Factory> create(Provider<CountryViewModelSubComponent.Builder> provider) {
        return new CountryViewModel_Factory_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.checkout.frames.component.country.CountryViewModel.Factory.subComponentProvider")
    public static void injectSubComponentProvider(CountryViewModel.Factory factory, Provider<CountryViewModelSubComponent.Builder> provider) {
        factory.subComponentProvider = provider;
    }

    public void injectMembers(CountryViewModel.Factory factory) {
        injectSubComponentProvider(factory, this.subComponentProvider);
    }
}
