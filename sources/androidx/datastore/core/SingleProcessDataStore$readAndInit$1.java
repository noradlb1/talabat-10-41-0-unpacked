package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0, 0, 1, 1, 1, 2}, l = {322, 348, 505}, m = "readAndInit", n = {"updateLock", "initData", "updateLock", "initData", "initializationComplete", "$this$withLock_u24default$iv"}, s = {"L$1", "L$2", "L$1", "L$2", "L$3", "L$3"})
public final class SingleProcessDataStore$readAndInit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f35650h;

    /* renamed from: i  reason: collision with root package name */
    public Object f35651i;

    /* renamed from: j  reason: collision with root package name */
    public Object f35652j;

    /* renamed from: k  reason: collision with root package name */
    public Object f35653k;

    /* renamed from: l  reason: collision with root package name */
    public Object f35654l;

    /* renamed from: m  reason: collision with root package name */
    public Object f35655m;

    /* renamed from: n  reason: collision with root package name */
    public /* synthetic */ Object f35656n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f35657o;

    /* renamed from: p  reason: collision with root package name */
    public int f35658p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInit$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$readAndInit$1> continuation) {
        super(continuation);
        this.f35657o = singleProcessDataStore;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f35656n = obj;
        this.f35658p |= Integer.MIN_VALUE;
        return this.f35657o.readAndInit(this);
    }
}
