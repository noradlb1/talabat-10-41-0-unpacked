package com.talabat.observabilityNew.tracker.impl;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class NewRelicObservabilityTracker_Factory implements Factory<NewRelicObservabilityTracker> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final NewRelicObservabilityTracker_Factory INSTANCE = new NewRelicObservabilityTracker_Factory();

        private InstanceHolder() {
        }
    }

    public static NewRelicObservabilityTracker_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NewRelicObservabilityTracker newInstance() {
        return new NewRelicObservabilityTracker();
    }

    public NewRelicObservabilityTracker get() {
        return newInstance();
    }
}
