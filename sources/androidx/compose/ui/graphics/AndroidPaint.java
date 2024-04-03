package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.Shader;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010J\u001a\u00060$j\u0002`KH\u0016R\u0019\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR-\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00048V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R-\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0006\u001a\u0004\u0018\u00010\u00188V@VX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR-\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0018\u00010&j\u0004\u0018\u0001`'X\u000e¢\u0006\u0002\n\u0000R$\u0010)\u001a\u00020(2\u0006\u0010\u0006\u001a\u00020(8V@VX\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R(\u0010.\u001a\u0004\u0018\u00010-2\b\u0010\u0006\u001a\u0004\u0018\u00010-@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R4\u00103\u001a\n\u0018\u00010&j\u0004\u0018\u0001`'2\u000e\u0010\u0006\u001a\n\u0018\u00010&j\u0004\u0018\u0001`'8V@VX\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R-\u00109\u001a\u0002082\u0006\u0010\u0006\u001a\u0002088V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010\u0011R-\u0010=\u001a\u00020<2\u0006\u0010\u0006\u001a\u00020<8V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b>\u0010\u000f\"\u0004\b?\u0010\u0011R$\u0010@\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u000e¢\u0006\f\u001a\u0004\bA\u0010\n\"\u0004\bB\u0010\fR$\u0010C\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078V@VX\u000e¢\u0006\f\u001a\u0004\bD\u0010\n\"\u0004\bE\u0010\fR-\u0010G\u001a\u00020F2\u0006\u0010\u0006\u001a\u00020F8V@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\bH\u0010\u000f\"\u0004\bI\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006L"}, d2 = {"Landroidx/compose/ui/graphics/AndroidPaint;", "Landroidx/compose/ui/graphics/Paint;", "()V", "_blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "I", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "getFilterQuality-f-v9h1I", "setFilterQuality-vDHp3xo", "internalColorFilter", "internalPaint", "Landroid/graphics/Paint;", "internalShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "", "isAntiAlias", "()Z", "setAntiAlias", "(Z)V", "Landroidx/compose/ui/graphics/PathEffect;", "pathEffect", "getPathEffect", "()Landroidx/compose/ui/graphics/PathEffect;", "setPathEffect", "(Landroidx/compose/ui/graphics/PathEffect;)V", "shader", "getShader", "()Landroid/graphics/Shader;", "setShader", "(Landroid/graphics/Shader;)V", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeCap", "getStrokeCap-KaPHkGw", "setStrokeCap-BeK7IIE", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeJoin", "getStrokeJoin-LxFBmk8", "setStrokeJoin-Ww9F2mQ", "strokeMiterLimit", "getStrokeMiterLimit", "setStrokeMiterLimit", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "Landroidx/compose/ui/graphics/PaintingStyle;", "style", "getStyle-TiuSbCo", "setStyle-k9PVt8s", "asFrameworkPaint", "Landroidx/compose/ui/graphics/NativePaint;", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidPaint implements Paint {
    private int _blendMode = BlendMode.Companion.m2857getSrcOver0nO6VwU();
    @Nullable
    private ColorFilter internalColorFilter;
    @NotNull
    private Paint internalPaint = AndroidPaint_androidKt.makeNativePaint();
    @Nullable
    private Shader internalShader;
    @Nullable
    private PathEffect pathEffect;

    @NotNull
    public Paint asFrameworkPaint() {
        return this.internalPaint;
    }

    public float getAlpha() {
        return AndroidPaint_androidKt.getNativeAlpha(this.internalPaint);
    }

    /* renamed from: getBlendMode-0nO6VwU  reason: not valid java name */
    public int m2790getBlendMode0nO6VwU() {
        return this._blendMode;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public long m2791getColor0d7_KjU() {
        return AndroidPaint_androidKt.getNativeColor(this.internalPaint);
    }

    @Nullable
    public ColorFilter getColorFilter() {
        return this.internalColorFilter;
    }

    /* renamed from: getFilterQuality-f-v9h1I  reason: not valid java name */
    public int m2792getFilterQualityfv9h1I() {
        return AndroidPaint_androidKt.getNativeFilterQuality(this.internalPaint);
    }

    @Nullable
    public PathEffect getPathEffect() {
        return this.pathEffect;
    }

    @Nullable
    public Shader getShader() {
        return this.internalShader;
    }

    /* renamed from: getStrokeCap-KaPHkGw  reason: not valid java name */
    public int m2793getStrokeCapKaPHkGw() {
        return AndroidPaint_androidKt.getNativeStrokeCap(this.internalPaint);
    }

    /* renamed from: getStrokeJoin-LxFBmk8  reason: not valid java name */
    public int m2794getStrokeJoinLxFBmk8() {
        return AndroidPaint_androidKt.getNativeStrokeJoin(this.internalPaint);
    }

    public float getStrokeMiterLimit() {
        return AndroidPaint_androidKt.getNativeStrokeMiterLimit(this.internalPaint);
    }

    public float getStrokeWidth() {
        return AndroidPaint_androidKt.getNativeStrokeWidth(this.internalPaint);
    }

    /* renamed from: getStyle-TiuSbCo  reason: not valid java name */
    public int m2795getStyleTiuSbCo() {
        return AndroidPaint_androidKt.getNativeStyle(this.internalPaint);
    }

    public boolean isAntiAlias() {
        return AndroidPaint_androidKt.getNativeAntiAlias(this.internalPaint);
    }

    public void setAlpha(float f11) {
        AndroidPaint_androidKt.setNativeAlpha(this.internalPaint, f11);
    }

    public void setAntiAlias(boolean z11) {
        AndroidPaint_androidKt.setNativeAntiAlias(this.internalPaint, z11);
    }

    /* renamed from: setBlendMode-s9anfk8  reason: not valid java name */
    public void m2796setBlendModes9anfk8(int i11) {
        this._blendMode = i11;
        AndroidPaint_androidKt.m2802setNativeBlendModeGB0RdKg(this.internalPaint, i11);
    }

    /* renamed from: setColor-8_81llA  reason: not valid java name */
    public void m2797setColor8_81llA(long j11) {
        AndroidPaint_androidKt.m2803setNativeColor4WTKRHQ(this.internalPaint, j11);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.internalColorFilter = colorFilter;
        AndroidPaint_androidKt.setNativeColorFilter(this.internalPaint, colorFilter);
    }

    /* renamed from: setFilterQuality-vDHp3xo  reason: not valid java name */
    public void m2798setFilterQualityvDHp3xo(int i11) {
        AndroidPaint_androidKt.m2804setNativeFilterQuality50PEsBU(this.internalPaint, i11);
    }

    public void setPathEffect(@Nullable PathEffect pathEffect2) {
        AndroidPaint_androidKt.setNativePathEffect(this.internalPaint, pathEffect2);
        this.pathEffect = pathEffect2;
    }

    public void setShader(@Nullable Shader shader) {
        this.internalShader = shader;
        AndroidPaint_androidKt.setNativeShader(this.internalPaint, shader);
    }

    /* renamed from: setStrokeCap-BeK7IIE  reason: not valid java name */
    public void m2799setStrokeCapBeK7IIE(int i11) {
        AndroidPaint_androidKt.m2805setNativeStrokeCapCSYIeUk(this.internalPaint, i11);
    }

    /* renamed from: setStrokeJoin-Ww9F2mQ  reason: not valid java name */
    public void m2800setStrokeJoinWw9F2mQ(int i11) {
        AndroidPaint_androidKt.m2806setNativeStrokeJoinkLtJ_vA(this.internalPaint, i11);
    }

    public void setStrokeMiterLimit(float f11) {
        AndroidPaint_androidKt.setNativeStrokeMiterLimit(this.internalPaint, f11);
    }

    public void setStrokeWidth(float f11) {
        AndroidPaint_androidKt.setNativeStrokeWidth(this.internalPaint, f11);
    }

    /* renamed from: setStyle-k9PVt8s  reason: not valid java name */
    public void m2801setStylek9PVt8s(int i11) {
        AndroidPaint_androidKt.m2807setNativeStyle5YerkU(this.internalPaint, i11);
    }
}
