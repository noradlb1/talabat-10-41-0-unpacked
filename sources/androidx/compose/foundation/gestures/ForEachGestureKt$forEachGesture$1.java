package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt", f = "ForEachGesture.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {41, 44, 49}, m = "forEachGesture", n = {"$this$forEachGesture", "block", "currentContext", "$this$forEachGesture", "block", "currentContext", "$this$forEachGesture", "block", "currentContext"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class ForEachGestureKt$forEachGesture$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2127h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2128i;

    /* renamed from: j  reason: collision with root package name */
    public Object f2129j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f2130k;

    /* renamed from: l  reason: collision with root package name */
    public int f2131l;

    public ForEachGestureKt$forEachGesture$1(Continuation<? super ForEachGestureKt$forEachGesture$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2130k = obj;
        this.f2131l |= Integer.MIN_VALUE;
        return ForEachGestureKt.forEachGesture((PointerInputScope) null, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
