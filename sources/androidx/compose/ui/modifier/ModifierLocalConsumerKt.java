package androidx.compose.ui.modifier;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0007¨\u0006\u0007"}, d2 = {"modifierLocalConsumer", "Landroidx/compose/ui/Modifier;", "consumer", "Lkotlin/Function1;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ModifierLocalConsumerKt {
    @ExperimentalComposeUiApi
    @Stable
    @NotNull
    public static final Modifier modifierLocalConsumer(@NotNull Modifier modifier, @NotNull Function1<? super ModifierLocalReadScope, Unit> function1) {
        Function1 function12;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "consumer");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function12 = new ModifierLocalConsumerKt$modifierLocalConsumer$$inlined$debugInspectorInfo$1(function1);
        } else {
            function12 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new ModifierLocalConsumerImpl(function1, function12));
    }
}
