package com.talabat.core.hms.location.data;

import com.huawei.hms.location.SettingsClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HmsSettingsClientWrapper_Factory implements Factory<HmsSettingsClientWrapper> {
    private final Provider<SettingsClient> settingsClientProvider;

    public HmsSettingsClientWrapper_Factory(Provider<SettingsClient> provider) {
        this.settingsClientProvider = provider;
    }

    public static HmsSettingsClientWrapper_Factory create(Provider<SettingsClient> provider) {
        return new HmsSettingsClientWrapper_Factory(provider);
    }

    public static HmsSettingsClientWrapper newInstance(SettingsClient settingsClient) {
        return new HmsSettingsClientWrapper(settingsClient);
    }

    public HmsSettingsClientWrapper get() {
        return newInstance(this.settingsClientProvider.get());
    }
}
