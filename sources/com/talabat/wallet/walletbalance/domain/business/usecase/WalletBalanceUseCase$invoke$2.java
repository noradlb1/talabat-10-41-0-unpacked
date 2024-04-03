package com.talabat.wallet.walletbalance.domain.business.usecase;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.common.ApiStatus;
import com.talabat.wallet.walletbalance.domain.entity.WalletBalance;
import com.talabat.wallet.walletbalance.domain.entity.WalletBalanceResult;
import com.talabat.wallet.walletbalance.domain.repository.WalletBalanceRepository;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/wallet/walletbalance/domain/entity/WalletBalanceResult;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.walletbalance.domain.business.usecase.WalletBalanceUseCase$invoke$2", f = "WalletBalanceUseCase.kt", i = {}, l = {17}, m = "invokeSuspend", n = {}, s = {})
public final class WalletBalanceUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WalletBalanceResult>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f12858h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletBalanceUseCase f12859i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletBalanceUseCase$invoke$2(WalletBalanceUseCase walletBalanceUseCase, Continuation<? super WalletBalanceUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f12859i = walletBalanceUseCase;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WalletBalanceUseCase$invoke$2 walletBalanceUseCase$invoke$2 = new WalletBalanceUseCase$invoke$2(this.f12859i, continuation);
        walletBalanceUseCase$invoke$2.L$0 = obj;
        return walletBalanceUseCase$invoke$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super WalletBalanceResult> continuation) {
        return ((WalletBalanceUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12858h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            WalletBalanceUseCase walletBalanceUseCase = this.f12859i;
            Result.Companion companion = Result.Companion;
            WalletBalanceRepository access$getWalletBalanceRepository$p = walletBalanceUseCase.walletBalanceRepository;
            this.f12858h = 1;
            obj = access$getWalletBalanceRepository$p.getWalletBalance(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl(new WalletBalanceResult.WalletBalanceSuccess(((WalletBalance) obj).getBalance()));
        WalletBalanceUseCase walletBalanceUseCase2 = this.f12859i;
        if (Result.m6332exceptionOrNullimpl(obj2) == null) {
            return obj2;
        }
        IObservabilityManager.DefaultImpls.trackEvent$default(walletBalanceUseCase2.observabilityManager, "get wallet Balance", ApiStatus.FAILURE.getValue(), (Map) null, 4, (Object) null);
        return WalletBalanceResult.WalletBalanceFailure.INSTANCE;
    }
}
