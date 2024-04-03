package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class DarkstoresUserDataModule_ProvideSelectedAreaIdFactory implements Factory<Integer> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresUserDataModule_ProvideSelectedAreaIdFactory INSTANCE = new DarkstoresUserDataModule_ProvideSelectedAreaIdFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresUserDataModule_ProvideSelectedAreaIdFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static int provideSelectedAreaId() {
        return DarkstoresUserDataModule.INSTANCE.provideSelectedAreaId();
    }

    public Integer get() {
        return Integer.valueOf(provideSelectedAreaId());
    }
}
