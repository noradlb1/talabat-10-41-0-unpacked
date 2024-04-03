package com.talabat.feature.tmart.growth.presentation.sheet;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel", f = "TMartGrowthBottomSheetViewModel.kt", i = {0}, l = {64, 65}, m = "trackOpenTMart", n = {"this"}, s = {"L$0"})
public final class TMartGrowthBottomSheetViewModel$trackOpenTMart$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59182h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59183i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthBottomSheetViewModel f59184j;

    /* renamed from: k  reason: collision with root package name */
    public int f59185k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthBottomSheetViewModel$trackOpenTMart$1(TMartGrowthBottomSheetViewModel tMartGrowthBottomSheetViewModel, Continuation<? super TMartGrowthBottomSheetViewModel$trackOpenTMart$1> continuation) {
        super(continuation);
        this.f59184j = tMartGrowthBottomSheetViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59183i = obj;
        this.f59185k |= Integer.MIN_VALUE;
        return this.f59184j.trackOpenTMart(this);
    }
}
