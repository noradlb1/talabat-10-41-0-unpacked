package com.talabat.feature.walletcobrandedcc.domain;

import com.talabat.core.di.Api;
import com.talabat.feature.walletcobrandedcc.domain.usecase.GetWalletStatusUseCase;
import com.talabat.feature.walletcobrandedcc.domain.usecase.ShowCobrandedNotificationUseCase;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/domain/WalletCobrandedCcFeatureApi;", "Lcom/talabat/core/di/Api;", "getWalletStatusUseCase", "Lcom/talabat/feature/walletcobrandedcc/domain/usecase/GetWalletStatusUseCase;", "showCobrandedNotificationUseCase", "Lcom/talabat/feature/walletcobrandedcc/domain/usecase/ShowCobrandedNotificationUseCase;", "walletCobrandedCcRepository", "Lcom/talabat/feature/walletcobrandedcc/domain/WalletCobrandedCcRepository;", "com_talabat_feature_wallet-cobranded-cc_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletCobrandedCcFeatureApi extends Api {
    @NotNull
    GetWalletStatusUseCase getWalletStatusUseCase();

    @NotNull
    ShowCobrandedNotificationUseCase showCobrandedNotificationUseCase();

    @NotNull
    WalletCobrandedCcRepository walletCobrandedCcRepository();
}
