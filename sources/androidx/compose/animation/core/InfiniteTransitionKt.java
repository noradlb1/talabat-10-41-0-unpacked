package androidx.compose.animation.core;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a5\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0007¢\u0006\u0002\u0010\n\u001aY\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\f0\u0004\"\u0004\b\u0000\u0010\f\"\b\b\u0001\u0010\r*\u00020\u000e*\u00020\u00012\u0006\u0010\u0006\u001a\u0002H\f2\u0006\u0010\u0007\u001a\u0002H\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r0\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\f0\tH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"rememberInfiniteTransition", "Landroidx/compose/animation/core/InfiniteTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/InfiniteTransition;", "animateFloat", "Landroidx/compose/runtime/State;", "", "initialValue", "targetValue", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "(Landroidx/compose/animation/core/InfiniteTransition;FFLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animateValue", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class InfiniteTransitionKt {
    @NotNull
    @Composable
    public static final State<Float> animateFloat(@NotNull InfiniteTransition infiniteTransition, float f11, float f12, @NotNull InfiniteRepeatableSpec<Float> infiniteRepeatableSpec, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(infiniteTransition, "<this>");
        Intrinsics.checkNotNullParameter(infiniteRepeatableSpec, "animationSpec");
        composer.startReplaceableGroup(469472752);
        State<Float> animateValue = animateValue(infiniteTransition, Float.valueOf(f11), Float.valueOf(f12), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), infiniteRepeatableSpec, composer, (i11 & 112) | 8 | (i11 & 896) | ((i11 << 3) & 57344));
        composer.endReplaceableGroup();
        return animateValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: androidx.compose.animation.core.InfiniteTransition$TransitionAnimationState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: androidx.compose.animation.core.InfiniteTransition$TransitionAnimationState} */
    /* JADX WARNING: type inference failed for: r13v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, V extends androidx.compose.animation.core.AnimationVector> androidx.compose.runtime.State<T> animateValue(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.InfiniteTransition r7, T r8, T r9, @org.jetbrains.annotations.NotNull androidx.compose.animation.core.TwoWayConverter<T, V> r10, @org.jetbrains.annotations.NotNull androidx.compose.animation.core.InfiniteRepeatableSpec<T> r11, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r12, int r13) {
        /*
            java.lang.String r13 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r13)
            java.lang.String r13 = "typeConverter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r13)
            java.lang.String r13 = "animationSpec"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r13)
            r13 = -1695411770(0xffffffff9af211c6, float:-1.0011757E-22)
            r12.startReplaceableGroup(r13)
            r13 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r13)
            java.lang.Object r13 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r13 != r0) goto L_0x0035
            androidx.compose.animation.core.InfiniteTransition$TransitionAnimationState r13 = new androidx.compose.animation.core.InfiniteTransition$TransitionAnimationState
            r1 = r13
            r2 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            r6 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            r12.updateRememberedValue(r13)
        L_0x0035:
            r12.endReplaceableGroup()
            androidx.compose.animation.core.InfiniteTransition$TransitionAnimationState r13 = (androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState) r13
            androidx.compose.animation.core.InfiniteTransitionKt$animateValue$1 r10 = new androidx.compose.animation.core.InfiniteTransitionKt$animateValue$1
            r10.<init>(r8, r13, r9, r11)
            r8 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r10, r12, r8)
            androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2 r8 = new androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2
            r8.<init>(r7, r13)
            r7 = 6
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r13, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r8, (androidx.compose.runtime.Composer) r12, (int) r7)
            r12.endReplaceableGroup()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.InfiniteTransitionKt.animateValue(androidx.compose.animation.core.InfiniteTransition, java.lang.Object, java.lang.Object, androidx.compose.animation.core.TwoWayConverter, androidx.compose.animation.core.InfiniteRepeatableSpec, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }

    @NotNull
    @Composable
    public static final InfiniteTransition rememberInfiniteTransition(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-840193660);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new InfiniteTransition();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        InfiniteTransition infiniteTransition = (InfiniteTransition) rememberedValue;
        infiniteTransition.run$animation_core_release(composer, 8);
        composer.endReplaceableGroup();
        return infiniteTransition;
    }
}
