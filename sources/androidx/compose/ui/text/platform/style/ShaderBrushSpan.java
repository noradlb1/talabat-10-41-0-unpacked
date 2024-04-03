package androidx.compose.ui.text.platform.style;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR%\u0010\f\u001a\u0004\u0018\u00010\rX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/platform/style/ShaderBrushSpan;", "Landroid/text/style/CharacterStyle;", "Landroid/text/style/UpdateAppearance;", "shaderBrush", "Landroidx/compose/ui/graphics/ShaderBrush;", "alpha", "", "(Landroidx/compose/ui/graphics/ShaderBrush;F)V", "getAlpha", "()F", "getShaderBrush", "()Landroidx/compose/ui/graphics/ShaderBrush;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-VsRJwc0", "()Landroidx/compose/ui/geometry/Size;", "setSize-iaC8Vc4", "(Landroidx/compose/ui/geometry/Size;)V", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {
    private final float alpha;
    @NotNull
    private final ShaderBrush shaderBrush;
    @Nullable
    private Size size;

    public ShaderBrushSpan(@NotNull ShaderBrush shaderBrush2, float f11) {
        Intrinsics.checkNotNullParameter(shaderBrush2, "shaderBrush");
        this.shaderBrush = shaderBrush2;
        this.alpha = f11;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    @NotNull
    public final ShaderBrush getShaderBrush() {
        return this.shaderBrush;
    }

    @Nullable
    /* renamed from: getSize-VsRJwc0  reason: not valid java name */
    public final Size m5272getSizeVsRJwc0() {
        return this.size;
    }

    /* renamed from: setSize-iaC8Vc4  reason: not valid java name */
    public final void m5273setSizeiaC8Vc4(@Nullable Size size2) {
        this.size = size2;
    }

    public void updateDrawState(@Nullable TextPaint textPaint) {
        if (textPaint != null) {
            Size size2 = this.size;
            if (size2 != null) {
                textPaint.setShader(this.shaderBrush.m3217createShaderuvyYCjk(size2.m2750unboximpl()));
            }
            AndroidTextPaint_androidKt.setAlpha(textPaint, this.alpha);
        }
    }
}
