package com.talabat.darkstores.feature.cart;

import android.content.SharedPreferences;
import com.talabat.darkstores.common.TimeProvider;
import com.talabat.darkstores.data.tracking.product.ProductTracker;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.feature.darkstorescartlist.domain.repository.DarkstoresCartListRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartController_Factory implements Factory<CartController> {
    private final Provider<DarkstoresCartListRepository> cartListRepositoryProvider;
    private final Provider<DarkstoresCartRepository> cartRepositoryProvider;
    private final Provider<ProductTracker> productTrackerProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TimeProvider> timeProvider;
    private final Provider<DarkstoresEventTracker> trackerProvider;

    public CartController_Factory(Provider<DarkstoresCartRepository> provider, Provider<DarkstoresCartListRepository> provider2, Provider<SharedPreferences> provider3, Provider<DarkstoresEventTracker> provider4, Provider<ProductTracker> provider5, Provider<TimeProvider> provider6) {
        this.cartRepositoryProvider = provider;
        this.cartListRepositoryProvider = provider2;
        this.sharedPreferencesProvider = provider3;
        this.trackerProvider = provider4;
        this.productTrackerProvider = provider5;
        this.timeProvider = provider6;
    }

    public static CartController_Factory create(Provider<DarkstoresCartRepository> provider, Provider<DarkstoresCartListRepository> provider2, Provider<SharedPreferences> provider3, Provider<DarkstoresEventTracker> provider4, Provider<ProductTracker> provider5, Provider<TimeProvider> provider6) {
        return new CartController_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static CartController newInstance(DarkstoresCartRepository darkstoresCartRepository, DarkstoresCartListRepository darkstoresCartListRepository, SharedPreferences sharedPreferences, DarkstoresEventTracker darkstoresEventTracker, ProductTracker productTracker, TimeProvider timeProvider2) {
        return new CartController(darkstoresCartRepository, darkstoresCartListRepository, sharedPreferences, darkstoresEventTracker, productTracker, timeProvider2);
    }

    public CartController get() {
        return newInstance(this.cartRepositoryProvider.get(), this.cartListRepositoryProvider.get(), this.sharedPreferencesProvider.get(), this.trackerProvider.get(), this.productTrackerProvider.get(), this.timeProvider.get());
    }
}
