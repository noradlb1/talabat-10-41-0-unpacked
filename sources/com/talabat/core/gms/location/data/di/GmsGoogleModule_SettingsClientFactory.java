package com.talabat.core.gms.location.data.di;

import android.content.Context;
import com.google.android.gms.location.SettingsClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsGoogleModule_SettingsClientFactory implements Factory<SettingsClient> {
    private final Provider<Context> contextProvider;

    public GmsGoogleModule_SettingsClientFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static GmsGoogleModule_SettingsClientFactory create(Provider<Context> provider) {
        return new GmsGoogleModule_SettingsClientFactory(provider);
    }

    public static SettingsClient settingsClient(Context context) {
        return (SettingsClient) Preconditions.checkNotNullFromProvides(GmsGoogleModule.INSTANCE.settingsClient(context));
    }

    public SettingsClient get() {
        return settingsClient(this.contextProvider.get());
    }
}
