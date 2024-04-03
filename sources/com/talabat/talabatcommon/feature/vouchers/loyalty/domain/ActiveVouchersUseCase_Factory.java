package com.talabat.talabatcommon.feature.vouchers.loyalty.domain;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class ActiveVouchersUseCase_Factory implements Factory<ActiveVouchersUseCase> {
    private final Provider<IObservabilityManager> observabilityManagerProvider;
    private final Provider<VoucherRepository> voucherRepositoryProvider;

    public ActiveVouchersUseCase_Factory(Provider<VoucherRepository> provider, Provider<IObservabilityManager> provider2) {
        this.voucherRepositoryProvider = provider;
        this.observabilityManagerProvider = provider2;
    }

    public static ActiveVouchersUseCase_Factory create(Provider<VoucherRepository> provider, Provider<IObservabilityManager> provider2) {
        return new ActiveVouchersUseCase_Factory(provider, provider2);
    }

    public static ActiveVouchersUseCase newInstance(VoucherRepository voucherRepository, IObservabilityManager iObservabilityManager) {
        return new ActiveVouchersUseCase(voucherRepository, iObservabilityManager);
    }

    public ActiveVouchersUseCase get() {
        return newInstance(this.voucherRepositoryProvider.get(), this.observabilityManagerProvider.get());
    }
}
