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
@QualifierMetadata({"com.talabat.core.safety.data.di.PackageName"})
public final class IdentifiersModule_PackageNameFactory implements Factory<String> {
    private final Provider<Context> contextProvider;

    public IdentifiersModule_PackageNameFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static IdentifiersModule_PackageNameFactory create(Provider<Context> provider) {
        return new IdentifiersModule_PackageNameFactory(provider);
    }

    public static String packageName(Context context) {
        return (String) Preconditions.checkNotNullFromProvides(IdentifiersModule.INSTANCE.packageName(context));
    }

    public String get() {
        return packageName(this.contextProvider.get());
    }
}
