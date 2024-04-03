package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 §\u00012\u00020\u0001:\n§\u0001¨\u0001©\u0001ª\u0001«\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020QH\u0002J\u0006\u0010R\u001a\u00020SJ\u0011\u0010T\u001a\u00020NH@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u0011\u0010V\u001a\u00020NH@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u0006\u0010W\u001a\u00020NJ\u0006\u0010X\u001a\u00020NJ*\u0010Y\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u00172\u0011\u0010[\u001a\r\u0012\u0004\u0012\u00020N0\\¢\u0006\u0002\b]H\u0010¢\u0006\u0004\b^\u0010_J:\u0010`\u001a\u0002Ha\"\u0004\b\u0000\u0010a2\u0006\u0010Z\u001a\u00020\u00172\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010c2\f\u0010d\u001a\b\u0012\u0004\u0012\u0002Ha0\\H\b¢\u0006\u0002\u0010eJ\u0015\u0010f\u001a\u00020N2\u0006\u0010g\u001a\u00020\u001aH\u0010¢\u0006\u0002\bhJ\u0010\u0010i\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010MH\u0002J\b\u0010j\u001a\u00020NH\u0002J\u0015\u0010k\u001a\u00020N2\u0006\u0010g\u001a\u00020\u001aH\u0010¢\u0006\u0002\blJ\u0015\u0010m\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u0017H\u0010¢\u0006\u0002\bnJ\u0015\u0010o\u001a\u00020N2\u0006\u0010p\u001a\u00020qH\u0010¢\u0006\u0002\brJ\u0011\u0010s\u001a\u00020NH@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001d\u0010t\u001a\u00020N2\u0006\u0010g\u001a\u00020\u001a2\u0006\u0010u\u001a\u00020\u001bH\u0010¢\u0006\u0002\bvJ\u0017\u0010w\u001a\u0004\u0018\u00010\u001b2\u0006\u0010g\u001a\u00020\u001aH\u0010¢\u0006\u0002\bxJ\u0010\u0010y\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u0017H\u0002J,\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00170{2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020\u001a0{2\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010cH\u0002J\"\u0010}\u001a\u0004\u0018\u00010\u00172\u0006\u0010Z\u001a\u00020\u00172\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010cH\u0002J.\u0010~\u001a\u00020N2\f\u0010\u001a\b0\u0001j\u0003`\u00012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00172\t\b\u0002\u0010\u0001\u001a\u00020\u0012H\u0002J\u001e\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020N0\u00012\u0006\u0010Z\u001a\u00020\u0017H\u0002JY\u0010\u0001\u001a\u00020N2D\u0010d\u001a@\b\u0001\u0012\u0005\u0012\u00030\u0001\u0012\u0017\u0012\u00150\u0001¢\u0006\u000f\b\u0001\u0012\n\b\u0001\u0012\u0005\b\b(\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020N0\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0001¢\u0006\u0003\b\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020NH\u0002J \u0010\u0001\u001a\u00020N2\u0014\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020N0\u0001H\bJ \u0010\u0001\u001a\u00020N2\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0010¢\u0006\u0003\b\u0001J\u0017\u0010\u0001\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u0017H\u0010¢\u0006\u0003\b\u0001J\u0012\u0010\u0001\u001a\u00020N2\u0007\u0010\u0001\u001a\u00020@H\u0002J\u000b\u0010\u0001\u001a\u0004\u0018\u00010/H\u0002J\t\u0010\u0001\u001a\u00020NH\u0002J'\u0010\u0001\u001a\u00020N2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010 \u0001J\u0012\u0010¡\u0001\u001a\u00020NH@ø\u0001\u0000¢\u0006\u0002\u0010UJ\u001b\u0010¢\u0001\u001a\u00020N2\u0006\u0010;\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0003\u0010£\u0001J\u0017\u0010¤\u0001\u001a\u00020N2\u0006\u0010Z\u001a\u00020\u0017H\u0010¢\u0006\u0003\b¥\u0001J.\u0010¦\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020N0\u00012\u0006\u0010Z\u001a\u00020\u00172\u000e\u0010b\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010cH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128PX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016X\u0004¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00160\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"8PX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0016\u00100\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0014R\u0014\u00103\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b4\u0010\u0014R\u0011\u00105\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b6\u0010\u0014R\u0014\u00107\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0014R\u000e\u00109\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u00020\u00038PX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010+R\u0012\u0010=\u001a\u00060>R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0014R\u001a\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0D0\u0016X\u0004¢\u0006\u0002\n\u0000R \u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070F8FX\u0004¢\u0006\f\u0012\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010L\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006¬\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "<set-?>", "", "changeCount", "getChangeCount", "()J", "closeCause", "", "collectingParameterInformation", "", "getCollectingParameterInformation$runtime_release", "()Z", "compositionInvalidations", "", "Landroidx/compose/runtime/ControlledComposition;", "compositionValueStatesAvailable", "", "Landroidx/compose/runtime/MovableContentStateReference;", "Landroidx/compose/runtime/MovableContentState;", "compositionValuesAwaitingInsert", "compositionValuesRemoved", "Landroidx/compose/runtime/MovableContent;", "", "compositionsAwaitingApply", "compoundHashKey", "", "getCompoundHashKey$runtime_release", "()I", "concurrentCompositionsOutstanding", "currentState", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "getEffectCoroutineContext$runtime_release", "()Lkotlin/coroutines/CoroutineContext;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "failedCompositions", "hasConcurrentFrameWorkLocked", "getHasConcurrentFrameWorkLocked", "hasFrameWorkLocked", "getHasFrameWorkLocked", "hasPendingWork", "getHasPendingWork", "hasSchedulingWork", "getHasSchedulingWork", "isClosed", "knownCompositions", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "runnerJob", "Lkotlinx/coroutines/Job;", "shouldKeepRecomposing", "getShouldKeepRecomposing", "snapshotInvalidations", "", "state", "Lkotlinx/coroutines/flow/Flow;", "getState$annotations", "()V", "getState", "()Lkotlinx/coroutines/flow/Flow;", "stateLock", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "applyAndCheck", "snapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "asRecomposerInfo", "Landroidx/compose/runtime/RecomposerInfo;", "awaitIdle", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitWorkAvailable", "cancel", "close", "composeInitial", "composition", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composing", "T", "modifiedValues", "Landroidx/compose/runtime/collection/IdentityArraySet;", "block", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/collection/IdentityArraySet;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "deletedMovableContent", "reference", "deletedMovableContent$runtime_release", "deriveStateLocked", "discardUnusedValues", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "join", "movableContentStateReleased", "data", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "performInitialMovableContentInserts", "performInsertValues", "", "references", "performRecompose", "processCompositionError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "failedInitialComposition", "recoverable", "readObserverOf", "Lkotlin/Function1;", "recompositionRunner", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/ParameterName;", "name", "parentFrameClock", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordComposerModificationsLocked", "onEachInvalidComposition", "recordInspectionTable", "table", "", "Landroidx/compose/runtime/tooling/CompositionData;", "recordInspectionTable$runtime_release", "registerComposition", "registerComposition$runtime_release", "registerRunnerJob", "callingJob", "resetErrorState", "retryFailedCompositions", "runFrameLoop", "frameSignal", "Landroidx/compose/runtime/ProduceFrameSignal;", "(Landroidx/compose/runtime/MonotonicFrameClock;Landroidx/compose/runtime/ProduceFrameSignal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runRecomposeAndApplyChanges", "runRecomposeConcurrentlyAndApplyChanges", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterComposition", "unregisterComposition$runtime_release", "writeObserverOf", "Companion", "HotReloadable", "RecomposerErrorState", "RecomposerInfoImpl", "State", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Recomposer extends CompositionContext {
    public static final int $stable = 8;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(Boolean.FALSE);
    /* access modifiers changed from: private */
    @NotNull
    public static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    /* access modifiers changed from: private */
    @NotNull
    public final MutableStateFlow<State> _state = StateFlowKt.MutableStateFlow(State.Inactive);
    /* access modifiers changed from: private */
    @NotNull
    public final BroadcastFrameClock broadcastFrameClock;
    /* access modifiers changed from: private */
    public long changeCount;
    /* access modifiers changed from: private */
    @Nullable
    public Throwable closeCause;
    /* access modifiers changed from: private */
    @NotNull
    public final List<ControlledComposition> compositionInvalidations = new ArrayList();
    @NotNull
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable = new LinkedHashMap();
    /* access modifiers changed from: private */
    @NotNull
    public final List<MovableContentStateReference> compositionValuesAwaitingInsert = new ArrayList();
    @NotNull
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved = new LinkedHashMap();
    /* access modifiers changed from: private */
    @NotNull
    public final List<ControlledComposition> compositionsAwaitingApply = new ArrayList();
    /* access modifiers changed from: private */
    public int concurrentCompositionsOutstanding;
    @NotNull
    private final CoroutineContext effectCoroutineContext;
    @NotNull
    private final CompletableJob effectJob;
    /* access modifiers changed from: private */
    @Nullable
    public RecomposerErrorState errorState;
    @Nullable
    private List<ControlledComposition> failedCompositions;
    /* access modifiers changed from: private */
    public boolean isClosed;
    /* access modifiers changed from: private */
    @NotNull
    public final List<ControlledComposition> knownCompositions = new ArrayList();
    /* access modifiers changed from: private */
    @NotNull
    public final RecomposerInfoImpl recomposerInfo = new RecomposerInfoImpl();
    /* access modifiers changed from: private */
    @Nullable
    public Job runnerJob;
    /* access modifiers changed from: private */
    @NotNull
    public final List<Set<Object>> snapshotInvalidations = new ArrayList();
    /* access modifiers changed from: private */
    @NotNull
    public final Object stateLock = new Object();
    /* access modifiers changed from: private */
    @Nullable
    public CancellableContinuation<? super Unit> workContinuation;

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010\u0016\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0001H\u0000¢\u0006\u0002\b\"J\u0014\u0010#\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u000bR\u00020\fH\u0002J\r\u0010$\u001a\u00020\u0001H\u0000¢\u0006\u0002\b%J\u0015\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0005H\u0000¢\u0006\u0002\b(R.\u0010\u0003\u001a\"\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004j\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005`\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000bR\u00020\f0\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", "", "()V", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "runningRecomposers", "Lkotlinx/coroutines/flow/StateFlow;", "", "Landroidx/compose/runtime/RecomposerInfo;", "getRunningRecomposers", "()Lkotlinx/coroutines/flow/StateFlow;", "addRunning", "", "info", "clearErrors", "clearErrors$runtime_release", "getCurrentErrors", "", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentErrors$runtime_release", "invalidateGroupsWithKey", "key", "", "invalidateGroupsWithKey$runtime_release", "loadStateAndComposeForHotReload", "token", "loadStateAndComposeForHotReload$runtime_release", "removeRunning", "saveStateAndDisposeForHotReload", "saveStateAndDisposeForHotReload$runtime_release", "setHotReloadEnabled", "value", "setHotReloadEnabled$runtime_release", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public final void addRunning(androidx.compose.runtime.Recomposer.RecomposerInfoImpl r4) {
            /*
                r3 = this;
            L_0x0000:
                kotlinx.coroutines.flow.MutableStateFlow r0 = androidx.compose.runtime.Recomposer._runningRecomposers
                java.lang.Object r0 = r0.getValue()
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet) r0
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r1 = r0.add(r4)
                if (r0 == r1) goto L_0x001a
                kotlinx.coroutines.flow.MutableStateFlow r2 = androidx.compose.runtime.Recomposer._runningRecomposers
                boolean r0 = r2.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x0000
            L_0x001a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.Companion.addRunning(androidx.compose.runtime.Recomposer$RecomposerInfoImpl):void");
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public final void removeRunning(androidx.compose.runtime.Recomposer.RecomposerInfoImpl r4) {
            /*
                r3 = this;
            L_0x0000:
                kotlinx.coroutines.flow.MutableStateFlow r0 = androidx.compose.runtime.Recomposer._runningRecomposers
                java.lang.Object r0 = r0.getValue()
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet) r0
                androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet r1 = r0.remove(r4)
                if (r0 == r1) goto L_0x001a
                kotlinx.coroutines.flow.MutableStateFlow r2 = androidx.compose.runtime.Recomposer._runningRecomposers
                boolean r0 = r2.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x0000
            L_0x001a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.Companion.removeRunning(androidx.compose.runtime.Recomposer$RecomposerInfoImpl):void");
        }

        public final void clearErrors$runtime_release() {
            ArrayList arrayList = new ArrayList();
            for (RecomposerInfoImpl resetErrorState : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorState resetErrorState2 = resetErrorState.resetErrorState();
                if (resetErrorState2 != null) {
                    arrayList.add(resetErrorState2);
                }
            }
        }

        @NotNull
        public final List<RecomposerErrorInfo> getCurrentErrors$runtime_release() {
            ArrayList arrayList = new ArrayList();
            for (RecomposerInfoImpl currentError : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInfo currentError2 = currentError.getCurrentError();
                if (currentError2 != null) {
                    arrayList.add(currentError2);
                }
            }
            return arrayList;
        }

        @NotNull
        public final StateFlow<Set<RecomposerInfo>> getRunningRecomposers() {
            return Recomposer._runningRecomposers;
        }

        public final void invalidateGroupsWithKey$runtime_release(int i11) {
            Recomposer._hotReloadEnabled.set(Boolean.TRUE);
            for (RecomposerInfoImpl recomposerInfoImpl : (Iterable) Recomposer._runningRecomposers.getValue()) {
                RecomposerErrorInfo currentError = recomposerInfoImpl.getCurrentError();
                boolean z11 = false;
                if (currentError != null && !currentError.getRecoverable()) {
                    z11 = true;
                }
                if (!z11) {
                    recomposerInfoImpl.resetErrorState();
                    recomposerInfoImpl.invalidateGroupsWithKey(i11);
                    recomposerInfoImpl.retryFailedCompositions();
                }
            }
        }

        public final void loadStateAndComposeForHotReload$runtime_release(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, LegacyTokenLocalDataSourceImpl.KEY);
            Recomposer._hotReloadEnabled.set(Boolean.TRUE);
            for (RecomposerInfoImpl resetErrorState : (Iterable) Recomposer._runningRecomposers.getValue()) {
                resetErrorState.resetErrorState();
            }
            List list = (List) obj;
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((HotReloadable) list.get(i11)).resetContent();
            }
            int size2 = list.size();
            for (int i12 = 0; i12 < size2; i12++) {
                ((HotReloadable) list.get(i12)).recompose();
            }
            for (RecomposerInfoImpl retryFailedCompositions : (Iterable) Recomposer._runningRecomposers.getValue()) {
                retryFailedCompositions.retryFailedCompositions();
            }
        }

        @NotNull
        public final Object saveStateAndDisposeForHotReload$runtime_release() {
            Recomposer._hotReloadEnabled.set(Boolean.TRUE);
            ArrayList arrayList = new ArrayList();
            for (RecomposerInfoImpl saveStateAndDisposeForHotReload : (Iterable) Recomposer._runningRecomposers.getValue()) {
                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, saveStateAndDisposeForHotReload.saveStateAndDisposeForHotReload());
            }
            return arrayList;
        }

        public final void setHotReloadEnabled$runtime_release(boolean z11) {
            Recomposer._hotReloadEnabled.set(Boolean.valueOf(z11));
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007R\u001b\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/Recomposer$HotReloadable;", "", "composition", "Landroidx/compose/runtime/CompositionImpl;", "(Landroidx/compose/runtime/CompositionImpl;)V", "composable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "clearContent", "recompose", "resetContent", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class HotReloadable {
        @NotNull
        private Function2<? super Composer, ? super Integer, Unit> composable;
        @NotNull
        private final CompositionImpl composition;

        public HotReloadable(@NotNull CompositionImpl compositionImpl) {
            Intrinsics.checkNotNullParameter(compositionImpl, "composition");
            this.composition = compositionImpl;
            this.composable = compositionImpl.getComposable();
        }

        public final void clearContent() {
            if (this.composition.isRoot()) {
                this.composition.setContent(ComposableSingletons$RecomposerKt.INSTANCE.m2524getLambda1$runtime_release());
            }
        }

        public final void recompose() {
            if (this.composition.isRoot()) {
                this.composition.setContent(this.composable);
            }
        }

        public final void resetContent() {
            this.composition.setComposable(this.composable);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "Landroidx/compose/runtime/RecomposerErrorInfo;", "recoverable", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ZLjava/lang/Exception;)V", "getCause", "()Ljava/lang/Exception;", "getRecoverable", "()Z", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RecomposerErrorState implements RecomposerErrorInfo {
        @NotNull
        private final Exception cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean z11, @NotNull Exception exc) {
            Intrinsics.checkNotNullParameter(exc, HexAttribute.HEX_ATTR_CAUSE);
            this.recoverable = z11;
            this.cause = exc;
        }

        @NotNull
        public Exception getCause() {
            return this.cause;
        }

        public boolean getRecoverable() {
            return this.recoverable;
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001a\u001a\u00020\u0015J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/RecomposerInfo;", "(Landroidx/compose/runtime/Recomposer;)V", "changeCount", "", "getChangeCount", "()J", "currentError", "Landroidx/compose/runtime/RecomposerErrorInfo;", "getCurrentError", "()Landroidx/compose/runtime/RecomposerErrorInfo;", "hasPendingWork", "", "getHasPendingWork", "()Z", "state", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/runtime/Recomposer$State;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "invalidateGroupsWithKey", "", "key", "", "resetErrorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "retryFailedCompositions", "saveStateAndDisposeForHotReload", "", "Landroidx/compose/runtime/Recomposer$HotReloadable;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }

        public long getChangeCount() {
            return Recomposer.this.getChangeCount();
        }

        @Nullable
        public final RecomposerErrorInfo getCurrentError() {
            RecomposerErrorState access$getErrorState$p;
            Object access$getStateLock$p = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (access$getStateLock$p) {
                access$getErrorState$p = recomposer.errorState;
            }
            return access$getErrorState$p;
        }

        public boolean getHasPendingWork() {
            return Recomposer.this.getHasPendingWork();
        }

        @NotNull
        public Flow<State> getState() {
            return Recomposer.this.getCurrentState();
        }

        public final void invalidateGroupsWithKey(int i11) {
            List mutableList;
            CompositionImpl compositionImpl;
            Object access$getStateLock$p = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (access$getStateLock$p) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList(recomposer.knownCompositions);
            }
            ArrayList arrayList = new ArrayList(mutableList.size());
            int size = mutableList.size();
            for (int i12 = 0; i12 < size; i12++) {
                ControlledComposition controlledComposition = (ControlledComposition) mutableList.get(i12);
                if (controlledComposition instanceof CompositionImpl) {
                    compositionImpl = (CompositionImpl) controlledComposition;
                } else {
                    compositionImpl = null;
                }
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            int size2 = arrayList.size();
            for (int i13 = 0; i13 < size2; i13++) {
                ((CompositionImpl) arrayList.get(i13)).invalidateGroupsWithKey(i11);
            }
        }

        @Nullable
        public final RecomposerErrorState resetErrorState() {
            return Recomposer.this.resetErrorState();
        }

        public final void retryFailedCompositions() {
            Recomposer.this.retryFailedCompositions();
        }

        @NotNull
        public final List<HotReloadable> saveStateAndDisposeForHotReload() {
            List mutableList;
            CompositionImpl compositionImpl;
            Object access$getStateLock$p = Recomposer.this.stateLock;
            Recomposer recomposer = Recomposer.this;
            synchronized (access$getStateLock$p) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList(recomposer.knownCompositions);
            }
            ArrayList arrayList = new ArrayList(mutableList.size());
            int size = mutableList.size();
            for (int i11 = 0; i11 < size; i11++) {
                ControlledComposition controlledComposition = (ControlledComposition) mutableList.get(i11);
                if (controlledComposition instanceof CompositionImpl) {
                    compositionImpl = (CompositionImpl) controlledComposition;
                } else {
                    compositionImpl = null;
                }
                if (compositionImpl != null) {
                    arrayList.add(compositionImpl);
                }
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int i12 = 0; i12 < size2; i12++) {
                HotReloadable hotReloadable = new HotReloadable((CompositionImpl) arrayList.get(i12));
                hotReloadable.clearContent();
                arrayList2.add(hotReloadable);
            }
            return arrayList2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", "", "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    public Recomposer(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "effectCoroutineContext");
        BroadcastFrameClock broadcastFrameClock2 = new BroadcastFrameClock(new Recomposer$broadcastFrameClock$1(this));
        this.broadcastFrameClock = broadcastFrameClock2;
        CompletableJob Job = JobKt.Job((Job) coroutineContext.get(Job.Key));
        Job.invokeOnCompletion(new Recomposer$effectJob$1$1(this));
        this.effectJob = Job;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock2).plus(Job);
    }

    public static /* synthetic */ void a(Recomposer recomposer, Exception exc, ControlledComposition controlledComposition, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            controlledComposition = null;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        recomposer.processCompositionError(exc, controlledComposition, z11);
    }

    private final void applyAndCheck(MutableSnapshot mutableSnapshot) {
        try {
            if (mutableSnapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.".toString());
            }
        } finally {
            mutableSnapshot.dispose();
        }
    }

    /* access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        if (getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this.stateLock) {
            if (getHasSchedulingWork()) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
            } else {
                this.workContinuation = cancellableContinuationImpl;
            }
            Unit unit = Unit.INSTANCE;
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    private final <T> T composing(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet, Function0<? extends T> function0) {
        Snapshot makeCurrent;
        MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, identityArraySet));
        try {
            makeCurrent = takeMutableSnapshot.makeCurrent();
            T invoke = function0.invoke();
            InlineMarker.finallyStart(1);
            takeMutableSnapshot.restoreCurrent(makeCurrent);
            InlineMarker.finallyEnd(1);
            InlineMarker.finallyStart(1);
            applyAndCheck(takeMutableSnapshot);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            applyAndCheck(takeMutableSnapshot);
            InlineMarker.finallyEnd(1);
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State state;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            this.knownCompositions.clear();
            this.snapshotInvalidations.clear();
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, (Throwable) null, 1, (Object) null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations.clear();
            this.compositionInvalidations.clear();
            if (this.broadcastFrameClock.getHasAwaiters()) {
                state = State.InactivePendingWork;
            } else {
                state = State.Inactive;
            }
        } else if ((!this.compositionInvalidations.isEmpty()) || (!this.snapshotInvalidations.isEmpty()) || (!this.compositionsAwaitingApply.isEmpty()) || (!this.compositionValuesAwaitingInsert.isEmpty()) || this.concurrentCompositionsOutstanding > 0 || this.broadcastFrameClock.getHasAwaiters()) {
            state = State.PendingWork;
        } else {
            state = State.Idle;
        }
        this._state.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        CancellableContinuation<? super Unit> cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* access modifiers changed from: private */
    public final void discardUnusedValues() {
        int i11;
        List list;
        synchronized (this.stateLock) {
            if (!this.compositionValuesRemoved.isEmpty()) {
                List flatten = CollectionsKt__IterablesKt.flatten(this.compositionValuesRemoved.values());
                this.compositionValuesRemoved.clear();
                list = new ArrayList(flatten.size());
                int size = flatten.size();
                for (int i12 = 0; i12 < size; i12++) {
                    MovableContentStateReference movableContentStateReference = (MovableContentStateReference) flatten.get(i12);
                    list.add(TuplesKt.to(movableContentStateReference, this.compositionValueStatesAvailable.get(movableContentStateReference)));
                }
                this.compositionValueStatesAvailable.clear();
            } else {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
        }
        int size2 = list.size();
        for (i11 = 0; i11 < size2; i11++) {
            Pair pair = (Pair) list.get(i11);
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.component1();
            MovableContentState movableContentState = (MovableContentState) pair.component2();
            if (movableContentState != null) {
                movableContentStateReference2.getComposition$runtime_release().disposeUnusedMovableContent(movableContentState);
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean getHasConcurrentFrameWorkLocked() {
        return (this.compositionsAwaitingApply.isEmpty() ^ true) || this.broadcastFrameClock.getHasAwaiters();
    }

    /* access modifiers changed from: private */
    public final boolean getHasFrameWorkLocked() {
        return (this.compositionInvalidations.isEmpty() ^ true) || this.broadcastFrameClock.getHasAwaiters();
    }

    /* access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z11;
        synchronized (this.stateLock) {
            z11 = true;
            if (!(!this.snapshotInvalidations.isEmpty()) && !(!this.compositionInvalidations.isEmpty()) && !this.broadcastFrameClock.getHasAwaiters()) {
                z11 = false;
            }
        }
        return z11;
    }

    /* access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z11;
        boolean z12;
        synchronized (this.stateLock) {
            z11 = !this.isClosed;
        }
        if (z11) {
            return true;
        }
        Iterator<Job> it = this.effectJob.getChildren().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().isActive()) {
                    z12 = true;
                    break;
                }
            } else {
                z12 = false;
                break;
            }
        }
        if (z12) {
            return true;
        }
        return false;
    }

    @Deprecated(message = "Replaced by currentState as a StateFlow", replaceWith = @ReplaceWith(expression = "currentState", imports = {}))
    public static /* synthetic */ void getState$annotations() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
        r0 = new java.util.ArrayList();
        performInitialMovableContentInserts$fillToInsert(r0, r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        if ((!r0.isEmpty()) == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        performInsertValues(r0, (androidx.compose.runtime.collection.IdentityArraySet<java.lang.Object>) null);
        performInitialMovableContentInserts$fillToInsert(r0, r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void performInitialMovableContentInserts(androidx.compose.runtime.ControlledComposition r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.stateLock
            monitor-enter(r0)
            java.util.List<androidx.compose.runtime.MovableContentStateReference> r1 = r7.compositionValuesAwaitingInsert     // Catch:{ all -> 0x0042 }
            int r2 = r1.size()     // Catch:{ all -> 0x0042 }
            r3 = 0
            r4 = r3
        L_0x000b:
            r5 = 1
            if (r4 >= r2) goto L_0x0023
            java.lang.Object r6 = r1.get(r4)     // Catch:{ all -> 0x0042 }
            androidx.compose.runtime.MovableContentStateReference r6 = (androidx.compose.runtime.MovableContentStateReference) r6     // Catch:{ all -> 0x0042 }
            androidx.compose.runtime.ControlledComposition r6 = r6.getComposition$runtime_release()     // Catch:{ all -> 0x0042 }
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r8)     // Catch:{ all -> 0x0042 }
            if (r6 == 0) goto L_0x0020
            r3 = r5
            goto L_0x0023
        L_0x0020:
            int r4 = r4 + 1
            goto L_0x000b
        L_0x0023:
            if (r3 != 0) goto L_0x0027
            monitor-exit(r0)
            return
        L_0x0027:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            performInitialMovableContentInserts$fillToInsert(r0, r7, r8)
        L_0x0032:
            boolean r1 = r0.isEmpty()
            r1 = r1 ^ r5
            if (r1 == 0) goto L_0x0041
            r1 = 0
            r7.performInsertValues(r0, r1)
            performInitialMovableContentInserts$fillToInsert(r0, r7, r8)
            goto L_0x0032
        L_0x0041:
            return
        L_0x0042:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.performInitialMovableContentInserts(androidx.compose.runtime.ControlledComposition):void");
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            Iterator<MovableContentStateReference> it = recomposer.compositionValuesAwaitingInsert.iterator();
            while (it.hasNext()) {
                MovableContentStateReference next = it.next();
                if (Intrinsics.areEqual((Object) next.getComposition$runtime_release(), (Object) controlledComposition)) {
                    list.add(next);
                    it.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final List<ControlledComposition> performInsertValues(List<MovableContentStateReference> list, IdentityArraySet<Object> identityArraySet) {
        ArrayList arrayList;
        HashMap hashMap = new HashMap(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            MovableContentStateReference movableContentStateReference = list.get(i11);
            ControlledComposition composition$runtime_release = movableContentStateReference.getComposition$runtime_release();
            Object obj = hashMap.get(composition$runtime_release);
            if (obj == null) {
                obj = new ArrayList();
                hashMap.put(composition$runtime_release, obj);
            }
            ((ArrayList) obj).add(movableContentStateReference);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            ControlledComposition controlledComposition = (ControlledComposition) entry.getKey();
            List list2 = (List) entry.getValue();
            ComposerKt.runtimeCheck(!controlledComposition.isComposing());
            MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, identityArraySet));
            try {
                Snapshot makeCurrent = takeMutableSnapshot.makeCurrent();
                try {
                    synchronized (this.stateLock) {
                        arrayList = new ArrayList(list2.size());
                        int size2 = list2.size();
                        for (int i12 = 0; i12 < size2; i12++) {
                            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) list2.get(i12);
                            arrayList.add(TuplesKt.to(movableContentStateReference2, RecomposerKt.removeLastMultiValue(this.compositionValuesRemoved, movableContentStateReference2.getContent$runtime_release())));
                        }
                    }
                    controlledComposition.insertMovableContent(arrayList);
                    Unit unit = Unit.INSTANCE;
                    takeMutableSnapshot.restoreCurrent(makeCurrent);
                } catch (Throwable th2) {
                    takeMutableSnapshot.restoreCurrent(makeCurrent);
                    throw th2;
                }
            } finally {
                applyAndCheck(takeMutableSnapshot);
            }
        }
        return CollectionsKt___CollectionsKt.toList(hashMap.keySet());
    }

    /* access modifiers changed from: private */
    public final ControlledComposition performRecompose(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet) {
        Snapshot makeCurrent;
        if (controlledComposition.isComposing() || controlledComposition.isDisposed()) {
            return null;
        }
        MutableSnapshot takeMutableSnapshot = Snapshot.Companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, identityArraySet));
        try {
            makeCurrent = takeMutableSnapshot.makeCurrent();
            boolean z11 = false;
            if (identityArraySet != null) {
                if (identityArraySet.isNotEmpty()) {
                    z11 = true;
                }
            }
            if (z11) {
                controlledComposition.prepareCompose(new Recomposer$performRecompose$1$1(identityArraySet, controlledComposition));
            }
            boolean recompose = controlledComposition.recompose();
            takeMutableSnapshot.restoreCurrent(makeCurrent);
            applyAndCheck(takeMutableSnapshot);
            if (recompose) {
                return controlledComposition;
            }
            return null;
        } catch (Throwable th2) {
            applyAndCheck(takeMutableSnapshot);
            throw th2;
        }
    }

    private final void processCompositionError(Exception exc, ControlledComposition controlledComposition, boolean z11) {
        Boolean bool = _hotReloadEnabled.get();
        Intrinsics.checkNotNullExpressionValue(bool, "_hotReloadEnabled.get()");
        if (!bool.booleanValue() || (exc instanceof ComposeRuntimeError)) {
            throw exc;
        }
        synchronized (this.stateLock) {
            this.compositionsAwaitingApply.clear();
            this.compositionInvalidations.clear();
            this.snapshotInvalidations.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.compositionValuesRemoved.clear();
            this.compositionValueStatesAvailable.clear();
            this.errorState = new RecomposerErrorState(z11, exc);
            if (controlledComposition != null) {
                List list = this.failedCompositions;
                if (list == null) {
                    list = new ArrayList();
                    this.failedCompositions = list;
                }
                if (!list.contains(controlledComposition)) {
                    list.add(controlledComposition);
                }
                this.knownCompositions.remove(controlledComposition);
            }
            deriveStateLocked();
        }
    }

    private final Function1<Object, Unit> readObserverOf(ControlledComposition controlledComposition) {
        return new Recomposer$readObserverOf$1(controlledComposition);
    }

    /* access modifiers changed from: private */
    public final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.broadcastFrameClock, new Recomposer$recompositionRunner$2(this, function3, MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext()), (Continuation<? super Recomposer$recompositionRunner$2>) null), continuation);
        if (withContext == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void recordComposerModificationsLocked() {
        if (!this.snapshotInvalidations.isEmpty()) {
            List<Set<Object>> list = this.snapshotInvalidations;
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                Set set = list.get(i11);
                List<ControlledComposition> list2 = this.knownCompositions;
                int size2 = list2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    list2.get(i12).recordModificationsOf(set);
                }
            }
            this.snapshotInvalidations.clear();
            if (deriveStateLocked() != null) {
                throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void registerRunnerJob(Job job) {
        synchronized (this.stateLock) {
            Throwable th2 = this.closeCause;
            if (th2 != null) {
                throw th2;
            } else if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down".toString());
            } else if (this.runnerJob == null) {
                this.runnerJob = job;
                deriveStateLocked();
            } else {
                throw new IllegalStateException("Recomposer already running".toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public final RecomposerErrorState resetErrorState() {
        RecomposerErrorState recomposerErrorState;
        synchronized (this.stateLock) {
            recomposerErrorState = this.errorState;
            if (recomposerErrorState != null) {
                this.errorState = null;
                deriveStateLocked();
            }
        }
        return recomposerErrorState;
    }

    /* access modifiers changed from: private */
    public final void retryFailedCompositions() {
        synchronized (this.stateLock) {
            List<ControlledComposition> list = this.failedCompositions;
            if (list != null) {
                while (!list.isEmpty()) {
                    ControlledComposition controlledComposition = (ControlledComposition) CollectionsKt__MutableCollectionsKt.removeLast(list);
                    if (controlledComposition instanceof CompositionImpl) {
                        controlledComposition.invalidateAll();
                        controlledComposition.setContent(((CompositionImpl) controlledComposition).getComposable());
                        if (this.errorState != null) {
                            break;
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0087 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runFrameLoop(androidx.compose.runtime.MonotonicFrameClock r8, androidx.compose.runtime.ProduceFrameSignal r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.compose.runtime.Recomposer$runFrameLoop$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = (androidx.compose.runtime.Recomposer$runFrameLoop$1) r0
            int r1 = r0.f9182o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9182o = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = new androidx.compose.runtime.Recomposer$runFrameLoop$1
            r0.<init>(r7, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f9180m
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f9182o
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0065
            if (r2 == r4) goto L_0x004d
            if (r2 != r3) goto L_0x0045
            java.lang.Object r8 = r0.f9179l
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.f9178k
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.f9177j
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.f9176i
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.f9175h
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            kotlin.ResultKt.throwOnFailure(r10)
        L_0x003f:
            r10 = r9
            r9 = r2
            r2 = r8
            r8 = r5
            r5 = r6
            goto L_0x0073
        L_0x0045:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004d:
            java.lang.Object r8 = r0.f9179l
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.f9178k
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.f9177j
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.f9176i
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.f9175h
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x008d
        L_0x0065:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r5 = r7
        L_0x0073:
            java.lang.Object r6 = r5.stateLock
            r0.f9175h = r5
            r0.f9176i = r8
            r0.f9177j = r9
            r0.f9178k = r10
            r0.f9179l = r2
            r0.f9182o = r4
            java.lang.Object r6 = r9.awaitFrameRequest(r6, r0)
            if (r6 != r1) goto L_0x0088
            return r1
        L_0x0088:
            r6 = r5
            r5 = r8
            r8 = r2
            r2 = r9
            r9 = r10
        L_0x008d:
            androidx.compose.runtime.Recomposer$runFrameLoop$2 r10 = new androidx.compose.runtime.Recomposer$runFrameLoop$2
            r10.<init>(r6, r9, r8, r2)
            r0.f9175h = r6
            r0.f9176i = r5
            r0.f9177j = r2
            r0.f9178k = r9
            r0.f9179l = r8
            r0.f9182o = r3
            java.lang.Object r10 = r5.withFrameNanos(r10, r0)
            if (r10 != r1) goto L_0x003f
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.runFrameLoop(androidx.compose.runtime.MonotonicFrameClock, androidx.compose.runtime.ProduceFrameSignal, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Function1<Object, Unit> writeObserverOf(ControlledComposition controlledComposition, IdentityArraySet<Object> identityArraySet) {
        return new Recomposer$writeObserverOf$1(controlledComposition, identityArraySet);
    }

    @NotNull
    public final RecomposerInfo asRecomposerInfo() {
        return this.recomposerInfo;
    }

    @Nullable
    public final Object awaitIdle(@NotNull Continuation<? super Unit> continuation) {
        Object collect = FlowKt.collect(FlowKt.takeWhile(getCurrentState(), new Recomposer$awaitIdle$2((Continuation<? super Recomposer$awaitIdle$2>) null)), continuation);
        return collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            if (this._state.getValue().compareTo(State.Idle) >= 0) {
                this._state.setValue(State.ShuttingDown);
            }
            Unit unit = Unit.INSTANCE;
        }
        Job.DefaultImpls.cancel$default((Job) this.effectJob, (CancellationException) null, 1, (Object) null);
    }

    public final void close() {
        if (this.effectJob.complete()) {
            synchronized (this.stateLock) {
                this.isClosed = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    public void composeInitial$runtime_release(@NotNull ControlledComposition controlledComposition, @NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        Snapshot makeCurrent;
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        Intrinsics.checkNotNullParameter(function2, "content");
        boolean isComposing = controlledComposition.isComposing();
        try {
            Snapshot.Companion companion = Snapshot.Companion;
            MutableSnapshot takeMutableSnapshot = companion.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, (IdentityArraySet<Object>) null));
            try {
                makeCurrent = takeMutableSnapshot.makeCurrent();
                controlledComposition.composeContent(function2);
                Unit unit = Unit.INSTANCE;
                takeMutableSnapshot.restoreCurrent(makeCurrent);
                applyAndCheck(takeMutableSnapshot);
                if (!isComposing) {
                    companion.notifyObjectsInitialized();
                }
                synchronized (this.stateLock) {
                    if (this._state.getValue().compareTo(State.ShuttingDown) > 0 && !this.knownCompositions.contains(controlledComposition)) {
                        this.knownCompositions.add(controlledComposition);
                    }
                }
                try {
                    performInitialMovableContentInserts(controlledComposition);
                    try {
                        controlledComposition.applyChanges();
                        controlledComposition.applyLateChanges();
                        if (!isComposing) {
                            companion.notifyObjectsInitialized();
                        }
                    } catch (Exception e11) {
                        a(this, e11, (ControlledComposition) null, false, 6, (Object) null);
                    }
                } catch (Exception e12) {
                    processCompositionError(e12, controlledComposition, true);
                }
            } catch (Throwable th2) {
                applyAndCheck(takeMutableSnapshot);
                throw th2;
            }
        } catch (Exception e13) {
            processCompositionError(e13, controlledComposition, true);
        }
    }

    public void deletedMovableContent$runtime_release(@NotNull MovableContentStateReference movableContentStateReference) {
        Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
        synchronized (this.stateLock) {
            RecomposerKt.addMultiValue(this.compositionValuesRemoved, movableContentStateReference.getContent$runtime_release(), movableContentStateReference);
        }
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    public boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    public int getCompoundHashKey$runtime_release() {
        return 1000;
    }

    @NotNull
    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    @NotNull
    public CoroutineContext getEffectCoroutineContext$runtime_release() {
        return this.effectCoroutineContext;
    }

    public final boolean getHasPendingWork() {
        boolean z11;
        synchronized (this.stateLock) {
            z11 = true;
            if (!(!this.snapshotInvalidations.isEmpty()) && !(!this.compositionInvalidations.isEmpty()) && this.concurrentCompositionsOutstanding <= 0 && !(!this.compositionsAwaitingApply.isEmpty()) && !this.broadcastFrameClock.getHasAwaiters()) {
                z11 = false;
            }
        }
        return z11;
    }

    @NotNull
    public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @NotNull
    public final Flow<State> getState() {
        return getCurrentState();
    }

    public void insertMovableContent$runtime_release(@NotNull MovableContentStateReference movableContentStateReference) {
        CancellableContinuation<Unit> deriveStateLocked;
        Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
        synchronized (this.stateLock) {
            this.compositionValuesAwaitingInsert.add(movableContentStateReference);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
        }
    }

    public void invalidate$runtime_release(@NotNull ControlledComposition controlledComposition) {
        CancellableContinuation<Unit> cancellableContinuation;
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        synchronized (this.stateLock) {
            if (!this.compositionInvalidations.contains(controlledComposition)) {
                this.compositionInvalidations.add(controlledComposition);
                cancellableContinuation = deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
        }
    }

    public void invalidateScope$runtime_release(@NotNull RecomposeScopeImpl recomposeScopeImpl) {
        CancellableContinuation<Unit> deriveStateLocked;
        Intrinsics.checkNotNullParameter(recomposeScopeImpl, "scope");
        synchronized (this.stateLock) {
            this.snapshotInvalidations.add(SetsKt__SetsJVMKt.setOf(recomposeScopeImpl));
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            deriveStateLocked.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
        }
    }

    @Nullable
    public final Object join(@NotNull Continuation<? super Unit> continuation) {
        Object first = FlowKt.first(getCurrentState(), new Recomposer$join$2((Continuation<? super Recomposer$join$2>) null), continuation);
        return first == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? first : Unit.INSTANCE;
    }

    public void movableContentStateReleased$runtime_release(@NotNull MovableContentStateReference movableContentStateReference, @NotNull MovableContentState movableContentState) {
        Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
        Intrinsics.checkNotNullParameter(movableContentState, "data");
        synchronized (this.stateLock) {
            this.compositionValueStatesAvailable.put(movableContentStateReference, movableContentState);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Nullable
    public MovableContentState movableContentStateResolve$runtime_release(@NotNull MovableContentStateReference movableContentStateReference) {
        MovableContentState remove;
        Intrinsics.checkNotNullParameter(movableContentStateReference, "reference");
        synchronized (this.stateLock) {
            remove = this.compositionValueStatesAvailable.remove(movableContentStateReference);
        }
        return remove;
    }

    public void recordInspectionTable$runtime_release(@NotNull Set<CompositionData> set) {
        Intrinsics.checkNotNullParameter(set, "table");
    }

    public void registerComposition$runtime_release(@NotNull ControlledComposition controlledComposition) {
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
    }

    @Nullable
    public final Object runRecomposeAndApplyChanges(@NotNull Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeAndApplyChanges$2(this, (Continuation<? super Recomposer$runRecomposeAndApplyChanges$2>) null), continuation);
        return recompositionRunner == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    @ExperimentalComposeApi
    @Nullable
    public final Object runRecomposeConcurrentlyAndApplyChanges(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(coroutineContext, this, (Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2>) null), continuation);
        return recompositionRunner == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    public void unregisterComposition$runtime_release(@NotNull ControlledComposition controlledComposition) {
        Intrinsics.checkNotNullParameter(controlledComposition, "composition");
        synchronized (this.stateLock) {
            this.knownCompositions.remove(controlledComposition);
            this.compositionInvalidations.remove(controlledComposition);
            this.compositionsAwaitingApply.remove(controlledComposition);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void recordComposerModificationsLocked(Function1<? super ControlledComposition, Unit> function1) {
        if (!this.snapshotInvalidations.isEmpty()) {
            List access$getSnapshotInvalidations$p = this.snapshotInvalidations;
            int size = access$getSnapshotInvalidations$p.size();
            for (int i11 = 0; i11 < size; i11++) {
                Set set = (Set) access$getSnapshotInvalidations$p.get(i11);
                List access$getKnownCompositions$p = this.knownCompositions;
                int size2 = access$getKnownCompositions$p.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    ((ControlledComposition) access$getKnownCompositions$p.get(i12)).recordModificationsOf(set);
                }
            }
            this.snapshotInvalidations.clear();
        }
        List access$getCompositionInvalidations$p = this.compositionInvalidations;
        int size3 = access$getCompositionInvalidations$p.size();
        for (int i13 = 0; i13 < size3; i13++) {
            function1.invoke(access$getCompositionInvalidations$p.get(i13));
        }
        this.compositionInvalidations.clear();
        if (deriveStateLocked() != null) {
            throw new IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
        }
    }
}
