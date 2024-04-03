package com.talabat.core.safety.data.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.safety.data.di.AndroidId"})
public final class IdentifiersModule_AndroidIdFactory implements Factory<String> {
    private final Provider<Context> contextProvider;

    public IdentifiersModule_AndroidIdFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static String androidId(Context context) {
        return (String) Preconditions.checkNotNullFromProvides(IdentifiersModule.INSTANCE.androidId(context));
    }

    public static IdentifiersModule_AndroidIdFactory create(Provider<Context> provider) {
        return new IdentifiersModule_AndroidIdFactory(provider);
    }

    public String get() {
        return androidId(this.contextProvider.get());
    }
}
