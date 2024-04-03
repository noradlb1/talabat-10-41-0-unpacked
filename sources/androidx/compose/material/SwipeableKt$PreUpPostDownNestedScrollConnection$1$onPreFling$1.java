package androidx.compose.material;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SwipeableKt$PreUpPostDownNestedScrollConnection$1", f = "Swipeable.kt", i = {0}, l = {873}, m = "onPreFling-QWom1Mo", n = {"available"}, s = {"J$0"})
public final class SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public long f5614h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5615i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SwipeableKt$PreUpPostDownNestedScrollConnection$1 f5616j;

    /* renamed from: k  reason: collision with root package name */
    public int f5617k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1(SwipeableKt$PreUpPostDownNestedScrollConnection$1 swipeableKt$PreUpPostDownNestedScrollConnection$1, Continuation<? super SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1> continuation) {
        super(continuation);
        this.f5616j = swipeableKt$PreUpPostDownNestedScrollConnection$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f5615i = obj;
        this.f5617k |= Integer.MIN_VALUE;
        return this.f5616j.m1398onPreFlingQWom1Mo(0, this);
    }
}
