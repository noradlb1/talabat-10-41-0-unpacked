package com.talabat.feature.ridertips.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.ridertips.data.RiderTipRepository", f = "RiderTipRepository.kt", i = {0}, l = {21}, m = "getRiderTip", n = {"$this$getRiderTip_u24lambda_u2d0"}, s = {"L$0"})
public final class RiderTipRepository$getRiderTip$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58789h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f58790i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RiderTipRepository f58791j;

    /* renamed from: k  reason: collision with root package name */
    public int f58792k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipRepository$getRiderTip$1(RiderTipRepository riderTipRepository, Continuation<? super RiderTipRepository$getRiderTip$1> continuation) {
        super(continuation);
        this.f58791j = riderTipRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58790i = obj;
        this.f58792k |= Integer.MIN_VALUE;
        return this.f58791j.getRiderTip(this);
    }
}
