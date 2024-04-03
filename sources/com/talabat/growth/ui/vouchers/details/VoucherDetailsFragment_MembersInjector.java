package com.talabat.growth.ui.vouchers.details;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class VoucherDetailsFragment_MembersInjector implements MembersInjector<VoucherDetailsFragment> {
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public VoucherDetailsFragment_MembersInjector(Provider<IObservabilityManager> provider) {
        this.observabilityManagerProvider = provider;
    }

    public static MembersInjector<VoucherDetailsFragment> create(Provider<IObservabilityManager> provider) {
        return new VoucherDetailsFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.details.VoucherDetailsFragment.observabilityManager")
    public static void injectObservabilityManager(VoucherDetailsFragment voucherDetailsFragment, IObservabilityManager iObservabilityManager) {
        voucherDetailsFragment.observabilityManager = iObservabilityManager;
    }

    public void injectMembers(VoucherDetailsFragment voucherDetailsFragment) {
        injectObservabilityManager(voucherDetailsFragment, this.observabilityManagerProvider.get());
    }
}
