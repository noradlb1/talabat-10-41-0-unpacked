package com.talabat.core.flutter.binding.data.gem;

import com.talabat.core.flutter.channels.domain.gem.GemChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GemFlutterEngineBinding_Factory implements Factory<GemFlutterEngineBinding> {
    private final Provider<GemChannelFlutterDomain> gemChannelFlutterDomainProvider;

    public GemFlutterEngineBinding_Factory(Provider<GemChannelFlutterDomain> provider) {
        this.gemChannelFlutterDomainProvider = provider;
    }

    public static GemFlutterEngineBinding_Factory create(Provider<GemChannelFlutterDomain> provider) {
        return new GemFlutterEngineBinding_Factory(provider);
    }

    public static GemFlutterEngineBinding newInstance(GemChannelFlutterDomain gemChannelFlutterDomain) {
        return new GemFlutterEngineBinding(gemChannelFlutterDomain);
    }

    public GemFlutterEngineBinding get() {
        return newInstance(this.gemChannelFlutterDomainProvider.get());
    }
}
