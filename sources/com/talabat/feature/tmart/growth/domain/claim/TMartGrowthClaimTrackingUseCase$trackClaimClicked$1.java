package com.talabat.feature.tmart.growth.domain.claim;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase", f = "TMartGrowthClaimTrackingUseCase.kt", i = {0}, l = {16}, m = "trackClaimClicked", n = {"this"}, s = {"L$0"})
public final class TMartGrowthClaimTrackingUseCase$trackClaimClicked$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59105h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59106i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthClaimTrackingUseCase f59107j;

    /* renamed from: k  reason: collision with root package name */
    public int f59108k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthClaimTrackingUseCase$trackClaimClicked$1(TMartGrowthClaimTrackingUseCase tMartGrowthClaimTrackingUseCase, Continuation<? super TMartGrowthClaimTrackingUseCase$trackClaimClicked$1> continuation) {
        super(continuation);
        this.f59107j = tMartGrowthClaimTrackingUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59106i = obj;
        this.f59108k |= Integer.MIN_VALUE;
        return this.f59107j.trackClaimClicked(this);
    }
}
