package com.talabat.feature.darkstorescarrierbag.presentation;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class DarkstoresCarrierBagManager_MembersInjector implements MembersInjector<DarkstoresCarrierBagManager> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public DarkstoresCarrierBagManager_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<DarkstoresCarrierBagManager> create(Provider<ViewModelProvider.Factory> provider) {
        return new DarkstoresCarrierBagManager_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.darkstorescarrierbag.presentation.DarkstoresCarrierBagManager.viewModelFactory")
    public static void injectViewModelFactory(DarkstoresCarrierBagManager darkstoresCarrierBagManager, ViewModelProvider.Factory factory) {
        darkstoresCarrierBagManager.viewModelFactory = factory;
    }

    public void injectMembers(DarkstoresCarrierBagManager darkstoresCarrierBagManager) {
        injectViewModelFactory(darkstoresCarrierBagManager, this.viewModelFactoryProvider.get());
    }
}
