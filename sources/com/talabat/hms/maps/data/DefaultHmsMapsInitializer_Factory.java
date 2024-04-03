package com.talabat.hms.maps.data;

import android.content.Context;
import com.talabat.secrets.Secrets;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DefaultHmsMapsInitializer_Factory implements Factory<DefaultHmsMapsInitializer> {
    private final Provider<Context> contextProvider;
    private final Provider<Secrets> secretsProvider;

    public DefaultHmsMapsInitializer_Factory(Provider<Context> provider, Provider<Secrets> provider2) {
        this.contextProvider = provider;
        this.secretsProvider = provider2;
    }

    public static DefaultHmsMapsInitializer_Factory create(Provider<Context> provider, Provider<Secrets> provider2) {
        return new DefaultHmsMapsInitializer_Factory(provider, provider2);
    }

    public static DefaultHmsMapsInitializer newInstance(Context context, Secrets secrets) {
        return new DefaultHmsMapsInitializer(context, secrets);
    }

    public DefaultHmsMapsInitializer get() {
        return newInstance(this.contextProvider.get(), this.secretsProvider.get());
    }
}
