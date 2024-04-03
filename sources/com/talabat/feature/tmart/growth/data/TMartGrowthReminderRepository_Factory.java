package com.talabat.feature.tmart.growth.data;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.feature.tmart.growth.data.remote.TMartGrowthApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"javax.inject.Named"})
public final class TMartGrowthReminderRepository_Factory implements Factory<TMartGrowthReminderRepository> {
    private final Provider<String> countryCodeProvider;
    private final Provider<IntegrationGlobalDataModel.Companion> globalDataModelProvider;
    private final Provider<TMartGrowthApi> tMartGrowthApiProvider;

    public TMartGrowthReminderRepository_Factory(Provider<String> provider, Provider<IntegrationGlobalDataModel.Companion> provider2, Provider<TMartGrowthApi> provider3) {
        this.countryCodeProvider = provider;
        this.globalDataModelProvider = provider2;
        this.tMartGrowthApiProvider = provider3;
    }

    public static TMartGrowthReminderRepository_Factory create(Provider<String> provider, Provider<IntegrationGlobalDataModel.Companion> provider2, Provider<TMartGrowthApi> provider3) {
        return new TMartGrowthReminderRepository_Factory(provider, provider2, provider3);
    }

    public static TMartGrowthReminderRepository newInstance(String str, IntegrationGlobalDataModel.Companion companion, TMartGrowthApi tMartGrowthApi) {
        return new TMartGrowthReminderRepository(str, companion, tMartGrowthApi);
    }

    public TMartGrowthReminderRepository get() {
        return newInstance(this.countryCodeProvider.get(), this.globalDataModelProvider.get(), this.tMartGrowthApiProvider.get());
    }
}
