package com.skydoves.landscapist;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CircularRevealedImage__CircularRevealedImageKt$CircularRevealedImage$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageBitmap f52933g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f52934h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Painter f52935i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Alignment f52936j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ContentScale f52937k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f52938l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float f52939m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f52940n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ CircularReveal f52941o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f52942p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f52943q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CircularRevealedImage__CircularRevealedImageKt$CircularRevealedImage$1(ImageBitmap imageBitmap, Modifier modifier, Painter painter, Alignment alignment, ContentScale contentScale, String str, float f11, ColorFilter colorFilter, CircularReveal circularReveal, int i11, int i12) {
        super(2);
        this.f52933g = imageBitmap;
        this.f52934h = modifier;
        this.f52935i = painter;
        this.f52936j = alignment;
        this.f52937k = contentScale;
        this.f52938l = str;
        this.f52939m = f11;
        this.f52940n = colorFilter;
        this.f52941o = circularReveal;
        this.f52942p = i11;
        this.f52943q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CircularRevealedImage.CircularRevealedImage(this.f52933g, this.f52934h, this.f52935i, this.f52936j, this.f52937k, this.f52938l, this.f52939m, this.f52940n, this.f52941o, composer, this.f52942p | 1, this.f52943q);
    }
}
