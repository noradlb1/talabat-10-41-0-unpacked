package com.skydoves.landscapist.coil;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import coil.ImageLoader;
import coil.request.ImageRequest;
import com.skydoves.landscapist.ImageLoadState;
import com.skydoves.landscapist.palette.BitmapPalette;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CoilImage__CoilImageKt$CoilImage$15 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageRequest f53081g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f53082h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ImageLoader f53083i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ BitmapPalette f53084j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<ImageLoadState, Composer, Integer, Unit> f53085k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f53086l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f53087m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoilImage__CoilImageKt$CoilImage$15(ImageRequest imageRequest, Modifier modifier, ImageLoader imageLoader, BitmapPalette bitmapPalette, Function3<? super ImageLoadState, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f53081g = imageRequest;
        this.f53082h = modifier;
        this.f53083i = imageLoader;
        this.f53084j = bitmapPalette;
        this.f53085k = function3;
        this.f53086l = i11;
        this.f53087m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CoilImage__CoilImageKt.CoilImage$CoilImage__CoilImageKt(this.f53081g, this.f53082h, this.f53083i, this.f53084j, this.f53085k, composer, this.f53086l | 1, this.f53087m);
    }
}
