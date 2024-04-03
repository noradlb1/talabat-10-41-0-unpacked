package androidx.compose.ui.platform;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0003H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"WindowFocusObserver", "", "onWindowFocusChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isWindowFocused", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class WindowInfoKt {
    @Composable
    public static final void WindowFocusObserver(@NotNull Function1<? super Boolean, Unit> function1, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Intrinsics.checkNotNullParameter(function1, "onWindowFocusChanged");
        Composer startRestartGroup = composer.startRestartGroup(127829799);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) function1)) {
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
                ComposerKt.traceEventStart(127829799, i12, -1, "androidx.compose.ui.platform.WindowFocusObserver (WindowInfo.kt:53)");
            }
            WindowInfo windowInfo = (WindowInfo) startRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
            State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, startRestartGroup, i12 & 14);
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed((Object) windowInfo) | startRestartGroup.changed((Object) rememberUpdatedState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new WindowInfoKt$WindowFocusObserver$1$1(windowInfo, rememberUpdatedState, (Continuation<? super WindowInfoKt$WindowFocusObserver$1$1>) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect((Object) windowInfo, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue, startRestartGroup, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new WindowInfoKt$WindowFocusObserver$2(function1, i11));
        }
    }
}
