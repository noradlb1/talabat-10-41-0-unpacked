package com.talabat.feature.tmart.growth.data;

import com.talabat.feature.tmart.growth.data.TMartGrowthRepository;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthVoucherResponse;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.talabat.feature.tmart.growth.data.TMartGrowthRepository$special$$inlined$flatMapLatest$1", f = "TMartGrowthRepository.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthRepository$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends TMartGrowthVoucherResponse>>, TMartGrowthRepository.RequestType, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59028h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59029i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthRepository f59030j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthRepository$special$$inlined$flatMapLatest$1(Continuation continuation, TMartGrowthRepository tMartGrowthRepository) {
        super(3, continuation);
        this.f59030j = tMartGrowthRepository;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super Result<? extends TMartGrowthVoucherResponse>> flowCollector, TMartGrowthRepository.RequestType requestType, @Nullable Continuation<? super Unit> continuation) {
        TMartGrowthRepository$special$$inlined$flatMapLatest$1 tMartGrowthRepository$special$$inlined$flatMapLatest$1 = new TMartGrowthRepository$special$$inlined$flatMapLatest$1(continuation, this.f59030j);
        tMartGrowthRepository$special$$inlined$flatMapLatest$1.L$0 = flowCollector;
        tMartGrowthRepository$special$$inlined$flatMapLatest$1.f59029i = requestType;
        return tMartGrowthRepository$special$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59028h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            TMartGrowthRepository.RequestType requestType = (TMartGrowthRepository.RequestType) this.f59029i;
            Flow flow = FlowKt.m7822catch(new TMartGrowthRepository$voucherResponse$lambda1$$inlined$map$1(FlowKt.flow(new TMartGrowthRepository$voucherResponse$1$1(this.f59030j, requestType, (Continuation<? super TMartGrowthRepository$voucherResponse$1$1>) null))), new TMartGrowthRepository$voucherResponse$1$3(requestType, (Continuation<? super TMartGrowthRepository$voucherResponse$1$3>) null));
            this.f59028h = 1;
            if (FlowKt.emitAll((FlowCollector) this.L$0, flow, (Continuation<? super Unit>) this) == coroutine_suspended) {
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
