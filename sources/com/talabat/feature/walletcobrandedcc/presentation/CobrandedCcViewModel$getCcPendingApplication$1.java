package com.talabat.feature.walletcobrandedcc.presentation;

import com.talabat.feature.walletcobrandedcc.domain.model.WalletStatus;
import com.talabat.feature.walletcobrandedcc.domain.usecase.GetWalletStatusUseCase;
import com.talabat.feature.walletcobrandedcc.tracking.AccountScreenBadgeLoadedEvent;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.walletcobrandedcc.presentation.CobrandedCcViewModel$getCcPendingApplication$1", f = "CobrandedCcViewModel.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
public final class CobrandedCcViewModel$getCcPendingApplication$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f59453h;

    /* renamed from: i  reason: collision with root package name */
    public int f59454i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CobrandedCcViewModel f59455j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CobrandedCcViewModel$getCcPendingApplication$1(CobrandedCcViewModel cobrandedCcViewModel, Continuation<? super CobrandedCcViewModel$getCcPendingApplication$1> continuation) {
        super(2, continuation);
        this.f59455j = cobrandedCcViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CobrandedCcViewModel$getCcPendingApplication$1(this.f59455j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CobrandedCcViewModel$getCcPendingApplication$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        CobrandedCcViewModel cobrandedCcViewModel;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59454i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CobrandedCcViewModel cobrandedCcViewModel2 = this.f59455j;
            Result.Companion companion = Result.Companion;
            GetWalletStatusUseCase access$getGetWalletStatusUseCase$p = cobrandedCcViewModel2.getWalletStatusUseCase;
            this.f59453h = cobrandedCcViewModel2;
            this.f59454i = 1;
            Object invoke = access$getGetWalletStatusUseCase$p.invoke(this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            cobrandedCcViewModel = cobrandedCcViewModel2;
            obj = invoke;
        } else if (i11 == 1) {
            cobrandedCcViewModel = (CobrandedCcViewModel) this.f59453h;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        WalletStatus walletStatus = (WalletStatus) obj;
        cobrandedCcViewModel._walletStatus.setValue(walletStatus);
        if (walletStatus.getShouldShowNotification()) {
            cobrandedCcViewModel.talabatTracker.track(new AccountScreenBadgeLoadedEvent());
        }
        obj2 = Result.m6329constructorimpl(Unit.INSTANCE);
        CobrandedCcViewModel cobrandedCcViewModel3 = this.f59455j;
        if (Result.m6332exceptionOrNullimpl(obj2) != null) {
            cobrandedCcViewModel3._walletStatus.setValue(new WalletStatus(false, "", "normal"));
        }
        return Unit.INSTANCE;
    }
}
