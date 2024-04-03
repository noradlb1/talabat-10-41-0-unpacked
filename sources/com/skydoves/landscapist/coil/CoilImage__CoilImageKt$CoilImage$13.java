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
public final class CoilImage__CoilImageKt$CoilImage$13 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageRequest f53050g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f53051h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ImageLoader f53052i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Alignment f53053j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ContentScale f53054k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f53055l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f53056m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f53057n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ CircularReveal f53058o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ BitmapPalette f53059p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f53060q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Loading, Composer, Integer, Unit> f53061r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Success, Composer, Integer, Unit> f53062s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Failure, Composer, Integer, Unit> f53063t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f53064u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f53065v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f53066w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoilImage__CoilImageKt$CoilImage$13(ImageRequest imageRequest, Modifier modifier, ImageLoader imageLoader, Alignment alignment, ContentScale contentScale, String str, float f11, ColorFilter colorFilter, CircularReveal circularReveal, BitmapPalette bitmapPalette, int i11, Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit> function3, Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function32, Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function33, int i12, int i13, int i14) {
        super(2);
        this.f53050g = imageRequest;
        this.f53051h = modifier;
        this.f53052i = imageLoader;
        this.f53053j = alignment;
        this.f53054k = contentScale;
        this.f53055l = str;
        this.f53056m = f11;
        this.f53057n = colorFilter;
        this.f53058o = circularReveal;
        this.f53059p = bitmapPalette;
        this.f53060q = i11;
        this.f53061r = function3;
        this.f53062s = function32;
        this.f53063t = function33;
        this.f53064u = i12;
        this.f53065v = i13;
        this.f53066w = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        ImageRequest imageRequest = this.f53050g;
        ImageRequest imageRequest2 = imageRequest;
        CoilImage.CoilImage(imageRequest2, this.f53051h, this.f53052i, this.f53053j, this.f53054k, this.f53055l, this.f53056m, this.f53057n, this.f53058o, this.f53059p, this.f53060q, (Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit>) this.f53061r, (Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit>) this.f53062s, (Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit>) this.f53063t, composer2, this.f53064u | 1, this.f53065v, this.f53066w);
    }
}
