package androidx.paging.multicast;

import androidx.paging.multicast.ChannelManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"T", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "msg", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "doDispatchValue"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.multicast.ChannelManager$Actor", f = "ChannelManager.kt", i = {0, 0, 1}, l = {172, 181}, m = "doDispatchValue", n = {"this", "msg", "msg"}, s = {"L$0", "L$1", "L$0"})
public final class ChannelManager$Actor$doDispatchValue$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37203h;

    /* renamed from: i  reason: collision with root package name */
    public int f37204i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChannelManager.Actor f37205j;

    /* renamed from: k  reason: collision with root package name */
    public Object f37206k;

    /* renamed from: l  reason: collision with root package name */
    public Object f37207l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelManager$Actor$doDispatchValue$1(ChannelManager.Actor actor, Continuation continuation) {
        super(continuation);
        this.f37205j = actor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37203h = obj;
        this.f37204i |= Integer.MIN_VALUE;
        return this.f37205j.c((ChannelManager.Message.Dispatch.Value) null, this);
    }
}
