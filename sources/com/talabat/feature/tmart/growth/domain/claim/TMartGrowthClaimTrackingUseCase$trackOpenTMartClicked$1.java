package com.talabat.feature.tmart.growth.domain.claim;

import com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase", f = "TMartGrowthClaimTrackingUseCase.kt", i = {0, 0}, l = {33}, m = "trackOpenTMartClicked", n = {"this", "screenType"}, s = {"L$0", "L$1"})
public final class TMartGrowthClaimTrackingUseCase$trackOpenTMartClicked$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59113h;

    /* renamed from: i  reason: collision with root package name */
    public Object f59114i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f59115j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthClaimTrackingUseCase f59116k;

    /* renamed from: l  reason: collision with root package name */
    public int f59117l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthClaimTrackingUseCase$trackOpenTMartClicked$1(TMartGrowthClaimTrackingUseCase tMartGrowthClaimTrackingUseCase, Continuation<? super TMartGrowthClaimTrackingUseCase$trackOpenTMartClicked$1> continuation) {
        super(continuation);
        this.f59116k = tMartGrowthClaimTrackingUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59115j = obj;
        this.f59117l |= Integer.MIN_VALUE;
        return this.f59116k.trackOpenTMartClicked((TMartGrowthScreenType) null, this);
    }
}
