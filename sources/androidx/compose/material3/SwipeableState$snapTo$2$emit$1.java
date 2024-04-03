package androidx.compose.material3;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SwipeableState$snapTo$2", f = "Swipeable.kt", i = {0}, l = {316}, m = "emit", n = {"this"}, s = {"L$0"})
public final class SwipeableState$snapTo$2$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f8467h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f8468i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SwipeableState$snapTo$2 f8469j;

    /* renamed from: k  reason: collision with root package name */
    public int f8470k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableState$snapTo$2$emit$1(SwipeableState$snapTo$2 swipeableState$snapTo$2, Continuation<? super SwipeableState$snapTo$2$emit$1> continuation) {
        super(continuation);
        this.f8469j = swipeableState$snapTo$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f8468i = obj;
        this.f8470k |= Integer.MIN_VALUE;
        return this.f8469j.emit((Map) null, (Continuation<? super Unit>) this);
    }
}
