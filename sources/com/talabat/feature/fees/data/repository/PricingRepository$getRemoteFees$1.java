package com.talabat.feature.fees.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.fees.data.repository.PricingRepository", f = "PricingRepository.kt", i = {0, 0}, l = {75, 89}, m = "getRemoteFees", n = {"this", "cacheKey"}, s = {"L$0", "L$1"})
public final class PricingRepository$getRemoteFees$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58524h;

    /* renamed from: i  reason: collision with root package name */
    public Object f58525i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f58526j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PricingRepository f58527k;

    /* renamed from: l  reason: collision with root package name */
    public int f58528l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PricingRepository$getRemoteFees$1(PricingRepository pricingRepository, Continuation<? super PricingRepository$getRemoteFees$1> continuation) {
        super(continuation);
        this.f58527k = pricingRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58526j = obj;
        this.f58528l |= Integer.MIN_VALUE;
        return this.f58527k.getRemoteFees(0.0d, 0.0d, (Float) null, (Float) null, (Float) null, (String) null, this);
    }
}
