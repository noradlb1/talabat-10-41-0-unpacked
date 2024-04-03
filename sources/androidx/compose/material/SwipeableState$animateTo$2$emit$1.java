package androidx.compose.material;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SwipeableState$animateTo$2", f = "Swipeable.kt", i = {0, 0}, l = {335}, m = "emit", n = {"this", "anchors"}, s = {"L$0", "L$1"})
public final class SwipeableState$animateTo$2$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f5669h;

    /* renamed from: i  reason: collision with root package name */
    public Object f5670i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f5671j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SwipeableState$animateTo$2 f5672k;

    /* renamed from: l  reason: collision with root package name */
    public int f5673l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableState$animateTo$2$emit$1(SwipeableState$animateTo$2 swipeableState$animateTo$2, Continuation<? super SwipeableState$animateTo$2$emit$1> continuation) {
        super(continuation);
        this.f5672k = swipeableState$animateTo$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f5671j = obj;
        this.f5673l |= Integer.MIN_VALUE;
        return this.f5672k.emit((Map) null, (Continuation<? super Unit>) this);
    }
}
