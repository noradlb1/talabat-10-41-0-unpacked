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
import com.skydoves.landscapist.coil.CoilImageState;
import com.skydoves.landscapist.palette.BitmapPalette;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CoilImage__CoilImageKt$CoilImage$6 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f53142g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f53143h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Context f53144i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f53145j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ImageLoader f53146k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Alignment f53147l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ContentScale f53148m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f53149n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f53150o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f53151p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ CircularReveal f53152q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ ShimmerParams f53153r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ BitmapPalette f53154s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f53155t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Success, Composer, Integer, Unit> f53156u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Failure, Composer, Integer, Unit> f53157v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f53158w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f53159x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f53160y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoilImage__CoilImageKt$CoilImage$6(Object obj, Modifier modifier, Context context, LifecycleOwner lifecycleOwner, ImageLoader imageLoader, Alignment alignment, ContentScale contentScale, String str, float f11, ColorFilter colorFilter, CircularReveal circularReveal, ShimmerParams shimmerParams, BitmapPalette bitmapPalette, int i11, Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function3, Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function32, int i12, int i13, int i14) {
        super(2);
        this.f53142g = obj;
        this.f53143h = modifier;
        this.f53144i = context;
        this.f53145j = lifecycleOwner;
        this.f53146k = imageLoader;
        this.f53147l = alignment;
        this.f53148m = contentScale;
        this.f53149n = str;
        this.f53150o = f11;
        this.f53151p = colorFilter;
        this.f53152q = circularReveal;
        this.f53153r = shimmerParams;
        this.f53154s = bitmapPalette;
        this.f53155t = i11;
        this.f53156u = function3;
        this.f53157v = function32;
        this.f53158w = i12;
        this.f53159x = i13;
        this.f53160y = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Object obj = this.f53142g;
        Object obj2 = obj;
        CoilImage.CoilImage(obj2, this.f53143h, this.f53144i, this.f53145j, this.f53146k, this.f53147l, this.f53148m, this.f53149n, this.f53150o, this.f53151p, this.f53152q, this.f53153r, this.f53154s, this.f53155t, (Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit>) this.f53156u, (Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit>) this.f53157v, composer2, this.f53158w | 1, this.f53159x, this.f53160y);
    }
}
