package com.talabat.core.facebook.login.data.datasource;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GraphRequestFactory_Factory implements Factory<GraphRequestFactory> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final GraphRequestFactory_Factory INSTANCE = new GraphRequestFactory_Factory();

        private InstanceHolder() {
        }
    }

    public static GraphRequestFactory_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static GraphRequestFactory newInstance() {
        return new GraphRequestFactory();
    }

    public GraphRequestFactory get() {
        return newInstance();
    }
}
