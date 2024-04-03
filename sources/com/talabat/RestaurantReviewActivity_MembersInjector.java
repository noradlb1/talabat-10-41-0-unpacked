package com.talabat;

import com.talabat.configuration.discovery.AppVersionProvider;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class RestaurantReviewActivity_MembersInjector implements MembersInjector<RestaurantReviewActivity> {
    private final Provider<AppVersionProvider> appVersionProvider;

    public RestaurantReviewActivity_MembersInjector(Provider<AppVersionProvider> provider) {
        this.appVersionProvider = provider;
    }

    public static MembersInjector<RestaurantReviewActivity> create(Provider<AppVersionProvider> provider) {
        return new RestaurantReviewActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.RestaurantReviewActivity.appVersionProvider")
    public static void injectAppVersionProvider(RestaurantReviewActivity restaurantReviewActivity, AppVersionProvider appVersionProvider2) {
        restaurantReviewActivity.f55028j = appVersionProvider2;
    }

    public void injectMembers(RestaurantReviewActivity restaurantReviewActivity) {
        injectAppVersionProvider(restaurantReviewActivity, this.appVersionProvider.get());
    }
}
