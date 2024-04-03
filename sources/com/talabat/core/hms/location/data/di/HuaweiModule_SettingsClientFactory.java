package com.talabat.core.hms.location.data.di;

import android.content.Context;
import com.huawei.hms.location.SettingsClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class HuaweiModule_SettingsClientFactory implements Factory<SettingsClient> {
    private final Provider<Context> contextProvider;

    public HuaweiModule_SettingsClientFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static HuaweiModule_SettingsClientFactory create(Provider<Context> provider) {
        return new HuaweiModule_SettingsClientFactory(provider);
    }

    public static SettingsClient settingsClient(Context context) {
        return (SettingsClient) Preconditions.checkNotNullFromProvides(HuaweiModule.INSTANCE.settingsClient(context));
    }

    public SettingsClient get() {
        return settingsClient(this.contextProvider.get());
    }
}
