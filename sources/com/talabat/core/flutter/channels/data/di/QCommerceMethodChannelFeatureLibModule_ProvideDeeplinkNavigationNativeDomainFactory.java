package com.talabat.core.flutter.channels.data.di;

import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelCallback;
import com.talabat.core.flutter.channels.domain.qcommerce.QCommerceChannelFlutterDomain;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class QCommerceMethodChannelFeatureLibModule_ProvideDeeplinkNavigationNativeDomainFactory implements Factory<QCommerceChannelFlutterDomain> {
    private final Provider<QCommerceChannelCallback> qCommerceChannelCallbackProvider;

    public QCommerceMethodChannelFeatureLibModule_ProvideDeeplinkNavigationNativeDomainFactory(Provider<QCommerceChannelCallback> provider) {
        this.qCommerceChannelCallbackProvider = provider;
    }

    public static QCommerceMethodChannelFeatureLibModule_ProvideDeeplinkNavigationNativeDomainFactory create(Provider<QCommerceChannelCallback> provider) {
        return new QCommerceMethodChannelFeatureLibModule_ProvideDeeplinkNavigationNativeDomainFactory(provider);
    }

    public static QCommerceChannelFlutterDomain provideDeeplinkNavigationNativeDomain(QCommerceChannelCallback qCommerceChannelCallback) {
        return (QCommerceChannelFlutterDomain) Preconditions.checkNotNullFromProvides(QCommerceMethodChannelFeatureLibModule.INSTANCE.provideDeeplinkNavigationNativeDomain(qCommerceChannelCallback));
    }

    public QCommerceChannelFlutterDomain get() {
        return provideDeeplinkNavigationNativeDomain(this.qCommerceChannelCallbackProvider.get());
    }
}
