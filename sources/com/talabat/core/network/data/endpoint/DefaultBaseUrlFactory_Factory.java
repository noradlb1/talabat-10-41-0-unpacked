package com.talabat.core.network.data.endpoint;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultBaseUrlFactory_Factory implements Factory<DefaultBaseUrlFactory> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DefaultBaseUrlFactory_Factory INSTANCE = new DefaultBaseUrlFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static DefaultBaseUrlFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DefaultBaseUrlFactory newInstance() {
        return new DefaultBaseUrlFactory();
    }

    public DefaultBaseUrlFactory get() {
        return newInstance();
    }
}
