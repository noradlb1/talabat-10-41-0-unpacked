package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {898, 948}, m = "awaitVerticalTouchSlopOrCancellation-jO51t88", n = {"onTouchSlopReached", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointer$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv", "onTouchSlopReached", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointer$iv", "dragEvent$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv"}, s = {"L$0", "L$2", "L$3", "I$0", "F$0", "F$1", "F$2", "L$0", "L$2", "L$3", "L$4", "I$0", "F$0", "F$1", "F$2"})
public final class DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f1933h;

    /* renamed from: i  reason: collision with root package name */
    public Object f1934i;

    /* renamed from: j  reason: collision with root package name */
    public Object f1935j;

    /* renamed from: k  reason: collision with root package name */
    public Object f1936k;

    /* renamed from: l  reason: collision with root package name */
    public Object f1937l;

    /* renamed from: m  reason: collision with root package name */
    public int f1938m;

    /* renamed from: n  reason: collision with root package name */
    public float f1939n;

    /* renamed from: o  reason: collision with root package name */
    public float f1940o;

    /* renamed from: p  reason: collision with root package name */
    public float f1941p;

    /* renamed from: q  reason: collision with root package name */
    public /* synthetic */ Object f1942q;

    /* renamed from: r  reason: collision with root package name */
    public int f1943r;

    public DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1(Continuation<? super DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f1942q = obj;
        this.f1943r |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m282awaitVerticalTouchSlopOrCancellationjO51t88((AwaitPointerEventScope) null, 0, (Function2<? super PointerInputChange, ? super Float, Unit>) null, this);
    }
}
