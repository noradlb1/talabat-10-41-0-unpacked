package com.talabat.core.flutter.channels.impl.data.legacydeeplink;

import com.talabat.core.navigation.domain.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LegacyDeeplinkNavigationChannelCallbackImpl_Factory implements Factory<LegacyDeeplinkNavigationChannelCallbackImpl> {
    private final Provider<Navigator> navigatorProvider;

    public LegacyDeeplinkNavigationChannelCallbackImpl_Factory(Provider<Navigator> provider) {
        this.navigatorProvider = provider;
    }

    public static LegacyDeeplinkNavigationChannelCallbackImpl_Factory create(Provider<Navigator> provider) {
        return new LegacyDeeplinkNavigationChannelCallbackImpl_Factory(provider);
    }

    public static LegacyDeeplinkNavigationChannelCallbackImpl newInstance(Navigator navigator) {
        return new LegacyDeeplinkNavigationChannelCallbackImpl(navigator);
    }

    public LegacyDeeplinkNavigationChannelCallbackImpl get() {
        return newInstance(this.navigatorProvider.get());
    }
}
