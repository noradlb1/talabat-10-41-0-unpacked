package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, d2 = {"asContextElement", "Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "Landroidx/compose/runtime/snapshots/Snapshot;", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SnapshotContextElementKt {
    @ExperimentalComposeApi
    @NotNull
    public static final SnapshotContextElement asContextElement(@NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "<this>");
        return new SnapshotContextElementImpl(snapshot);
    }
}
