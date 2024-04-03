package com.talabat.core.flutter.channels.impl.data.useraccount;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class UserAccountChannelCallbackImpl_Factory implements Factory<UserAccountChannelCallbackImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final UserAccountChannelCallbackImpl_Factory INSTANCE = new UserAccountChannelCallbackImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static UserAccountChannelCallbackImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static UserAccountChannelCallbackImpl newInstance() {
        return new UserAccountChannelCallbackImpl();
    }

    public UserAccountChannelCallbackImpl get() {
        return newInstance();
    }
}
