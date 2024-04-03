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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragLogic", f = "Draggable.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {382, 385, 387}, m = "processDragStart", n = {"this", "$this$processDragStart", "event", "this", "$this$processDragStart", "event", "interaction"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
public final class DragLogic$processDragStart$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2023h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2024i;

    /* renamed from: j  reason: collision with root package name */
    public Object f2025j;

    /* renamed from: k  reason: collision with root package name */
    public Object f2026k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f2027l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ DragLogic f2028m;

    /* renamed from: n  reason: collision with root package name */
    public int f2029n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DragLogic$processDragStart$1(DragLogic dragLogic, Continuation<? super DragLogic$processDragStart$1> continuation) {
        super(continuation);
        this.f2028m = dragLogic;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2027l = obj;
        this.f2029n |= Integer.MIN_VALUE;
        return this.f2028m.processDragStart((CoroutineScope) null, (DragEvent.DragStarted) null, this);
    }
}
