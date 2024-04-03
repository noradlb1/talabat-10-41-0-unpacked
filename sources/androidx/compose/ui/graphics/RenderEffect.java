package androidx.compose.ui.graphics;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H%J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/graphics/RenderEffect;", "", "Landroid/graphics/RenderEffect;", "asAndroidRenderEffect", "a", "", "isSupported", "internalRenderEffect", "Landroid/graphics/RenderEffect;", "<init>", "()V", "Landroidx/compose/ui/graphics/AndroidRenderEffect;", "Landroidx/compose/ui/graphics/BlurEffect;", "Landroidx/compose/ui/graphics/OffsetEffect;", "ui-graphics_release"}, k = 1, mv = {1, 7, 1})
public abstract class RenderEffect {
    @Nullable
    private android.graphics.RenderEffect internalRenderEffect;

    private RenderEffect() {
    }

    public /* synthetic */ RenderEffect(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @RequiresApi(31)
    @NotNull
    public abstract android.graphics.RenderEffect a();

    @RequiresApi(31)
    @NotNull
    public final android.graphics.RenderEffect asAndroidRenderEffect() {
        android.graphics.RenderEffect renderEffect = this.internalRenderEffect;
        if (renderEffect != null) {
            return renderEffect;
        }
        android.graphics.RenderEffect a11 = a();
        this.internalRenderEffect = a11;
        return a11;
    }

    public boolean isSupported() {
        return Build.VERSION.SDK_INT >= 31;
    }
}
