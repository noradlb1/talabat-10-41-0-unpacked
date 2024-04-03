package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {761, 768}, m = "runFrameLoop", n = {"this", "parentFrameClock", "frameSignal", "toRecompose", "toApply", "this", "parentFrameClock", "frameSignal", "toRecompose", "toApply"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class Recomposer$runFrameLoop$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f9175h;

    /* renamed from: i  reason: collision with root package name */
    public Object f9176i;

    /* renamed from: j  reason: collision with root package name */
    public Object f9177j;

    /* renamed from: k  reason: collision with root package name */
    public Object f9178k;

    /* renamed from: l  reason: collision with root package name */
    public Object f9179l;

    /* renamed from: m  reason: collision with root package name */
    public /* synthetic */ Object f9180m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Recomposer f9181n;

    /* renamed from: o  reason: collision with root package name */
    public int f9182o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Recomposer$runFrameLoop$1(Recomposer recomposer, Continuation<? super Recomposer$runFrameLoop$1> continuation) {
        super(continuation);
        this.f9181n = recomposer;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f9180m = obj;
        this.f9182o |= Integer.MIN_VALUE;
        return this.f9181n.runFrameLoop((MonotonicFrameClock) null, (ProduceFrameSignal) null, this);
    }
}
