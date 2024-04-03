package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RestaurantsSearchActivity_MembersInjector implements MembersInjector<RestaurantsSearchActivity> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public RestaurantsSearchActivity_MembersInjector(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static MembersInjector<RestaurantsSearchActivity> create(Provider<AppVersionProvider> provider) {
        return new RestaurantsSearchActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.RestaurantsSearchActivity.appVersionProvider")
    public static void injectAppVersionProvider(RestaurantsSearchActivity restaurantsSearchActivity, AppVersionProvider appVersionProvider2) {
        restaurantsSearchActivity.f55031i = appVersionProvider2;
    }

    public void injectMembers(RestaurantsSearchActivity restaurantsSearchActivity) {
        injectAppVersionProvider(restaurantsSearchActivity, this.appVersionProvider.get());
    }
}
