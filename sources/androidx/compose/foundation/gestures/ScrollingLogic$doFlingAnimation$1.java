package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic", f = "Scrollable.kt", i = {0}, l = {446}, m = "doFlingAnimation-QWom1Mo", n = {"result"}, s = {"L$0"})
public final class ScrollingLogic$doFlingAnimation$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2197h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f2198i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ScrollingLogic f2199j;

    /* renamed from: k  reason: collision with root package name */
    public int f2200k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$doFlingAnimation$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$doFlingAnimation$1> continuation) {
        super(continuation);
        this.f2199j = scrollingLogic;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2198i = obj;
        this.f2200k |= Integer.MIN_VALUE;
        return this.f2199j.m347doFlingAnimationQWom1Mo(0, this);
    }
}
