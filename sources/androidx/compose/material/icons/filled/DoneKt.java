package androidx.compose.material.icons.filled;

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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_done", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Done", "Landroidx/compose/material/icons/Icons$Filled;", "getDone", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DoneKt {
    @Nullable
    private static ImageVector _done;

    @NotNull
    public static final ImageVector getDone(@NotNull Icons.Filled filled) {
        Intrinsics.checkNotNullParameter(filled, "<this>");
        ImageVector imageVector = _done;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = r1;
        ImageVector.Builder builder2 = new ImageVector.Builder("Filled.Done", Dp.m5478constructorimpl(24.0f), Dp.m5478constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, 96, (DefaultConstructorMarker) null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = r0;
        SolidColor solidColor2 = new SolidColor(Color.Companion.m2945getBlack0d7_KjU(), (DefaultConstructorMarker) null);
        int r21 = StrokeCap.Companion.m3253getButtKaPHkGw();
        int r22 = StrokeJoin.Companion.m3263getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(9.0f, 16.2f);
        pathBuilder.lineTo(4.8f, 12.0f);
        pathBuilder.lineToRelative(-1.4f, 1.4f);
        pathBuilder.lineTo(9.0f, 19.0f);
        pathBuilder.lineTo(21.0f, 7.0f);
        pathBuilder.lineToRelative(-1.4f, -1.4f);
        pathBuilder.lineTo(9.0f, 16.2f);
        pathBuilder.close();
        ImageVector build = ImageVector.Builder.m3522addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, 1.0f, (Brush) null, 1.0f, 1.0f, r21, r22, 1.0f, 0.0f, 0.0f, 0.0f, 14336, (Object) null).build();
        _done = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
