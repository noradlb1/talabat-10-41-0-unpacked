package com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote;

import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscountsRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsRemoteDataSource", f = "IncentiveAutoApplyDiscountsRemoteDataSource.kt", i = {}, l = {16}, m = "getAutoApplyDiscounts", n = {}, s = {})
public final class IncentiveAutoApplyDiscountsRemoteDataSource$getAutoApplyDiscounts$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f58563h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ IncentiveAutoApplyDiscountsRemoteDataSource f58564i;

    /* renamed from: j  reason: collision with root package name */
    public int f58565j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IncentiveAutoApplyDiscountsRemoteDataSource$getAutoApplyDiscounts$1(IncentiveAutoApplyDiscountsRemoteDataSource incentiveAutoApplyDiscountsRemoteDataSource, Continuation<? super IncentiveAutoApplyDiscountsRemoteDataSource$getAutoApplyDiscounts$1> continuation) {
        super(continuation);
        this.f58564i = incentiveAutoApplyDiscountsRemoteDataSource;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58563h = obj;
        this.f58565j |= Integer.MIN_VALUE;
        return this.f58564i.getAutoApplyDiscounts((AutoApplyDiscountsRequest) null, this);
    }
}
