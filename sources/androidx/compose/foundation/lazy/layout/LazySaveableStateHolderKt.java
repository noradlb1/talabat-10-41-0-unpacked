package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"LazySaveableStateHolderProvider", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazySaveableStateHolderKt {
    @ComposableInferredTarget(scheme = "[0[0]]")
    @Composable
    public static final void LazySaveableStateHolderProvider(@NotNull Function3<? super SaveableStateHolder, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer startRestartGroup = composer.startRestartGroup(674185128);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) function3)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(674185128, i12, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider (LazySaveableStateHolder.kt:41)");
            }
            SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) startRestartGroup.consume(SaveableStateRegistryKt.getLocalSaveableStateRegistry());
            LazySaveableStateHolder lazySaveableStateHolder = (LazySaveableStateHolder) RememberSaveableKt.rememberSaveable(new Object[]{saveableStateRegistry}, LazySaveableStateHolder.Companion.saver(saveableStateRegistry), (String) null, new LazySaveableStateHolderKt$LazySaveableStateHolderProvider$holder$1(saveableStateRegistry), startRestartGroup, 72, 4);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(lazySaveableStateHolder)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 1863926504, true, new LazySaveableStateHolderKt$LazySaveableStateHolderProvider$1(lazySaveableStateHolder, function3, i12)), startRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazySaveableStateHolderKt$LazySaveableStateHolderProvider$2(function3, i11));
        }
    }
}
