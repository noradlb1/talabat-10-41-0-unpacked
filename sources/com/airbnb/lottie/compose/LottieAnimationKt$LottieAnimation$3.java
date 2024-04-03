package com.airbnb.lottie.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.RenderMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class LottieAnimationKt$LottieAnimation$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LottieComposition f40544g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f40545h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f40546i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f40547j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f40548k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f40549l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ RenderMode f40550m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f40551n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ LottieDynamicProperties f40552o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Alignment f40553p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ ContentScale f40554q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f40555r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f40556s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f40557t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f40558u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieAnimationKt$LottieAnimation$3(LottieComposition lottieComposition, float f11, Modifier modifier, boolean z11, boolean z12, boolean z13, RenderMode renderMode, boolean z14, LottieDynamicProperties lottieDynamicProperties, Alignment alignment, ContentScale contentScale, boolean z15, int i11, int i12, int i13) {
        super(2);
        this.f40544g = lottieComposition;
        this.f40545h = f11;
        this.f40546i = modifier;
        this.f40547j = z11;
        this.f40548k = z12;
        this.f40549l = z13;
        this.f40550m = renderMode;
        this.f40551n = z14;
        this.f40552o = lottieDynamicProperties;
        this.f40553p = alignment;
        this.f40554q = contentScale;
        this.f40555r = z15;
        this.f40556s = i11;
        this.f40557t = i12;
        this.f40558u = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LottieAnimationKt.LottieAnimation(this.f40544g, this.f40545h, this.f40546i, this.f40547j, this.f40548k, this.f40549l, this.f40550m, this.f40551n, this.f40552o, this.f40553p, this.f40554q, this.f40555r, composer, this.f40556s | 1, this.f40557t, this.f40558u);
    }
}
