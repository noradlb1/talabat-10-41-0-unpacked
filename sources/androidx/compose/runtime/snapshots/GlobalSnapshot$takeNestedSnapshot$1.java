package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class GlobalSnapshot$takeNestedSnapshot$1 extends Lambda implements Function1<SnapshotIdSet, ReadonlySnapshot> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Object, Unit> f9520g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobalSnapshot$takeNestedSnapshot$1(Function1<Object, Unit> function1) {
        super(1);
        this.f9520g = function1;
    }

    @NotNull
    public final ReadonlySnapshot invoke(@NotNull SnapshotIdSet snapshotIdSet) {
        int access$getNextSnapshotId$p;
        Intrinsics.checkNotNullParameter(snapshotIdSet, "invalid");
        synchronized (SnapshotKt.getLock()) {
            access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
        }
        return new ReadonlySnapshot(access$getNextSnapshotId$p, snapshotIdSet, this.f9520g);
    }
}
