package com.talabat.configuration.location.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AreaMapper_Factory implements Factory<AreaMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AreaMapper_Factory INSTANCE = new AreaMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static AreaMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AreaMapper newInstance() {
        return new AreaMapper();
    }

    public AreaMapper get() {
        return newInstance();
    }
}
