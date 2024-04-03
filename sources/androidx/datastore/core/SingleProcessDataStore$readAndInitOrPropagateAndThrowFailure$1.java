package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0}, l = {302}, m = "readAndInitOrPropagateAndThrowFailure", n = {"this"}, s = {"L$0"})
public final class SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f35671h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f35672i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f35673j;

    /* renamed from: k  reason: collision with root package name */
    public int f35674k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1> continuation) {
        super(continuation);
        this.f35673j = singleProcessDataStore;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f35672i = obj;
        this.f35674k |= Integer.MIN_VALUE;
        return this.f35673j.readAndInitOrPropagateAndThrowFailure(this);
    }
}
