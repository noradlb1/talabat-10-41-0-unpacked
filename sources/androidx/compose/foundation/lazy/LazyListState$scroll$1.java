package androidx.compose.foundation.lazy;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState", f = "LazyListState.kt", i = {0, 0, 0}, l = {260, 261}, m = "scroll", n = {"this", "scrollPriority", "block"}, s = {"L$0", "L$1", "L$2"})
public final class LazyListState$scroll$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2805h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2806i;

    /* renamed from: j  reason: collision with root package name */
    public Object f2807j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f2808k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ LazyListState f2809l;

    /* renamed from: m  reason: collision with root package name */
    public int f2810m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyListState$scroll$1(LazyListState lazyListState, Continuation<? super LazyListState$scroll$1> continuation) {
        super(continuation);
        this.f2809l = lazyListState;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2808k = obj;
        this.f2810m |= Integer.MIN_VALUE;
        return this.f2809l.scroll((MutatePriority) null, (Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
