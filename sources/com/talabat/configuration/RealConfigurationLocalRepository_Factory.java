package com.talabat.configuration;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class RealConfigurationLocalRepository_Factory implements Factory<RealConfigurationLocalRepository> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RealConfigurationLocalRepository_Factory INSTANCE = new RealConfigurationLocalRepository_Factory();

        private InstanceHolder() {
        }
    }

    public static RealConfigurationLocalRepository_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RealConfigurationLocalRepository newInstance() {
        return new RealConfigurationLocalRepository();
    }

    public RealConfigurationLocalRepository get() {
        return newInstance();
    }
}
