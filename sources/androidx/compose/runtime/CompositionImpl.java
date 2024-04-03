package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArrayMap;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.collection.IdentityScopeMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010T\u001a\u00020\u001bH\u0002J\u001e\u0010U\u001a\u00020\u001b2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020.0W2\u0006\u0010X\u001a\u00020\u000fH\u0002J\b\u0010Y\u001a\u00020\u001bH\u0016Jc\u0010Z\u001a\u00020\u001b2Y\u0010\u0012\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0014j\u0002`\u001c0\u0013H\u0002J\b\u0010[\u001a\u00020\u001bH\u0016J\b\u0010\\\u001a\u00020\u001bH\u0016J\b\u0010]\u001a\u00020\u001bH\u0002J \u0010^\u001a\u00020\u001b2\u0011\u0010_\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\u0002\b\u001fH\u0016¢\u0006\u0002\u0010#J3\u0010`\u001a\u0002Ha\"\u0004\b\u0000\u0010a2\b\u0010b\u001a\u0004\u0018\u00010\u00012\u0006\u0010c\u001a\u00020:2\f\u0010d\u001a\b\u0012\u0004\u0012\u0002Ha0\u001eH\u0016¢\u0006\u0002\u0010eJ\b\u0010f\u001a\u00020\u001bH\u0016J\u0010\u0010g\u001a\u00020\u001b2\u0006\u0010h\u001a\u00020iH\u0016J\b\u0010j\u001a\u00020\u001bH\u0002J\b\u0010k\u001a\u00020\u001bH\u0002J\"\u0010l\u001a\u0002Hm\"\u0004\b\u0000\u0010m2\f\u0010d\u001a\b\u0012\u0004\u0012\u0002Hm0\u001eH\b¢\u0006\u0002\u0010nJK\u0010o\u001a\u0002Hm\"\u0004\b\u0000\u0010m25\u0010d\u001a1\u0012'\u0012%\u0012\u0004\u0012\u00020)\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010=0<¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002Hm0pH\b¢\u0006\u0002\u0010qJ$\u0010r\u001a\u00020\u001b2\u001a\u0010s\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020u\u0012\u0006\u0012\u0004\u0018\u00010u0t0(H\u0016J\u0018\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020)2\b\u0010y\u001a\u0004\u0018\u00010.J\b\u0010z\u001a\u00020\u001bH\u0016J\"\u0010{\u001a\u00020w2\u0006\u0010x\u001a\u00020)2\u0006\u0010|\u001a\u00020}2\b\u0010y\u001a\u0004\u0018\u00010.H\u0002J\u000e\u0010~\u001a\u00020\u001b2\u0006\u0010\u001a\u00020:J\u0012\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020.H\u0002J\u0017\u0010\u0001\u001a\u00020\u000f2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020.0WH\u0016J\u0017\u0010\u0001\u001a\u00020\u001b2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001eH\u0016J\t\u0010\u0001\u001a\u00020\u000fH\u0016J\u0017\u0010\u0001\u001a\u00020\u001b2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020.0WH\u0016J\u0012\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020.H\u0016J\u0012\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020.H\u0016J\u001b\u0010\u0001\u001a\u00020\u001b2\n\u0010h\u001a\u0006\u0012\u0002\b\u000302H\u0000¢\u0006\u0003\b\u0001J\u001f\u0010\u0001\u001a\u00020\u001b2\u0006\u0010y\u001a\u00020.2\u0006\u0010x\u001a\u00020)H\u0000¢\u0006\u0003\b\u0001J!\u0010\u0001\u001a\u00020\u001b2\u0011\u0010_\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\u0002\b\u001fH\u0016¢\u0006\u0002\u0010#J\u001d\u0010\u0001\u001a\u0016\u0012\u0004\u0012\u00020)\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010=0<H\u0002J#\u0010\u0001\u001a\u0002Hm\"\u0004\b\u0000\u0010m2\f\u0010d\u001a\b\u0012\u0004\u0012\u0002Hm0\u001eH\b¢\u0006\u0002\u0010nJ\u0011\u0010\u0001\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020QH\u0002J\t\u0010\u0001\u001a\u00020\u001bH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011Ra\u0010\u0012\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0014j\u0002`\u001c0\u0013X\u0004¢\u0006\u0002\n\u0000R'\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u001b0\u001e¢\u0006\u0002\b\u001fX\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(8@X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001e\u0010,\u001a\u0012\u0012\u0004\u0012\u00020)0\u000bj\b\u0012\u0004\u0012\u00020)`\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020.0(8@X\u0004¢\u0006\u0006\u001a\u0004\b/\u0010+R\u0018\u00100\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0011R\u0014\u00106\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0011R\u0010\u00108\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\"\u0010;\u001a\u0016\u0012\u0004\u0012\u00020)\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010=0<X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0011R\u0014\u0010?\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0011R\u0011\u0010@\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0011Ra\u0010A\u001aU\u0012Q\u0012O\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0014j\u0002`\u001c0\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020)01X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020)01X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020.0(8@X\u0004¢\u0006\u0006\u001a\u0004\bF\u0010+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0011\"\u0004\bI\u0010JR\"\u0010K\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010.0Lj\n\u0012\u0006\u0012\u0004\u0018\u00010.`MX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020QX\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010S¨\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "parent", "Landroidx/compose/runtime/CompositionContext;", "applier", "Landroidx/compose/runtime/Applier;", "recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "_recomposeContext", "abandonSet", "Ljava/util/HashSet;", "Landroidx/compose/runtime/RememberObserver;", "Lkotlin/collections/HashSet;", "areChildrenComposing", "", "getAreChildrenComposing", "()Z", "changes", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "composable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "conditionalScopes", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getConditionalScopes$runtime_release", "()Ljava/util/List;", "conditionallyInvalidatedScopes", "derivedStateDependencies", "", "getDerivedStateDependencies$runtime_release", "derivedStates", "Landroidx/compose/runtime/collection/IdentityScopeMap;", "Landroidx/compose/runtime/DerivedState;", "disposed", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges", "invalidationDelegate", "invalidationDelegateGroup", "", "invalidations", "Landroidx/compose/runtime/collection/IdentityArrayMap;", "Landroidx/compose/runtime/collection/IdentityArraySet;", "isComposing", "isDisposed", "isRoot", "lateChanges", "lock", "observations", "observationsProcessed", "observedObjects", "getObservedObjects$runtime_release", "pendingInvalidScopes", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "getRecomposeContext", "()Lkotlin/coroutines/CoroutineContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "abandonChanges", "addPendingInvalidationsLocked", "values", "", "forgetConditionalScopes", "applyChanges", "applyChangesInLocked", "applyLateChanges", "changesApplied", "cleanUpDerivedStateObservations", "composeContent", "content", "delegateInvalidations", "R", "to", "groupIndex", "block", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispose", "disposeUnusedMovableContent", "state", "Landroidx/compose/runtime/MovableContentState;", "drainPendingModificationsForCompositionLocked", "drainPendingModificationsLocked", "guardChanges", "T", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "guardInvalidationsLocked", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "insertMovableContent", "references", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "invalidate", "Landroidx/compose/runtime/InvalidationResult;", "scope", "instance", "invalidateAll", "invalidateChecked", "anchor", "Landroidx/compose/runtime/Anchor;", "invalidateGroupsWithKey", "key", "invalidateScopeOfLocked", "value", "observesAnyOf", "prepareCompose", "recompose", "recordModificationsOf", "recordReadOf", "recordWriteOf", "removeDerivedStateObservation", "removeDerivedStateObservation$runtime_release", "removeObservation", "removeObservation$runtime_release", "setContent", "takeInvalidations", "trackAbandonedValues", "validateRecomposeScopeAnchors", "verifyConsistent", "RememberEventDispatcher", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CompositionImpl implements ControlledComposition {
    @Nullable
    private final CoroutineContext _recomposeContext;
    @NotNull
    private final HashSet<RememberObserver> abandonSet;
    @NotNull
    private final Applier<?> applier;
    @NotNull
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> changes;
    @NotNull
    private Function2<? super Composer, ? super Integer, Unit> composable;
    @NotNull
    private final ComposerImpl composer;
    @NotNull
    private final HashSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    @NotNull
    private final IdentityScopeMap<DerivedState<?>> derivedStates;
    private boolean disposed;
    @Nullable
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    @NotNull
    private IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> invalidations;
    private final boolean isRoot;
    @NotNull
    private final List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> lateChanges;
    @NotNull
    private final Object lock;
    @NotNull
    private final IdentityScopeMap<RecomposeScopeImpl> observations;
    @NotNull
    private final IdentityScopeMap<RecomposeScopeImpl> observationsProcessed;
    @NotNull
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    @NotNull
    private final AtomicReference<Object> pendingModifications;
    @NotNull
    private final SlotTable slotTable;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", "", "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "forgetting", "", "remembering", "sideEffects", "Lkotlin/Function0;", "", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "instance", "sideEffect", "effect", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RememberEventDispatcher implements RememberManager {
        @NotNull
        private final Set<RememberObserver> abandoning;
        @NotNull
        private final List<RememberObserver> forgetting = new ArrayList();
        @NotNull
        private final List<RememberObserver> remembering = new ArrayList();
        @NotNull
        private final List<Function0<Unit>> sideEffects = new ArrayList();

        public RememberEventDispatcher(@NotNull Set<RememberObserver> set) {
            Intrinsics.checkNotNullParameter(set, "abandoning");
            this.abandoning = set;
        }

        public final void dispatchAbandons() {
            if (!this.abandoning.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:abandons");
                try {
                    Iterator<RememberObserver> it = this.abandoning.iterator();
                    while (it.hasNext()) {
                        it.remove();
                        it.next().onAbandoned();
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
        }

        public final void dispatchRememberObservers() {
            if (!this.forgetting.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    for (int size = this.forgetting.size() - 1; -1 < size; size--) {
                        RememberObserver rememberObserver = this.forgetting.get(size);
                        if (!this.abandoning.contains(rememberObserver)) {
                            rememberObserver.onForgotten();
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
            if (!this.remembering.isEmpty()) {
                Object beginSection2 = Trace.INSTANCE.beginSection("Compose:onRemembered");
                try {
                    List<RememberObserver> list = this.remembering;
                    int size2 = list.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        RememberObserver rememberObserver2 = list.get(i11);
                        this.abandoning.remove(rememberObserver2);
                        rememberObserver2.onRemembered();
                    }
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection2);
                }
            }
        }

        public final void dispatchSideEffects() {
            if (!this.sideEffects.isEmpty()) {
                Object beginSection = Trace.INSTANCE.beginSection("Compose:sideeffects");
                try {
                    List<Function0<Unit>> list = this.sideEffects;
                    int size = list.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        list.get(i11).invoke();
                    }
                    this.sideEffects.clear();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.INSTANCE.endSection(beginSection);
                }
            }
        }

        public void forgetting(@NotNull RememberObserver rememberObserver) {
            Intrinsics.checkNotNullParameter(rememberObserver, "instance");
            int lastIndexOf = this.remembering.lastIndexOf(rememberObserver);
            if (lastIndexOf >= 0) {
                this.remembering.remove(lastIndexOf);
                this.abandoning.remove(rememberObserver);
                return;
            }
            this.forgetting.add(rememberObserver);
        }

        public void remembering(@NotNull RememberObserver rememberObserver) {
            Intrinsics.checkNotNullParameter(rememberObserver, "instance");
            int lastIndexOf = this.forgetting.lastIndexOf(rememberObserver);
            if (lastIndexOf >= 0) {
                this.forgetting.remove(lastIndexOf);
                this.abandoning.remove(rememberObserver);
                return;
            }
            this.remembering.add(rememberObserver);
        }

        public void sideEffect(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "effect");
            this.sideEffects.add(function0);
        }
    }

    public CompositionImpl(@NotNull CompositionContext compositionContext, @NotNull Applier<?> applier2, @Nullable CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(compositionContext, "parent");
        Intrinsics.checkNotNullParameter(applier2, "applier");
        this.parent = compositionContext;
        this.applier = applier2;
        this.pendingModifications = new AtomicReference<>((Object) null);
        this.lock = new Object();
        HashSet<RememberObserver> hashSet = new HashSet<>();
        this.abandonSet = hashSet;
        SlotTable slotTable2 = new SlotTable();
        this.slotTable = slotTable2;
        this.observations = new IdentityScopeMap<>();
        this.conditionallyInvalidatedScopes = new HashSet<>();
        this.derivedStates = new IdentityScopeMap<>();
        ArrayList arrayList = new ArrayList();
        this.changes = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.lateChanges = arrayList2;
        this.observationsProcessed = new IdentityScopeMap<>();
        this.invalidations = new IdentityArrayMap<>(0, 1, (DefaultConstructorMarker) null);
        ComposerImpl composerImpl = new ComposerImpl(applier2, compositionContext, slotTable2, hashSet, arrayList, arrayList2, this);
        compositionContext.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m2522getLambda1$runtime_release();
    }

    private final void abandonChanges() {
        this.pendingModifications.set((Object) null);
        this.changes.clear();
        this.lateChanges.clear();
        this.abandonSet.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00a8 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addPendingInvalidationsLocked(java.util.Set<? extends java.lang.Object> r17, boolean r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            java.util.Iterator r3 = r17.iterator()
        L_0x000d:
            boolean r4 = r3.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x0044
            java.lang.Object r4 = r3.next()
            boolean r7 = r4 instanceof androidx.compose.runtime.RecomposeScopeImpl
            if (r7 == 0) goto L_0x0022
            androidx.compose.runtime.RecomposeScopeImpl r4 = (androidx.compose.runtime.RecomposeScopeImpl) r4
            r4.invalidateForResult(r5)
            goto L_0x000d
        L_0x0022:
            addPendingInvalidationsLocked$invalidate(r0, r1, r2, r4)
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.DerivedState<?>> r5 = r0.derivedStates
            int r4 = r5.find(r4)
            if (r4 < 0) goto L_0x000d
            androidx.compose.runtime.collection.IdentityArraySet r4 = r5.scopeSetAt(r4)
            int r5 = r4.size()
            r6 = 0
        L_0x0036:
            if (r6 >= r5) goto L_0x000d
            java.lang.Object r7 = r4.get(r6)
            androidx.compose.runtime.DerivedState r7 = (androidx.compose.runtime.DerivedState) r7
            addPendingInvalidationsLocked$invalidate(r0, r1, r2, r7)
            int r6 = r6 + 1
            goto L_0x0036
        L_0x0044:
            java.lang.String r3 = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet"
            if (r1 == 0) goto L_0x0105
            java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl> r1 = r0.conditionallyInvalidatedScopes
            boolean r1 = r1.isEmpty()
            r4 = 1
            r1 = r1 ^ r4
            if (r1 == 0) goto L_0x0105
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r1 = r0.observations
            int r7 = r1.getSize()
            r8 = 0
            r9 = 0
        L_0x005a:
            if (r8 >= r7) goto L_0x00e1
            int[] r10 = r1.getValueOrder()
            r10 = r10[r8]
            androidx.compose.runtime.collection.IdentityArraySet[] r11 = r1.getScopeSets()
            r11 = r11[r10]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            int r12 = r11.size()
            r13 = 0
            r14 = 0
        L_0x0071:
            if (r13 >= r12) goto L_0x00ac
            java.lang.Object[] r15 = r11.getValues()
            r15 = r15[r13]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15, r3)
            r6 = r15
            androidx.compose.runtime.RecomposeScopeImpl r6 = (androidx.compose.runtime.RecomposeScopeImpl) r6
            java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl> r5 = r0.conditionallyInvalidatedScopes
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x009b
            T r5 = r2.element
            java.util.HashSet r5 = (java.util.HashSet) r5
            if (r5 == 0) goto L_0x0095
            boolean r5 = r5.contains(r6)
            if (r5 != r4) goto L_0x0095
            r5 = r4
            goto L_0x0096
        L_0x0095:
            r5 = 0
        L_0x0096:
            if (r5 == 0) goto L_0x0099
            goto L_0x009b
        L_0x0099:
            r5 = 0
            goto L_0x009c
        L_0x009b:
            r5 = r4
        L_0x009c:
            if (r5 != 0) goto L_0x00a8
            if (r14 == r13) goto L_0x00a6
            java.lang.Object[] r5 = r11.getValues()
            r5[r14] = r15
        L_0x00a6:
            int r14 = r14 + 1
        L_0x00a8:
            int r13 = r13 + 1
            r5 = 0
            goto L_0x0071
        L_0x00ac:
            int r5 = r11.size()
            r6 = r14
        L_0x00b1:
            if (r6 >= r5) goto L_0x00bd
            java.lang.Object[] r12 = r11.getValues()
            r13 = 0
            r12[r6] = r13
            int r6 = r6 + 1
            goto L_0x00b1
        L_0x00bd:
            r11.setSize(r14)
            int r5 = r11.size()
            if (r5 <= 0) goto L_0x00dc
            if (r9 == r8) goto L_0x00da
            int[] r5 = r1.getValueOrder()
            r5 = r5[r9]
            int[] r6 = r1.getValueOrder()
            r6[r9] = r10
            int[] r6 = r1.getValueOrder()
            r6[r8] = r5
        L_0x00da:
            int r9 = r9 + 1
        L_0x00dc:
            int r8 = r8 + 1
            r5 = 0
            goto L_0x005a
        L_0x00e1:
            int r2 = r1.getSize()
            r3 = r9
        L_0x00e6:
            if (r3 >= r2) goto L_0x00f8
            java.lang.Object[] r4 = r1.getValues()
            int[] r5 = r1.getValueOrder()
            r5 = r5[r3]
            r6 = 0
            r4[r5] = r6
            int r3 = r3 + 1
            goto L_0x00e6
        L_0x00f8:
            r1.setSize(r9)
            r16.cleanUpDerivedStateObservations()
            java.util.HashSet<androidx.compose.runtime.RecomposeScopeImpl> r1 = r0.conditionallyInvalidatedScopes
            r1.clear()
            goto L_0x019b
        L_0x0105:
            T r1 = r2.element
            java.util.HashSet r1 = (java.util.HashSet) r1
            if (r1 == 0) goto L_0x019b
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r2 = r0.observations
            int r4 = r2.getSize()
            r5 = 0
            r6 = 0
        L_0x0113:
            if (r5 >= r4) goto L_0x017e
            int[] r7 = r2.getValueOrder()
            r7 = r7[r5]
            androidx.compose.runtime.collection.IdentityArraySet[] r8 = r2.getScopeSets()
            r8 = r8[r7]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            int r9 = r8.size()
            r10 = 0
            r11 = 0
        L_0x012a:
            if (r10 >= r9) goto L_0x014b
            java.lang.Object[] r12 = r8.getValues()
            r12 = r12[r10]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r3)
            r13 = r12
            androidx.compose.runtime.RecomposeScopeImpl r13 = (androidx.compose.runtime.RecomposeScopeImpl) r13
            boolean r13 = r1.contains(r13)
            if (r13 != 0) goto L_0x0148
            if (r11 == r10) goto L_0x0146
            java.lang.Object[] r13 = r8.getValues()
            r13[r11] = r12
        L_0x0146:
            int r11 = r11 + 1
        L_0x0148:
            int r10 = r10 + 1
            goto L_0x012a
        L_0x014b:
            int r9 = r8.size()
            r10 = r11
        L_0x0150:
            if (r10 >= r9) goto L_0x015c
            java.lang.Object[] r12 = r8.getValues()
            r13 = 0
            r12[r10] = r13
            int r10 = r10 + 1
            goto L_0x0150
        L_0x015c:
            r8.setSize(r11)
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x017b
            if (r6 == r5) goto L_0x0179
            int[] r8 = r2.getValueOrder()
            r8 = r8[r6]
            int[] r9 = r2.getValueOrder()
            r9[r6] = r7
            int[] r7 = r2.getValueOrder()
            r7[r5] = r8
        L_0x0179:
            int r6 = r6 + 1
        L_0x017b:
            int r5 = r5 + 1
            goto L_0x0113
        L_0x017e:
            int r1 = r2.getSize()
            r3 = r6
        L_0x0183:
            if (r3 >= r1) goto L_0x0195
            java.lang.Object[] r4 = r2.getValues()
            int[] r5 = r2.getValueOrder()
            r5 = r5[r3]
            r7 = 0
            r4[r5] = r7
            int r3 = r3 + 1
            goto L_0x0183
        L_0x0195:
            r2.setSize(r6)
            r16.cleanUpDerivedStateObservations()
        L_0x019b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.addPendingInvalidationsLocked(java.util.Set, boolean):void");
    }

    private static final void addPendingInvalidationsLocked$invalidate(CompositionImpl compositionImpl, boolean z11, Ref.ObjectRef<HashSet<RecomposeScopeImpl>> objectRef, Object obj) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = compositionImpl.observations;
        int access$find = identityScopeMap.find(obj);
        if (access$find >= 0) {
            IdentityArraySet access$scopeSetAt = identityScopeMap.scopeSetAt(access$find);
            int size = access$scopeSetAt.size();
            for (int i11 = 0; i11 < size; i11++) {
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) access$scopeSetAt.get(i11);
                if (!compositionImpl.observationsProcessed.remove(obj, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(obj) != InvalidationResult.IGNORED) {
                    if (!recomposeScopeImpl.isConditional() || z11) {
                        T t11 = (HashSet) objectRef.element;
                        if (t11 == null) {
                            t11 = new HashSet();
                            objectRef.element = t11;
                        }
                        t11.add(recomposeScopeImpl);
                    } else {
                        compositionImpl.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                    }
                }
            }
        }
    }

    private final void applyChangesInLocked(List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list) {
        SlotWriter openWriter;
        Object beginSection;
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        try {
            if (!list.isEmpty()) {
                Object beginSection2 = Trace.INSTANCE.beginSection("Compose:applyChanges");
                try {
                    this.applier.onBeginChanges();
                    openWriter = this.slotTable.openWriter();
                    Applier<?> applier2 = this.applier;
                    int size = list.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        list.get(i11).invoke(applier2, openWriter, rememberEventDispatcher);
                    }
                    list.clear();
                    Unit unit = Unit.INSTANCE;
                    openWriter.close();
                    this.applier.onEndChanges();
                    Trace trace = Trace.INSTANCE;
                    trace.endSection(beginSection2);
                    rememberEventDispatcher.dispatchRememberObservers();
                    rememberEventDispatcher.dispatchSideEffects();
                    if (this.pendingInvalidScopes) {
                        beginSection = trace.beginSection("Compose:unobserve");
                        this.pendingInvalidScopes = false;
                        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
                        int size2 = identityScopeMap.getSize();
                        int i12 = 0;
                        for (int i13 = 0; i13 < size2; i13++) {
                            int i14 = identityScopeMap.getValueOrder()[i13];
                            IdentityArraySet identityArraySet = identityScopeMap.getScopeSets()[i14];
                            Intrinsics.checkNotNull(identityArraySet);
                            int size3 = identityArraySet.size();
                            int i15 = 0;
                            for (int i16 = 0; i16 < size3; i16++) {
                                Object obj = identityArraySet.getValues()[i16];
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                                if (!(!((RecomposeScopeImpl) obj).getValid())) {
                                    if (i15 != i16) {
                                        identityArraySet.getValues()[i15] = obj;
                                    }
                                    i15++;
                                }
                            }
                            int size4 = identityArraySet.size();
                            for (int i17 = i15; i17 < size4; i17++) {
                                identityArraySet.getValues()[i17] = null;
                            }
                            identityArraySet.setSize(i15);
                            if (identityArraySet.size() > 0) {
                                if (i12 != i13) {
                                    int i18 = identityScopeMap.getValueOrder()[i12];
                                    identityScopeMap.getValueOrder()[i12] = i14;
                                    identityScopeMap.getValueOrder()[i13] = i18;
                                }
                                i12++;
                            }
                        }
                        int size5 = identityScopeMap.getSize();
                        for (int i19 = i12; i19 < size5; i19++) {
                            identityScopeMap.getValues()[identityScopeMap.getValueOrder()[i19]] = null;
                        }
                        identityScopeMap.setSize(i12);
                        cleanUpDerivedStateObservations();
                        Unit unit2 = Unit.INSTANCE;
                        Trace.INSTANCE.endSection(beginSection);
                    }
                    if (this.lateChanges.isEmpty()) {
                        rememberEventDispatcher.dispatchAbandons();
                    }
                } catch (Throwable th2) {
                    Trace.INSTANCE.endSection(beginSection2);
                    throw th2;
                }
            } else if (this.lateChanges.isEmpty()) {
                rememberEventDispatcher.dispatchAbandons();
            }
        } catch (Throwable th3) {
            if (this.lateChanges.isEmpty()) {
                rememberEventDispatcher.dispatchAbandons();
            }
            throw th3;
        }
    }

    private final void cleanUpDerivedStateObservations() {
        IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
        int size = identityScopeMap.getSize();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            int i13 = identityScopeMap.getValueOrder()[i12];
            IdentityArraySet identityArraySet = identityScopeMap.getScopeSets()[i13];
            Intrinsics.checkNotNull(identityArraySet);
            int size2 = identityArraySet.size();
            int i14 = 0;
            for (int i15 = 0; i15 < size2; i15++) {
                Object obj = identityArraySet.getValues()[i15];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                if (!(!this.observations.contains((DerivedState) obj))) {
                    if (i14 != i15) {
                        identityArraySet.getValues()[i14] = obj;
                    }
                    i14++;
                }
            }
            int size3 = identityArraySet.size();
            for (int i16 = i14; i16 < size3; i16++) {
                identityArraySet.getValues()[i16] = null;
            }
            identityArraySet.setSize(i14);
            if (identityArraySet.size() > 0) {
                if (i11 != i12) {
                    int i17 = identityScopeMap.getValueOrder()[i11];
                    identityScopeMap.getValueOrder()[i11] = i13;
                    identityScopeMap.getValueOrder()[i12] = i17;
                }
                i11++;
            }
        }
        int size4 = identityScopeMap.getSize();
        for (int i18 = i11; i18 < size4; i18++) {
            identityScopeMap.getValues()[identityScopeMap.getValueOrder()[i18]] = null;
        }
        identityScopeMap.setSize(i11);
        Iterator<RecomposeScopeImpl> it = this.conditionallyInvalidatedScopes.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator()");
        while (it.hasNext()) {
            if (!it.next().isConditional()) {
                it.remove();
            }
        }
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object andSet = this.pendingModifications.getAndSet(CompositionKt.PendingApplyNoModifications);
        if (andSet == null) {
            return;
        }
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            ComposerKt.composeRuntimeError("pending composition has not been applied");
            throw new KotlinNothingValueException();
        } else if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, true);
        } else if (andSet instanceof Object[]) {
            for (Set addPendingInvalidationsLocked : (Set[]) andSet) {
                addPendingInvalidationsLocked(addPendingInvalidationsLocked, true);
            }
        } else {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    private final void drainPendingModificationsLocked() {
        Object andSet = this.pendingModifications.getAndSet((Object) null);
        if (Intrinsics.areEqual(andSet, CompositionKt.PendingApplyNoModifications)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set) andSet, false);
        } else if (andSet instanceof Object[]) {
            for (Set addPendingInvalidationsLocked : (Set[]) andSet) {
                addPendingInvalidationsLocked(addPendingInvalidationsLocked, false);
            }
        } else if (andSet == null) {
            ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        } else {
            ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
            throw new KotlinNothingValueException();
        }
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    private final <T> T guardChanges(Function0<? extends T> function0) {
        try {
            T invoke = function0.invoke();
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Exception e11) {
            abandonChanges();
            throw e11;
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            InlineMarker.finallyEnd(1);
            throw th2;
        }
    }

    private final <T> T guardInvalidationsLocked(Function1<? super IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>>, ? extends T> function1) {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations = takeInvalidations();
        try {
            return function1.invoke(takeInvalidations);
        } catch (Exception e11) {
            this.invalidations = takeInvalidations;
            throw e11;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        if (r1 == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003c, code lost:
        return r1.invalidateChecked(r6, r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        r5.parent.invalidate$runtime_release(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
        if (isComposing() == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return androidx.compose.runtime.InvalidationResult.SCHEDULED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return androidx.compose.runtime.InvalidationResult.DEFERRED;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.InvalidationResult invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl r6, androidx.compose.runtime.Anchor r7, java.lang.Object r8) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            androidx.compose.runtime.CompositionImpl r1 = r5.invalidationDelegate     // Catch:{ all -> 0x004e }
            r2 = 0
            if (r1 == 0) goto L_0x0013
            androidx.compose.runtime.SlotTable r3 = r5.slotTable     // Catch:{ all -> 0x004e }
            int r4 = r5.invalidationDelegateGroup     // Catch:{ all -> 0x004e }
            boolean r3 = r3.groupContainsAnchor(r4, r7)     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r1 = r2
        L_0x0014:
            if (r1 != 0) goto L_0x0035
            boolean r3 = r5.isComposing()     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x0028
            androidx.compose.runtime.ComposerImpl r3 = r5.composer     // Catch:{ all -> 0x004e }
            boolean r3 = r3.tryImminentInvalidation$runtime_release(r6, r8)     // Catch:{ all -> 0x004e }
            if (r3 == 0) goto L_0x0028
            androidx.compose.runtime.InvalidationResult r6 = androidx.compose.runtime.InvalidationResult.IMMINENT     // Catch:{ all -> 0x004e }
            monitor-exit(r0)
            return r6
        L_0x0028:
            if (r8 != 0) goto L_0x0030
            androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object>> r3 = r5.invalidations     // Catch:{ all -> 0x004e }
            r3.set(r6, r2)     // Catch:{ all -> 0x004e }
            goto L_0x0035
        L_0x0030:
            androidx.compose.runtime.collection.IdentityArrayMap<androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object>> r2 = r5.invalidations     // Catch:{ all -> 0x004e }
            androidx.compose.runtime.CompositionKt.addValue(r2, r6, r8)     // Catch:{ all -> 0x004e }
        L_0x0035:
            monitor-exit(r0)
            if (r1 == 0) goto L_0x003d
            androidx.compose.runtime.InvalidationResult r6 = r1.invalidateChecked(r6, r7, r8)
            return r6
        L_0x003d:
            androidx.compose.runtime.CompositionContext r6 = r5.parent
            r6.invalidate$runtime_release(r5)
            boolean r6 = r5.isComposing()
            if (r6 == 0) goto L_0x004b
            androidx.compose.runtime.InvalidationResult r6 = androidx.compose.runtime.InvalidationResult.DEFERRED
            goto L_0x004d
        L_0x004b:
            androidx.compose.runtime.InvalidationResult r6 = androidx.compose.runtime.InvalidationResult.SCHEDULED
        L_0x004d:
            return r6
        L_0x004e:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.invalidateChecked(androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.Anchor, java.lang.Object):androidx.compose.runtime.InvalidationResult");
    }

    private final void invalidateScopeOfLocked(Object obj) {
        IdentityScopeMap<RecomposeScopeImpl> identityScopeMap = this.observations;
        int access$find = identityScopeMap.find(obj);
        if (access$find >= 0) {
            IdentityArraySet access$scopeSetAt = identityScopeMap.scopeSetAt(access$find);
            int size = access$scopeSetAt.size();
            for (int i11 = 0; i11 < size; i11++) {
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) access$scopeSetAt.get(i11);
                if (recomposeScopeImpl.invalidateForResult(obj) == InvalidationResult.IMMINENT) {
                    this.observationsProcessed.add(obj, recomposeScopeImpl);
                }
            }
        }
    }

    private final IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations() {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> identityArrayMap = this.invalidations;
        this.invalidations = new IdentityArrayMap<>(0, 1, (DefaultConstructorMarker) null);
        return identityArrayMap;
    }

    private final <T> T trackAbandonedValues(Function0<? extends T> function0) {
        try {
            T invoke = function0.invoke();
            InlineMarker.finallyStart(1);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            InlineMarker.finallyEnd(1);
            throw th2;
        }
    }

    private final void validateRecomposeScopeAnchors(SlotTable slotTable2) {
        RecomposeScopeImpl recomposeScopeImpl;
        Object[] slots = slotTable2.getSlots();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        for (Object obj : slots) {
            if (obj instanceof RecomposeScopeImpl) {
                recomposeScopeImpl = (RecomposeScopeImpl) obj;
            } else {
                recomposeScopeImpl = null;
            }
            if (recomposeScopeImpl != null) {
                arrayList.add(recomposeScopeImpl);
            }
        }
        int size = arrayList.size();
        while (i11 < size) {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) arrayList.get(i11);
            Anchor anchor = recomposeScopeImpl2.getAnchor();
            if (anchor == null || slotTable2.slotsOf$runtime_release(anchor.toIndexFor(slotTable2)).contains(recomposeScopeImpl2)) {
                i11++;
            } else {
                throw new IllegalStateException(("Misaligned anchor " + anchor + " in scope " + recomposeScopeImpl2 + " encountered, scope found at " + ArraysKt___ArraysKt.indexOf((T[]) slotTable2.getSlots(), recomposeScopeImpl2)).toString());
            }
        }
    }

    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            } catch (Exception e11) {
                abandonChanges();
                throw e11;
            } catch (Throwable th2) {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th2;
            }
        }
    }

    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (!this.lateChanges.isEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Exception e11) {
                abandonChanges();
                throw e11;
            } catch (Throwable th2) {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th2;
            }
        }
    }

    public void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Exception e11) {
                abandonChanges();
                throw e11;
            } catch (Throwable th2) {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th2;
            }
        }
    }

    public void composeContent(@NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "content");
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations = takeInvalidations();
                try {
                    this.composer.composeContent$runtime_release(takeInvalidations, function2);
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e11) {
                    this.invalidations = takeInvalidations;
                    throw e11;
                }
            }
        } catch (Throwable th2) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th2;
            } catch (Exception e12) {
                abandonChanges();
                throw e12;
            }
        }
    }

    public <R> R delegateInvalidations(@Nullable ControlledComposition controlledComposition, int i11, @NotNull Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        if (controlledComposition == null || Intrinsics.areEqual((Object) controlledComposition, (Object) this) || i11 < 0) {
            return function0.invoke();
        }
        this.invalidationDelegate = (CompositionImpl) controlledComposition;
        this.invalidationDelegateGroup = i11;
        try {
            return function0.invoke();
        } finally {
            this.invalidationDelegate = null;
            this.invalidationDelegateGroup = 0;
        }
    }

    /* JADX INFO: finally extract failed */
    public void dispose() {
        boolean z11;
        synchronized (this.lock) {
            if (!this.disposed) {
                this.disposed = true;
                this.composable = ComposableSingletons$CompositionKt.INSTANCE.m2523getLambda2$runtime_release();
                List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> deferredChanges$runtime_release = this.composer.getDeferredChanges$runtime_release();
                if (deferredChanges$runtime_release != null) {
                    applyChangesInLocked(deferredChanges$runtime_release);
                }
                if (this.slotTable.getGroupsSize() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 || (true ^ this.abandonSet.isEmpty())) {
                    RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                    if (z11) {
                        SlotWriter openWriter = this.slotTable.openWriter();
                        try {
                            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
                            Unit unit = Unit.INSTANCE;
                            openWriter.close();
                            this.applier.clear();
                            rememberEventDispatcher.dispatchRememberObservers();
                        } catch (Throwable th2) {
                            openWriter.close();
                            throw th2;
                        }
                    }
                    rememberEventDispatcher.dispatchAbandons();
                }
                this.composer.dispose$runtime_release();
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    /* JADX INFO: finally extract failed */
    public void disposeUnusedMovableContent(@NotNull MovableContentState movableContentState) {
        Intrinsics.checkNotNullParameter(movableContentState, "state");
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter openWriter = movableContentState.getSlotTable$runtime_release().openWriter();
        try {
            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
            Unit unit = Unit.INSTANCE;
            openWriter.close();
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th2) {
            openWriter.close();
            throw th2;
        }
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getComposable() {
        return this.composable;
    }

    @NotNull
    public final List<RecomposeScopeImpl> getConditionalScopes$runtime_release() {
        return CollectionsKt___CollectionsKt.toList(this.conditionallyInvalidatedScopes);
    }

    @NotNull
    public final List<Object> getDerivedStateDependencies$runtime_release() {
        return ArraysKt___ArraysKt.filterNotNull(this.derivedStates.getValues());
    }

    public boolean getHasInvalidations() {
        boolean z11;
        synchronized (this.lock) {
            if (this.invalidations.getSize$runtime_release() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z11;
    }

    public boolean getHasPendingChanges() {
        boolean hasPendingChanges$runtime_release;
        synchronized (this.lock) {
            hasPendingChanges$runtime_release = this.composer.getHasPendingChanges$runtime_release();
        }
        return hasPendingChanges$runtime_release;
    }

    @NotNull
    public final List<Object> getObservedObjects$runtime_release() {
        return ArraysKt___ArraysKt.filterNotNull(this.observations.getValues());
    }

    public final boolean getPendingInvalidScopes$runtime_release() {
        return this.pendingInvalidScopes;
    }

    @NotNull
    public final CoroutineContext getRecomposeContext() {
        CoroutineContext coroutineContext = this._recomposeContext;
        return coroutineContext == null ? this.parent.getRecomposeCoroutineContext$runtime_release() : coroutineContext;
    }

    @NotNull
    public final SlotTable getSlotTable$runtime_release() {
        return this.slotTable;
    }

    public void insertMovableContent(@NotNull List<Pair<MovableContentStateReference, MovableContentStateReference>> list) {
        Intrinsics.checkNotNullParameter(list, "references");
        int size = list.size();
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                z11 = true;
                break;
            } else if (!Intrinsics.areEqual((Object) ((MovableContentStateReference) list.get(i11).getFirst()).getComposition$runtime_release(), (Object) this)) {
                break;
            } else {
                i11++;
            }
        }
        ComposerKt.runtimeCheck(z11);
        try {
            this.composer.insertMovableContentReferences(list);
            Unit unit = Unit.INSTANCE;
        } catch (Exception e11) {
            abandonChanges();
            throw e11;
        } catch (Throwable th2) {
            if (!this.abandonSet.isEmpty()) {
                new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
            }
            throw th2;
        }
    }

    @NotNull
    public final InvalidationResult invalidate(@NotNull RecomposeScopeImpl recomposeScopeImpl, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(recomposeScopeImpl, "scope");
        if (recomposeScopeImpl.getDefaultsInScope()) {
            recomposeScopeImpl.setDefaultsInvalid(true);
        }
        Anchor anchor = recomposeScopeImpl.getAnchor();
        if (anchor == null || !this.slotTable.ownsAnchor(anchor) || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (!recomposeScopeImpl.getCanRecompose()) {
            return InvalidationResult.IGNORED;
        }
        return invalidateChecked(recomposeScopeImpl, anchor, obj);
    }

    public void invalidateAll() {
        RecomposeScopeImpl recomposeScopeImpl;
        synchronized (this.lock) {
            for (Object obj : this.slotTable.getSlots()) {
                if (obj instanceof RecomposeScopeImpl) {
                    recomposeScopeImpl = (RecomposeScopeImpl) obj;
                } else {
                    recomposeScopeImpl = null;
                }
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.invalidate();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void invalidateGroupsWithKey(int i11) {
        List<RecomposeScopeImpl> invalidateGroupsWithKey$runtime_release;
        boolean z11;
        boolean z12;
        synchronized (this.lock) {
            invalidateGroupsWithKey$runtime_release = this.slotTable.invalidateGroupsWithKey$runtime_release(i11);
        }
        boolean z13 = true;
        if (invalidateGroupsWithKey$runtime_release != null) {
            int size = invalidateGroupsWithKey$runtime_release.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    z11 = false;
                    break;
                }
                if (invalidateGroupsWithKey$runtime_release.get(i12).invalidateForResult((Object) null) == InvalidationResult.IGNORED) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    z11 = true;
                    break;
                }
                i12++;
            }
            if (!z11) {
                z13 = false;
            }
        }
        if (z13 && this.composer.forceRecomposeScopes$runtime_release()) {
            this.parent.invalidate$runtime_release(this);
        }
    }

    public boolean isComposing() {
        return this.composer.isComposing$runtime_release();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public final boolean isRoot() {
        return this.isRoot;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean observesAnyOf(@org.jetbrains.annotations.NotNull java.util.Set<? extends java.lang.Object> r3) {
        /*
            r2 = this;
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Iterator r3 = r3.iterator()
        L_0x0009:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0025
            java.lang.Object r0 = r3.next()
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.RecomposeScopeImpl> r1 = r2.observations
            boolean r1 = r1.contains(r0)
            if (r1 != 0) goto L_0x0023
            androidx.compose.runtime.collection.IdentityScopeMap<androidx.compose.runtime.DerivedState<?>> r1 = r2.derivedStates
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L_0x0009
        L_0x0023:
            r3 = 1
            return r3
        L_0x0025:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.observesAnyOf(java.util.Set):boolean");
    }

    public void prepareCompose(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.composer.prepareCompose$runtime_release(function0);
    }

    public boolean recompose() {
        IdentityArrayMap<RecomposeScopeImpl, IdentityArraySet<Object>> takeInvalidations;
        boolean recompose$runtime_release;
        synchronized (this.lock) {
            drainPendingModificationsForCompositionLocked();
            try {
                takeInvalidations = takeInvalidations();
                recompose$runtime_release = this.composer.recompose$runtime_release(takeInvalidations);
                if (!recompose$runtime_release) {
                    drainPendingModificationsLocked();
                }
            } catch (Exception e11) {
                this.invalidations = takeInvalidations;
                throw e11;
            } catch (Throwable th2) {
                try {
                    if (!this.abandonSet.isEmpty()) {
                        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                    }
                    throw th2;
                } catch (Exception e12) {
                    abandonChanges();
                    throw e12;
                }
            }
        }
        return recompose$runtime_release;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.util.Set<? extends java.lang.Object>} */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.util.Set[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void recordModificationsOf(@org.jetbrains.annotations.NotNull java.util.Set<? extends java.lang.Object> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "values"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
        L_0x0005:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r0 = r5.pendingModifications
            java.lang.Object r0 = r0.get()
            r1 = 1
            if (r0 != 0) goto L_0x0010
            r2 = r1
            goto L_0x0018
        L_0x0010:
            java.lang.Object r2 = androidx.compose.runtime.CompositionKt.PendingApplyNoModifications
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
        L_0x0018:
            if (r2 == 0) goto L_0x001c
            r2 = r6
            goto L_0x003c
        L_0x001c:
            boolean r2 = r0 instanceof java.util.Set
            if (r2 == 0) goto L_0x002c
            r2 = 2
            java.util.Set[] r2 = new java.util.Set[r2]
            r3 = 0
            r4 = r0
            java.util.Set r4 = (java.util.Set) r4
            r2[r3] = r4
            r2[r1] = r6
            goto L_0x003c
        L_0x002c:
            boolean r1 = r0 instanceof java.lang.Object[]
            if (r1 == 0) goto L_0x0054
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            r1 = r0
            java.util.Set[] r1 = (java.util.Set[]) r1
            java.lang.Object[] r2 = kotlin.collections.ArraysKt___ArraysJvmKt.plus((T[]) r1, r6)
        L_0x003c:
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r5.pendingModifications
            boolean r1 = i.b.a(r1, r0, r2)
            if (r1 == 0) goto L_0x0005
            if (r0 != 0) goto L_0x0053
            java.lang.Object r6 = r5.lock
            monitor-enter(r6)
            r5.drainPendingModificationsLocked()     // Catch:{ all -> 0x0050 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0050 }
            monitor-exit(r6)
            goto L_0x0053
        L_0x0050:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x0053:
            return
        L_0x0054:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "corrupt pendingModifications: "
            r0.append(r1)
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r5.pendingModifications
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.recordModificationsOf(java.util.Set):void");
    }

    public void recordReadOf(@NotNull Object obj) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        Intrinsics.checkNotNullParameter(obj, "value");
        if (!getAreChildrenComposing() && (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) != null) {
            currentRecomposeScope$runtime_release.setUsed(true);
            this.observations.add(obj, currentRecomposeScope$runtime_release);
            if (obj instanceof DerivedState) {
                this.derivedStates.removeScope(obj);
                for (Object obj2 : ((DerivedState) obj).getDependencies()) {
                    if (obj2 == null) {
                        break;
                    }
                    this.derivedStates.add(obj2, obj);
                }
            }
            currentRecomposeScope$runtime_release.recordRead(obj);
        }
    }

    public void recordWriteOf(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        synchronized (this.lock) {
            invalidateScopeOfLocked(obj);
            IdentityScopeMap<DerivedState<?>> identityScopeMap = this.derivedStates;
            int access$find = identityScopeMap.find(obj);
            if (access$find >= 0) {
                IdentityArraySet access$scopeSetAt = identityScopeMap.scopeSetAt(access$find);
                int size = access$scopeSetAt.size();
                for (int i11 = 0; i11 < size; i11++) {
                    invalidateScopeOfLocked((DerivedState) access$scopeSetAt.get(i11));
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeDerivedStateObservation$runtime_release(@NotNull DerivedState<?> derivedState) {
        Intrinsics.checkNotNullParameter(derivedState, "state");
        if (!this.observations.contains(derivedState)) {
            this.derivedStates.removeScope(derivedState);
        }
    }

    public final void removeObservation$runtime_release(@NotNull Object obj, @NotNull RecomposeScopeImpl recomposeScopeImpl) {
        Intrinsics.checkNotNullParameter(obj, "instance");
        Intrinsics.checkNotNullParameter(recomposeScopeImpl, "scope");
        this.observations.remove(obj, recomposeScopeImpl);
    }

    public final void setComposable(@NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.composable = function2;
    }

    public void setContent(@NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "content");
        if (!this.disposed) {
            this.composable = function2;
            this.parent.composeInitial$runtime_release(this, function2);
            return;
        }
        throw new IllegalStateException("The composition is disposed".toString());
    }

    public final void setPendingInvalidScopes$runtime_release(boolean z11) {
        this.pendingInvalidScopes = z11;
    }

    public void verifyConsistent() {
        synchronized (this.lock) {
            if (!isComposing()) {
                this.composer.verifyConsistent$runtime_release();
                this.slotTable.verifyWellFormed();
                validateRecomposeScopeAnchors(this.slotTable);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier2, CoroutineContext coroutineContext, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier2, (i11 & 4) != 0 ? null : coroutineContext);
    }
}
