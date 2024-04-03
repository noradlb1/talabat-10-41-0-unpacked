package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1", f = "AppBar.kt", i = {0, 0}, l = {1539, 1540}, m = "onPostFling-RZ2iAVY", n = {"this", "available"}, s = {"L$0", "J$0"})
public final class ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f6971h;

    /* renamed from: i  reason: collision with root package name */
    public long f6972i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f6973j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 f6974k;

    /* renamed from: l  reason: collision with root package name */
    public int f6975l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1(ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 exitUntilCollapsedScrollBehavior$nestedScrollConnection$1, Continuation<? super ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1> continuation) {
        super(continuation);
        this.f6974k = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f6973j = obj;
        this.f6975l |= Integer.MIN_VALUE;
        return this.f6974k.m1665onPostFlingRZ2iAVY(0, 0, this);
    }
}
