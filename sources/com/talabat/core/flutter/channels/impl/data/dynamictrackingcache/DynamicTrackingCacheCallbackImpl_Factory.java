package com.talabat.core.flutter.channels.impl.data.dynamictrackingcache;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DynamicTrackingCacheCallbackImpl_Factory implements Factory<DynamicTrackingCacheCallbackImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DynamicTrackingCacheCallbackImpl_Factory INSTANCE = new DynamicTrackingCacheCallbackImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static DynamicTrackingCacheCallbackImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DynamicTrackingCacheCallbackImpl newInstance() {
        return new DynamicTrackingCacheCallbackImpl();
    }

    public DynamicTrackingCacheCallbackImpl get() {
        return newInstance();
    }
}
