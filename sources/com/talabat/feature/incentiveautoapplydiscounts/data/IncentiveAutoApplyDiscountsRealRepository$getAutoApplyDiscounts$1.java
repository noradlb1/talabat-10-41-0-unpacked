package com.talabat.feature.incentiveautoapplydiscounts.data;

import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscountsRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.incentiveautoapplydiscounts.data.IncentiveAutoApplyDiscountsRealRepository", f = "IncentiveAutoApplyDiscountsRealRepository.kt", i = {0, 0}, l = {31}, m = "getAutoApplyDiscounts", n = {"this", "$this$getAutoApplyDiscounts_u24lambda_u2d3_u24lambda_u2d2"}, s = {"L$0", "L$1"})
public final class IncentiveAutoApplyDiscountsRealRepository$getAutoApplyDiscounts$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58557h;

    /* renamed from: i  reason: collision with root package name */
    public Object f58558i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f58559j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ IncentiveAutoApplyDiscountsRealRepository f58560k;

    /* renamed from: l  reason: collision with root package name */
    public int f58561l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IncentiveAutoApplyDiscountsRealRepository$getAutoApplyDiscounts$1(IncentiveAutoApplyDiscountsRealRepository incentiveAutoApplyDiscountsRealRepository, Continuation<? super IncentiveAutoApplyDiscountsRealRepository$getAutoApplyDiscounts$1> continuation) {
        super(continuation);
        this.f58560k = incentiveAutoApplyDiscountsRealRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58559j = obj;
        this.f58561l |= Integer.MIN_VALUE;
        return this.f58560k.getAutoApplyDiscounts((AutoApplyDiscountsRequest) null, this);
    }
}
