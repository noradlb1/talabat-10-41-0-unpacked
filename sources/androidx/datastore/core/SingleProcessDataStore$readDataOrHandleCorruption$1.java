package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0, 1, 2, 2}, l = {359, 362, 365}, m = "readDataOrHandleCorruption", n = {"this", "ex", "ex", "newData"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class SingleProcessDataStore$readDataOrHandleCorruption$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f35685h;

    /* renamed from: i  reason: collision with root package name */
    public Object f35686i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f35687j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f35688k;

    /* renamed from: l  reason: collision with root package name */
    public int f35689l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readDataOrHandleCorruption$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$readDataOrHandleCorruption$1> continuation) {
        super(continuation);
        this.f35688k = singleProcessDataStore;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f35687j = obj;
        this.f35689l |= Integer.MIN_VALUE;
        return this.f35688k.readDataOrHandleCorruption(this);
    }
}
