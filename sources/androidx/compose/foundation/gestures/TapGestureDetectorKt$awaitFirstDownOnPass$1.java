package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 0}, l = {256}, m = "awaitFirstDownOnPass", n = {"$this$awaitFirstDownOnPass", "pass", "requireUnconsumed"}, s = {"L$0", "L$1", "Z$0"})
public final class TapGestureDetectorKt$awaitFirstDownOnPass$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2218h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2219i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2220j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f2221k;

    /* renamed from: l  reason: collision with root package name */
    public int f2222l;

    public TapGestureDetectorKt$awaitFirstDownOnPass$1(Continuation<? super TapGestureDetectorKt$awaitFirstDownOnPass$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2221k = obj;
        this.f2222l |= Integer.MIN_VALUE;
        return TapGestureDetectorKt.awaitFirstDownOnPass((AwaitPointerEventScope) null, (PointerEventPass) null, false, this);
    }
}
