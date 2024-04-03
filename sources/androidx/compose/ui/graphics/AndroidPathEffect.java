package androidx.compose.ui.graphics;

import android.graphics.PathEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/AndroidPathEffect;", "Landroidx/compose/ui/graphics/PathEffect;", "nativePathEffect", "Landroid/graphics/PathEffect;", "(Landroid/graphics/PathEffect;)V", "getNativePathEffect", "()Landroid/graphics/PathEffect;", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidPathEffect implements PathEffect {
    @NotNull
    private final PathEffect nativePathEffect;

    public AndroidPathEffect(@NotNull PathEffect pathEffect) {
        Intrinsics.checkNotNullParameter(pathEffect, "nativePathEffect");
        this.nativePathEffect = pathEffect;
    }

    @NotNull
    public final PathEffect getNativePathEffect() {
        return this.nativePathEffect;
    }
}
