package com.talabat.core.flutter.channels.impl.data.vendor;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class VendorChannelCallbackImpl_Factory implements Factory<VendorChannelCallbackImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final VendorChannelCallbackImpl_Factory INSTANCE = new VendorChannelCallbackImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static VendorChannelCallbackImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static VendorChannelCallbackImpl newInstance() {
        return new VendorChannelCallbackImpl();
    }

    public VendorChannelCallbackImpl get() {
        return newInstance();
    }
}
