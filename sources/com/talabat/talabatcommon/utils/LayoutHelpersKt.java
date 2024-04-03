package com.talabat.talabatcommon.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"removeConstraint", "", "constraintLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "viewId", "", "constraint", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LayoutHelpersKt {
    public static final void removeConstraint(@NotNull ConstraintLayout constraintLayout, int i11, int i12) {
        Intrinsics.checkNotNullParameter(constraintLayout, "constraintLayout");
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.clear(i11, i12);
        constraintSet.applyTo(constraintLayout);
    }
}
