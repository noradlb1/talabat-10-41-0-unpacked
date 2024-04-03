package com.talabat.feature.ridertips.data.convert;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RiderTipResponseToRiderTipMapper_Factory implements Factory<RiderTipResponseToRiderTipMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RiderTipResponseToRiderTipMapper_Factory INSTANCE = new RiderTipResponseToRiderTipMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static RiderTipResponseToRiderTipMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RiderTipResponseToRiderTipMapper newInstance() {
        return new RiderTipResponseToRiderTipMapper();
    }

    public RiderTipResponseToRiderTipMapper get() {
        return newInstance();
    }
}
