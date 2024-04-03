package androidx.compose.ui.focus;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\t\u001a\u00020\u0006*\u00020\u0006H\u0007\u001a\n\u0010\n\u001a\u00020\u0006*\u00020\u0006\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0000\"\u001c\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"ModifierLocalParentFocusModifier", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/focus/FocusModifier;", "getModifierLocalParentFocusModifier", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "ResetFocusModifierLocals", "Landroidx/compose/ui/Modifier;", "getResetFocusModifierLocals", "()Landroidx/compose/ui/Modifier;", "focusModifier", "focusTarget", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FocusModifierKt {
    @NotNull
    private static final ProvidableModifierLocal<FocusModifier> ModifierLocalParentFocusModifier = ModifierLocalKt.modifierLocalOf(FocusModifierKt$ModifierLocalParentFocusModifier$1.INSTANCE);
    @NotNull
    private static final Modifier ResetFocusModifierLocals = Modifier.Companion.then(new FocusModifierKt$ResetFocusModifierLocals$1()).then(new FocusModifierKt$ResetFocusModifierLocals$2()).then(new FocusModifierKt$ResetFocusModifierLocals$3());

    @NotNull
    @Deprecated(message = "Replaced by focusTarget", replaceWith = @ReplaceWith(expression = "focusTarget()", imports = {"androidx.compose.ui.focus.focusTarget"}))
    public static final Modifier focusModifier(@NotNull Modifier modifier) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new FocusModifierKt$focusModifier$$inlined$debugInspectorInfo$1();
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, FocusModifierKt$focusModifier$2.INSTANCE);
    }

    @NotNull
    public static final Modifier focusTarget(@NotNull Modifier modifier, @NotNull FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        return modifier.then(focusModifier).then(ResetFocusModifierLocals);
    }

    @NotNull
    public static final ProvidableModifierLocal<FocusModifier> getModifierLocalParentFocusModifier() {
        return ModifierLocalParentFocusModifier;
    }

    @NotNull
    public static final Modifier getResetFocusModifierLocals() {
        return ResetFocusModifierLocals;
    }

    @NotNull
    public static final Modifier focusTarget(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusModifierKt$focusTarget$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), FocusModifierKt$focusTarget$2.INSTANCE);
    }
}
