package com.talabat.feature.activecarts.presentation;

import com.talabat.feature.activecarts.presentation.viewmodel.BasketListViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class BasketListActivity_MembersInjector implements MembersInjector<BasketListActivity> {
    private final Provider<BasketListViewModelFactory> viewModelFactoryProvider;

    public BasketListActivity_MembersInjector(Provider<BasketListViewModelFactory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<BasketListActivity> create(Provider<BasketListViewModelFactory> provider) {
        return new BasketListActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.activecarts.presentation.BasketListActivity.viewModelFactory")
    public static void injectViewModelFactory(BasketListActivity basketListActivity, BasketListViewModelFactory basketListViewModelFactory) {
        basketListActivity.viewModelFactory = basketListViewModelFactory;
    }

    public void injectMembers(BasketListActivity basketListActivity) {
        injectViewModelFactory(basketListActivity, this.viewModelFactoryProvider.get());
    }
}
