package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class QuickFindRestaurantScreen_MembersInjector implements MembersInjector<QuickFindRestaurantScreen> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public QuickFindRestaurantScreen_MembersInjector(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static MembersInjector<QuickFindRestaurantScreen> create(Provider<AppVersionProvider> provider) {
        return new QuickFindRestaurantScreen_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.QuickFindRestaurantScreen.appVersionProvider")
    public static void injectAppVersionProvider(QuickFindRestaurantScreen quickFindRestaurantScreen, AppVersionProvider appVersionProvider2) {
        quickFindRestaurantScreen.f54561k = appVersionProvider2;
    }

    public void injectMembers(QuickFindRestaurantScreen quickFindRestaurantScreen) {
        injectAppVersionProvider(quickFindRestaurantScreen, this.appVersionProvider.get());
    }
}
