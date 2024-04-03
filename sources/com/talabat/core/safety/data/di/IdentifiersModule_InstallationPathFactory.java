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
@QualifierMetadata({"com.talabat.core.safety.data.di.InstallationPath"})
public final class IdentifiersModule_InstallationPathFactory implements Factory<String> {
    private final Provider<Context> contextProvider;

    public IdentifiersModule_InstallationPathFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static IdentifiersModule_InstallationPathFactory create(Provider<Context> provider) {
        return new IdentifiersModule_InstallationPathFactory(provider);
    }

    public static String installationPath(Context context) {
        return (String) Preconditions.checkNotNullFromProvides(IdentifiersModule.INSTANCE.installationPath(context));
    }

    public String get() {
        return installationPath(this.contextProvider.get());
    }
}
