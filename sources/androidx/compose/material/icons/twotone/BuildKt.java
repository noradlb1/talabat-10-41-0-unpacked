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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Build", "Landroidx/compose/material/icons/Icons$TwoTone;", "getBuild", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BuildKt {
    @Nullable
    private static ImageVector _build;

    @NotNull
    public static final ImageVector getBuild(@NotNull Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _build;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = r1;
        ImageVector.Builder builder2 = r1;
        ImageVector.Builder builder3 = new ImageVector.Builder("TwoTone.Build", Dp.m5478constructorimpl(24.0f), Dp.m5478constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = r0;
        Color.Companion companion = Color.Companion;
        SolidColor solidColor2 = new SolidColor(companion.m2945getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        StrokeCap.Companion companion2 = StrokeCap.Companion;
        int r21 = companion2.m3253getButtKaPHkGw();
        StrokeJoin.Companion companion3 = StrokeJoin.Companion;
        int r22 = companion3.m3263getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(11.92f, 8.28f);
        PathBuilder pathBuilder2 = pathBuilder;
        pathBuilder2.curveToRelative(0.24f, -1.4f, -0.16f, -2.89f, -1.24f, -3.96f);
        pathBuilder2.curveToRelative(-0.94f, -0.95f, -2.2f, -1.39f, -3.44f, -1.32f);
        pathBuilder.lineToRelative(3.09f, 3.09f);
        pathBuilder.lineToRelative(-4.24f, 4.24f);
        pathBuilder.lineTo(3.0f, 7.24f);
        pathBuilder2.curveToRelative(-0.07f, 1.24f, 0.37f, 2.49f, 1.31f, 3.44f);
        pathBuilder2.curveToRelative(1.04f, 1.04f, 2.47f, 1.45f, 3.83f, 1.25f);
        pathBuilder2.curveToRelative(0.71f, -0.1f, 1.4f, -0.38f, 2.0f, -0.82f);
        pathBuilder.lineToRelative(9.46f, 9.46f);
        pathBuilder.lineToRelative(0.88f, -0.88f);
        pathBuilder.lineToRelative(-9.45f, -9.45f);
        pathBuilder.curveToRelative(0.47f, -0.6f, 0.77f, -1.26f, 0.89f, -1.96f);
        pathBuilder.close();
        ImageVector.Builder.m3522addPathoIyEayM$default(builder2, pathBuilder.getNodes(), defaultFillType, "", solidColor, 0.3f, (Brush) null, 0.3f, 1.0f, r21, r22, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor3 = r3;
        SolidColor solidColor4 = new SolidColor(companion.m2945getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int r38 = companion2.m3253getButtKaPHkGw();
        int r39 = companion3.m3263getBevelLxFBmk8();
        PathBuilder pathBuilder3 = new PathBuilder();
        pathBuilder3.moveTo(22.61f, 18.97f);
        pathBuilder3.lineTo(13.54f, 9.9f);
        PathBuilder pathBuilder4 = pathBuilder3;
        pathBuilder4.curveToRelative(0.93f, -2.34f, 0.45f, -5.1f, -1.44f, -7.0f);
        pathBuilder4.curveTo(9.8f, 0.6f, 6.22f, 0.39f, 3.67f, 2.25f);
        pathBuilder3.lineTo(7.5f, 6.08f);
        pathBuilder3.lineTo(6.08f, 7.5f);
        pathBuilder3.lineTo(2.25f, 3.67f);
        pathBuilder4.curveTo(0.39f, 6.21f, 0.6f, 9.79f, 2.9f, 12.09f);
        pathBuilder4.curveToRelative(1.86f, 1.86f, 4.57f, 2.35f, 6.89f, 1.48f);
        pathBuilder3.lineToRelative(9.11f, 9.11f);
        pathBuilder4.curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0.0f);
        pathBuilder3.lineToRelative(2.3f, -2.3f);
        pathBuilder4.curveToRelative(0.4f, -0.38f, 0.4f, -1.02f, 0.0f, -1.41f);
        pathBuilder3.close();
        pathBuilder3.moveTo(19.61f, 20.57f);
        pathBuilder3.lineToRelative(-9.46f, -9.46f);
        pathBuilder4.curveToRelative(-0.61f, 0.45f, -1.29f, 0.72f, -2.0f, 0.82f);
        pathBuilder4.curveToRelative(-1.36f, 0.2f, -2.79f, -0.21f, -3.83f, -1.25f);
        pathBuilder4.curveToRelative(-0.95f, -0.94f, -1.39f, -2.2f, -1.32f, -3.44f);
        pathBuilder3.lineToRelative(3.09f, 3.09f);
        pathBuilder3.lineToRelative(4.24f, -4.24f);
        pathBuilder3.lineTo(7.24f, 3.0f);
        pathBuilder4.curveToRelative(1.24f, -0.07f, 2.49f, 0.37f, 3.44f, 1.31f);
        pathBuilder4.curveToRelative(1.08f, 1.08f, 1.49f, 2.57f, 1.24f, 3.96f);
        pathBuilder4.curveToRelative(-0.12f, 0.7f, -0.42f, 1.36f, -0.88f, 1.95f);
        pathBuilder3.lineToRelative(9.45f, 9.45f);
        pathBuilder3.lineToRelative(-0.88f, 0.9f);
        pathBuilder3.close();
        ImageVector build = ImageVector.Builder.m3522addPathoIyEayM$default(builder, pathBuilder3.getNodes(), defaultFillType2, "", solidColor3, 1.0f, (Brush) null, 1.0f, 1.0f, r38, r39, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _build = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
