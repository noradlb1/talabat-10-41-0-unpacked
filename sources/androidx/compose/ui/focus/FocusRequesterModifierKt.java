package androidx.compose.ui.focus;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0007\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"ModifierLocalFocusRequester", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/focus/FocusRequesterModifierLocal;", "getModifierLocalFocusRequester", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "focusRequester", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/focus/FocusRequester;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FocusRequesterModifierKt {
    @NotNull
    private static final ProvidableModifierLocal<FocusRequesterModifierLocal> ModifierLocalFocusRequester = ModifierLocalKt.modifierLocalOf(FocusRequesterModifierKt$ModifierLocalFocusRequester$1.INSTANCE);

    @NotNull
    public static final Modifier focusRequester(@NotNull Modifier modifier, @NotNull FocusRequester focusRequester) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new FocusRequesterModifierKt$focusRequester$$inlined$debugInspectorInfo$1(focusRequester);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new FocusRequesterModifierKt$focusRequester$2(focusRequester));
    }

    @NotNull
    public static final ProvidableModifierLocal<FocusRequesterModifierLocal> getModifierLocalFocusRequester() {
        return ModifierLocalFocusRequester;
    }
}
