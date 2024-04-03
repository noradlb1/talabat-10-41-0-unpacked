package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt", f = "Scrollable.kt", i = {0}, l = {311}, m = "awaitScrollEvent", n = {"$this$awaitScrollEvent"}, s = {"L$0"})
public final class ScrollableKt$awaitScrollEvent$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2165h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f2166i;

    /* renamed from: j  reason: collision with root package name */
    public int f2167j;

    public ScrollableKt$awaitScrollEvent$1(Continuation<? super ScrollableKt$awaitScrollEvent$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2166i = obj;
        this.f2167j |= Integer.MIN_VALUE;
        return ScrollableKt.awaitScrollEvent((AwaitPointerEventScope) null, this);
    }
}
