package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001aY\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032:\b\u0002\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"animateContentSize", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "finishedListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "initialValue", "targetValue", "", "animation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AnimationModifierKt {
    @NotNull
    public static final Modifier animateContentSize(@NotNull Modifier modifier, @NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, @Nullable Function2<? super IntSize, ? super IntSize, Unit> function2) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new AnimationModifierKt$animateContentSize$$inlined$debugInspectorInfo$1(finiteAnimationSpec, function2);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new AnimationModifierKt$animateContentSize$2(function2, finiteAnimationSpec));
    }

    public static /* synthetic */ Modifier animateContentSize$default(Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, Function2 function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        }
        if ((i11 & 2) != 0) {
            function2 = null;
        }
        return animateContentSize(modifier, finiteAnimationSpec, function2);
    }
}
