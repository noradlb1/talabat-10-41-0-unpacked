package com.talabat.feature.darkstores.domain.tracking;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ScreenTrackingProvider_Factory implements Factory<ScreenTrackingProvider> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ScreenTrackingProvider_Factory INSTANCE = new ScreenTrackingProvider_Factory();

        private InstanceHolder() {
        }
    }

    public static ScreenTrackingProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ScreenTrackingProvider newInstance() {
        return new ScreenTrackingProvider();
    }

    public ScreenTrackingProvider get() {
        return newInstance();
    }
}
