package com.talabat.wallet.bnplmanager.domain.business.usecase;

import com.talabat.wallet.bnplmanager.domain.repository.BNPLManagerRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nHBø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/business/usecase/SetIsUserSeenBNPLPaymentFallbackOptionUseCase;", "", "bNPLManagerRepository", "Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/wallet/bnplmanager/domain/repository/BNPLManagerRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "invoke", "", "seenOption", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SetIsUserSeenBNPLPaymentFallbackOptionUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final BNPLManagerRepository bNPLManagerRepository;
    @NotNull
    private final CoroutineDispatcher dispatcher;

    public SetIsUserSeenBNPLPaymentFallbackOptionUseCase(@NotNull BNPLManagerRepository bNPLManagerRepository2, @NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(bNPLManagerRepository2, "bNPLManagerRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.bNPLManagerRepository = bNPLManagerRepository2;
        this.dispatcher = coroutineDispatcher;
    }

    @Nullable
    public final Object invoke(boolean z11, @NotNull Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatcher, new SetIsUserSeenBNPLPaymentFallbackOptionUseCase$invoke$2(this, z11, (Continuation<? super SetIsUserSeenBNPLPaymentFallbackOptionUseCase$invoke$2>) null), continuation);
        return withContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
