package androidx.compose.foundation.text;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"maxLinesHeight", "Landroidx/compose/ui/Modifier;", "maxLines", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MaxLinesHeightModifierKt {
    @NotNull
    public static final Modifier maxLinesHeight(@NotNull Modifier modifier, int i11, @NotNull TextStyle textStyle) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new MaxLinesHeightModifierKt$maxLinesHeight$$inlined$debugInspectorInfo$1(i11, textStyle);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new MaxLinesHeightModifierKt$maxLinesHeight$2(i11, textStyle));
    }
}
