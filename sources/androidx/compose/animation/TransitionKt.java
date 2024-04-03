package androidx.compose.animation;

import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2*\b\n\u0010\f\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\r¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132&\u0010\u0014\u001a\"\u0012\u0013\u0012\u0011H\n¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0002\b\u0010H\bø\u0001\u0000ø\u0001\u0002¢\u0006\u0002\u0010\u0018\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006\u0019"}, d2 = {"animateColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/InfiniteTransition;", "initialValue", "targetValue", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "animateColor-RIQooxk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "S", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "label", "", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TransitionKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[0[0][0]]")
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <S> androidx.compose.runtime.State<androidx.compose.ui.graphics.Color> animateColor(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.Transition<S> r8, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.animation.core.Transition.Segment<S>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, ? extends androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.graphics.Color>> r9, @org.jetbrains.annotations.Nullable java.lang.String r10, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.ui.graphics.Color> r11, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r12, int r13, int r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "targetValueByState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -1939694975(0xffffffff8c629a81, float:-1.7456901E-31)
            r12.startReplaceableGroup(r0)
            r0 = r14 & 1
            if (r0 == 0) goto L_0x0016
            androidx.compose.animation.TransitionKt$animateColor$1 r9 = androidx.compose.animation.TransitionKt$animateColor$1.INSTANCE
        L_0x0016:
            r14 = r14 & 2
            if (r14 == 0) goto L_0x001c
            java.lang.String r10 = "ColorAnimation"
        L_0x001c:
            r5 = r10
            java.lang.Object r10 = r8.getTargetState()
            int r14 = r13 >> 6
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            java.lang.Object r10 = r11.invoke(r10, r12, r14)
            androidx.compose.ui.graphics.Color r10 = (androidx.compose.ui.graphics.Color) r10
            long r0 = r10.m2929unboximpl()
            androidx.compose.ui.graphics.colorspace.ColorSpace r10 = androidx.compose.ui.graphics.Color.m2923getColorSpaceimpl(r0)
            r14 = 1157296644(0x44faf204, float:2007.563)
            r12.startReplaceableGroup(r14)
            boolean r14 = r12.changed((java.lang.Object) r10)
            java.lang.Object r0 = r12.rememberedValue()
            if (r14 != 0) goto L_0x004f
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r0 != r14) goto L_0x005f
        L_0x004f:
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r14 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r14)
            java.lang.Object r10 = r14.invoke(r10)
            r0 = r10
            androidx.compose.animation.core.TwoWayConverter r0 = (androidx.compose.animation.core.TwoWayConverter) r0
            r12.updateRememberedValue(r0)
        L_0x005f:
            r12.endReplaceableGroup()
            r4 = r0
            androidx.compose.animation.core.TwoWayConverter r4 = (androidx.compose.animation.core.TwoWayConverter) r4
            r10 = r13 & 14
            r10 = r10 | 64
            int r13 = r13 << 3
            r14 = r13 & 896(0x380, float:1.256E-42)
            r10 = r10 | r14
            r14 = r13 & 7168(0x1c00, float:1.0045E-41)
            r10 = r10 | r14
            r14 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r14
            r10 = r10 | r13
            r13 = -142660079(0xfffffffff77f2e11, float:-5.1756642E33)
            r12.startReplaceableGroup(r13)
            java.lang.Object r13 = r8.getCurrentState()
            int r0 = r10 >> 9
            r0 = r0 & 112(0x70, float:1.57E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Object r1 = r11.invoke(r13, r12, r1)
            java.lang.Object r13 = r8.getTargetState()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r2 = r11.invoke(r13, r12, r0)
            androidx.compose.animation.core.Transition$Segment r11 = r8.getSegment()
            int r13 = r10 >> 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.Object r9 = r9.invoke(r11, r12, r13)
            r3 = r9
            androidx.compose.animation.core.FiniteAnimationSpec r3 = (androidx.compose.animation.core.FiniteAnimationSpec) r3
            r9 = r10 & 14
            int r11 = r10 << 9
            r11 = r11 & r14
            r9 = r9 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            int r10 = r10 << 6
            r10 = r10 & r11
            r7 = r9 | r10
            r0 = r8
            r6 = r12
            androidx.compose.runtime.State r8 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            r12.endReplaceableGroup()
            r12.endReplaceableGroup()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.TransitionKt.animateColor(androidx.compose.animation.core.Transition, kotlin.jvm.functions.Function3, java.lang.String, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):androidx.compose.runtime.State");
    }

    @NotNull
    @Composable
    /* renamed from: animateColor-RIQooxk  reason: not valid java name */
    public static final State<Color> m99animateColorRIQooxk(@NotNull InfiniteTransition infiniteTransition, long j11, long j12, @NotNull InfiniteRepeatableSpec<Color> infiniteRepeatableSpec, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(infiniteTransition, "$this$animateColor");
        Intrinsics.checkNotNullParameter(infiniteRepeatableSpec, "animationSpec");
        composer.startReplaceableGroup(1400583834);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.m2923getColorSpaceimpl(j12));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        InfiniteTransition infiniteTransition2 = infiniteTransition;
        State<Color> animateValue = InfiniteTransitionKt.animateValue(infiniteTransition2, Color.m2909boximpl(j11), Color.m2909boximpl(j12), (TwoWayConverter) rememberedValue, infiniteRepeatableSpec, composer, InfiniteTransition.$stable | 4096 | (i11 & 14) | (i11 & 112) | (i11 & 896) | (InfiniteRepeatableSpec.$stable << 12) | ((i11 << 3) & 57344));
        composer.endReplaceableGroup();
        return animateValue;
    }
}
