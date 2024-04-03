package com.talabat.core.flutter.channels.impl.data.menu;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class MenuChannelCallbackImpl_Factory implements Factory<MenuChannelCallbackImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final MenuChannelCallbackImpl_Factory INSTANCE = new MenuChannelCallbackImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static MenuChannelCallbackImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MenuChannelCallbackImpl newInstance() {
        return new MenuChannelCallbackImpl();
    }

    public MenuChannelCallbackImpl get() {
        return newInstance();
    }
}
