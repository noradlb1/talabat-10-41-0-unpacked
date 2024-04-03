package com.talabat.feature.tokenization.data.provider;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class CheckoutApiClientProvider_Factory implements Factory<CheckoutApiClientProvider> {
    private final Provider<Context> contextProvider;

    public CheckoutApiClientProvider_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static CheckoutApiClientProvider_Factory create(Provider<Context> provider) {
        return new CheckoutApiClientProvider_Factory(provider);
    }

    public static CheckoutApiClientProvider newInstance(Context context) {
        return new CheckoutApiClientProvider(context);
    }

    public CheckoutApiClientProvider get() {
        return newInstance(this.contextProvider.get());
    }
}
