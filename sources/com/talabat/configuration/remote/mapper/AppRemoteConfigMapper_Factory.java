package com.talabat.configuration.remote.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AppRemoteConfigMapper_Factory implements Factory<AppRemoteConfigMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AppRemoteConfigMapper_Factory INSTANCE = new AppRemoteConfigMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static AppRemoteConfigMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AppRemoteConfigMapper newInstance() {
        return new AppRemoteConfigMapper();
    }

    public AppRemoteConfigMapper get() {
        return newInstance();
    }
}
