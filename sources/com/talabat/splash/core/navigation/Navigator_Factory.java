package com.talabat.splash.core.navigation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
public final class Navigator_Factory implements Factory<Navigator> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final Navigator_Factory INSTANCE = new Navigator_Factory();

        private InstanceHolder() {
        }
    }

    public static Navigator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Navigator newInstance() {
        return new Navigator();
    }

    public Navigator get() {
        return newInstance();
    }
}
