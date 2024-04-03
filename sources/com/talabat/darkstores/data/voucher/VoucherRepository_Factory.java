package com.talabat.darkstores.data.voucher;

import com.integration.IntegrationGlobalDataModel;
import com.talabat.darkstores.data.ConfigurationParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.reactivex.Scheduler;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.talabat.darkstores.di.qualifier.IoScheduler"})
public final class VoucherRepository_Factory implements Factory<VoucherRepository> {
    private final Provider<ConfigurationParameters> configurationParametersProvider;
    private final Provider<IntegrationGlobalDataModel.Companion> globalDataModelProvider;
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<VoucherApi> voucherApiProvider;

    public VoucherRepository_Factory(Provider<ConfigurationParameters> provider, Provider<IntegrationGlobalDataModel.Companion> provider2, Provider<VoucherApi> provider3, Provider<Scheduler> provider4) {
        this.configurationParametersProvider = provider;
        this.globalDataModelProvider = provider2;
        this.voucherApiProvider = provider3;
        this.ioSchedulerProvider = provider4;
    }

    public static VoucherRepository_Factory create(Provider<ConfigurationParameters> provider, Provider<IntegrationGlobalDataModel.Companion> provider2, Provider<VoucherApi> provider3, Provider<Scheduler> provider4) {
        return new VoucherRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static VoucherRepository newInstance(ConfigurationParameters configurationParameters, IntegrationGlobalDataModel.Companion companion, VoucherApi voucherApi, Scheduler scheduler) {
        return new VoucherRepository(configurationParameters, companion, voucherApi, scheduler);
    }

    public VoucherRepository get() {
        return newInstance(this.configurationParametersProvider.get(), this.globalDataModelProvider.get(), this.voucherApiProvider.get(), this.ioSchedulerProvider.get());
    }
}
