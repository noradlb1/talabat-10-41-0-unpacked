package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1", f = "Swipeable.kt", i = {0}, l = {869}, m = "onPreFling-QWom1Mo", n = {"available"}, s = {"J$0"})
public final class SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public long f8392h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f8393i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SwipeableKt$PreUpPostDownNestedScrollConnection$1 f8394j;

    /* renamed from: k  reason: collision with root package name */
    public int f8395k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1(SwipeableKt$PreUpPostDownNestedScrollConnection$1 swipeableKt$PreUpPostDownNestedScrollConnection$1, Continuation<? super SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1> continuation) {
        super(continuation);
        this.f8394j = swipeableKt$PreUpPostDownNestedScrollConnection$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f8393i = obj;
        this.f8395k |= Integer.MIN_VALUE;
        return this.f8394j.m1871onPreFlingQWom1Mo(0, this);
    }
}
