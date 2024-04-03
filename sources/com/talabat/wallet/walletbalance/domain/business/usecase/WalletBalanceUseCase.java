package com.talabat.wallet.walletbalance.domain.business.usecase;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.wallet.walletbalance.domain.entity.WalletBalanceResult;
import com.talabat.wallet.walletbalance.domain.repository.WalletBalanceRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/walletbalance/domain/business/usecase/WalletBalanceUseCase;", "", "walletBalanceRepository", "Lcom/talabat/wallet/walletbalance/domain/repository/WalletBalanceRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/wallet/walletbalance/domain/repository/WalletBalanceRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "invoke", "Lcom/talabat/wallet/walletbalance/domain/entity/WalletBalanceResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBalanceUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final IObservabilityManager observabilityManager;
    /* access modifiers changed from: private */
    @NotNull
    public final WalletBalanceRepository walletBalanceRepository;

    public WalletBalanceUseCase(@NotNull WalletBalanceRepository walletBalanceRepository2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(walletBalanceRepository2, "walletBalanceRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.walletBalanceRepository = walletBalanceRepository2;
        this.observabilityManager = iObservabilityManager;
    }

    @Nullable
    public final Object invoke(@NotNull Continuation<? super WalletBalanceResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new WalletBalanceUseCase$invoke$2(this, (Continuation<? super WalletBalanceUseCase$invoke$2>) null), continuation);
    }
}
