package com.talabat.feature.ulcampaign.data;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CampaignMigratorSharedPreferencesImpl_Factory implements Factory<CampaignMigratorSharedPreferencesImpl> {
    private final Provider<Context> contextProvider;

    public CampaignMigratorSharedPreferencesImpl_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static CampaignMigratorSharedPreferencesImpl_Factory create(Provider<Context> provider) {
        return new CampaignMigratorSharedPreferencesImpl_Factory(provider);
    }

    public static CampaignMigratorSharedPreferencesImpl newInstance(Context context) {
        return new CampaignMigratorSharedPreferencesImpl(context);
    }

    public CampaignMigratorSharedPreferencesImpl get() {
        return newInstance(this.contextProvider.get());
    }
}
