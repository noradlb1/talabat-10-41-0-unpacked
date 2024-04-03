package com.talabat.feature.fees.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class UserDataModule_ProvideShopIdFactory implements Factory<Integer> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final UserDataModule_ProvideShopIdFactory INSTANCE = new UserDataModule_ProvideShopIdFactory();

        private InstanceHolder() {
        }
    }

    public static UserDataModule_ProvideShopIdFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static int provideShopId() {
        return UserDataModule.INSTANCE.provideShopId();
    }

    public Integer get() {
        return Integer.valueOf(provideShopId());
    }
}
