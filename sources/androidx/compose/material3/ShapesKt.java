package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0011\u0010\u000b\u001a\u00020\b*\u00020\nH\u0001¢\u0006\u0002\u0010\f\u001a\f\u0010\r\u001a\u00020\u0006*\u00020\u0006H\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000e"}, d2 = {"LocalShapes", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/Shapes;", "getLocalShapes", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "end", "Landroidx/compose/foundation/shape/CornerBasedShape;", "fromToken", "Landroidx/compose/ui/graphics/Shape;", "value", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "toShape", "(Landroidx/compose/material3/tokens/ShapeKeyTokens;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "top", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ShapesKt {
    @NotNull
    private static final ProvidableCompositionLocal<Shapes> LocalShapes = CompositionLocalKt.staticCompositionLocalOf(ShapesKt$LocalShapes$1.INSTANCE);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ShapeKeyTokens.values().length];
            iArr[ShapeKeyTokens.CornerExtraLarge.ordinal()] = 1;
            iArr[ShapeKeyTokens.CornerExtraLargeTop.ordinal()] = 2;
            iArr[ShapeKeyTokens.CornerExtraSmall.ordinal()] = 3;
            iArr[ShapeKeyTokens.CornerExtraSmallTop.ordinal()] = 4;
            iArr[ShapeKeyTokens.CornerFull.ordinal()] = 5;
            iArr[ShapeKeyTokens.CornerLarge.ordinal()] = 6;
            iArr[ShapeKeyTokens.CornerLargeEnd.ordinal()] = 7;
            iArr[ShapeKeyTokens.CornerLargeTop.ordinal()] = 8;
            iArr[ShapeKeyTokens.CornerMedium.ordinal()] = 9;
            iArr[ShapeKeyTokens.CornerNone.ordinal()] = 10;
            iArr[ShapeKeyTokens.CornerSmall.ordinal()] = 11;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final CornerBasedShape end(@NotNull CornerBasedShape cornerBasedShape) {
        Intrinsics.checkNotNullParameter(cornerBasedShape, "<this>");
        float f11 = (float) 0.0d;
        return CornerBasedShape.copy$default(cornerBasedShape, CornerSizeKt.m806CornerSize0680j_4(Dp.m5478constructorimpl(f11)), (CornerSize) null, (CornerSize) null, CornerSizeKt.m806CornerSize0680j_4(Dp.m5478constructorimpl(f11)), 6, (Object) null);
    }

    @NotNull
    public static final Shape fromToken(@NotNull Shapes shapes, @NotNull ShapeKeyTokens shapeKeyTokens) {
        Intrinsics.checkNotNullParameter(shapes, "<this>");
        Intrinsics.checkNotNullParameter(shapeKeyTokens, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[shapeKeyTokens.ordinal()]) {
            case 1:
                return shapes.getExtraLarge();
            case 2:
                return top(shapes.getExtraLarge());
            case 3:
                return shapes.getExtraSmall();
            case 4:
                return top(shapes.getExtraSmall());
            case 5:
                return RoundedCornerShapeKt.getCircleShape();
            case 6:
                return shapes.getLarge();
            case 7:
                return end(shapes.getLarge());
            case 8:
                return top(shapes.getLarge());
            case 9:
                return shapes.getMedium();
            case 10:
                return RectangleShapeKt.getRectangleShape();
            case 11:
                return shapes.getSmall();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public static final ProvidableCompositionLocal<Shapes> getLocalShapes() {
        return LocalShapes;
    }

    @NotNull
    @Composable
    public static final Shape toShape(@NotNull ShapeKeyTokens shapeKeyTokens, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(shapeKeyTokens, "<this>");
        composer.startReplaceableGroup(-612531606);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-612531606, i11, -1, "androidx.compose.material3.toShape (Shapes.kt:174)");
        }
        Shape fromToken = fromToken(MaterialTheme.INSTANCE.getShapes(composer, 6), shapeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return fromToken;
    }

    @NotNull
    public static final CornerBasedShape top(@NotNull CornerBasedShape cornerBasedShape) {
        Intrinsics.checkNotNullParameter(cornerBasedShape, "<this>");
        float f11 = (float) 0.0d;
        return CornerBasedShape.copy$default(cornerBasedShape, (CornerSize) null, (CornerSize) null, CornerSizeKt.m806CornerSize0680j_4(Dp.m5478constructorimpl(f11)), CornerSizeKt.m806CornerSize0680j_4(Dp.m5478constructorimpl(f11)), 3, (Object) null);
    }
}
