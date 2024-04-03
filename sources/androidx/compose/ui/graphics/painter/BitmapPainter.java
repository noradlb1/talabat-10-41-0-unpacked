package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import f0.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004ø\u0001\u0001¢\u0006\u0004\b,\u0010-J%\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u000b\u001a\u00020\n*\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0014J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\u0013\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0003\u001a\u00020\u00028\u0002X\u0004ø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u001d\u0010\u0005\u001a\u00020\u00048\u0002X\u0004ø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR+\u0010\u001f\u001a\u00020\u001e8\u0000@\u0000X\u000eø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001d\u0010%\u001a\u00020\u00048\u0002X\u0004ø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0006\n\u0004\b%\u0010\u001dR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010&R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010'R\u001d\u0010+\u001a\u00020(8VX\u0004ø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b)\u0010*\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/ui/graphics/painter/BitmapPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/ui/unit/IntOffset;", "srcOffset", "Landroidx/compose/ui/unit/IntSize;", "srcSize", "validateSize-N5eqBDc", "(JJ)J", "validateSize", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "d", "", "alpha", "", "a", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "b", "", "other", "equals", "", "hashCode", "", "toString", "Landroidx/compose/ui/graphics/ImageBitmap;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "J", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "I", "getFilterQuality-f-v9h1I$ui_graphics_release", "()I", "setFilterQuality-vDHp3xo$ui_graphics_release", "(I)V", "size", "F", "Landroidx/compose/ui/graphics/ColorFilter;", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "intrinsicSize", "<init>", "(Landroidx/compose/ui/graphics/ImageBitmap;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "ui-graphics_release"}, k = 1, mv = {1, 7, 1})
public final class BitmapPainter extends Painter {
    private float alpha;
    @Nullable
    private ColorFilter colorFilter;
    private int filterQuality;
    @NotNull
    private final ImageBitmap image;
    private final long size;
    private final long srcOffset;
    private final long srcSize;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j11, long j12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, (i11 & 2) != 0 ? IntOffset.Companion.m5606getZeronOccac() : j11, (i11 & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j12, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, j11, j12);
    }

    /* renamed from: validateSize-N5eqBDc  reason: not valid java name */
    private final long m3505validateSizeN5eqBDc(long j11, long j12) {
        boolean z11;
        if (IntOffset.m5596getXimpl(j11) < 0 || IntOffset.m5597getYimpl(j11) < 0 || IntSize.m5638getWidthimpl(j12) < 0 || IntSize.m5637getHeightimpl(j12) < 0 || IntSize.m5638getWidthimpl(j12) > this.image.getWidth() || IntSize.m5637getHeightimpl(j12) > this.image.getHeight()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return j12;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public boolean a(float f11) {
        this.alpha = f11;
        return true;
    }

    public boolean b(@Nullable ColorFilter colorFilter2) {
        this.colorFilter = colorFilter2;
        return true;
    }

    public void d(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        b.z(drawScope, this.image, this.srcOffset, this.srcSize, 0, IntSizeKt.IntSize(MathKt__MathJVMKt.roundToInt(Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc())), MathKt__MathJVMKt.roundToInt(Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc()))), this.alpha, (DrawStyle) null, this.colorFilter, 0, this.filterQuality, 328, (Object) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BitmapPainter)) {
            return false;
        }
        BitmapPainter bitmapPainter = (BitmapPainter) obj;
        if (Intrinsics.areEqual((Object) this.image, (Object) bitmapPainter.image) && IntOffset.m5595equalsimpl0(this.srcOffset, bitmapPainter.srcOffset) && IntSize.m5636equalsimpl0(this.srcSize, bitmapPainter.srcSize) && FilterQuality.m3000equalsimpl0(this.filterQuality, bitmapPainter.filterQuality)) {
            return true;
        }
        return false;
    }

    /* renamed from: getFilterQuality-f-v9h1I$ui_graphics_release  reason: not valid java name */
    public final int m3506getFilterQualityfv9h1I$ui_graphics_release() {
        return this.filterQuality;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m3507getIntrinsicSizeNHjbRc() {
        return IntSizeKt.m5648toSizeozmzZPI(this.size);
    }

    public int hashCode() {
        return (((((this.image.hashCode() * 31) + IntOffset.m5598hashCodeimpl(this.srcOffset)) * 31) + IntSize.m5639hashCodeimpl(this.srcSize)) * 31) + FilterQuality.m3001hashCodeimpl(this.filterQuality);
    }

    /* renamed from: setFilterQuality-vDHp3xo$ui_graphics_release  reason: not valid java name */
    public final void m3508setFilterQualityvDHp3xo$ui_graphics_release(int i11) {
        this.filterQuality = i11;
    }

    @NotNull
    public String toString() {
        return "BitmapPainter(image=" + this.image + ", srcOffset=" + IntOffset.m5603toStringimpl(this.srcOffset) + ", srcSize=" + IntSize.m5641toStringimpl(this.srcSize) + ", filterQuality=" + FilterQuality.m3002toStringimpl(this.filterQuality) + ')';
    }

    private BitmapPainter(ImageBitmap imageBitmap, long j11, long j12) {
        this.image = imageBitmap;
        this.srcOffset = j11;
        this.srcSize = j12;
        this.filterQuality = FilterQuality.Companion.m3005getLowfv9h1I();
        this.size = m3505validateSizeN5eqBDc(j11, j12);
        this.alpha = 1.0f;
    }
}
