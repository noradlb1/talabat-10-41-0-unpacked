package com.talabat.core.flutter.channels.impl.data.sharedprefs;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SharedPreferencesChannelCallbackImpl_Factory implements Factory<SharedPreferencesChannelCallbackImpl> {
    private final Provider<Context> contextProvider;

    public SharedPreferencesChannelCallbackImpl_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static SharedPreferencesChannelCallbackImpl_Factory create(Provider<Context> provider) {
        return new SharedPreferencesChannelCallbackImpl_Factory(provider);
    }

    public static SharedPreferencesChannelCallbackImpl newInstance(Context context) {
        return new SharedPreferencesChannelCallbackImpl(context);
    }

    public SharedPreferencesChannelCallbackImpl get() {
        return newInstance(this.contextProvider.get());
    }
}
