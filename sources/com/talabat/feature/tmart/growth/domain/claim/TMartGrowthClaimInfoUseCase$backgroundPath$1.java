package com.talabat.feature.tmart.growth.domain.claim;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase", f = "TMartGrowthClaimInfoUseCase.kt", i = {}, l = {42}, m = "backgroundPath-r0oKcjY", n = {}, s = {})
public final class TMartGrowthClaimInfoUseCase$backgroundPath$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f59094h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthClaimInfoUseCase f59095i;

    /* renamed from: j  reason: collision with root package name */
    public int f59096j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthClaimInfoUseCase$backgroundPath$1(TMartGrowthClaimInfoUseCase tMartGrowthClaimInfoUseCase, Continuation<? super TMartGrowthClaimInfoUseCase$backgroundPath$1> continuation) {
        super(continuation);
        this.f59095i = tMartGrowthClaimInfoUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59094h = obj;
        this.f59096j |= Integer.MIN_VALUE;
        Object r22 = this.f59095i.m10320backgroundPathr0oKcjY((String) null, this);
        return r22 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r22 : TMartGrowthFilePath.m10323boximpl((String) r22);
    }
}
