package com.talabat.feature.fees.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FeesMapper_Factory implements Factory<FeesMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FeesMapper_Factory INSTANCE = new FeesMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static FeesMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FeesMapper newInstance() {
        return new FeesMapper();
    }

    public FeesMapper get() {
        return newInstance();
    }
}
