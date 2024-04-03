package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt", f = "ScrollExtensions.kt", i = {0}, l = {61}, m = "scrollBy", n = {"consumed"}, s = {"L$0"})
public final class ScrollExtensionsKt$scrollBy$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2151h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f2152i;

    /* renamed from: j  reason: collision with root package name */
    public int f2153j;

    public ScrollExtensionsKt$scrollBy$1(Continuation<? super ScrollExtensionsKt$scrollBy$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2152i = obj;
        this.f2153j |= Integer.MIN_VALUE;
        return ScrollExtensionsKt.scrollBy((ScrollableState) null, 0.0f, this);
    }
}
