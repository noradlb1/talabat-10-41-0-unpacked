package androidx.compose.ui.graphics;

import android.graphics.RenderEffect;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Immutable
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/graphics/AndroidRenderEffect;", "Landroidx/compose/ui/graphics/RenderEffect;", "Landroid/graphics/RenderEffect;", "a", "androidRenderEffect", "Landroid/graphics/RenderEffect;", "getAndroidRenderEffect", "()Landroid/graphics/RenderEffect;", "<init>", "(Landroid/graphics/RenderEffect;)V", "ui-graphics_release"}, k = 1, mv = {1, 7, 1})
public final class AndroidRenderEffect extends RenderEffect {
    @NotNull
    private final RenderEffect androidRenderEffect;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidRenderEffect(@NotNull RenderEffect renderEffect) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(renderEffect, "androidRenderEffect");
        this.androidRenderEffect = renderEffect;
    }

    @NotNull
    public RenderEffect a() {
        return this.androidRenderEffect;
    }

    @NotNull
    public final RenderEffect getAndroidRenderEffect() {
        return this.androidRenderEffect;
    }
}
