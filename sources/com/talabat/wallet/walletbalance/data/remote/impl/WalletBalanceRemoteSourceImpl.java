package com.talabat.wallet.walletbalance.data.remote.impl;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.talabatcommon.feature.walletBalance.model.response.WalletCreditBalanceResponse;
import com.talabat.wallet.walletbalance.data.remote.WalletBalanceRemoteSource;
import com.talabat.wallet.walletbalance.data.remote.api.WalletBalanceApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/walletbalance/data/remote/impl/WalletBalanceRemoteSourceImpl;", "Lcom/talabat/wallet/walletbalance/data/remote/WalletBalanceRemoteSource;", "walletBalanceApi", "Lcom/talabat/wallet/walletbalance/data/remote/api/WalletBalanceApi;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/wallet/walletbalance/data/remote/api/WalletBalanceApi;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "getWalletBalance", "Lcom/talabat/talabatcommon/feature/walletBalance/model/response/WalletCreditBalanceResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBalanceRemoteSourceImpl implements WalletBalanceRemoteSource {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final WalletBalanceApi walletBalanceApi;

    public WalletBalanceRemoteSourceImpl(@NotNull WalletBalanceApi walletBalanceApi2, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(walletBalanceApi2, "walletBalanceApi");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.walletBalanceApi = walletBalanceApi2;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @Nullable
    public Object getWalletBalance(@NotNull Continuation<? super WalletCreditBalanceResponse> continuation) {
        return this.walletBalanceApi.getWalletBalance(String.valueOf(this.configurationLocalRepository.selectedCountry().getCountryId()), continuation);
    }
}
