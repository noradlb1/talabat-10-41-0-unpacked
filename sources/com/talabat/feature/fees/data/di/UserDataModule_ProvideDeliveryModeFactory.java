package com.talabat.feature.fees.data.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class UserDataModule_ProvideDeliveryModeFactory implements Factory<String> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final UserDataModule_ProvideDeliveryModeFactory INSTANCE = new UserDataModule_ProvideDeliveryModeFactory();

        private InstanceHolder() {
        }
    }

    public static UserDataModule_ProvideDeliveryModeFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provideDeliveryMode() {
        return (String) Preconditions.checkNotNullFromProvides(UserDataModule.INSTANCE.provideDeliveryMode());
    }

    public String get() {
        return provideDeliveryMode();
    }
}
