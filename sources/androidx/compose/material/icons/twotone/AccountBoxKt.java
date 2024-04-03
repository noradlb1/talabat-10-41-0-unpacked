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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_accountBox", "Landroidx/compose/ui/graphics/vector/ImageVector;", "AccountBox", "Landroidx/compose/material/icons/Icons$TwoTone;", "getAccountBox", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AccountBoxKt {
    @Nullable
    private static ImageVector _accountBox;

    @NotNull
    public static final ImageVector getAccountBox(@NotNull Icons.TwoTone twoTone) {
        Intrinsics.checkNotNullParameter(twoTone, "<this>");
        ImageVector imageVector = _accountBox;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = r1;
        ImageVector.Builder builder2 = r1;
        ImageVector.Builder builder3 = new ImageVector.Builder("TwoTone.AccountBox", Dp.m5478constructorimpl(24.0f), Dp.m5478constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = r0;
        Color.Companion companion = Color.Companion;
        SolidColor solidColor2 = new SolidColor(companion.m2945getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        StrokeCap.Companion companion2 = StrokeCap.Companion;
        int r21 = companion2.m3253getButtKaPHkGw();
        StrokeJoin.Companion companion3 = StrokeJoin.Companion;
        int r22 = companion3.m3263getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(5.0f, 19.0f);
        pathBuilder.horizontalLineToRelative(14.0f);
        pathBuilder.lineTo(19.0f, 5.0f);
        pathBuilder.lineTo(5.0f, 5.0f);
        pathBuilder.verticalLineToRelative(14.0f);
        pathBuilder.close();
        pathBuilder.moveTo(12.0f, 6.0f);
        PathBuilder pathBuilder2 = pathBuilder;
        pathBuilder2.curveToRelative(1.65f, 0.0f, 3.0f, 1.35f, 3.0f, 3.0f);
        pathBuilder.reflectiveCurveToRelative(-1.35f, 3.0f, -3.0f, 3.0f);
        pathBuilder.reflectiveCurveToRelative(-3.0f, -1.35f, -3.0f, -3.0f);
        pathBuilder.reflectiveCurveToRelative(1.35f, -3.0f, 3.0f, -3.0f);
        pathBuilder.close();
        pathBuilder.moveTo(6.0f, 16.47f);
        pathBuilder2.curveToRelative(0.0f, -2.5f, 3.97f, -3.58f, 6.0f, -3.58f);
        pathBuilder.reflectiveCurveToRelative(6.0f, 1.08f, 6.0f, 3.58f);
        pathBuilder.lineTo(18.0f, 18.0f);
        pathBuilder.lineTo(6.0f, 18.0f);
        pathBuilder.verticalLineToRelative(-1.53f);
        pathBuilder.close();
        ImageVector.Builder.m3522addPathoIyEayM$default(builder2, pathBuilder.getNodes(), defaultFillType, "", solidColor, 0.3f, (Brush) null, 0.3f, 1.0f, r21, r22, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor3 = r3;
        SolidColor solidColor4 = new SolidColor(companion.m2945getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int r38 = companion2.m3253getButtKaPHkGw();
        int r39 = companion3.m3263getBevelLxFBmk8();
        PathBuilder pathBuilder3 = new PathBuilder();
        pathBuilder3.moveTo(12.0f, 12.0f);
        PathBuilder pathBuilder4 = pathBuilder3;
        pathBuilder4.curveToRelative(1.65f, 0.0f, 3.0f, -1.35f, 3.0f, -3.0f);
        pathBuilder3.reflectiveCurveToRelative(-1.35f, -3.0f, -3.0f, -3.0f);
        pathBuilder3.reflectiveCurveToRelative(-3.0f, 1.35f, -3.0f, 3.0f);
        pathBuilder3.reflectiveCurveToRelative(1.35f, 3.0f, 3.0f, 3.0f);
        pathBuilder3.close();
        pathBuilder3.moveTo(12.0f, 8.0f);
        pathBuilder4.curveToRelative(0.55f, 0.0f, 1.0f, 0.45f, 1.0f, 1.0f);
        pathBuilder3.reflectiveCurveToRelative(-0.45f, 1.0f, -1.0f, 1.0f);
        pathBuilder3.reflectiveCurveToRelative(-1.0f, -0.45f, -1.0f, -1.0f);
        pathBuilder3.reflectiveCurveToRelative(0.45f, -1.0f, 1.0f, -1.0f);
        pathBuilder3.close();
        pathBuilder3.moveTo(19.0f, 3.0f);
        pathBuilder3.lineTo(5.0f, 3.0f);
        PathBuilder pathBuilder5 = pathBuilder3;
        pathBuilder5.curveToRelative(-1.11f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        pathBuilder3.verticalLineToRelative(14.0f);
        pathBuilder5.curveToRelative(0.0f, 1.1f, 0.89f, 2.0f, 2.0f, 2.0f);
        pathBuilder3.horizontalLineToRelative(14.0f);
        pathBuilder5.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder3.lineTo(21.0f, 5.0f);
        PathBuilder pathBuilder6 = pathBuilder3;
        pathBuilder6.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        pathBuilder3.close();
        pathBuilder3.moveTo(19.0f, 19.0f);
        pathBuilder3.lineTo(5.0f, 19.0f);
        pathBuilder3.lineTo(5.0f, 5.0f);
        pathBuilder3.horizontalLineToRelative(14.0f);
        pathBuilder3.verticalLineToRelative(14.0f);
        pathBuilder3.close();
        pathBuilder3.moveTo(18.0f, 16.47f);
        pathBuilder6.curveToRelative(0.0f, -2.5f, -3.97f, -3.58f, -6.0f, -3.58f);
        pathBuilder3.reflectiveCurveToRelative(-6.0f, 1.08f, -6.0f, 3.58f);
        pathBuilder3.lineTo(6.0f, 18.0f);
        pathBuilder3.horizontalLineToRelative(12.0f);
        pathBuilder3.verticalLineToRelative(-1.53f);
        pathBuilder3.close();
        pathBuilder3.moveTo(8.31f, 16.0f);
        pathBuilder6.curveToRelative(0.69f, -0.56f, 2.38f, -1.12f, 3.69f, -1.12f);
        pathBuilder3.reflectiveCurveToRelative(3.01f, 0.56f, 3.69f, 1.12f);
        pathBuilder3.lineTo(8.31f, 16.0f);
        pathBuilder3.close();
        ImageVector build = ImageVector.Builder.m3522addPathoIyEayM$default(builder, pathBuilder3.getNodes(), defaultFillType2, "", solidColor3, 1.0f, (Brush) null, 1.0f, 1.0f, r38, r39, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _accountBox = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
