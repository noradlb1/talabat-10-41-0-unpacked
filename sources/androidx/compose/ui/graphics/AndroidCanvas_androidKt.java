package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import com.apptimize.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00060\u0001j\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006*\n\u0010\f\"\u00020\u00012\u00020\u0001¨\u0006\r"}, d2 = {"EmptyCanvas", "Landroid/graphics/Canvas;", "nativeCanvas", "Landroidx/compose/ui/graphics/NativeCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "getNativeCanvas", "(Landroidx/compose/ui/graphics/Canvas;)Landroid/graphics/Canvas;", "ActualCanvas", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "Canvas", "c", "NativeCanvas", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidCanvas_androidKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final Canvas EmptyCanvas = new Canvas();

    @NotNull
    public static final Canvas ActualCanvas(@NotNull ImageBitmap imageBitmap) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        AndroidCanvas androidCanvas = new AndroidCanvas();
        androidCanvas.setInternalCanvas(new Canvas(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap)));
        return androidCanvas;
    }

    @NotNull
    public static final Canvas Canvas(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, c.f41585a);
        AndroidCanvas androidCanvas = new AndroidCanvas();
        androidCanvas.setInternalCanvas(canvas);
        return androidCanvas;
    }

    @NotNull
    public static final Canvas getNativeCanvas(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        return ((AndroidCanvas) canvas).getInternalCanvas();
    }
}
