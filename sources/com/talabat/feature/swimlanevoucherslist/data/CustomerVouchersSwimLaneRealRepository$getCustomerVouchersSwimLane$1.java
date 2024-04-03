package com.talabat.feature.swimlanevoucherslist.data;

import com.talabat.features.swimlanevoucherslist.domain.model.VouchersSwimLaneRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.swimlanevoucherslist.data.CustomerVouchersSwimLaneRealRepository", f = "CustomerVouchersSwimLaneRealRepository.kt", i = {0}, l = {18}, m = "getCustomerVouchersSwimLane", n = {"this"}, s = {"L$0"})
public final class CustomerVouchersSwimLaneRealRepository$getCustomerVouchersSwimLane$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59010h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59011i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CustomerVouchersSwimLaneRealRepository f59012j;

    /* renamed from: k  reason: collision with root package name */
    public int f59013k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerVouchersSwimLaneRealRepository$getCustomerVouchersSwimLane$1(CustomerVouchersSwimLaneRealRepository customerVouchersSwimLaneRealRepository, Continuation<? super CustomerVouchersSwimLaneRealRepository$getCustomerVouchersSwimLane$1> continuation) {
        super(continuation);
        this.f59012j = customerVouchersSwimLaneRealRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59011i = obj;
        this.f59013k |= Integer.MIN_VALUE;
        return this.f59012j.getCustomerVouchersSwimLane((VouchersSwimLaneRequest) null, this);
    }
}
