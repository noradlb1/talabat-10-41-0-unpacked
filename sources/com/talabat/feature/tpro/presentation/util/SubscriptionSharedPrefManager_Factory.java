package com.talabat.feature.tpro.presentation.util;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SubscriptionSharedPrefManager_Factory implements Factory<SubscriptionSharedPrefManager> {
    private final Provider<Context> contextProvider;

    public SubscriptionSharedPrefManager_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static SubscriptionSharedPrefManager_Factory create(Provider<Context> provider) {
        return new SubscriptionSharedPrefManager_Factory(provider);
    }

    public static SubscriptionSharedPrefManager newInstance(Context context) {
        return new SubscriptionSharedPrefManager(context);
    }

    public SubscriptionSharedPrefManager get() {
        return newInstance(this.contextProvider.get());
    }
}
