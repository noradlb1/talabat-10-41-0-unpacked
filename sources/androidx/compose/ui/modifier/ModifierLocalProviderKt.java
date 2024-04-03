package androidx.compose.ui.modifier;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"modifierLocalProvider", "Landroidx/compose/ui/Modifier;", "T", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "Lkotlin/Function0;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ModifierLocalProviderKt {
    @ExperimentalComposeUiApi
    @NotNull
    public static final <T> Modifier modifierLocalProvider(@NotNull Modifier modifier, @NotNull ProvidableModifierLocal<T> providableModifierLocal, @NotNull Function0<? extends T> function0) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(providableModifierLocal, "key");
        Intrinsics.checkNotNullParameter(function0, "value");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new ModifierLocalProviderKt$modifierLocalProvider$$inlined$debugInspectorInfo$1(providableModifierLocal, function0);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new ModifierLocalProviderKt$modifierLocalProvider$1(providableModifierLocal, function0, function1));
    }
}
