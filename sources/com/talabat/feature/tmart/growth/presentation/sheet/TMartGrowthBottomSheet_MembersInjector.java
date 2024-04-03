package com.talabat.feature.tmart.growth.presentation.sheet;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class TMartGrowthBottomSheet_MembersInjector implements MembersInjector<TMartGrowthBottomSheet> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public TMartGrowthBottomSheet_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<TMartGrowthBottomSheet> create(Provider<ViewModelProvider.Factory> provider) {
        return new TMartGrowthBottomSheet_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheet.viewModelFactory")
    public static void injectViewModelFactory(TMartGrowthBottomSheet tMartGrowthBottomSheet, ViewModelProvider.Factory factory) {
        tMartGrowthBottomSheet.viewModelFactory = factory;
    }

    public void injectMembers(TMartGrowthBottomSheet tMartGrowthBottomSheet) {
        injectViewModelFactory(tMartGrowthBottomSheet, this.viewModelFactoryProvider.get());
    }
}
