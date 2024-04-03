package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0}, l = {884}, m = "awaitHorizontalDragOrCancellation-rnUCldI", n = {"$this$awaitDragOrUp_u2djO51t88$iv", "pointer$iv"}, s = {"L$0", "L$1"})
public final class DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f1861h;

    /* renamed from: i  reason: collision with root package name */
    public Object f1862i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f1863j;

    /* renamed from: k  reason: collision with root package name */
    public int f1864k;

    public DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1(Continuation<? super DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f1863j = obj;
        this.f1864k |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m272awaitHorizontalDragOrCancellationrnUCldI((AwaitPointerEventScope) null, 0, this);
    }
}
