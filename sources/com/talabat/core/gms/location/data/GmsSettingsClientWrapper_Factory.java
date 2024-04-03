package com.talabat.core.gms.location.data;

import com.google.android.gms.location.SettingsClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GmsSettingsClientWrapper_Factory implements Factory<GmsSettingsClientWrapper> {
    private final Provider<SettingsClient> settingsClientProvider;

    public GmsSettingsClientWrapper_Factory(Provider<SettingsClient> provider) {
        this.settingsClientProvider = provider;
    }

    public static GmsSettingsClientWrapper_Factory create(Provider<SettingsClient> provider) {
        return new GmsSettingsClientWrapper_Factory(provider);
    }

    public static GmsSettingsClientWrapper newInstance(SettingsClient settingsClient) {
        return new GmsSettingsClientWrapper(settingsClient);
    }

    public GmsSettingsClientWrapper get() {
        return newInstance(this.settingsClientProvider.get());
    }
}
