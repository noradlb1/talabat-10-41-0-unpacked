package coil.util;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "coil.util.-Lifecycles", f = "Lifecycles.kt", i = {0, 0}, l = {44}, m = "observeStarted", n = {"$this$observeStarted", "observer"}, s = {"L$0", "L$1"})
/* renamed from: coil.util.-Lifecycles$observeStarted$1  reason: invalid class name */
public final class Lifecycles$observeStarted$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f39819h;

    /* renamed from: i  reason: collision with root package name */
    public Object f39820i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f39821j;

    /* renamed from: k  reason: collision with root package name */
    public int f39822k;

    public Lifecycles$observeStarted$1(Continuation<? super Lifecycles$observeStarted$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f39821j = obj;
        this.f39822k |= Integer.MIN_VALUE;
        return Lifecycles.observeStarted((Lifecycle) null, this);
    }
}
