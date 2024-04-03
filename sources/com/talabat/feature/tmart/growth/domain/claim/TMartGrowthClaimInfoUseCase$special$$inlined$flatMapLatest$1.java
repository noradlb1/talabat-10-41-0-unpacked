package com.talabat.feature.tmart.growth.domain.claim;

import com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H@¨\u0006\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$special$$inlined$flatMapLatest$1", f = "TMartGrowthClaimInfoUseCase.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthClaimInfoUseCase$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super TMartGrowthClaimDisplayModel>, TMartGrowthClaimInfo, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59078h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59079i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthClaimInfoUseCase f59080j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthClaimInfoUseCase$special$$inlined$flatMapLatest$1(Continuation continuation, TMartGrowthClaimInfoUseCase tMartGrowthClaimInfoUseCase) {
        super(3, continuation);
        this.f59080j = tMartGrowthClaimInfoUseCase;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super TMartGrowthClaimDisplayModel> flowCollector, TMartGrowthClaimInfo tMartGrowthClaimInfo, @Nullable Continuation<? super Unit> continuation) {
        TMartGrowthClaimInfoUseCase$special$$inlined$flatMapLatest$1 tMartGrowthClaimInfoUseCase$special$$inlined$flatMapLatest$1 = new TMartGrowthClaimInfoUseCase$special$$inlined$flatMapLatest$1(continuation, this.f59080j);
        tMartGrowthClaimInfoUseCase$special$$inlined$flatMapLatest$1.L$0 = flowCollector;
        tMartGrowthClaimInfoUseCase$special$$inlined$flatMapLatest$1.f59079i = tMartGrowthClaimInfo;
        return tMartGrowthClaimInfoUseCase$special$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Flow flow;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59078h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            TMartGrowthClaimInfo tMartGrowthClaimInfo = (TMartGrowthClaimInfo) this.f59079i;
            if (Intrinsics.areEqual((Object) tMartGrowthClaimInfo, (Object) TMartGrowthClaimInfo.Refreshing.INSTANCE)) {
                flow = FlowKt.flowOf(TMartGrowthClaimDisplayModel.Loading.INSTANCE);
            } else if (tMartGrowthClaimInfo instanceof TMartGrowthClaimInfo.Success) {
                flow = this.f59080j.toDisplayModelFlow((TMartGrowthClaimInfo.Success) tMartGrowthClaimInfo);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.f59078h = 1;
            if (FlowKt.emitAll(flowCollector, flow, (Continuation<? super Unit>) this) == coroutine_suspended) {
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
