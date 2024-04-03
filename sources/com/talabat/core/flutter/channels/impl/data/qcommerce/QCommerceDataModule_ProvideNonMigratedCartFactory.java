package com.talabat.core.flutter.channels.impl.data.qcommerce;

import buisnessmodels.Cart;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class QCommerceDataModule_ProvideNonMigratedCartFactory implements Factory<Cart> {
    private final QCommerceDataModule module;

    public QCommerceDataModule_ProvideNonMigratedCartFactory(QCommerceDataModule qCommerceDataModule) {
        this.module = qCommerceDataModule;
    }

    public static QCommerceDataModule_ProvideNonMigratedCartFactory create(QCommerceDataModule qCommerceDataModule) {
        return new QCommerceDataModule_ProvideNonMigratedCartFactory(qCommerceDataModule);
    }

    public static Cart provideNonMigratedCart(QCommerceDataModule qCommerceDataModule) {
        return (Cart) Preconditions.checkNotNullFromProvides(qCommerceDataModule.provideNonMigratedCart());
    }

    public Cart get() {
        return provideNonMigratedCart(this.module);
    }
}
