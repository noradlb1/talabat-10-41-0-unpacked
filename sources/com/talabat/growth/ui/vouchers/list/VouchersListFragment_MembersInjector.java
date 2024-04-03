package com.talabat.growth.ui.vouchers.list;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class VouchersListFragment_MembersInjector implements MembersInjector<VouchersListFragment> {
    private final Provider<ConfigurationLocalRepository> configurationLocalRepositoryProvider;
    private final Provider<IObservabilityManager> observabilityManagerProvider;

    public VouchersListFragment_MembersInjector(Provider<ConfigurationLocalRepository> provider, Provider<IObservabilityManager> provider2) {
        this.configurationLocalRepositoryProvider = provider;
        this.observabilityManagerProvider = provider2;
    }

    public static MembersInjector<VouchersListFragment> create(Provider<ConfigurationLocalRepository> provider, Provider<IObservabilityManager> provider2) {
        return new VouchersListFragment_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.list.VouchersListFragment.configurationLocalRepository")
    public static void injectConfigurationLocalRepository(VouchersListFragment vouchersListFragment, ConfigurationLocalRepository configurationLocalRepository) {
        vouchersListFragment.configurationLocalRepository = configurationLocalRepository;
    }

    @InjectedFieldSignature("com.talabat.growth.ui.vouchers.list.VouchersListFragment.observabilityManager")
    public static void injectObservabilityManager(VouchersListFragment vouchersListFragment, IObservabilityManager iObservabilityManager) {
        vouchersListFragment.observabilityManager = iObservabilityManager;
    }

    public void injectMembers(VouchersListFragment vouchersListFragment) {
        injectConfigurationLocalRepository(vouchersListFragment, this.configurationLocalRepositoryProvider.get());
        injectObservabilityManager(vouchersListFragment, this.observabilityManagerProvider.get());
    }
}
