package com.designsystem.modifier;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import com.designsystem.ds_box_shadow.Shadow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"DefaultCornerSize", "Landroidx/compose/ui/unit/Dp;", "F", "boxShadow", "Landroidx/compose/ui/Modifier;", "shadows", "", "Lcom/designsystem/ds_box_shadow/Shadow;", "shape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class BoxShadowKt {
    private static final float DefaultCornerSize = Dp.m5478constructorimpl((float) 0);

    @NotNull
    public static final Modifier boxShadow(@NotNull Modifier modifier, @NotNull List<Shadow> list, @NotNull RoundedCornerShape roundedCornerShape) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(list, "shadows");
        Intrinsics.checkNotNullParameter(roundedCornerShape, "shape");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new BoxShadowKt$boxShadow$$inlined$debugInspectorInfo$1(list, roundedCornerShape);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new BoxShadowKt$boxShadow$2(list, roundedCornerShape));
    }

    public static /* synthetic */ Modifier boxShadow$default(Modifier modifier, List list, RoundedCornerShape roundedCornerShape, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            roundedCornerShape = RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(DefaultCornerSize);
        }
        return boxShadow(modifier, list, roundedCornerShape);
    }
}
