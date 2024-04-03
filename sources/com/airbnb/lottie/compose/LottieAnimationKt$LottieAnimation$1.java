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
public final class LottieAnimationKt$LottieAnimation$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LottieComposition f40515g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ float f40516h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f40517i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f40518j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f40519k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f40520l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ RenderMode f40521m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f40522n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ LottieDynamicProperties f40523o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Alignment f40524p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ ContentScale f40525q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f40526r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f40527s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f40528t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f40529u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieAnimationKt$LottieAnimation$1(LottieComposition lottieComposition, float f11, Modifier modifier, boolean z11, boolean z12, boolean z13, RenderMode renderMode, boolean z14, LottieDynamicProperties lottieDynamicProperties, Alignment alignment, ContentScale contentScale, boolean z15, int i11, int i12, int i13) {
        super(2);
        this.f40515g = lottieComposition;
        this.f40516h = f11;
        this.f40517i = modifier;
        this.f40518j = z11;
        this.f40519k = z12;
        this.f40520l = z13;
        this.f40521m = renderMode;
        this.f40522n = z14;
        this.f40523o = lottieDynamicProperties;
        this.f40524p = alignment;
        this.f40525q = contentScale;
        this.f40526r = z15;
        this.f40527s = i11;
        this.f40528t = i12;
        this.f40529u = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        LottieAnimationKt.LottieAnimation(this.f40515g, this.f40516h, this.f40517i, this.f40518j, this.f40519k, this.f40520l, this.f40521m, this.f40522n, this.f40523o, this.f40524p, this.f40525q, this.f40526r, composer, this.f40527s | 1, this.f40528t, this.f40529u);
    }
}
