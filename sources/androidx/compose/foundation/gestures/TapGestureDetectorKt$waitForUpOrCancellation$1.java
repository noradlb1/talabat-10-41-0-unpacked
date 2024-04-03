package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 1}, l = {274, 289}, m = "waitForUpOrCancellation", n = {"$this$waitForUpOrCancellation", "$this$waitForUpOrCancellation"}, s = {"L$0", "L$0"})
public final class TapGestureDetectorKt$waitForUpOrCancellation$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2285h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f2286i;

    /* renamed from: j  reason: collision with root package name */
    public int f2287j;

    public TapGestureDetectorKt$waitForUpOrCancellation$1(Continuation<? super TapGestureDetectorKt$waitForUpOrCancellation$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2286i = obj;
        this.f2287j |= Integer.MIN_VALUE;
        return TapGestureDetectorKt.waitForUpOrCancellation((AwaitPointerEventScope) null, this);
    }
}
