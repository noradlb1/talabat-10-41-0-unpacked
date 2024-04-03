package r;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;

public final /* synthetic */ class a {
    public static /* synthetic */ Modifier a(LazyGridItemScope lazyGridItemScope, Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5587boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
            }
            return lazyGridItemScope.animateItemPlacement(modifier, finiteAnimationSpec);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateItemPlacement");
    }
}
