package com.talabat.feature.address.data.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressDtoMapper_Factory implements Factory<AddressDtoMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AddressDtoMapper_Factory INSTANCE = new AddressDtoMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static AddressDtoMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AddressDtoMapper newInstance() {
        return new AddressDtoMapper();
    }

    public AddressDtoMapper get() {
        return newInstance();
    }
}
