package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import org.jetbrains.annotations.NotNull;
import y.a;

@Stable
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001MB\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001a\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J)\u0010%\u001a\u00020\u001b2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\bJ\u0016\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001dJ\u0016\u0010*\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010+\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010,J\u0015\u0010-\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u001bH\u0016J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0002J\u0015\u00102\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0016J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000042\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J.\u00105\u001a\u0002H6\"\u0004\b\u0001\u001062\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u0002H60'H\b¢\u0006\u0002\u00107J\"\u00108\u001a\u00020\u001b2\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u001b0'H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u000bH\u0016J\u0015\u0010;\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010<\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010=\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010,J\u0016\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010J\u0016\u0010A\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J+\u0010B\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0010H\u0000¢\u0006\u0002\bEJ\u001e\u0010F\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010GJ\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010H\u0016J)\u0010I\u001a\u00020\u001e2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\bJ3\u0010J\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'¢\u0006\u0002\bKH\b¢\u0006\u0002\u00107J3\u0010L\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'¢\u0006\u0002\bKH\b¢\u0006\u0002\u00107R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068AX\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148@X\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012¨\u0006N"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/List;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "size", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "conditionalUpdate", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "mutate", "R", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mutateBoolean", "prependStateRecord", "value", "remove", "removeAll", "removeAt", "removeRange", "fromIndex", "toIndex", "retainAll", "retainAllInRange", "start", "end", "retainAllInRange$runtime_release", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "update", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateListStateRecord", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SnapshotStateList<T> implements List<T>, StateObject, KMutableList {
    @NotNull
    private StateRecord firstStateRecord = new StateListStateRecord(ExtensionsKt.persistentListOf());

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "list", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class StateListStateRecord<T> extends StateRecord {
        @NotNull
        private PersistentList<? extends T> list;
        private int modification;

        public StateListStateRecord(@NotNull PersistentList<? extends T> persistentList) {
            Intrinsics.checkNotNullParameter(persistentList, DefaultCardView.CARD_LIST);
            this.list = persistentList;
        }

        public void assign(@NotNull StateRecord stateRecord) {
            Intrinsics.checkNotNullParameter(stateRecord, "value");
            synchronized (SnapshotStateListKt.sync) {
                this.list = ((StateListStateRecord) stateRecord).list;
                this.modification = ((StateListStateRecord) stateRecord).modification;
                Unit unit = Unit.INSTANCE;
            }
        }

        @NotNull
        public StateRecord create() {
            return new StateListStateRecord(this.list);
        }

        @NotNull
        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setList$runtime_release(@NotNull PersistentList<? extends T> persistentList) {
            Intrinsics.checkNotNullParameter(persistentList, "<set-?>");
            this.list = persistentList;
        }

        public final void setModification$runtime_release(int i11) {
            this.modification = i11;
        }
    }

    private final boolean conditionalUpdate(Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z11;
        Snapshot current;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord2 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                    modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList persistentList = (PersistentList) function1.invoke(list$runtime_release);
            z11 = false;
            if (Intrinsics.areEqual((Object) persistentList, (Object) list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord3 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord3;
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                        if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                            stateListStateRecord3.setList$runtime_release(persistentList);
                            stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                            z11 = true;
                        }
                        InlineMarker.finallyStart(1);
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, this);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            InlineMarker.finallyEnd(1);
        } while (!z11);
        return true;
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    private final <R> R mutate(Function1<? super List<T>, ? extends R> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        R invoke;
        Snapshot current;
        boolean z11;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord2 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                    modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            invoke = function1.invoke(builder);
            PersistentList build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord3 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord3;
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                        if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                            stateListStateRecord3.setList$runtime_release(build);
                            stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        InlineMarker.finallyStart(1);
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, this);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            InlineMarker.finallyEnd(1);
        } while (!z11);
        return invoke;
    }

    private final boolean mutateBoolean(Function1<? super List<T>, Boolean> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Boolean invoke;
        Snapshot current;
        boolean z11;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            invoke = function1.invoke(builder);
            PersistentList build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(build);
                        z11 = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z11 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z11);
        return invoke.booleanValue();
    }

    private final void update(Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z11;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord2 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                    modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList persistentList = (PersistentList) function1.invoke(list$runtime_release);
            if (!Intrinsics.areEqual((Object) persistentList, (Object) list$runtime_release)) {
                synchronized (SnapshotStateListKt.sync) {
                    try {
                        StateRecord firstStateRecord3 = getFirstStateRecord();
                        Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                        StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord3;
                        SnapshotKt.getSnapshotInitializer();
                        synchronized (SnapshotKt.getLock()) {
                            current = Snapshot.Companion.getCurrent();
                            StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                            if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                                stateListStateRecord3.setList$runtime_release(persistentList);
                                stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            InlineMarker.finallyStart(1);
                        }
                        InlineMarker.finallyEnd(1);
                        SnapshotKt.notifyWrite(current, this);
                        InlineMarker.finallyStart(1);
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                InlineMarker.finallyEnd(1);
            } else {
                return;
            }
        } while (!z11);
    }

    private final <R> R withCurrent(Function1<? super StateListStateRecord<T>, ? extends R> function1) {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return function1.invoke(SnapshotKt.current((StateListStateRecord) firstStateRecord2));
    }

    private final <R> R writable(Function1<? super StateListStateRecord<T>, ? extends R> function1) {
        Snapshot current;
        R invoke;
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord stateListStateRecord = (StateListStateRecord) firstStateRecord2;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                invoke = function1.invoke(SnapshotKt.writableRecord(stateListStateRecord, this, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(current, this);
        return invoke;
    }

    public boolean add(T t11) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z11;
        Snapshot current;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList add = list$runtime_release.add(t11);
            z11 = false;
            if (Intrinsics.areEqual((Object) add, (Object) list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(add);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                        z11 = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z11);
        return true;
    }

    public boolean addAll(int i11, @NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return mutateBoolean(new SnapshotStateList$addAll$1(i11, collection));
    }

    public void clear() {
        Snapshot current;
        synchronized (SnapshotStateListKt.sync) {
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord, this, current);
                stateListStateRecord2.setList$runtime_release(ExtensionsKt.persistentListOf());
                stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
            }
            SnapshotKt.notifyWrite(current, this);
        }
    }

    public boolean contains(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().contains(obj);
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return getReadable$runtime_release().getList$runtime_release().containsAll(collection);
    }

    public T get(int i11) {
        return getReadable$runtime_release().getList$runtime_release().get(i11);
    }

    @NotNull
    @JvmName(name = "getDebuggerDisplayValue")
    public final List<T> getDebuggerDisplayValue() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2)).getList$runtime_release();
    }

    @NotNull
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public final int getModification$runtime_release() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2)).getModification$runtime_release();
    }

    @NotNull
    public final StateListStateRecord<T> getReadable$runtime_release() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) firstStateRecord2, this);
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    public int indexOf(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(obj);
    }

    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    @NotNull
    public Iterator<T> iterator() {
        return listIterator();
    }

    public int lastIndexOf(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(obj);
    }

    @NotNull
    public ListIterator<T> listIterator() {
        return new StateListIterator(this, 0);
    }

    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return a.a(this, stateRecord, stateRecord2, stateRecord3);
    }

    public void prependStateRecord(@NotNull StateRecord stateRecord) {
        Intrinsics.checkNotNullParameter(stateRecord, "value");
        stateRecord.setNext$runtime_release(getFirstStateRecord());
        this.firstStateRecord = (StateListStateRecord) stateRecord;
    }

    public final /* bridge */ T remove(int i11) {
        return removeAt(i11);
    }

    public boolean removeAll(@NotNull Collection<? extends Object> collection) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z11;
        Snapshot current;
        Intrinsics.checkNotNullParameter(collection, "elements");
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<? extends Object> removeAll = list$runtime_release.removeAll(collection);
            z11 = false;
            if (Intrinsics.areEqual((Object) removeAll, (Object) list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(removeAll);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                        z11 = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z11);
        return true;
    }

    public T removeAt(int i11) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z11;
        T t11 = get(i11);
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList removeAt = list$runtime_release.removeAt(i11);
            if (Intrinsics.areEqual((Object) removeAt, (Object) list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(removeAt);
                        z11 = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z11 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z11);
        return t11;
    }

    public final void removeRange(int i11, int i12) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z11;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            builder.subList(i11, i12).clear();
            PersistentList build = builder.build();
            if (!Intrinsics.areEqual((Object) build, (Object) list$runtime_release)) {
                synchronized (SnapshotStateListKt.sync) {
                    StateRecord firstStateRecord3 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord3;
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                        if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                            stateListStateRecord3.setList$runtime_release(build);
                            z11 = true;
                            stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                        } else {
                            z11 = false;
                        }
                    }
                    SnapshotKt.notifyWrite(current, this);
                }
            } else {
                return;
            }
        } while (!z11);
    }

    public boolean retainAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return mutateBoolean(new SnapshotStateList$retainAll$1(collection));
    }

    public final int retainAllInRange$runtime_release(@NotNull Collection<? extends T> collection, int i11, int i12) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z11;
        Intrinsics.checkNotNullParameter(collection, "elements");
        int size = size();
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            builder.subList(i11, i12).retainAll(collection);
            PersistentList build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(build);
                        z11 = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z11 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z11);
        return size - size();
    }

    public T set(int i11, T t11) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z11;
        T t12 = get(i11);
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList persistentList = list$runtime_release.set(i11, t11);
            if (Intrinsics.areEqual((Object) persistentList, (Object) list$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(persistentList);
                        z11 = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z11 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z11);
        return t12;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public List<T> subList(int i11, int i12) {
        boolean z11;
        boolean z12 = true;
        if (i11 < 0 || i11 > i12) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11 || i12 > size()) {
            z12 = false;
        }
        if (z12) {
            return new SubList(this, i11, i12);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    public boolean addAll(@NotNull Collection<? extends T> collection) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z11;
        Snapshot current;
        Intrinsics.checkNotNullParameter(collection, "elements");
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<? extends T> addAll = list$runtime_release.addAll(collection);
            z11 = false;
            if (Intrinsics.areEqual((Object) addAll, (Object) list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(addAll);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                        z11 = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z11);
        return true;
    }

    @NotNull
    public ListIterator<T> listIterator(int i11) {
        return new StateListIterator(this, i11);
    }

    public boolean remove(Object obj) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z11;
        Snapshot current;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList remove = list$runtime_release.remove(obj);
            z11 = false;
            if (Intrinsics.areEqual((Object) remove, (Object) list$runtime_release)) {
                return false;
            }
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                    if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord3.setList$runtime_release(remove);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                        z11 = true;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z11);
        return true;
    }

    public void add(int i11, T t11) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z11;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList add = list$runtime_release.add(i11, t11);
            if (!Intrinsics.areEqual((Object) add, (Object) list$runtime_release)) {
                synchronized (SnapshotStateListKt.sync) {
                    StateRecord firstStateRecord3 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord3;
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                        if (stateListStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                            stateListStateRecord3.setList$runtime_release(add);
                            z11 = true;
                            stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification$runtime_release() + 1);
                        } else {
                            z11 = false;
                        }
                    }
                    SnapshotKt.notifyWrite(current, this);
                }
            } else {
                return;
            }
        } while (!z11);
    }
}
