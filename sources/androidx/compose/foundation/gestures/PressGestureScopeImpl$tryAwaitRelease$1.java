package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", f = "TapGestureDetector.kt", i = {0}, l = {339}, m = "tryAwaitRelease", n = {"this"}, s = {"L$0"})
public final class PressGestureScopeImpl$tryAwaitRelease$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2135h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f2136i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PressGestureScopeImpl f2137j;

    /* renamed from: k  reason: collision with root package name */
    public int f2138k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PressGestureScopeImpl$tryAwaitRelease$1(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super PressGestureScopeImpl$tryAwaitRelease$1> continuation) {
        super(continuation);
        this.f2137j = pressGestureScopeImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2136i = obj;
        this.f2138k |= Integer.MIN_VALUE;
        return this.f2137j.tryAwaitRelease(this);
    }
}
