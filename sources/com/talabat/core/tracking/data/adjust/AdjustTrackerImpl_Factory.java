package com.talabat.core.tracking.data.adjust;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AdjustTrackerImpl_Factory implements Factory<AdjustTrackerImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AdjustTrackerImpl_Factory INSTANCE = new AdjustTrackerImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static AdjustTrackerImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AdjustTrackerImpl newInstance() {
        return new AdjustTrackerImpl();
    }

    public AdjustTrackerImpl get() {
        return newInstance();
    }
}
