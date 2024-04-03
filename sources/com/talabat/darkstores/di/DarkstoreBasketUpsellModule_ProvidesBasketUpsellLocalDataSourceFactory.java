package com.talabat.darkstores.di;

import com.talabat.darkstores.data.basket.local.BasketUpsellLocalDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoreBasketUpsellModule_ProvidesBasketUpsellLocalDataSourceFactory implements Factory<BasketUpsellLocalDataSource> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoreBasketUpsellModule_ProvidesBasketUpsellLocalDataSourceFactory INSTANCE = new DarkstoreBasketUpsellModule_ProvidesBasketUpsellLocalDataSourceFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoreBasketUpsellModule_ProvidesBasketUpsellLocalDataSourceFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BasketUpsellLocalDataSource providesBasketUpsellLocalDataSource() {
        return (BasketUpsellLocalDataSource) Preconditions.checkNotNullFromProvides(DarkstoreBasketUpsellModule.INSTANCE.providesBasketUpsellLocalDataSource());
    }

    public BasketUpsellLocalDataSource get() {
        return providesBasketUpsellLocalDataSource();
    }
}
