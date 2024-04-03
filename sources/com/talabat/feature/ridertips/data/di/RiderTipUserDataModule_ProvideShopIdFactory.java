package com.talabat.feature.ridertips.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class RiderTipUserDataModule_ProvideShopIdFactory implements Factory<Integer> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RiderTipUserDataModule_ProvideShopIdFactory INSTANCE = new RiderTipUserDataModule_ProvideShopIdFactory();

        private InstanceHolder() {
        }
    }

    public static RiderTipUserDataModule_ProvideShopIdFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static int provideShopId() {
        return RiderTipUserDataModule.INSTANCE.provideShopId();
    }

    public Integer get() {
        return Integer.valueOf(provideShopId());
    }
}
