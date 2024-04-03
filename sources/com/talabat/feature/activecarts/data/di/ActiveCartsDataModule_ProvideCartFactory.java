package com.talabat.feature.activecarts.data.di;

import buisnessmodels.Cart;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ActiveCartsDataModule_ProvideCartFactory implements Factory<Cart> {
    private final ActiveCartsDataModule module;

    public ActiveCartsDataModule_ProvideCartFactory(ActiveCartsDataModule activeCartsDataModule) {
        this.module = activeCartsDataModule;
    }

    public static ActiveCartsDataModule_ProvideCartFactory create(ActiveCartsDataModule activeCartsDataModule) {
        return new ActiveCartsDataModule_ProvideCartFactory(activeCartsDataModule);
    }

    public static Cart provideCart(ActiveCartsDataModule activeCartsDataModule) {
        return (Cart) Preconditions.checkNotNullFromProvides(activeCartsDataModule.provideCart());
    }

    public Cart get() {
        return provideCart(this.module);
    }
}
