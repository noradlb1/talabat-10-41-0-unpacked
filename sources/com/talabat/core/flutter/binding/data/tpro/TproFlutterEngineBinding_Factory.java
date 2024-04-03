package com.talabat.core.flutter.binding.data.tpro;

import com.talabat.core.flutter.channels.domain.tpro.TproChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TproFlutterEngineBinding_Factory implements Factory<TproFlutterEngineBinding> {
    private final Provider<TproChannelFlutterDomain> tProChannelFlutterDomainProvider;

    public TproFlutterEngineBinding_Factory(Provider<TproChannelFlutterDomain> provider) {
        this.tProChannelFlutterDomainProvider = provider;
    }

    public static TproFlutterEngineBinding_Factory create(Provider<TproChannelFlutterDomain> provider) {
        return new TproFlutterEngineBinding_Factory(provider);
    }

    public static TproFlutterEngineBinding newInstance(TproChannelFlutterDomain tproChannelFlutterDomain) {
        return new TproFlutterEngineBinding(tproChannelFlutterDomain);
    }

    public TproFlutterEngineBinding get() {
        return newInstance(this.tProChannelFlutterDomainProvider.get());
    }
}
