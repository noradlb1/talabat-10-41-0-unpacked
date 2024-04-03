package com.talabat.feature.tmart.growth.data.tracking;

import android.content.Context;
import com.integration.IntegrationGlobalDataModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import tracking.gtm.ITalabatFirebase;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class TMartGrowthTracker_Factory implements Factory<TMartGrowthTracker> {
    private final Provider<Context> contextProvider;
    private final Provider<IntegrationGlobalDataModel.Companion> globalDataModelProvider;
    private final Provider<ITalabatFirebase> talabatFirebaseProvider;

    public TMartGrowthTracker_Factory(Provider<Context> provider, Provider<ITalabatFirebase> provider2, Provider<IntegrationGlobalDataModel.Companion> provider3) {
        this.contextProvider = provider;
        this.talabatFirebaseProvider = provider2;
        this.globalDataModelProvider = provider3;
    }

    public static TMartGrowthTracker_Factory create(Provider<Context> provider, Provider<ITalabatFirebase> provider2, Provider<IntegrationGlobalDataModel.Companion> provider3) {
        return new TMartGrowthTracker_Factory(provider, provider2, provider3);
    }

    public static TMartGrowthTracker newInstance(Context context, ITalabatFirebase iTalabatFirebase, IntegrationGlobalDataModel.Companion companion) {
        return new TMartGrowthTracker(context, iTalabatFirebase, companion);
    }

    public TMartGrowthTracker get() {
        return newInstance(this.contextProvider.get(), this.talabatFirebaseProvider.get(), this.globalDataModelProvider.get());
    }
}
