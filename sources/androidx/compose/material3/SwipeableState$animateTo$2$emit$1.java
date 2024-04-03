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
@DebugMetadata(c = "androidx.compose.material3.SwipeableState$animateTo$2", f = "Swipeable.kt", i = {0, 0}, l = {335}, m = "emit", n = {"this", "anchors"}, s = {"L$0", "L$1"})
public final class SwipeableState$animateTo$2$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f8447h;

    /* renamed from: i  reason: collision with root package name */
    public Object f8448i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f8449j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SwipeableState$animateTo$2 f8450k;

    /* renamed from: l  reason: collision with root package name */
    public int f8451l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableState$animateTo$2$emit$1(SwipeableState$animateTo$2 swipeableState$animateTo$2, Continuation<? super SwipeableState$animateTo$2$emit$1> continuation) {
        super(continuation);
        this.f8450k = swipeableState$animateTo$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f8449j = obj;
        this.f8451l |= Integer.MIN_VALUE;
        return this.f8450k.emit((Map) null, (Continuation<? super Unit>) this);
    }
}
