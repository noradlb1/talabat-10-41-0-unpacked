package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import f0.b;
import f0.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1 extends Lambda implements Function1<CacheDrawScope, DrawResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f3267g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1(long j11) {
        super(1);
        this.f3267g = j11;
    }

    @NotNull
    public final DrawResult invoke(@NotNull CacheDrawScope cacheDrawScope) {
        Intrinsics.checkNotNullParameter(cacheDrawScope, "$this$drawWithCache");
        final float r02 = Size.m2745getWidthimpl(cacheDrawScope.m2573getSizeNHjbRc()) / 2.0f;
        final ImageBitmap createHandleImage = AndroidSelectionHandles_androidKt.createHandleImage(cacheDrawScope, r02);
        final ColorFilter r22 = ColorFilter.Companion.m2960tintxETnrds$default(ColorFilter.Companion, this.f3267g, 0, 2, (Object) null);
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
                Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
                contentDrawScope.drawContent();
                float f11 = r02;
                ImageBitmap imageBitmap = createHandleImage;
                ColorFilter colorFilter = r22;
                DrawContext drawContext = contentDrawScope.getDrawContext();
                long r12 = drawContext.m3403getSizeNHjbRc();
                drawContext.getCanvas().save();
                DrawTransform transform = drawContext.getTransform();
                c.g(transform, f11, 0.0f, 2, (Object) null);
                transform.m3478rotateUv8p0NA(45.0f, Offset.Companion.m2692getZeroF1C5BW0());
                b.A(contentDrawScope, imageBitmap, 0, 0.0f, (DrawStyle) null, colorFilter, 0, 46, (Object) null);
                drawContext.getCanvas().restore();
                drawContext.m3404setSizeuvyYCjk(r12);
            }
        });
    }
}
