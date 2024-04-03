package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import f0.b;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JD\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u001bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#J\f\u0010$\u001a\u00020\u0016*\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\u00020\u0013X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/ui/graphics/vector/DrawCache;", "", "()V", "cacheScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "cachedCanvas", "Landroidx/compose/ui/graphics/Canvas;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "mCachedImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "getMCachedImage$annotations", "getMCachedImage", "()Landroidx/compose/ui/graphics/ImageBitmap;", "setMCachedImage", "(Landroidx/compose/ui/graphics/ImageBitmap;)V", "scopeDensity", "Landroidx/compose/ui/unit/Density;", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "drawCachedImage", "", "density", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "drawCachedImage-CJJAR-o", "(JLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)V", "drawInto", "target", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clear", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DrawCache {
    @NotNull
    private final CanvasDrawScope cacheScope = new CanvasDrawScope();
    @Nullable
    private Canvas cachedCanvas;
    @NotNull
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    @Nullable
    private ImageBitmap mCachedImage;
    @Nullable
    private Density scopeDensity;
    private long size = IntSize.Companion.m5643getZeroYbymL2g();

    private final void clear(DrawScope drawScope) {
        b.K(drawScope, Color.Companion.m2945getBlack0d7_KjU(), 0, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.m2830getClear0nO6VwU(), 62, (Object) null);
    }

    public static /* synthetic */ void drawInto$default(DrawCache drawCache, DrawScope drawScope, float f11, ColorFilter colorFilter, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            f11 = 1.0f;
        }
        if ((i11 & 4) != 0) {
            colorFilter = null;
        }
        drawCache.drawInto(drawScope, f11, colorFilter);
    }

    @PublishedApi
    public static /* synthetic */ void getMCachedImage$annotations() {
    }

    /* renamed from: drawCachedImage-CJJAR-o  reason: not valid java name */
    public final void m3517drawCachedImageCJJARo(long j11, @NotNull Density density, @NotNull LayoutDirection layoutDirection2, @NotNull Function1<? super DrawScope, Unit> function1) {
        Density density2 = density;
        LayoutDirection layoutDirection3 = layoutDirection2;
        Function1<? super DrawScope, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(density2, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(layoutDirection3, "layoutDirection");
        Intrinsics.checkNotNullParameter(function12, "block");
        this.scopeDensity = density2;
        this.layoutDirection = layoutDirection3;
        ImageBitmap imageBitmap = this.mCachedImage;
        Canvas canvas = this.cachedCanvas;
        if (imageBitmap == null || canvas == null || IntSize.m5638getWidthimpl(j11) > imageBitmap.getWidth() || IntSize.m5637getHeightimpl(j11) > imageBitmap.getHeight()) {
            imageBitmap = ImageBitmapKt.m3095ImageBitmapx__hDU$default(IntSize.m5638getWidthimpl(j11), IntSize.m5637getHeightimpl(j11), 0, false, (ColorSpace) null, 28, (Object) null);
            canvas = CanvasKt.Canvas(imageBitmap);
            this.mCachedImage = imageBitmap;
            this.cachedCanvas = canvas;
        }
        this.size = j11;
        CanvasDrawScope canvasDrawScope = this.cacheScope;
        long r62 = IntSizeKt.m5648toSizeozmzZPI(j11);
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        Canvas component3 = drawParams.component3();
        long r13 = drawParams.m3375component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        drawParams2.setDensity(density2);
        drawParams2.setLayoutDirection(layoutDirection3);
        drawParams2.setCanvas(canvas);
        drawParams2.m3378setSizeuvyYCjk(r62);
        canvas.save();
        clear(canvasDrawScope);
        function12.invoke(canvasDrawScope);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.m3378setSizeuvyYCjk(r13);
        imageBitmap.prepareToDraw();
    }

    public final void drawInto(@NotNull DrawScope drawScope, float f11, @Nullable ColorFilter colorFilter) {
        boolean z11;
        Intrinsics.checkNotNullParameter(drawScope, "target");
        ImageBitmap imageBitmap = this.mCachedImage;
        if (imageBitmap != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            b.z(drawScope, imageBitmap, 0, this.size, 0, 0, f11, (DrawStyle) null, colorFilter, 0, 0, 858, (Object) null);
            return;
        }
        throw new IllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination".toString());
    }

    @Nullable
    public final ImageBitmap getMCachedImage() {
        return this.mCachedImage;
    }

    public final void setMCachedImage(@Nullable ImageBitmap imageBitmap) {
        this.mCachedImage = imageBitmap;
    }
}
