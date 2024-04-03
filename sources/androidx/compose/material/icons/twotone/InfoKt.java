package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_info", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Info", "Landroidx/compose/material/icons/Icons$TwoTone;", "getInfo", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class InfoKt {
    @Nullable
    private static ImageVector _info;

    @NotNull
    public static final ImageVector getInfo(@NotNull Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _info;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = r1;
        ImageVector.Builder builder2 = r1;
        ImageVector.Builder builder3 = new ImageVector.Builder("TwoTone.Info", Dp.m5478constructorimpl(24.0f), Dp.m5478constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = r0;
        Color.Companion companion = Color.Companion;
        SolidColor solidColor2 = new SolidColor(companion.m2945getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        StrokeCap.Companion companion2 = StrokeCap.Companion;
        int r21 = companion2.m3253getButtKaPHkGw();
        StrokeJoin.Companion companion3 = StrokeJoin.Companion;
        int r22 = companion3.m3263getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(12.0f, 4.0f);
        pathBuilder.curveToRelative(-4.41f, 0.0f, -8.0f, 3.59f, -8.0f, 8.0f);
        pathBuilder.reflectiveCurveToRelative(3.59f, 8.0f, 8.0f, 8.0f);
        pathBuilder.reflectiveCurveToRelative(8.0f, -3.59f, 8.0f, -8.0f);
        pathBuilder.reflectiveCurveToRelative(-3.59f, -8.0f, -8.0f, -8.0f);
        pathBuilder.close();
        pathBuilder.moveTo(13.0f, 17.0f);
        pathBuilder.horizontalLineToRelative(-2.0f);
        pathBuilder.verticalLineToRelative(-6.0f);
        pathBuilder.horizontalLineToRelative(2.0f);
        pathBuilder.verticalLineToRelative(6.0f);
        pathBuilder.close();
        pathBuilder.moveTo(13.0f, 9.0f);
        pathBuilder.horizontalLineToRelative(-2.0f);
        pathBuilder.lineTo(11.0f, 7.0f);
        pathBuilder.horizontalLineToRelative(2.0f);
        pathBuilder.verticalLineToRelative(2.0f);
        pathBuilder.close();
        ImageVector.Builder.m3522addPathoIyEayM$default(builder2, pathBuilder.getNodes(), defaultFillType, "", solidColor, 0.3f, (Brush) null, 0.3f, 1.0f, r21, r22, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor3 = r3;
        SolidColor solidColor4 = new SolidColor(companion.m2945getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int r38 = companion2.m3253getButtKaPHkGw();
        int r39 = companion3.m3263getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(11.0f, 7.0f);
        pathBuilder2.horizontalLineToRelative(2.0f);
        pathBuilder2.verticalLineToRelative(2.0f);
        pathBuilder2.horizontalLineToRelative(-2.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(11.0f, 11.0f);
        pathBuilder2.horizontalLineToRelative(2.0f);
        pathBuilder2.verticalLineToRelative(6.0f);
        pathBuilder2.horizontalLineToRelative(-2.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(12.0f, 2.0f);
        PathBuilder pathBuilder3 = pathBuilder2;
        pathBuilder3.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        pathBuilder2.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        pathBuilder2.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        pathBuilder2.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(12.0f, 20.0f);
        pathBuilder3.curveToRelative(-4.41f, 0.0f, -8.0f, -3.59f, -8.0f, -8.0f);
        pathBuilder2.reflectiveCurveToRelative(3.59f, -8.0f, 8.0f, -8.0f);
        pathBuilder2.reflectiveCurveToRelative(8.0f, 3.59f, 8.0f, 8.0f);
        pathBuilder2.reflectiveCurveToRelative(-3.59f, 8.0f, -8.0f, 8.0f);
        pathBuilder2.close();
        ImageVector build = ImageVector.Builder.m3522addPathoIyEayM$default(builder, pathBuilder2.getNodes(), defaultFillType2, "", solidColor3, 1.0f, (Brush) null, 1.0f, 1.0f, r38, r39, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _info = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
