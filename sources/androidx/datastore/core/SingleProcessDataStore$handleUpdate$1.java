package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {1, 1}, l = {276, 281, 284}, m = "handleUpdate", n = {"update", "$this$handleUpdate_u24lambda_u2d0"}, s = {"L$0", "L$1"})
public final class SingleProcessDataStore$handleUpdate$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f35644h;

    /* renamed from: i  reason: collision with root package name */
    public Object f35645i;

    /* renamed from: j  reason: collision with root package name */
    public Object f35646j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f35647k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f35648l;

    /* renamed from: m  reason: collision with root package name */
    public int f35649m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$handleUpdate$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$handleUpdate$1> continuation) {
        super(continuation);
        this.f35648l = singleProcessDataStore;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f35647k = obj;
        this.f35649m |= Integer.MIN_VALUE;
        return this.f35648l.handleUpdate((SingleProcessDataStore.Message.Update) null, this);
    }
}
