package com.talabat.wallet.walletbalance.di.module;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.network.endpoint.WalletEndPointProvider;
import com.talabat.core.network.network.OKHttpBuilder;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.wallet.walletbalance.data.impl.WalletBalanceRepositoryImpl;
import com.talabat.wallet.walletbalance.data.local.impl.WalletBalanceLocalSourceImpl;
import com.talabat.wallet.walletbalance.data.remote.api.WalletBalanceApi;
import com.talabat.wallet.walletbalance.data.remote.impl.WalletBalanceRemoteSourceImpl;
import com.talabat.wallet.walletbalance.domain.repository.WalletBalanceRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/walletbalance/di/module/WalletBalanceDomainModule;", "", "()V", "provideWalletBalanceRepository", "Lcom/talabat/wallet/walletbalance/domain/repository/WalletBalanceRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBalanceDomainModule {
    @NotNull
    public static final WalletBalanceDomainModule INSTANCE = new WalletBalanceDomainModule();

    private WalletBalanceDomainModule() {
    }

    @NotNull
    public final WalletBalanceRepository provideWalletBalanceRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        return new WalletBalanceRepositoryImpl(new WalletBalanceRemoteSourceImpl((WalletBalanceApi) new TalabatAPIBuilder().createApi(WalletEndPointProvider.INSTANCE.getBaseUrl(), WalletBalanceApi.class, OKHttpBuilder.getDefaultHttpClient$default(OKHttpBuilder.INSTANCE, (List) null, 10, 1, (Object) null)), configurationLocalRepository), new WalletBalanceLocalSourceImpl());
    }
}
