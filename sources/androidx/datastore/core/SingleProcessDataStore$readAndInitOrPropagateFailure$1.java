package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0}, l = {311}, m = "readAndInitOrPropagateFailure", n = {"this"}, s = {"L$0"})
public final class SingleProcessDataStore$readAndInitOrPropagateFailure$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f35675h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f35676i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f35677j;

    /* renamed from: k  reason: collision with root package name */
    public int f35678k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInitOrPropagateFailure$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$readAndInitOrPropagateFailure$1> continuation) {
        super(continuation);
        this.f35677j = singleProcessDataStore;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f35676i = obj;
        this.f35678k |= Integer.MIN_VALUE;
        return this.f35677j.readAndInitOrPropagateFailure(this);
    }
}
