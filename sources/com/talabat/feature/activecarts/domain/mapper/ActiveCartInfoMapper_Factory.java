package com.talabat.feature.activecarts.domain.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ActiveCartInfoMapper_Factory implements Factory<ActiveCartInfoMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ActiveCartInfoMapper_Factory INSTANCE = new ActiveCartInfoMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static ActiveCartInfoMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ActiveCartInfoMapper newInstance() {
        return new ActiveCartInfoMapper();
    }

    public ActiveCartInfoMapper get() {
        return newInstance();
    }
}
