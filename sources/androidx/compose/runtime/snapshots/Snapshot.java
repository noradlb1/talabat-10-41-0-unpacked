package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ExperimentalComposeApi;
import androidx.compose.runtime.InternalComposeApi;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Set;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 M2\u00020\u0001:\u0001MB\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010*\u001a\u00020 H\u0000¢\u0006\u0002\b+J\r\u0010,\u001a\u00020 H\u0010¢\u0006\u0002\b-J\b\u0010.\u001a\u00020 H\u0016J%\u0010/\u001a\u0002H0\"\u0004\b\u0000\u001002\f\u00101\u001a\b\u0012\u0004\u0012\u0002H002H\bø\u0001\u0000¢\u0006\u0002\u00103J\b\u00104\u001a\u00020\bH&J\n\u00105\u001a\u0004\u0018\u00010\u0000H\u0011J\u0015\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\u0000H ¢\u0006\u0002\b8J\u0015\u00109\u001a\u00020 2\u0006\u00107\u001a\u00020\u0000H ¢\u0006\u0002\b:J\r\u0010;\u001a\u00020 H ¢\u0006\u0002\b<J\u0015\u0010=\u001a\u00020 2\u0006\u0010>\u001a\u00020\u001aH ¢\u0006\u0002\b?J\r\u0010@\u001a\u00020 H\u0000¢\u0006\u0002\bAJ\r\u0010B\u001a\u00020 H\u0010¢\u0006\u0002\bCJ\u0012\u0010D\u001a\u00020 2\b\u00107\u001a\u0004\u0018\u00010\u0000H\u0011J \u0010E\u001a\u00020\u00002\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH&J\r\u0010F\u001a\u00020\u0003H\u0000¢\u0006\u0002\bGJ\n\u0010H\u001a\u0004\u0018\u00010\u0000H\u0007J\u0012\u0010I\u001a\u00020 2\b\u0010J\u001a\u0004\u0018\u00010\u0000H\u0007J\r\u0010K\u001a\u00020 H\u0000¢\u0006\u0002\bLR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003@PX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u00020\b8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\nR\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X \u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX \u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\nR\u0012\u0010%\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R \u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX \u0004¢\u0006\u0006\u001a\u0004\b)\u0010\"\u0001\u0004NOPQ\u0002\u0007\n\u0005\b20\u0001¨\u0006R"}, d2 = {"Landroidx/compose/runtime/snapshots/Snapshot;", "", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "disposed", "", "getDisposed$runtime_release", "()Z", "setDisposed$runtime_release", "(Z)V", "<set-?>", "getId", "()I", "setId$runtime_release", "(I)V", "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "isPinned", "isPinned$runtime_release", "modified", "", "Landroidx/compose/runtime/snapshots/StateObject;", "getModified$runtime_release", "()Ljava/util/Set;", "pinningTrackingHandle", "readObserver", "Lkotlin/Function1;", "", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "writeObserver", "getWriteObserver$runtime_release", "closeAndReleasePinning", "closeAndReleasePinning$runtime_release", "closeLocked", "closeLocked$runtime_release", "dispose", "enter", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasPendingChanges", "makeCurrent", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "releasePinnedSnapshotLocked", "releasePinnedSnapshotLocked$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "restoreCurrent", "takeNestedSnapshot", "takeoverPinnedSnapshot", "takeoverPinnedSnapshot$runtime_release", "unsafeEnter", "unsafeLeave", "oldSnapshot", "validateNotDisposed", "validateNotDisposed$runtime_release", "Companion", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class Snapshot {
    public static final int $stable = 8;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean disposed;

    /* renamed from: id  reason: collision with root package name */
    private int f9523id;
    @NotNull
    private SnapshotIdSet invalid;
    /* access modifiers changed from: private */
    public int pinningTrackingHandle;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0001J%\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\bø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJO\u0010\u000f\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0007J&\u0010\u0016\u001a\u00020\u00172\u001e\u0010\u0018\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0019J\u001a\u0010\u001b\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\u0011J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0001J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0001J\u0006\u0010\u001f\u001a\u00020\u000eJ6\u0010 \u001a\u00020!2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011J\u001e\u0010\"\u001a\u00020\u00042\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011J%\u0010#\u001a\u0002H$\"\u0004\b\u0000\u0010$2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H$0\u000bH\bø\u0001\u0000¢\u0006\u0002\u0010\fJ7\u0010%\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u0002H\t0\u000b¢\u0006\u0002\b&H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\fR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006'"}, d2 = {"Landroidx/compose/runtime/snapshots/Snapshot$Companion;", "", "()V", "current", "Landroidx/compose/runtime/snapshots/Snapshot;", "getCurrent", "()Landroidx/compose/runtime/snapshots/Snapshot;", "createNonObservableSnapshot", "global", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "notifyObjectsInitialized", "", "observe", "readObserver", "Lkotlin/Function1;", "writeObserver", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "openSnapshotCount", "", "registerApplyObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "observer", "Lkotlin/Function2;", "", "registerGlobalWriteObserver", "removeCurrent", "restoreCurrent", "previous", "sendApplyNotifications", "takeMutableSnapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "takeSnapshot", "withMutableSnapshot", "R", "withoutReadObservation", "Landroidx/compose/runtime/DisallowComposableCalls;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Object observe$default(Companion companion, Function1 function1, Function1 function12, Function0 function0, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                function1 = null;
            }
            if ((i11 & 2) != 0) {
                function12 = null;
            }
            return companion.observe(function1, function12, function0);
        }

        public static /* synthetic */ MutableSnapshot takeMutableSnapshot$default(Companion companion, Function1 function1, Function1 function12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                function1 = null;
            }
            if ((i11 & 2) != 0) {
                function12 = null;
            }
            return companion.takeMutableSnapshot(function1, function12);
        }

        public static /* synthetic */ Snapshot takeSnapshot$default(Companion companion, Function1 function1, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                function1 = null;
            }
            return companion.takeSnapshot(function1);
        }

        @NotNull
        @PublishedApi
        public final Snapshot createNonObservableSnapshot() {
            return SnapshotKt.a((Snapshot) SnapshotKt.threadSnapshot.get(), (Function1) null, false, 6, (Object) null);
        }

        @NotNull
        public final Snapshot getCurrent() {
            return SnapshotKt.currentSnapshot();
        }

        public final <T> T global(@NotNull Function0<? extends T> function0) {
            Intrinsics.checkNotNullParameter(function0, "block");
            Snapshot removeCurrent = removeCurrent();
            T invoke = function0.invoke();
            Snapshot.Companion.restoreCurrent(removeCurrent);
            return invoke;
        }

        public final void notifyObjectsInitialized() {
            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime_release();
        }

        public final <T> T observe(@Nullable Function1<Object, Unit> function1, @Nullable Function1<Object, Unit> function12, @NotNull Function0<? extends T> function0) {
            Snapshot snapshot;
            Snapshot makeCurrent;
            MutableSnapshot mutableSnapshot;
            Intrinsics.checkNotNullParameter(function0, "block");
            if (function1 == null && function12 == null) {
                return function0.invoke();
            }
            Snapshot snapshot2 = (Snapshot) SnapshotKt.threadSnapshot.get();
            if (snapshot2 == null || (snapshot2 instanceof MutableSnapshot)) {
                if (snapshot2 instanceof MutableSnapshot) {
                    mutableSnapshot = (MutableSnapshot) snapshot2;
                } else {
                    mutableSnapshot = null;
                }
                snapshot = new TransparentObserverMutableSnapshot(mutableSnapshot, function1, function12, true, false);
            } else if (function1 == null) {
                return function0.invoke();
            } else {
                snapshot = snapshot2.takeNestedSnapshot(function1);
            }
            try {
                makeCurrent = snapshot.makeCurrent();
                T invoke = function0.invoke();
                snapshot.restoreCurrent(makeCurrent);
                snapshot.dispose();
                return invoke;
            } catch (Throwable th2) {
                snapshot.dispose();
                throw th2;
            }
        }

        @InternalComposeApi
        public final int openSnapshotCount() {
            return CollectionsKt___CollectionsKt.toList(SnapshotKt.openSnapshots).size();
        }

        @NotNull
        public final ObserverHandle registerApplyObserver(@NotNull Function2<? super Set<? extends Object>, ? super Snapshot, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "observer");
            Object unused = SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.applyObservers.add(function2);
            }
            return new Snapshot$Companion$registerApplyObserver$2(function2);
        }

        @NotNull
        public final ObserverHandle registerGlobalWriteObserver(@NotNull Function1<Object, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "observer");
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.globalWriteObservers.add(function1);
            }
            SnapshotKt.advanceGlobalSnapshot();
            return new Snapshot$Companion$registerGlobalWriteObserver$2(function1);
        }

        @Nullable
        @PublishedApi
        public final Snapshot removeCurrent() {
            Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
            if (snapshot != null) {
                SnapshotKt.threadSnapshot.set(null);
            }
            return snapshot;
        }

        @PublishedApi
        public final void restoreCurrent(@Nullable Snapshot snapshot) {
            if (snapshot != null) {
                SnapshotKt.threadSnapshot.set(snapshot);
            }
        }

        public final void sendApplyNotifications() {
            boolean z11;
            synchronized (SnapshotKt.getLock()) {
                Set<StateObject> modified$runtime_release = ((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getModified$runtime_release();
                z11 = false;
                if (modified$runtime_release != null && (!modified$runtime_release.isEmpty())) {
                    z11 = true;
                }
            }
            if (z11) {
                SnapshotKt.advanceGlobalSnapshot();
            }
        }

        @NotNull
        public final MutableSnapshot takeMutableSnapshot(@Nullable Function1<Object, Unit> function1, @Nullable Function1<Object, Unit> function12) {
            MutableSnapshot mutableSnapshot;
            MutableSnapshot takeNestedMutableSnapshot;
            Snapshot currentSnapshot = SnapshotKt.currentSnapshot();
            if (currentSnapshot instanceof MutableSnapshot) {
                mutableSnapshot = (MutableSnapshot) currentSnapshot;
            } else {
                mutableSnapshot = null;
            }
            if (mutableSnapshot != null && (takeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(function1, function12)) != null) {
                return takeNestedMutableSnapshot;
            }
            throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot".toString());
        }

        @NotNull
        public final Snapshot takeSnapshot(@Nullable Function1<Object, Unit> function1) {
            return SnapshotKt.currentSnapshot().takeNestedSnapshot(function1);
        }

        public final <R> R withMutableSnapshot(@NotNull Function0<? extends R> function0) {
            Snapshot makeCurrent;
            Intrinsics.checkNotNullParameter(function0, "block");
            MutableSnapshot takeMutableSnapshot$default = takeMutableSnapshot$default(this, (Function1) null, (Function1) null, 3, (Object) null);
            try {
                makeCurrent = takeMutableSnapshot$default.makeCurrent();
                R invoke = function0.invoke();
                InlineMarker.finallyStart(1);
                takeMutableSnapshot$default.restoreCurrent(makeCurrent);
                InlineMarker.finallyEnd(1);
                takeMutableSnapshot$default.apply().check();
                InlineMarker.finallyStart(1);
                takeMutableSnapshot$default.dispose();
                InlineMarker.finallyEnd(1);
                return invoke;
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                takeMutableSnapshot$default.dispose();
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }

        public final <T> T withoutReadObservation(@NotNull Function0<? extends T> function0) {
            Snapshot makeCurrent;
            Intrinsics.checkNotNullParameter(function0, "block");
            Snapshot createNonObservableSnapshot = createNonObservableSnapshot();
            try {
                makeCurrent = createNonObservableSnapshot.makeCurrent();
                T invoke = function0.invoke();
                InlineMarker.finallyStart(1);
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                InlineMarker.finallyEnd(1);
                InlineMarker.finallyStart(1);
                createNonObservableSnapshot.dispose();
                InlineMarker.finallyEnd(1);
                return invoke;
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                createNonObservableSnapshot.dispose();
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
    }

    private Snapshot(int i11, SnapshotIdSet snapshotIdSet) {
        int i12;
        this.invalid = snapshotIdSet;
        this.f9523id = i11;
        if (i11 != 0) {
            i12 = SnapshotKt.trackPinning(i11, getInvalid$runtime_release());
        } else {
            i12 = -1;
        }
        this.pinningTrackingHandle = i12;
    }

    public /* synthetic */ Snapshot(int i11, SnapshotIdSet snapshotIdSet, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, snapshotIdSet);
    }

    public static /* synthetic */ Snapshot takeNestedSnapshot$default(Snapshot snapshot, Function1 function1, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                function1 = null;
            }
            return snapshot.takeNestedSnapshot(function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedSnapshot");
    }

    public final void closeAndReleasePinning$runtime_release() {
        synchronized (SnapshotKt.getLock()) {
            closeLocked$runtime_release();
            releasePinnedSnapshotsForCloseLocked$runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId());
    }

    public void dispose() {
        this.disposed = true;
        synchronized (SnapshotKt.getLock()) {
            releasePinnedSnapshotLocked$runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final <T> T enter(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        Snapshot makeCurrent = makeCurrent();
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            restoreCurrent(makeCurrent);
            InlineMarker.finallyEnd(1);
        }
    }

    public final boolean getDisposed$runtime_release() {
        return this.disposed;
    }

    public int getId() {
        return this.f9523id;
    }

    @NotNull
    public SnapshotIdSet getInvalid$runtime_release() {
        return this.invalid;
    }

    @Nullable
    public abstract Set<StateObject> getModified$runtime_release();

    @Nullable
    public abstract Function1<Object, Unit> getReadObserver$runtime_release();

    public abstract boolean getReadOnly();

    @NotNull
    public abstract Snapshot getRoot();

    @Nullable
    public abstract Function1<Object, Unit> getWriteObserver$runtime_release();

    public abstract boolean hasPendingChanges();

    public final boolean isPinned$runtime_release() {
        return this.pinningTrackingHandle >= 0;
    }

    @Nullable
    @PublishedApi
    public Snapshot makeCurrent() {
        Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
        SnapshotKt.threadSnapshot.set(this);
        return snapshot;
    }

    public abstract void nestedActivated$runtime_release(@NotNull Snapshot snapshot);

    public abstract void nestedDeactivated$runtime_release(@NotNull Snapshot snapshot);

    public abstract void notifyObjectsInitialized$runtime_release();

    public abstract void recordModified$runtime_release(@NotNull StateObject stateObject);

    public final void releasePinnedSnapshotLocked$runtime_release() {
        int i11 = this.pinningTrackingHandle;
        if (i11 >= 0) {
            SnapshotKt.releasePinningLocked(i11);
            this.pinningTrackingHandle = -1;
        }
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePinnedSnapshotLocked$runtime_release();
    }

    @PublishedApi
    public void restoreCurrent(@Nullable Snapshot snapshot) {
        SnapshotKt.threadSnapshot.set(snapshot);
    }

    public final void setDisposed$runtime_release(boolean z11) {
        this.disposed = z11;
    }

    public void setId$runtime_release(int i11) {
        this.f9523id = i11;
    }

    public void setInvalid$runtime_release(@NotNull SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "<set-?>");
        this.invalid = snapshotIdSet;
    }

    @NotNull
    public abstract Snapshot takeNestedSnapshot(@Nullable Function1<Object, Unit> function1);

    public final int takeoverPinnedSnapshot$runtime_release() {
        int i11 = this.pinningTrackingHandle;
        this.pinningTrackingHandle = -1;
        return i11;
    }

    @ExperimentalComposeApi
    @Nullable
    public final Snapshot unsafeEnter() {
        return makeCurrent();
    }

    @ExperimentalComposeApi
    public final void unsafeLeave(@Nullable Snapshot snapshot) {
        boolean z11;
        if (SnapshotKt.threadSnapshot.get() == this) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            restoreCurrent(snapshot);
            return;
        }
        throw new IllegalStateException(("Cannot leave snapshot; " + this + " is not the current snapshot").toString());
    }

    public final void validateNotDisposed$runtime_release() {
        if (!(!this.disposed)) {
            throw new IllegalArgumentException("Cannot use a disposed snapshot".toString());
        }
    }
}
