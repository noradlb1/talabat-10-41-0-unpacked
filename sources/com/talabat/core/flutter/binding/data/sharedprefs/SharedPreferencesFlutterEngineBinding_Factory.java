package com.talabat.core.flutter.binding.data.sharedprefs;

import com.talabat.core.flutter.channels.domain.sharedprefs.SharedPreferencesChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SharedPreferencesFlutterEngineBinding_Factory implements Factory<SharedPreferencesFlutterEngineBinding> {
    private final Provider<SharedPreferencesChannelFlutterDomain> sharedPreferencesChannelFlutterDomainProvider;

    public SharedPreferencesFlutterEngineBinding_Factory(Provider<SharedPreferencesChannelFlutterDomain> provider) {
        this.sharedPreferencesChannelFlutterDomainProvider = provider;
    }

    public static SharedPreferencesFlutterEngineBinding_Factory create(Provider<SharedPreferencesChannelFlutterDomain> provider) {
        return new SharedPreferencesFlutterEngineBinding_Factory(provider);
    }

    public static SharedPreferencesFlutterEngineBinding newInstance(SharedPreferencesChannelFlutterDomain sharedPreferencesChannelFlutterDomain) {
        return new SharedPreferencesFlutterEngineBinding(sharedPreferencesChannelFlutterDomain);
    }

    public SharedPreferencesFlutterEngineBinding get() {
        return newInstance(this.sharedPreferencesChannelFlutterDomainProvider.get());
    }
}
