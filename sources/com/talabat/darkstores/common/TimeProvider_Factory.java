package com.talabat.darkstores.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TimeProvider_Factory implements Factory<TimeProvider> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TimeProvider_Factory INSTANCE = new TimeProvider_Factory();

        private InstanceHolder() {
        }
    }

    public static TimeProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static TimeProvider newInstance() {
        return new TimeProvider();
    }

    public TimeProvider get() {
        return newInstance();
    }
}
