package com.talabat.feature.tmart.growth.presentation.sheet;

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
@DebugMetadata(c = "com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheet$onViewCreated$1", f = "TMartGrowthBottomSheet.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthBottomSheet$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59141h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthBottomSheet f59142i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthBottomSheet$onViewCreated$1(TMartGrowthBottomSheet tMartGrowthBottomSheet, Continuation<? super TMartGrowthBottomSheet$onViewCreated$1> continuation) {
        super(2, continuation);
        this.f59142i = tMartGrowthBottomSheet;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TMartGrowthBottomSheet$onViewCreated$1(this.f59142i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TMartGrowthBottomSheet$onViewCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59141h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<BottomSheetState> state = this.f59142i.getViewModel().getState();
            final TMartGrowthBottomSheet tMartGrowthBottomSheet = this.f59142i;
            AnonymousClass1 r12 = new FlowCollector() {
                @Nullable
                public final Object emit(@NotNull BottomSheetState bottomSheetState, @NotNull Continuation<? super Unit> continuation) {
                    tMartGrowthBottomSheet.handleState(bottomSheetState);
                    return Unit.INSTANCE;
                }
            };
            this.f59141h = 1;
            if (state.collect(r12, this) == coroutine_suspended) {
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
