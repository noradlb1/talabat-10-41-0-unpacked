package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "T", "changed", "", "", "<anonymous parameter 1>", "Landroidx/compose/runtime/snapshots/Snapshot;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1 extends Lambda implements Function2<Set<? extends Object>, Snapshot, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Channel<Set<Object>> f9256g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1(Channel<Set<Object>> channel) {
        super(2);
        this.f9256g = channel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Set<? extends Object>) (Set) obj, (Snapshot) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Set<? extends Object> set, @NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(set, "changed");
        Intrinsics.checkNotNullParameter(snapshot, "<anonymous parameter 1>");
        this.f9256g.m7820trySendJP2dKIU(set);
    }
}
