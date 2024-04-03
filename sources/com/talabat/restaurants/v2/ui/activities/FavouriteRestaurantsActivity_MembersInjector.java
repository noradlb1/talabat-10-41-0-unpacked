package com.talabat.restaurants.v2.ui.activities;

import com.talabat.core.dispatcher.domain.RxSchedulersFactory;
import com.talabat.core.tracking.domain.TalabatTracker;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class FavouriteRestaurantsActivity_MembersInjector implements MembersInjector<FavouriteRestaurantsActivity> {
    private final Provider<RxSchedulersFactory> rxSchedulersFactoryProvider;
    private final Provider<TalabatTracker> trackerProvider;

    public FavouriteRestaurantsActivity_MembersInjector(Provider<TalabatTracker> provider, Provider<RxSchedulersFactory> provider2) {
        this.trackerProvider = provider;
        this.rxSchedulersFactoryProvider = provider2;
    }

    public static MembersInjector<FavouriteRestaurantsActivity> create(Provider<TalabatTracker> provider, Provider<RxSchedulersFactory> provider2) {
        return new FavouriteRestaurantsActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.restaurants.v2.ui.activities.FavouriteRestaurantsActivity.rxSchedulersFactory")
    public static void injectRxSchedulersFactory(FavouriteRestaurantsActivity favouriteRestaurantsActivity, RxSchedulersFactory rxSchedulersFactory) {
        favouriteRestaurantsActivity.rxSchedulersFactory = rxSchedulersFactory;
    }

    @InjectedFieldSignature("com.talabat.restaurants.v2.ui.activities.FavouriteRestaurantsActivity.tracker")
    public static void injectTracker(FavouriteRestaurantsActivity favouriteRestaurantsActivity, TalabatTracker talabatTracker) {
        favouriteRestaurantsActivity.tracker = talabatTracker;
    }

    public void injectMembers(FavouriteRestaurantsActivity favouriteRestaurantsActivity) {
        injectTracker(favouriteRestaurantsActivity, this.trackerProvider.get());
        injectRxSchedulersFactory(favouriteRestaurantsActivity, this.rxSchedulersFactoryProvider.get());
    }
}
