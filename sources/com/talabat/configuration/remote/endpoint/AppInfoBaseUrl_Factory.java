package com.talabat.configuration.remote.endpoint;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AppInfoBaseUrl_Factory implements Factory<AppInfoBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AppInfoBaseUrl_Factory INSTANCE = new AppInfoBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static AppInfoBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AppInfoBaseUrl newInstance() {
        return new AppInfoBaseUrl();
    }

    public AppInfoBaseUrl get() {
        return newInstance();
    }
}
