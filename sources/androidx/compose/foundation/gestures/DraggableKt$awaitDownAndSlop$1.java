package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt", f = "Draggable.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {313, 322, 456, 506}, m = "awaitDownAndSlop", n = {"$this$awaitDownAndSlop", "canDrag", "startDragImmediately", "velocityTracker", "orientation", "$this$awaitDownAndSlop", "velocityTracker", "orientation", "initialDelta", "postPointerSlop", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointerDirectionConfig$iv", "pointer$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv", "initialDelta", "postPointerSlop", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointerDirectionConfig$iv", "pointer$iv", "dragEvent$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "F$0", "F$1", "F$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "F$0", "F$1", "F$2"})
public final class DraggableKt$awaitDownAndSlop$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2047h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2048i;

    /* renamed from: j  reason: collision with root package name */
    public Object f2049j;

    /* renamed from: k  reason: collision with root package name */
    public Object f2050k;

    /* renamed from: l  reason: collision with root package name */
    public Object f2051l;

    /* renamed from: m  reason: collision with root package name */
    public Object f2052m;

    /* renamed from: n  reason: collision with root package name */
    public int f2053n;

    /* renamed from: o  reason: collision with root package name */
    public float f2054o;

    /* renamed from: p  reason: collision with root package name */
    public float f2055p;

    /* renamed from: q  reason: collision with root package name */
    public float f2056q;

    /* renamed from: r  reason: collision with root package name */
    public /* synthetic */ Object f2057r;

    /* renamed from: s  reason: collision with root package name */
    public int f2058s;

    public DraggableKt$awaitDownAndSlop$1(Continuation<? super DraggableKt$awaitDownAndSlop$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2057r = obj;
        this.f2058s |= Integer.MIN_VALUE;
        return DraggableKt.awaitDownAndSlop((AwaitPointerEventScope) null, (State<? extends Function1<? super PointerInputChange, Boolean>>) null, (State<? extends Function0<Boolean>>) null, (VelocityTracker) null, (Orientation) null, this);
    }
}
