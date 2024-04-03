package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0, 0, 0}, l = {402, 410}, m = "transformAndWrite", n = {"this", "curDataAndHash", "curData"}, s = {"L$0", "L$1", "L$2"})
public final class SingleProcessDataStore$transformAndWrite$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f35690h;

    /* renamed from: i  reason: collision with root package name */
    public Object f35691i;

    /* renamed from: j  reason: collision with root package name */
    public Object f35692j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f35693k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f35694l;

    /* renamed from: m  reason: collision with root package name */
    public int f35695m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$transformAndWrite$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$transformAndWrite$1> continuation) {
        super(continuation);
        this.f35694l = singleProcessDataStore;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f35693k = obj;
        this.f35695m |= Integer.MIN_VALUE;
        return this.f35694l.transformAndWrite((Function2) null, (CoroutineContext) null, this);
    }
}
