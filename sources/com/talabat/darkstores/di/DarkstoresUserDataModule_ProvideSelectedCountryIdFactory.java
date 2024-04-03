package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class DarkstoresUserDataModule_ProvideSelectedCountryIdFactory implements Factory<Integer> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresUserDataModule_ProvideSelectedCountryIdFactory INSTANCE = new DarkstoresUserDataModule_ProvideSelectedCountryIdFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresUserDataModule_ProvideSelectedCountryIdFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static int provideSelectedCountryId() {
        return DarkstoresUserDataModule.INSTANCE.provideSelectedCountryId();
    }

    public Integer get() {
        return Integer.valueOf(provideSelectedCountryId());
    }
}
