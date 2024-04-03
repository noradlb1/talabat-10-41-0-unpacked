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
public final class CoilImage__CoilImageKt$CoilImage$10 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageRequest f53004g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f53005h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ImageLoader f53006i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Alignment f53007j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ContentScale f53008k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f53009l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f53010m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f53011n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ CircularReveal f53012o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ShimmerParams f53013p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ BitmapPalette f53014q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f53015r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Success, Composer, Integer, Unit> f53016s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Failure, Composer, Integer, Unit> f53017t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f53018u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f53019v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f53020w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoilImage__CoilImageKt$CoilImage$10(ImageRequest imageRequest, Modifier modifier, ImageLoader imageLoader, Alignment alignment, ContentScale contentScale, String str, float f11, ColorFilter colorFilter, CircularReveal circularReveal, ShimmerParams shimmerParams, BitmapPalette bitmapPalette, int i11, Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function3, Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function32, int i12, int i13, int i14) {
        super(2);
        this.f53004g = imageRequest;
        this.f53005h = modifier;
        this.f53006i = imageLoader;
        this.f53007j = alignment;
        this.f53008k = contentScale;
        this.f53009l = str;
        this.f53010m = f11;
        this.f53011n = colorFilter;
        this.f53012o = circularReveal;
        this.f53013p = shimmerParams;
        this.f53014q = bitmapPalette;
        this.f53015r = i11;
        this.f53016s = function3;
        this.f53017t = function32;
        this.f53018u = i12;
        this.f53019v = i13;
        this.f53020w = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        ImageRequest imageRequest = this.f53004g;
        ImageRequest imageRequest2 = imageRequest;
        CoilImage.CoilImage(imageRequest2, this.f53005h, this.f53006i, this.f53007j, this.f53008k, this.f53009l, this.f53010m, this.f53011n, this.f53012o, this.f53013p, this.f53014q, this.f53015r, (Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit>) this.f53016s, (Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit>) this.f53017t, composer2, this.f53018u | 1, this.f53019v, this.f53020w);
    }
}
