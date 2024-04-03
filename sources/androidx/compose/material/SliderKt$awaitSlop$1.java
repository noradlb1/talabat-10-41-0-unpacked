package androidx.compose.material;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SliderKt", f = "Slider.kt", i = {0}, l = {795}, m = "awaitSlop-8vUncbI", n = {"initialDelta"}, s = {"L$0"})
public final class SliderKt$awaitSlop$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f5265h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5266i;

    /* renamed from: j  reason: collision with root package name */
    public int f5267j;

    public SliderKt$awaitSlop$1(Continuation<? super SliderKt$awaitSlop$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f5266i = obj;
        this.f5267j |= Integer.MIN_VALUE;
        return SliderKt.m1361awaitSlop8vUncbI((AwaitPointerEventScope) null, 0, 0, this);
    }
}
