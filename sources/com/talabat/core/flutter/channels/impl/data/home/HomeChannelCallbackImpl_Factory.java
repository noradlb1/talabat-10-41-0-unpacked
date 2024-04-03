package com.talabat.core.flutter.channels.impl.data.home;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HomeChannelCallbackImpl_Factory implements Factory<HomeChannelCallbackImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final HomeChannelCallbackImpl_Factory INSTANCE = new HomeChannelCallbackImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static HomeChannelCallbackImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static HomeChannelCallbackImpl newInstance() {
        return new HomeChannelCallbackImpl();
    }

    public HomeChannelCallbackImpl get() {
        return newInstance();
    }
}
