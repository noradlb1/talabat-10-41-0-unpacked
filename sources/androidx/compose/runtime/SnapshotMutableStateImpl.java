package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001$B\u001b\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\fJ\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\"\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eH\u0016J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u000eH\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u0017\u0010\b\u001a\u00028\u00008G¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u00008V@VX\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Landroidx/compose/runtime/SnapshotMutableStateImpl;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "()Ljava/lang/Object;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "next", "Landroidx/compose/runtime/SnapshotMutableStateImpl$StateStateRecord;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "getValue$annotations", "getValue", "setValue", "(Ljava/lang/Object;)V", "component1", "component2", "Lkotlin/Function1;", "", "mergeRecords", "previous", "current", "applied", "prependStateRecord", "toString", "", "StateStateRecord", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class SnapshotMutableStateImpl<T> implements StateObject, SnapshotMutableState<T> {
    @NotNull
    private StateStateRecord<T> next;
    @NotNull
    private final SnapshotMutationPolicy<T> policy;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u001c\u0010\u0005\u001a\u00028\u0001X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/SnapshotMutableStateImpl$StateStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "myValue", "(Ljava/lang/Object;)V", "value", "getValue", "()Ljava/lang/Object;", "setValue", "Ljava/lang/Object;", "assign", "", "create", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class StateStateRecord<T> extends StateRecord {
        private T value;

        public StateStateRecord(T t11) {
            this.value = t11;
        }

        public void assign(@NotNull StateRecord stateRecord) {
            Intrinsics.checkNotNullParameter(stateRecord, "value");
            this.value = ((StateStateRecord) stateRecord).value;
        }

        @NotNull
        public StateRecord create() {
            return new StateStateRecord(this.value);
        }

        public final T getValue() {
            return this.value;
        }

        public final void setValue(T t11) {
            this.value = t11;
        }
    }

    public SnapshotMutableStateImpl(T t11, @NotNull SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        Intrinsics.checkNotNullParameter(snapshotMutationPolicy, "policy");
        this.policy = snapshotMutationPolicy;
        this.next = new StateStateRecord<>(t11);
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public T component1() {
        return getValue();
    }

    @NotNull
    public Function1<T, Unit> component2() {
        return new SnapshotMutableStateImpl$component2$1(this);
    }

    @JvmName(name = "getDebuggerDisplayValue")
    public final T getDebuggerDisplayValue() {
        return ((StateStateRecord) SnapshotKt.current(this.next)).getValue();
    }

    @NotNull
    public StateRecord getFirstStateRecord() {
        return this.next;
    }

    @NotNull
    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    public T getValue() {
        return ((StateStateRecord) SnapshotKt.readable(this.next, this)).getValue();
    }

    @Nullable
    public StateRecord mergeRecords(@NotNull StateRecord stateRecord, @NotNull StateRecord stateRecord2, @NotNull StateRecord stateRecord3) {
        Intrinsics.checkNotNullParameter(stateRecord, "previous");
        Intrinsics.checkNotNullParameter(stateRecord2, "current");
        Intrinsics.checkNotNullParameter(stateRecord3, "applied");
        StateStateRecord stateStateRecord = (StateStateRecord) stateRecord;
        StateStateRecord stateStateRecord2 = (StateStateRecord) stateRecord2;
        StateStateRecord stateStateRecord3 = (StateStateRecord) stateRecord3;
        if (getPolicy().equivalent(stateStateRecord2.getValue(), stateStateRecord3.getValue())) {
            return stateRecord2;
        }
        Object merge = getPolicy().merge(stateStateRecord.getValue(), stateStateRecord2.getValue(), stateStateRecord3.getValue());
        if (merge == null) {
            return null;
        }
        StateRecord create = stateStateRecord3.create();
        Intrinsics.checkNotNull(create, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl.mergeRecords$lambda-2>");
        ((StateStateRecord) create).setValue(merge);
        return create;
    }

    public void prependStateRecord(@NotNull StateRecord stateRecord) {
        Intrinsics.checkNotNullParameter(stateRecord, "value");
        this.next = (StateStateRecord) stateRecord;
    }

    public void setValue(T t11) {
        Snapshot current;
        StateStateRecord stateStateRecord = (StateStateRecord) SnapshotKt.current(this.next);
        if (!getPolicy().equivalent(stateStateRecord.getValue(), t11)) {
            StateStateRecord<T> stateStateRecord2 = this.next;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                ((StateStateRecord) SnapshotKt.overwritableRecord(stateStateRecord2, this, current, stateStateRecord)).setValue(t11);
                Unit unit = Unit.INSTANCE;
            }
            SnapshotKt.notifyWrite(current, this);
        }
    }

    @NotNull
    public String toString() {
        return "MutableState(value=" + ((StateStateRecord) SnapshotKt.current(this.next)).getValue() + ")@" + hashCode();
    }
}
