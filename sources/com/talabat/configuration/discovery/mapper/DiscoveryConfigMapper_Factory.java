package com.talabat.configuration.discovery.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DiscoveryConfigMapper_Factory implements Factory<DiscoveryConfigMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DiscoveryConfigMapper_Factory INSTANCE = new DiscoveryConfigMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DiscoveryConfigMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DiscoveryConfigMapper newInstance() {
        return new DiscoveryConfigMapper();
    }

    public DiscoveryConfigMapper get() {
        return newInstance();
    }
}
