package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Collection;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"androidx/compose/runtime/SnapshotStateKt__DerivedStateKt", "androidx/compose/runtime/SnapshotStateKt__ProduceStateKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotMutationPolicyKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotStateKt"}, k = 4, mv = {1, 7, 1}, xi = 48)
public final class SnapshotStateKt {
    @NotNull
    @Composable
    public static final <T extends R, R> State<R> collectAsState(@NotNull Flow<? extends T> flow, R r11, @Nullable CoroutineContext coroutineContext, @Nullable Composer composer, int i11, int i12) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(flow, r11, coroutineContext, composer, i11, i12);
    }

    @NotNull
    public static final <T> State<T> derivedStateOf(@NotNull SnapshotMutationPolicy<T> snapshotMutationPolicy, @NotNull Function0<? extends T> function0) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(snapshotMutationPolicy, function0);
    }

    public static final <T> T getValue(@NotNull State<? extends T> state, @Nullable Object obj, @NotNull KProperty<?> kProperty) {
        return SnapshotStateKt__SnapshotStateKt.getValue(state, obj, kProperty);
    }

    @NotNull
    public static final <T> SnapshotStateList<T> mutableStateListOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf();
    }

    @NotNull
    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf();
    }

    @NotNull
    public static final <T> MutableState<T> mutableStateOf(T t11, @NotNull SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf(t11, snapshotMutationPolicy);
    }

    @NotNull
    public static final <T> SnapshotMutationPolicy<T> neverEqualPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.neverEqualPolicy();
    }

    public static final <R> void observeDerivedStateRecalculations(@NotNull Function1<? super State<?>, Unit> function1, @NotNull Function1<? super State<?>, Unit> function12, @NotNull Function0<? extends R> function0) {
        SnapshotStateKt__DerivedStateKt.observeDerivedStateRecalculations(function1, function12, function0);
    }

    @NotNull
    @Composable
    public static final <T> State<T> produceState(T t11, @Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull @BuilderInference Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, @Nullable Composer composer, int i11) {
        return SnapshotStateKt__ProduceStateKt.produceState(t11, obj, obj2, obj3, function2, composer, i11);
    }

    @NotNull
    public static final <T> SnapshotMutationPolicy<T> referentialEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.referentialEqualityPolicy();
    }

    @NotNull
    @Composable
    public static final <T> State<T> rememberUpdatedState(T t11, @Nullable Composer composer, int i11) {
        return SnapshotStateKt__SnapshotStateKt.rememberUpdatedState(t11, composer, i11);
    }

    public static final <T> void setValue(@NotNull MutableState<T> mutableState, @Nullable Object obj, @NotNull KProperty<?> kProperty, T t11) {
        SnapshotStateKt__SnapshotStateKt.setValue(mutableState, obj, kProperty, t11);
    }

    @NotNull
    public static final <T> Flow<T> snapshotFlow(@NotNull Function0<? extends T> function0) {
        return SnapshotStateKt__SnapshotFlowKt.snapshotFlow(function0);
    }

    @NotNull
    public static final <T> SnapshotMutationPolicy<T> structuralEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.structuralEqualityPolicy();
    }

    @NotNull
    public static final <T> SnapshotStateList<T> toMutableStateList(@NotNull Collection<? extends T> collection) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateList(collection);
    }

    @NotNull
    public static final <K, V> SnapshotStateMap<K, V> toMutableStateMap(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        return SnapshotStateKt__SnapshotStateKt.toMutableStateMap(iterable);
    }

    @NotNull
    @Composable
    public static final <T> State<T> collectAsState(@NotNull StateFlow<? extends T> stateFlow, @Nullable CoroutineContext coroutineContext, @Nullable Composer composer, int i11, int i12) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(stateFlow, coroutineContext, composer, i11, i12);
    }

    @NotNull
    public static final <T> State<T> derivedStateOf(@NotNull Function0<? extends T> function0) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(function0);
    }

    @NotNull
    public static final <T> SnapshotStateList<T> mutableStateListOf(@NotNull T... tArr) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf(tArr);
    }

    @NotNull
    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf(pairArr);
    }

    @NotNull
    @Composable
    public static final <T> State<T> produceState(T t11, @Nullable Object obj, @Nullable Object obj2, @NotNull @BuilderInference Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, @Nullable Composer composer, int i11) {
        return SnapshotStateKt__ProduceStateKt.produceState(t11, obj, obj2, function2, composer, i11);
    }

    @NotNull
    @Composable
    public static final <T> State<T> produceState(T t11, @Nullable Object obj, @NotNull @BuilderInference Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, @Nullable Composer composer, int i11) {
        return SnapshotStateKt__ProduceStateKt.produceState(t11, obj, function2, composer, i11);
    }

    @NotNull
    @Composable
    public static final <T> State<T> produceState(T t11, @NotNull @BuilderInference Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, @Nullable Composer composer, int i11) {
        return SnapshotStateKt__ProduceStateKt.produceState(t11, function2, composer, i11);
    }

    @NotNull
    @Composable
    public static final <T> State<T> produceState(T t11, @NotNull Object[] objArr, @NotNull @BuilderInference Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, @Nullable Composer composer, int i11) {
        return SnapshotStateKt__ProduceStateKt.produceState(t11, objArr, function2, composer, i11);
    }
}
