package com.talabat.core.flutter.binding.data.legacydeeplink;

import com.talabat.core.flutter.channels.domain.legacydeeplink.LegacyDeeplinkNavigationFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LegacyDeeplinkNavigationFlutterEngineBinding_Factory implements Factory<LegacyDeeplinkNavigationFlutterEngineBinding> {
    private final Provider<LegacyDeeplinkNavigationFlutterDomain> legacyDeeplinkNavigationFlutterDomainProvider;

    public LegacyDeeplinkNavigationFlutterEngineBinding_Factory(Provider<LegacyDeeplinkNavigationFlutterDomain> provider) {
        this.legacyDeeplinkNavigationFlutterDomainProvider = provider;
    }

    public static LegacyDeeplinkNavigationFlutterEngineBinding_Factory create(Provider<LegacyDeeplinkNavigationFlutterDomain> provider) {
        return new LegacyDeeplinkNavigationFlutterEngineBinding_Factory(provider);
    }

    public static LegacyDeeplinkNavigationFlutterEngineBinding newInstance(LegacyDeeplinkNavigationFlutterDomain legacyDeeplinkNavigationFlutterDomain) {
        return new LegacyDeeplinkNavigationFlutterEngineBinding(legacyDeeplinkNavigationFlutterDomain);
    }

    public LegacyDeeplinkNavigationFlutterEngineBinding get() {
        return newInstance(this.legacyDeeplinkNavigationFlutterDomainProvider.get());
    }
}
