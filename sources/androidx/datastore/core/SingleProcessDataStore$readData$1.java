package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0}, l = {381}, m = "readData", n = {"this"}, s = {"L$0"})
public final class SingleProcessDataStore$readData$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f35679h;

    /* renamed from: i  reason: collision with root package name */
    public Object f35680i;

    /* renamed from: j  reason: collision with root package name */
    public Object f35681j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f35682k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f35683l;

    /* renamed from: m  reason: collision with root package name */
    public int f35684m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readData$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$readData$1> continuation) {
        super(continuation);
        this.f35683l = singleProcessDataStore;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f35682k = obj;
        this.f35684m |= Integer.MIN_VALUE;
        return this.f35683l.readData(this);
    }
}
