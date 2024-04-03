package com.talabat.core.flutter.channels.impl.data.search;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SearchChannelCallbackImpl_Factory implements Factory<SearchChannelCallbackImpl> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SearchChannelCallbackImpl_Factory INSTANCE = new SearchChannelCallbackImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static SearchChannelCallbackImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SearchChannelCallbackImpl newInstance() {
        return new SearchChannelCallbackImpl();
    }

    public SearchChannelCallbackImpl get() {
        return newInstance();
    }
}
