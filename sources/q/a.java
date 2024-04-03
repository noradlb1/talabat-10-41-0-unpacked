package q;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;

public final /* synthetic */ class a {
    public static /* synthetic */ Modifier a(LazyItemScope lazyItemScope, Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m5587boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
            }
            return lazyItemScope.animateItemPlacement(modifier, finiteAnimationSpec);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateItemPlacement");
    }

    public static /* synthetic */ Modifier b(LazyItemScope lazyItemScope, Modifier modifier, float f11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                f11 = 1.0f;
            }
            return lazyItemScope.fillParentMaxHeight(modifier, f11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxHeight");
    }

    public static /* synthetic */ Modifier c(LazyItemScope lazyItemScope, Modifier modifier, float f11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                f11 = 1.0f;
            }
            return lazyItemScope.fillParentMaxSize(modifier, f11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxSize");
    }

    public static /* synthetic */ Modifier d(LazyItemScope lazyItemScope, Modifier modifier, float f11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                f11 = 1.0f;
            }
            return lazyItemScope.fillParentMaxWidth(modifier, f11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillParentMaxWidth");
    }
}
