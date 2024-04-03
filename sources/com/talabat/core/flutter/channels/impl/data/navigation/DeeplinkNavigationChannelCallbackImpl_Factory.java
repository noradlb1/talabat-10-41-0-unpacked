package com.talabat.core.flutter.channels.impl.data.navigation;

import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DeeplinkNavigationChannelCallbackImpl_Factory implements Factory<DeeplinkNavigationChannelCallbackImpl> {
    private final Provider<DeepLinkNavigator> deepLinkNavigatorProvider;

    public DeeplinkNavigationChannelCallbackImpl_Factory(Provider<DeepLinkNavigator> provider) {
        this.deepLinkNavigatorProvider = provider;
    }

    public static DeeplinkNavigationChannelCallbackImpl_Factory create(Provider<DeepLinkNavigator> provider) {
        return new DeeplinkNavigationChannelCallbackImpl_Factory(provider);
    }

    public static DeeplinkNavigationChannelCallbackImpl newInstance(DeepLinkNavigator deepLinkNavigator) {
        return new DeeplinkNavigationChannelCallbackImpl(deepLinkNavigator);
    }

    public DeeplinkNavigationChannelCallbackImpl get() {
        return newInstance(this.deepLinkNavigatorProvider.get());
    }
}
