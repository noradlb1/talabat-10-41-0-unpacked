package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00012#\u0010\u0002\u001a\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\b\bø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"layout", "Landroidx/compose/ui/Modifier;", "measure", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LayoutModifierKt {
    @NotNull
    public static final Modifier layout(@NotNull Modifier modifier, @NotNull Function3<? super MeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> function3) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function3, "measure");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new LayoutModifierKt$layout$$inlined$debugInspectorInfo$1(function3);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new LayoutModifierImpl(function3, function1));
    }
}
