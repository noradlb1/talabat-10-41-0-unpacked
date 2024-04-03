package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0}, l = {109}, m = "drag-jO51t88", n = {"$this$drag_u2djO51t88", "onDrag"}, s = {"L$0", "L$1"})
public final class DragGestureDetectorKt$drag$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2002h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2003i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f2004j;

    /* renamed from: k  reason: collision with root package name */
    public int f2005k;

    public DragGestureDetectorKt$drag$1(Continuation<? super DragGestureDetectorKt$drag$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2004j = obj;
        this.f2005k |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m284dragjO51t88((AwaitPointerEventScope) null, 0, (Function1<? super PointerInputChange, Unit>) null, this);
    }
}
