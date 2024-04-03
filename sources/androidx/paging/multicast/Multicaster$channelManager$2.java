package androidx.paging.multicast;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/paging/multicast/ChannelManager;", "T", "invoke"}, k = 3, mv = {1, 4, 2})
public final class Multicaster$channelManager$2 extends Lambda implements Function0<ChannelManager<T>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Multicaster f37222g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f37223h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Multicaster$channelManager$2(Multicaster multicaster, int i11) {
        super(0);
        this.f37222g = multicaster;
        this.f37223h = i11;
    }

    @NotNull
    public final ChannelManager<T> invoke() {
        return new ChannelManager(this.f37222g.scope, this.f37223h, this.f37222g.piggybackingDownstream, this.f37222g.onEach, this.f37222g.keepUpstreamAlive, this.f37222g.source);
    }
}
