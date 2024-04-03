package com.talabat.feature.swimlanevoucherslist.data.datasource.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CustomerVoucherMapper_Factory implements Factory<CustomerVoucherMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CustomerVoucherMapper_Factory INSTANCE = new CustomerVoucherMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static CustomerVoucherMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CustomerVoucherMapper newInstance() {
        return new CustomerVoucherMapper();
    }

    public CustomerVoucherMapper get() {
        return newInstance();
    }
}
