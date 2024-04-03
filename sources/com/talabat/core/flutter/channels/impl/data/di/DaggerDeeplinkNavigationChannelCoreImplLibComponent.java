package com.talabat.core.flutter.channels.impl.data.di;

import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationChannelCallback;
import com.talabat.core.flutter.channels.impl.data.di.DeeplinkNavigationChannelCoreImplLibComponent;
import com.talabat.core.flutter.channels.impl.data.navigation.DeeplinkNavigationChannelCallbackImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;

@DaggerGenerated
public final class DaggerDeeplinkNavigationChannelCoreImplLibComponent {

    public static final class DeeplinkNavigationChannelCoreImplLibComponentImpl implements DeeplinkNavigationChannelCoreImplLibComponent {
        private final DeepLinkCoreLibApi deepLinkCoreLibApi;
        private final DeeplinkNavigationChannelCoreImplLibComponentImpl deeplinkNavigationChannelCoreImplLibComponentImpl;

        private DeeplinkNavigationChannelCoreImplLibComponentImpl(DeepLinkCoreLibApi deepLinkCoreLibApi2) {
            this.deeplinkNavigationChannelCoreImplLibComponentImpl = this;
            this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
        }

        private DeeplinkNavigationChannelCallbackImpl deeplinkNavigationChannelCallbackImpl() {
            return new DeeplinkNavigationChannelCallbackImpl((DeepLinkNavigator) Preconditions.checkNotNullFromComponent(this.deepLinkCoreLibApi.getDeepLinkNavigator()));
        }

        public DeeplinkNavigationChannelCallback getDeeplinkNavigationChannelCallback() {
            return deeplinkNavigationChannelCallbackImpl();
        }
    }

    public static final class Factory implements DeeplinkNavigationChannelCoreImplLibComponent.Factory {
        private Factory() {
        }

        public DeeplinkNavigationChannelCoreImplLibComponent create(DeepLinkCoreLibApi deepLinkCoreLibApi) {
            Preconditions.checkNotNull(deepLinkCoreLibApi);
            return new DeeplinkNavigationChannelCoreImplLibComponentImpl(deepLinkCoreLibApi);
        }
    }

    private DaggerDeeplinkNavigationChannelCoreImplLibComponent() {
    }

    public static DeeplinkNavigationChannelCoreImplLibComponent.Factory factory() {
        return new Factory();
    }
}
