package com.skydoves.landscapist;

import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import f0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class Shimmer__ShimmerKt$Shimmer$2 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f52975g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Animatable<Float, AnimationVector1D> f52976h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f52977i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f52978j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f52979k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f52980l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Shimmer__ShimmerKt$Shimmer$2(float f11, Animatable<Float, AnimationVector1D> animatable, long j11, long j12, float f12, float f13) {
        super(1);
        this.f52975g = f11;
        this.f52976h = animatable;
        this.f52977i = j11;
        this.f52978j = j12;
        this.f52979k = f12;
        this.f52980l = f13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        Paint paint = (Paint) Shimmer__ShimmerKt.paintPool.acquire();
        if (paint == null) {
            paint = AndroidPaint_androidKt.Paint();
        }
        Paint paint2 = paint;
        Intrinsics.checkNotNullExpressionValue(paint2, "paintPool.acquire() ?: Paint()");
        Matrix matrix = new Matrix();
        float r32 = (float) (((double) Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc())) + (Math.tan(Math.toRadians((double) this.f52975g)) * ((double) Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc()))));
        try {
            float access$offset = Shimmer__ShimmerKt.offset$Shimmer__ShimmerKt(-r32, r32, this.f52976h.getValue().floatValue());
            Shader r42 = ShaderKt.m3220LinearGradientShaderVjE6UOU(OffsetKt.Offset(0.0f, 0.0f), OffsetKt.Offset(Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()), 0.0f), CollectionsKt__CollectionsKt.listOf(Color.m2909boximpl(this.f52977i), Color.m2909boximpl(this.f52978j), Color.m2909boximpl(this.f52978j), Color.m2909boximpl(this.f52977i)), CollectionsKt__CollectionsKt.listOf(Float.valueOf(Math.max(((1.0f - this.f52979k) - this.f52980l) / 2.0f, 0.0f)), Float.valueOf(Math.max(((1.0f - this.f52979k) - 0.001f) / 2.0f, 0.0f)), Float.valueOf(Math.min(((this.f52979k + 1.0f) + 0.001f) / 2.0f, 1.0f)), Float.valueOf(Math.min(((this.f52979k + 1.0f) + this.f52980l) / 2.0f, 1.0f))), TileMode.Companion.m3274getClamp3opZhB0());
            ShaderBrush ShaderBrush = BrushKt.ShaderBrush(r42);
            android.graphics.Paint asFrameworkPaint = paint2.asFrameworkPaint();
            asFrameworkPaint.setAntiAlias(true);
            asFrameworkPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            asFrameworkPaint.setShader(r42);
            matrix.reset();
            matrix.setRotate(this.f52975g, Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()) / 2.0f, Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc()) / 2.0f);
            matrix.postTranslate(access$offset, 0.0f);
            r42.setLocalMatrix(matrix);
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            canvas.saveLayer(SizeKt.m2766toRectuvyYCjk(drawScope.m3425getSizeNHjbRc()), paint2);
            b.J(drawScope, ShaderBrush, OffsetKt.Offset(0.0f, 0.0f), drawScope.m3425getSizeNHjbRc(), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
            canvas.restore();
        } finally {
            paint2.asFrameworkPaint().reset();
            Shimmer__ShimmerKt.paintPool.release(paint2);
        }
    }
}
