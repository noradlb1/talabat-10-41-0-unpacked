package com.checkout.frames.component.cvv;

import com.checkout.frames.component.cvv.CvvViewModel;
import com.checkout.frames.di.component.CvvViewModelSubComponent;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class CvvViewModel_Factory_MembersInjector implements MembersInjector<CvvViewModel.Factory> {
    private final Provider<CvvViewModelSubComponent.Builder> subComponentProvider;

    public CvvViewModel_Factory_MembersInjector(Provider<CvvViewModelSubComponent.Builder> provider) {
        this.subComponentProvider = provider;
    }

    public static MembersInjector<CvvViewModel.Factory> create(Provider<CvvViewModelSubComponent.Builder> provider) {
        return new CvvViewModel_Factory_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.checkout.frames.component.cvv.CvvViewModel.Factory.subComponentProvider")
    public static void injectSubComponentProvider(CvvViewModel.Factory factory, Provider<CvvViewModelSubComponent.Builder> provider) {
        factory.subComponentProvider = provider;
    }

    public void injectMembers(CvvViewModel.Factory factory) {
        injectSubComponentProvider(factory, this.subComponentProvider);
    }
}
