package com.talabat.splash.domain.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AppInfoResponseMapper_Factory implements Factory<AppInfoResponseMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AppInfoResponseMapper_Factory INSTANCE = new AppInfoResponseMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static AppInfoResponseMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AppInfoResponseMapper newInstance() {
        return new AppInfoResponseMapper();
    }

    public AppInfoResponseMapper get() {
        return newInstance();
    }
}
