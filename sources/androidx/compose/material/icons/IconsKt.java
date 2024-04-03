package androidx.compose.material.icons;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a-\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\bø\u0001\u0000\u001aT\u0010\f\u001a\u00020\n*\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\t¢\u0006\u0002\b\u000bH\bø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u0002\u0012\n\u0005\b20\u0001\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"MaterialIconDimension", "", "getMaterialIconDimension$annotations", "()V", "materialIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "name", "", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Lkotlin/ExtensionFunctionType;", "materialPath", "fillAlpha", "strokeAlpha", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "materialPath-YwgOQQI", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;FFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "material-icons-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class IconsKt {
    public static final float MaterialIconDimension = 24.0f;

    @PublishedApi
    public static /* synthetic */ void getMaterialIconDimension$annotations() {
    }

    @NotNull
    public static final ImageVector materialIcon(@NotNull String str, @NotNull Function1<? super ImageVector.Builder, ImageVector.Builder> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "block");
        return function1.invoke(new ImageVector.Builder(str, Dp.m5478constructorimpl(24.0f), Dp.m5478constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, 96, (DefaultConstructorMarker) null)).build();
    }

    @NotNull
    /* renamed from: materialPath-YwgOQQI  reason: not valid java name */
    public static final ImageVector.Builder m1462materialPathYwgOQQI(@NotNull ImageVector.Builder builder, float f11, float f12, int i11, @NotNull Function1<? super PathBuilder, Unit> function1) {
        Function1<? super PathBuilder, Unit> function12 = function1;
        int i12 = i11;
        Intrinsics.checkNotNullParameter(builder, "$this$materialPath");
        Intrinsics.checkNotNullParameter(function12, "pathBuilder");
        SolidColor solidColor = r2;
        SolidColor solidColor2 = new SolidColor(Color.Companion.m2945getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int r102 = StrokeCap.Companion.m3253getButtKaPHkGw();
        int r11 = StrokeJoin.Companion.m3263getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        function12.invoke(pathBuilder);
        return ImageVector.Builder.m3522addPathoIyEayM$default(builder, pathBuilder.getNodes(), i12, "", solidColor, f11, (Brush) null, f12, 1.0f, r102, r11, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
    }

    /* renamed from: materialPath-YwgOQQI$default  reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m1463materialPathYwgOQQI$default(ImageVector.Builder builder, float f11, float f12, int i11, Function1 function1, int i12, Object obj) {
        float f13;
        float f14;
        int i13;
        Function1 function12 = function1;
        if ((i12 & 1) != 0) {
            f13 = 1.0f;
        } else {
            f13 = f11;
        }
        if ((i12 & 2) != 0) {
            f14 = 1.0f;
        } else {
            f14 = f12;
        }
        if ((i12 & 4) != 0) {
            i13 = VectorKt.getDefaultFillType();
        } else {
            i13 = i11;
        }
        Intrinsics.checkNotNullParameter(builder, "$this$materialPath");
        Intrinsics.checkNotNullParameter(function12, "pathBuilder");
        SolidColor solidColor = r1;
        SolidColor solidColor2 = new SolidColor(Color.Companion.m2945getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int r12 = StrokeCap.Companion.m3253getButtKaPHkGw();
        int r13 = StrokeJoin.Companion.m3263getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        function12.invoke(pathBuilder);
        return ImageVector.Builder.m3522addPathoIyEayM$default(builder, pathBuilder.getNodes(), i13, "", solidColor, f13, (Brush) null, f14, 1.0f, r12, r13, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
    }
}
