package com.talabat.feature.tmart.growth.presentation.widget;

import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase;
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
@DebugMetadata(c = "com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetViewModel$onWidgetClaimed$1", f = "TMartGrowthWidgetViewModel.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthWidgetViewModel$onWidgetClaimed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59220h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthWidgetViewModel f59221i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthWidgetViewModel$onWidgetClaimed$1(TMartGrowthWidgetViewModel tMartGrowthWidgetViewModel, Continuation<? super TMartGrowthWidgetViewModel$onWidgetClaimed$1> continuation) {
        super(2, continuation);
        this.f59221i = tMartGrowthWidgetViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TMartGrowthWidgetViewModel$onWidgetClaimed$1(this.f59221i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TMartGrowthWidgetViewModel$onWidgetClaimed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59220h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            TMartGrowthClaimTrackingUseCase access$getTrackingUseCase$p = this.f59221i.trackingUseCase;
            this.f59220h = 1;
            if (access$getTrackingUseCase$p.trackClaimClicked(this) == coroutine_suspended) {
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
