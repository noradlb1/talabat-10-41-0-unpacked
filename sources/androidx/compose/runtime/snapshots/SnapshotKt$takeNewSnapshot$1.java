package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "T", "Landroidx/compose/runtime/snapshots/Snapshot;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invoke", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/Snapshot;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnapshotKt$takeNewSnapshot$1 extends Lambda implements Function1<SnapshotIdSet, T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<SnapshotIdSet, T> f9536g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapshotKt$takeNewSnapshot$1(Function1<? super SnapshotIdSet, ? extends T> function1) {
        super(1);
        this.f9536g = function1;
    }

    @NotNull
    public final T invoke(@NotNull SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "invalid");
        T t11 = (Snapshot) this.f9536g.invoke(snapshotIdSet);
        synchronized (SnapshotKt.getLock()) {
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(t11.getId());
            Unit unit = Unit.INSTANCE;
        }
        return t11;
    }
}
