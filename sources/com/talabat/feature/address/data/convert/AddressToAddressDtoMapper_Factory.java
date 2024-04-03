package com.talabat.feature.address.data.convert;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressToAddressDtoMapper_Factory implements Factory<AddressToAddressDtoMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AddressToAddressDtoMapper_Factory INSTANCE = new AddressToAddressDtoMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static AddressToAddressDtoMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AddressToAddressDtoMapper newInstance() {
        return new AddressToAddressDtoMapper();
    }

    public AddressToAddressDtoMapper get() {
        return newInstance();
    }
}
