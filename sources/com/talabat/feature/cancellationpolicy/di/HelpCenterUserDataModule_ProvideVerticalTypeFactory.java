package com.talabat.feature.cancellationpolicy.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class HelpCenterUserDataModule_ProvideVerticalTypeFactory implements Factory<Integer> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final HelpCenterUserDataModule_ProvideVerticalTypeFactory INSTANCE = new HelpCenterUserDataModule_ProvideVerticalTypeFactory();

        private InstanceHolder() {
        }
    }

    public static HelpCenterUserDataModule_ProvideVerticalTypeFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static int provideVerticalType() {
        return HelpCenterUserDataModule.INSTANCE.provideVerticalType();
    }

    public Integer get() {
        return Integer.valueOf(provideVerticalType());
    }
}
