package com.talabat.darkstores.feature.cart.cartabadonment;

import com.talabat.darkstores.data.tracking.product.ProductTracker;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class StartCartClearedEventTrackerUseCase_Factory implements Factory<StartCartClearedEventTrackerUseCase> {
    private final Provider<DarkstoresCartRepository> cartRepositoryProvider;
    private final Provider<ProductTracker> productTrackerProvider;

    public StartCartClearedEventTrackerUseCase_Factory(Provider<DarkstoresCartRepository> provider, Provider<ProductTracker> provider2) {
        this.cartRepositoryProvider = provider;
        this.productTrackerProvider = provider2;
    }

    public static StartCartClearedEventTrackerUseCase_Factory create(Provider<DarkstoresCartRepository> provider, Provider<ProductTracker> provider2) {
        return new StartCartClearedEventTrackerUseCase_Factory(provider, provider2);
    }

    public static StartCartClearedEventTrackerUseCase newInstance(DarkstoresCartRepository darkstoresCartRepository, ProductTracker productTracker) {
        return new StartCartClearedEventTrackerUseCase(darkstoresCartRepository, productTracker);
    }

    public StartCartClearedEventTrackerUseCase get() {
        return newInstance(this.cartRepositoryProvider.get(), this.productTrackerProvider.get());
    }
}
