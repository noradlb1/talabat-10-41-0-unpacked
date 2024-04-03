package com.talabat.feature.ridertips.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.ridertips.data.RiderTipRepository", f = "RiderTipRepository.kt", i = {}, l = {29}, m = "saveRiderTip", n = {}, s = {})
public final class RiderTipRepository$saveRiderTip$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f58793h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RiderTipRepository f58794i;

    /* renamed from: j  reason: collision with root package name */
    public int f58795j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipRepository$saveRiderTip$1(RiderTipRepository riderTipRepository, Continuation<? super RiderTipRepository$saveRiderTip$1> continuation) {
        super(continuation);
        this.f58794i = riderTipRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58793h = obj;
        this.f58795j |= Integer.MIN_VALUE;
        return this.f58794i.saveRiderTip((Double) null, false, this);
    }
}
