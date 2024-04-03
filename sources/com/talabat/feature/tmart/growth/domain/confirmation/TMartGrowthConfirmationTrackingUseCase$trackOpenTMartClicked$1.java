package com.talabat.feature.tmart.growth.domain.confirmation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase", f = "TMartGrowthConfirmationTrackingUseCase.kt", i = {0}, l = {20}, m = "trackOpenTMartClicked", n = {"this"}, s = {"L$0"})
public final class TMartGrowthConfirmationTrackingUseCase$trackOpenTMartClicked$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59128h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59129i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthConfirmationTrackingUseCase f59130j;

    /* renamed from: k  reason: collision with root package name */
    public int f59131k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthConfirmationTrackingUseCase$trackOpenTMartClicked$1(TMartGrowthConfirmationTrackingUseCase tMartGrowthConfirmationTrackingUseCase, Continuation<? super TMartGrowthConfirmationTrackingUseCase$trackOpenTMartClicked$1> continuation) {
        super(continuation);
        this.f59130j = tMartGrowthConfirmationTrackingUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59129i = obj;
        this.f59131k |= Integer.MIN_VALUE;
        return this.f59130j.trackOpenTMartClicked(this);
    }
}
