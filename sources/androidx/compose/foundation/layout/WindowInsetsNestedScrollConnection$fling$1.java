package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection", f = "WindowInsetsConnection.android.kt", i = {0, 0, 0, 1, 1, 1, 2, 2}, l = {304, 330, 355}, m = "fling-huYlsQE", n = {"this", "available", "flingAmount", "this", "endVelocity", "available", "this", "available"}, s = {"L$0", "J$0", "F$0", "L$0", "L$1", "J$0", "L$0", "J$0"})
public final class WindowInsetsNestedScrollConnection$fling$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2596h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2597i;

    /* renamed from: j  reason: collision with root package name */
    public long f2598j;

    /* renamed from: k  reason: collision with root package name */
    public float f2599k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f2600l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsNestedScrollConnection f2601m;

    /* renamed from: n  reason: collision with root package name */
    public int f2602n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WindowInsetsNestedScrollConnection$fling$1(WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, Continuation<? super WindowInsetsNestedScrollConnection$fling$1> continuation) {
        super(continuation);
        this.f2601m = windowInsetsNestedScrollConnection;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2600l = obj;
        this.f2602n |= Integer.MIN_VALUE;
        return this.f2601m.m580flinghuYlsQE(0, 0.0f, false, this);
    }
}
