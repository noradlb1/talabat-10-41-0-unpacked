package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.IdentityArrayIntMap;
import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import com.instabug.commons.snapshot.StateSnapshotCaptor;
import java.util.HashMap;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001:\u0001)B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0001J)\u0010\u0019\u001a\u00020\u00052!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00130\u0003J&\u0010\u001b\u001a\u00020\u0011\"\b\b\u0000\u0010\u001c*\u00020\u00012\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001d\u0010\u001e\u001a\u00020\u00052\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0003H\bJ\u001c\u0010 \u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\"\u001a\u00020\rJ?\u0010#\u001a\u00020\u0005\"\b\b\u0000\u0010\u001c*\u00020\u00012\u0006\u0010\u0018\u001a\u0002H\u001c2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010%J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\u0005J\u0016\u0010(\u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R&\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015X\u0004¢\u0006\u0002\n\u0000R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "isPaused", "", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "readObserver", "clear", "scope", "clearIf", "predicate", "ensureMap", "T", "onChanged", "forEachScopeMap", "block", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "start", "stop", "withNoObservations", "ObservedScopeMap", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    @NotNull
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new SnapshotStateObserver$applyObserver$1(this);
    @Nullable
    private ObserverHandle applyUnsubscribe;
    /* access modifiers changed from: private */
    @Nullable
    public ObservedScopeMap currentMap;
    /* access modifiers changed from: private */
    public boolean isPaused;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<Function0<Unit>, Unit> onChangedExecutor;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<Object, Unit> readObserver = new SnapshotStateObserver$readObserver$1(this);

    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001e\u001a\u00020\u0004J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0001H\u0002J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0001J\u0006\u0010\"\u001a\u00020\u0004J\"\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040%H\bø\u0001\u0000J\u0014\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010)J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0001J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0001H\u0002J)\u0010-\u001a\u00020\u00042!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b( \u0012\u0004\u0012\u00020'0\u0003R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R!\u0010\u000f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0013\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R6\u0010\u0018\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u001aX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\fX\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u00061"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "currentScopeReads", "Landroidx/compose/runtime/collection/IdentityArrayIntMap;", "currentToken", "", "dependencyToDerivedStates", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "Landroidx/compose/runtime/DerivedState;", "deriveStateScopeCount", "derivedStateEnterObserver", "Landroidx/compose/runtime/State;", "getDerivedStateEnterObserver", "()Lkotlin/jvm/functions/Function1;", "derivedStateExitObserver", "getDerivedStateExitObserver", "invalidated", "Landroidx/compose/runtime/collection/IdentityArraySet;", "getOnChanged", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scopeToValues", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "valueToScopes", "clear", "clearObsoleteStateReads", "scope", "clearScopeObservations", "notifyInvalidatedScopes", "observe", "block", "Lkotlin/Function0;", "recordInvalidation", "", "changes", "", "recordRead", "value", "removeObservation", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", "name", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ObservedScopeMap {
        /* access modifiers changed from: private */
        @Nullable
        public Object currentScope;
        /* access modifiers changed from: private */
        @Nullable
        public IdentityArrayIntMap currentScopeReads;
        /* access modifiers changed from: private */
        public int currentToken = -1;
        @NotNull
        private final IdentityScopeMap<DerivedState<?>> dependencyToDerivedStates = new IdentityScopeMap<>();
        /* access modifiers changed from: private */
        public int deriveStateScopeCount;
        @NotNull
        private final Function1<State<?>, Unit> derivedStateEnterObserver = new SnapshotStateObserver$ObservedScopeMap$derivedStateEnterObserver$1(this);
        @NotNull
        private final Function1<State<?>, Unit> derivedStateExitObserver = new SnapshotStateObserver$ObservedScopeMap$derivedStateExitObserver$1(this);
        @NotNull
        private final IdentityArraySet<Object> invalidated = new IdentityArraySet<>();
        @NotNull
        private final Function1<Object, Unit> onChanged;
        @NotNull
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues = new HashMap<>();
        /* access modifiers changed from: private */
        @NotNull
        public final IdentityArrayMap<Object, IdentityArrayIntMap> scopeToValues = new IdentityArrayMap<>(0, 1, (DefaultConstructorMarker) null);
        @NotNull
        private final IdentityScopeMap<Object> valueToScopes = new IdentityScopeMap<>();

        public ObservedScopeMap(@NotNull Function1<Object, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onChanged");
            this.onChanged = function1;
        }

        /* access modifiers changed from: private */
        public final void clearObsoleteStateReads(Object obj) {
            boolean z11;
            IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
            if (identityArrayIntMap != null) {
                int size = identityArrayIntMap.getSize();
                int i11 = 0;
                for (int i12 = 0; i12 < size; i12++) {
                    Object obj2 = identityArrayIntMap.getKeys()[i12];
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Any");
                    int i13 = identityArrayIntMap.getValues()[i12];
                    if (i13 != this.currentToken) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        removeObservation(obj, obj2);
                    }
                    if (!z11) {
                        if (i11 != i12) {
                            identityArrayIntMap.getKeys()[i11] = obj2;
                            identityArrayIntMap.getValues()[i11] = i13;
                        }
                        i11++;
                    }
                }
                int size2 = identityArrayIntMap.getSize();
                for (int i14 = i11; i14 < size2; i14++) {
                    identityArrayIntMap.getKeys()[i14] = null;
                }
                identityArrayIntMap.setSize(i11);
            }
        }

        private final void removeObservation(Object obj, Object obj2) {
            this.valueToScopes.remove(obj2, obj);
            if ((obj2 instanceof DerivedState) && !this.valueToScopes.contains(obj2)) {
                this.dependencyToDerivedStates.removeScope(obj2);
                this.recordedDerivedStateValues.remove(obj2);
            }
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        public final void clearScopeObservations(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "scope");
            IdentityArrayIntMap identityArrayIntMap = this.scopeToValues.get(obj);
            if (identityArrayIntMap != null) {
                int size = identityArrayIntMap.getSize();
                for (int i11 = 0; i11 < size; i11++) {
                    Object obj2 = identityArrayIntMap.getKeys()[i11];
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Any");
                    int i12 = identityArrayIntMap.getValues()[i11];
                    removeObservation(obj, obj2);
                }
            }
        }

        @NotNull
        public final Function1<State<?>, Unit> getDerivedStateEnterObserver() {
            return this.derivedStateEnterObserver;
        }

        @NotNull
        public final Function1<State<?>, Unit> getDerivedStateExitObserver() {
            return this.derivedStateExitObserver;
        }

        @NotNull
        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final void notifyInvalidatedScopes() {
            IdentityArraySet<Object> identityArraySet = this.invalidated;
            Function1<Object, Unit> function1 = this.onChanged;
            int size = identityArraySet.size();
            for (int i11 = 0; i11 < size; i11++) {
                function1.invoke(identityArraySet.get(i11));
            }
            this.invalidated.clear();
        }

        public final void observe(@NotNull Object obj, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(obj, "scope");
            Intrinsics.checkNotNullParameter(function0, "block");
            Object access$getCurrentScope$p = this.currentScope;
            IdentityArrayIntMap access$getCurrentScopeReads$p = this.currentScopeReads;
            int access$getCurrentToken$p = this.currentToken;
            this.currentScope = obj;
            this.currentScopeReads = (IdentityArrayIntMap) this.scopeToValues.get(obj);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            function0.invoke();
            Object access$getCurrentScope$p2 = this.currentScope;
            Intrinsics.checkNotNull(access$getCurrentScope$p2);
            clearObsoleteStateReads(access$getCurrentScope$p2);
            this.currentScope = access$getCurrentScope$p;
            this.currentScopeReads = access$getCurrentScopeReads$p;
            this.currentToken = access$getCurrentToken$p;
        }

        public final boolean recordInvalidation(@NotNull Set<? extends Object> set) {
            IdentityScopeMap<DerivedState<?>> identityScopeMap;
            int access$find;
            IdentityScopeMap<Object> identityScopeMap2;
            int access$find2;
            Intrinsics.checkNotNullParameter(set, "changes");
            boolean z11 = false;
            for (Object next : set) {
                if (this.dependencyToDerivedStates.contains(next) && (access$find = identityScopeMap.find(next)) >= 0) {
                    IdentityArraySet access$scopeSetAt = (identityScopeMap = this.dependencyToDerivedStates).scopeSetAt(access$find);
                    int size = access$scopeSetAt.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        DerivedState derivedState = (DerivedState) access$scopeSetAt.get(i11);
                        Intrinsics.checkNotNull(derivedState, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
                        Object obj = this.recordedDerivedStateValues.get(derivedState);
                        SnapshotMutationPolicy policy = derivedState.getPolicy();
                        if (policy == null) {
                            policy = SnapshotStateKt.structuralEqualityPolicy();
                        }
                        if (!policy.equivalent(derivedState.getCurrentValue(), obj) && (access$find2 = identityScopeMap2.find(derivedState)) >= 0) {
                            IdentityArraySet access$scopeSetAt2 = (identityScopeMap2 = this.valueToScopes).scopeSetAt(access$find2);
                            int size2 = access$scopeSetAt2.size();
                            int i12 = 0;
                            while (i12 < size2) {
                                this.invalidated.add(access$scopeSetAt2.get(i12));
                                i12++;
                                z11 = true;
                            }
                        }
                    }
                }
                IdentityScopeMap<Object> identityScopeMap3 = this.valueToScopes;
                int access$find3 = identityScopeMap3.find(next);
                if (access$find3 >= 0) {
                    IdentityArraySet access$scopeSetAt3 = identityScopeMap3.scopeSetAt(access$find3);
                    int size3 = access$scopeSetAt3.size();
                    int i13 = 0;
                    while (i13 < size3) {
                        this.invalidated.add(access$scopeSetAt3.get(i13));
                        i13++;
                        z11 = true;
                    }
                }
            }
            return z11;
        }

        public final void recordRead(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "value");
            if (this.deriveStateScopeCount <= 0) {
                Object obj2 = this.currentScope;
                Intrinsics.checkNotNull(obj2);
                IdentityArrayIntMap identityArrayIntMap = this.currentScopeReads;
                if (identityArrayIntMap == null) {
                    identityArrayIntMap = new IdentityArrayIntMap();
                    this.currentScopeReads = identityArrayIntMap;
                    this.scopeToValues.set(obj2, identityArrayIntMap);
                }
                int add = identityArrayIntMap.add(obj, this.currentToken);
                if ((obj instanceof DerivedState) && add != this.currentToken) {
                    DerivedState derivedState = (DerivedState) obj;
                    for (Object obj3 : derivedState.getDependencies()) {
                        if (obj3 == null) {
                            break;
                        }
                        this.dependencyToDerivedStates.add(obj3, obj);
                    }
                    this.recordedDerivedStateValues.put(obj, derivedState.getCurrentValue());
                }
                if (add == -1) {
                    this.valueToScopes.add(obj, obj2);
                }
            }
        }

        public final void removeScopeIf(@NotNull Function1<Object, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            IdentityArrayMap<Object, IdentityArrayIntMap> identityArrayMap = this.scopeToValues;
            int size$runtime_release = identityArrayMap.getSize$runtime_release();
            int i11 = 0;
            for (int i12 = 0; i12 < size$runtime_release; i12++) {
                Object obj = identityArrayMap.getKeys$runtime_release()[i12];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
                IdentityArrayIntMap identityArrayIntMap = (IdentityArrayIntMap) identityArrayMap.getValues$runtime_release()[i12];
                Boolean invoke = function1.invoke(obj);
                if (invoke.booleanValue()) {
                    int size = identityArrayIntMap.getSize();
                    for (int i13 = 0; i13 < size; i13++) {
                        Object obj2 = identityArrayIntMap.getKeys()[i13];
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Any");
                        int i14 = identityArrayIntMap.getValues()[i13];
                        removeObservation(obj, obj2);
                    }
                }
                if (!invoke.booleanValue()) {
                    if (i11 != i12) {
                        identityArrayMap.getKeys$runtime_release()[i11] = obj;
                        identityArrayMap.getValues$runtime_release()[i11] = identityArrayMap.getValues$runtime_release()[i12];
                    }
                    i11++;
                }
            }
            if (identityArrayMap.getSize$runtime_release() > i11) {
                int size$runtime_release2 = identityArrayMap.getSize$runtime_release();
                for (int i15 = i11; i15 < size$runtime_release2; i15++) {
                    identityArrayMap.getKeys$runtime_release()[i15] = null;
                    identityArrayMap.getValues$runtime_release()[i15] = null;
                }
                identityArrayMap.setSize$runtime_release(i11);
            }
        }
    }

    public SnapshotStateObserver(@NotNull Function1<? super Function0<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onChangedExecutor");
        this.onChangedExecutor = function1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap ensureMap(kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r8) {
        /*
            r7 = this;
            androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap> r0 = r7.observedScopeMaps
            int r1 = r0.getSize()
            r2 = 1
            if (r1 <= 0) goto L_0x0029
            java.lang.Object[] r0 = r0.getContent()
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r3)
            r3 = 0
            r4 = r3
        L_0x0014:
            r5 = r0[r4]
            r6 = r5
            androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap r6 = (androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap) r6
            kotlin.jvm.functions.Function1 r6 = r6.getOnChanged()
            if (r6 != r8) goto L_0x0021
            r6 = r2
            goto L_0x0022
        L_0x0021:
            r6 = r3
        L_0x0022:
            if (r6 == 0) goto L_0x0025
            goto L_0x002a
        L_0x0025:
            int r4 = r4 + 1
            if (r4 < r1) goto L_0x0014
        L_0x0029:
            r5 = 0
        L_0x002a:
            androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap r5 = (androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap) r5
            if (r5 != 0) goto L_0x0044
            androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap r0 = new androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r1)
            java.lang.Object r8 = kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(r8, r2)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r0.<init>(r8)
            androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap> r8 = r7.observedScopeMaps
            r8.add(r0)
            return r0
        L_0x0044:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ensureMap(kotlin.jvm.functions.Function1):androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap");
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> function1) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector access$getObservedScopeMaps$p = this.observedScopeMaps;
                int size = access$getObservedScopeMaps$p.getSize();
                if (size > 0) {
                    Object[] content = access$getObservedScopeMaps$p.getContent();
                    Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    int i11 = 0;
                    do {
                        function1.invoke(content[i11]);
                        i11++;
                    } while (i11 < size);
                }
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
        InlineMarker.finallyEnd(1);
    }

    public final void clear(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "scope");
        synchronized (this.observedScopeMaps) {
            MutableVector access$getObservedScopeMaps$p = this.observedScopeMaps;
            int size = access$getObservedScopeMaps$p.getSize();
            if (size > 0) {
                Object[] content = access$getObservedScopeMaps$p.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                int i11 = 0;
                do {
                    ((ObservedScopeMap) content[i11]).clearScopeObservations(obj);
                    i11++;
                } while (i11 < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(@NotNull Function1<Object, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        synchronized (this.observedScopeMaps) {
            MutableVector access$getObservedScopeMaps$p = this.observedScopeMaps;
            int size = access$getObservedScopeMaps$p.getSize();
            if (size > 0) {
                Object[] content = access$getObservedScopeMaps$p.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                int i11 = 0;
                do {
                    ((ObservedScopeMap) content[i11]).removeScopeIf(function1);
                    i11++;
                } while (i11 < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void notifyChanges(@NotNull Set<? extends Object> set, @NotNull Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(set, "changes");
        Intrinsics.checkNotNullParameter(snapshot, StateSnapshotCaptor.STATE_SNAPSHOT_FILE_NAME);
        this.applyObserver.invoke(set, snapshot);
    }

    public final <T> void observeReads(@NotNull T t11, @NotNull Function1<? super T, Unit> function1, @NotNull Function0<Unit> function0) {
        ObservedScopeMap ensureMap;
        Intrinsics.checkNotNullParameter(t11, "scope");
        Intrinsics.checkNotNullParameter(function1, "onValueChangedForScope");
        Intrinsics.checkNotNullParameter(function0, "block");
        synchronized (this.observedScopeMaps) {
            ensureMap = ensureMap(function1);
        }
        boolean z11 = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        try {
            this.isPaused = false;
            this.currentMap = ensureMap;
            Object access$getCurrentScope$p = ensureMap.currentScope;
            IdentityArrayIntMap access$getCurrentScopeReads$p = ensureMap.currentScopeReads;
            int access$getCurrentToken$p = ensureMap.currentToken;
            ensureMap.currentScope = t11;
            ensureMap.currentScopeReads = (IdentityArrayIntMap) ensureMap.scopeToValues.get(t11);
            if (ensureMap.currentToken == -1) {
                ensureMap.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            SnapshotStateKt.observeDerivedStateRecalculations(ensureMap.getDerivedStateEnterObserver(), ensureMap.getDerivedStateExitObserver(), new SnapshotStateObserver$observeReads$1$1(this, function0));
            Object access$getCurrentScope$p2 = ensureMap.currentScope;
            Intrinsics.checkNotNull(access$getCurrentScope$p2);
            ensureMap.clearObsoleteStateReads(access$getCurrentScope$p2);
            ensureMap.currentScope = access$getCurrentScope$p;
            ensureMap.currentScopeReads = access$getCurrentScopeReads$p;
            ensureMap.currentToken = access$getCurrentToken$p;
        } finally {
            this.currentMap = observedScopeMap;
            this.isPaused = z11;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.Companion.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        boolean z11 = this.isPaused;
        this.isPaused = true;
        try {
            function0.invoke();
        } finally {
            this.isPaused = z11;
        }
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            MutableVector access$getObservedScopeMaps$p = this.observedScopeMaps;
            int size = access$getObservedScopeMaps$p.getSize();
            if (size > 0) {
                Object[] content = access$getObservedScopeMaps$p.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                int i11 = 0;
                do {
                    ((ObservedScopeMap) content[i11]).clear();
                    i11++;
                } while (i11 < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
