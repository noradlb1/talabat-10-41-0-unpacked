package com.talabat.core.advertisement.google.data;

import android.content.Context;
import com.talabat.core.advertisement.google.data.datasource.GoogleAidDataSource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class AdMobRepository_Factory implements Factory<AdMobRepository> {
    private final Provider<Context> contextProvider;
    private final Provider<GoogleAidDataSource> googleAidDataSourceProvider;

    public AdMobRepository_Factory(Provider<Context> provider, Provider<GoogleAidDataSource> provider2) {
        this.contextProvider = provider;
        this.googleAidDataSourceProvider = provider2;
    }

    public static AdMobRepository_Factory create(Provider<Context> provider, Provider<GoogleAidDataSource> provider2) {
        return new AdMobRepository_Factory(provider, provider2);
    }

    public static AdMobRepository newInstance(Context context, GoogleAidDataSource googleAidDataSource) {
        return new AdMobRepository(context, googleAidDataSource);
    }

    public AdMobRepository get() {
        return newInstance(this.contextProvider.get(), this.googleAidDataSourceProvider.get());
    }
}
