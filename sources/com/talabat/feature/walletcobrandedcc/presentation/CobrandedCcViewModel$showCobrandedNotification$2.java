package com.talabat.feature.walletcobrandedcc.presentation;

import androidx.lifecycle.MutableLiveData;
import com.talabat.feature.walletcobrandedcc.domain.model.CobrandedCcInProgressAppNotification;
import com.talabat.feature.walletcobrandedcc.domain.usecase.ShowCobrandedNotificationUseCase;
import com.talabat.feature.walletcobrandedcc.tracking.AccountBadgeLoadedEvent;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.walletcobrandedcc.presentation.CobrandedCcViewModel$showCobrandedNotification$2", f = "CobrandedCcViewModel.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
public final class CobrandedCcViewModel$showCobrandedNotification$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f59456h;

    /* renamed from: i  reason: collision with root package name */
    public int f59457i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CobrandedCcViewModel f59458j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CobrandedCcViewModel$showCobrandedNotification$2(CobrandedCcViewModel cobrandedCcViewModel, Continuation<? super CobrandedCcViewModel$showCobrandedNotification$2> continuation) {
        super(2, continuation);
        this.f59458j = cobrandedCcViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CobrandedCcViewModel$showCobrandedNotification$2(this.f59458j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CobrandedCcViewModel$showCobrandedNotification$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        CobrandedCcViewModel cobrandedCcViewModel;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59457i;
        boolean z11 = true;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CobrandedCcViewModel cobrandedCcViewModel2 = this.f59458j;
            Result.Companion companion = Result.Companion;
            ShowCobrandedNotificationUseCase access$getShowCobrandedNotificationUseCase$p = cobrandedCcViewModel2.showCobrandedNotificationUseCase;
            this.f59456h = cobrandedCcViewModel2;
            this.f59457i = 1;
            Object invoke = access$getShowCobrandedNotificationUseCase$p.invoke(this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            cobrandedCcViewModel = cobrandedCcViewModel2;
            obj = invoke;
        } else if (i11 == 1) {
            cobrandedCcViewModel = (CobrandedCcViewModel) this.f59456h;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean shouldNotifyUser = ((CobrandedCcInProgressAppNotification) obj).getShouldNotifyUser();
        MutableLiveData access$get_showCobrandedNotification$p = cobrandedCcViewModel._showCobrandedNotification;
        if (!shouldNotifyUser) {
            z11 = false;
        }
        access$get_showCobrandedNotification$p.setValue(Boxing.boxBoolean(z11));
        if (shouldNotifyUser) {
            cobrandedCcViewModel.talabatTracker.track(new AccountBadgeLoadedEvent());
        }
        obj2 = Result.m6329constructorimpl(Unit.INSTANCE);
        CobrandedCcViewModel cobrandedCcViewModel3 = this.f59458j;
        if (Result.m6332exceptionOrNullimpl(obj2) != null) {
            cobrandedCcViewModel3._showCobrandedNotification.setValue(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }
}
