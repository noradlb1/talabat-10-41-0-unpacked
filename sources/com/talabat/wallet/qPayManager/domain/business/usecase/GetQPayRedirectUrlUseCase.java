package com.talabat.wallet.qPayManager.domain.business.usecase;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.wallet.qPayManager.data.remote.dto.QPayRedirectUrlRequest;
import com.talabat.wallet.qPayManager.domain.entity.QPayRedirectUrlResult;
import com.talabat.wallet.qPayManager.domain.repository.QPayManagerRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fHBø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/qPayManager/domain/business/usecase/GetQPayRedirectUrlUseCase;", "", "qPayManagerRepository", "Lcom/talabat/wallet/qPayManager/domain/repository/QPayManagerRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/wallet/qPayManager/domain/repository/QPayManagerRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "invoke", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayRedirectUrlResult;", "url", "", "request", "Lcom/talabat/wallet/qPayManager/data/remote/dto/QPayRedirectUrlRequest;", "(Ljava/lang/String;Lcom/talabat/wallet/qPayManager/data/remote/dto/QPayRedirectUrlRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetQPayRedirectUrlUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final IObservabilityManager observabilityManager;
    /* access modifiers changed from: private */
    @NotNull
    public final QPayManagerRepository qPayManagerRepository;

    public GetQPayRedirectUrlUseCase(@NotNull QPayManagerRepository qPayManagerRepository2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(qPayManagerRepository2, "qPayManagerRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.qPayManagerRepository = qPayManagerRepository2;
        this.observabilityManager = iObservabilityManager;
    }

    @Nullable
    public final Object invoke(@Nullable String str, @NotNull QPayRedirectUrlRequest qPayRedirectUrlRequest, @NotNull Continuation<? super QPayRedirectUrlResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GetQPayRedirectUrlUseCase$invoke$2(str, this, qPayRedirectUrlRequest, (Continuation<? super GetQPayRedirectUrlUseCase$invoke$2>) null), continuation);
    }
}
