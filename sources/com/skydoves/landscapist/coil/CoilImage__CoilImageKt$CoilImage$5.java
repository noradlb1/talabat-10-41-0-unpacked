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
import com.skydoves.landscapist.palette.BitmapPalette;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CoilImage__CoilImageKt$CoilImage$5 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Object f53124g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f53125h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Context f53126i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f53127j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ImageLoader f53128k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Alignment f53129l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f53130m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ContentScale f53131n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f53132o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ CircularReveal f53133p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ BitmapPalette f53134q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f53135r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ Object f53136s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ Object f53137t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f53138u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f53139v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f53140w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f53141x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoilImage__CoilImageKt$CoilImage$5(Object obj, Modifier modifier, Context context, LifecycleOwner lifecycleOwner, ImageLoader imageLoader, Alignment alignment, float f11, ContentScale contentScale, String str, CircularReveal circularReveal, BitmapPalette bitmapPalette, ColorFilter colorFilter, Object obj2, Object obj3, int i11, int i12, int i13, int i14) {
        super(2);
        this.f53124g = obj;
        this.f53125h = modifier;
        this.f53126i = context;
        this.f53127j = lifecycleOwner;
        this.f53128k = imageLoader;
        this.f53129l = alignment;
        this.f53130m = f11;
        this.f53131n = contentScale;
        this.f53132o = str;
        this.f53133p = circularReveal;
        this.f53134q = bitmapPalette;
        this.f53135r = colorFilter;
        this.f53136s = obj2;
        this.f53137t = obj3;
        this.f53138u = i11;
        this.f53139v = i12;
        this.f53140w = i13;
        this.f53141x = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Object obj = this.f53124g;
        Object obj2 = obj;
        CoilImage.CoilImage(obj2, this.f53125h, this.f53126i, this.f53127j, this.f53128k, this.f53129l, this.f53130m, this.f53131n, this.f53132o, this.f53133p, this.f53134q, this.f53135r, this.f53136s, this.f53137t, this.f53138u, composer2, this.f53139v | 1, this.f53140w, this.f53141x);
    }
}
