package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {98, 102}, m = "detectZoom", n = {"$this$detectZoom", "panZoomLock", "state", "rotation", "zoom", "pan", "pastTouchSlop", "lockedToPanZoom", "touchSlop"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "F$0"})
public final class TransformableKt$detectZoom$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2308h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2309i;

    /* renamed from: j  reason: collision with root package name */
    public Object f2310j;

    /* renamed from: k  reason: collision with root package name */
    public Object f2311k;

    /* renamed from: l  reason: collision with root package name */
    public Object f2312l;

    /* renamed from: m  reason: collision with root package name */
    public Object f2313m;

    /* renamed from: n  reason: collision with root package name */
    public Object f2314n;

    /* renamed from: o  reason: collision with root package name */
    public Object f2315o;

    /* renamed from: p  reason: collision with root package name */
    public float f2316p;

    /* renamed from: q  reason: collision with root package name */
    public /* synthetic */ Object f2317q;

    /* renamed from: r  reason: collision with root package name */
    public int f2318r;

    public TransformableKt$detectZoom$1(Continuation<? super TransformableKt$detectZoom$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2317q = obj;
        this.f2318r |= Integer.MIN_VALUE;
        return TransformableKt.detectZoom((PointerInputScope) null, (State<Boolean>) null, (State<? extends TransformableState>) null, this);
    }
}
