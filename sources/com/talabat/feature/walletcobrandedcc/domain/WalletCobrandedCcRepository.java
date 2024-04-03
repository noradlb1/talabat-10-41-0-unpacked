package com.talabat.feature.walletcobrandedcc.domain;

import com.talabat.feature.walletcobrandedcc.domain.model.CobrandedCcInProgressAppNotification;
import com.talabat.feature.walletcobrandedcc.domain.model.WalletStatus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/domain/WalletCobrandedCcRepository;", "", "getWalletStatus", "Lcom/talabat/feature/walletcobrandedcc/domain/model/WalletStatus;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldDisplayCobrandedCcInProgressNotification", "Lcom/talabat/feature/walletcobrandedcc/domain/model/CobrandedCcInProgressAppNotification;", "com_talabat_feature_wallet-cobranded-cc_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletCobrandedCcRepository {
    @Nullable
    Object getWalletStatus(@NotNull Continuation<? super WalletStatus> continuation);

    @Nullable
    Object shouldDisplayCobrandedCcInProgressNotification(@NotNull Continuation<? super CobrandedCcInProgressAppNotification> continuation);
}
