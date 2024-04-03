package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SwipeableKt$PreUpPostDownNestedScrollConnection$1", f = "Swipeable.kt", i = {0}, l = {878}, m = "onPostFling-RZ2iAVY", n = {"available"}, s = {"J$0"})
public final class SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public long f8388h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f8389i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SwipeableKt$PreUpPostDownNestedScrollConnection$1 f8390j;

    /* renamed from: k  reason: collision with root package name */
    public int f8391k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1(SwipeableKt$PreUpPostDownNestedScrollConnection$1 swipeableKt$PreUpPostDownNestedScrollConnection$1, Continuation<? super SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1> continuation) {
        super(continuation);
        this.f8390j = swipeableKt$PreUpPostDownNestedScrollConnection$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f8389i = obj;
        this.f8391k |= Integer.MIN_VALUE;
        return this.f8390j.m1869onPostFlingRZ2iAVY(0, 0, this);
    }
}
