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
public final class LottieAnimationKt$LottieAnimation$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LottieComposition f40559g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f40560h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f40561i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f40562j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LottieClipSpec f40563k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f40564l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f40565m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f40566n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f40567o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f40568p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ RenderMode f40569q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f40570r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ LottieDynamicProperties f40571s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Alignment f40572t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ ContentScale f40573u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ boolean f40574v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f40575w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f40576x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f40577y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LottieAnimationKt$LottieAnimation$4(LottieComposition lottieComposition, Modifier modifier, boolean z11, boolean z12, LottieClipSpec lottieClipSpec, float f11, int i11, boolean z13, boolean z14, boolean z15, RenderMode renderMode, boolean z16, LottieDynamicProperties lottieDynamicProperties, Alignment alignment, ContentScale contentScale, boolean z17, int i12, int i13, int i14) {
        super(2);
        this.f40559g = lottieComposition;
        this.f40560h = modifier;
        this.f40561i = z11;
        this.f40562j = z12;
        this.f40563k = lottieClipSpec;
        this.f40564l = f11;
        this.f40565m = i11;
        this.f40566n = z13;
        this.f40567o = z14;
        this.f40568p = z15;
        this.f40569q = renderMode;
        this.f40570r = z16;
        this.f40571s = lottieDynamicProperties;
        this.f40572t = alignment;
        this.f40573u = contentScale;
        this.f40574v = z17;
        this.f40575w = i12;
        this.f40576x = i13;
        this.f40577y = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        LottieComposition lottieComposition = this.f40559g;
        LottieComposition lottieComposition2 = lottieComposition;
        LottieAnimationKt.LottieAnimation(lottieComposition2, this.f40560h, this.f40561i, this.f40562j, this.f40563k, this.f40564l, this.f40565m, this.f40566n, this.f40567o, this.f40568p, this.f40569q, this.f40570r, this.f40571s, this.f40572t, this.f40573u, this.f40574v, composer2, this.f40575w | 1, this.f40576x, this.f40577y);
    }
}
