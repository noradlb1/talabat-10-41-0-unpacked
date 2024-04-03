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
import com.skydoves.landscapist.coil.CoilImageState;
import com.skydoves.landscapist.palette.BitmapPalette;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CoilImage__CoilImageKt$CoilImage$7 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f53161g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f53162h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Context f53163i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f53164j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ImageLoader f53165k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Alignment f53166l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ContentScale f53167m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f53168n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f53169o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f53170p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ CircularReveal f53171q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ BitmapPalette f53172r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f53173s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Loading, Composer, Integer, Unit> f53174t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Success, Composer, Integer, Unit> f53175u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Failure, Composer, Integer, Unit> f53176v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f53177w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f53178x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f53179y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoilImage__CoilImageKt$CoilImage$7(Object obj, Modifier modifier, Context context, LifecycleOwner lifecycleOwner, ImageLoader imageLoader, Alignment alignment, ContentScale contentScale, String str, float f11, ColorFilter colorFilter, CircularReveal circularReveal, BitmapPalette bitmapPalette, int i11, Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit> function3, Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function32, Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function33, int i12, int i13, int i14) {
        super(2);
        this.f53161g = obj;
        this.f53162h = modifier;
        this.f53163i = context;
        this.f53164j = lifecycleOwner;
        this.f53165k = imageLoader;
        this.f53166l = alignment;
        this.f53167m = contentScale;
        this.f53168n = str;
        this.f53169o = f11;
        this.f53170p = colorFilter;
        this.f53171q = circularReveal;
        this.f53172r = bitmapPalette;
        this.f53173s = i11;
        this.f53174t = function3;
        this.f53175u = function32;
        this.f53176v = function33;
        this.f53177w = i12;
        this.f53178x = i13;
        this.f53179y = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Object obj = this.f53161g;
        Object obj2 = obj;
        CoilImage.CoilImage(obj2, this.f53162h, this.f53163i, this.f53164j, this.f53165k, this.f53166l, this.f53167m, this.f53168n, this.f53169o, this.f53170p, this.f53171q, this.f53172r, this.f53173s, (Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit>) this.f53174t, (Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit>) this.f53175u, (Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit>) this.f53176v, composer2, this.f53177w | 1, this.f53178x, this.f53179y);
    }
}
