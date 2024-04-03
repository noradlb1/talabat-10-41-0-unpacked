package com.talabat.feature.address.data.di;

import com.talabat.feature.address.data.remote.api.AddressApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressNetworkModule_RestFactory implements Factory<AddressApi> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AddressNetworkModule_RestFactory INSTANCE = new AddressNetworkModule_RestFactory();

        private InstanceHolder() {
        }
    }

    public static AddressNetworkModule_RestFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AddressApi rest() {
        return (AddressApi) Preconditions.checkNotNullFromProvides(AddressNetworkModule.INSTANCE.rest());
    }

    public AddressApi get() {
        return rest();
    }
}
