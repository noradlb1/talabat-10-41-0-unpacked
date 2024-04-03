package com.talabat.feature.tmart.growth.presentation.widget;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.presentation.widget.TMartGrowthWidgetView$onAttachedToWindow$1$1", f = "TMartGrowthWidgetView.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthWidgetView$onAttachedToWindow$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59201h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthWidgetView f59202i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthWidgetView$onAttachedToWindow$1$1(TMartGrowthWidgetView tMartGrowthWidgetView, Continuation<? super TMartGrowthWidgetView$onAttachedToWindow$1$1> continuation) {
        super(2, continuation);
        this.f59202i = tMartGrowthWidgetView;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TMartGrowthWidgetView$onAttachedToWindow$1$1(this.f59202i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TMartGrowthWidgetView$onAttachedToWindow$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59201h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<WidgetState> widgetState = this.f59202i.getViewModel().getWidgetState();
            final TMartGrowthWidgetView tMartGrowthWidgetView = this.f59202i;
            AnonymousClass1 r12 = new FlowCollector() {
                @Nullable
                public final Object emit(@NotNull WidgetState widgetState, @NotNull Continuation<? super Unit> continuation) {
                    tMartGrowthWidgetView.handleState(widgetState);
                    return Unit.INSTANCE;
                }
            };
            this.f59201h = 1;
            if (widgetState.collect(r12, this) == coroutine_suspended) {
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
