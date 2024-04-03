package androidx.compose.ui.input.pointer;

import a0.a;
import a0.b;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import com.instabug.library.model.State;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001cB\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ@\u0010/\u001a\u0002H0\"\u0004\b\u0000\u001002'\u00101\u001a#\b\u0001\u0012\u0004\u0012\u000203\u0012\n\u0012\b\u0012\u0004\u0012\u0002H004\u0012\u0006\u0012\u0004\u0018\u00010502¢\u0006\u0002\b6H@ø\u0001\u0000¢\u0006\u0002\u00107J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<H\u0002J-\u0010=\u001a\u0002092\u0006\u0010;\u001a\u00020<2\u001a\u00101\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u00030\u001bR\u00020\u0000\u0012\u0004\u0012\u0002090>H\bJ\b\u0010?\u001a\u000209H\u0016J-\u0010@\u001a\u0002092\u0006\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<2\u0006\u0010A\u001a\u00020\nH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u001a\u0010D\u001a\u00020E*\u00020FH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u001a\u0010D\u001a\u00020E*\u00020IH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ\u001a\u0010L\u001a\u00020F*\u00020IH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\u001d\u0010L\u001a\u00020F*\u00020\u0016H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001d\u0010L\u001a\u00020F*\u00020EH\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010QJ\u001a\u0010R\u001a\u00020S*\u00020\u001dH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\u001a\u0010V\u001a\u00020\u0016*\u00020FH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010PJ\u001a\u0010V\u001a\u00020\u0016*\u00020IH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010NJ\r\u0010Y\u001a\u00020Z*\u00020[H\u0001J\u001a\u0010\\\u001a\u00020\u001d*\u00020SH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b]\u0010UJ\u001a\u0010^\u001a\u00020I*\u00020FH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b_\u0010`J\u001d\u0010^\u001a\u00020I*\u00020\u0016H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010`J\u001d\u0010^\u001a\u00020I*\u00020EH\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010bR\u0019\u0010\t\u001a\u00020\nX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000bR \u0010\f\u001a\u00020\rX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00168\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u001bR\u00020\u00000\u001aX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u00020\u001d8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00168\u0016X\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\u0018R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u00030\u001bR\u00020\u00000\u001aX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006d"}, d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter;", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "Landroidx/compose/ui/input/pointer/PointerInputModifier;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "density", "(Landroidx/compose/ui/platform/ViewConfiguration;Landroidx/compose/ui/unit/Density;)V", "boundsSize", "Landroidx/compose/ui/unit/IntSize;", "J", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$annotations", "()V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "", "getDensity", "()F", "dispatchingPointerHandlers", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter$PointerEventHandlerCoroutine;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "interceptOutOfBoundsChildEvents", "", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "lastPointerEvent", "pointerHandlers", "pointerInputFilter", "getPointerInputFilter", "()Landroidx/compose/ui/input/pointer/PointerInputFilter;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEventScope", "R", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPointerEvent", "", "pointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "forEachCurrentPointerHandler", "Lkotlin/Function1;", "onCancel", "onPointerEvent", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "PointerEventHandlerCoroutine", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SuspendingPointerInputFilter extends PointerInputFilter implements PointerInputModifier, PointerInputScope, Density {
    private final /* synthetic */ Density $$delegate_0;
    /* access modifiers changed from: private */
    public long boundsSize;
    @NotNull
    private CoroutineScope coroutineScope;
    /* access modifiers changed from: private */
    @NotNull
    public PointerEvent currentEvent;
    @NotNull
    private final MutableVector<PointerEventHandlerCoroutine<?>> dispatchingPointerHandlers;
    private boolean interceptOutOfBoundsChildEvents;
    @Nullable
    private PointerEvent lastPointerEvent;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableVector<PointerEventHandlerCoroutine<?>> pointerHandlers;
    @NotNull
    private final ViewConfiguration viewConfiguration;

    @Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0006J\u0019\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*J\u0016\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\bJ\u001e\u0010-\u001a\u00020(2\f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0016ø\u0001\u0000¢\u0006\u0002\u00100JH\u00101\u001a\u0002H2\"\u0004\b\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\b8H@ø\u0001\u0000¢\u0006\u0002\u00109JJ\u0010:\u001a\u0004\u0018\u0001H2\"\u0004\b\u0001\u001022\u0006\u00103\u001a\u0002042'\u00105\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u0004\u0012\u0006\u0012\u0004\u0018\u00010706¢\u0006\u0002\b8H@ø\u0001\u0000¢\u0006\u0002\u00109J\u001a\u0010;\u001a\u00020<*\u00020=H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001a\u0010;\u001a\u00020<*\u00020@H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u001a\u0010C\u001a\u00020=*\u00020@H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001d\u0010C\u001a\u00020=*\u00020\u0012H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001d\u0010C\u001a\u00020=*\u00020<H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010HJ\u001a\u0010I\u001a\u00020J*\u00020\u0016H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u001a\u0010M\u001a\u00020\u0012*\u00020=H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010GJ\u001a\u0010M\u001a\u00020\u0012*\u00020@H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010EJ\r\u0010P\u001a\u00020Q*\u00020RH\u0001J\u001a\u0010S\u001a\u00020\u0016*\u00020JH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010LJ\u001a\u0010U\u001a\u00020@*\u00020=H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ\u001d\u0010U\u001a\u00020@*\u00020\u0012H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010WJ\u001d\u0010U\u001a\u00020@*\u00020<H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u00020\u00168VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00128\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u00020\u001e8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020!8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter$PointerEventHandlerCoroutine;", "R", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/coroutines/Continuation;", "completion", "(Landroidx/compose/ui/input/pointer/SuspendingPointerInputFilter;Lkotlin/coroutines/Continuation;)V", "awaitPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "density", "", "getDensity", "()F", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "fontScale", "getFontScale", "pointerAwaiter", "Lkotlinx/coroutines/CancellableContinuation;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "cause", "", "offerPointerEvent", "event", "resumeWith", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "withTimeout", "T", "timeMillis", "", "block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class PointerEventHandlerCoroutine<R> implements AwaitPointerEventScope, Density, Continuation<R> {
        private final /* synthetic */ SuspendingPointerInputFilter $$delegate_0;
        /* access modifiers changed from: private */
        @NotNull
        public PointerEventPass awaitPass = PointerEventPass.Main;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SuspendingPointerInputFilter f9801b;
        @NotNull
        private final Continuation<R> completion;
        @NotNull
        private final CoroutineContext context = EmptyCoroutineContext.INSTANCE;
        /* access modifiers changed from: private */
        @Nullable
        public CancellableContinuation<? super PointerEvent> pointerAwaiter;

        public PointerEventHandlerCoroutine(@NotNull SuspendingPointerInputFilter suspendingPointerInputFilter, Continuation<? super R> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            this.f9801b = suspendingPointerInputFilter;
            this.completion = continuation;
            this.$$delegate_0 = suspendingPointerInputFilter;
        }

        @Nullable
        public Object awaitPointerEvent(@NotNull PointerEventPass pointerEventPass, @NotNull Continuation<? super PointerEvent> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            this.awaitPass = pointerEventPass;
            this.pointerAwaiter = cancellableContinuationImpl;
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        public final void cancel(@Nullable Throwable th2) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation = this.pointerAwaiter;
            if (cancellableContinuation != null) {
                cancellableContinuation.cancel(th2);
            }
            this.pointerAwaiter = null;
        }

        @NotNull
        public CoroutineContext getContext() {
            return this.context;
        }

        @NotNull
        public PointerEvent getCurrentEvent() {
            return this.f9801b.currentEvent;
        }

        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        /* renamed from: getExtendedTouchPadding-NH-jbRc  reason: not valid java name */
        public long m4399getExtendedTouchPaddingNHjbRc() {
            return this.f9801b.m4385getExtendedTouchPaddingNHjbRc();
        }

        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        /* renamed from: getSize-YbymL2g  reason: not valid java name */
        public long m4400getSizeYbymL2g() {
            return this.f9801b.boundsSize;
        }

        @NotNull
        public ViewConfiguration getViewConfiguration() {
            return this.f9801b.getViewConfiguration();
        }

        public final void offerPointerEvent(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pointerEventPass) {
            CancellableContinuation<? super PointerEvent> cancellableContinuation;
            Intrinsics.checkNotNullParameter(pointerEvent, "event");
            Intrinsics.checkNotNullParameter(pointerEventPass, "pass");
            if (pointerEventPass == this.awaitPass && (cancellableContinuation = this.pointerAwaiter) != null) {
                this.pointerAwaiter = null;
                cancellableContinuation.resumeWith(Result.m6329constructorimpl(pointerEvent));
            }
        }

        public void resumeWith(@NotNull Object obj) {
            MutableVector access$getPointerHandlers$p = this.f9801b.pointerHandlers;
            SuspendingPointerInputFilter suspendingPointerInputFilter = this.f9801b;
            synchronized (access$getPointerHandlers$p) {
                suspendingPointerInputFilter.pointerHandlers.remove(this);
                Unit unit = Unit.INSTANCE;
            }
            this.completion.resumeWith(obj);
        }

        @Stable
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public int m4401roundToPxR2X_6o(long j11) {
            return this.$$delegate_0.m4387roundToPxR2X_6o(j11);
        }

        @Stable
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public int m4402roundToPx0680j_4(float f11) {
            return this.$$delegate_0.m4388roundToPx0680j_4(f11);
        }

        @Stable
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public float m4403toDpGaN1DYA(long j11) {
            return this.$$delegate_0.m4389toDpGaN1DYA(j11);
        }

        @Stable
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public float m4404toDpu2uoSUM(float f11) {
            return this.$$delegate_0.m4390toDpu2uoSUM(f11);
        }

        @Stable
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public float m4405toDpu2uoSUM(int i11) {
            return this.$$delegate_0.m4391toDpu2uoSUM(i11);
        }

        @Stable
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public long m4406toDpSizekrfVVM(long j11) {
            return this.$$delegate_0.m4392toDpSizekrfVVM(j11);
        }

        @Stable
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public float m4407toPxR2X_6o(long j11) {
            return this.$$delegate_0.m4393toPxR2X_6o(j11);
        }

        @Stable
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public float m4408toPx0680j_4(float f11) {
            return this.$$delegate_0.m4394toPx0680j_4(f11);
        }

        @NotNull
        @Stable
        public Rect toRect(@NotNull DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "<this>");
            return this.$$delegate_0.toRect(dpRect);
        }

        @Stable
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public long m4409toSizeXkaWNTQ(long j11) {
            return this.$$delegate_0.m4395toSizeXkaWNTQ(j11);
        }

        @Stable
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public long m4410toSp0xMU5do(float f11) {
            return this.$$delegate_0.m4396toSp0xMU5do(f11);
        }

        @Stable
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public long m4411toSpkPz2Gy4(float f11) {
            return this.$$delegate_0.m4397toSpkPz2Gy4(f11);
        }

        @Stable
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public long m4412toSpkPz2Gy4(int i11) {
            return this.$$delegate_0.m4398toSpkPz2Gy4(i11);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> java.lang.Object withTimeout(long r12, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r15) {
            /*
                r11 = this;
                boolean r0 = r15 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1
                if (r0 == 0) goto L_0x0013
                r0 = r15
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1) r0
                int r1 = r0.f9805k
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f9805k = r1
                goto L_0x0018
            L_0x0013:
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1
                r0.<init>(r11, r15)
            L_0x0018:
                java.lang.Object r15 = r0.f9803i
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.f9805k
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L_0x0038
                if (r2 != r3) goto L_0x0030
                java.lang.Object r12 = r0.f9802h
                kotlinx.coroutines.Job r12 = (kotlinx.coroutines.Job) r12
                kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x002e }
                goto L_0x0075
            L_0x002e:
                r13 = move-exception
                goto L_0x0079
            L_0x0030:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L_0x0038:
                kotlin.ResultKt.throwOnFailure(r15)
                r5 = 0
                int r15 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
                if (r15 > 0) goto L_0x0057
                kotlinx.coroutines.CancellableContinuation<? super androidx.compose.ui.input.pointer.PointerEvent> r15 = r11.pointerAwaiter
                if (r15 == 0) goto L_0x0057
                kotlin.Result$Companion r2 = kotlin.Result.Companion
                androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException r2 = new androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
                r2.<init>(r12)
                java.lang.Object r2 = kotlin.ResultKt.createFailure(r2)
                java.lang.Object r2 = kotlin.Result.m6329constructorimpl(r2)
                r15.resumeWith(r2)
            L_0x0057:
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter r15 = r11.f9801b
                kotlinx.coroutines.CoroutineScope r5 = r15.getCoroutineScope()
                r6 = 0
                r7 = 0
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1 r8 = new androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1
                r8.<init>(r12, r11, r4)
                r9 = 3
                r10 = 0
                kotlinx.coroutines.Job r12 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r5, r6, r7, r8, r9, r10)
                r0.f9802h = r12     // Catch:{ all -> 0x002e }
                r0.f9805k = r3     // Catch:{ all -> 0x002e }
                java.lang.Object r15 = r14.invoke(r11, r0)     // Catch:{ all -> 0x002e }
                if (r15 != r1) goto L_0x0075
                return r1
            L_0x0075:
                kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r12, (java.util.concurrent.CancellationException) r4, (int) r3, (java.lang.Object) r4)
                return r15
            L_0x0079:
                kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r12, (java.util.concurrent.CancellationException) r4, (int) r3, (java.lang.Object) r4)
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.PointerEventHandlerCoroutine.withTimeout(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> java.lang.Object withTimeoutOrNull(long r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.AwaitPointerEventScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r8) {
            /*
                r4 = this;
                boolean r0 = r8 instanceof androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                if (r0 == 0) goto L_0x0013
                r0 = r8
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = (androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1) r0
                int r1 = r0.f9811j
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f9811j = r1
                goto L_0x0018
            L_0x0013:
                androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1 r0 = new androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1
                r0.<init>(r4, r8)
            L_0x0018:
                java.lang.Object r8 = r0.f9809h
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.f9811j
                r3 = 1
                if (r2 == 0) goto L_0x0031
                if (r2 != r3) goto L_0x0029
                kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ PointerEventTimeoutCancellationException -> 0x003d }
                goto L_0x003e
            L_0x0029:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x0031:
                kotlin.ResultKt.throwOnFailure(r8)
                r0.f9811j = r3     // Catch:{ PointerEventTimeoutCancellationException -> 0x003d }
                java.lang.Object r8 = r4.withTimeout(r5, r7, r0)     // Catch:{ PointerEventTimeoutCancellationException -> 0x003d }
                if (r8 != r1) goto L_0x003e
                return r1
            L_0x003d:
                r8 = 0
            L_0x003e:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.PointerEventHandlerCoroutine.withTimeoutOrNull(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PointerEventPass.values().length];
            iArr[PointerEventPass.Initial.ordinal()] = 1;
            iArr[PointerEventPass.Final.ordinal()] = 2;
            iArr[PointerEventPass.Main.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuspendingPointerInputFilter(ViewConfiguration viewConfiguration2, Density density, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewConfiguration2, (i11 & 2) != 0 ? DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null) : density);
    }

    private final void dispatchPointerEvent(PointerEvent pointerEvent, PointerEventPass pointerEventPass) {
        synchronized (this.pointerHandlers) {
            MutableVector<PointerEventHandlerCoroutine<?>> mutableVector = this.dispatchingPointerHandlers;
            mutableVector.addAll(mutableVector.getSize(), this.pointerHandlers);
        }
        try {
            int i11 = WhenMappings.$EnumSwitchMapping$0[pointerEventPass.ordinal()];
            if (i11 == 1 || i11 == 2) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
                int size = mutableVector2.getSize();
                if (size > 0) {
                    Object[] content = mutableVector2.getContent();
                    Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    int i12 = 0;
                    do {
                        ((PointerEventHandlerCoroutine) content[i12]).offerPointerEvent(pointerEvent, pointerEventPass);
                        i12++;
                    } while (i12 < size);
                }
            } else if (i11 == 3) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                int size2 = mutableVector3.getSize();
                if (size2 > 0) {
                    int i13 = size2 - 1;
                    Object[] content2 = mutableVector3.getContent();
                    Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    do {
                        ((PointerEventHandlerCoroutine) content2[i13]).offerPointerEvent(pointerEvent, pointerEventPass);
                        i13--;
                    } while (i13 >= 0);
                }
            }
        } finally {
            this.dispatchingPointerHandlers.clear();
        }
    }

    /* JADX INFO: finally extract failed */
    private final void forEachCurrentPointerHandler(PointerEventPass pointerEventPass, Function1<? super PointerEventHandlerCoroutine<?>, Unit> function1) {
        synchronized (this.pointerHandlers) {
            try {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector = this.dispatchingPointerHandlers;
                mutableVector.addAll(mutableVector.getSize(), this.pointerHandlers);
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        InlineMarker.finallyEnd(1);
        try {
            int i11 = WhenMappings.$EnumSwitchMapping$0[pointerEventPass.ordinal()];
            if (i11 == 1 || i11 == 2) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector2 = this.dispatchingPointerHandlers;
                int size = mutableVector2.getSize();
                if (size > 0) {
                    Object[] content = mutableVector2.getContent();
                    Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    int i12 = 0;
                    do {
                        function1.invoke(content[i12]);
                        i12++;
                    } while (i12 < size);
                }
            } else if (i11 == 3) {
                MutableVector<PointerEventHandlerCoroutine<?>> mutableVector3 = this.dispatchingPointerHandlers;
                int size2 = mutableVector3.getSize();
                if (size2 > 0) {
                    int i13 = size2 - 1;
                    Object[] content2 = mutableVector3.getContent();
                    Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    do {
                        function1.invoke(content2[i13]);
                        i13--;
                    } while (i13 >= 0);
                }
            }
        } finally {
            InlineMarker.finallyStart(1);
            this.dispatchingPointerHandlers.clear();
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ void getCoroutineScope$annotations() {
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    @Nullable
    public <R> Object awaitPointerEventScope(@NotNull Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        PointerEventHandlerCoroutine pointerEventHandlerCoroutine = new PointerEventHandlerCoroutine(this, cancellableContinuationImpl);
        synchronized (this.pointerHandlers) {
            this.pointerHandlers.add(pointerEventHandlerCoroutine);
            Continuation<Unit> createCoroutine = ContinuationKt.createCoroutine(function2, pointerEventHandlerCoroutine, pointerEventHandlerCoroutine);
            Result.Companion companion = Result.Companion;
            createCoroutine.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
        }
        cancellableContinuationImpl.invokeOnCancellation(new SuspendingPointerInputFilter$awaitPointerEventScope$2$2(pointerEventHandlerCoroutine));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    /* renamed from: getExtendedTouchPadding-NH-jbRc  reason: not valid java name */
    public long m4385getExtendedTouchPaddingNHjbRc() {
        long r02 = m4395toSizeXkaWNTQ(getViewConfiguration().m4881getMinimumTouchTargetSizeMYxV2XQ());
        long r22 = m4326getSizeYbymL2g();
        return SizeKt.Size(Math.max(0.0f, Size.m2745getWidthimpl(r02) - ((float) IntSize.m5638getWidthimpl(r22))) / 2.0f, Math.max(0.0f, Size.m2742getHeightimpl(r02) - ((float) IntSize.m5637getHeightimpl(r22))) / 2.0f);
    }

    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    public boolean getInterceptOutOfBoundsChildEvents() {
        return this.interceptOutOfBoundsChildEvents;
    }

    @NotNull
    public PointerInputFilter getPointerInputFilter() {
        return this;
    }

    @NotNull
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public void onCancel() {
        boolean z11;
        PointerEvent pointerEvent = this.lastPointerEvent;
        if (pointerEvent != null) {
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i11 = 0;
            while (true) {
                z11 = true;
                if (i11 >= size) {
                    break;
                } else if (!(true ^ changes.get(i11).getPressed())) {
                    z11 = false;
                    break;
                } else {
                    i11++;
                }
            }
            if (!z11) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                ArrayList arrayList = new ArrayList(changes2.size());
                int size2 = changes2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    PointerInputChange pointerInputChange = changes2.get(i12);
                    arrayList.add(new PointerInputChange(pointerInputChange.m4305getIdJ3iCeTQ(), pointerInputChange.getUptimeMillis(), pointerInputChange.m4306getPositionF1C5BW0(), false, pointerInputChange.getPressure(), pointerInputChange.getUptimeMillis(), pointerInputChange.m4306getPositionF1C5BW0(), pointerInputChange.getPressed(), pointerInputChange.getPressed(), 0, 0, 1536, (DefaultConstructorMarker) null));
                }
                PointerEvent pointerEvent2 = new PointerEvent(arrayList);
                this.currentEvent = pointerEvent2;
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Initial);
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Main);
                dispatchPointerEvent(pointerEvent2, PointerEventPass.Final);
                this.lastPointerEvent = null;
            }
        }
    }

    /* renamed from: onPointerEvent-H0pRuoY  reason: not valid java name */
    public void m4386onPointerEventH0pRuoY(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pointerEventPass, long j11) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pointerEventPass, "pass");
        this.boundsSize = j11;
        if (pointerEventPass == PointerEventPass.Initial) {
            this.currentEvent = pointerEvent;
        }
        dispatchPointerEvent(pointerEvent, pointerEventPass);
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                z11 = true;
                break;
            } else if (!PointerEventKt.changedToUpIgnoreConsumed(changes.get(i11))) {
                break;
            } else {
                i11++;
            }
        }
        if (!(!z11)) {
            pointerEvent = null;
        }
        this.lastPointerEvent = pointerEvent;
    }

    @Stable
    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m4387roundToPxR2X_6o(long j11) {
        return this.$$delegate_0.m5440roundToPxR2X_6o(j11);
    }

    @Stable
    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m4388roundToPx0680j_4(float f11) {
        return this.$$delegate_0.m5441roundToPx0680j_4(f11);
    }

    public final void setCoroutineScope(@NotNull CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "<set-?>");
        this.coroutineScope = coroutineScope2;
    }

    public void setInterceptOutOfBoundsChildEvents(boolean z11) {
        this.interceptOutOfBoundsChildEvents = z11;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    @Stable
    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m4389toDpGaN1DYA(long j11) {
        return this.$$delegate_0.m5442toDpGaN1DYA(j11);
    }

    @Stable
    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m4390toDpu2uoSUM(float f11) {
        return this.$$delegate_0.m5443toDpu2uoSUM(f11);
    }

    @Stable
    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m4391toDpu2uoSUM(int i11) {
        return this.$$delegate_0.m5444toDpu2uoSUM(i11);
    }

    @Stable
    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m4392toDpSizekrfVVM(long j11) {
        return this.$$delegate_0.m5445toDpSizekrfVVM(j11);
    }

    @Stable
    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m4393toPxR2X_6o(long j11) {
        return this.$$delegate_0.m5446toPxR2X_6o(j11);
    }

    @Stable
    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m4394toPx0680j_4(float f11) {
        return this.$$delegate_0.m5447toPx0680j_4(f11);
    }

    @NotNull
    @Stable
    public Rect toRect(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    @Stable
    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m4395toSizeXkaWNTQ(long j11) {
        return this.$$delegate_0.m5448toSizeXkaWNTQ(j11);
    }

    @Stable
    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m4396toSp0xMU5do(float f11) {
        return this.$$delegate_0.m5449toSp0xMU5do(f11);
    }

    @Stable
    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m4397toSpkPz2Gy4(float f11) {
        return this.$$delegate_0.m5450toSpkPz2Gy4(f11);
    }

    @Stable
    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m4398toSpkPz2Gy4(int i11) {
        return this.$$delegate_0.m5451toSpkPz2Gy4(i11);
    }

    public SuspendingPointerInputFilter(@NotNull ViewConfiguration viewConfiguration2, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(viewConfiguration2, "viewConfiguration");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        this.viewConfiguration = viewConfiguration2;
        this.$$delegate_0 = density;
        this.currentEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        this.pointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.dispatchingPointerHandlers = new MutableVector<>(new PointerEventHandlerCoroutine[16], 0);
        this.boundsSize = IntSize.Companion.m5643getZeroYbymL2g();
        this.coroutineScope = GlobalScope.INSTANCE;
    }
}
