package com.talabat.feature.walletcobrandedcc.domain.usecase.impl;

import com.talabat.feature.walletcobrandedcc.domain.WalletCobrandedCcRepository;
import com.talabat.feature.walletcobrandedcc.domain.model.WalletStatus;
import com.talabat.feature.walletcobrandedcc.domain.usecase.GetWalletStatusUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/domain/usecase/impl/GetWalletStatusUseCaseImpl;", "Lcom/talabat/feature/walletcobrandedcc/domain/usecase/GetWalletStatusUseCase;", "walletCobrandedCcRepository", "Lcom/talabat/feature/walletcobrandedcc/domain/WalletCobrandedCcRepository;", "(Lcom/talabat/feature/walletcobrandedcc/domain/WalletCobrandedCcRepository;)V", "invoke", "Lcom/talabat/feature/walletcobrandedcc/domain/model/WalletStatus;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_wallet-cobranded-cc_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetWalletStatusUseCaseImpl implements GetWalletStatusUseCase {
    @NotNull
    private final WalletCobrandedCcRepository walletCobrandedCcRepository;

    @Inject
    public GetWalletStatusUseCaseImpl(@NotNull WalletCobrandedCcRepository walletCobrandedCcRepository2) {
        Intrinsics.checkNotNullParameter(walletCobrandedCcRepository2, "walletCobrandedCcRepository");
        this.walletCobrandedCcRepository = walletCobrandedCcRepository2;
    }

    @Nullable
    public Object invoke(@NotNull Continuation<? super WalletStatus> continuation) {
        return this.walletCobrandedCcRepository.getWalletStatus(continuation);
    }
}
