package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import com.instabug.commons.snapshot.StateSnapshotCaptor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y.a;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001+B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!J:\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020%2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\b\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010*\u001a\u00020'H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00018\u00008G¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000b¨\u0006,"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "dependencies", "", "", "getDependencies", "()[Ljava/lang/Object;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "value", "getValue", "current", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "currentRecord", "readable", "forceDependencyReads", "", "displayValue", "", "prependStateRecord", "", "toString", "ResultRecord", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class DerivedSnapshotState<T> implements StateObject, DerivedState<T> {
    @NotNull
    private final Function0<T> calculation;
    @NotNull
    private ResultRecord<T> first = new ResultRecord<>();
    @Nullable
    private final SnapshotMutationPolicy<T> policy;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \"*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0001\"B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020 J\u001a\u0010!\u001a\u00020\u00072\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020 R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "()V", "dependencies", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "", "getDependencies", "()Landroidx/compose/runtime/collection/IdentityArrayMap;", "setDependencies", "(Landroidx/compose/runtime/collection/IdentityArrayMap;)V", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "resultHash", "getResultHash", "()I", "setResultHash", "(I)V", "assign", "", "value", "create", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "Companion", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ResultRecord<T> extends StateRecord {
        public static final int $stable = 8;
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        @NotNull
        public static final Object Unset = new Object();
        @Nullable
        private IdentityArrayMap<StateObject, Integer> dependencies;
        @Nullable
        private Object result = Unset;
        private int resultHash;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", "", "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        public void assign(@NotNull StateRecord stateRecord) {
            Intrinsics.checkNotNullParameter(stateRecord, "value");
            ResultRecord resultRecord = (ResultRecord) stateRecord;
            this.dependencies = resultRecord.dependencies;
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        @NotNull
        public StateRecord create() {
            return new ResultRecord();
        }

        @Nullable
        public final IdentityArrayMap<StateObject, Integer> getDependencies() {
            return this.dependencies;
        }

        @Nullable
        public final Object getResult() {
            return this.result;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final boolean isValid(@NotNull DerivedState<?> derivedState, @NotNull Snapshot snapshot) {
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
            if (this.result == Unset || this.resultHash != readableHash(derivedState, snapshot)) {
                return false;
            }
            return true;
        }

        public final int readableHash(@NotNull DerivedState<?> derivedState, @NotNull Snapshot snapshot) {
            IdentityArrayMap<StateObject, Integer> identityArrayMap;
            StateRecord stateRecord;
            Intrinsics.checkNotNullParameter(derivedState, "derivedState");
            Intrinsics.checkNotNullParameter(snapshot, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
            synchronized (SnapshotKt.getLock()) {
                identityArrayMap = this.dependencies;
            }
            int i11 = 7;
            if (identityArrayMap != null) {
                MutableVector mutableVector = (MutableVector) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
                int i12 = 0;
                if (mutableVector == null) {
                    mutableVector = new MutableVector(new Pair[0], 0);
                }
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    int i13 = 0;
                    do {
                        ((Function1) ((Pair) content[i13]).component1()).invoke(derivedState);
                        i13++;
                    } while (i13 < size);
                }
                try {
                    int size$runtime_release = identityArrayMap.getSize$runtime_release();
                    for (int i14 = 0; i14 < size$runtime_release; i14++) {
                        Object obj = identityArrayMap.getKeys$runtime_release()[i14];
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                        StateObject stateObject = (StateObject) obj;
                        if (((Number) identityArrayMap.getValues$runtime_release()[i14]).intValue() == 1) {
                            if (stateObject instanceof DerivedSnapshotState) {
                                stateRecord = ((DerivedSnapshotState) stateObject).current(snapshot);
                            } else {
                                stateRecord = SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot);
                            }
                            i11 = (((i11 * 31) + ActualJvm_jvmKt.identityHashCode(stateRecord)) * 31) + stateRecord.getSnapshotId$runtime_release();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    int size2 = mutableVector.getSize();
                    if (size2 > 0) {
                        Object[] content2 = mutableVector.getContent();
                        Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            ((Function1) ((Pair) content2[i12]).component2()).invoke(derivedState);
                            i12++;
                        } while (i12 < size2);
                    }
                } catch (Throwable th2) {
                    int size3 = mutableVector.getSize();
                    if (size3 > 0) {
                        Object[] content3 = mutableVector.getContent();
                        Intrinsics.checkNotNull(content3, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            ((Function1) ((Pair) content3[i12]).component2()).invoke(derivedState);
                            i12++;
                        } while (i12 < size3);
                    }
                    throw th2;
                }
            }
            return i11;
        }

        public final void setDependencies(@Nullable IdentityArrayMap<StateObject, Integer> identityArrayMap) {
            this.dependencies = identityArrayMap;
        }

        public final void setResult(@Nullable Object obj) {
            this.result = obj;
        }

        public final void setResultHash(int i11) {
            this.resultHash = i11;
        }
    }

    public DerivedSnapshotState(@NotNull Function0<? extends T> function0, @Nullable SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        Intrinsics.checkNotNullParameter(function0, "calculation");
        this.calculation = function0;
        this.policy = snapshotMutationPolicy;
    }

    private final ResultRecord<T> currentRecord(ResultRecord<T> resultRecord, Snapshot snapshot, boolean z11, Function0<? extends T> function0) {
        int i11;
        Snapshot.Companion companion;
        int i12;
        boolean z12 = true;
        int i13 = 0;
        if (resultRecord.isValid(this, snapshot)) {
            if (z11) {
                MutableVector mutableVector = (MutableVector) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
                if (mutableVector == null) {
                    mutableVector = new MutableVector(new Pair[0], 0);
                }
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    int i14 = 0;
                    do {
                        ((Function1) ((Pair) content[i14]).component1()).invoke(this);
                        i14++;
                    } while (i14 < size);
                }
                try {
                    IdentityArrayMap<StateObject, Integer> dependencies = resultRecord.getDependencies();
                    Integer num = (Integer) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
                    if (num != null) {
                        i12 = num.intValue();
                    } else {
                        i12 = 0;
                    }
                    if (dependencies != null) {
                        int size$runtime_release = dependencies.getSize$runtime_release();
                        for (int i15 = 0; i15 < size$runtime_release; i15++) {
                            Object obj = dependencies.getKeys$runtime_release()[i15];
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                            StateObject stateObject = (StateObject) obj;
                            SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(Integer.valueOf(((Number) dependencies.getValues$runtime_release()[i15]).intValue() + i12));
                            Function1<Object, Unit> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
                            if (readObserver$runtime_release != null) {
                                readObserver$runtime_release.invoke(stateObject);
                            }
                        }
                    }
                    SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(Integer.valueOf(i12));
                    Unit unit = Unit.INSTANCE;
                    int size2 = mutableVector.getSize();
                    if (size2 > 0) {
                        Object[] content2 = mutableVector.getContent();
                        Intrinsics.checkNotNull(content2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            ((Function1) ((Pair) content2[i13]).component2()).invoke(this);
                            i13++;
                        } while (i13 < size2);
                    }
                } catch (Throwable th2) {
                    int size3 = mutableVector.getSize();
                    if (size3 > 0) {
                        Object[] content3 = mutableVector.getContent();
                        Intrinsics.checkNotNull(content3, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                        do {
                            ((Function1) ((Pair) content3[i13]).component2()).invoke(this);
                            i13++;
                        } while (i13 < size3);
                    }
                    throw th2;
                }
            }
            return resultRecord;
        }
        Integer num2 = (Integer) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
        if (num2 != null) {
            i11 = num2.intValue();
        } else {
            i11 = 0;
        }
        IdentityArrayMap identityArrayMap = new IdentityArrayMap(0, 1, (DefaultConstructorMarker) null);
        MutableVector mutableVector2 = (MutableVector) SnapshotStateKt__DerivedStateKt.derivedStateObservers.get();
        if (mutableVector2 == null) {
            mutableVector2 = new MutableVector(new Pair[0], 0);
        }
        int size4 = mutableVector2.getSize();
        if (size4 > 0) {
            Object[] content4 = mutableVector2.getContent();
            Intrinsics.checkNotNull(content4, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i16 = 0;
            do {
                ((Function1) ((Pair) content4[i16]).component1()).invoke(this);
                i16++;
            } while (i16 < size4);
        }
        try {
            SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(Integer.valueOf(i11 + 1));
            Object observe = Snapshot.Companion.observe(new DerivedSnapshotState$currentRecord$result$1$result$1(this, identityArrayMap, i11), (Function1<Object, Unit>) null, function0);
            SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(Integer.valueOf(i11));
            int size5 = mutableVector2.getSize();
            if (size5 > 0) {
                Object[] content5 = mutableVector2.getContent();
                Intrinsics.checkNotNull(content5, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                int i17 = 0;
                do {
                    ((Function1) ((Pair) content5[i17]).component2()).invoke(this);
                    i17++;
                } while (i17 < size5);
            }
            synchronized (SnapshotKt.getLock()) {
                companion = Snapshot.Companion;
                Snapshot current = companion.getCurrent();
                if (resultRecord.getResult() != ResultRecord.Companion.getUnset()) {
                    SnapshotMutationPolicy policy2 = getPolicy();
                    if (policy2 == null || !policy2.equivalent(observe, resultRecord.getResult())) {
                        z12 = false;
                    }
                    if (z12) {
                        resultRecord.setDependencies(identityArrayMap);
                        resultRecord.setResultHash(resultRecord.readableHash(this, current));
                    }
                }
                resultRecord = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, current);
                resultRecord.setDependencies(identityArrayMap);
                resultRecord.setResultHash(resultRecord.readableHash(this, current));
                resultRecord.setResult(observe);
            }
            if (i11 == 0) {
                companion.notifyObjectsInitialized();
            }
            return resultRecord;
        } catch (Throwable th3) {
            int size6 = mutableVector2.getSize();
            if (size6 > 0) {
                Object[] content6 = mutableVector2.getContent();
                Intrinsics.checkNotNull(content6, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                do {
                    ((Function1) ((Pair) content6[i13]).component2()).invoke(this);
                    i13++;
                } while (i13 < size6);
            }
            throw th3;
        }
    }

    private final String displayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.Companion.getCurrent())) {
            return String.valueOf(resultRecord.getResult());
        }
        return "<Not calculated>";
    }

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    @NotNull
    public final StateRecord current(@NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    public T getCurrentValue() {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.Companion.getCurrent(), false, this.calculation).getResult();
    }

    @Nullable
    @JvmName(name = "getDebuggerDisplayValue")
    public final T getDebuggerDisplayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.Companion.getCurrent())) {
            return resultRecord.getResult();
        }
        return null;
    }

    @NotNull
    public Object[] getDependencies() {
        Object[] keys$runtime_release;
        IdentityArrayMap<StateObject, Integer> dependencies = currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.Companion.getCurrent(), false, this.calculation).getDependencies();
        if (dependencies == null || (keys$runtime_release = dependencies.getKeys$runtime_release()) == null) {
            return new Object[0];
        }
        return keys$runtime_release;
    }

    @NotNull
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Nullable
    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    public T getValue() {
        Snapshot.Companion companion = Snapshot.Companion;
        Function1<Object, Unit> readObserver$runtime_release = companion.getCurrent().getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(this);
        }
        return currentRecord((ResultRecord) SnapshotKt.current(this.first), companion.getCurrent(), true, this.calculation).getResult();
    }

    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return a.a(this, stateRecord, stateRecord2, stateRecord3);
    }

    public void prependStateRecord(@NotNull StateRecord stateRecord) {
        Intrinsics.checkNotNullParameter(stateRecord, "value");
        this.first = (ResultRecord) stateRecord;
    }

    @NotNull
    public String toString() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }
}
