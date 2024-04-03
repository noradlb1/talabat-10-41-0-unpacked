package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt", f = "ForEachGesture.kt", i = {0}, l = {79}, m = "awaitAllPointersUp", n = {"$this$awaitAllPointersUp"}, s = {"L$0"})
public final class ForEachGestureKt$awaitAllPointersUp$3 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2124h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f2125i;

    /* renamed from: j  reason: collision with root package name */
    public int f2126j;

    public ForEachGestureKt$awaitAllPointersUp$3(Continuation<? super ForEachGestureKt$awaitAllPointersUp$3> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2125i = obj;
        this.f2126j |= Integer.MIN_VALUE;
        return ForEachGestureKt.awaitAllPointersUp((AwaitPointerEventScope) null, (Continuation<? super Unit>) this);
    }
}
