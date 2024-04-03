package com.talabat.feature.tmart.growth.presentation.sheet;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimConfirmation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel", f = "TMartGrowthBottomSheetViewModel.kt", i = {}, l = {58, 60}, m = "toState", n = {}, s = {})
public final class TMartGrowthBottomSheetViewModel$toState$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59178h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59179i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthBottomSheetViewModel f59180j;

    /* renamed from: k  reason: collision with root package name */
    public int f59181k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthBottomSheetViewModel$toState$1(TMartGrowthBottomSheetViewModel tMartGrowthBottomSheetViewModel, Continuation<? super TMartGrowthBottomSheetViewModel$toState$1> continuation) {
        super(continuation);
        this.f59180j = tMartGrowthBottomSheetViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59179i = obj;
        this.f59181k |= Integer.MIN_VALUE;
        return this.f59180j.toState((BottomSheetAction) null, (TMartGrowthClaimConfirmation) null, this);
    }
}
