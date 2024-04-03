package com.skydoves.landscapist.coil;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import coil.ImageLoader;
import coil.request.ImageRequest;
import com.skydoves.landscapist.CircularReveal;
import com.skydoves.landscapist.ShimmerParams;
import com.skydoves.landscapist.coil.CoilImageState;
import com.skydoves.landscapist.palette.BitmapPalette;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CoilImage__CoilImageKt$CoilImage$8 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageRequest f53180g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f53181h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ImageLoader f53182i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Alignment f53183j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ContentScale f53184k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f53185l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f53186m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f53187n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ CircularReveal f53188o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ShimmerParams f53189p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ BitmapPalette f53190q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f53191r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Success, Composer, Integer, Unit> f53192s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Failure, Composer, Integer, Unit> f53193t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f53194u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f53195v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f53196w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoilImage__CoilImageKt$CoilImage$8(ImageRequest imageRequest, Modifier modifier, ImageLoader imageLoader, Alignment alignment, ContentScale contentScale, String str, float f11, ColorFilter colorFilter, CircularReveal circularReveal, ShimmerParams shimmerParams, BitmapPalette bitmapPalette, int i11, Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function3, Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function32, int i12, int i13, int i14) {
        super(2);
        this.f53180g = imageRequest;
        this.f53181h = modifier;
        this.f53182i = imageLoader;
        this.f53183j = alignment;
        this.f53184k = contentScale;
        this.f53185l = str;
        this.f53186m = f11;
        this.f53187n = colorFilter;
        this.f53188o = circularReveal;
        this.f53189p = shimmerParams;
        this.f53190q = bitmapPalette;
        this.f53191r = i11;
        this.f53192s = function3;
        this.f53193t = function32;
        this.f53194u = i12;
        this.f53195v = i13;
        this.f53196w = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        ImageRequest imageRequest = this.f53180g;
        ImageRequest imageRequest2 = imageRequest;
        CoilImage.CoilImage(imageRequest2, this.f53181h, this.f53182i, this.f53183j, this.f53184k, this.f53185l, this.f53186m, this.f53187n, this.f53188o, this.f53189p, this.f53190q, this.f53191r, (Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit>) this.f53192s, (Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit>) this.f53193t, composer2, this.f53194u | 1, this.f53195v, this.f53196w);
    }
}
