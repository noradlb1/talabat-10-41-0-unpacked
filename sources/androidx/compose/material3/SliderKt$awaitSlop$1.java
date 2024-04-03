package androidx.compose.material3;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SliderKt", f = "Slider.kt", i = {0}, l = {1048}, m = "awaitSlop-8vUncbI", n = {"initialDelta"}, s = {"L$0"})
public final class SliderKt$awaitSlop$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f8125h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f8126i;

    /* renamed from: j  reason: collision with root package name */
    public int f8127j;

    public SliderKt$awaitSlop$1(Continuation<? super SliderKt$awaitSlop$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f8126i = obj;
        this.f8127j |= Integer.MIN_VALUE;
        return SliderKt.m1821awaitSlop8vUncbI((AwaitPointerEventScope) null, 0, 0, this);
    }
}
