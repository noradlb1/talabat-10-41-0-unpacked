package com.talabat.feature.darkstoresscheduleddelivery.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DeliverySlotResponseMapper_Factory implements Factory<DeliverySlotResponseMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DeliverySlotResponseMapper_Factory INSTANCE = new DeliverySlotResponseMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static DeliverySlotResponseMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DeliverySlotResponseMapper newInstance() {
        return new DeliverySlotResponseMapper();
    }

    public DeliverySlotResponseMapper get() {
        return newInstance();
    }
}
