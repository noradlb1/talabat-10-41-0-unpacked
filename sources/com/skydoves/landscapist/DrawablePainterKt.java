package com.skydoves.landscapist;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.ColorPainter;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\n\"\u001b\u0010\u0000\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u000b"}, d2 = {"MAIN_HANDLER", "Landroid/os/Handler;", "getMAIN_HANDLER", "()Landroid/os/Handler;", "MAIN_HANDLER$delegate", "Lkotlin/Lazy;", "rememberDrawablePainter", "Landroidx/compose/ui/graphics/painter/Painter;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "landscapist_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DrawablePainterKt {
    @NotNull
    private static final Lazy MAIN_HANDLER$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, DrawablePainterKt$MAIN_HANDLER$2.INSTANCE);

    /* access modifiers changed from: private */
    public static final Handler getMAIN_HANDLER() {
        return (Handler) MAIN_HANDLER$delegate.getValue();
    }

    @NotNull
    @Composable
    public static final Painter rememberDrawablePainter(@Nullable Drawable drawable, @Nullable Composer composer, int i11) {
        Object obj;
        composer.startReplaceableGroup(-516480828);
        composer.startReplaceableGroup(-3686930);
        boolean changed = composer.changed((Object) drawable);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            if (drawable == null) {
                rememberedValue = EmptyPainter.INSTANCE;
            } else if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "drawable.bitmap");
                rememberedValue = new BitmapPainter(AndroidImageBitmap_androidKt.asImageBitmap(bitmap), 0, 0, 6, (DefaultConstructorMarker) null);
            } else {
                if (drawable instanceof ColorDrawable) {
                    obj = new ColorPainter(ColorKt.Color(((ColorDrawable) drawable).getColor()), (DefaultConstructorMarker) null);
                } else {
                    Drawable mutate = drawable.mutate();
                    Intrinsics.checkNotNullExpressionValue(mutate, "drawable.mutate()");
                    obj = new DrawablePainter(mutate);
                }
                rememberedValue = obj;
            }
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Painter painter = (Painter) rememberedValue;
        composer.endReplaceableGroup();
        return painter;
    }
}
