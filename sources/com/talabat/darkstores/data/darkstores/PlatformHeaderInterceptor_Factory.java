package com.talabat.darkstores.data.darkstores;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PlatformHeaderInterceptor_Factory implements Factory<PlatformHeaderInterceptor> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PlatformHeaderInterceptor_Factory INSTANCE = new PlatformHeaderInterceptor_Factory();

        private InstanceHolder() {
        }
    }

    public static PlatformHeaderInterceptor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PlatformHeaderInterceptor newInstance() {
        return new PlatformHeaderInterceptor();
    }

    public PlatformHeaderInterceptor get() {
        return newInstance();
    }
}
