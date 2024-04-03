package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", f = "TapGestureDetector.kt", i = {}, l = {332}, m = "awaitRelease", n = {}, s = {})
public final class PressGestureScopeImpl$awaitRelease$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f2132h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PressGestureScopeImpl f2133i;

    /* renamed from: j  reason: collision with root package name */
    public int f2134j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PressGestureScopeImpl$awaitRelease$1(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super PressGestureScopeImpl$awaitRelease$1> continuation) {
        super(continuation);
        this.f2133i = pressGestureScopeImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2132h = obj;
        this.f2134j |= Integer.MIN_VALUE;
        return this.f2133i.awaitRelease(this);
    }
}
