package com.talabat.darkstores.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class DarkstoresUserDataModule_ProvideSelectedLongitudeFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DarkstoresUserDataModule_ProvideSelectedLongitudeFactory INSTANCE = new DarkstoresUserDataModule_ProvideSelectedLongitudeFactory();

        private InstanceHolder() {
        }
    }

    public static DarkstoresUserDataModule_ProvideSelectedLongitudeFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provideSelectedLongitude() {
        return (String) Preconditions.checkNotNullFromProvides(DarkstoresUserDataModule.INSTANCE.provideSelectedLongitude());
    }

    public String get() {
        return provideSelectedLongitude();
    }
}
