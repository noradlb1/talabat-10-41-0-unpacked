package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$scrollableNestedScrollConnection$1", f = "Scrollable.kt", i = {0, 0}, l = {533}, m = "onPostFling-RZ2iAVY", n = {"this", "available"}, s = {"L$0", "J$0"})
public final class ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2191h;

    /* renamed from: i  reason: collision with root package name */
    public long f2192i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f2193j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ScrollableKt$scrollableNestedScrollConnection$1 f2194k;

    /* renamed from: l  reason: collision with root package name */
    public int f2195l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1(ScrollableKt$scrollableNestedScrollConnection$1 scrollableKt$scrollableNestedScrollConnection$1, Continuation<? super ScrollableKt$scrollableNestedScrollConnection$1$onPostFling$1> continuation) {
        super(continuation);
        this.f2194k = scrollableKt$scrollableNestedScrollConnection$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2193j = obj;
        this.f2195l |= Integer.MIN_VALUE;
        return this.f2194k.m341onPostFlingRZ2iAVY(0, 0, this);
    }
}
