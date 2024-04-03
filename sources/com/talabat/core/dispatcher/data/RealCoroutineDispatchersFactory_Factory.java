package com.talabat.core.dispatcher.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RealCoroutineDispatchersFactory_Factory implements Factory<RealCoroutineDispatchersFactory> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RealCoroutineDispatchersFactory_Factory INSTANCE = new RealCoroutineDispatchersFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static RealCoroutineDispatchersFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RealCoroutineDispatchersFactory newInstance() {
        return new RealCoroutineDispatchersFactory();
    }

    public RealCoroutineDispatchersFactory get() {
        return newInstance();
    }
}
