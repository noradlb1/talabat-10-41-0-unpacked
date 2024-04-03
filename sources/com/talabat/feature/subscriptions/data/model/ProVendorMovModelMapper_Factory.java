package com.talabat.feature.subscriptions.data.model;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ProVendorMovModelMapper_Factory implements Factory<ProVendorMovModelMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ProVendorMovModelMapper_Factory INSTANCE = new ProVendorMovModelMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static ProVendorMovModelMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ProVendorMovModelMapper newInstance() {
        return new ProVendorMovModelMapper();
    }

    public ProVendorMovModelMapper get() {
        return newInstance();
    }
}
