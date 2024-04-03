package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;
import library.talabat.mvp.cart.CartUtility;

@QualifierMetadata
@DaggerGenerated
public final class MenuSearchActivity_MembersInjector implements MembersInjector<MenuSearchActivity> {
    private final Provider<AppVersionProvider> appVersionProvider;
    private final Provider<CartUtility> cartUtilityProvider;
    private final Provider<ITalabatExperiment> talabatExperimentProvider;

    public MenuSearchActivity_MembersInjector(Provider<AppVersionProvider> provider, Provider<CartUtility> provider2, Provider<ITalabatExperiment> provider3) {
        this.appVersionProvider = provider;
        this.cartUtilityProvider = provider2;
        this.talabatExperimentProvider = provider3;
    }

    public static MembersInjector<MenuSearchActivity> create(Provider<AppVersionProvider> provider, Provider<CartUtility> provider2, Provider<ITalabatExperiment> provider3) {
        return new MenuSearchActivity_MembersInjector(provider, provider2, provider3);
    }

    @InjectedFieldSignature("com.talabat.MenuSearchActivity.appVersionProvider")
    public static void injectAppVersionProvider(MenuSearchActivity menuSearchActivity, AppVersionProvider appVersionProvider2) {
        menuSearchActivity.f54396m = appVersionProvider2;
    }

    @InjectedFieldSignature("com.talabat.MenuSearchActivity.cartUtility")
    public static void injectCartUtility(MenuSearchActivity menuSearchActivity, CartUtility cartUtility) {
        menuSearchActivity.f54397n = cartUtility;
    }

    @InjectedFieldSignature("com.talabat.MenuSearchActivity.talabatExperiment")
    public static void injectTalabatExperiment(MenuSearchActivity menuSearchActivity, ITalabatExperiment iTalabatExperiment) {
        menuSearchActivity.f54398o = iTalabatExperiment;
    }

    public void injectMembers(MenuSearchActivity menuSearchActivity) {
        injectAppVersionProvider(menuSearchActivity, this.appVersionProvider.get());
        injectCartUtility(menuSearchActivity, this.cartUtilityProvider.get());
        injectTalabatExperiment(menuSearchActivity, this.talabatExperimentProvider.get());
    }
}
