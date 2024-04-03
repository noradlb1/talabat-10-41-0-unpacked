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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {898, 948}, m = "awaitVerticalPointerSlopOrCancellation-gDDlDlE", n = {"onTouchSlopReached", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointer$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv", "onTouchSlopReached", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointer$iv", "dragEvent$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv"}, s = {"L$0", "L$2", "L$3", "I$0", "F$0", "F$1", "F$2", "L$0", "L$2", "L$3", "L$4", "I$0", "F$0", "F$1", "F$2"})
public final class DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f1922h;

    /* renamed from: i  reason: collision with root package name */
    public Object f1923i;

    /* renamed from: j  reason: collision with root package name */
    public Object f1924j;

    /* renamed from: k  reason: collision with root package name */
    public Object f1925k;

    /* renamed from: l  reason: collision with root package name */
    public Object f1926l;

    /* renamed from: m  reason: collision with root package name */
    public int f1927m;

    /* renamed from: n  reason: collision with root package name */
    public float f1928n;

    /* renamed from: o  reason: collision with root package name */
    public float f1929o;

    /* renamed from: p  reason: collision with root package name */
    public float f1930p;

    /* renamed from: q  reason: collision with root package name */
    public /* synthetic */ Object f1931q;

    /* renamed from: r  reason: collision with root package name */
    public int f1932r;

    public DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1(Continuation<? super DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f1931q = obj;
        this.f1932r |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m281awaitVerticalPointerSlopOrCancellationgDDlDlE((AwaitPointerEventScope) null, 0, 0, (Function2<? super PointerInputChange, ? super Float, Unit>) null, this);
    }
}
