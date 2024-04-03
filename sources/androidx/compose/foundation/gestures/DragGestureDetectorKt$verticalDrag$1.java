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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0, 0, 0}, l = {890}, m = "verticalDrag-jO51t88", n = {"onDrag", "$this$drag_u2dVnAYq1g$iv", "$this$awaitDragOrUp_u2djO51t88$iv$iv", "pointer$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class DragGestureDetectorKt$verticalDrag$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2012h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2013i;

    /* renamed from: j  reason: collision with root package name */
    public Object f2014j;

    /* renamed from: k  reason: collision with root package name */
    public Object f2015k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f2016l;

    /* renamed from: m  reason: collision with root package name */
    public int f2017m;

    public DragGestureDetectorKt$verticalDrag$1(Continuation<? super DragGestureDetectorKt$verticalDrag$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2016l = obj;
        this.f2017m |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m288verticalDragjO51t88((AwaitPointerEventScope) null, 0, (Function1<? super PointerInputChange, Unit>) null, this);
    }
}
