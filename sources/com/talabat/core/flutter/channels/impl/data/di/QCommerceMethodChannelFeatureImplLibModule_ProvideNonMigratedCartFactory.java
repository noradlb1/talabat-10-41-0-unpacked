package com.talabat.core.flutter.channels.impl.data.di;

import buisnessmodels.Cart;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class QCommerceMethodChannelFeatureImplLibModule_ProvideNonMigratedCartFactory implements Factory<Cart> {
    private final QCommerceMethodChannelFeatureImplLibModule module;

    public QCommerceMethodChannelFeatureImplLibModule_ProvideNonMigratedCartFactory(QCommerceMethodChannelFeatureImplLibModule qCommerceMethodChannelFeatureImplLibModule) {
        this.module = qCommerceMethodChannelFeatureImplLibModule;
    }

    public static QCommerceMethodChannelFeatureImplLibModule_ProvideNonMigratedCartFactory create(QCommerceMethodChannelFeatureImplLibModule qCommerceMethodChannelFeatureImplLibModule) {
        return new QCommerceMethodChannelFeatureImplLibModule_ProvideNonMigratedCartFactory(qCommerceMethodChannelFeatureImplLibModule);
    }

    public static Cart provideNonMigratedCart(QCommerceMethodChannelFeatureImplLibModule qCommerceMethodChannelFeatureImplLibModule) {
        return (Cart) Preconditions.checkNotNullFromProvides(qCommerceMethodChannelFeatureImplLibModule.provideNonMigratedCart());
    }

    public Cart get() {
        return provideNonMigratedCart(this.module);
    }
}
