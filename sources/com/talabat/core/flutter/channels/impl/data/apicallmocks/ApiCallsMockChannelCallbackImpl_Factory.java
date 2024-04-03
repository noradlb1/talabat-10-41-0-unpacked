package com.talabat.core.flutter.channels.impl.data.apicallmocks;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ApiCallsMockChannelCallbackImpl_Factory implements Factory<ApiCallsMockChannelCallbackImpl> {
    private final Provider<Context> contextProvider;

    public ApiCallsMockChannelCallbackImpl_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static ApiCallsMockChannelCallbackImpl_Factory create(Provider<Context> provider) {
        return new ApiCallsMockChannelCallbackImpl_Factory(provider);
    }

    public static ApiCallsMockChannelCallbackImpl newInstance(Context context) {
        return new ApiCallsMockChannelCallbackImpl(context);
    }

    public ApiCallsMockChannelCallbackImpl get() {
        return newInstance(this.contextProvider.get());
    }
}
