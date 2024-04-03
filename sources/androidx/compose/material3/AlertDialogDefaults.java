package androidx.compose.material3;

import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/AlertDialogDefaults;", "", "()V", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "iconContentColor", "getIconContentColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "textContentColor", "getTextContentColor", "titleContentColor", "getTitleContentColor", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AlertDialogDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final AlertDialogDefaults INSTANCE = new AlertDialogDefaults();
    private static final float TonalElevation = DialogTokens.INSTANCE.m2115getContainerElevationD9Ej5fM();

    private AlertDialogDefaults() {
    }

    @Composable
    @JvmName(name = "getContainerColor")
    public final long getContainerColor(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-285850401);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-285850401, i11, -1, "androidx.compose.material3.AlertDialogDefaults.<get-containerColor> (AndroidAlertDialog.android.kt:133)");
        }
        long color = ColorSchemeKt.toColor(DialogTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    @Composable
    @JvmName(name = "getIconContentColor")
    public final long getIconContentColor(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1074292351);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1074292351, i11, -1, "androidx.compose.material3.AlertDialogDefaults.<get-iconContentColor> (AndroidAlertDialog.android.kt:136)");
        }
        long color = ColorSchemeKt.toColor(DialogTokens.INSTANCE.getIconColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    @NotNull
    @Composable
    @JvmName(name = "getShape")
    public final Shape getShape(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-331760525);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-331760525, i11, -1, "androidx.compose.material3.AlertDialogDefaults.<get-shape> (AndroidAlertDialog.android.kt:130)");
        }
        Shape shape = ShapesKt.toShape(DialogTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return shape;
    }

    @Composable
    @JvmName(name = "getTextContentColor")
    public final long getTextContentColor(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1352479489);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1352479489, i11, -1, "androidx.compose.material3.AlertDialogDefaults.<get-textContentColor> (AndroidAlertDialog.android.kt:142)");
        }
        long color = ColorSchemeKt.toColor(DialogTokens.INSTANCE.getSupportingTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    @Composable
    @JvmName(name = "getTitleContentColor")
    public final long getTitleContentColor(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(11981687);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(11981687, i11, -1, "androidx.compose.material3.AlertDialogDefaults.<get-titleContentColor> (AndroidAlertDialog.android.kt:139)");
        }
        long color = ColorSchemeKt.toColor(DialogTokens.INSTANCE.getHeadlineColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return color;
    }

    /* renamed from: getTonalElevation-D9Ej5fM  reason: not valid java name */
    public final float m1492getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }
}
