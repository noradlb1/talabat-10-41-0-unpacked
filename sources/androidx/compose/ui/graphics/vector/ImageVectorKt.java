package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.vector.ImageVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\b\u0012H\bø\u0001\u0000\u001a\u0001\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020 2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\b\u0012H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b#\u0010$\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006%"}, d2 = {"group", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "name", "", "rotate", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "path", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "path-R_LF-3I", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;Ljava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ImageVectorKt {
    @NotNull
    public static final ImageVector.Builder group(@NotNull ImageVector.Builder builder, @NotNull String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, @NotNull List<? extends PathNode> list, @NotNull Function1<? super ImageVector.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "clipPathData");
        Intrinsics.checkNotNullParameter(function1, "block");
        builder.addGroup(str, f11, f12, f13, f14, f15, f16, f17, list);
        function1.invoke(builder);
        builder.clearGroup();
        return builder;
    }

    public static /* synthetic */ ImageVector.Builder group$default(ImageVector.Builder builder, String str, float f11, float f12, float f13, float f14, float f15, float f16, float f17, List list, Function1 function1, int i11, Object obj) {
        String str2;
        float f18;
        float f19;
        float f21;
        float f22;
        float f23;
        float f24;
        List<PathNode> list2;
        ImageVector.Builder builder2 = builder;
        Function1 function12 = function1;
        int i12 = i11;
        if ((i12 & 1) != 0) {
            str2 = "";
        } else {
            str2 = str;
        }
        if ((i12 & 2) != 0) {
            f18 = 0.0f;
        } else {
            f18 = f11;
        }
        if ((i12 & 4) != 0) {
            f19 = 0.0f;
        } else {
            f19 = f12;
        }
        if ((i12 & 8) != 0) {
            f21 = 0.0f;
        } else {
            f21 = f13;
        }
        float f25 = 1.0f;
        if ((i12 & 16) != 0) {
            f22 = 1.0f;
        } else {
            f22 = f14;
        }
        if ((i12 & 32) == 0) {
            f25 = f15;
        }
        if ((i12 & 64) != 0) {
            f23 = 0.0f;
        } else {
            f23 = f16;
        }
        if ((i12 & 128) != 0) {
            f24 = 0.0f;
        } else {
            f24 = f17;
        }
        if ((i12 & 256) != 0) {
            list2 = VectorKt.getEmptyPath();
        } else {
            list2 = list;
        }
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(list2, "clipPathData");
        Intrinsics.checkNotNullParameter(function12, "block");
        builder.addGroup(str2, f18, f19, f21, f22, f25, f23, f24, list2);
        function12.invoke(builder);
        builder.clearGroup();
        return builder2;
    }

    @NotNull
    /* renamed from: path-R_LF-3I  reason: not valid java name */
    public static final ImageVector.Builder m3524pathR_LF3I(@NotNull ImageVector.Builder builder, @NotNull String str, @Nullable Brush brush, float f11, @Nullable Brush brush2, float f12, float f13, int i11, int i12, float f14, int i13, @NotNull Function1<? super PathBuilder, Unit> function1) {
        Function1<? super PathBuilder, Unit> function12 = function1;
        int i14 = i13;
        Intrinsics.checkNotNullParameter(builder, "$this$path");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function12, "pathBuilder");
        PathBuilder pathBuilder = new PathBuilder();
        function12.invoke(pathBuilder);
        return ImageVector.Builder.m3522addPathoIyEayM$default(builder, pathBuilder.getNodes(), i14, str, brush, f11, brush2, f12, f13, i11, i12, f14, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
    }

    /* renamed from: path-R_LF-3I$default  reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m3525pathR_LF3I$default(ImageVector.Builder builder, String str, Brush brush, float f11, Brush brush2, float f12, float f13, int i11, int i12, float f14, int i13, Function1 function1, int i14, Object obj) {
        String str2;
        Brush brush3;
        float f15;
        Brush brush4;
        float f16;
        float f17;
        int i15;
        int i16;
        float f18;
        int i17;
        Function1 function12 = function1;
        int i18 = i14;
        if ((i18 & 1) != 0) {
            str2 = "";
        } else {
            str2 = str;
        }
        if ((i18 & 2) != 0) {
            brush3 = null;
        } else {
            brush3 = brush;
        }
        if ((i18 & 4) != 0) {
            f15 = 1.0f;
        } else {
            f15 = f11;
        }
        if ((i18 & 8) != 0) {
            brush4 = null;
        } else {
            brush4 = brush2;
        }
        if ((i18 & 16) != 0) {
            f16 = 1.0f;
        } else {
            f16 = f12;
        }
        if ((i18 & 32) != 0) {
            f17 = 0.0f;
        } else {
            f17 = f13;
        }
        if ((i18 & 64) != 0) {
            i15 = VectorKt.getDefaultStrokeLineCap();
        } else {
            i15 = i11;
        }
        if ((i18 & 128) != 0) {
            i16 = VectorKt.getDefaultStrokeLineJoin();
        } else {
            i16 = i12;
        }
        if ((i18 & 256) != 0) {
            f18 = 4.0f;
        } else {
            f18 = f14;
        }
        if ((i18 & 512) != 0) {
            i17 = VectorKt.getDefaultFillType();
        } else {
            i17 = i13;
        }
        Intrinsics.checkNotNullParameter(builder, "$this$path");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(function12, "pathBuilder");
        PathBuilder pathBuilder = new PathBuilder();
        function12.invoke(pathBuilder);
        return ImageVector.Builder.m3522addPathoIyEayM$default(builder, pathBuilder.getNodes(), i17, str2, brush3, f15, brush4, f16, f17, i15, i16, f18, 0.0f, 0.0f, 0.0f, 14336, (Object) null);
    }
}
