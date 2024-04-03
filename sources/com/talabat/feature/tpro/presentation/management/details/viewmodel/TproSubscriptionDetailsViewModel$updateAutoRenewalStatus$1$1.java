package com.talabat.feature.tpro.presentation.management.details.viewmodel;

import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase;
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
@DebugMetadata(c = "com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel$updateAutoRenewalStatus$1$1", f = "TproSubscriptionDetailsViewModel.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
public final class TproSubscriptionDetailsViewModel$updateAutoRenewalStatus$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59342h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TproSubscriptionDetailsViewModel f59343i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f59344j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f59345k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f59346l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f59347m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f59348n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TproSubscriptionDetailsViewModel$updateAutoRenewalStatus$1$1(TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel, String str, boolean z11, boolean z12, boolean z13, boolean z14, Continuation<? super TproSubscriptionDetailsViewModel$updateAutoRenewalStatus$1$1> continuation) {
        super(2, continuation);
        this.f59343i = tproSubscriptionDetailsViewModel;
        this.f59344j = str;
        this.f59345k = z11;
        this.f59346l = z12;
        this.f59347m = z13;
        this.f59348n = z14;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TproSubscriptionDetailsViewModel$updateAutoRenewalStatus$1$1 tproSubscriptionDetailsViewModel$updateAutoRenewalStatus$1$1 = new TproSubscriptionDetailsViewModel$updateAutoRenewalStatus$1$1(this.f59343i, this.f59344j, this.f59345k, this.f59346l, this.f59347m, this.f59348n, continuation);
        tproSubscriptionDetailsViewModel$updateAutoRenewalStatus$1$1.L$0 = obj;
        return tproSubscriptionDetailsViewModel$updateAutoRenewalStatus$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TproSubscriptionDetailsViewModel$updateAutoRenewalStatus$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        boolean z11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59342h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel = this.f59343i;
            String str = this.f59344j;
            boolean z12 = this.f59345k;
            boolean z13 = this.f59346l;
            Result.Companion companion = Result.Companion;
            UpdateAutoRenewalUseCase access$getUpdateAutoRenewalUseCase$p = tproSubscriptionDetailsViewModel.updateAutoRenewalUseCase;
            if (z13) {
                z11 = true;
            } else {
                z11 = false;
            }
            UpdateAutoRenewalUseCase.Params params = new UpdateAutoRenewalUseCase.Params(str, z12, z11);
            this.f59342h = 1;
            if (access$getUpdateAutoRenewalUseCase$p.invoke(params, this) == coroutine_suspended) {
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
        obj2 = Result.m6329constructorimpl(Unit.INSTANCE);
        boolean z14 = this.f59347m;
        boolean z15 = this.f59346l;
        TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel2 = this.f59343i;
        boolean z16 = this.f59345k;
        boolean z17 = this.f59348n;
        String str2 = this.f59344j;
        if (Result.m6336isSuccessimpl(obj2)) {
            Unit unit = (Unit) obj2;
            if (z14) {
                if (z15) {
                    tproSubscriptionDetailsViewModel2._subscriptionAutoRenewTurnedOn.setValue(Boxing.boxBoolean(false));
                    tproSubscriptionDetailsViewModel2._subscriptionAutoRenewTurnedOff.setValue(Boxing.boxBoolean(true));
                } else {
                    tproSubscriptionDetailsViewModel2._subscriptionAutoRenewTurnedOff.setValue(Boxing.boxBoolean(false));
                    tproSubscriptionDetailsViewModel2._subscriptionAutoRenewTurnedOn.setValue(Boxing.boxBoolean(true));
                }
            } else if (z16) {
                tproSubscriptionDetailsViewModel2._renewalEnabled.setValue(str2);
            } else if (z17) {
                tproSubscriptionDetailsViewModel2._autoRenewalCanceledFromBanner.setValue(Boxing.boxBoolean(true));
            } else {
                tproSubscriptionDetailsViewModel2._renewalCanceled.setValue(str2);
            }
            Subscription access$getSubscriptionStatus = tproSubscriptionDetailsViewModel2.getSubscriptionStatus(str2);
            if (access$getSubscriptionStatus != null) {
                tproSubscriptionDetailsViewModel2._subscription.postValue(access$getSubscriptionStatus);
            }
        }
        boolean z18 = this.f59345k;
        boolean z19 = this.f59348n;
        TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel3 = this.f59343i;
        if (Result.m6332exceptionOrNullimpl(obj2) != null && !z18 && z19) {
            tproSubscriptionDetailsViewModel3._autoRenewalCanceledFromBanner.setValue(Boxing.boxBoolean(false));
        }
        return Unit.INSTANCE;
    }
}
