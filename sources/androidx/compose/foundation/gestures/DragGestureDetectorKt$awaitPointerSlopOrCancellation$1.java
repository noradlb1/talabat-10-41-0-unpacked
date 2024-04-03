package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 176)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {682, 716}, m = "awaitPointerSlopOrCancellation-wtdNQyU", n = {"$this$awaitPointerSlopOrCancellation_u2dwtdNQyU", "pointerDirectionConfig", "onPointerSlopReached", "pointer", "triggerOnMainAxisSlop", "touchSlop", "totalMainPositionChange", "totalCrossPositionChange", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU", "pointerDirectionConfig", "onPointerSlopReached", "pointer", "dragEvent", "triggerOnMainAxisSlop", "touchSlop", "totalMainPositionChange", "totalCrossPositionChange"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "F$0", "F$1", "F$2", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "F$0", "F$1", "F$2"})
public final class DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f1896h;

    /* renamed from: i  reason: collision with root package name */
    public Object f1897i;

    /* renamed from: j  reason: collision with root package name */
    public Object f1898j;

    /* renamed from: k  reason: collision with root package name */
    public Object f1899k;

    /* renamed from: l  reason: collision with root package name */
    public Object f1900l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f1901m;

    /* renamed from: n  reason: collision with root package name */
    public float f1902n;

    /* renamed from: o  reason: collision with root package name */
    public float f1903o;

    /* renamed from: p  reason: collision with root package name */
    public float f1904p;

    /* renamed from: q  reason: collision with root package name */
    public /* synthetic */ Object f1905q;

    /* renamed from: r  reason: collision with root package name */
    public int f1906r;

    public DragGestureDetectorKt$awaitPointerSlopOrCancellation$1(Continuation<? super DragGestureDetectorKt$awaitPointerSlopOrCancellation$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f1905q = obj;
        this.f1906r |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m276awaitPointerSlopOrCancellationwtdNQyU((AwaitPointerEventScope) null, 0, 0, (PointerDirectionConfig) null, false, (Function2<? super PointerInputChange, ? super Offset, Unit>) null, this);
    }
}
