package com.talabat.darkstores.data.deliveryfee;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FlutterDeliveryTierMapper_Factory implements Factory<FlutterDeliveryTierMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FlutterDeliveryTierMapper_Factory INSTANCE = new FlutterDeliveryTierMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static FlutterDeliveryTierMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FlutterDeliveryTierMapper newInstance() {
        return new FlutterDeliveryTierMapper();
    }

    public FlutterDeliveryTierMapper get() {
        return newInstance();
    }
}
