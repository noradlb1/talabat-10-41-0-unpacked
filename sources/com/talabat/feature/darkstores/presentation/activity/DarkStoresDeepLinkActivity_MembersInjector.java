package com.talabat.feature.darkstores.presentation.activity;

import com.talabat.feature.darkstores.domain.navigator.DarkstoresNavigator;
import com.talabat.feature.darkstores.presentation.di.DarkStoresDeepLinkViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class DarkStoresDeepLinkActivity_MembersInjector implements MembersInjector<DarkStoresDeepLinkActivity> {
    private final Provider<DarkstoresNavigator> darkStoresNavigatorProvider;
    private final Provider<DarkStoresDeepLinkViewModelFactory> viewModelFactoryProvider;

    public DarkStoresDeepLinkActivity_MembersInjector(Provider<DarkStoresDeepLinkViewModelFactory> provider, Provider<DarkstoresNavigator> provider2) {
        this.viewModelFactoryProvider = provider;
        this.darkStoresNavigatorProvider = provider2;
    }

    public static MembersInjector<DarkStoresDeepLinkActivity> create(Provider<DarkStoresDeepLinkViewModelFactory> provider, Provider<DarkstoresNavigator> provider2) {
        return new DarkStoresDeepLinkActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.feature.darkstores.presentation.activity.DarkStoresDeepLinkActivity.darkStoresNavigator")
    public static void injectDarkStoresNavigator(DarkStoresDeepLinkActivity darkStoresDeepLinkActivity, DarkstoresNavigator darkstoresNavigator) {
        darkStoresDeepLinkActivity.darkStoresNavigator = darkstoresNavigator;
    }

    @InjectedFieldSignature("com.talabat.feature.darkstores.presentation.activity.DarkStoresDeepLinkActivity.viewModelFactory")
    public static void injectViewModelFactory(DarkStoresDeepLinkActivity darkStoresDeepLinkActivity, DarkStoresDeepLinkViewModelFactory darkStoresDeepLinkViewModelFactory) {
        darkStoresDeepLinkActivity.viewModelFactory = darkStoresDeepLinkViewModelFactory;
    }

    public void injectMembers(DarkStoresDeepLinkActivity darkStoresDeepLinkActivity) {
        injectViewModelFactory(darkStoresDeepLinkActivity, this.viewModelFactoryProvider.get());
        injectDarkStoresNavigator(darkStoresDeepLinkActivity, this.darkStoresNavigatorProvider.get());
    }
}
