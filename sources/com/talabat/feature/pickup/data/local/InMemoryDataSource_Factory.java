package com.talabat.feature.pickup.data.local;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class InMemoryDataSource_Factory implements Factory<InMemoryDataSource> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final InMemoryDataSource_Factory INSTANCE = new InMemoryDataSource_Factory();

        private InstanceHolder() {
        }
    }

    public static InMemoryDataSource_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static InMemoryDataSource newInstance() {
        return new InMemoryDataSource();
    }

    public InMemoryDataSource get() {
        return newInstance();
    }
}
