package com.talabat.feature.fees.data.local;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class InMemoryFeesDataSource_Factory implements Factory<InMemoryFeesDataSource> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final InMemoryFeesDataSource_Factory INSTANCE = new InMemoryFeesDataSource_Factory();

        private InstanceHolder() {
        }
    }

    public static InMemoryFeesDataSource_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static InMemoryFeesDataSource newInstance() {
        return new InMemoryFeesDataSource();
    }

    public InMemoryFeesDataSource get() {
        return newInstance();
    }
}
