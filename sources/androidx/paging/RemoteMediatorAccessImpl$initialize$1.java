package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"", "Key", "Value", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/RemoteMediator$InitializeAction;", "continuation", "initialize"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl", f = "RemoteMediatorAccessor.kt", i = {0}, l = {394}, m = "initialize", n = {"this"}, s = {"L$0"})
public final class RemoteMediatorAccessImpl$initialize$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37056h;

    /* renamed from: i  reason: collision with root package name */
    public int f37057i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RemoteMediatorAccessImpl f37058j;

    /* renamed from: k  reason: collision with root package name */
    public Object f37059k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteMediatorAccessImpl$initialize$1(RemoteMediatorAccessImpl remoteMediatorAccessImpl, Continuation continuation) {
        super(continuation);
        this.f37058j = remoteMediatorAccessImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37056h = obj;
        this.f37057i |= Integer.MIN_VALUE;
        return this.f37058j.initialize(this);
    }
}
