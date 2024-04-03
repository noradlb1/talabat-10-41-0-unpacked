package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1", f = "SingleProcessDataStore.kt", i = {0, 0, 1, 2, 2}, l = {503, 337, 339}, m = "updateData", n = {"transform", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "newData"}, s = {"L$0", "L$1", "L$0", "L$0", "L$2"})
public final class SingleProcessDataStore$readAndInit$api$1$updateData$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f35663h;

    /* renamed from: i  reason: collision with root package name */
    public Object f35664i;

    /* renamed from: j  reason: collision with root package name */
    public Object f35665j;

    /* renamed from: k  reason: collision with root package name */
    public Object f35666k;

    /* renamed from: l  reason: collision with root package name */
    public Object f35667l;

    /* renamed from: m  reason: collision with root package name */
    public /* synthetic */ Object f35668m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore$readAndInit$api$1 f35669n;

    /* renamed from: o  reason: collision with root package name */
    public int f35670o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$readAndInit$api$1$updateData$1(SingleProcessDataStore$readAndInit$api$1 singleProcessDataStore$readAndInit$api$1, Continuation<? super SingleProcessDataStore$readAndInit$api$1$updateData$1> continuation) {
        super(continuation);
        this.f35669n = singleProcessDataStore$readAndInit$api$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f35668m = obj;
        this.f35670o |= Integer.MIN_VALUE;
        return this.f35669n.updateData((Function2) null, this);
    }
}
