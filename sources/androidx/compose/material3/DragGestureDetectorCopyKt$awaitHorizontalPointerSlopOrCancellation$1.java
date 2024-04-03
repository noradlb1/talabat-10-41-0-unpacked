package androidx.compose.material3;

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
@DebugMetadata(c = "androidx.compose.material3.DragGestureDetectorCopyKt", f = "DragGestureDetectorCopy.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {144, 182}, m = "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", n = {"onPointerSlopReached", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointer$iv", "touchSlop$iv", "totalPositionChange$iv", "onPointerSlopReached", "$this$awaitPointerSlopOrCancellation_u2dpn7EDYM$iv", "pointer$iv", "dragEvent$iv", "touchSlop$iv", "totalPositionChange$iv"}, s = {"L$0", "L$1", "L$2", "F$0", "F$1", "L$0", "L$1", "L$2", "L$3", "F$0", "F$1"})
public final class DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f6955h;

    /* renamed from: i  reason: collision with root package name */
    public Object f6956i;

    /* renamed from: j  reason: collision with root package name */
    public Object f6957j;

    /* renamed from: k  reason: collision with root package name */
    public Object f6958k;

    /* renamed from: l  reason: collision with root package name */
    public float f6959l;

    /* renamed from: m  reason: collision with root package name */
    public float f6960m;

    /* renamed from: n  reason: collision with root package name */
    public /* synthetic */ Object f6961n;

    /* renamed from: o  reason: collision with root package name */
    public int f6962o;

    public DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1(Continuation<? super DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f6961n = obj;
        this.f6962o |= Integer.MIN_VALUE;
        return DragGestureDetectorCopyKt.m1646awaitHorizontalPointerSlopOrCancellationgDDlDlE((AwaitPointerEventScope) null, 0, 0, (Function2<? super PointerInputChange, ? super Float, Unit>) null, this);
    }
}
