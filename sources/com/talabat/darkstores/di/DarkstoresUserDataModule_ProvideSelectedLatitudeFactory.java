package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class DarkstoresUserDataModule_ProvideSelectedLatitudeFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresUserDataModule_ProvideSelectedLatitudeFactory INSTANCE = new DarkstoresUserDataModule_ProvideSelectedLatitudeFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresUserDataModule_ProvideSelectedLatitudeFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provideSelectedLatitude() {
        return (String) Preconditions.checkNotNullFromProvides(DarkstoresUserDataModule.INSTANCE.provideSelectedLatitude());
    }

    public String get() {
        return provideSelectedLatitude();
    }
}
