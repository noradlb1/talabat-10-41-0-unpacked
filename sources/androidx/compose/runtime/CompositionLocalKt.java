package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a<\u0010\u0000\u001a\u00020\u00012\u001a\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\t\"\u0006\u0012\u0002\b\u00030\n2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u000b\u001a0\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0005\u001a \u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0005¨\u0006\u0013"}, d2 = {"CompositionLocalProvider", "", "context", "Landroidx/compose/runtime/CompositionLocalContext;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionLocalContext;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "([Landroidx/compose/runtime/ProvidedValue;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "compositionLocalOf", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "T", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "defaultFactory", "staticCompositionLocalOf", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CompositionLocalKt {
    @ComposableInferredTarget(scheme = "[0[0]]")
    @Composable
    public static final void CompositionLocalProvider(@NotNull ProvidedValue<?>[] providedValueArr, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(providedValueArr, "values");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1390796515);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1390796515, i11, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:225)");
        }
        startRestartGroup.startProviders(providedValueArr);
        function2.invoke(startRestartGroup, Integer.valueOf((i11 >> 3) & 14));
        startRestartGroup.endProviders();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CompositionLocalKt$CompositionLocalProvider$1(providedValueArr, function2, i11));
        }
    }

    @NotNull
    public static final <T> ProvidableCompositionLocal<T> compositionLocalOf(@NotNull SnapshotMutationPolicy<T> snapshotMutationPolicy, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(snapshotMutationPolicy, "policy");
        Intrinsics.checkNotNullParameter(function0, "defaultFactory");
        return new DynamicProvidableCompositionLocal(snapshotMutationPolicy, function0);
    }

    public static /* synthetic */ ProvidableCompositionLocal compositionLocalOf$default(SnapshotMutationPolicy snapshotMutationPolicy, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            snapshotMutationPolicy = SnapshotStateKt.structuralEqualityPolicy();
        }
        return compositionLocalOf(snapshotMutationPolicy, function0);
    }

    @NotNull
    public static final <T> ProvidableCompositionLocal<T> staticCompositionLocalOf(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "defaultFactory");
        return new StaticProvidableCompositionLocal(function0);
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    @Composable
    public static final void CompositionLocalProvider(@NotNull CompositionLocalContext compositionLocalContext, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(compositionLocalContext, "context");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(1853897736);
        if ((i11 & 14) == 0) {
            i12 = (startRestartGroup.changed((Object) compositionLocalContext) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            i12 |= startRestartGroup.changed((Object) function2) ? 32 : 16;
        }
        if ((i12 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1853897736, i12, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:246)");
            }
            PersistentMap<CompositionLocal<Object>, State<Object>> compositionLocals$runtime_release = compositionLocalContext.getCompositionLocals$runtime_release();
            ArrayList arrayList = new ArrayList(compositionLocals$runtime_release.size());
            for (Map.Entry next : compositionLocals$runtime_release.entrySet()) {
                Object key = next.getKey();
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type androidx.compose.runtime.ProvidableCompositionLocal<kotlin.Any?>");
                arrayList.add(((ProvidableCompositionLocal) key).provides(((State) next.getValue()).getValue()));
            }
            Object[] array = arrayList.toArray(new ProvidedValue[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            ProvidedValue[] providedValueArr = (ProvidedValue[]) array;
            CompositionLocalProvider((ProvidedValue<?>[]) (ProvidedValue[]) Arrays.copyOf(providedValueArr, providedValueArr.length), function2, startRestartGroup, (i12 & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CompositionLocalKt$CompositionLocalProvider$3(compositionLocalContext, function2, i11));
        }
    }
}
