package com.talabat.feature.tmart.growth.domain.claim;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimTrackingUseCase", f = "TMartGrowthClaimTrackingUseCase.kt", i = {0}, l = {27}, m = "trackHomeWidgetShown", n = {"this"}, s = {"L$0"})
public final class TMartGrowthClaimTrackingUseCase$trackHomeWidgetShown$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59109h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59110i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthClaimTrackingUseCase f59111j;

    /* renamed from: k  reason: collision with root package name */
    public int f59112k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthClaimTrackingUseCase$trackHomeWidgetShown$1(TMartGrowthClaimTrackingUseCase tMartGrowthClaimTrackingUseCase, Continuation<? super TMartGrowthClaimTrackingUseCase$trackHomeWidgetShown$1> continuation) {
        super(continuation);
        this.f59111j = tMartGrowthClaimTrackingUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59110i = obj;
        this.f59112k |= Integer.MIN_VALUE;
        return this.f59111j.trackHomeWidgetShown(this);
    }
}
