package com.talabat.wallet.bnplmanager.domain.business.usecase;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLInstallmentRequestModel;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLInstallments;
import com.talabat.wallet.bnplmanager.domain.repository.BNPLManagerRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fHBø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLInstallmentsUseCase;", "", "bNPLManagerRepository", "Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "invoke", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLInstallments;", "bNPLInstallmentRequestModel", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentRequestModel;", "(Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLInstallmentRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetBNPLInstallmentsUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final BNPLManagerRepository bNPLManagerRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final IObservabilityManager observabilityManager;

    public GetBNPLInstallmentsUseCase(@NotNull BNPLManagerRepository bNPLManagerRepository2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(bNPLManagerRepository2, "bNPLManagerRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.bNPLManagerRepository = bNPLManagerRepository2;
        this.dispatcher = coroutineDispatcher;
        this.observabilityManager = iObservabilityManager;
    }

    @Nullable
    public final Object invoke(@NotNull BNPLInstallmentRequestModel bNPLInstallmentRequestModel, @NotNull Continuation<? super BNPLInstallments> continuation) {
        return BuildersKt.withContext(this.dispatcher, new GetBNPLInstallmentsUseCase$invoke$2(this, bNPLInstallmentRequestModel, (Continuation<? super GetBNPLInstallmentsUseCase$invoke$2>) null), continuation);
    }
}
