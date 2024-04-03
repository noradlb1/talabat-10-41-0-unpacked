package androidx.compose.material3;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
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
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import net.bytebuddy.jar.asm.Opcodes;
import o.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010%\u001ae\u0010&\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00101\u001a±\u0001\u00102\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b52\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u00106\u001a\u00020-2\u0019\b\u0002\u00107\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b5H\u0007¢\u0006\u0002\u00108\u001a}\u00102\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u00106\u001a\u00020-H\u0007¢\u0006\u0002\u00109\u001a\u0001\u00102\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u00106\u001a\u00020-2\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b5H\u0007¢\u0006\u0002\u0010:\u001a\u0001\u0010;\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00106\u001a\u00020-2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b52\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b5H\u0003¢\u0006\u0002\u0010<\u001aU\u0010=\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\bH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a1\u0010B\u001a\u00020\u00162\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010H\u001a \u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\bH\u0002\u001a0\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\bH\u0002\u001a<\u0010M\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\bH\u0002\u001a(\u0010T\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0002\u001a\u0010\u0010W\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020 H\u0002\u001a?\u0010X\u001a\u00020\u0016*\u00020Y2\u0006\u0010Z\u001a\u00020\u00032\u001c\u0010[\u001a\u0018\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b5¢\u0006\u0002\b\\H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b]\u0010^\u001a;\u0010_\u001a\u0010\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020\b\u0018\u00010`*\u00020b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020fH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bg\u0010h\u001a\u0001\u0010i\u001a\u00020\u0001*\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\b0k2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\b0k2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010m\u001a\u00020\u001d2\u0006\u0010V\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00160\u001a0k2\u001e\u0010o\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160p0kH\u0002\u001a\\\u0010q\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 H\u0002\u001ad\u0010r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010C\u001a\u00020D2\u0006\u00106\u001a\u00020-2\u0006\u0010V\u001a\u00020 2\u0006\u0010m\u001a\u00020\u001d2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\b0k2\u0012\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\"0k2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020\b0u2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\f\u001a\u00020\rX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000e\"\u0019\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0011\"\u0013\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0013\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0014\u0010\u0011\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006v"}, d2 = {"DefaultSliderConstraints", "Landroidx/compose/ui/Modifier;", "SliderHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SliderMinWidth", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "", "ThumbDefaultElevation", "ThumbHeight", "ThumbPressedElevation", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "ThumbWidth", "getThumbWidth", "()F", "TickSize", "TrackHeight", "getTrackHeight", "RangeSlider", "", "value", "Lkotlin/ranges/ClosedFloatingPointRange;", "onValueChange", "Lkotlin/Function1;", "modifier", "enabled", "", "valueRange", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material3/SliderColors;", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "positionFractionStart", "positionFractionEnd", "tickFractions", "", "width", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumbSemantics", "endThumbSemantics", "(ZFF[FLandroidx/compose/material3/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Slider", "track", "Landroidx/compose/material3/SliderPositions;", "Landroidx/compose/runtime/Composable;", "interactionSource", "thumb", "(FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;IFLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "TempRangeSliderTrack", "thumbWidth", "trackStrokeWidth", "TempRangeSliderTrack-au3_HiA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZFF[FFFLandroidx/compose/runtime/Composer;I)V", "animateToTarget", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "current", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x1", "a2", "b2", "x", "snapValueToTick", "minPx", "maxPx", "stepsToTickFractions", "TempRangeSliderThumb", "Landroidx/compose/foundation/layout/BoxScope;", "offset", "content", "Lkotlin/ExtensionFunctionType;", "TempRangeSliderThumb-rAjV9yQ", "(Landroidx/compose/foundation/layout/BoxScope;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "Landroidx/compose/runtime/State;", "rawOffsetEnd", "isRtl", "gestureEndAction", "onDrag", "Lkotlin/Function2;", "sliderSemantics", "sliderTapModifier", "rawOffset", "pressOffset", "Landroidx/compose/runtime/MutableState;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SliderKt {
    @NotNull
    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;
    /* access modifiers changed from: private */
    @NotNull
    public static final TweenSpec<Float> SliderToTickAnimation = new TweenSpec(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final float ThumbDefaultElevation = Dp.m5478constructorimpl((float) 1);
    private static final float ThumbHeight;
    /* access modifiers changed from: private */
    public static final float ThumbPressedElevation = Dp.m5478constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final long ThumbSize;
    private static final float ThumbWidth;
    /* access modifiers changed from: private */
    public static final float TickSize;
    private static final float TrackHeight;

    static {
        SliderTokens sliderTokens = SliderTokens.INSTANCE;
        float r12 = sliderTokens.m2419getHandleWidthD9Ej5fM();
        ThumbWidth = r12;
        float r22 = sliderTokens.m2418getHandleHeightD9Ej5fM();
        ThumbHeight = r22;
        ThumbSize = DpKt.m5500DpSizeYgX7TsA(r12, r22);
        TickSize = sliderTokens.m2425getTickMarksContainerSizeD9Ej5fM();
        TrackHeight = sliderTokens.m2420getInactiveTrackHeightD9Ej5fM();
        float r02 = Dp.m5478constructorimpl((float) 48);
        SliderHeight = r02;
        float r23 = Dp.m5478constructorimpl((float) Opcodes.D2F);
        SliderMinWidth = r23;
        DefaultSliderConstraints = SizeKt.m546heightInVpY3zN4$default(SizeKt.m565widthInVpY3zN4$default(Modifier.Companion, r23, 0.0f, 2, (Object) null), 0.0f, r02, 1, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: float[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
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
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RangeSlider(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r41, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.ranges.ClosedFloatingPointRange<java.lang.Float>, kotlin.Unit> r42, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r43, boolean r44, @org.jetbrains.annotations.Nullable kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r45, int r46, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r47, @org.jetbrains.annotations.Nullable androidx.compose.material3.SliderColors r48, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r49, int r50, int r51) {
        /*
            r12 = r41
            r13 = r42
            r14 = r50
            r15 = r51
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -743091416(0xffffffffd3b55328, float:-1.55756842E12)
            r1 = r49
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r1 = r15 & 1
            if (r1 == 0) goto L_0x0022
            r1 = r14 | 6
            goto L_0x0032
        L_0x0022:
            r1 = r14 & 14
            if (r1 != 0) goto L_0x0031
            boolean r1 = r11.changed((java.lang.Object) r12)
            if (r1 == 0) goto L_0x002e
            r1 = 4
            goto L_0x002f
        L_0x002e:
            r1 = 2
        L_0x002f:
            r1 = r1 | r14
            goto L_0x0032
        L_0x0031:
            r1 = r14
        L_0x0032:
            r3 = r15 & 2
            if (r3 == 0) goto L_0x0039
            r1 = r1 | 48
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
            r1 = r1 | r3
        L_0x0049:
            r3 = r15 & 4
            if (r3 == 0) goto L_0x0050
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r4 = r14 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0063
            r4 = r43
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005f
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r1 = r1 | r5
            goto L_0x0065
        L_0x0063:
            r4 = r43
        L_0x0065:
            r5 = r15 & 8
            if (r5 == 0) goto L_0x006c
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x007f
            r6 = r44
            boolean r7 = r11.changed((boolean) r6)
            if (r7 == 0) goto L_0x007b
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r1 = r1 | r7
            goto L_0x0081
        L_0x007f:
            r6 = r44
        L_0x0081:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r14
            if (r7 != 0) goto L_0x009c
            r7 = r15 & 16
            if (r7 != 0) goto L_0x0096
            r7 = r45
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0098
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0096:
            r7 = r45
        L_0x0098:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r1 = r1 | r8
            goto L_0x009e
        L_0x009c:
            r7 = r45
        L_0x009e:
            r8 = r15 & 32
            if (r8 == 0) goto L_0x00a6
            r9 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r9
            goto L_0x00ba
        L_0x00a6:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r14
            if (r9 != 0) goto L_0x00ba
            r9 = r46
            boolean r10 = r11.changed((int) r9)
            if (r10 == 0) goto L_0x00b6
            r10 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b8
        L_0x00b6:
            r10 = 65536(0x10000, float:9.18355E-41)
        L_0x00b8:
            r1 = r1 | r10
            goto L_0x00bc
        L_0x00ba:
            r9 = r46
        L_0x00bc:
            r10 = r15 & 64
            if (r10 == 0) goto L_0x00c7
            r16 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r16
            r2 = r47
            goto L_0x00dc
        L_0x00c7:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r14 & r16
            r2 = r47
            if (r16 != 0) goto L_0x00dc
            boolean r16 = r11.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x00d8
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r1 = r1 | r16
        L_0x00dc:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r14 & r16
            if (r16 != 0) goto L_0x00f8
            r0 = r15 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00f1
            r0 = r48
            boolean r16 = r11.changed((java.lang.Object) r0)
            if (r16 == 0) goto L_0x00f3
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f5
        L_0x00f1:
            r0 = r48
        L_0x00f3:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f5:
            r1 = r1 | r16
            goto L_0x00fa
        L_0x00f8:
            r0 = r48
        L_0x00fa:
            r16 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r1 & r16
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x0119
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x010b
            goto L_0x0119
        L_0x010b:
            r11.skipToGroupEnd()
            r8 = r48
            r3 = r4
            r4 = r6
            r5 = r7
            r6 = r9
            r14 = r11
            r7 = r47
            goto L_0x02c0
        L_0x0119:
            r11.startDefaults()
            r0 = r14 & 1
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = 1
            if (r0 == 0) goto L_0x0151
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x012b
            goto L_0x0151
        L_0x012b:
            r11.skipToGroupEnd()
            r0 = r15 & 16
            if (r0 == 0) goto L_0x0134
            r1 = r1 & r16
        L_0x0134:
            r0 = r15 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0142
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r0 = r0 & r1
            r20 = r47
            r21 = r48
            r3 = r0
            goto L_0x0147
        L_0x0142:
            r20 = r47
            r21 = r48
            r3 = r1
        L_0x0147:
            r16 = r4
            r17 = r6
            r18 = r7
            r19 = r9
            goto L_0x01af
        L_0x0151:
            if (r3 == 0) goto L_0x0156
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0157
        L_0x0156:
            r0 = r4
        L_0x0157:
            if (r5 == 0) goto L_0x015a
            r6 = r2
        L_0x015a:
            r3 = r15 & 16
            if (r3 == 0) goto L_0x0168
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r3 = kotlin.ranges.RangesKt__RangesKt.rangeTo((float) r3, (float) r4)
            r1 = r1 & r16
            r7 = r3
        L_0x0168:
            if (r8 == 0) goto L_0x016b
            r9 = 0
        L_0x016b:
            if (r10 == 0) goto L_0x016f
            r3 = 0
            goto L_0x0171
        L_0x016f:
            r3 = r47
        L_0x0171:
            r4 = r15 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x01a2
            androidx.compose.material3.SliderDefaults r16 = androidx.compose.material3.SliderDefaults.INSTANCE
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
            androidx.compose.material3.SliderColors r4 = r16.m1815colorsq0g_0yA(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r39, r40)
            r5 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r5
            r16 = r0
            r20 = r3
            r21 = r4
            goto L_0x01a8
        L_0x01a2:
            r21 = r48
            r16 = r0
            r20 = r3
        L_0x01a8:
            r17 = r6
            r18 = r7
            r19 = r9
            r3 = r1
        L_0x01af:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01c1
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.RangeSlider (Slider.kt:384)"
            r4 = -743091416(0xffffffffd3b55328, float:-1.55756842E12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r3, r0, r1)
        L_0x01c1:
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r0)
            java.lang.Object r1 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r4.getEmpty()
            if (r1 != r5) goto L_0x01da
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r1)
        L_0x01da:
            r11.endReplaceableGroup()
            r5 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            r11.startReplaceableGroup(r0)
            java.lang.Object r0 = r11.rememberedValue()
            java.lang.Object r1 = r4.getEmpty()
            if (r0 != r1) goto L_0x01f4
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r0)
        L_0x01f4:
            r11.endReplaceableGroup()
            r6 = r0
            androidx.compose.foundation.interaction.MutableInteractionSource r6 = (androidx.compose.foundation.interaction.MutableInteractionSource) r6
            if (r19 < 0) goto L_0x01fe
            r0 = r2
            goto L_0x01ff
        L_0x01fe:
            r0 = 0
        L_0x01ff:
            if (r0 == 0) goto L_0x02d9
            r0 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r0)
            boolean r0 = r11.changed((java.lang.Object) r12)
            boolean r1 = r11.changed((java.lang.Object) r13)
            r0 = r0 | r1
            java.lang.Object r1 = r11.rememberedValue()
            if (r0 != 0) goto L_0x021c
            java.lang.Object r0 = r4.getEmpty()
            if (r1 != r0) goto L_0x0224
        L_0x021c:
            androidx.compose.material3.SliderKt$RangeSlider$onValueChangeState$1$1 r1 = new androidx.compose.material3.SliderKt$RangeSlider$onValueChangeState$1$1
            r1.<init>(r12, r13)
            r11.updateRememberedValue(r1)
        L_0x0224:
            r11.endReplaceableGroup()
            r0 = 0
            androidx.compose.runtime.State r9 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r1, r11, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r19)
            r1 = 1157296644(0x44faf204, float:2007.563)
            r11.startReplaceableGroup(r1)
            boolean r0 = r11.changed((java.lang.Object) r0)
            java.lang.Object r1 = r11.rememberedValue()
            if (r0 != 0) goto L_0x0246
            java.lang.Object r0 = r4.getEmpty()
            if (r1 != r0) goto L_0x024d
        L_0x0246:
            float[] r1 = stepsToTickFractions(r19)
            r11.updateRememberedValue(r1)
        L_0x024d:
            r11.endReplaceableGroup()
            r10 = r1
            float[] r10 = (float[]) r10
            androidx.compose.ui.Modifier r22 = androidx.compose.material3.TouchTargetKt.minimumTouchTargetSize(r16)
            float r0 = ThumbWidth
            r1 = 2
            float r1 = (float) r1
            float r0 = r0 * r1
            float r23 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r0)
            float r0 = ThumbHeight
            float r0 = r0 * r1
            float r24 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r0)
            r25 = 0
            r26 = 0
            r27 = 12
            r28 = 0
            androidx.compose.ui.Modifier r22 = androidx.compose.foundation.layout.SizeKt.m554requiredSizeInqDBjuR0$default(r22, r23, r24, r25, r26, r27, r28)
            r23 = 0
            r24 = 0
            androidx.compose.material3.SliderKt$RangeSlider$2 r8 = new androidx.compose.material3.SliderKt$RangeSlider$2
            r0 = r8
            r1 = r20
            r7 = r2
            r2 = r3
            r3 = r5
            r4 = r6
            r5 = r17
            r6 = r18
            r12 = r7
            r7 = r41
            r13 = r8
            r8 = r19
            r14 = r11
            r11 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = -990606702(0xffffffffc4f48a92, float:-1956.3303)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r0, r12, r13)
            r1 = 3072(0xc00, float:4.305E-42)
            r2 = 6
            r43 = r22
            r44 = r23
            r45 = r24
            r46 = r0
            r47 = r14
            r48 = r1
            r49 = r2
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r43, r44, r45, r46, r47, r48, r49)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02b4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02b4:
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
        L_0x02c0:
            androidx.compose.runtime.ScopeUpdateScope r11 = r14.endRestartGroup()
            if (r11 != 0) goto L_0x02c7
            goto L_0x02d8
        L_0x02c7:
            androidx.compose.material3.SliderKt$RangeSlider$3 r12 = new androidx.compose.material3.SliderKt$RangeSlider$3
            r0 = r12
            r1 = r41
            r2 = r42
            r9 = r50
            r10 = r51
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.updateScope(r12)
        L_0x02d8:
            return
        L_0x02d9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "steps should be >= 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSlider(kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RangeSliderImpl(boolean z11, float f11, float f12, float[] fArr, SliderColors sliderColors, float f13, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Modifier modifier, Modifier modifier2, Modifier modifier3, Composer composer, int i11, int i12) {
        int i13 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-597471305);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-597471305, i13, i12, "androidx.compose.material3.RangeSliderImpl (Slider.kt:511)");
        } else {
            int i14 = i12;
        }
        Strings.Companion companion = Strings.Companion;
        String r14 = Strings_androidKt.m1849getStringNWtq28(companion.m1848getSliderRangeStartadMyvUU(), startRestartGroup, 6);
        String r15 = Strings_androidKt.m1849getStringNWtq28(companion.m1847getSliderRangeEndadMyvUU(), startRestartGroup, 6);
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
        Composer r82 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r82, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m2543setimpl(r82, density, companion3.getSetDensity());
        Updater.m2543setimpl(r82, layoutDirection, companion3.getSetLayoutDirection());
        Updater.m2543setimpl(r82, viewConfiguration, companion3.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-2137368960);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        startRestartGroup.startReplaceableGroup(1755032509);
        Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        float r83 = density2.m5447toPx0680j_4(TrackHeight);
        float r22 = density2.m5443toDpu2uoSUM(f13);
        float r72 = Dp.m5478constructorimpl(r22 * f11);
        int i15 = i13 << 6;
        float r18 = Dp.m5478constructorimpl(r22 * f12);
        m1817TempRangeSliderTrackau3_HiA(SizeKt.fillMaxSize$default(boxScopeInstance.align(Modifier.Companion, companion2.getCenterStart()), 0.0f, 1, (Object) null), sliderColors, z11, f11, f12, fArr, ThumbWidth, r83, startRestartGroup, ((i13 >> 9) & 112) | 1835008 | (i15 & 896) | (i15 & 7168) | (i15 & 57344));
        BoxScopeInstance boxScopeInstance2 = boxScopeInstance;
        SliderColors sliderColors2 = sliderColors;
        boolean z12 = z11;
        int i16 = i11;
        m1816TempRangeSliderThumbrAjV9yQ(boxScopeInstance2, r72, ComposableLambdaKt.composableLambda(startRestartGroup, -1592025586, true, new SliderKt$RangeSliderImpl$1$2(r14, mutableInteractionSource, modifier2, sliderColors2, z12, i16)), startRestartGroup, 390);
        m1816TempRangeSliderThumbrAjV9yQ(boxScopeInstance2, r18, ComposableLambdaKt.composableLambda(startRestartGroup, -1141545019, true, new SliderKt$RangeSliderImpl$1$3(r15, mutableInteractionSource2, modifier3, sliderColors2, z12, i16)), startRestartGroup, 390);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$RangeSliderImpl$2(z11, f11, f12, fArr, sliderColors, f13, mutableInteractionSource, mutableInteractionSource2, modifier, modifier2, modifier3, i11, i12));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: kotlin.jvm.functions.Function3} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0107  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Slider(float r44, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r45, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r46, boolean r47, @org.jetbrains.annotations.Nullable kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r48, int r49, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r50, @org.jetbrains.annotations.Nullable androidx.compose.material3.SliderColors r51, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r52, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r53, int r54, int r55) {
        /*
            r15 = r45
            r14 = r54
            r13 = r55
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = -202044027(0xfffffffff3f50d85, float:-3.8830168E31)
            r1 = r53
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x001d
            r1 = r14 | 6
            r11 = r44
            goto L_0x002f
        L_0x001d:
            r1 = r14 & 14
            r11 = r44
            if (r1 != 0) goto L_0x002e
            boolean r1 = r12.changed((float) r11)
            if (r1 == 0) goto L_0x002b
            r1 = 4
            goto L_0x002c
        L_0x002b:
            r1 = 2
        L_0x002c:
            r1 = r1 | r14
            goto L_0x002f
        L_0x002e:
            r1 = r14
        L_0x002f:
            r2 = r13 & 2
            if (r2 == 0) goto L_0x0036
            r1 = r1 | 48
            goto L_0x0046
        L_0x0036:
            r2 = r14 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0046
            boolean r2 = r12.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x0043
            r2 = 32
            goto L_0x0045
        L_0x0043:
            r2 = 16
        L_0x0045:
            r1 = r1 | r2
        L_0x0046:
            r2 = r13 & 4
            if (r2 == 0) goto L_0x004d
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0060
        L_0x004d:
            r3 = r14 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0060
            r3 = r46
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005c
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005c:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r1 = r1 | r4
            goto L_0x0062
        L_0x0060:
            r3 = r46
        L_0x0062:
            r4 = r13 & 8
            if (r4 == 0) goto L_0x0069
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r5 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x007c
            r5 = r47
            boolean r6 = r12.changed((boolean) r5)
            if (r6 == 0) goto L_0x0078
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r1 = r1 | r6
            goto L_0x007e
        L_0x007c:
            r5 = r47
        L_0x007e:
            r6 = 57344(0xe000, float:8.0356E-41)
            r7 = r14 & r6
            if (r7 != 0) goto L_0x009a
            r7 = r13 & 16
            if (r7 != 0) goto L_0x0094
            r7 = r48
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0096
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0094:
            r7 = r48
        L_0x0096:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r1 = r1 | r8
            goto L_0x009c
        L_0x009a:
            r7 = r48
        L_0x009c:
            r8 = r13 & 32
            r9 = 458752(0x70000, float:6.42848E-40)
            if (r8 == 0) goto L_0x00a6
            r10 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r10
            goto L_0x00ba
        L_0x00a6:
            r10 = r14 & r9
            if (r10 != 0) goto L_0x00ba
            r10 = r49
            boolean r16 = r12.changed((int) r10)
            if (r16 == 0) goto L_0x00b5
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r1 = r1 | r16
            goto L_0x00bc
        L_0x00ba:
            r10 = r49
        L_0x00bc:
            r16 = r13 & 64
            r41 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00c9
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r9 = r50
            goto L_0x00dc
        L_0x00c9:
            r17 = r14 & r41
            r9 = r50
            if (r17 != 0) goto L_0x00dc
            boolean r17 = r12.changed((java.lang.Object) r9)
            if (r17 == 0) goto L_0x00d8
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r1 = r1 | r17
        L_0x00dc:
            r42 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r14 & r42
            if (r17 != 0) goto L_0x00f8
            r6 = r13 & 128(0x80, float:1.794E-43)
            if (r6 != 0) goto L_0x00f1
            r6 = r51
            boolean r17 = r12.changed((java.lang.Object) r6)
            if (r17 == 0) goto L_0x00f3
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f5
        L_0x00f1:
            r6 = r51
        L_0x00f3:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f5:
            r1 = r1 | r17
            goto L_0x00fa
        L_0x00f8:
            r6 = r51
        L_0x00fa:
            r0 = r13 & 256(0x100, float:3.59E-43)
            r43 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x0107
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r17
            r3 = r52
            goto L_0x011a
        L_0x0107:
            r17 = r14 & r43
            r3 = r52
            if (r17 != 0) goto L_0x011a
            boolean r17 = r12.changed((java.lang.Object) r3)
            if (r17 == 0) goto L_0x0116
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0118
        L_0x0116:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0118:
            r1 = r1 | r17
        L_0x011a:
            r17 = 191739611(0xb6db6db, float:4.5782105E-32)
            r3 = r1 & r17
            r5 = 38347922(0x2492492, float:1.4777643E-37)
            if (r3 != r5) goto L_0x013c
            boolean r3 = r12.getSkipping()
            if (r3 != 0) goto L_0x012b
            goto L_0x013c
        L_0x012b:
            r12.skipToGroupEnd()
            r3 = r46
            r4 = r47
            r8 = r6
            r5 = r7
            r7 = r9
            r6 = r10
            r20 = r12
            r9 = r52
            goto L_0x02d9
        L_0x013c:
            r12.startDefaults()
            r3 = r14 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r5 = 1
            if (r3 == 0) goto L_0x016e
            boolean r3 = r12.getDefaultsInvalid()
            if (r3 == 0) goto L_0x014e
            goto L_0x016e
        L_0x014e:
            r12.skipToGroupEnd()
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0157
            r1 = r1 & r17
        L_0x0157:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x015f
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r0
        L_0x015f:
            r16 = r46
            r8 = r52
            r17 = r7
            r19 = r9
            r18 = r10
            r10 = r47
            r9 = r6
            goto L_0x01f6
        L_0x016e:
            if (r2 == 0) goto L_0x0173
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x0175
        L_0x0173:
            r2 = r46
        L_0x0175:
            if (r4 == 0) goto L_0x0179
            r3 = r5
            goto L_0x017b
        L_0x0179:
            r3 = r47
        L_0x017b:
            r4 = r13 & 16
            if (r4 == 0) goto L_0x0189
            r4 = 0
            r7 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r4 = kotlin.ranges.RangesKt__RangesKt.rangeTo((float) r4, (float) r7)
            r1 = r1 & r17
            goto L_0x018a
        L_0x0189:
            r4 = r7
        L_0x018a:
            if (r8 == 0) goto L_0x018e
            r7 = 0
            goto L_0x018f
        L_0x018e:
            r7 = r10
        L_0x018f:
            if (r16 == 0) goto L_0x0193
            r8 = 0
            goto L_0x0194
        L_0x0193:
            r8 = r9
        L_0x0194:
            r9 = r13 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x01be
            androidx.compose.material3.SliderDefaults r16 = androidx.compose.material3.SliderDefaults.INSTANCE
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
            r37 = r12
            androidx.compose.material3.SliderColors r6 = r16.m1815colorsq0g_0yA(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r39, r40)
            r9 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r9
        L_0x01be:
            if (r0 == 0) goto L_0x01ea
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r0)
            java.lang.Object r0 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r0 != r9) goto L_0x01d9
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r12.updateRememberedValue(r0)
        L_0x01d9:
            r12.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r16 = r2
            r10 = r3
            r17 = r4
            r9 = r6
            r18 = r7
            r19 = r8
            r8 = r0
            goto L_0x01f6
        L_0x01ea:
            r16 = r2
            r10 = r3
            r17 = r4
            r9 = r6
            r18 = r7
            r19 = r8
            r8 = r52
        L_0x01f6:
            r12.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0208
            r0 = -1
            java.lang.String r2 = "androidx.compose.material3.Slider (Slider.kt:154)"
            r3 = -202044027(0xfffffffff3f50d85, float:-3.8830168E31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x0208:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)
            r2 = 1618982084(0x607fb4c4, float:7.370227E19)
            r12.startReplaceableGroup(r2)
            boolean r2 = r12.changed((java.lang.Object) r8)
            boolean r3 = r12.changed((java.lang.Object) r9)
            r2 = r2 | r3
            boolean r0 = r12.changed((java.lang.Object) r0)
            r0 = r0 | r2
            java.lang.Object r2 = r12.rememberedValue()
            if (r0 != 0) goto L_0x022e
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x023d
        L_0x022e:
            androidx.compose.material3.SliderKt$Slider$2$1 r0 = new androidx.compose.material3.SliderKt$Slider$2$1
            r0.<init>(r8, r9, r10, r1)
            r2 = -1923353268(0xffffffff8d5bf54c, float:-6.777985E-31)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r2, r5, r0)
            r12.updateRememberedValue(r2)
        L_0x023d:
            r12.endReplaceableGroup()
            r20 = r2
            kotlin.jvm.functions.Function3 r20 = (kotlin.jvm.functions.Function3) r20
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r2)
            boolean r2 = r12.changed((java.lang.Object) r9)
            boolean r0 = r12.changed((java.lang.Object) r0)
            r0 = r0 | r2
            java.lang.Object r2 = r12.rememberedValue()
            if (r0 != 0) goto L_0x0265
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x0274
        L_0x0265:
            androidx.compose.material3.SliderKt$Slider$3$1 r0 = new androidx.compose.material3.SliderKt$Slider$3$1
            r0.<init>(r9, r10, r1)
            r2 = 1022381539(0x3cf04de3, float:0.029334014)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r2, r5, r0)
            r12.updateRememberedValue(r2)
        L_0x0274:
            r12.endReplaceableGroup()
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r0 = r1 & 14
            r3 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            int r1 = r1 << 3
            r3 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r1
            r0 = r0 | r3
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r1
            r0 = r0 | r3
            r3 = r1 & r41
            r0 = r0 | r3
            r3 = r1 & r42
            r0 = r0 | r3
            r3 = r1 & r43
            r0 = r0 | r3
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r3
            r21 = r0 | r1
            r22 = 0
            r23 = 0
            r0 = r44
            r1 = r45
            r3 = r16
            r4 = r10
            r5 = r17
            r6 = r18
            r7 = r19
            r24 = r8
            r8 = r9
            r25 = r9
            r9 = r24
            r26 = r10
            r10 = r20
            r11 = r12
            r20 = r12
            r12 = r21
            r13 = r22
            r14 = r23
            Slider(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02cb
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02cb:
            r3 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r9 = r24
            r8 = r25
            r4 = r26
        L_0x02d9:
            androidx.compose.runtime.ScopeUpdateScope r12 = r20.endRestartGroup()
            if (r12 != 0) goto L_0x02e0
            goto L_0x02f1
        L_0x02e0:
            androidx.compose.material3.SliderKt$Slider$4 r13 = new androidx.compose.material3.SliderKt$Slider$4
            r0 = r13
            r1 = r44
            r2 = r45
            r10 = r54
            r11 = r55
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.updateScope(r13)
        L_0x02f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: kotlin.jvm.functions.Function3} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x03a3  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0442  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x044e  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0452  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0507  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0517  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0594  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SliderImpl(androidx.compose.ui.Modifier r32, boolean r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r35, kotlin.jvm.functions.Function0<kotlin.Unit> r36, int r37, float r38, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r39, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, int r43) {
        /*
            r11 = r33
            r12 = r34
            r13 = r35
            r14 = r36
            r15 = r38
            r10 = r39
            r9 = r40
            r8 = r41
            r7 = r43
            r0 = 851260148(0x32bd32f4, float:2.2025667E-8)
            r1 = r42
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            r1 = r7 & 14
            r5 = r32
            if (r1 != 0) goto L_0x002c
            boolean r1 = r6.changed((java.lang.Object) r5)
            if (r1 == 0) goto L_0x0029
            r1 = 4
            goto L_0x002a
        L_0x0029:
            r1 = 2
        L_0x002a:
            r1 = r1 | r7
            goto L_0x002d
        L_0x002c:
            r1 = r7
        L_0x002d:
            r3 = r7 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x003d
            boolean r3 = r6.changed((boolean) r11)
            if (r3 == 0) goto L_0x003a
            r3 = 32
            goto L_0x003c
        L_0x003a:
            r3 = 16
        L_0x003c:
            r1 = r1 | r3
        L_0x003d:
            r3 = r7 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x004d
            boolean r3 = r6.changed((java.lang.Object) r12)
            if (r3 == 0) goto L_0x004a
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x004c
        L_0x004a:
            r3 = 128(0x80, float:1.794E-43)
        L_0x004c:
            r1 = r1 | r3
        L_0x004d:
            r3 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x005d
            boolean r3 = r6.changed((java.lang.Object) r13)
            if (r3 == 0) goto L_0x005a
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x005c
        L_0x005a:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x005c:
            r1 = r1 | r3
        L_0x005d:
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r7
            if (r3 != 0) goto L_0x006f
            boolean r3 = r6.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x006c
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006e
        L_0x006c:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x006e:
            r1 = r1 | r3
        L_0x006f:
            r3 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r7
            r4 = r37
            if (r3 != 0) goto L_0x0082
            boolean r3 = r6.changed((int) r4)
            if (r3 == 0) goto L_0x007f
            r3 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0081
        L_0x007f:
            r3 = 65536(0x10000, float:9.18355E-41)
        L_0x0081:
            r1 = r1 | r3
        L_0x0082:
            r3 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r7
            if (r3 != 0) goto L_0x0093
            boolean r3 = r6.changed((float) r15)
            if (r3 == 0) goto L_0x0090
            r3 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0092
        L_0x0090:
            r3 = 524288(0x80000, float:7.34684E-40)
        L_0x0092:
            r1 = r1 | r3
        L_0x0093:
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r7
            if (r3 != 0) goto L_0x00a4
            boolean r3 = r6.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x00a1
            r3 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00a3
        L_0x00a1:
            r3 = 4194304(0x400000, float:5.877472E-39)
        L_0x00a3:
            r1 = r1 | r3
        L_0x00a4:
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r7
            if (r3 != 0) goto L_0x00b5
            boolean r3 = r6.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x00b2
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00b4
        L_0x00b2:
            r3 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00b4:
            r1 = r1 | r3
        L_0x00b5:
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r7
            if (r3 != 0) goto L_0x00c6
            boolean r3 = r6.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x00c3
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00c5
        L_0x00c3:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00c5:
            r1 = r1 | r3
        L_0x00c6:
            r3 = r1
            r1 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r1 = r1 & r3
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            if (r1 != r2) goto L_0x00de
            boolean r1 = r6.getSkipping()
            if (r1 != 0) goto L_0x00d7
            goto L_0x00de
        L_0x00d7:
            r6.skipToGroupEnd()
            r13 = r6
            r10 = r8
            goto L_0x0597
        L_0x00de:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00ea
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.SliderImpl (Slider.kt:798)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r1, r2)
        L_0x00ea:
            java.lang.Float r0 = java.lang.Float.valueOf(r38)
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r6.startReplaceableGroup(r1)
            boolean r0 = r6.changed((java.lang.Object) r0)
            boolean r1 = r6.changed((java.lang.Object) r13)
            r0 = r0 | r1
            java.lang.Object r1 = r6.rememberedValue()
            if (r0 != 0) goto L_0x010b
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x0113
        L_0x010b:
            androidx.compose.material3.SliderKt$SliderImpl$onValueChangeState$1$1 r1 = new androidx.compose.material3.SliderKt$SliderImpl$onValueChangeState$1$1
            r1.<init>(r15, r13)
            r6.updateRememberedValue(r1)
        L_0x0113:
            r6.endReplaceableGroup()
            r2 = 0
            androidx.compose.runtime.State r16 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r1, r6, r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r37)
            r1 = 1157296644(0x44faf204, float:2007.563)
            r6.startReplaceableGroup(r1)
            boolean r0 = r6.changed((java.lang.Object) r0)
            java.lang.Object r1 = r6.rememberedValue()
            if (r0 != 0) goto L_0x0137
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x013e
        L_0x0137:
            float[] r1 = stepsToTickFractions(r37)
            r6.updateRememberedValue(r1)
        L_0x013e:
            r6.endReplaceableGroup()
            float[] r1 = (float[]) r1
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r0)
            java.lang.Object r2 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r19.getEmpty()
            r9 = 0
            if (r2 != r0) goto L_0x016c
            float r0 = getThumbWidth()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r2 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r9, r2, r9)
            r6.updateRememberedValue(r0)
            r31 = r2
            r2 = r0
            r0 = r31
            goto L_0x016d
        L_0x016c:
            r0 = 2
        L_0x016d:
            r6.endReplaceableGroup()
            androidx.compose.runtime.MutableState r2 = (androidx.compose.runtime.MutableState) r2
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r0)
            java.lang.Object r0 = r6.rememberedValue()
            java.lang.Object r9 = r19.getEmpty()
            if (r0 != r9) goto L_0x0193
            r9 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            r21 = r2
            r2 = 0
            r9 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r2, r9, r2)
            r6.updateRememberedValue(r0)
            goto L_0x0195
        L_0x0193:
            r21 = r2
        L_0x0195:
            r6.endReplaceableGroup()
            r9 = r0
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r0 = r6.consume(r0)
            androidx.compose.ui.unit.LayoutDirection r2 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r0 != r2) goto L_0x01ae
            r0 = 1
            r22 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            goto L_0x01b3
        L_0x01ae:
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r22 = 0
        L_0x01b3:
            r6.startReplaceableGroup(r0)
            java.lang.Object r0 = r6.rememberedValue()
            java.lang.Object r2 = r19.getEmpty()
            r4 = 0
            if (r0 != r2) goto L_0x01d3
            float r0 = SliderImpl$scaleToOffset(r10, r4, r4, r15)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r2 = 2
            r4 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r4, r2, r4)
            r6.updateRememberedValue(r0)
            goto L_0x01d5
        L_0x01d3:
            r2 = 2
            r4 = 0
        L_0x01d5:
            r6.endReplaceableGroup()
            r23 = r0
            androidx.compose.runtime.MutableState r23 = (androidx.compose.runtime.MutableState) r23
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r0)
            java.lang.Object r0 = r6.rememberedValue()
            java.lang.Object r2 = r19.getEmpty()
            if (r0 != r2) goto L_0x01f9
            r2 = 0
            java.lang.Float r0 = java.lang.Float.valueOf(r2)
            r2 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r4, r2, r4)
            r6.updateRememberedValue(r0)
        L_0x01f9:
            r6.endReplaceableGroup()
            r24 = r0
            androidx.compose.runtime.MutableState r24 = (androidx.compose.runtime.MutableState) r24
            java.lang.Comparable r0 = r39.getStart()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            java.lang.Comparable r2 = r39.getEndInclusive()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            float r0 = kotlin.ranges.RangesKt___RangesKt.coerceIn((float) r15, (float) r0, (float) r2)
            java.lang.Comparable r2 = r39.getStart()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            java.lang.Comparable r4 = r39.getEndInclusive()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            float r4 = calcFraction(r2, r4, r0)
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r0)
            java.lang.Object r0 = r6.rememberedValue()
            java.lang.Object r2 = r19.getEmpty()
            if (r0 != r2) goto L_0x0248
            androidx.compose.material3.SliderPositions r0 = new androidx.compose.material3.SliderPositions
            r0.<init>(r4, r1)
            r6.updateRememberedValue(r0)
        L_0x0248:
            r6.endReplaceableGroup()
            r2 = r0
            androidx.compose.material3.SliderPositions r2 = (androidx.compose.material3.SliderPositions) r2
            r2.setPositionFraction$material3_release(r4)
            r2.setTickFractions$material3_release(r1)
            int r20 = r3 >> 21
            r0 = 1157296644(0x44faf204, float:2007.563)
            r6.startReplaceableGroup(r0)
            boolean r17 = r6.changed((java.lang.Object) r10)
            java.lang.Object r0 = r6.rememberedValue()
            if (r17 != 0) goto L_0x0279
            r17 = r1
            java.lang.Object r1 = r19.getEmpty()
            if (r0 != r1) goto L_0x026f
            goto L_0x027b
        L_0x026f:
            r27 = r2
            r18 = r3
            r28 = r4
            r10 = r6
            r42 = r21
            goto L_0x02a8
        L_0x0279:
            r17 = r1
        L_0x027b:
            androidx.compose.material3.SliderDraggableState r1 = new androidx.compose.material3.SliderDraggableState
            androidx.compose.material3.SliderKt$SliderImpl$draggableState$1$1 r0 = new androidx.compose.material3.SliderKt$SliderImpl$draggableState$1$1
            r25 = r0
            r26 = 1157296644(0x44faf204, float:2007.563)
            r8 = r1
            r10 = r26
            r1 = r9
            r27 = r2
            r42 = r21
            r10 = 0
            r2 = r42
            r18 = r3
            r3 = r23
            r28 = r4
            r4 = r24
            r5 = r17
            r10 = r6
            r6 = r16
            r7 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.<init>(r0)
            r10.updateRememberedValue(r8)
            r0 = r8
        L_0x02a8:
            r10.endReplaceableGroup()
            r8 = r0
            androidx.compose.material3.SliderDraggableState r8 = (androidx.compose.material3.SliderDraggableState) r8
            androidx.compose.material3.SliderKt$SliderImpl$gestureEndAction$1 r0 = new androidx.compose.material3.SliderKt$SliderImpl$gestureEndAction$1
            r0.<init>(r8, r14)
            r7 = 0
            androidx.compose.runtime.State r6 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r0, r10, r7)
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            java.lang.Object r0 = r9.getValue()
            java.lang.Number r0 = (java.lang.Number) r0
            int r3 = r0.intValue()
            r0 = r5
            r1 = r8
            r2 = r34
            r4 = r22
            r16 = r5
            r5 = r23
            r17 = r6
            r21 = r7
            r7 = r24
            r23 = r8
            r8 = r33
            androidx.compose.ui.Modifier r8 = sliderTapModifier(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Horizontal
            boolean r5 = r23.isDragging()
            r6 = 0
            r0 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r0)
            r0 = r17
            boolean r1 = r10.changed((java.lang.Object) r0)
            java.lang.Object r3 = r10.rememberedValue()
            if (r1 != 0) goto L_0x02fb
            java.lang.Object r1 = r19.getEmpty()
            if (r3 != r1) goto L_0x0304
        L_0x02fb:
            androidx.compose.material3.SliderKt$SliderImpl$drag$1$1 r3 = new androidx.compose.material3.SliderKt$SliderImpl$drag$1$1
            r1 = 0
            r3.<init>(r0, r1)
            r10.updateRememberedValue(r3)
        L_0x0304:
            r10.endReplaceableGroup()
            r7 = r3
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            r17 = 32
            r19 = 0
            r0 = r16
            r1 = r23
            r3 = r33
            r4 = r34
            r29 = r8
            r8 = r22
            r30 = r9
            r9 = r17
            r13 = r10
            r17 = r21
            r10 = r19
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.Modifier r0 = androidx.compose.material3.TouchTargetKt.minimumTouchTargetSize(r32)
            androidx.compose.material3.tokens.SliderTokens r1 = androidx.compose.material3.tokens.SliderTokens.INSTANCE
            float r2 = r1.m2419getHandleWidthD9Ej5fM()
            float r3 = r1.m2418getHandleHeightD9Ej5fM()
            r4 = 0
            r5 = 0
            r6 = 12
            r8 = 0
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r8
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m554requiredSizeInqDBjuR0$default(r0, r1, r2, r3, r4, r5, r6)
            r1 = r38
            r2 = r33
            r3 = r35
            r4 = r36
            r5 = r39
            r6 = r37
            androidx.compose.ui.Modifier r0 = sliderSemantics(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.FocusableKt.focusable(r0, r11, r12)
            r1 = r29
            androidx.compose.ui.Modifier r0 = r0.then(r1)
            androidx.compose.ui.Modifier r0 = r0.then(r7)
            androidx.compose.material3.SliderKt$SliderImpl$2 r1 = new androidx.compose.material3.SliderKt$SliderImpl$2
            r2 = r42
            r4 = r28
            r3 = r30
            r1.<init>(r2, r3, r4)
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r2)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r3 = r13.consume(r3)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r4 = r13.consume(r4)
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r5 = r13.consume(r5)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r8 = r13.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x03a6
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03a6:
            r13.startReusableNode()
            boolean r8 = r13.getInserting()
            if (r8 == 0) goto L_0x03b3
            r13.createNode(r7)
            goto L_0x03b6
        L_0x03b3:
            r13.useNode()
        L_0x03b6:
            r13.disableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m2536constructorimpl(r13)
            kotlin.jvm.functions.Function2 r8 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r1, r8)
            kotlin.jvm.functions.Function2 r1 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r3, r1)
            kotlin.jvm.functions.Function2 r1 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r4, r1)
            kotlin.jvm.functions.Function2 r1 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r5, r1)
            r13.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r17)
            r0.invoke(r1, r13, r3)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r0)
            r1 = 1870435165(0x6f7c935d, float:7.8168374E28)
            r13.startReplaceableGroup(r1)
            androidx.compose.material3.SliderComponents r1 = androidx.compose.material3.SliderComponents.THUMB
            r3 = r16
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r3, r1)
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r4)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r5.getTopStart()
            r8 = r17
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r7, r8, r13, r8)
            r13.startReplaceableGroup(r2)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r9 = r13.consume(r9)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r10 = r13.consume(r10)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r2 = r13.consume(r2)
            androidx.compose.ui.platform.ViewConfiguration r2 = (androidx.compose.ui.platform.ViewConfiguration) r2
            kotlin.jvm.functions.Function0 r4 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r0 = r13.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x0445
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0445:
            r13.startReusableNode()
            boolean r0 = r13.getInserting()
            if (r0 == 0) goto L_0x0452
            r13.createNode(r4)
            goto L_0x0455
        L_0x0452:
            r13.useNode()
        L_0x0455:
            r13.disableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m2536constructorimpl(r13)
            kotlin.jvm.functions.Function2 r4 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r7, r4)
            kotlin.jvm.functions.Function2 r4 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r9, r4)
            kotlin.jvm.functions.Function2 r4 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r10, r4)
            kotlin.jvm.functions.Function2 r4 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r2, r4)
            r13.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r0)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            r1.invoke(r0, r13, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r0)
            r0 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r13.startReplaceableGroup(r0)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            r1 = -1220826601(0xffffffffb73baa17, float:-1.1185671E-5)
            r13.startReplaceableGroup(r1)
            r1 = r20 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r9 = r40
            r2 = r27
            r9.invoke(r2, r13, r1)
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            androidx.compose.material3.SliderComponents r1 = androidx.compose.material3.SliderComponents.TRACK
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r3, r1)
            r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r13.startReplaceableGroup(r3)
            androidx.compose.ui.Alignment r3 = r5.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r8, r13, r8)
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r13.startReplaceableGroup(r4)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r4 = r13.consume(r4)
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r5 = r13.consume(r5)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            java.lang.Object r7 = r13.consume(r7)
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            kotlin.jvm.functions.Function0 r10 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r0 = r13.getApplier()
            boolean r0 = r0 instanceof androidx.compose.runtime.Applier
            if (r0 != 0) goto L_0x050a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x050a:
            r13.startReusableNode()
            boolean r0 = r13.getInserting()
            if (r0 == 0) goto L_0x0517
            r13.createNode(r10)
            goto L_0x051a
        L_0x0517:
            r13.useNode()
        L_0x051a:
            r13.disableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m2536constructorimpl(r13)
            kotlin.jvm.functions.Function2 r10 = r6.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r3, r10)
            kotlin.jvm.functions.Function2 r3 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r4, r3)
            kotlin.jvm.functions.Function2 r3 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r5, r3)
            kotlin.jvm.functions.Function2 r3 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r7, r3)
            r13.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r1.invoke(r0, r13, r3)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r0)
            r0 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r13.startReplaceableGroup(r0)
            r0 = 971611456(0x39e99d40, float:4.4558384E-4)
            r13.startReplaceableGroup(r0)
            int r0 = r18 >> 24
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | 6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r10 = r41
            r10.invoke(r2, r13, r0)
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0597
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0597:
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x059e
            goto L_0x05be
        L_0x059e:
            androidx.compose.material3.SliderKt$SliderImpl$3 r8 = new androidx.compose.material3.SliderKt$SliderImpl$3
            r0 = r8
            r1 = r32
            r2 = r33
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r37
            r7 = r38
            r12 = r8
            r8 = r39
            r9 = r40
            r10 = r41
            r11 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r13.updateScope(r12)
        L_0x05be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.SliderImpl(androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, int, float, kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final float SliderImpl$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, float f11, float f12, float f13) {
        return scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f13, f11, f12);
    }

    /* access modifiers changed from: private */
    public static final float SliderImpl$scaleToUserValue(ClosedFloatingPointRange<Float> closedFloatingPointRange, float f11, float f12, float f13) {
        return scale(f11, f12, f13, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: TempRangeSliderThumb-rAjV9yQ  reason: not valid java name */
    public static final void m1816TempRangeSliderThumbrAjV9yQ(BoxScope boxScope, float f11, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        BoxScope boxScope2 = boxScope;
        float f12 = f11;
        Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        int i16 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-2104116536);
        if ((i16 & 14) == 0) {
            if (startRestartGroup.changed((Object) boxScope2)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i12 = i15 | i16;
        } else {
            i12 = i16;
        }
        if ((i16 & 112) == 0) {
            if (startRestartGroup.changed(f12)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i12 |= i14;
        }
        if ((i16 & 896) == 0) {
            if (startRestartGroup.changed((Object) function32)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        int i17 = i12;
        if ((i17 & 731) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2104116536, i17, -1, "androidx.compose.material3.TempRangeSliderThumb (Slider.kt:946)");
            }
            Modifier r12 = PaddingKt.m490paddingqDBjuR0$default(Modifier.Companion, f11, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            Alignment.Companion companion = Alignment.Companion;
            Modifier align = boxScope2.align(r12, companion.getCenterStart());
            int i18 = (i17 << 3) & 7168;
            startRestartGroup.startReplaceableGroup(733328855);
            int i19 = i18 >> 3;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion.getTopStart(), false, startRestartGroup, (i19 & 112) | (i19 & 14));
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(align);
            int i21 = ((((i18 << 3) & 112) << 9) & 7168) | 6;
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
            Composer r14 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r14, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r14, density, companion2.getSetDensity());
            Updater.m2543setimpl(r14, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r14, viewConfiguration, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i21 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            if (((i21 >> 9) & 14 & 11) != 2 || !startRestartGroup.getSkipping()) {
                function32.invoke(BoxScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i18 >> 6) & 112) | 6));
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$TempRangeSliderThumb$1(boxScope2, f12, function32, i16));
        }
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: TempRangeSliderTrack-au3_HiA  reason: not valid java name */
    public static final void m1817TempRangeSliderTrackau3_HiA(Modifier modifier, SliderColors sliderColors, boolean z11, float f11, float f12, float[] fArr, float f13, float f14, Composer composer, int i11) {
        SliderColors sliderColors2 = sliderColors;
        boolean z12 = z11;
        int i12 = i11;
        Composer startRestartGroup = composer.startRestartGroup(1015664062);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1015664062, i12, -1, "androidx.compose.material3.TempRangeSliderTrack (Slider.kt:960)");
        }
        Ref.FloatRef floatRef = new Ref.FloatRef();
        Ref.FloatRef floatRef2 = new Ref.FloatRef();
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        floatRef.element = density.m5447toPx0680j_4(f13) / ((float) 2);
        floatRef2.element = density.m5447toPx0680j_4(TickSize);
        int i13 = ((i12 >> 6) & 14) | 48 | ((i12 << 3) & 896);
        Modifier modifier2 = modifier;
        CanvasKt.Canvas(modifier2, new SliderKt$TempRangeSliderTrack$2(floatRef, sliderColors2.trackColor$material3_release(z12, false, startRestartGroup, i13), f14, f12, f11, sliderColors2.trackColor$material3_release(z12, true, startRestartGroup, i13), fArr, sliderColors2.tickColor$material3_release(z12, false, startRestartGroup, i13), sliderColors2.tickColor$material3_release(z12, true, startRestartGroup, i13), floatRef2), startRestartGroup, i12 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$TempRangeSliderTrack$3(modifier, sliderColors, z11, f11, f12, fArr, f13, f14, i11));
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
    public static final java.lang.Object m1821awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.material3.SliderKt$awaitSlop$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = (androidx.compose.material3.SliderKt$awaitSlop$1) r0
            int r1 = r0.f8127j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f8127j = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = new androidx.compose.material3.SliderKt$awaitSlop$1
            r0.<init>(r12)
        L_0x0018:
            r6 = r0
            java.lang.Object r12 = r6.f8126i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f8127j
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            java.lang.Object r8 = r6.f8125h
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
            androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1 r5 = new androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1
            r5.<init>(r12)
            r6.f8125h = r12
            r6.f8127j = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r8 = androidx.compose.material3.DragGestureDetectorCopyKt.m1646awaitHorizontalPointerSlopOrCancellationgDDlDlE(r1, r2, r4, r5, r6)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.m1821awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final float calcFraction(float f11, float f12, float f13) {
        float f14 = f12 - f11;
        return RangesKt___RangesKt.coerceIn((f14 > 0.0f ? 1 : (f14 == 0.0f ? 0 : -1)) == 0 ? 0.0f : (f13 - f11) / f14, 0.0f, 1.0f);
    }

    public static final float getThumbWidth() {
        return ThumbWidth;
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
    public static final Modifier sliderSemantics(Modifier modifier, float f11, boolean z11, Function1<? super Float, Unit> function1, Function0<Unit> function0, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i11) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new SliderKt$sliderSemantics$1(z11, closedFloatingPointRange, i11, RangesKt___RangesKt.coerceIn(f11, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue()), function1, function0), 1, (Object) null), f11, closedFloatingPointRange, i11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: kotlin.jvm.functions.Function1<androidx.compose.ui.platform.InspectorInfo, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: androidx.compose.material3.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.compose.material3.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1} */
    /* JADX WARNING: type inference failed for: r0v1, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.ui.Modifier sliderTapModifier(androidx.compose.ui.Modifier r11, androidx.compose.foundation.gestures.DraggableState r12, androidx.compose.foundation.interaction.MutableInteractionSource r13, int r14, boolean r15, androidx.compose.runtime.State<java.lang.Float> r16, androidx.compose.runtime.State<? extends kotlin.jvm.functions.Function0<kotlin.Unit>> r17, androidx.compose.runtime.MutableState<java.lang.Float> r18, boolean r19) {
        /*
            boolean r0 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r0 == 0) goto L_0x0019
            androidx.compose.material3.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1 r0 = new androidx.compose.material3.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1
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
            androidx.compose.material3.SliderKt$sliderTapModifier$2 r10 = new androidx.compose.material3.SliderKt$sliderTapModifier$2
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.sliderTapModifier(androidx.compose.ui.Modifier, androidx.compose.foundation.gestures.DraggableState, androidx.compose.foundation.interaction.MutableInteractionSource, int, boolean, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.runtime.MutableState, boolean):androidx.compose.ui.Modifier");
    }

    /* access modifiers changed from: private */
    public static final float snapValueToTick(float f11, float[] fArr, float f12, float f13) {
        boolean z11;
        Float f14;
        if (fArr.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            f14 = null;
        } else {
            float f15 = fArr[0];
            int lastIndex = ArraysKt___ArraysKt.getLastIndex(fArr);
            if (lastIndex == 0) {
                f14 = Float.valueOf(f15);
            } else {
                float abs = Math.abs(MathHelpersKt.lerp(f12, f13, f15) - f11);
                IntIterator it = new IntRange(1, lastIndex).iterator();
                while (it.hasNext()) {
                    float f16 = fArr[it.nextInt()];
                    float abs2 = Math.abs(MathHelpersKt.lerp(f12, f13, f16) - f11);
                    if (Float.compare(abs, abs2) > 0) {
                        f15 = f16;
                        abs = abs2;
                    }
                }
                f14 = Float.valueOf(f15);
            }
        }
        if (f14 != null) {
            return MathHelpersKt.lerp(f12, f13, f14.floatValue());
        }
        return f11;
    }

    /* access modifiers changed from: private */
    public static final float[] stepsToTickFractions(int i11) {
        if (i11 == 0) {
            return new float[0];
        }
        int i12 = i11 + 2;
        float[] fArr = new float[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            fArr[i13] = ((float) i13) / ((float) (i11 + 1));
        }
        return fArr;
    }

    /* access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> scale(float f11, float f12, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f13, float f14) {
        return RangesKt__RangesKt.rangeTo(scale(f11, f12, closedFloatingPointRange.getStart().floatValue(), f13, f14), scale(f11, f12, closedFloatingPointRange.getEndInclusive().floatValue(), f13, f14));
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x012b  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Slider(float r45, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r46, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r47, boolean r48, @org.jetbrains.annotations.Nullable kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r49, int r50, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r51, @org.jetbrains.annotations.Nullable androidx.compose.material3.SliderColors r52, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r53, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r55, int r56, int r57) {
        /*
            r15 = r46
            r14 = r54
            r13 = r56
            r12 = r57
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "thumb"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1785516312(0x6a6cd118, float:7.1573478E25)
            r1 = r55
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r1 = r12 & 1
            if (r1 == 0) goto L_0x0024
            r1 = r13 | 6
            r10 = r45
            goto L_0x0036
        L_0x0024:
            r1 = r13 & 14
            r10 = r45
            if (r1 != 0) goto L_0x0035
            boolean r1 = r11.changed((float) r10)
            if (r1 == 0) goto L_0x0032
            r1 = 4
            goto L_0x0033
        L_0x0032:
            r1 = 2
        L_0x0033:
            r1 = r1 | r13
            goto L_0x0036
        L_0x0035:
            r1 = r13
        L_0x0036:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x003d
            r1 = r1 | 48
            goto L_0x004d
        L_0x003d:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004d
            boolean r2 = r11.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x004a
            r2 = 32
            goto L_0x004c
        L_0x004a:
            r2 = 16
        L_0x004c:
            r1 = r1 | r2
        L_0x004d:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x0054
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0054:
            r3 = r13 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0067
            r3 = r47
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0063
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r1 = r1 | r4
            goto L_0x0069
        L_0x0067:
            r3 = r47
        L_0x0069:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x0070
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x0070:
            r5 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0083
            r5 = r48
            boolean r6 = r11.changed((boolean) r5)
            if (r6 == 0) goto L_0x007f
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r1 = r1 | r6
            goto L_0x0085
        L_0x0083:
            r5 = r48
        L_0x0085:
            r6 = 57344(0xe000, float:8.0356E-41)
            r7 = r13 & r6
            if (r7 != 0) goto L_0x00a1
            r7 = r12 & 16
            if (r7 != 0) goto L_0x009b
            r7 = r49
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x009d
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009b:
            r7 = r49
        L_0x009d:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r1 = r1 | r8
            goto L_0x00a3
        L_0x00a1:
            r7 = r49
        L_0x00a3:
            r8 = r12 & 32
            r9 = 458752(0x70000, float:6.42848E-40)
            if (r8 == 0) goto L_0x00b0
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r9 = r50
            goto L_0x00c3
        L_0x00b0:
            r16 = r13 & r9
            r9 = r50
            if (r16 != 0) goto L_0x00c3
            boolean r16 = r11.changed((int) r9)
            if (r16 == 0) goto L_0x00bf
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00bf:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c1:
            r1 = r1 | r16
        L_0x00c3:
            r16 = r12 & 64
            r41 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00d0
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r6 = r51
            goto L_0x00e3
        L_0x00d0:
            r17 = r13 & r41
            r6 = r51
            if (r17 != 0) goto L_0x00e3
            boolean r17 = r11.changed((java.lang.Object) r6)
            if (r17 == 0) goto L_0x00df
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r1 = r1 | r17
        L_0x00e3:
            r42 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r13 & r42
            if (r17 != 0) goto L_0x00ff
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x00f8
            r0 = r52
            boolean r17 = r11.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00fa
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fc
        L_0x00f8:
            r0 = r52
        L_0x00fa:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fc:
            r1 = r1 | r17
            goto L_0x0101
        L_0x00ff:
            r0 = r52
        L_0x0101:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r43 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x010e
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r17
            r3 = r53
            goto L_0x0121
        L_0x010e:
            r17 = r13 & r43
            r3 = r53
            if (r17 != 0) goto L_0x0121
            boolean r17 = r11.changed((java.lang.Object) r3)
            if (r17 == 0) goto L_0x011d
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011f
        L_0x011d:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011f:
            r1 = r1 | r17
        L_0x0121:
            r3 = r12 & 512(0x200, float:7.175E-43)
            r44 = 1879048192(0x70000000, float:1.58456325E29)
            if (r3 == 0) goto L_0x012b
            r3 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0129:
            r1 = r1 | r3
            goto L_0x013b
        L_0x012b:
            r3 = r13 & r44
            if (r3 != 0) goto L_0x013b
            boolean r3 = r11.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0138
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0129
        L_0x0138:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0129
        L_0x013b:
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r3 & r1
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x015d
            boolean r3 = r11.getSkipping()
            if (r3 != 0) goto L_0x014b
            goto L_0x015d
        L_0x014b:
            r11.skipToGroupEnd()
            r3 = r47
            r4 = r48
            r8 = r52
            r5 = r7
            r26 = r11
            r7 = r6
            r6 = r9
            r9 = r53
            goto L_0x02b3
        L_0x015d:
            r11.startDefaults()
            r3 = r13 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            r5 = 1
            if (r3 == 0) goto L_0x0190
            boolean r3 = r11.getDefaultsInvalid()
            if (r3 == 0) goto L_0x016f
            goto L_0x0190
        L_0x016f:
            r11.skipToGroupEnd()
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0178
            r1 = r1 & r17
        L_0x0178:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0180
            r0 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r0
        L_0x0180:
            r16 = r47
            r8 = r52
            r20 = r53
            r19 = r6
            r17 = r7
            r18 = r9
            r9 = r48
            goto L_0x020f
        L_0x0190:
            if (r2 == 0) goto L_0x0195
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x0197
        L_0x0195:
            r2 = r47
        L_0x0197:
            if (r4 == 0) goto L_0x019b
            r3 = r5
            goto L_0x019d
        L_0x019b:
            r3 = r48
        L_0x019d:
            r4 = r12 & 16
            if (r4 == 0) goto L_0x01ab
            r4 = 0
            r7 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r4 = kotlin.ranges.RangesKt__RangesKt.rangeTo((float) r4, (float) r7)
            r1 = r1 & r17
            goto L_0x01ac
        L_0x01ab:
            r4 = r7
        L_0x01ac:
            if (r8 == 0) goto L_0x01b0
            r7 = 0
            goto L_0x01b1
        L_0x01b0:
            r7 = r9
        L_0x01b1:
            if (r16 == 0) goto L_0x01b4
            r6 = 0
        L_0x01b4:
            r8 = r12 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x01df
            androidx.compose.material3.SliderDefaults r16 = androidx.compose.material3.SliderDefaults.INSTANCE
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
            androidx.compose.material3.SliderColors r8 = r16.m1815colorsq0g_0yA(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r39, r40)
            r9 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r9
            goto L_0x01e1
        L_0x01df:
            r8 = r52
        L_0x01e1:
            if (r0 == 0) goto L_0x0204
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r0)
            java.lang.Object r0 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r0 != r9) goto L_0x01fc
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r0)
        L_0x01fc:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r20 = r0
            goto L_0x0206
        L_0x0204:
            r20 = r53
        L_0x0206:
            r16 = r2
            r9 = r3
            r17 = r4
            r19 = r6
            r18 = r7
        L_0x020f:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0221
            r0 = -1
            java.lang.String r2 = "androidx.compose.material3.Slider (Slider.kt:235)"
            r3 = 1785516312(0x6a6cd118, float:7.1573478E25)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r0, r2)
        L_0x0221:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r9)
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r2)
            boolean r2 = r11.changed((java.lang.Object) r8)
            boolean r0 = r11.changed((java.lang.Object) r0)
            r0 = r0 | r2
            java.lang.Object r2 = r11.rememberedValue()
            if (r0 != 0) goto L_0x0242
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x0251
        L_0x0242:
            androidx.compose.material3.SliderKt$Slider$6$1 r0 = new androidx.compose.material3.SliderKt$Slider$6$1
            r0.<init>(r8, r9, r1)
            r2 = 1252336501(0x4aa52375, float:5411258.5)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r2, r5, r0)
            r11.updateRememberedValue(r2)
        L_0x0251:
            r11.endReplaceableGroup()
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r0 = r1 & 14
            r3 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            int r3 = r1 << 3
            r4 = r3 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r4
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r3
            r0 = r0 | r4
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r3
            r0 = r0 | r4
            r4 = r3 & r41
            r0 = r0 | r4
            r4 = r3 & r42
            r0 = r0 | r4
            r4 = r3 & r43
            r0 = r0 | r4
            r3 = r3 & r44
            r21 = r0 | r3
            int r0 = r1 >> 27
            r22 = r0 & 14
            r23 = 0
            r0 = r45
            r1 = r46
            r3 = r16
            r4 = r9
            r5 = r17
            r6 = r18
            r7 = r19
            r24 = r8
            r25 = r9
            r9 = r20
            r10 = r54
            r26 = r11
            r12 = r21
            r13 = r22
            r14 = r23
            Slider(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02a5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02a5:
            r3 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r9 = r20
            r8 = r24
            r4 = r25
        L_0x02b3:
            androidx.compose.runtime.ScopeUpdateScope r13 = r26.endRestartGroup()
            if (r13 != 0) goto L_0x02ba
            goto L_0x02cd
        L_0x02ba:
            androidx.compose.material3.SliderKt$Slider$7 r14 = new androidx.compose.material3.SliderKt$Slider$7
            r0 = r14
            r1 = r45
            r2 = r46
            r10 = r54
            r11 = r56
            r12 = r57
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.updateScope(r14)
        L_0x02cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0126  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Slider(float r47, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r48, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r50, boolean r51, @org.jetbrains.annotations.Nullable kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r52, int r53, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r54, @org.jetbrains.annotations.Nullable androidx.compose.material3.SliderColors r55, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r56, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r58, int r59, int r60, int r61) {
        /*
            r12 = r48
            r13 = r49
            r14 = r59
            r15 = r61
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "track"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 387052651(0x1711f46b, float:4.7160526E-25)
            r1 = r58
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r1 = r15 & 1
            if (r1 == 0) goto L_0x0024
            r1 = r14 | 6
            r10 = r47
            goto L_0x0036
        L_0x0024:
            r1 = r14 & 14
            r10 = r47
            if (r1 != 0) goto L_0x0035
            boolean r1 = r11.changed((float) r10)
            if (r1 == 0) goto L_0x0032
            r1 = 4
            goto L_0x0033
        L_0x0032:
            r1 = 2
        L_0x0033:
            r1 = r1 | r14
            goto L_0x0036
        L_0x0035:
            r1 = r14
        L_0x0036:
            r4 = r15 & 2
            if (r4 == 0) goto L_0x003d
            r1 = r1 | 48
            goto L_0x004d
        L_0x003d:
            r4 = r14 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004d
            boolean r4 = r11.changed((java.lang.Object) r12)
            if (r4 == 0) goto L_0x004a
            r4 = 32
            goto L_0x004c
        L_0x004a:
            r4 = 16
        L_0x004c:
            r1 = r1 | r4
        L_0x004d:
            r4 = r15 & 4
            if (r4 == 0) goto L_0x0054
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0054:
            r4 = r14 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0064
            boolean r4 = r11.changed((java.lang.Object) r13)
            if (r4 == 0) goto L_0x0061
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r1 = r1 | r4
        L_0x0064:
            r4 = r15 & 8
            if (r4 == 0) goto L_0x006b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x007e
        L_0x006b:
            r5 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x007e
            r5 = r50
            boolean r6 = r11.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x007a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r1 = r1 | r6
            goto L_0x0080
        L_0x007e:
            r5 = r50
        L_0x0080:
            r6 = r15 & 16
            r7 = 57344(0xe000, float:8.0356E-41)
            if (r6 == 0) goto L_0x008a
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x008a:
            r8 = r14 & r7
            if (r8 != 0) goto L_0x009d
            r8 = r51
            boolean r9 = r11.changed((boolean) r8)
            if (r9 == 0) goto L_0x0099
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r1 = r1 | r9
            goto L_0x009f
        L_0x009d:
            r8 = r51
        L_0x009f:
            r9 = 458752(0x70000, float:6.42848E-40)
            r16 = r14 & r9
            if (r16 != 0) goto L_0x00b9
            r16 = r15 & 32
            r2 = r52
            if (r16 != 0) goto L_0x00b4
            boolean r16 = r11.changed((java.lang.Object) r2)
            if (r16 == 0) goto L_0x00b4
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b4:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r1 = r1 | r16
            goto L_0x00bb
        L_0x00b9:
            r2 = r52
        L_0x00bb:
            r16 = r15 & 64
            r41 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00c8
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r9 = r53
            goto L_0x00db
        L_0x00c8:
            r17 = r14 & r41
            r9 = r53
            if (r17 != 0) goto L_0x00db
            boolean r17 = r11.changed((int) r9)
            if (r17 == 0) goto L_0x00d7
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d9
        L_0x00d7:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d9:
            r1 = r1 | r17
        L_0x00db:
            r7 = r15 & 128(0x80, float:1.794E-43)
            r42 = 29360128(0x1c00000, float:7.052966E-38)
            if (r7 == 0) goto L_0x00e8
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r17
            r0 = r54
            goto L_0x00fb
        L_0x00e8:
            r17 = r14 & r42
            r0 = r54
            if (r17 != 0) goto L_0x00fb
            boolean r17 = r11.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x00f7
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f9
        L_0x00f7:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f9:
            r1 = r1 | r17
        L_0x00fb:
            r43 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r14 & r43
            if (r17 != 0) goto L_0x0117
            r3 = r15 & 256(0x100, float:3.59E-43)
            if (r3 != 0) goto L_0x0110
            r3 = r55
            boolean r18 = r11.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x0112
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0114
        L_0x0110:
            r3 = r55
        L_0x0112:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0114:
            r1 = r1 | r18
            goto L_0x0119
        L_0x0117:
            r3 = r55
        L_0x0119:
            r0 = r15 & 512(0x200, float:7.175E-43)
            r44 = 1879048192(0x70000000, float:1.58456325E29)
            if (r0 == 0) goto L_0x0126
            r18 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r18
            r2 = r56
            goto L_0x0139
        L_0x0126:
            r18 = r14 & r44
            r2 = r56
            if (r18 != 0) goto L_0x0139
            boolean r18 = r11.changed((java.lang.Object) r2)
            if (r18 == 0) goto L_0x0135
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0137
        L_0x0135:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0137:
            r1 = r1 | r18
        L_0x0139:
            r18 = r60 & 14
            if (r18 != 0) goto L_0x0155
            r2 = r15 & 1024(0x400, float:1.435E-42)
            if (r2 != 0) goto L_0x014c
            r2 = r57
            boolean r18 = r11.changed((java.lang.Object) r2)
            if (r18 == 0) goto L_0x014e
            r18 = 4
            goto L_0x0150
        L_0x014c:
            r2 = r57
        L_0x014e:
            r18 = 2
        L_0x0150:
            r18 = r60 | r18
            r45 = r18
            goto L_0x0159
        L_0x0155:
            r2 = r57
            r45 = r60
        L_0x0159:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r1 & r18
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r3) goto L_0x0183
            r2 = r45 & 11
            r3 = 2
            if (r2 != r3) goto L_0x0183
            boolean r2 = r11.getSkipping()
            if (r2 != 0) goto L_0x016f
            goto L_0x0183
        L_0x016f:
            r11.skipToGroupEnd()
            r6 = r52
            r10 = r56
            r4 = r5
            r5 = r8
            r7 = r9
            r25 = r11
            r8 = r54
            r9 = r55
            r11 = r57
            goto L_0x031b
        L_0x0183:
            r11.startDefaults()
            r2 = r14 & 1
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r2 == 0) goto L_0x01c0
            boolean r2 = r11.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0194
            goto L_0x01c0
        L_0x0194:
            r11.skipToGroupEnd()
            r0 = r15 & 32
            if (r0 == 0) goto L_0x019d
            r1 = r1 & r17
        L_0x019d:
            r0 = r15 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x01a5
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r0
        L_0x01a5:
            r0 = r15 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x01ab
            r45 = r45 & -15
        L_0x01ab:
            r18 = r52
            r20 = r54
            r21 = r55
            r22 = r56
            r23 = r57
            r16 = r5
            r17 = r8
            r19 = r9
            r2 = r45
            r0 = 1
            goto L_0x029f
        L_0x01c0:
            if (r4 == 0) goto L_0x01c5
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x01c6
        L_0x01c5:
            r2 = r5
        L_0x01c6:
            if (r6 == 0) goto L_0x01c9
            r8 = 1
        L_0x01c9:
            r4 = r15 & 32
            if (r4 == 0) goto L_0x01d7
            r4 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r4 = kotlin.ranges.RangesKt__RangesKt.rangeTo((float) r4, (float) r5)
            r1 = r1 & r17
            goto L_0x01d9
        L_0x01d7:
            r4 = r52
        L_0x01d9:
            if (r16 == 0) goto L_0x01dd
            r5 = 0
            goto L_0x01de
        L_0x01dd:
            r5 = r9
        L_0x01de:
            if (r7 == 0) goto L_0x01e2
            r6 = 0
            goto L_0x01e4
        L_0x01e2:
            r6 = r54
        L_0x01e4:
            r7 = r15 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x020f
            androidx.compose.material3.SliderDefaults r16 = androidx.compose.material3.SliderDefaults.INSTANCE
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
            androidx.compose.material3.SliderColors r7 = r16.m1815colorsq0g_0yA(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r39, r40)
            r9 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r9
            goto L_0x0211
        L_0x020f:
            r7 = r55
        L_0x0211:
            if (r0 == 0) goto L_0x0232
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r0)
            java.lang.Object r0 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r0 != r9) goto L_0x022c
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r0)
        L_0x022c:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x0234
        L_0x0232:
            r0 = r56
        L_0x0234:
            r9 = r15 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x028a
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r8)
            r3 = 1618982084(0x607fb4c4, float:7.370227E19)
            r11.startReplaceableGroup(r3)
            boolean r3 = r11.changed((java.lang.Object) r0)
            boolean r16 = r11.changed((java.lang.Object) r7)
            r3 = r3 | r16
            boolean r9 = r11.changed((java.lang.Object) r9)
            r3 = r3 | r9
            java.lang.Object r9 = r11.rememberedValue()
            if (r3 != 0) goto L_0x0264
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r9 != r3) goto L_0x0260
            goto L_0x0264
        L_0x0260:
            r16 = r0
            r0 = 1
            goto L_0x0276
        L_0x0264:
            androidx.compose.material3.SliderKt$Slider$9$1 r3 = new androidx.compose.material3.SliderKt$Slider$9$1
            r3.<init>(r0, r7, r8, r1)
            r9 = 1647281944(0x622f8718, float:8.094787E20)
            r16 = r0
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r9, r0, r3)
            r11.updateRememberedValue(r9)
        L_0x0276:
            r11.endReplaceableGroup()
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            r45 = r45 & -15
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r17 = r8
            r23 = r9
            goto L_0x0299
        L_0x028a:
            r16 = r0
            r0 = 1
            r23 = r57
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r17 = r8
        L_0x0299:
            r22 = r16
            r16 = r2
            r2 = r45
        L_0x029f:
            r11.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x02b0
            java.lang.String r3 = "androidx.compose.material3.Slider (Slider.kt:312)"
            r4 = 387052651(0x1711f46b, float:4.7160526E-25)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r3)
        L_0x02b0:
            if (r19 < 0) goto L_0x02b4
            r3 = r0
            goto L_0x02b5
        L_0x02b4:
            r3 = 0
        L_0x02b5:
            if (r3 == 0) goto L_0x0340
            int r0 = r1 >> 9
            r3 = r0 & 14
            r4 = r0 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            int r4 = r1 >> 21
            r4 = r4 & 896(0x380, float:1.256E-42)
            r3 = r3 | r4
            int r4 = r1 << 6
            r5 = r4 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r5
            r5 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r5
            r0 = r0 | r3
            int r3 = r1 >> 3
            r5 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r5
            r0 = r0 | r3
            int r3 = r1 << 18
            r3 = r3 & r41
            r0 = r0 | r3
            r3 = r4 & r42
            r0 = r0 | r3
            int r2 = r2 << 24
            r2 = r2 & r43
            r0 = r0 | r2
            int r1 = r1 << 21
            r1 = r1 & r44
            r24 = r0 | r1
            r0 = r16
            r1 = r17
            r2 = r22
            r3 = r48
            r4 = r20
            r5 = r19
            r6 = r47
            r7 = r18
            r8 = r23
            r9 = r49
            r10 = r11
            r25 = r11
            r11 = r24
            SliderImpl(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x030b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x030b:
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = r23
        L_0x031b:
            androidx.compose.runtime.ScopeUpdateScope r3 = r25.endRestartGroup()
            if (r3 != 0) goto L_0x0322
            goto L_0x033f
        L_0x0322:
            androidx.compose.material3.SliderKt$Slider$11 r2 = new androidx.compose.material3.SliderKt$Slider$11
            r0 = r2
            r1 = r47
            r15 = r2
            r2 = r48
            r12 = r3
            r3 = r49
            r13 = r12
            r12 = r59
            r14 = r13
            r13 = r60
            r46 = r14
            r14 = r61
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r46
            r0.updateScope(r15)
        L_0x033f:
            return
        L_0x0340:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "steps should be >= 0"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(float, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
