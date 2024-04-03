package com.talabat.feature.tmart.growth.presentation.sheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TMartGrowthBottomSheet$showAnimation$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public TMartGrowthBottomSheet$showAnimation$1(Object obj) {
        super(0, obj, TMartGrowthBottomSheetViewModel.class, "onAnimationEnd", "onAnimationEnd()V", 0);
    }

    public final void invoke() {
        ((TMartGrowthBottomSheetViewModel) this.receiver).onAnimationEnd();
    }
}
