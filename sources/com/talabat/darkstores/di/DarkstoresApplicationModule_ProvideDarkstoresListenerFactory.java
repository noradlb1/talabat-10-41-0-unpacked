package com.talabat.darkstores.di;

import com.google.gson.Gson;
import com.talabat.darkstores.feature.checkout.DarkstoresListener;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class DarkstoresApplicationModule_ProvideDarkstoresListenerFactory implements Factory<DarkstoresListener> {
    private final Provider<Gson> gsonProvider;

    public DarkstoresApplicationModule_ProvideDarkstoresListenerFactory(Provider<Gson> provider) {
        this.gsonProvider = provider;
    }

    public static DarkstoresApplicationModule_ProvideDarkstoresListenerFactory create(Provider<Gson> provider) {
        return new DarkstoresApplicationModule_ProvideDarkstoresListenerFactory(provider);
    }

    public static DarkstoresListener provideDarkstoresListener(Gson gson) {
        return (DarkstoresListener) Preconditions.checkNotNullFromProvides(DarkstoresApplicationModule.INSTANCE.provideDarkstoresListener(gson));
    }

    public DarkstoresListener get() {
        return provideDarkstoresListener(this.gsonProvider.get());
    }
}
