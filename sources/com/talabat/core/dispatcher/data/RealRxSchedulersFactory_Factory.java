package com.talabat.core.dispatcher.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RealRxSchedulersFactory_Factory implements Factory<RealRxSchedulersFactory> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RealRxSchedulersFactory_Factory INSTANCE = new RealRxSchedulersFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static RealRxSchedulersFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RealRxSchedulersFactory newInstance() {
        return new RealRxSchedulersFactory();
    }

    public RealRxSchedulersFactory get() {
        return newInstance();
    }
}
