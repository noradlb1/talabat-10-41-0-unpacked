package com.skydoves.landscapist.coil;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.lifecycle.LifecycleOwner;
import coil.ImageLoader;
import com.skydoves.landscapist.CircularReveal;
import com.skydoves.landscapist.ShimmerParams;
import com.skydoves.landscapist.palette.BitmapPalette;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CoilImage__CoilImageKt$CoilImage$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f53088g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f53089h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Context f53090i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f53091j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ImageLoader f53092k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Alignment f53093l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f53094m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ContentScale f53095n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f53096o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ CircularReveal f53097p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f53098q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ ShimmerParams f53099r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ BitmapPalette f53100s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Object f53101t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f53102u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f53103v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f53104w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f53105x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoilImage__CoilImageKt$CoilImage$2(Object obj, Modifier modifier, Context context, LifecycleOwner lifecycleOwner, ImageLoader imageLoader, Alignment alignment, float f11, ContentScale contentScale, String str, CircularReveal circularReveal, ColorFilter colorFilter, ShimmerParams shimmerParams, BitmapPalette bitmapPalette, Object obj2, int i11, int i12, int i13, int i14) {
        super(2);
        this.f53088g = obj;
        this.f53089h = modifier;
        this.f53090i = context;
        this.f53091j = lifecycleOwner;
        this.f53092k = imageLoader;
        this.f53093l = alignment;
        this.f53094m = f11;
        this.f53095n = contentScale;
        this.f53096o = str;
        this.f53097p = circularReveal;
        this.f53098q = colorFilter;
        this.f53099r = shimmerParams;
        this.f53100s = bitmapPalette;
        this.f53101t = obj2;
        this.f53102u = i11;
        this.f53103v = i12;
        this.f53104w = i13;
        this.f53105x = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Object obj = this.f53088g;
        Object obj2 = obj;
        CoilImage.CoilImage(obj2, this.f53089h, this.f53090i, this.f53091j, this.f53092k, this.f53093l, this.f53094m, this.f53095n, this.f53096o, this.f53097p, this.f53098q, this.f53099r, this.f53100s, this.f53101t, this.f53102u, composer2, this.f53103v | 1, this.f53104w, this.f53105x);
    }
}
