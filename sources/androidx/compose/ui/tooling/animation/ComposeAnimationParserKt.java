package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimation;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¨\u0006\u0004"}, d2 = {"parse", "Landroidx/compose/animation/tooling/ComposeAnimation;", "Landroidx/compose/animation/core/Transition;", "", "ui-tooling_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ComposeAnimationParserKt {
    @NotNull
    public static final ComposeAnimation parse(@NotNull Transition<Object> transition) {
        Set set;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Object initialState = transition.getSegment().getInitialState();
        Object[] enumConstants = initialState.getClass().getEnumConstants();
        if (enumConstants == null) {
            set = null;
        } else {
            set = ArraysKt___ArraysKt.toSet((T[]) enumConstants);
        }
        if (set == null) {
            set = SetsKt__SetsJVMKt.setOf(initialState);
        }
        String label = transition.getLabel();
        if (label == null) {
            label = Reflection.getOrCreateKotlinClass(initialState.getClass()).getSimpleName();
        }
        return new ComposeAnimationParserKt$parse$1(transition, set, label);
    }
}
