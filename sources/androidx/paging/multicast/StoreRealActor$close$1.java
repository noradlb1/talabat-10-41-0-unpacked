package androidx.paging.multicast;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@"}, d2 = {"T", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "close"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.multicast.StoreRealActor", f = "StoreRealActor.kt", i = {0}, l = {74, 76}, m = "close", n = {"this"}, s = {"L$0"})
public final class StoreRealActor$close$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37248h;

    /* renamed from: i  reason: collision with root package name */
    public int f37249i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ StoreRealActor f37250j;

    /* renamed from: k  reason: collision with root package name */
    public Object f37251k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoreRealActor$close$1(StoreRealActor storeRealActor, Continuation continuation) {
        super(continuation);
        this.f37250j = storeRealActor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37248h = obj;
        this.f37249i |= Integer.MIN_VALUE;
        return this.f37250j.close(this);
    }
}
