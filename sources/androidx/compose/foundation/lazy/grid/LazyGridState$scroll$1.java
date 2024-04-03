package androidx.compose.foundation.lazy.grid;

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
@DebugMetadata(c = "androidx.compose.foundation.lazy.grid.LazyGridState", f = "LazyGridState.kt", i = {0, 0, 0}, l = {266, 267}, m = "scroll", n = {"this", "scrollPriority", "block"}, s = {"L$0", "L$1", "L$2"})
public final class LazyGridState$scroll$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2957h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2958i;

    /* renamed from: j  reason: collision with root package name */
    public Object f2959j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f2960k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ LazyGridState f2961l;

    /* renamed from: m  reason: collision with root package name */
    public int f2962m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridState$scroll$1(LazyGridState lazyGridState, Continuation<? super LazyGridState$scroll$1> continuation) {
        super(continuation);
        this.f2961l = lazyGridState;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2960k = obj;
        this.f2962m |= Integer.MIN_VALUE;
        return this.f2961l.scroll((MutatePriority) null, (Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
