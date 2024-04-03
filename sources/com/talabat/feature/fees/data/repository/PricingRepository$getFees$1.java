package com.talabat.feature.fees.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.fees.data.repository.PricingRepository", f = "PricingRepository.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1}, l = {34, 38, 53}, m = "getFees", n = {"this", "subtotalBeforeDiscounts", "subtotal", "couponDiscount", "cacheKey", "latitude", "longitude", "forceUpdate", "cachedFees"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "D$0", "D$1", "Z$0", "L$0"})
public final class PricingRepository$getFees$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f58513h;

    /* renamed from: i  reason: collision with root package name */
    public Object f58514i;

    /* renamed from: j  reason: collision with root package name */
    public Object f58515j;

    /* renamed from: k  reason: collision with root package name */
    public Object f58516k;

    /* renamed from: l  reason: collision with root package name */
    public Object f58517l;

    /* renamed from: m  reason: collision with root package name */
    public double f58518m;

    /* renamed from: n  reason: collision with root package name */
    public double f58519n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f58520o;

    /* renamed from: p  reason: collision with root package name */
    public /* synthetic */ Object f58521p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ PricingRepository f58522q;

    /* renamed from: r  reason: collision with root package name */
    public int f58523r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PricingRepository$getFees$1(PricingRepository pricingRepository, Continuation<? super PricingRepository$getFees$1> continuation) {
        super(continuation);
        this.f58522q = pricingRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f58521p = obj;
        this.f58523r |= Integer.MIN_VALUE;
        return this.f58522q.getFees(0.0d, 0.0d, (Float) null, (Float) null, (Float) null, false, this);
    }
}
