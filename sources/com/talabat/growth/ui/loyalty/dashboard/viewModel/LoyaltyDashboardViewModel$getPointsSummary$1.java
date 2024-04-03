package com.talabat.growth.ui.loyalty.dashboard.viewModel;

import kotlin.Metadata;
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
@DebugMetadata(c = "com.talabat.growth.ui.loyalty.dashboard.viewModel.LoyaltyDashboardViewModel$getPointsSummary$1", f = "LoyaltyDashboardViewModel.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
public final class LoyaltyDashboardViewModel$getPointsSummary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f60667h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LoyaltyDashboardViewModel f60668i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f60669j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoyaltyDashboardViewModel$getPointsSummary$1(LoyaltyDashboardViewModel loyaltyDashboardViewModel, String str, Continuation<? super LoyaltyDashboardViewModel$getPointsSummary$1> continuation) {
        super(2, continuation);
        this.f60668i = loyaltyDashboardViewModel;
        this.f60669j = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LoyaltyDashboardViewModel$getPointsSummary$1(this.f60668i, this.f60669j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LoyaltyDashboardViewModel$getPointsSummary$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f60667h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            LoyaltyDashboardViewModel loyaltyDashboardViewModel = this.f60668i;
            String str = this.f60669j;
            this.f60667h = 1;
            if (loyaltyDashboardViewModel.getSuspendedPointsSummary(str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
