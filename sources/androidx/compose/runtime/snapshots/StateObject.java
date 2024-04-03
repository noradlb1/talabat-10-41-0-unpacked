package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y.a;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/snapshots/StateObject;", "", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "mergeRecords", "previous", "current", "applied", "prependStateRecord", "", "value", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface StateObject {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Nullable
        @Deprecated
        public static StateRecord mergeRecords(@NotNull StateObject stateObject, @NotNull StateRecord stateRecord, @NotNull StateRecord stateRecord2, @NotNull StateRecord stateRecord3) {
            Intrinsics.checkNotNullParameter(stateRecord, "previous");
            Intrinsics.checkNotNullParameter(stateRecord2, "current");
            Intrinsics.checkNotNullParameter(stateRecord3, "applied");
            return a.a(stateObject, stateRecord, stateRecord2, stateRecord3);
        }
    }

    @NotNull
    StateRecord getFirstStateRecord();

    @Nullable
    StateRecord mergeRecords(@NotNull StateRecord stateRecord, @NotNull StateRecord stateRecord2, @NotNull StateRecord stateRecord3);

    void prependStateRecord(@NotNull StateRecord stateRecord);
}
