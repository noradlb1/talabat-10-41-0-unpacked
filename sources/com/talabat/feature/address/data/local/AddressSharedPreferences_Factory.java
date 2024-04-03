package com.talabat.feature.address.data.local;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AddressSharedPreferences_Factory implements Factory<AddressSharedPreferences> {
    private final Provider<Context> contextProvider;

    public AddressSharedPreferences_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static AddressSharedPreferences_Factory create(Provider<Context> provider) {
        return new AddressSharedPreferences_Factory(provider);
    }

    public static AddressSharedPreferences newInstance(Context context) {
        return new AddressSharedPreferences(context);
    }

    public AddressSharedPreferences get() {
        return newInstance(this.contextProvider.get());
    }
}
