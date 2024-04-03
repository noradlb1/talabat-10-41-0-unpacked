package com.talabat.core.advertisement.google.data.datasource.legacy;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LegacyGoogleAidDataSource_Factory implements Factory<LegacyGoogleAidDataSource> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final LegacyGoogleAidDataSource_Factory INSTANCE = new LegacyGoogleAidDataSource_Factory();

        private InstanceHolder() {
        }
    }

    public static LegacyGoogleAidDataSource_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LegacyGoogleAidDataSource newInstance() {
        return new LegacyGoogleAidDataSource();
    }

    public LegacyGoogleAidDataSource get() {
        return newInstance();
    }
}
