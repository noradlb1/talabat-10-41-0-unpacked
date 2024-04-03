package com.talabat.feature.address.data.convert;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressDtoToAddressMapper_Factory implements Factory<AddressDtoToAddressMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AddressDtoToAddressMapper_Factory INSTANCE = new AddressDtoToAddressMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static AddressDtoToAddressMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AddressDtoToAddressMapper newInstance() {
        return new AddressDtoToAddressMapper();
    }

    public AddressDtoToAddressMapper get() {
        return newInstance();
    }
}
