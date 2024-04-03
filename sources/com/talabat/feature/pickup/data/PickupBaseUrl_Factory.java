package com.talabat.feature.pickup.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PickupBaseUrl_Factory implements Factory<PickupBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PickupBaseUrl_Factory INSTANCE = new PickupBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static PickupBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PickupBaseUrl newInstance() {
        return new PickupBaseUrl();
    }

    public PickupBaseUrl get() {
        return newInstance();
    }
}
