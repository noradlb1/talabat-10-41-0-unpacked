package com.talabat.feature.tmart.growth.domain.confirmation;

import com.talabat.feature.tmart.growth.domain.TMartGrowthSelectedPreference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tmart.growth.domain.confirmation.TMartGrowthConfirmationTrackingUseCase", f = "TMartGrowthConfirmationTrackingUseCase.kt", i = {0, 0}, l = {15}, m = "trackPreferenceSelected", n = {"this", "preference"}, s = {"L$0", "L$1"})
public final class TMartGrowthConfirmationTrackingUseCase$trackPreferenceSelected$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59132h;

    /* renamed from: i  reason: collision with root package name */
    public Object f59133i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f59134j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthConfirmationTrackingUseCase f59135k;

    /* renamed from: l  reason: collision with root package name */
    public int f59136l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthConfirmationTrackingUseCase$trackPreferenceSelected$1(TMartGrowthConfirmationTrackingUseCase tMartGrowthConfirmationTrackingUseCase, Continuation<? super TMartGrowthConfirmationTrackingUseCase$trackPreferenceSelected$1> continuation) {
        super(continuation);
        this.f59135k = tMartGrowthConfirmationTrackingUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59134j = obj;
        this.f59136l |= Integer.MIN_VALUE;
        return this.f59135k.trackPreferenceSelected((TMartGrowthSelectedPreference) null, this);
    }
}
