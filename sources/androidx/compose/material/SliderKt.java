package androidx.compose.material;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.Strings;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlinx.coroutines.CoroutineScope;
import net.bytebuddy.jar.asm.Opcodes;
import o.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aS\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010\u001a\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u001b\u001a\u0010\u001c\u001a\u00020\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0018\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0016\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010\"\u001a\u00020#2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020'H\u0007¢\u0006\u0002\u0010(\u001ak\u0010)\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0-2\u0006\u0010&\u001a\u00020'2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00104\u001a}\u00105\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\b2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\b\b\u0002\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010\"\u001a\u00020#2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010%2\b\b\u0002\u00106\u001a\u0002002\b\b\u0002\u0010&\u001a\u00020'H\u0007¢\u0006\u0002\u00107\u001aK\u00108\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u00109\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0-2\u0006\u0010&\u001a\u00020'2\u0006\u0010.\u001a\u00020\b2\u0006\u00106\u001a\u0002002\u0006\u0010\u001f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010:\u001aS\u0010;\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020!2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0-2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\bH\u0003¢\u0006\u0002\u0010>\u001a1\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010E\u001a \u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\b2\u0006\u0010I\u001a\u00020\bH\u0002\u001a0\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\bH\u0002\u001a<\u0010J\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\bH\u0002\u001a.\u0010Q\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0-2\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\bH\u0002\u001a\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00020\b0-2\u0006\u0010\"\u001a\u00020#H\u0002\u001aI\u0010U\u001a\u00020\u0012*\u00020V2\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010W\u001a\u00020\u00032\u0006\u00106\u001a\u0002002\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020!2\u0006\u0010X\u001a\u00020\u0003H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bY\u0010Z\u001a;\u0010[\u001a\u0010\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020\b\u0018\u00010\\*\u00020^2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020bH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bc\u0010d\u001a\u0001\u0010e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\f\u0010f\u001a\b\u0012\u0004\u0012\u00020\b0g2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\b0g2\u0006\u0010 \u001a\u00020!2\u0006\u0010i\u001a\u00020!2\u0006\u0010S\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0018\u0010j\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00120\u00140g2\u001e\u0010k\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120l0gH\u0002\u001aX\u0010m\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0-2\u0006\u0010 \u001a\u00020!2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010\"\u001a\u00020#H\u0002\u001aj\u0010n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010@\u001a\u00020A2\u0006\u00106\u001a\u0002002\u0006\u0010S\u001a\u00020\b2\u0006\u0010i\u001a\u00020!2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\b0g2\u0018\u0010j\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00120\u00140g2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u0010 \u001a\u00020!H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\f\u0010\r\"\u0013\u0010\u000e\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\r\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006q"}, d2 = {"DefaultSliderConstraints", "Landroidx/compose/ui/Modifier;", "SliderHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SliderMinWidth", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "", "ThumbDefaultElevation", "ThumbPressedElevation", "ThumbRadius", "getThumbRadius", "()F", "ThumbRippleRadius", "TrackHeight", "getTrackHeight", "CorrectValueSideEffect", "", "scaleToOffset", "Lkotlin/Function1;", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "trackRange", "valueState", "Landroidx/compose/runtime/MutableState;", "value", "(Lkotlin/jvm/functions/Function1;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/MutableState;FLandroidx/compose/runtime/Composer;I)V", "RangeSlider", "values", "onValueChange", "modifier", "enabled", "", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material/SliderColors;", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "positionFractionStart", "positionFractionEnd", "tickFractions", "", "width", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumbSemantics", "endThumbSemantics", "(ZFFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Slider", "interactionSource", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "positionFraction", "(ZFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Track", "thumbPx", "trackStrokeWidth", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SliderColors;ZFFLjava/util/List;FFLandroidx/compose/runtime/Composer;I)V", "animateToTarget", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "current", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x1", "a2", "b2", "x", "snapValueToTick", "minPx", "maxPx", "stepsToTickFractions", "SliderThumb", "Landroidx/compose/foundation/layout/BoxScope;", "offset", "thumbSize", "SliderThumb-PcYyNuk", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;ZFLandroidx/compose/runtime/Composer;I)V", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "Landroidx/compose/runtime/State;", "rawOffsetEnd", "isRtl", "gestureEndAction", "onDrag", "Lkotlin/Function2;", "sliderSemantics", "sliderTapModifier", "rawOffset", "pressOffset", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SliderKt {
    @NotNull
    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;
    /* access modifiers changed from: private */
    @NotNull
    public static final TweenSpec<Float> SliderToTickAnimation = new TweenSpec(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float ThumbDefaultElevation = Dp.m5478constructorimpl((float) 1);
    private static final float ThumbPressedElevation = Dp.m5478constructorimpl((float) 6);
    private static final float ThumbRadius = Dp.m5478constructorimpl((float) 10);
    private static final float ThumbRippleRadius = Dp.m5478constructorimpl((float) 24);
    private static final float TrackHeight = Dp.m5478constructorimpl((float) 4);

    static {
        float r12 = Dp.m5478constructorimpl((float) 48);
        SliderHeight = r12;
        float r22 = Dp.m5478constructorimpl((float) Opcodes.D2F);
        SliderMinWidth = r22;
        DefaultSliderConstraints = SizeKt.m546heightInVpY3zN4$default(SizeKt.m565widthInVpY3zN4$default(Modifier.Companion, r22, 0.0f, 2, (Object) null), 0.0f, r12, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00af, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x00b1;
     */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CorrectValueSideEffect(kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float> r15, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r16, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r17, androidx.compose.runtime.MutableState<java.lang.Float> r18, float r19, androidx.compose.runtime.Composer r20, int r21) {
        /*
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r21
            r0 = -743965752(0xffffffffd3a7fbc8, float:-1.44296745E12)
            r1 = r20
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r10 & 14
            r1 = 4
            r2 = 2
            if (r0 != 0) goto L_0x0023
            boolean r0 = r11.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0020
            r0 = r1
            goto L_0x0021
        L_0x0020:
            r0 = r2
        L_0x0021:
            r0 = r0 | r10
            goto L_0x0024
        L_0x0023:
            r0 = r10
        L_0x0024:
            r3 = r10 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0034
            boolean r3 = r11.changed((java.lang.Object) r7)
            if (r3 == 0) goto L_0x0031
            r3 = 32
            goto L_0x0033
        L_0x0031:
            r3 = 16
        L_0x0033:
            r0 = r0 | r3
        L_0x0034:
            r3 = r10 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0044
            boolean r3 = r11.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x0041
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0043
        L_0x0041:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0043:
            r0 = r0 | r3
        L_0x0044:
            r3 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0054
            boolean r3 = r11.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x0051
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0053
        L_0x0051:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0053:
            r0 = r0 | r3
        L_0x0054:
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r10
            r12 = r19
            if (r3 != 0) goto L_0x0068
            boolean r3 = r11.changed((float) r12)
            if (r3 == 0) goto L_0x0065
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0067
        L_0x0065:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x0067:
            r0 = r0 | r3
        L_0x0068:
            r3 = 46811(0xb6db, float:6.5596E-41)
            r0 = r0 & r3
            r3 = 9362(0x2492, float:1.3119E-41)
            if (r0 != r3) goto L_0x007b
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0077
            goto L_0x007b
        L_0x0077:
            r11.skipToGroupEnd()
            goto L_0x00cb
        L_0x007b:
            r0 = 5
            java.lang.Object[] r3 = new java.lang.Object[r0]
            r13 = 0
            r3[r13] = r7
            r4 = 1
            r3[r4] = r6
            java.lang.Float r4 = java.lang.Float.valueOf(r19)
            r3[r2] = r4
            r2 = 3
            r3[r2] = r9
            r3[r1] = r8
            r1 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r11.startReplaceableGroup(r1)
            r1 = r13
            r2 = r1
        L_0x0097:
            if (r1 >= r0) goto L_0x00a3
            r4 = r3[r1]
            boolean r4 = r11.changed((java.lang.Object) r4)
            r2 = r2 | r4
            int r1 = r1 + 1
            goto L_0x0097
        L_0x00a3:
            java.lang.Object r0 = r11.rememberedValue()
            if (r2 != 0) goto L_0x00b1
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x00c3
        L_0x00b1:
            androidx.compose.material.SliderKt$CorrectValueSideEffect$1$1 r14 = new androidx.compose.material.SliderKt$CorrectValueSideEffect$1$1
            r0 = r14
            r1 = r16
            r2 = r15
            r3 = r19
            r4 = r18
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            r11.updateRememberedValue(r14)
        L_0x00c3:
            r11.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r11, r13)
        L_0x00cb:
            androidx.compose.runtime.ScopeUpdateScope r11 = r11.endRestartGroup()
            if (r11 != 0) goto L_0x00d2
            goto L_0x00e6
        L_0x00d2:
            androidx.compose.material.SliderKt$CorrectValueSideEffect$2 r13 = new androidx.compose.material.SliderKt$CorrectValueSideEffect$2
            r0 = r13
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.updateScope(r13)
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.CorrectValueSideEffect(kotlin.jvm.functions.Function1, kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedFloatingPointRange, androidx.compose.runtime.MutableState, float, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0119  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RangeSlider(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r42, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit> r43, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r44, boolean r45, @org.jetbrains.annotations.Nullable kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r46, int r47, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r48, @org.jetbrains.annotations.Nullable androidx.compose.material.SliderColors r49, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r50, int r51, int r52) {
        /*
            r12 = r42
            r13 = r43
            r14 = r51
            r15 = r52
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -1556183027(0xffffffffa33e880d, float:-1.03287305E-17)
            r1 = r50
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r15 & 1
            if (r0 == 0) goto L_0x0022
            r0 = r14 | 6
            goto L_0x0032
        L_0x0022:
            r0 = r14 & 14
            if (r0 != 0) goto L_0x0031
            boolean r0 = r11.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x002e
            r0 = 4
            goto L_0x002f
        L_0x002e:
            r0 = 2
        L_0x002f:
            r0 = r0 | r14
            goto L_0x0032
        L_0x0031:
            r0 = r14
        L_0x0032:
            r3 = r15 & 2
            if (r3 == 0) goto L_0x0039
            r0 = r0 | 48
            goto L_0x0049
        L_0x0039:
            r3 = r14 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0049
            boolean r3 = r11.changed((java.lang.Object) r13)
            if (r3 == 0) goto L_0x0046
            r3 = 32
            goto L_0x0048
        L_0x0046:
            r3 = 16
        L_0x0048:
            r0 = r0 | r3
        L_0x0049:
            r3 = r15 & 4
            if (r3 == 0) goto L_0x0050
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r4 = r14 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0063
            r4 = r44
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005f
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r0 = r0 | r5
            goto L_0x0065
        L_0x0063:
            r4 = r44
        L_0x0065:
            r5 = r15 & 8
            if (r5 == 0) goto L_0x006c
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x007f
            r6 = r45
            boolean r7 = r11.changed((boolean) r6)
            if (r7 == 0) goto L_0x007b
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r0 = r0 | r7
            goto L_0x0081
        L_0x007f:
            r6 = r45
        L_0x0081:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r14
            if (r7 != 0) goto L_0x009c
            r7 = r15 & 16
            if (r7 != 0) goto L_0x0096
            r7 = r46
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0098
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0096:
            r7 = r46
        L_0x0098:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r0 = r0 | r8
            goto L_0x009e
        L_0x009c:
            r7 = r46
        L_0x009e:
            r8 = r15 & 32
            if (r8 == 0) goto L_0x00a6
            r9 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r9
            goto L_0x00ba
        L_0x00a6:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r14
            if (r9 != 0) goto L_0x00ba
            r9 = r47
            boolean r10 = r11.changed((int) r9)
            if (r10 == 0) goto L_0x00b6
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r0 = r0 | r10
            goto L_0x00bc
        L_0x00ba:
            r9 = r47
        L_0x00bc:
            r10 = r15 & 64
            if (r10 == 0) goto L_0x00c7
            r16 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r16
            r2 = r48
            goto L_0x00dc
        L_0x00c7:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r14 & r16
            r2 = r48
            if (r16 != 0) goto L_0x00dc
            boolean r16 = r11.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x00d8
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r0 = r0 | r16
        L_0x00dc:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r14 & r16
            if (r16 != 0) goto L_0x00f8
            r1 = r15 & 128(0x80, float:1.794E-43)
            if (r1 != 0) goto L_0x00f1
            r1 = r49
            boolean r16 = r11.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x00f3
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f5
        L_0x00f1:
            r1 = r49
        L_0x00f3:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f5:
            r0 = r0 | r16
            goto L_0x00fa
        L_0x00f8:
            r1 = r49
        L_0x00fa:
            r16 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r0 & r16
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r2) goto L_0x0119
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x010b
            goto L_0x0119
        L_0x010b:
            r11.skipToGroupEnd()
            r8 = r49
            r3 = r4
            r4 = r6
            r5 = r7
            r6 = r9
            r14 = r11
            r7 = r48
            goto L_0x0279
        L_0x0119:
            r11.startDefaults()
            r1 = r14 & 1
            r2 = 0
            r41 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r12 = 1
            if (r1 == 0) goto L_0x014d
            boolean r1 = r11.getDefaultsInvalid()
            if (r1 == 0) goto L_0x012f
            goto L_0x014d
        L_0x012f:
            r11.skipToGroupEnd()
            r1 = r15 & 16
            if (r1 == 0) goto L_0x0138
            r0 = r0 & r16
        L_0x0138:
            r1 = r15 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x013e
            r0 = r0 & r41
        L_0x013e:
            r20 = r48
            r21 = r49
            r3 = r0
            r16 = r4
            r17 = r6
            r18 = r7
            r19 = r9
            goto L_0x01a9
        L_0x014d:
            if (r3 == 0) goto L_0x0152
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0153
        L_0x0152:
            r1 = r4
        L_0x0153:
            if (r5 == 0) goto L_0x0156
            r6 = r12
        L_0x0156:
            r3 = r15 & 16
            if (r3 == 0) goto L_0x0164
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r3 = kotlin.ranges.RangesKt__RangesKt.rangeTo((float) r3, (float) r4)
            r0 = r0 & r16
            r7 = r3
        L_0x0164:
            if (r8 == 0) goto L_0x0167
            r9 = r2
        L_0x0167:
            if (r10 == 0) goto L_0x016b
            r3 = 0
            goto L_0x016d
        L_0x016b:
            r3 = r48
        L_0x016d:
            r4 = r15 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x019c
            androidx.compose.material.SliderDefaults r16 = androidx.compose.material.SliderDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r38 = 0
            r39 = 6
            r40 = 1023(0x3ff, float:1.434E-42)
            r37 = r11
            androidx.compose.material.SliderColors r4 = r16.m1357colorsq0g_0yA(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r39, r40)
            r0 = r0 & r41
            r16 = r1
            r20 = r3
            r21 = r4
            goto L_0x01a2
        L_0x019c:
            r21 = r49
            r16 = r1
            r20 = r3
        L_0x01a2:
            r17 = r6
            r18 = r7
            r19 = r9
            r3 = r0
        L_0x01a9:
            r11.endDefaults()
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r0)
            java.lang.Object r1 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r4.getEmpty()
            if (r1 != r5) goto L_0x01c5
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r1)
        L_0x01c5:
            r11.endReplaceableGroup()
            r5 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            r11.startReplaceableGroup(r0)
            java.lang.Object r0 = r11.rememberedValue()
            java.lang.Object r1 = r4.getEmpty()
            if (r0 != r1) goto L_0x01df
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r0)
        L_0x01df:
            r11.endReplaceableGroup()
            r6 = r0
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = (androidx.compose.foundation.interaction.MutableInteractionSource) r6
            if (r19 < 0) goto L_0x01e8
            r2 = r12
        L_0x01e8:
            if (r2 == 0) goto L_0x0292
            int r0 = r3 >> 3
            r0 = r0 & 14
            androidx.compose.runtime.State r7 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r13, r11, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r19)
            r1 = 1157296644(0x44faf204, float:2007.563)
            r11.startReplaceableGroup(r1)
            boolean r0 = r11.changed((java.lang.Object) r0)
            java.lang.Object r1 = r11.rememberedValue()
            if (r0 != 0) goto L_0x020c
            java.lang.Object r0 = r4.getEmpty()
            if (r1 != r0) goto L_0x0213
        L_0x020c:
            java.util.List r1 = stepsToTickFractions(r19)
            r11.updateRememberedValue(r1)
        L_0x0213:
            r11.endReplaceableGroup()
            r8 = r1
            java.util.List r8 = (java.util.List) r8
            androidx.compose.ui.Modifier r22 = androidx.compose.material.TouchTargetKt.minimumTouchTargetSize(r16)
            float r0 = ThumbRadius
            r1 = 4
            float r1 = (float) r1
            float r1 = r1 * r0
            float r23 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            r1 = 2
            float r1 = (float) r1
            float r0 = r0 * r1
            float r24 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r0)
            r25 = 0
            r26 = 0
            r27 = 12
            r28 = 0
            androidx.compose.ui.Modifier r22 = androidx.compose.foundation.layout.SizeKt.m554requiredSizeInqDBjuR0$default(r22, r23, r24, r25, r26, r27, r28)
            r23 = 0
            r24 = 0
            androidx.compose.material.SliderKt$RangeSlider$2 r10 = new androidx.compose.material.SliderKt$RangeSlider$2
            r0 = r10
            r1 = r18
            r2 = r42
            r4 = r7
            r7 = r17
            r9 = r19
            r13 = r10
            r10 = r21
            r14 = r11
            r11 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = 652589923(0x26e5bb63, float:1.5940858E-15)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r0, r12, r13)
            r1 = 3072(0xc00, float:4.305E-42)
            r2 = 6
            r44 = r22
            r45 = r23
            r46 = r24
            r47 = r0
            r48 = r14
            r49 = r1
            r50 = r2
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r44, r45, r46, r47, r48, r49, r50)
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
        L_0x0279:
            androidx.compose.runtime.ScopeUpdateScope r11 = r14.endRestartGroup()
            if (r11 != 0) goto L_0x0280
            goto L_0x0291
        L_0x0280:
            androidx.compose.material.SliderKt$RangeSlider$3 r12 = new androidx.compose.material.SliderKt$RangeSlider$3
            r0 = r12
            r1 = r42
            r2 = r43
            r9 = r51
            r10 = r52
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.updateScope(r12)
        L_0x0291:
            return
        L_0x0292:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "steps should be >= 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.RangeSlider(kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RangeSliderImpl(boolean z11, float f11, float f12, List<Float> list, SliderColors sliderColors, float f13, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Modifier modifier, Modifier modifier2, Modifier modifier3, Composer composer, int i11, int i12) {
        Composer startRestartGroup = composer.startRestartGroup(-278895713);
        Strings.Companion companion = Strings.Companion;
        String r11 = Strings_androidKt.m1382getString4foXLRw(companion.m1381getSliderRangeStartUdPEhr4(), startRestartGroup, 6);
        String r12 = Strings_androidKt.m1382getString4foXLRw(companion.m1380getSliderRangeEndUdPEhr4(), startRestartGroup, 6);
        Modifier then = modifier.then(DefaultSliderConstraints);
        startRestartGroup.startReplaceableGroup(733328855);
        Alignment.Companion companion2 = Alignment.Companion;
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(then);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r92 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r92, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m2543setimpl(r92, density, companion3.getSetDensity());
        Updater.m2543setimpl(r92, layoutDirection, companion3.getSetLayoutDirection());
        Updater.m2543setimpl(r92, viewConfiguration, companion3.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        startRestartGroup.startReplaceableGroup(2044256857);
        Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        float r82 = density2.m5447toPx0680j_4(TrackHeight);
        float f14 = ThumbRadius;
        float r72 = density2.m5447toPx0680j_4(f14);
        float r13 = density2.m5443toDpu2uoSUM(f13);
        Unit unit = Unit.INSTANCE;
        float r16 = Dp.m5478constructorimpl(f14 * ((float) 2));
        float r17 = Dp.m5478constructorimpl(r13 * f11);
        float r18 = Dp.m5478constructorimpl(r13 * f12);
        Modifier.Companion companion4 = Modifier.Companion;
        int i13 = i11 >> 9;
        int i14 = i11 << 6;
        int i15 = i13;
        String str = r12;
        Modifier.Companion companion5 = companion4;
        Track(SizeKt.fillMaxSize$default(boxScopeInstance.align(companion4, companion2.getCenterStart()), 0.0f, 1, (Object) null), sliderColors, z11, f11, f12, list, r72, r82, startRestartGroup, (i13 & 112) | 262144 | (i14 & 896) | (i14 & 7168) | (i14 & 57344));
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed((Object) r11);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new SliderKt$RangeSliderImpl$1$2$1(r11);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        Modifier then2 = FocusableKt.focusable(SemanticsModifierKt.semantics(companion5, true, (Function1) rememberedValue), true, mutableInteractionSource).then(modifier2);
        int i16 = i11 & 57344;
        int i17 = (i11 << 15) & Opcodes.ASM7;
        m1358SliderThumbPcYyNuk(boxScopeInstance, then2, r17, mutableInteractionSource, sliderColors, z11, r16, startRestartGroup, (i15 & 7168) | 1572870 | i16 | i17);
        startRestartGroup.startReplaceableGroup(1157296644);
        String str2 = str;
        boolean changed2 = startRestartGroup.changed((Object) str2);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new SliderKt$RangeSliderImpl$1$3$1(str2);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        m1358SliderThumbPcYyNuk(boxScopeInstance, FocusableKt.focusable(SemanticsModifierKt.semantics(companion5, true, (Function1) rememberedValue2), true, mutableInteractionSource2).then(modifier3), r18, mutableInteractionSource2, sliderColors, z11, r16, startRestartGroup, ((i11 >> 12) & 7168) | 1572870 | i16 | i17);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$RangeSliderImpl$2(z11, f11, f12, list, sliderColors, f13, mutableInteractionSource, mutableInteractionSource2, modifier, modifier2, modifier3, i11, i12));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0117  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Slider(float r39, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r40, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r41, boolean r42, @org.jetbrains.annotations.Nullable kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r43, int r44, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r45, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r46, @org.jetbrains.annotations.Nullable androidx.compose.material.SliderColors r47, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r48, int r49, int r50) {
        /*
            r2 = r40
            r10 = r49
            r11 = r50
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = -1962335196(0xffffffff8b092424, float:-2.641243E-32)
            r1 = r48
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r11 & 1
            if (r1 == 0) goto L_0x001e
            r1 = r10 | 6
            r4 = r1
            r1 = r39
            goto L_0x0032
        L_0x001e:
            r1 = r10 & 14
            if (r1 != 0) goto L_0x002f
            r1 = r39
            boolean r4 = r0.changed((float) r1)
            if (r4 == 0) goto L_0x002c
            r4 = 4
            goto L_0x002d
        L_0x002c:
            r4 = 2
        L_0x002d:
            r4 = r4 | r10
            goto L_0x0032
        L_0x002f:
            r1 = r39
            r4 = r10
        L_0x0032:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x0039
            r4 = r4 | 48
            goto L_0x0049
        L_0x0039:
            r5 = r10 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0049
            boolean r5 = r0.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x0046
            r5 = 32
            goto L_0x0048
        L_0x0046:
            r5 = 16
        L_0x0048:
            r4 = r4 | r5
        L_0x0049:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0050
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r6 = r10 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0063
            r6 = r41
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r4 = r4 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r41
        L_0x0065:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x006c
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r8 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007f
            r8 = r42
            boolean r9 = r0.changed((boolean) r8)
            if (r9 == 0) goto L_0x007b
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r4 = r4 | r9
            goto L_0x0081
        L_0x007f:
            r8 = r42
        L_0x0081:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r10
            if (r9 != 0) goto L_0x009c
            r9 = r11 & 16
            if (r9 != 0) goto L_0x0096
            r9 = r43
            boolean r12 = r0.changed((java.lang.Object) r9)
            if (r12 == 0) goto L_0x0098
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0096:
            r9 = r43
        L_0x0098:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r4 = r4 | r12
            goto L_0x009e
        L_0x009c:
            r9 = r43
        L_0x009e:
            r12 = r11 & 32
            if (r12 == 0) goto L_0x00a6
            r13 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r13
            goto L_0x00ba
        L_0x00a6:
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00ba
            r13 = r44
            boolean r14 = r0.changed((int) r13)
            if (r14 == 0) goto L_0x00b6
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r4 = r4 | r14
            goto L_0x00bc
        L_0x00ba:
            r13 = r44
        L_0x00bc:
            r14 = r11 & 64
            if (r14 == 0) goto L_0x00c4
            r15 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r15
            goto L_0x00d9
        L_0x00c4:
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00d9
            r15 = r45
            boolean r16 = r0.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00d4
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d6
        L_0x00d4:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d6:
            r4 = r4 | r16
            goto L_0x00db
        L_0x00d9:
            r15 = r45
        L_0x00db:
            r3 = r11 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x00e6
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r16
            r1 = r46
            goto L_0x00fb
        L_0x00e6:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r10 & r16
            r1 = r46
            if (r16 != 0) goto L_0x00fb
            boolean r16 = r0.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x00f7
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f7:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r4 = r4 | r16
        L_0x00fb:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r10 & r16
            if (r16 != 0) goto L_0x0117
            r1 = r11 & 256(0x100, float:3.59E-43)
            if (r1 != 0) goto L_0x0110
            r1 = r47
            boolean r16 = r0.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x0112
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0114
        L_0x0110:
            r1 = r47
        L_0x0112:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0114:
            r4 = r4 | r16
            goto L_0x0119
        L_0x0117:
            r1 = r47
        L_0x0119:
            r16 = 191739611(0xb6db6db, float:4.5782105E-32)
            r1 = r4 & r16
            r6 = 38347922(0x2492492, float:1.4777643E-37)
            if (r1 != r6) goto L_0x0139
            boolean r1 = r0.getSkipping()
            if (r1 != 0) goto L_0x012a
            goto L_0x0139
        L_0x012a:
            r0.skipToGroupEnd()
            r3 = r41
            r4 = r8
            r5 = r9
            r6 = r13
            r7 = r15
            r8 = r46
            r9 = r47
            goto L_0x02a2
        L_0x0139:
            r0.startDefaults()
            r1 = r10 & 1
            r37 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r6 = 1
            if (r1 == 0) goto L_0x0175
            boolean r1 = r0.getDefaultsInvalid()
            if (r1 == 0) goto L_0x014e
            goto L_0x0175
        L_0x014e:
            r0.skipToGroupEnd()
            r1 = r11 & 16
            if (r1 == 0) goto L_0x0157
            r4 = r4 & r16
        L_0x0157:
            r1 = r11 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0169
            r1 = r4 & r37
            r3 = r46
            r4 = r47
            r14 = r1
            r5 = r9
            r7 = r13
            r9 = r15
            r1 = r41
            goto L_0x01e8
        L_0x0169:
            r1 = r41
            r3 = r46
            r14 = r4
            r5 = r9
            r7 = r13
            r9 = r15
        L_0x0171:
            r4 = r47
            goto L_0x01e8
        L_0x0175:
            if (r5 == 0) goto L_0x017a
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x017c
        L_0x017a:
            r1 = r41
        L_0x017c:
            if (r7 == 0) goto L_0x017f
            r8 = r6
        L_0x017f:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x018d
            r5 = 0
            r7 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r5 = kotlin.ranges.RangesKt__RangesKt.rangeTo((float) r5, (float) r7)
            r4 = r4 & r16
            goto L_0x018e
        L_0x018d:
            r5 = r9
        L_0x018e:
            if (r12 == 0) goto L_0x0192
            r7 = 0
            goto L_0x0193
        L_0x0192:
            r7 = r13
        L_0x0193:
            if (r14 == 0) goto L_0x0197
            r9 = 0
            goto L_0x0198
        L_0x0197:
            r9 = r15
        L_0x0198:
            if (r3 == 0) goto L_0x01b9
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r3)
            java.lang.Object r3 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r3 != r12) goto L_0x01b3
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r3)
        L_0x01b3:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            goto L_0x01bb
        L_0x01b9:
            r3 = r46
        L_0x01bb:
            r12 = r11 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x01e6
            androidx.compose.material.SliderDefaults r12 = androidx.compose.material.SliderDefaults.INSTANCE
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r34 = 0
            r35 = 6
            r36 = 1023(0x3ff, float:1.434E-42)
            r33 = r0
            androidx.compose.material.SliderColors r12 = r12.m1357colorsq0g_0yA(r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r34, r35, r36)
            r4 = r4 & r37
            r14 = r4
            r4 = r12
            goto L_0x01e8
        L_0x01e6:
            r14 = r4
            goto L_0x0171
        L_0x01e8:
            r0.endDefaults()
            if (r7 < 0) goto L_0x01f0
            r38 = r6
            goto L_0x01f2
        L_0x01f0:
            r38 = 0
        L_0x01f2:
            if (r38 == 0) goto L_0x02bb
            int r12 = r14 >> 3
            r12 = r12 & 14
            androidx.compose.runtime.State r20 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r2, r0, r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r7)
            r13 = 1157296644(0x44faf204, float:2007.563)
            r0.startReplaceableGroup(r13)
            boolean r12 = r0.changed((java.lang.Object) r12)
            java.lang.Object r13 = r0.rememberedValue()
            if (r12 != 0) goto L_0x0218
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x021f
        L_0x0218:
            java.util.List r13 = stepsToTickFractions(r7)
            r0.updateRememberedValue(r13)
        L_0x021f:
            r0.endReplaceableGroup()
            r18 = r13
            java.util.List r18 = (java.util.List) r18
            androidx.compose.ui.Modifier r12 = androidx.compose.material.TouchTargetKt.minimumTouchTargetSize(r1)
            float r13 = ThumbRadius
            r15 = 2
            float r15 = (float) r15
            float r16 = r13 * r15
            float r16 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r16)
            float r13 = r13 * r15
            float r13 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r13)
            r15 = 0
            r17 = 0
            r19 = 12
            r21 = 0
            r41 = r12
            r42 = r16
            r43 = r13
            r44 = r15
            r45 = r17
            r46 = r19
            r47 = r21
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.layout.SizeKt.m554requiredSizeInqDBjuR0$default(r41, r42, r43, r44, r45, r46, r47)
            r41 = r12
            r42 = r39
            r43 = r18
            r44 = r8
            r45 = r40
            r46 = r5
            r47 = r7
            androidx.compose.ui.Modifier r12 = sliderSemantics(r41, r42, r43, r44, r45, r46, r47)
            androidx.compose.ui.Modifier r22 = androidx.compose.foundation.FocusableKt.focusable(r12, r8, r3)
            r23 = 0
            r24 = 0
            androidx.compose.material.SliderKt$Slider$3 r15 = new androidx.compose.material.SliderKt$Slider$3
            r12 = r15
            r13 = r5
            r48 = r1
            r1 = r15
            r15 = r39
            r16 = r3
            r17 = r8
            r19 = r4
            r21 = r9
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r12 = 2085116814(0x7c485b8e, float:4.1612653E36)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r12, r6, r1)
            r6 = 3072(0xc00, float:4.305E-42)
            r12 = 6
            r41 = r22
            r42 = r23
            r43 = r24
            r44 = r1
            r45 = r0
            r46 = r6
            r47 = r12
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r41, r42, r43, r44, r45, r46, r47)
            r6 = r7
            r7 = r9
            r9 = r4
            r4 = r8
            r8 = r3
            r3 = r48
        L_0x02a2:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x02a9
            goto L_0x02ba
        L_0x02a9:
            androidx.compose.material.SliderKt$Slider$4 r13 = new androidx.compose.material.SliderKt$Slider$4
            r0 = r13
            r1 = r39
            r2 = r40
            r10 = r49
            r11 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.updateScope(r13)
        L_0x02ba:
            return
        L_0x02bb:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "steps should be >= 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void SliderImpl(boolean z11, float f11, List<Float> list, SliderColors sliderColors, float f12, MutableInteractionSource mutableInteractionSource, Modifier modifier, Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(1679682785);
        Modifier then = modifier.then(DefaultSliderConstraints);
        startRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(then);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r82 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r82, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r82, density, companion.getSetDensity());
        Updater.m2543setimpl(r82, layoutDirection, companion.getSetLayoutDirection());
        Updater.m2543setimpl(r82, viewConfiguration, companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        startRestartGroup.startReplaceableGroup(231316251);
        Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        float r83 = density2.m5447toPx0680j_4(TrackHeight);
        float f13 = ThumbRadius;
        float r72 = density2.m5447toPx0680j_4(f13);
        float r12 = density2.m5443toDpu2uoSUM(f12);
        float r14 = Dp.m5478constructorimpl(f13 * ((float) 2));
        float r15 = Dp.m5478constructorimpl(r12 * f11);
        Modifier.Companion companion2 = Modifier.Companion;
        int i12 = i11 >> 6;
        Track(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, (Object) null), sliderColors, z11, 0.0f, f11, list, r72, r83, startRestartGroup, (i12 & 112) | 265222 | ((i11 << 6) & 896) | ((i11 << 9) & 57344));
        m1358SliderThumbPcYyNuk(boxScopeInstance, companion2, r15, mutableInteractionSource, sliderColors, z11, r14, startRestartGroup, (i12 & 7168) | 1572918 | ((i11 << 3) & 57344) | ((i11 << 15) & Opcodes.ASM7));
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$SliderImpl$2(z11, f11, list, sliderColors, f12, mutableInteractionSource, modifier, i11));
        }
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: SliderThumb-PcYyNuk  reason: not valid java name */
    public static final void m1358SliderThumbPcYyNuk(BoxScope boxScope, Modifier modifier, float f11, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z11, float f12, Composer composer, int i11) {
        int i12;
        float f13;
        float f14;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        BoxScope boxScope2 = boxScope;
        Modifier modifier2 = modifier;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        SliderColors sliderColors2 = sliderColors;
        boolean z12 = z11;
        float f15 = f12;
        int i21 = i11;
        Composer startRestartGroup = composer.startRestartGroup(428907178);
        if ((i21 & 14) == 0) {
            if (startRestartGroup.changed((Object) boxScope2)) {
                i19 = 4;
            } else {
                i19 = 2;
            }
            i12 = i19 | i21;
        } else {
            i12 = i21;
        }
        if ((i21 & 112) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i18 = 32;
            } else {
                i18 = 16;
            }
            i12 |= i18;
        }
        float f16 = f11;
        if ((i21 & 896) == 0) {
            if (startRestartGroup.changed(f16)) {
                i17 = 256;
            } else {
                i17 = 128;
            }
            i12 |= i17;
        }
        if ((i21 & 7168) == 0) {
            if (startRestartGroup.changed((Object) mutableInteractionSource2)) {
                i16 = 2048;
            } else {
                i16 = 1024;
            }
            i12 |= i16;
        }
        if ((57344 & i21) == 0) {
            if (startRestartGroup.changed((Object) sliderColors2)) {
                i15 = 16384;
            } else {
                i15 = 8192;
            }
            i12 |= i15;
        }
        if ((458752 & i21) == 0) {
            if (startRestartGroup.changed(z12)) {
                i14 = 131072;
            } else {
                i14 = 65536;
            }
            i12 |= i14;
        }
        if ((3670016 & i21) == 0) {
            if (startRestartGroup.changed(f15)) {
                i13 = 1048576;
            } else {
                i13 = 524288;
            }
            i12 |= i13;
        }
        if ((2995931 & i12) != 599186 || !startRestartGroup.getSkipping()) {
            Modifier r92 = PaddingKt.m490paddingqDBjuR0$default(Modifier.Companion, f11, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            Alignment.Companion companion = Alignment.Companion;
            Modifier align = boxScope2.align(r92, companion.getCenterStart());
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(align);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r12 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r12, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r12, density, companion2.getSetDensity());
            Updater.m2543setimpl(r12, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r12, viewConfiguration, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(-587645648);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion3 = Composer.Companion;
            if (rememberedValue == companion3.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateListOf();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
            int i22 = i12 >> 9;
            int i23 = i22 & 14;
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed((Object) mutableInteractionSource2) | startRestartGroup.changed((Object) snapshotStateList);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion3.getEmpty()) {
                rememberedValue2 = new SliderKt$SliderThumb$1$1$1(mutableInteractionSource2, snapshotStateList, (Continuation<? super SliderKt$SliderThumb$1$1$1>) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect((Object) mutableInteractionSource2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, startRestartGroup, i23);
            if (!snapshotStateList.isEmpty()) {
                f13 = ThumbPressedElevation;
            } else {
                f13 = ThumbDefaultElevation;
            }
            float f17 = f13;
            Modifier hoverable$default = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m560sizeVpY3zN4(modifier2, f15, f15), mutableInteractionSource2, RippleKt.m1485rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0, startRestartGroup, 54, 4)), mutableInteractionSource2, false, 2, (Object) null);
            if (z12) {
                f14 = f17;
            } else {
                f14 = Dp.m5478constructorimpl((float) 0);
            }
            SpacerKt.Spacer(BackgroundKt.m176backgroundbw27NRU(ShadowKt.m2593shadows4CzXII$default(hoverable$default, f14, RoundedCornerShapeKt.getCircleShape(), false, 0, 0, 24, (Object) null), sliderColors2.thumbColor(z12, startRestartGroup, ((i12 >> 15) & 14) | (i22 & 112)).getValue().m2929unboximpl(), RoundedCornerShapeKt.getCircleShape()), startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$SliderThumb$2(boxScope, modifier, f11, mutableInteractionSource, sliderColors, z11, f12, i11));
        }
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Track(Modifier modifier, SliderColors sliderColors, boolean z11, float f11, float f12, List<Float> list, float f13, float f14, Composer composer, int i11) {
        SliderColors sliderColors2 = sliderColors;
        boolean z12 = z11;
        Composer startRestartGroup = composer.startRestartGroup(1833126050);
        int i12 = ((i11 >> 6) & 14) | 48 | ((i11 << 3) & 896);
        Modifier modifier2 = modifier;
        CanvasKt.Canvas(modifier, new SliderKt$Track$1(f13, sliderColors2.trackColor(z12, false, startRestartGroup, i12), f14, f12, f11, sliderColors2.trackColor(z12, true, startRestartGroup, i12), list, sliderColors2.tickColor(z12, false, startRestartGroup, i12), sliderColors2.tickColor(z12, true, startRestartGroup, i12)), startRestartGroup, i11 & 14);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$Track$2(modifier, sliderColors, z11, f11, f12, list, f13, f14, i11));
        }
    }

    /* access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float f11, float f12, float f13, Continuation<? super Unit> continuation) {
        Object a11 = a.a(draggableState, (MutatePriority) null, new SliderKt$animateToTarget$2(f11, f12, f13, (Continuation<? super SliderKt$animateToTarget$2>) null), continuation, 1, (Object) null);
        return a11 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a11 : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: awaitSlop-8vUncbI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m1361awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.material.SliderKt$awaitSlop$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            androidx.compose.material.SliderKt$awaitSlop$1 r0 = (androidx.compose.material.SliderKt$awaitSlop$1) r0
            int r1 = r0.f5267j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f5267j = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.material.SliderKt$awaitSlop$1 r0 = new androidx.compose.material.SliderKt$awaitSlop$1
            r0.<init>(r12)
        L_0x0018:
            r6 = r0
            java.lang.Object r12 = r6.f5266i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f5267j
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            java.lang.Object r8 = r6.f5265h
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0054
        L_0x002e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.jvm.internal.Ref$FloatRef r12 = new kotlin.jvm.internal.Ref$FloatRef
            r12.<init>()
            androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1 r5 = new androidx.compose.material.SliderKt$awaitSlop$postPointerSlop$1
            r5.<init>(r12)
            r6.f5265h = r12
            r6.f5267j = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r8 = androidx.compose.material.DragGestureDetectorCopyKt.m1220awaitHorizontalPointerSlopOrCancellationgDDlDlE(r1, r2, r4, r5, r6)
            if (r8 != r0) goto L_0x0051
            return r0
        L_0x0051:
            r7 = r12
            r12 = r8
            r8 = r7
        L_0x0054:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 == 0) goto L_0x0063
            float r8 = r8.element
            java.lang.Float r8 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r12, r8)
            goto L_0x0064
        L_0x0063:
            r8 = 0
        L_0x0064:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.m1361awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final float calcFraction(float f11, float f12, float f13) {
        float f14 = f12 - f11;
        return RangesKt___RangesKt.coerceIn((f14 > 0.0f ? 1 : (f14 == 0.0f ? 0 : -1)) == 0 ? 0.0f : (f13 - f11) / f14, 0.0f, 1.0f);
    }

    public static final float getThumbRadius() {
        return ThumbRadius;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    /* access modifiers changed from: private */
    public static final Modifier rangeSliderPressDragModifier(Modifier modifier, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, boolean z11, boolean z12, float f11, ClosedFloatingPointRange<Float> closedFloatingPointRange, State<? extends Function1<? super Boolean, Unit>> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4) {
        if (!z11) {
            return modifier;
        }
        Modifier modifier2 = modifier;
        return SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, Float.valueOf(f11), Boolean.valueOf(z12), closedFloatingPointRange}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SliderKt$rangeSliderPressDragModifier$1(mutableInteractionSource, mutableInteractionSource2, state, state2, state4, z12, f11, state3, (Continuation<? super SliderKt$rangeSliderPressDragModifier$1>) null));
    }

    /* access modifiers changed from: private */
    public static final float scale(float f11, float f12, float f13, float f14, float f15) {
        return MathHelpersKt.lerp(f14, f15, calcFraction(f11, f12, f13));
    }

    /* access modifiers changed from: private */
    public static final Modifier sliderSemantics(Modifier modifier, float f11, List<Float> list, boolean z11, Function1<? super Float, Unit> function1, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i11) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new SliderKt$sliderSemantics$1(z11, closedFloatingPointRange, i11, list, RangesKt___RangesKt.coerceIn(f11, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue()), function1), 1, (Object) null), f11, closedFloatingPointRange, i11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: kotlin.jvm.functions.Function1<androidx.compose.ui.platform.InspectorInfo, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: androidx.compose.material.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.compose.material.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1} */
    /* JADX WARNING: type inference failed for: r0v1, types: [kotlin.jvm.functions.Function1] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier sliderTapModifier(androidx.compose.ui.Modifier r11, androidx.compose.foundation.gestures.DraggableState r12, androidx.compose.foundation.interaction.MutableInteractionSource r13, float r14, boolean r15, androidx.compose.runtime.State<java.lang.Float> r16, androidx.compose.runtime.State<? extends kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit>> r17, androidx.compose.runtime.MutableState<java.lang.Float> r18, boolean r19) {
        /*
            boolean r0 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r0 == 0) goto L_0x0019
            androidx.compose.material.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1 r0 = new androidx.compose.material.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1
            r1 = r0
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x001d
        L_0x0019:
            kotlin.jvm.functions.Function1 r0 = androidx.compose.ui.platform.InspectableValueKt.getNoInspectorInfo()
        L_0x001d:
            androidx.compose.material.SliderKt$sliderTapModifier$2 r10 = new androidx.compose.material.SliderKt$sliderTapModifier$2
            r1 = r10
            r2 = r19
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r18
            r8 = r16
            r9 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r1 = r11
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.ComposedModifierKt.composed(r11, r0, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.sliderTapModifier(androidx.compose.ui.Modifier, androidx.compose.foundation.gestures.DraggableState, androidx.compose.foundation.interaction.MutableInteractionSource, float, boolean, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, boolean):androidx.compose.ui.Modifier");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Number} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final float snapValueToTick(float r5, java.util.List<java.lang.Float> r6, float r7, float r8) {
        /*
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
            boolean r0 = r6.hasNext()
            if (r0 != 0) goto L_0x000e
            r6 = 0
            goto L_0x004d
        L_0x000e:
            java.lang.Object r0 = r6.next()
            boolean r1 = r6.hasNext()
            if (r1 != 0) goto L_0x001a
        L_0x0018:
            r6 = r0
            goto L_0x004d
        L_0x001a:
            r1 = r0
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r1 = androidx.compose.ui.util.MathHelpersKt.lerp((float) r7, (float) r8, (float) r1)
            float r1 = r1 - r5
            float r1 = java.lang.Math.abs(r1)
        L_0x002a:
            java.lang.Object r2 = r6.next()
            r3 = r2
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r3 = androidx.compose.ui.util.MathHelpersKt.lerp((float) r7, (float) r8, (float) r3)
            float r3 = r3 - r5
            float r3 = java.lang.Math.abs(r3)
            int r4 = java.lang.Float.compare(r1, r3)
            if (r4 <= 0) goto L_0x0046
            r0 = r2
            r1 = r3
        L_0x0046:
            boolean r2 = r6.hasNext()
            if (r2 != 0) goto L_0x002a
            goto L_0x0018
        L_0x004d:
            java.lang.Float r6 = (java.lang.Float) r6
            if (r6 == 0) goto L_0x0059
            float r5 = r6.floatValue()
            float r5 = androidx.compose.ui.util.MathHelpersKt.lerp((float) r7, (float) r8, (float) r5)
        L_0x0059:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.snapValueToTick(float, java.util.List, float, float):float");
    }

    private static final List<Float> stepsToTickFractions(int i11) {
        if (i11 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int i12 = i11 + 2;
        ArrayList arrayList = new ArrayList(i12);
        for (int i13 = 0; i13 < i12; i13++) {
            arrayList.add(Float.valueOf(((float) i13) / ((float) (i11 + 1))));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> scale(float f11, float f12, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f13, float f14) {
        return RangesKt__RangesKt.rangeTo(scale(f11, f12, closedFloatingPointRange.getStart().floatValue(), f13, f14), scale(f11, f12, closedFloatingPointRange.getEndInclusive().floatValue(), f13, f14));
    }
}
