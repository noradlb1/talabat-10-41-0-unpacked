package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0002\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/snapshots/NestedMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "parent", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "deactivated", "", "getParent", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "root", "Landroidx/compose/runtime/snapshots/Snapshot;", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "deactivate", "dispose", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NestedMutableSnapshot extends MutableSnapshot {
    private boolean deactivated;
    @NotNull
    private final MutableSnapshot parent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedMutableSnapshot(int i11, @NotNull SnapshotIdSet snapshotIdSet, @Nullable Function1<Object, Unit> function1, @Nullable Function1<Object, Unit> function12, @NotNull MutableSnapshot mutableSnapshot) {
        super(i11, snapshotIdSet, function1, function12);
        Intrinsics.checkNotNullParameter(snapshotIdSet, "invalid");
        Intrinsics.checkNotNullParameter(mutableSnapshot, "parent");
        this.parent = mutableSnapshot;
        mutableSnapshot.nestedActivated$runtime_release(this);
    }

    private final void deactivate() {
        if (!this.deactivated) {
            this.deactivated = true;
            this.parent.nestedDeactivated$runtime_release(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            r6 = this;
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent
            boolean r0 = r0.getApplied$runtime_release()
            if (r0 != 0) goto L_0x00be
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent
            boolean r0 = r0.getDisposed$runtime_release()
            if (r0 == 0) goto L_0x0012
            goto L_0x00be
        L_0x0012:
            java.util.Set r0 = r6.getModified$runtime_release()
            int r1 = r6.getId()
            if (r0 == 0) goto L_0x0027
            androidx.compose.runtime.snapshots.MutableSnapshot r2 = r6.parent
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r2.getInvalid$runtime_release()
            java.util.Map r2 = androidx.compose.runtime.snapshots.SnapshotKt.optimisticMerges(r2, r6, r3)
            goto L_0x0028
        L_0x0027:
            r2 = 0
        L_0x0028:
            java.lang.Object r3 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r3)
            androidx.compose.runtime.snapshots.SnapshotKt.validateOpen(r6)     // Catch:{ all -> 0x00bb }
            if (r0 == 0) goto L_0x0069
            int r4 = r0.size()     // Catch:{ all -> 0x00bb }
            if (r4 != 0) goto L_0x0039
            goto L_0x0069
        L_0x0039:
            androidx.compose.runtime.snapshots.MutableSnapshot r4 = r6.parent     // Catch:{ all -> 0x00bb }
            int r4 = r4.getId()     // Catch:{ all -> 0x00bb }
            androidx.compose.runtime.snapshots.MutableSnapshot r5 = r6.parent     // Catch:{ all -> 0x00bb }
            androidx.compose.runtime.snapshots.SnapshotIdSet r5 = r5.getInvalid$runtime_release()     // Catch:{ all -> 0x00bb }
            androidx.compose.runtime.snapshots.SnapshotApplyResult r2 = r6.innerApplyLocked$runtime_release(r4, r2, r5)     // Catch:{ all -> 0x00bb }
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r4 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE     // Catch:{ all -> 0x00bb }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x00bb }
            if (r4 != 0) goto L_0x0053
            monitor-exit(r3)
            return r2
        L_0x0053:
            androidx.compose.runtime.snapshots.MutableSnapshot r2 = r6.parent     // Catch:{ all -> 0x00bb }
            java.util.Set r2 = r2.getModified$runtime_release()     // Catch:{ all -> 0x00bb }
            if (r2 != 0) goto L_0x0065
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x00bb }
            r2.<init>()     // Catch:{ all -> 0x00bb }
            androidx.compose.runtime.snapshots.MutableSnapshot r4 = r6.parent     // Catch:{ all -> 0x00bb }
            r4.setModified(r2)     // Catch:{ all -> 0x00bb }
        L_0x0065:
            r2.addAll(r0)     // Catch:{ all -> 0x00bb }
            goto L_0x006c
        L_0x0069:
            r6.closeAndReleasePinning$runtime_release()     // Catch:{ all -> 0x00bb }
        L_0x006c:
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch:{ all -> 0x00bb }
            int r0 = r0.getId()     // Catch:{ all -> 0x00bb }
            if (r0 >= r1) goto L_0x0079
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch:{ all -> 0x00bb }
            r0.advance$runtime_release()     // Catch:{ all -> 0x00bb }
        L_0x0079:
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch:{ all -> 0x00bb }
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r0.getInvalid$runtime_release()     // Catch:{ all -> 0x00bb }
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r2.clear(r1)     // Catch:{ all -> 0x00bb }
            androidx.compose.runtime.snapshots.SnapshotIdSet r4 = r6.getPreviousIds$runtime_release()     // Catch:{ all -> 0x00bb }
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r2.andNot(r4)     // Catch:{ all -> 0x00bb }
            r0.setInvalid$runtime_release(r2)     // Catch:{ all -> 0x00bb }
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch:{ all -> 0x00bb }
            r0.recordPrevious$runtime_release(r1)     // Catch:{ all -> 0x00bb }
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch:{ all -> 0x00bb }
            int r1 = r6.takeoverPinnedSnapshot$runtime_release()     // Catch:{ all -> 0x00bb }
            r0.recordPreviousPinnedSnapshot$runtime_release(r1)     // Catch:{ all -> 0x00bb }
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch:{ all -> 0x00bb }
            androidx.compose.runtime.snapshots.SnapshotIdSet r1 = r6.getPreviousIds$runtime_release()     // Catch:{ all -> 0x00bb }
            r0.recordPreviousList$runtime_release(r1)     // Catch:{ all -> 0x00bb }
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r6.parent     // Catch:{ all -> 0x00bb }
            int[] r1 = r6.getPreviousPinnedSnapshots$runtime_release()     // Catch:{ all -> 0x00bb }
            r0.recordPreviousPinnedSnapshots$runtime_release(r1)     // Catch:{ all -> 0x00bb }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00bb }
            monitor-exit(r3)
            r0 = 1
            r6.setApplied$runtime_release(r0)
            r6.deactivate()
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r0 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE
            return r0
        L_0x00bb:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x00be:
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure r0 = new androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure
            r0.<init>(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.NestedMutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    public void dispose() {
        if (!getDisposed$runtime_release()) {
            super.dispose();
            deactivate();
        }
    }

    @NotNull
    public final MutableSnapshot getParent() {
        return this.parent;
    }

    @NotNull
    public Snapshot getRoot() {
        return this.parent.getRoot();
    }
}
