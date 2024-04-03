package com.talabat.feature.tmart.growth.presentation.sheet;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimConfirmation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H@¨\u0006\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$special$$inlined$flatMapLatest$1", f = "TMartGrowthBottomSheetViewModel.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthBottomSheetViewModel$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super BottomSheetState>, TMartGrowthClaimConfirmation, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59155h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59156i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthBottomSheetViewModel f59157j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthBottomSheetViewModel$special$$inlined$flatMapLatest$1(Continuation continuation, TMartGrowthBottomSheetViewModel tMartGrowthBottomSheetViewModel) {
        super(3, continuation);
        this.f59157j = tMartGrowthBottomSheetViewModel;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super BottomSheetState> flowCollector, TMartGrowthClaimConfirmation tMartGrowthClaimConfirmation, @Nullable Continuation<? super Unit> continuation) {
        TMartGrowthBottomSheetViewModel$special$$inlined$flatMapLatest$1 tMartGrowthBottomSheetViewModel$special$$inlined$flatMapLatest$1 = new TMartGrowthBottomSheetViewModel$special$$inlined$flatMapLatest$1(continuation, this.f59157j);
        tMartGrowthBottomSheetViewModel$special$$inlined$flatMapLatest$1.L$0 = flowCollector;
        tMartGrowthBottomSheetViewModel$special$$inlined$flatMapLatest$1.f59156i = tMartGrowthClaimConfirmation;
        return tMartGrowthBottomSheetViewModel$special$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59155h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            TMartGrowthClaimConfirmation tMartGrowthClaimConfirmation = (TMartGrowthClaimConfirmation) this.f59156i;
            Flow onStart = FlowKt.onStart(new TMartGrowthBottomSheetViewModel$_init_$lambda2$$inlined$map$1(this.f59157j.actionFlow, this.f59157j, tMartGrowthClaimConfirmation), new TMartGrowthBottomSheetViewModel$3$2(this.f59157j, tMartGrowthClaimConfirmation, (Continuation<? super TMartGrowthBottomSheetViewModel$3$2>) null));
            this.f59155h = 1;
            if (FlowKt.emitAll((FlowCollector) this.L$0, onStart, (Continuation<? super Unit>) this) == coroutine_suspended) {
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
