package com.talabat.wallet.bnplmanager.domain.business.usecase;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPlan;
import com.talabat.wallet.bnplmanager.domain.repository.BNPLManagerRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fHBø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLPlansUseCase;", "", "bNPLManagerRepository", "Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "invoke", "", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetBNPLPlansUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final BNPLManagerRepository bNPLManagerRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final IObservabilityManager observabilityManager;

    public GetBNPLPlansUseCase(@NotNull BNPLManagerRepository bNPLManagerRepository2, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(bNPLManagerRepository2, "bNPLManagerRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.bNPLManagerRepository = bNPLManagerRepository2;
        this.dispatcher = coroutineDispatcher;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.observabilityManager = iObservabilityManager;
    }

    @Nullable
    public final Object invoke(@NotNull Continuation<? super List<BNPLPlan>> continuation) {
        return BuildersKt.withContext(this.dispatcher, new GetBNPLPlansUseCase$invoke$2(this, (Continuation<? super GetBNPLPlansUseCase$invoke$2>) null), continuation);
    }
}
