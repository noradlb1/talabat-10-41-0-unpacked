package com.talabat.feature.tmart.growth.data;

import com.talabat.feature.tmart.growth.data.TMartGrowthRepository;
import com.talabat.feature.tmart.growth.data.convert.TMartGrowthResponseMappersKt;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthVoucherResponse;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthTrackingInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H@"}, d2 = {"Lkotlin/Result;", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse;", "result", "Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType;", "requestType", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthTrackingInfo;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.data.TMartGrowthRepository$trackingData$1", f = "TMartGrowthRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthRepository$trackingData$1 extends SuspendLambda implements Function3<Result<? extends TMartGrowthVoucherResponse>, TMartGrowthRepository.RequestType, Continuation<? super TMartGrowthTrackingInfo>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59057h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59058i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f59059j;

    public TMartGrowthRepository$trackingData$1(Continuation<? super TMartGrowthRepository$trackingData$1> continuation) {
        super(3, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull Object obj, @NotNull TMartGrowthRepository.RequestType requestType, @Nullable Continuation<? super TMartGrowthTrackingInfo> continuation) {
        TMartGrowthRepository$trackingData$1 tMartGrowthRepository$trackingData$1 = new TMartGrowthRepository$trackingData$1(continuation);
        tMartGrowthRepository$trackingData$1.f59058i = Result.m6328boximpl(obj);
        tMartGrowthRepository$trackingData$1.f59059j = requestType;
        return tMartGrowthRepository$trackingData$1.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Result) obj).m6338unboximpl(), (TMartGrowthRepository.RequestType) obj2, (Continuation<? super TMartGrowthTrackingInfo>) (Continuation) obj3);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        TMartGrowthRepository.RequestType.GrowthWidget growthWidget;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f59057h == 0) {
            ResultKt.throwOnFailure(obj);
            Object r42 = ((Result) this.f59058i).m6338unboximpl();
            TMartGrowthRepository.RequestType requestType = (TMartGrowthRepository.RequestType) this.f59059j;
            if (Result.m6336isSuccessimpl(r42)) {
                TMartGrowthVoucherResponse tMartGrowthVoucherResponse = (TMartGrowthVoucherResponse) r42;
                String str = null;
                if (requestType instanceof TMartGrowthRepository.RequestType.GrowthWidget) {
                    growthWidget = (TMartGrowthRepository.RequestType.GrowthWidget) requestType;
                } else {
                    growthWidget = null;
                }
                if (growthWidget != null) {
                    str = growthWidget.getVoucherId();
                }
                if (str == null) {
                    str = "";
                }
                r42 = TMartGrowthResponseMappersKt.toTrackingInfo(tMartGrowthVoucherResponse, str, tMartGrowthVoucherResponse.getClaimInfo().getTitle());
            }
            Object r43 = Result.m6329constructorimpl(r42);
            ResultKt.throwOnFailure(r43);
            return r43;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
