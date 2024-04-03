package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.EnterAlwaysScrollBehavior$nestedScrollConnection$1", f = "AppBar.kt", i = {0, 0}, l = {1454, 1455}, m = "onPostFling-RZ2iAVY", n = {"this", "available"}, s = {"L$0", "J$0"})
public final class EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f6965h;

    /* renamed from: i  reason: collision with root package name */
    public long f6966i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f6967j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ EnterAlwaysScrollBehavior$nestedScrollConnection$1 f6968k;

    /* renamed from: l  reason: collision with root package name */
    public int f6969l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1(EnterAlwaysScrollBehavior$nestedScrollConnection$1 enterAlwaysScrollBehavior$nestedScrollConnection$1, Continuation<? super EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1> continuation) {
        super(continuation);
        this.f6968k = enterAlwaysScrollBehavior$nestedScrollConnection$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f6967j = obj;
        this.f6969l |= Integer.MIN_VALUE;
        return this.f6968k.m1661onPostFlingRZ2iAVY(0, 0, this);
    }
}
