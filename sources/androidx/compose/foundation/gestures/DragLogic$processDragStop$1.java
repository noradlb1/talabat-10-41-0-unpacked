package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragLogic", f = "Draggable.kt", i = {0, 0, 0}, l = {392, 395}, m = "processDragStop", n = {"this", "$this$processDragStop", "event"}, s = {"L$0", "L$1", "L$2"})
public final class DragLogic$processDragStop$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2030h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2031i;

    /* renamed from: j  reason: collision with root package name */
    public Object f2032j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f2033k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DragLogic f2034l;

    /* renamed from: m  reason: collision with root package name */
    public int f2035m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DragLogic$processDragStop$1(DragLogic dragLogic, Continuation<? super DragLogic$processDragStop$1> continuation) {
        super(continuation);
        this.f2034l = dragLogic;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2033k = obj;
        this.f2035m |= Integer.MIN_VALUE;
        return this.f2034l.processDragStop((CoroutineScope) null, (DragEvent.DragStopped) null, this);
    }
}
