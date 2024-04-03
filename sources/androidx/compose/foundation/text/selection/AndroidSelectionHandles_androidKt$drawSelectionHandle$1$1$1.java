package androidx.compose.foundation.text.selection;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import f0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1 extends Lambda implements Function1<CacheDrawScope, DrawResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f3653g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f3654h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ResolvedTextDirection f3655i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f3656j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1(long j11, boolean z11, ResolvedTextDirection resolvedTextDirection, boolean z12) {
        super(1);
        this.f3653g = j11;
        this.f3654h = z11;
        this.f3655i = resolvedTextDirection;
        this.f3656j = z12;
    }

    @NotNull
    public final DrawResult invoke(@NotNull CacheDrawScope cacheDrawScope) {
        Intrinsics.checkNotNullParameter(cacheDrawScope, "$this$drawWithCache");
        final ImageBitmap createHandleImage = AndroidSelectionHandles_androidKt.createHandleImage(cacheDrawScope, Size.m2745getWidthimpl(cacheDrawScope.m2573getSizeNHjbRc()) / 2.0f);
        final ColorFilter r62 = ColorFilter.Companion.m2960tintxETnrds$default(ColorFilter.Companion, this.f3653g, 0, 2, (Object) null);
        final boolean z11 = this.f3654h;
        final ResolvedTextDirection resolvedTextDirection = this.f3655i;
        final boolean z12 = this.f3656j;
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
                Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
                contentDrawScope.drawContent();
                if (AndroidSelectionHandles_androidKt.isLeft(z11, resolvedTextDirection, z12)) {
                    ImageBitmap imageBitmap = createHandleImage;
                    ColorFilter colorFilter = r62;
                    long r02 = contentDrawScope.m3424getCenterF1C5BW0();
                    DrawContext drawContext = contentDrawScope.getDrawContext();
                    long r12 = drawContext.m3403getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    drawContext.getTransform().m3479scale0AR0LA0(-1.0f, 1.0f, r02);
                    b.A(contentDrawScope, imageBitmap, 0, 0.0f, (DrawStyle) null, colorFilter, 0, 46, (Object) null);
                    drawContext.getCanvas().restore();
                    drawContext.m3404setSizeuvyYCjk(r12);
                    return;
                }
                b.A(contentDrawScope, createHandleImage, 0, 0.0f, (DrawStyle) null, r62, 0, 46, (Object) null);
            }
        });
    }
}
