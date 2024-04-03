package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0, 0}, l = {162}, m = "awaitTwoDowns", n = {"$this$awaitTwoDowns", "firstDown", "requireUnconsumed"}, s = {"L$0", "L$1", "Z$0"})
public final class TransformableKt$awaitTwoDowns$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2303h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2304i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2305j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f2306k;

    /* renamed from: l  reason: collision with root package name */
    public int f2307l;

    public TransformableKt$awaitTwoDowns$1(Continuation<? super TransformableKt$awaitTwoDowns$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2306k = obj;
        this.f2307l |= Integer.MIN_VALUE;
        return TransformableKt.awaitTwoDowns((AwaitPointerEventScope) null, false, this);
    }
}
