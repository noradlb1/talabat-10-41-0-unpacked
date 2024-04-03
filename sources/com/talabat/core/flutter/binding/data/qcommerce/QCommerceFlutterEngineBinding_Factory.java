package com.talabat.core.flutter.binding.data.qcommerce;

import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class QCommerceFlutterEngineBinding_Factory implements Factory<QCommerceFlutterEngineBinding> {
    private final Provider<QCommerceChannelFlutterDomain> qCommerceChannelFlutterDomainProvider;

    public QCommerceFlutterEngineBinding_Factory(Provider<QCommerceChannelFlutterDomain> provider) {
        this.qCommerceChannelFlutterDomainProvider = provider;
    }

    public static QCommerceFlutterEngineBinding_Factory create(Provider<QCommerceChannelFlutterDomain> provider) {
        return new QCommerceFlutterEngineBinding_Factory(provider);
    }

    public static QCommerceFlutterEngineBinding newInstance(QCommerceChannelFlutterDomain qCommerceChannelFlutterDomain) {
        return new QCommerceFlutterEngineBinding(qCommerceChannelFlutterDomain);
    }

    public QCommerceFlutterEngineBinding get() {
        return newInstance(this.qCommerceChannelFlutterDomainProvider.get());
    }
}
