package com.talabat.core.flutter.channels.impl.data.vendorlist;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class InlineAdsChannelCallbackImpl_Factory implements Factory<InlineAdsChannelCallbackImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final InlineAdsChannelCallbackImpl_Factory INSTANCE = new InlineAdsChannelCallbackImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static InlineAdsChannelCallbackImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static InlineAdsChannelCallbackImpl newInstance() {
        return new InlineAdsChannelCallbackImpl();
    }

    public InlineAdsChannelCallbackImpl get() {
        return newInstance();
    }
}
