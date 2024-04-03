package androidx.paging.multicast;

import androidx.paging.multicast.ChannelManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"T", "Landroidx/paging/multicast/ChannelManager$Message;", "msg", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "handle"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.multicast.ChannelManager$Actor", f = "ChannelManager.kt", i = {}, l = {103, 104, 105}, m = "handle", n = {}, s = {})
public final class ChannelManager$Actor$handle$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37211h;

    /* renamed from: i  reason: collision with root package name */
    public int f37212i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChannelManager.Actor f37213j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelManager$Actor$handle$1(ChannelManager.Actor actor, Continuation continuation) {
        super(continuation);
        this.f37213j = actor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37211h = obj;
        this.f37212i |= Integer.MIN_VALUE;
        return this.f37213j.handle((ChannelManager.Message) null, (Continuation<? super Unit>) this);
    }
}
