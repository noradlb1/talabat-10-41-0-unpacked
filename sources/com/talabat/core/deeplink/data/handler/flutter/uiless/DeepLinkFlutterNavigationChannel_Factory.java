package com.talabat.core.deeplink.data.handler.flutter.uiless;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DeepLinkFlutterNavigationChannel_Factory implements Factory<DeepLinkFlutterNavigationChannel> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DeepLinkFlutterNavigationChannel_Factory INSTANCE = new DeepLinkFlutterNavigationChannel_Factory();

        private InstanceHolder() {
        }
    }

    public static DeepLinkFlutterNavigationChannel_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DeepLinkFlutterNavigationChannel newInstance() {
        return new DeepLinkFlutterNavigationChannel();
    }

    public DeepLinkFlutterNavigationChannel get() {
        return newInstance();
    }
}
