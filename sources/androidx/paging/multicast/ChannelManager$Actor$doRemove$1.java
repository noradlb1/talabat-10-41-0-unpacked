package androidx.paging.multicast;

import androidx.paging.multicast.ChannelManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H@"}, d2 = {"T", "Lkotlinx/coroutines/channels/SendChannel;", "Landroidx/paging/multicast/ChannelManager$Message$Dispatch$Value;", "channel", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "doRemove"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.multicast.ChannelManager$Actor", f = "ChannelManager.kt", i = {}, l = {206}, m = "doRemove", n = {}, s = {})
public final class ChannelManager$Actor$doRemove$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37208h;

    /* renamed from: i  reason: collision with root package name */
    public int f37209i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChannelManager.Actor f37210j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelManager$Actor$doRemove$1(ChannelManager.Actor actor, Continuation continuation) {
        super(continuation);
        this.f37210j = actor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37208h = obj;
        this.f37209i |= Integer.MIN_VALUE;
        return this.f37210j.d((SendChannel) null, this);
    }
}
