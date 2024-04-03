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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_face", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Face", "Landroidx/compose/material/icons/Icons$TwoTone;", "getFace", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FaceKt {
    @Nullable
    private static ImageVector _face;

    @NotNull
    public static final ImageVector getFace(@NotNull Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _face;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = r1;
        ImageVector.Builder builder2 = r1;
        ImageVector.Builder builder3 = r1;
        ImageVector.Builder builder4 = r1;
        ImageVector.Builder builder5 = new ImageVector.Builder("TwoTone.Face", Dp.m5478constructorimpl(24.0f), Dp.m5478constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = r0;
        Color.Companion companion = Color.Companion;
        SolidColor solidColor2 = new SolidColor(companion.m2945getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        StrokeCap.Companion companion2 = StrokeCap.Companion;
        int r21 = companion2.m3253getButtKaPHkGw();
        StrokeJoin.Companion companion3 = StrokeJoin.Companion;
        int r22 = companion3.m3263getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(17.5f, 8.0f);
        PathBuilder pathBuilder2 = pathBuilder;
        pathBuilder2.curveToRelative(0.46f, 0.0f, 0.91f, -0.05f, 1.34f, -0.12f);
        pathBuilder2.curveTo(17.44f, 5.56f, 14.9f, 4.0f, 12.0f, 4.0f);
        pathBuilder2.curveToRelative(-0.46f, 0.0f, -0.91f, 0.05f, -1.34f, 0.12f);
        pathBuilder2.curveTo(12.06f, 6.44f, 14.6f, 8.0f, 17.5f, 8.0f);
        pathBuilder.close();
        pathBuilder.moveTo(8.08f, 5.03f);
        pathBuilder2.curveTo(6.37f, 6.0f, 5.05f, 7.58f, 4.42f, 9.47f);
        pathBuilder2.curveToRelative(1.71f, -0.97f, 3.03f, -2.55f, 3.66f, -4.44f);
        pathBuilder.close();
        ImageVector.Builder.m3522addPathoIyEayM$default(builder4, pathBuilder.getNodes(), defaultFillType, "", solidColor, 0.3f, (Brush) null, 0.3f, 1.0f, r21, r22, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor3 = r3;
        SolidColor solidColor4 = new SolidColor(companion.m2945getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int r38 = companion2.m3253getButtKaPHkGw();
        int r39 = companion3.m3263getBevelLxFBmk8();
        PathBuilder pathBuilder3 = new PathBuilder();
        pathBuilder3.moveTo(12.0f, 2.0f);
        pathBuilder3.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
        pathBuilder3.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
        pathBuilder3.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
        pathBuilder3.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
        pathBuilder3.close();
        pathBuilder3.moveTo(12.0f, 4.0f);
        PathBuilder pathBuilder4 = pathBuilder3;
        pathBuilder4.curveToRelative(2.9f, 0.0f, 5.44f, 1.56f, 6.84f, 3.88f);
        pathBuilder4.curveToRelative(-0.43f, 0.07f, -0.88f, 0.12f, -1.34f, 0.12f);
        pathBuilder4.curveToRelative(-2.9f, 0.0f, -5.44f, -1.56f, -6.84f, -3.88f);
        pathBuilder4.curveToRelative(0.43f, -0.07f, 0.88f, -0.12f, 1.34f, -0.12f);
        pathBuilder3.close();
        pathBuilder3.moveTo(8.08f, 5.03f);
        PathBuilder pathBuilder5 = pathBuilder3;
        pathBuilder5.curveTo(7.45f, 6.92f, 6.13f, 8.5f, 4.42f, 9.47f);
        pathBuilder5.curveTo(5.05f, 7.58f, 6.37f, 6.0f, 8.08f, 5.03f);
        pathBuilder3.close();
        pathBuilder3.moveTo(12.0f, 20.0f);
        pathBuilder5.curveToRelative(-4.41f, 0.0f, -8.0f, -3.59f, -8.0f, -8.0f);
        pathBuilder5.curveToRelative(0.0f, -0.05f, 0.01f, -0.1f, 0.01f, -0.15f);
        pathBuilder5.curveToRelative(2.6f, -0.98f, 4.68f, -2.99f, 5.74f, -5.55f);
        pathBuilder5.curveToRelative(1.83f, 2.26f, 4.62f, 3.7f, 7.75f, 3.7f);
        pathBuilder5.curveToRelative(0.75f, 0.0f, 1.47f, -0.09f, 2.17f, -0.24f);
        pathBuilder5.curveToRelative(0.21f, 0.71f, 0.33f, 1.46f, 0.33f, 2.24f);
        pathBuilder5.curveToRelative(0.0f, 4.41f, -3.59f, 8.0f, -8.0f, 8.0f);
        pathBuilder3.close();
        ImageVector.Builder.m3522addPathoIyEayM$default(builder3, pathBuilder3.getNodes(), defaultFillType2, "", solidColor3, 1.0f, (Brush) null, 1.0f, 1.0f, r38, r39, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int defaultFillType3 = VectorKt.getDefaultFillType();
        SolidColor solidColor5 = r3;
        SolidColor solidColor6 = new SolidColor(companion.m2945getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int r55 = companion2.m3253getButtKaPHkGw();
        int r56 = companion3.m3263getBevelLxFBmk8();
        PathBuilder pathBuilder6 = new PathBuilder();
        pathBuilder6.moveTo(9.0f, 13.0f);
        pathBuilder6.moveToRelative(-1.25f, 0.0f);
        PathBuilder pathBuilder7 = pathBuilder6;
        pathBuilder7.arcToRelative(1.25f, 1.25f, 0.0f, true, true, 2.5f, 0.0f);
        pathBuilder7.arcToRelative(1.25f, 1.25f, 0.0f, true, true, -2.5f, 0.0f);
        ImageVector.Builder.m3522addPathoIyEayM$default(builder2, pathBuilder6.getNodes(), defaultFillType3, "", solidColor5, 1.0f, (Brush) null, 1.0f, 1.0f, r55, r56, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int defaultFillType4 = VectorKt.getDefaultFillType();
        SolidColor solidColor7 = r3;
        SolidColor solidColor8 = new SolidColor(companion.m2945getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int r72 = companion2.m3253getButtKaPHkGw();
        int r73 = companion3.m3263getBevelLxFBmk8();
        PathBuilder pathBuilder8 = new PathBuilder();
        pathBuilder8.moveTo(15.0f, 13.0f);
        pathBuilder8.moveToRelative(-1.25f, 0.0f);
        PathBuilder pathBuilder9 = pathBuilder8;
        pathBuilder9.arcToRelative(1.25f, 1.25f, 0.0f, true, true, 2.5f, 0.0f);
        pathBuilder9.arcToRelative(1.25f, 1.25f, 0.0f, true, true, -2.5f, 0.0f);
        ImageVector build = ImageVector.Builder.m3522addPathoIyEayM$default(builder, pathBuilder8.getNodes(), defaultFillType4, "", solidColor7, 1.0f, (Brush) null, 1.0f, 1.0f, r72, r73, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _face = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
