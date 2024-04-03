package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0}, l = {181}, m = "consumeUntilUp", n = {"$this$consumeUntilUp"}, s = {"L$0"})
public final class TapGestureDetectorKt$consumeUntilUp$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2226h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f2227i;

    /* renamed from: j  reason: collision with root package name */
    public int f2228j;

    public TapGestureDetectorKt$consumeUntilUp$1(Continuation<? super TapGestureDetectorKt$consumeUntilUp$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2227i = obj;
        this.f2228j |= Integer.MIN_VALUE;
        return TapGestureDetectorKt.consumeUntilUp((AwaitPointerEventScope) null, this);
    }
}
