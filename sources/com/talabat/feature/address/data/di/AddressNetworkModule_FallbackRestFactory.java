package com.talabat.feature.address.data.di;

import com.talabat.feature.address.data.remote.api.AddressApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.feature.address.data.di.FallbackApi"})
public final class AddressNetworkModule_FallbackRestFactory implements Factory<AddressApi> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final AddressNetworkModule_FallbackRestFactory INSTANCE = new AddressNetworkModule_FallbackRestFactory();

        private InstanceHolder() {
        }
    }

    public static AddressNetworkModule_FallbackRestFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AddressApi fallbackRest() {
        return (AddressApi) Preconditions.checkNotNullFromProvides(AddressNetworkModule.INSTANCE.fallbackRest());
    }

    public AddressApi get() {
        return fallbackRest();
    }
}
