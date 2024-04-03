package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.Stable;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y.a;

@Stable
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004:\u0001KB\u0005¢\u0006\u0002\u0010\u0005J1\u0010&\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*\u0012\u0004\u0012\u00020'0)H\bø\u0001\u0000¢\u0006\u0002\b+J1\u0010,\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*\u0012\u0004\u0012\u00020'0)H\bø\u0001\u0000¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0015\u00100\u001a\u00020'2\u0006\u00101\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00020'2\u0006\u00104\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00102J\u0018\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\b\u00107\u001a\u00020'H\u0016J4\u00108\u001a\u0002H9\"\u0004\b\u0002\u001092\u001e\u0010:\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u0002H90)H\b¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020/2\u0006\u00104\u001a\u00020\u0011H\u0016J\u001f\u0010=\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u00002\u0006\u00104\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010>J\u001e\u0010?\u001a\u00020/2\u0014\u0010@\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0017\u0010A\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00106J1\u0010B\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\u0012\u0004\u0012\u00020'0)H\bø\u0001\u0000¢\u0006\u0002\bCJ\u0017\u0010D\u001a\u00020'2\u0006\u00104\u001a\u00028\u0001H\u0000¢\u0006\u0004\bE\u00102J5\u0010F\u001a\u00020/2*\u0010:\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010G\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010G0)H\bJ9\u0010H\u001a\u0002H9\"\u0004\b\u0002\u001092#\u0010:\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0004\u0012\u0002H90)¢\u0006\u0002\bIH\b¢\u0006\u0002\u0010;J9\u0010J\u001a\u0002H9\"\u0004\b\u0002\u001092#\u0010:\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0004\u0012\u0002H90)¢\u0006\u0002\bIH\b¢\u0006\u0002\u0010;R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078AX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00188@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c8@X\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001aR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010#X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u0002\u0007\n\u0005\b20\u0001¨\u0006L"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "K", "V", "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/Map;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "keys", "getKeys", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "all", "", "predicate", "Lkotlin/Function1;", "", "all$runtime_release", "any", "any$runtime_release", "clear", "", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "mutate", "R", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "prependStateRecord", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "remove", "removeIf", "removeIf$runtime_release", "removeValue", "removeValue$runtime_release", "update", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateMapStateRecord", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SnapshotStateMap<K, V> implements Map<K, V>, StateObject, KMutableMap {
    @NotNull
    private final Set<Map.Entry<K, V>> entries = new SnapshotMapEntrySet(this);
    @NotNull
    private StateRecord firstStateRecord = new StateMapStateRecord(ExtensionsKt.persistentHashMapOf());
    @NotNull
    private final Set<K> keys = new SnapshotMapKeySet(this);
    @NotNull
    private final Collection<V> values = new SnapshotMapValueSet(this);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\b\u0000\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "K", "V", "Landroidx/compose/runtime/snapshots/StateRecord;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "getMap$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setMap$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class StateMapStateRecord<K, V> extends StateRecord {
        @NotNull
        private PersistentMap<K, ? extends V> map;
        private int modification;

        public StateMapStateRecord(@NotNull PersistentMap<K, ? extends V> persistentMap) {
            Intrinsics.checkNotNullParameter(persistentMap, Param.MAP);
            this.map = persistentMap;
        }

        public void assign(@NotNull StateRecord stateRecord) {
            Intrinsics.checkNotNullParameter(stateRecord, "value");
            StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) stateRecord;
            synchronized (SnapshotStateMapKt.sync) {
                this.map = stateMapStateRecord.map;
                this.modification = stateMapStateRecord.modification;
                Unit unit = Unit.INSTANCE;
            }
        }

        @NotNull
        public StateRecord create() {
            return new StateMapStateRecord(this.map);
        }

        @NotNull
        public final PersistentMap<K, V> getMap$runtime_release() {
            return this.map;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setMap$runtime_release(@NotNull PersistentMap<K, ? extends V> persistentMap) {
            Intrinsics.checkNotNullParameter(persistentMap, "<set-?>");
            this.map = persistentMap;
        }

        public final void setModification$runtime_release(int i11) {
            this.modification = i11;
        }
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    private final <R> R mutate(Function1<? super Map<K, V>, ? extends R> function1) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        R invoke;
        Snapshot current;
        boolean z11;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateRecord firstStateRecord2 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                    StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord2);
                    map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                    modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            invoke = function1.invoke(builder);
            PersistentMap build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateRecord firstStateRecord3 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                    StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) firstStateRecord3;
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, current);
                        if (stateMapStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                            stateMapStateRecord3.setMap$runtime_release(build);
                            stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification$runtime_release() + 1);
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

    private final void update(Function1<? super PersistentMap<K, ? extends V>, ? extends PersistentMap<K, ? extends V>> function1) {
        Snapshot current;
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord2);
        PersistentMap persistentMap = (PersistentMap) function1.invoke(stateMapStateRecord.getMap$runtime_release());
        if (persistentMap != stateMapStateRecord.getMap$runtime_release()) {
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateRecord firstStateRecord3 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                    StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) firstStateRecord3;
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, current);
                        stateMapStateRecord3.setMap$runtime_release(persistentMap);
                        stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification$runtime_release() + 1);
                        InlineMarker.finallyStart(1);
                    }
                    InlineMarker.finallyEnd(1);
                    SnapshotKt.notifyWrite(current, this);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th2) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th2;
                }
            }
            InlineMarker.finallyEnd(1);
        }
    }

    private final <R> R withCurrent(Function1<? super StateMapStateRecord<K, V>, ? extends R> function1) {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return function1.invoke(SnapshotKt.current((StateMapStateRecord) firstStateRecord2));
    }

    private final <R> R writable(Function1<? super StateMapStateRecord<K, V>, ? extends R> function1) {
        Snapshot current;
        R invoke;
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) firstStateRecord2;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                invoke = function1.invoke(SnapshotKt.writableRecord(stateMapStateRecord, this, current));
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

    public final boolean all$runtime_release(@NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (Map.Entry invoke : (ImmutableSet) getReadable$runtime_release().getMap$runtime_release().entrySet()) {
            if (!function1.invoke(invoke).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public final boolean any$runtime_release(@NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (Map.Entry invoke : (ImmutableSet) getReadable$runtime_release().getMap$runtime_release().entrySet()) {
            if (function1.invoke(invoke).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        Snapshot current;
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord2);
        stateMapStateRecord.getMap$runtime_release();
        PersistentMap persistentHashMapOf = ExtensionsKt.persistentHashMapOf();
        if (persistentHashMapOf != stateMapStateRecord.getMap$runtime_release()) {
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, current);
                    stateMapStateRecord3.setMap$runtime_release(persistentHashMapOf);
                    stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification$runtime_release() + 1);
                }
                SnapshotKt.notifyWrite(current, this);
            }
        }
    }

    public boolean containsKey(Object obj) {
        return getReadable$runtime_release().getMap$runtime_release().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return getReadable$runtime_release().getMap$runtime_release().containsValue(obj);
    }

    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Nullable
    public V get(Object obj) {
        return getReadable$runtime_release().getMap$runtime_release().get(obj);
    }

    @NotNull
    @JvmName(name = "getDebuggerDisplayValue")
    public final Map<K, V> getDebuggerDisplayValue() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return ((StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord2)).getMap$runtime_release();
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        return this.entries;
    }

    @NotNull
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    @NotNull
    public Set<K> getKeys() {
        return this.keys;
    }

    public final int getModification$runtime_release() {
        return getReadable$runtime_release().getModification$runtime_release();
    }

    @NotNull
    public final StateMapStateRecord<K, V> getReadable$runtime_release() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return (StateMapStateRecord) SnapshotKt.readable((StateMapStateRecord) firstStateRecord2, this);
    }

    public int getSize() {
        return getReadable$runtime_release().getMap$runtime_release().size();
    }

    @NotNull
    public Collection<V> getValues() {
        return this.values;
    }

    public boolean isEmpty() {
        return getReadable$runtime_release().getMap$runtime_release().isEmpty();
    }

    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return a.a(this, stateRecord, stateRecord2, stateRecord3);
    }

    public void prependStateRecord(@NotNull StateRecord stateRecord) {
        Intrinsics.checkNotNullParameter(stateRecord, "value");
        this.firstStateRecord = (StateMapStateRecord) stateRecord;
    }

    @Nullable
    public V put(K k11, V v11) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        V put;
        Snapshot current;
        boolean z11;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord2);
                map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            put = builder.put(k11, v11);
            PersistentMap build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, current);
                    if (stateMapStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateMapStateRecord3.setMap$runtime_release(build);
                        z11 = true;
                        stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z11 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z11);
        return put;
    }

    public void putAll(@NotNull Map<? extends K, ? extends V> map) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        Snapshot current;
        boolean z11;
        Intrinsics.checkNotNullParameter(map, "from");
        do {
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord2);
                map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            builder.putAll(map);
            PersistentMap build = builder.build();
            if (!Intrinsics.areEqual((Object) build, (Object) map$runtime_release)) {
                synchronized (SnapshotStateMapKt.sync) {
                    StateRecord firstStateRecord3 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                    StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) firstStateRecord3;
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, current);
                        if (stateMapStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                            stateMapStateRecord3.setMap$runtime_release(build);
                            z11 = true;
                            stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification$runtime_release() + 1);
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

    @Nullable
    public V remove(Object obj) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        V remove;
        Snapshot current;
        boolean z11;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord2);
                map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            remove = builder.remove(obj);
            PersistentMap build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, current);
                    if (stateMapStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                        stateMapStateRecord3.setMap$runtime_release(build);
                        z11 = true;
                        stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification$runtime_release() + 1);
                    } else {
                        z11 = false;
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            }
        } while (!z11);
        return remove;
    }

    public final boolean removeIf$runtime_release(@NotNull Function1<? super Map.Entry<K, V>, Boolean> function1) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        Snapshot current;
        boolean z11;
        Intrinsics.checkNotNullParameter(function1, "predicate");
        boolean z12 = false;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateRecord firstStateRecord2 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                    StateMapStateRecord stateMapStateRecord = (StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord2);
                    map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                    modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            for (Map.Entry entry : entrySet()) {
                if (function1.invoke(entry).booleanValue()) {
                    builder.remove(entry.getKey());
                    z12 = true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            PersistentMap build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) map$runtime_release)) {
                break;
            }
            synchronized (SnapshotStateMapKt.sync) {
                try {
                    StateRecord firstStateRecord3 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                    StateMapStateRecord stateMapStateRecord2 = (StateMapStateRecord) firstStateRecord3;
                    SnapshotKt.getSnapshotInitializer();
                    synchronized (SnapshotKt.getLock()) {
                        current = Snapshot.Companion.getCurrent();
                        StateMapStateRecord stateMapStateRecord3 = (StateMapStateRecord) SnapshotKt.writableRecord(stateMapStateRecord2, this, current);
                        if (stateMapStateRecord3.getModification$runtime_release() == modification$runtime_release) {
                            stateMapStateRecord3.setMap$runtime_release(build);
                            stateMapStateRecord3.setModification$runtime_release(stateMapStateRecord3.getModification$runtime_release() + 1);
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
        return z12;
    }

    public final boolean removeValue$runtime_release(V v11) {
        Object obj;
        Iterator it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Map.Entry) obj).getValue(), (Object) v11)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return false;
        }
        remove(entry.getKey());
        return true;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<V> values() {
        return getValues();
    }
}
