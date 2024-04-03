package com.airbnb.lottie.compose;

import android.graphics.Matrix;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.RenderMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class LottieAnimationKt$LottieAnimation$2 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LottieComposition f40530g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ContentScale f40531h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Alignment f40532i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Matrix f40533j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f40534k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f40535l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ RenderMode f40536m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ LottieDynamicProperties f40537n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f40538o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f40539p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ boolean f40540q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f40541r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ float f40542s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ MutableState<LottieDynamicProperties> f40543t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieAnimationKt$LottieAnimation$2(LottieComposition lottieComposition, ContentScale contentScale, Alignment alignment, Matrix matrix, LottieDrawable lottieDrawable, boolean z11, RenderMode renderMode, LottieDynamicProperties lottieDynamicProperties, boolean z12, boolean z13, boolean z14, boolean z15, float f11, MutableState<LottieDynamicProperties> mutableState) {
        super(1);
        this.f40530g = lottieComposition;
        this.f40531h = contentScale;
        this.f40532i = alignment;
        this.f40533j = matrix;
        this.f40534k = lottieDrawable;
        this.f40535l = z11;
        this.f40536m = renderMode;
        this.f40537n = lottieDynamicProperties;
        this.f40538o = z12;
        this.f40539p = z13;
        this.f40540q = z14;
        this.f40541r = z15;
        this.f40542s = f11;
        this.f40543t = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        LottieComposition lottieComposition = this.f40530g;
        ContentScale contentScale = this.f40531h;
        Alignment alignment = this.f40532i;
        Matrix matrix = this.f40533j;
        LottieDrawable lottieDrawable = this.f40534k;
        boolean z11 = this.f40535l;
        RenderMode renderMode = this.f40536m;
        LottieDynamicProperties lottieDynamicProperties = this.f40537n;
        boolean z12 = this.f40538o;
        boolean z13 = this.f40539p;
        boolean z14 = this.f40540q;
        boolean z15 = this.f40541r;
        float f11 = this.f40542s;
        MutableState<LottieDynamicProperties> mutableState = this.f40543t;
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        float f12 = f11;
        MutableState<LottieDynamicProperties> mutableState2 = mutableState;
        long Size = SizeKt.Size((float) lottieComposition.getBounds().width(), (float) lottieComposition.getBounds().height());
        long IntSize = IntSizeKt.IntSize(MathKt__MathJVMKt.roundToInt(Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc())), MathKt__MathJVMKt.roundToInt(Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc())));
        boolean z16 = z14;
        long r72 = contentScale.m4442computeScaleFactorH7hwNQA(Size, drawScope.m3425getSizeNHjbRc());
        long r52 = LottieAnimationKt.m9146timesUQTWf7w(Size, r72);
        boolean z17 = z16;
        float f13 = f12;
        boolean z18 = z17;
        long j11 = r72;
        long j12 = IntSize;
        boolean z19 = z15;
        boolean z21 = z13;
        long r32 = alignment.m2554alignKFBX0sM(r52, j12, drawScope.getLayoutDirection());
        matrix.reset();
        matrix.preTranslate((float) IntOffset.m5596getXimpl(r32), (float) IntOffset.m5597getYimpl(r32));
        matrix.preScale(ScaleFactor.m4549getScaleXimpl(j11), ScaleFactor.m4550getScaleYimpl(j11));
        lottieDrawable.enableMergePathsForKitKatAndAbove(z11);
        lottieDrawable.setRenderMode(renderMode);
        lottieDrawable.setComposition(lottieComposition);
        if (lottieDynamicProperties != LottieAnimationKt.m9140LottieAnimation$lambda3(mutableState2)) {
            LottieDynamicProperties r33 = LottieAnimationKt.m9140LottieAnimation$lambda3(mutableState2);
            if (r33 != null) {
                r33.removeFrom$lottie_compose_release(lottieDrawable);
            }
            if (lottieDynamicProperties != null) {
                lottieDynamicProperties.addTo$lottie_compose_release(lottieDrawable);
            }
            LottieAnimationKt.m9141LottieAnimation$lambda4(mutableState2, lottieDynamicProperties);
        }
        lottieDrawable.setOutlineMasksAndMattes(z12);
        lottieDrawable.setApplyingOpacityToLayersEnabled(z21);
        lottieDrawable.setMaintainOriginalImageBounds(z18);
        lottieDrawable.setClipToCompositionBounds(z19);
        lottieDrawable.setProgress(f12);
        lottieDrawable.setBounds(0, 0, lottieComposition.getBounds().width(), lottieComposition.getBounds().height());
        lottieDrawable.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas), matrix);
    }
}
