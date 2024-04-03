package com.talabat.feature.tmart.growth.data;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.data.TMartGrowthRepository$combinedTrigger$1", f = "TMartGrowthRepository.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthRepository$combinedTrigger$1 extends SuspendLambda implements Function2<FlowCollector<? super Unit>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59054h;

    public TMartGrowthRepository$combinedTrigger$1(Continuation<? super TMartGrowthRepository$combinedTrigger$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TMartGrowthRepository$combinedTrigger$1 tMartGrowthRepository$combinedTrigger$1 = new TMartGrowthRepository$combinedTrigger$1(continuation);
        tMartGrowthRepository$combinedTrigger$1.L$0 = obj;
        return tMartGrowthRepository$combinedTrigger$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super Unit> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((TMartGrowthRepository$combinedTrigger$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59054h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Unit unit = Unit.INSTANCE;
            this.f59054h = 1;
            if (((FlowCollector) this.L$0).emit(unit, this) == coroutine_suspended) {
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
