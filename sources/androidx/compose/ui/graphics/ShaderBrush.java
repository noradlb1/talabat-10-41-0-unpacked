package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\u0004H&ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bX\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/ShaderBrush;", "Landroidx/compose/ui/graphics/Brush;", "()V", "createdSize", "Landroidx/compose/ui/geometry/Size;", "J", "internalShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "applyTo", "", "size", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "createShader", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ShaderBrush extends Brush {
    private long createdSize = Size.Companion.m2753getUnspecifiedNHjbRc();
    @Nullable
    private Shader internalShader;

    public ShaderBrush() {
        super((DefaultConstructorMarker) null);
    }

    /* renamed from: applyTo-Pq9zytI  reason: not valid java name */
    public final void m3216applyToPq9zytI(long j11, @NotNull Paint paint, float f11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(paint, "p");
        Shader shader = this.internalShader;
        if (shader == null || !Size.m2741equalsimpl0(this.createdSize, j11)) {
            shader = m3217createShaderuvyYCjk(j11);
            this.internalShader = shader;
            this.createdSize = j11;
        }
        long r52 = paint.m3130getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m2920equalsimpl0(r52, companion.m2945getBlack0d7_KjU())) {
            paint.m3136setColor8_81llA(companion.m2945getBlack0d7_KjU());
        }
        if (!Intrinsics.areEqual((Object) paint.getShader(), (Object) shader)) {
            paint.setShader(shader);
        }
        if (paint.getAlpha() == f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            paint.setAlpha(f11);
        }
    }

    @NotNull
    /* renamed from: createShader-uvyYCjk  reason: not valid java name */
    public abstract Shader m3217createShaderuvyYCjk(long j11);
}
