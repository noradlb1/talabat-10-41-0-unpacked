package com.talabat.feature.swimlanevoucherslist.data.datasource.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VouchersBaseUrl_Factory implements Factory<VouchersBaseUrl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final VouchersBaseUrl_Factory INSTANCE = new VouchersBaseUrl_Factory();

        private InstanceHolder() {
        }
    }

    public static VouchersBaseUrl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static VouchersBaseUrl newInstance() {
        return new VouchersBaseUrl();
    }

    public VouchersBaseUrl get() {
        return newInstance();
    }
}
