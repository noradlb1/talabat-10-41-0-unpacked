package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"ContextMenuArea", "", "manager", "Landroidx/compose/foundation/text/selection/SelectionManager;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/text/selection/SelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ContextMenu_androidKt {
    @ComposableInferredTarget(scheme = "[0[0]]")
    @Composable
    public static final void ContextMenuArea(@NotNull TextFieldSelectionManager textFieldSelectionManager, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "manager");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1985516685);
        if ((i11 & 112) == 0) {
            i12 = (startRestartGroup.changed((Object) function2) ? 32 : 16) | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 81) != 16 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1985516685, i12, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:23)");
            }
            function2.invoke(startRestartGroup, Integer.valueOf((i12 >> 3) & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ContextMenu_androidKt$ContextMenuArea$1(textFieldSelectionManager, function2, i11));
        }
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    @Composable
    public static final void ContextMenuArea(@NotNull SelectionManager selectionManager, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(selectionManager, "manager");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(605522716);
        if ((i11 & 112) == 0) {
            i12 = (startRestartGroup.changed((Object) function2) ? 32 : 16) | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 81) != 16 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(605522716, i12, -1, "androidx.compose.foundation.text.ContextMenuArea (ContextMenu.android.kt:31)");
            }
            function2.invoke(startRestartGroup, Integer.valueOf((i12 >> 3) & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ContextMenu_androidKt$ContextMenuArea$2(selectionManager, function2, i11));
        }
    }
}
