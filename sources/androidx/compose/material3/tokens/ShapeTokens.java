package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/tokens/ShapeTokens;", "", "()V", "CornerExtraLarge", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getCornerExtraLarge", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "CornerExtraLargeTop", "getCornerExtraLargeTop", "CornerExtraSmall", "getCornerExtraSmall", "CornerExtraSmallTop", "getCornerExtraSmallTop", "CornerFull", "getCornerFull", "CornerLarge", "getCornerLarge", "CornerLargeEnd", "getCornerLargeEnd", "CornerLargeTop", "getCornerLargeTop", "CornerMedium", "getCornerMedium", "CornerNone", "Landroidx/compose/ui/graphics/Shape;", "getCornerNone", "()Landroidx/compose/ui/graphics/Shape;", "CornerSmall", "getCornerSmall", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ShapeTokens {
    @NotNull
    private static final RoundedCornerShape CornerExtraLarge;
    @NotNull
    private static final RoundedCornerShape CornerExtraLargeTop;
    @NotNull
    private static final RoundedCornerShape CornerExtraSmall;
    @NotNull
    private static final RoundedCornerShape CornerExtraSmallTop;
    @NotNull
    private static final RoundedCornerShape CornerFull = RoundedCornerShapeKt.getCircleShape();
    @NotNull
    private static final RoundedCornerShape CornerLarge;
    @NotNull
    private static final RoundedCornerShape CornerLargeEnd;
    @NotNull
    private static final RoundedCornerShape CornerLargeTop;
    @NotNull
    private static final RoundedCornerShape CornerMedium = RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(Dp.m5478constructorimpl((float) 12.0d));
    @NotNull
    private static final Shape CornerNone = RectangleShapeKt.getRectangleShape();
    @NotNull
    private static final RoundedCornerShape CornerSmall = RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(Dp.m5478constructorimpl((float) 8.0d));
    @NotNull
    public static final ShapeTokens INSTANCE = new ShapeTokens();

    static {
        float f11 = (float) 28.0d;
        CornerExtraLarge = RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(Dp.m5478constructorimpl(f11));
        float f12 = (float) 0.0d;
        CornerExtraLargeTop = RoundedCornerShapeKt.m822RoundedCornerShapea9UjIt4(Dp.m5478constructorimpl(f11), Dp.m5478constructorimpl(f11), Dp.m5478constructorimpl(f12), Dp.m5478constructorimpl(f12));
        float f13 = (float) 4.0d;
        CornerExtraSmall = RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(Dp.m5478constructorimpl(f13));
        CornerExtraSmallTop = RoundedCornerShapeKt.m822RoundedCornerShapea9UjIt4(Dp.m5478constructorimpl(f13), Dp.m5478constructorimpl(f13), Dp.m5478constructorimpl(f12), Dp.m5478constructorimpl(f12));
        float f14 = (float) 16.0d;
        CornerLarge = RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(Dp.m5478constructorimpl(f14));
        CornerLargeEnd = RoundedCornerShapeKt.m822RoundedCornerShapea9UjIt4(Dp.m5478constructorimpl(f12), Dp.m5478constructorimpl(f14), Dp.m5478constructorimpl(f14), Dp.m5478constructorimpl(f12));
        CornerLargeTop = RoundedCornerShapeKt.m822RoundedCornerShapea9UjIt4(Dp.m5478constructorimpl(f14), Dp.m5478constructorimpl(f14), Dp.m5478constructorimpl(f12), Dp.m5478constructorimpl(f12));
    }

    private ShapeTokens() {
    }

    @NotNull
    public final RoundedCornerShape getCornerExtraLarge() {
        return CornerExtraLarge;
    }

    @NotNull
    public final RoundedCornerShape getCornerExtraLargeTop() {
        return CornerExtraLargeTop;
    }

    @NotNull
    public final RoundedCornerShape getCornerExtraSmall() {
        return CornerExtraSmall;
    }

    @NotNull
    public final RoundedCornerShape getCornerExtraSmallTop() {
        return CornerExtraSmallTop;
    }

    @NotNull
    public final RoundedCornerShape getCornerFull() {
        return CornerFull;
    }

    @NotNull
    public final RoundedCornerShape getCornerLarge() {
        return CornerLarge;
    }

    @NotNull
    public final RoundedCornerShape getCornerLargeEnd() {
        return CornerLargeEnd;
    }

    @NotNull
    public final RoundedCornerShape getCornerLargeTop() {
        return CornerLargeTop;
    }

    @NotNull
    public final RoundedCornerShape getCornerMedium() {
        return CornerMedium;
    }

    @NotNull
    public final Shape getCornerNone() {
        return CornerNone;
    }

    @NotNull
    public final RoundedCornerShape getCornerSmall() {
        return CornerSmall;
    }
}
