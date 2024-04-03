package com.talabat.configuration;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class LegacyConfigurationLocalRepository_Factory implements Factory<LegacyConfigurationLocalRepository> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final LegacyConfigurationLocalRepository_Factory INSTANCE = new LegacyConfigurationLocalRepository_Factory();

        private InstanceHolder() {
        }
    }

    public static LegacyConfigurationLocalRepository_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LegacyConfigurationLocalRepository newInstance() {
        return new LegacyConfigurationLocalRepository();
    }

    public LegacyConfigurationLocalRepository get() {
        return newInstance();
    }
}
