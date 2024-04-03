package com.skydoves.landscapist.coil;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import coil.ImageLoader;
import coil.request.ImageRequest;
import com.skydoves.landscapist.CircularReveal;
import com.skydoves.landscapist.coil.CoilImageState;
import com.skydoves.landscapist.palette.BitmapPalette;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CoilImage__CoilImageKt$CoilImage$11 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageRequest f53021g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f53022h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ImageLoader f53023i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Alignment f53024j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ContentScale f53025k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f53026l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f53027m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f53028n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ CircularReveal f53029o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ BitmapPalette f53030p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f53031q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Loading, Composer, Integer, Unit> f53032r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Success, Composer, Integer, Unit> f53033s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Failure, Composer, Integer, Unit> f53034t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f53035u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f53036v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f53037w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoilImage__CoilImageKt$CoilImage$11(ImageRequest imageRequest, Modifier modifier, ImageLoader imageLoader, Alignment alignment, ContentScale contentScale, String str, float f11, ColorFilter colorFilter, CircularReveal circularReveal, BitmapPalette bitmapPalette, int i11, Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit> function3, Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function32, Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function33, int i12, int i13, int i14) {
        super(2);
        this.f53021g = imageRequest;
        this.f53022h = modifier;
        this.f53023i = imageLoader;
        this.f53024j = alignment;
        this.f53025k = contentScale;
        this.f53026l = str;
        this.f53027m = f11;
        this.f53028n = colorFilter;
        this.f53029o = circularReveal;
        this.f53030p = bitmapPalette;
        this.f53031q = i11;
        this.f53032r = function3;
        this.f53033s = function32;
        this.f53034t = function33;
        this.f53035u = i12;
        this.f53036v = i13;
        this.f53037w = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        ImageRequest imageRequest = this.f53021g;
        ImageRequest imageRequest2 = imageRequest;
        CoilImage.CoilImage(imageRequest2, this.f53022h, this.f53023i, this.f53024j, this.f53025k, this.f53026l, this.f53027m, this.f53028n, this.f53029o, this.f53030p, this.f53031q, (Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit>) this.f53032r, (Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit>) this.f53033s, (Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit>) this.f53034t, composer2, this.f53035u | 1, this.f53036v, this.f53037w);
    }
}
