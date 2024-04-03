package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class GlobalSnapshotManager$ensureStarted$2 extends Lambda implements Function1<Object, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Channel<Unit> f10038g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalSnapshotManager$ensureStarted$2(Channel<Unit> channel) {
        super(1);
        this.f10038g = channel;
    }

    public final void invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        this.f10038g.m7820trySendJP2dKIU(Unit.INSTANCE);
    }
}
