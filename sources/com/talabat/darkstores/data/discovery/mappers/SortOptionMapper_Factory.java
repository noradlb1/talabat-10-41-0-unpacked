package com.talabat.darkstores.data.discovery.mappers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SortOptionMapper_Factory implements Factory<SortOptionMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SortOptionMapper_Factory INSTANCE = new SortOptionMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static SortOptionMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SortOptionMapper newInstance() {
        return new SortOptionMapper();
    }

    public SortOptionMapper get() {
        return newInstance();
    }
}
