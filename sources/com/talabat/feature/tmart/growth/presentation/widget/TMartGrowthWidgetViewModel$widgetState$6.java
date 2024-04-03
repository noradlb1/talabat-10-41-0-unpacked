package com.talabat.feature.tmart.growth.presentation.widget;

import com.talabat.feature.tmart.growth.presentation.widget.WidgetState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/talabat/feature/tmart/growth/presentation/widget/WidgetState;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetViewModel$widgetState$6", f = "TMartGrowthWidgetViewModel.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthWidgetViewModel$widgetState$6 extends SuspendLambda implements Function3<FlowCollector<? super WidgetState>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59230h;

    public TMartGrowthWidgetViewModel$widgetState$6(Continuation<? super TMartGrowthWidgetViewModel$widgetState$6> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super WidgetState> flowCollector, @NotNull Throwable th2, @Nullable Continuation<? super Unit> continuation) {
        TMartGrowthWidgetViewModel$widgetState$6 tMartGrowthWidgetViewModel$widgetState$6 = new TMartGrowthWidgetViewModel$widgetState$6(continuation);
        tMartGrowthWidgetViewModel$widgetState$6.L$0 = flowCollector;
        return tMartGrowthWidgetViewModel$widgetState$6.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59230h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            WidgetState.Hidden hidden = WidgetState.Hidden.INSTANCE;
            this.f59230h = 1;
            if (((FlowCollector) this.L$0).emit(hidden, this) == coroutine_suspended) {
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
