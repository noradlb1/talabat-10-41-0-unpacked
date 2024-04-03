package com.checkout.frames.utils.extensions;

import androidx.compose.foundation.shape.CutCornerShapeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.unit.Dp;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toComposeShape", "Landroidx/compose/ui/graphics/Shape;", "Lcom/checkout/frames/model/Shape;", "cornerRadius", "Lcom/checkout/frames/model/CornerRadius;", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ShapeExtensionsKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Shape.values().length];
            iArr[Shape.Circle.ordinal()] = 1;
            iArr[Shape.RoundCorner.ordinal()] = 2;
            iArr[Shape.CutCorner.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final androidx.compose.ui.graphics.Shape toComposeShape(@NotNull Shape shape, @NotNull CornerRadius cornerRadius) {
        Intrinsics.checkNotNullParameter(shape, "<this>");
        Intrinsics.checkNotNullParameter(cornerRadius, "cornerRadius");
        int i11 = WhenMappings.$EnumSwitchMapping$0[shape.ordinal()];
        if (i11 == 1) {
            return RoundedCornerShapeKt.getCircleShape();
        }
        if (i11 == 2) {
            return RoundedCornerShapeKt.m822RoundedCornerShapea9UjIt4(Dp.m5478constructorimpl((float) cornerRadius.getTopStart()), Dp.m5478constructorimpl((float) cornerRadius.getTopEnd()), Dp.m5478constructorimpl((float) cornerRadius.getBottomEnd()), Dp.m5478constructorimpl((float) cornerRadius.getBottomStart()));
        }
        if (i11 != 3) {
            return RectangleShapeKt.getRectangleShape();
        }
        return CutCornerShapeKt.m810CutCornerShapea9UjIt4(Dp.m5478constructorimpl((float) cornerRadius.getTopStart()), Dp.m5478constructorimpl((float) cornerRadius.getTopEnd()), Dp.m5478constructorimpl((float) cornerRadius.getBottomEnd()), Dp.m5478constructorimpl((float) cornerRadius.getBottomStart()));
    }
}
