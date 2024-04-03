package com.talabat.feature.tmart.growth.data;

import com.integration.nfv.observability.NfvObservabilityHandler;
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
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Result;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.data.TMartGrowthRepository$voucherResponse$1$3", f = "TMartGrowthRepository.kt", i = {0}, l = {80}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
public final class TMartGrowthRepository$voucherResponse$1$3 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends TMartGrowthVoucherResponse>>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59063h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59064i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthRepository.RequestType f59065j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthRepository$voucherResponse$1$3(TMartGrowthRepository.RequestType requestType, Continuation<? super TMartGrowthRepository$voucherResponse$1$3> continuation) {
        super(3, continuation);
        this.f59065j = requestType;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super Result<TMartGrowthVoucherResponse>> flowCollector, @NotNull Throwable th2, @Nullable Continuation<? super Unit> continuation) {
        TMartGrowthRepository$voucherResponse$1$3 tMartGrowthRepository$voucherResponse$1$3 = new TMartGrowthRepository$voucherResponse$1$3(this.f59065j, continuation);
        tMartGrowthRepository$voucherResponse$1$3.L$0 = flowCollector;
        tMartGrowthRepository$voucherResponse$1$3.f59064i = th2;
        return tMartGrowthRepository$voucherResponse$1$3.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Throwable th2;
        String str;
        TMartGrowthRepository.RequestType.GrowthWidget growthWidget;
        String str2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f59063h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Throwable th3 = (Throwable) this.f59064i;
            Result.Companion companion = Result.Companion;
            Result r32 = Result.m6328boximpl(Result.m6329constructorimpl(ResultKt.createFailure(th3)));
            this.L$0 = th3;
            this.f59063h = 1;
            if (((FlowCollector) this.L$0).emit(r32, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            th2 = th3;
        } else if (i11 == 1) {
            th2 = (Throwable) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NfvObservabilityHandler nfvObservabilityHandler = NfvObservabilityHandler.INSTANCE;
        String message = th2.getMessage();
        if (message == null) {
            str = "";
        } else {
            str = message;
        }
        TMartGrowthRepository.RequestType requestType = this.f59065j;
        String str3 = null;
        if (requestType instanceof TMartGrowthRepository.RequestType.GrowthWidget) {
            growthWidget = (TMartGrowthRepository.RequestType.GrowthWidget) requestType;
        } else {
            growthWidget = null;
        }
        if (growthWidget != null) {
            str3 = growthWidget.getVoucherId();
        }
        if (str3 == null) {
            str2 = "";
        } else {
            str2 = str3;
        }
        NfvObservabilityHandler.onTMartGrowthGetFailed$default(nfvObservabilityHandler, 0, str, str2, 1, (Object) null);
        return Unit.INSTANCE;
    }
}
