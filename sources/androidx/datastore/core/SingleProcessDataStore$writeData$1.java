package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0, 0, 0}, l = {426}, m = "writeData$datastore_core", n = {"this", "scratchFile", "stream"}, s = {"L$0", "L$1", "L$4"})
public final class SingleProcessDataStore$writeData$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f35699h;

    /* renamed from: i  reason: collision with root package name */
    public Object f35700i;

    /* renamed from: j  reason: collision with root package name */
    public Object f35701j;

    /* renamed from: k  reason: collision with root package name */
    public Object f35702k;

    /* renamed from: l  reason: collision with root package name */
    public Object f35703l;

    /* renamed from: m  reason: collision with root package name */
    public /* synthetic */ Object f35704m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f35705n;

    /* renamed from: o  reason: collision with root package name */
    public int f35706o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$writeData$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$writeData$1> continuation) {
        super(continuation);
        this.f35705n = singleProcessDataStore;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f35704m = obj;
        this.f35706o |= Integer.MIN_VALUE;
        return this.f35705n.writeData$datastore_core(null, this);
    }
}
