package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt", f = "ScrollExtensions.kt", i = {0}, l = {40}, m = "animateScrollBy", n = {"previousValue"}, s = {"L$0"})
public final class ScrollExtensionsKt$animateScrollBy$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2142h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f2143i;

    /* renamed from: j  reason: collision with root package name */
    public int f2144j;

    public ScrollExtensionsKt$animateScrollBy$1(Continuation<? super ScrollExtensionsKt$animateScrollBy$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2143i = obj;
        this.f2144j |= Integer.MIN_VALUE;
        return ScrollExtensionsKt.animateScrollBy((ScrollableState) null, 0.0f, (AnimationSpec<Float>) null, this);
    }
}
