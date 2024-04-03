package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import com.instabug.commons.snapshot.StateSnapshotCaptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\u001a\b\u0010$\u001a\u00020\bH\u0002\u001a6\u0010$\u001a\u0002H%\"\u0004\b\u0000\u0010%2!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H%0\u000fH\u0002¢\u0006\u0002\u0010'\u001a4\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\b\u0002\u0010+\u001a\u00020,H\u0002\u001a\u001f\u0010-\u001a\u0002H%\"\b\b\u0000\u0010%*\u00020.2\u0006\u0010/\u001a\u0002H%H\u0001¢\u0006\u0002\u00100\u001a'\u0010-\u001a\u0002H%\"\b\b\u0000\u0010%*\u00020.2\u0006\u0010/\u001a\u0002H%2\u0006\u00101\u001a\u00020\u0007H\u0001¢\u0006\u0002\u00102\u001a\b\u00103\u001a\u00020\u0007H\u0000\u001aL\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\b\u0002\u00106\u001a\u00020,H\u0002\u001aB\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0002\u001a\u0018\u00109\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00072\u0006\u0010:\u001a\u00020;H\u0001\u001a.\u0010<\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.\u0018\u00010=2\u0006\u00103\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020\u0010H\u0002\u001a\b\u0010A\u001a\u00020BH\u0002\u001a1\u0010C\u001a\u0004\u0018\u0001H%\"\b\b\u0000\u0010%*\u00020.2\u0006\u0010/\u001a\u0002H%2\u0006\u0010D\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010E\u001a\u0010\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u0001H\u0000\u001a\b\u0010H\u001a\u00020BH\u0002\u001a%\u0010I\u001a\u0002H%\"\u0004\b\u0000\u0010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H%0JH\bø\u0001\u0000¢\u0006\u0002\u0010K\u001a>\u0010L\u001a\u0002H%\"\u0004\b\u0000\u0010%2\u0006\u0010M\u001a\u00020\u00072!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H%0\u000fH\u0002¢\u0006\u0002\u0010N\u001a:\u0010O\u001a\u0002H%\"\b\b\u0000\u0010%*\u00020\u00072!\u0010&\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H%0\u000fH\u0002¢\u0006\u0002\u0010P\u001a\u0018\u0010Q\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0000\u001a\u0012\u0010R\u001a\u0004\u0018\u00010.2\u0006\u0010:\u001a\u00020;H\u0002\u001a \u0010S\u001a\u00020,2\u0006\u0010T\u001a\u00020.2\u0006\u00101\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a \u0010S\u001a\u00020,2\u0006\u00103\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a\u0010\u0010V\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0007H\u0002\u001a\u001c\u0010W\u001a\u00020\u0010*\u00020\u00102\u0006\u0010X\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0001H\u0000\u001a#\u0010Z\u001a\u0002H%\"\b\b\u0000\u0010%*\u00020.*\u0002H%2\u0006\u0010:\u001a\u00020;H\u0000¢\u0006\u0002\u0010[\u001a+\u0010\\\u001a\u0002H%\"\b\b\u0000\u0010%*\u00020.*\u0002H%2\u0006\u0010:\u001a\u00020;2\u0006\u00101\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010]\u001aN\u0010^\u001a\u0002H_\"\b\b\u0000\u0010%*\u00020.\"\u0004\b\u0001\u0010_*\u0002H%2\u0006\u0010:\u001a\u00020;2\u0006\u0010`\u001a\u0002H%2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H_0\u000f¢\u0006\u0002\baH\bø\u0001\u0000¢\u0006\u0002\u0010b\u001a3\u0010c\u001a\u0002H%\"\b\b\u0000\u0010%*\u00020.*\u0002H%2\u0006\u0010:\u001a\u00020;2\u0006\u00101\u001a\u00020\u00072\u0006\u0010`\u001a\u0002H%H\u0000¢\u0006\u0002\u0010d\u001a!\u0010C\u001a\u0002H%\"\b\b\u0000\u0010%*\u00020.*\u0002H%2\u0006\u0010:\u001a\u00020;¢\u0006\u0002\u0010[\u001a)\u0010C\u001a\u0002H%\"\b\b\u0000\u0010%*\u00020.*\u0002H%2\u0006\u0010:\u001a\u00020;2\u0006\u00101\u001a\u00020\u0007¢\u0006\u0002\u0010]\u001aH\u0010e\u001a\u0002H_\"\b\b\u0000\u0010%*\u00020.\"\u0004\b\u0001\u0010_*\u0002H%2!\u0010&\u001a\u001d\u0012\u0013\u0012\u0011H%¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(/\u0012\u0004\u0012\u0002H_0\u000fH\bø\u0001\u0000¢\u0006\u0002\u0010f\u001aF\u0010g\u001a\u0002H_\"\b\b\u0000\u0010%*\u00020.\"\u0004\b\u0001\u0010_*\u0002H%2\u0006\u0010:\u001a\u00020;2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H_0\u000f¢\u0006\u0002\baH\bø\u0001\u0000¢\u0006\u0002\u0010h\u001aN\u0010g\u001a\u0002H_\"\b\b\u0000\u0010%*\u00020.\"\u0004\b\u0001\u0010_*\u0002H%2\u0006\u0010:\u001a\u00020;2\u0006\u00101\u001a\u00020\u00072\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u0002H_0\u000f¢\u0006\u0002\baH\bø\u0001\u0000¢\u0006\u0002\u0010i\u001a+\u0010j\u001a\u0002H%\"\b\b\u0000\u0010%*\u00020.*\u0002H%2\u0006\u0010:\u001a\u00020;2\u0006\u00101\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010]\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\",\u0010\u0002\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\".\u0010\t\u001a\"\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nj\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b`\rX\u0004¢\u0006\u0002\n\u0000\")\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u000fX\u0004¢\u0006\u0002\n\u0000\" \u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000f0\u0003X\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0015\u001a\u00020\u00068\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u000e\u0010\u001a\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u001e\u001a\u00020\u00078\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010!\"\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070#X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006k"}, d2 = {"INVALID_SNAPSHOT", "", "applyObservers", "", "Lkotlin/Function2;", "", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "", "currentGlobalSnapshot", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "emptyLambda", "Lkotlin/Function1;", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "Lkotlin/ParameterName;", "name", "invalid", "globalWriteObservers", "lock", "getLock$annotations", "()V", "getLock", "()Ljava/lang/Object;", "nextSnapshotId", "openSnapshots", "pinningTable", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "snapshotInitializer", "getSnapshotInitializer$annotations", "getSnapshotInitializer", "()Landroidx/compose/runtime/snapshots/Snapshot;", "threadSnapshot", "Landroidx/compose/runtime/SnapshotThreadLocal;", "advanceGlobalSnapshot", "T", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "createTransparentSnapshotWithNoParentReadObserver", "previousSnapshot", "readObserver", "ownsPreviousSnapshot", "", "current", "Landroidx/compose/runtime/snapshots/StateRecord;", "r", "(Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "snapshot", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "currentSnapshot", "mergedReadObserver", "parentObserver", "mergeReadObserver", "mergedWriteObserver", "writeObserver", "notifyWrite", "state", "Landroidx/compose/runtime/snapshots/StateObject;", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "applyingSnapshot", "invalidSnapshots", "readError", "", "readable", "id", "(Landroidx/compose/runtime/snapshots/StateRecord;ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "releasePinningLocked", "handle", "reportReadonlySnapshotWrite", "sync", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "takeNewGlobalSnapshot", "previousGlobalSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "takeNewSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "trackPinning", "used", "valid", "data", "candidateSnapshot", "validateOpen", "addRange", "from", "until", "newOverwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "overwritable", "R", "candidate", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "overwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "withCurrent", "(Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writable", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writableRecord", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SnapshotKt {
    private static final int INVALID_SNAPSHOT = 0;
    /* access modifiers changed from: private */
    @NotNull
    public static final List<Function2<Set<? extends Object>, Snapshot, Unit>> applyObservers = new ArrayList();
    /* access modifiers changed from: private */
    @NotNull
    public static final AtomicReference<GlobalSnapshot> currentGlobalSnapshot;
    /* access modifiers changed from: private */
    @NotNull
    public static final Function1<SnapshotIdSet, Unit> emptyLambda = SnapshotKt$emptyLambda$1.INSTANCE;
    /* access modifiers changed from: private */
    @NotNull
    public static final List<Function1<Object, Unit>> globalWriteObservers = new ArrayList();
    @NotNull
    private static final Object lock = new Object();
    /* access modifiers changed from: private */
    public static int nextSnapshotId;
    /* access modifiers changed from: private */
    @NotNull
    public static SnapshotIdSet openSnapshots;
    @NotNull
    private static final SnapshotDoubleIndexHeap pinningTable = new SnapshotDoubleIndexHeap();
    @NotNull
    private static final Snapshot snapshotInitializer;
    /* access modifiers changed from: private */
    @NotNull
    public static final SnapshotThreadLocal<Snapshot> threadSnapshot = new SnapshotThreadLocal<>();

    static {
        SnapshotIdSet.Companion companion = SnapshotIdSet.Companion;
        openSnapshots = companion.getEMPTY();
        nextSnapshotId = 1;
        int i11 = nextSnapshotId;
        nextSnapshotId = i11 + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(i11, companion.getEMPTY());
        openSnapshots = openSnapshots.set(globalSnapshot.getId());
        AtomicReference<GlobalSnapshot> atomicReference = new AtomicReference<>(globalSnapshot);
        currentGlobalSnapshot = atomicReference;
        GlobalSnapshot globalSnapshot2 = atomicReference.get();
        Intrinsics.checkNotNullExpressionValue(globalSnapshot2, "currentGlobalSnapshot.get()");
        snapshotInitializer = globalSnapshot2;
    }

    public static /* synthetic */ Snapshot a(Snapshot snapshot, Function1 function1, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return createTransparentSnapshotWithNoParentReadObserver(snapshot, function1, z11);
    }

    @NotNull
    public static final SnapshotIdSet addRange(@NotNull SnapshotIdSet snapshotIdSet, int i11, int i12) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "<this>");
        while (i11 < i12) {
            snapshotIdSet = snapshotIdSet.set(i11);
            i11++;
        }
        return snapshotIdSet;
    }

    /* access modifiers changed from: private */
    public static final <T> T advanceGlobalSnapshot(Function1<? super SnapshotIdSet, ? extends T> function1) {
        GlobalSnapshot globalSnapshot;
        T takeNewGlobalSnapshot;
        List mutableList;
        Snapshot snapshot = snapshotInitializer;
        Intrinsics.checkNotNull(snapshot, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot");
        GlobalSnapshot globalSnapshot2 = (GlobalSnapshot) snapshot;
        synchronized (getLock()) {
            globalSnapshot = currentGlobalSnapshot.get();
            Intrinsics.checkNotNullExpressionValue(globalSnapshot, "currentGlobalSnapshot.get()");
            takeNewGlobalSnapshot = takeNewGlobalSnapshot(globalSnapshot, function1);
        }
        Set<StateObject> modified$runtime_release = globalSnapshot.getModified$runtime_release();
        if (modified$runtime_release != null) {
            synchronized (getLock()) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList(applyObservers);
            }
            int size = mutableList.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((Function2) mutableList.get(i11)).invoke(modified$runtime_release, globalSnapshot);
            }
        }
        return takeNewGlobalSnapshot;
    }

    public static /* synthetic */ Function1 b(Function1 function1, Function1 function12, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = true;
        }
        return mergedReadObserver(function1, function12, z11);
    }

    /* access modifiers changed from: private */
    public static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot snapshot, Function1<Object, Unit> function1, boolean z11) {
        MutableSnapshot mutableSnapshot;
        boolean z12 = snapshot instanceof MutableSnapshot;
        if (!z12 && snapshot != null) {
            return new TransparentObserverSnapshot(snapshot, function1, false, z11);
        }
        if (z12) {
            mutableSnapshot = (MutableSnapshot) snapshot;
        } else {
            mutableSnapshot = null;
        }
        return new TransparentObserverMutableSnapshot(mutableSnapshot, function1, (Function1<Object, Unit>) null, false, z11);
    }

    @NotNull
    @PublishedApi
    public static final <T extends StateRecord> T current(@NotNull T t11, @NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(t11, "r");
        Intrinsics.checkNotNullParameter(snapshot, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
        T readable = readable(t11, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable != null) {
            return readable;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = threadSnapshot.get();
        if (snapshot != null) {
            return snapshot;
        }
        GlobalSnapshot globalSnapshot = currentGlobalSnapshot.get();
        Intrinsics.checkNotNullExpressionValue(globalSnapshot, "currentGlobalSnapshot.get()");
        return globalSnapshot;
    }

    @NotNull
    public static final Object getLock() {
        return lock;
    }

    @PublishedApi
    public static /* synthetic */ void getLock$annotations() {
    }

    @NotNull
    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    @PublishedApi
    public static /* synthetic */ void getSnapshotInitializer$annotations() {
    }

    /* access modifiers changed from: private */
    public static final Function1<Object, Unit> mergedReadObserver(Function1<Object, Unit> function1, Function1<Object, Unit> function12, boolean z11) {
        if (!z11) {
            function12 = null;
        }
        if (function1 != null && function12 != null && !Intrinsics.areEqual((Object) function1, (Object) function12)) {
            return new SnapshotKt$mergedReadObserver$1(function1, function12);
        }
        if (function1 == null) {
            return function12;
        }
        return function1;
    }

    /* access modifiers changed from: private */
    public static final Function1<Object, Unit> mergedWriteObserver(Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        if (function1 != null && function12 != null && !Intrinsics.areEqual((Object) function1, (Object) function12)) {
            return new SnapshotKt$mergedWriteObserver$1(function1, function12);
        }
        if (function1 == null) {
            return function12;
        }
        return function1;
    }

    @NotNull
    public static final <T extends StateRecord> T newOverwritableRecord(@NotNull T t11, @NotNull StateObject stateObject) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, "state");
        T used = used(stateObject);
        if (used != null) {
            used.setSnapshotId$runtime_release(Integer.MAX_VALUE);
            return used;
        }
        T create = t11.create();
        create.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        create.setNext$runtime_release(stateObject.getFirstStateRecord());
        Intrinsics.checkNotNull(create, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecord$lambda-8");
        stateObject.prependStateRecord(create);
        Intrinsics.checkNotNull(create, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecord");
        return create;
    }

    @NotNull
    public static final <T extends StateRecord> T newWritableRecord(@NotNull T t11, @NotNull StateObject stateObject, @NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, "state");
        Intrinsics.checkNotNullParameter(snapshot, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
        T newOverwritableRecord = newOverwritableRecord(t11, stateObject);
        newOverwritableRecord.assign(t11);
        newOverwritableRecord.setSnapshotId$runtime_release(snapshot.getId());
        return newOverwritableRecord;
    }

    @PublishedApi
    public static final void notifyWrite(@NotNull Snapshot snapshot, @NotNull StateObject stateObject) {
        Intrinsics.checkNotNullParameter(snapshot, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
        Intrinsics.checkNotNullParameter(stateObject, "state");
        Function1<Object, Unit> writeObserver$runtime_release = snapshot.getWriteObserver$runtime_release();
        if (writeObserver$runtime_release != null) {
            writeObserver$runtime_release.invoke(stateObject);
        }
    }

    /* access modifiers changed from: private */
    public static final Map<StateRecord, StateRecord> optimisticMerges(MutableSnapshot mutableSnapshot, MutableSnapshot mutableSnapshot2, SnapshotIdSet snapshotIdSet) {
        StateRecord readable;
        Set<StateObject> modified$runtime_release = mutableSnapshot2.getModified$runtime_release();
        int id2 = mutableSnapshot.getId();
        if (modified$runtime_release == null) {
            return null;
        }
        SnapshotIdSet or2 = mutableSnapshot2.getInvalid$runtime_release().set(mutableSnapshot2.getId()).or(mutableSnapshot2.getPreviousIds$runtime_release());
        HashMap hashMap = null;
        for (StateObject next : modified$runtime_release) {
            StateRecord firstStateRecord = next.getFirstStateRecord();
            StateRecord readable2 = readable(firstStateRecord, id2, snapshotIdSet);
            if (!(readable2 == null || (readable = readable(firstStateRecord, id2, or2)) == null || Intrinsics.areEqual((Object) readable2, (Object) readable))) {
                StateRecord readable3 = readable(firstStateRecord, mutableSnapshot2.getId(), mutableSnapshot2.getInvalid$runtime_release());
                if (readable3 != null) {
                    StateRecord mergeRecords = next.mergeRecords(readable, readable2, readable3);
                    if (mergeRecords == null) {
                        return null;
                    }
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(readable2, mergeRecords);
                    hashMap = hashMap;
                } else {
                    readError();
                    throw new KotlinNothingValueException();
                }
            }
        }
        return hashMap;
    }

    public static final <T extends StateRecord, R> R overwritable(@NotNull T t11, @NotNull StateObject stateObject, @NotNull T t12, @NotNull Function1<? super T, ? extends R> function1) {
        Snapshot current;
        R invoke;
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, "state");
        Intrinsics.checkNotNullParameter(t12, "candidate");
        Intrinsics.checkNotNullParameter(function1, "block");
        getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                invoke = function1.invoke(overwritableRecord(t11, stateObject, current, t12));
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(current, stateObject);
        return invoke;
    }

    @NotNull
    public static final <T extends StateRecord> T overwritableRecord(@NotNull T t11, @NotNull StateObject stateObject, @NotNull Snapshot snapshot, @NotNull T t12) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, "state");
        Intrinsics.checkNotNullParameter(snapshot, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
        Intrinsics.checkNotNullParameter(t12, "candidate");
        if (snapshot.getReadOnly()) {
            snapshot.recordModified$runtime_release(stateObject);
        }
        int id2 = snapshot.getId();
        if (t12.getSnapshotId$runtime_release() == id2) {
            return t12;
        }
        T newOverwritableRecord = newOverwritableRecord(t11, stateObject);
        newOverwritableRecord.setSnapshotId$runtime_release(id2);
        snapshot.recordModified$runtime_release(stateObject);
        return newOverwritableRecord;
    }

    /* access modifiers changed from: private */
    public static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
    }

    /* access modifiers changed from: private */
    public static final <T extends StateRecord> T readable(T t11, int i11, SnapshotIdSet snapshotIdSet) {
        T t12 = null;
        while (t11 != null) {
            if (valid((StateRecord) t11, i11, snapshotIdSet) && (t12 == null || t12.getSnapshotId$runtime_release() < t11.getSnapshotId$runtime_release())) {
                t12 = t11;
            }
            t11 = t11.getNext$runtime_release();
        }
        if (t12 != null) {
            return t12;
        }
        return null;
    }

    public static final void releasePinningLocked(int i11) {
        pinningTable.remove(i11);
    }

    /* access modifiers changed from: private */
    public static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
    }

    @PublishedApi
    public static final <T> T sync(@NotNull Function0<? extends T> function0) {
        T invoke;
        Intrinsics.checkNotNullParameter(function0, "block");
        synchronized (getLock()) {
            try {
                invoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }

    /* access modifiers changed from: private */
    public static final <T> T takeNewGlobalSnapshot(Snapshot snapshot, Function1<? super SnapshotIdSet, ? extends T> function1) {
        T invoke = function1.invoke(openSnapshots.clear(snapshot.getId()));
        synchronized (getLock()) {
            int i11 = nextSnapshotId;
            nextSnapshotId = i11 + 1;
            openSnapshots = openSnapshots.clear(snapshot.getId());
            currentGlobalSnapshot.set(new GlobalSnapshot(i11, openSnapshots));
            snapshot.dispose();
            openSnapshots = openSnapshots.set(i11);
            Unit unit = Unit.INSTANCE;
        }
        return invoke;
    }

    /* access modifiers changed from: private */
    public static final <T extends Snapshot> T takeNewSnapshot(Function1<? super SnapshotIdSet, ? extends T> function1) {
        return (Snapshot) advanceGlobalSnapshot(new SnapshotKt$takeNewSnapshot$1(function1));
    }

    public static final int trackPinning(int i11, @NotNull SnapshotIdSet snapshotIdSet) {
        int add;
        Intrinsics.checkNotNullParameter(snapshotIdSet, "invalid");
        int lowest = snapshotIdSet.lowest(i11);
        synchronized (getLock()) {
            add = pinningTable.add(lowest);
        }
        return add;
    }

    private static final StateRecord used(StateObject stateObject) {
        int lowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId) - 1;
        SnapshotIdSet empty = SnapshotIdSet.Companion.getEMPTY();
        StateRecord stateRecord = null;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
            if (firstStateRecord.getSnapshotId$runtime_release() == 0) {
                return firstStateRecord;
            }
            if (valid(firstStateRecord, lowestOrDefault, empty)) {
                if (stateRecord == null) {
                    stateRecord = firstStateRecord;
                } else if (firstStateRecord.getSnapshotId$runtime_release() < stateRecord.getSnapshotId$runtime_release()) {
                    return firstStateRecord;
                } else {
                    return stateRecord;
                }
            }
        }
        return null;
    }

    private static final boolean valid(int i11, int i12, SnapshotIdSet snapshotIdSet) {
        return i12 != 0 && i12 <= i11 && !snapshotIdSet.get(i12);
    }

    /* access modifiers changed from: private */
    public static final void validateOpen(Snapshot snapshot) {
        if (!openSnapshots.get(snapshot.getId())) {
            throw new IllegalStateException("Snapshot is not open".toString());
        }
    }

    public static final <T extends StateRecord, R> R withCurrent(@NotNull T t11, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        return function1.invoke(current(t11));
    }

    public static final <T extends StateRecord, R> R writable(@NotNull T t11, @NotNull StateObject stateObject, @NotNull Function1<? super T, ? extends R> function1) {
        Snapshot current;
        R invoke;
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, "state");
        Intrinsics.checkNotNullParameter(function1, "block");
        getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                invoke = function1.invoke(writableRecord(t11, stateObject, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(current, stateObject);
        return invoke;
    }

    @NotNull
    @PublishedApi
    public static final <T extends StateRecord> T writableRecord(@NotNull T t11, @NotNull StateObject stateObject, @NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, "state");
        Intrinsics.checkNotNullParameter(snapshot, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
        if (snapshot.getReadOnly()) {
            snapshot.recordModified$runtime_release(stateObject);
        }
        T readable = readable(t11, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable == null) {
            readError();
            throw new KotlinNothingValueException();
        } else if (readable.getSnapshotId$runtime_release() == snapshot.getId()) {
            return readable;
        } else {
            T newWritableRecord = newWritableRecord(readable, stateObject, snapshot);
            snapshot.recordModified$runtime_release(stateObject);
            return newWritableRecord;
        }
    }

    @NotNull
    @PublishedApi
    public static final <T extends StateRecord> T current(@NotNull T t11) {
        T readable;
        Intrinsics.checkNotNullParameter(t11, "r");
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot current = companion.getCurrent();
        T readable2 = readable(t11, current.getId(), current.getInvalid$runtime_release());
        if (readable2 != null) {
            return readable2;
        }
        synchronized (getLock()) {
            Snapshot current2 = companion.getCurrent();
            readable = readable(t11, current2.getId(), current2.getInvalid$runtime_release());
        }
        if (readable != null) {
            return readable;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    private static final boolean valid(StateRecord stateRecord, int i11, SnapshotIdSet snapshotIdSet) {
        return valid(i11, stateRecord.getSnapshotId$runtime_release(), snapshotIdSet);
    }

    @NotNull
    public static final <T extends StateRecord> T readable(@NotNull T t11, @NotNull StateObject stateObject) {
        T readable;
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, "state");
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot current = companion.getCurrent();
        Function1<Object, Unit> readObserver$runtime_release = current.getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(stateObject);
        }
        T readable2 = readable(t11, current.getId(), current.getInvalid$runtime_release());
        if (readable2 != null) {
            return readable2;
        }
        synchronized (getLock()) {
            Snapshot current2 = companion.getCurrent();
            readable = readable(t11, current2.getId(), current2.getInvalid$runtime_release());
        }
        if (readable != null) {
            return readable;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final <T extends StateRecord, R> R writable(@NotNull T t11, @NotNull StateObject stateObject, @NotNull Snapshot snapshot, @NotNull Function1<? super T, ? extends R> function1) {
        R invoke;
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, "state");
        Intrinsics.checkNotNullParameter(snapshot, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
        Intrinsics.checkNotNullParameter(function1, "block");
        synchronized (getLock()) {
            try {
                invoke = function1.invoke(writableRecord(t11, stateObject, snapshot));
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(snapshot, stateObject);
        return invoke;
    }

    @NotNull
    public static final <T extends StateRecord> T readable(@NotNull T t11, @NotNull StateObject stateObject, @NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(t11, "<this>");
        Intrinsics.checkNotNullParameter(stateObject, "state");
        Intrinsics.checkNotNullParameter(snapshot, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
        Function1<Object, Unit> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(stateObject);
        }
        T readable = readable(t11, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable != null) {
            return readable;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    /* access modifiers changed from: private */
    public static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(SnapshotKt$advanceGlobalSnapshot$2.INSTANCE);
    }
}
