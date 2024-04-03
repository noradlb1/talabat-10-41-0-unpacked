package com.checkout.frames.screen.countrypicker;

import com.checkout.frames.di.component.CountryPickerViewModelSubComponent;
import com.checkout.frames.screen.countrypicker.CountryPickerViewModel;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class CountryPickerViewModel_Factory_MembersInjector implements MembersInjector<CountryPickerViewModel.Factory> {
    private final Provider<CountryPickerViewModelSubComponent.Builder> subComponentProvider;

    public CountryPickerViewModel_Factory_MembersInjector(Provider<CountryPickerViewModelSubComponent.Builder> provider) {
        this.subComponentProvider = provider;
    }

    public static MembersInjector<CountryPickerViewModel.Factory> create(Provider<CountryPickerViewModelSubComponent.Builder> provider) {
        return new CountryPickerViewModel_Factory_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.checkout.frames.screen.countrypicker.CountryPickerViewModel.Factory.subComponentProvider")
    public static void injectSubComponentProvider(CountryPickerViewModel.Factory factory, Provider<CountryPickerViewModelSubComponent.Builder> provider) {
        factory.subComponentProvider = provider;
    }

    public void injectMembers(CountryPickerViewModel.Factory factory) {
        injectSubComponentProvider(factory, this.subComponentProvider);
    }
}
