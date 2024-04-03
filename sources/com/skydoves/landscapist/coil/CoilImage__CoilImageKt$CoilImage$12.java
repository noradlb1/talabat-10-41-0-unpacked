package com.skydoves.landscapist.coil;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.core.graphics.drawable.DrawableKt;
import com.skydoves.landscapist.CircularReveal;
import com.skydoves.landscapist.CircularRevealedImage;
import com.skydoves.landscapist.DrawablePainterKt;
import com.skydoves.landscapist.ImageLoadState;
import com.skydoves.landscapist.coil.CoilImageState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CoilImage__CoilImageKt$CoilImage$12 extends Lambda implements Function3<ImageLoadState, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Loading, Composer, Integer, Unit> f53038g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f53039h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Failure, Composer, Integer, Unit> f53040i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Success, Composer, Integer, Unit> f53041j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Modifier f53042k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Alignment f53043l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ContentScale f53044m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f53045n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f53046o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f53047p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ CircularReveal f53048q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f53049r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoilImage__CoilImageKt$CoilImage$12(Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit> function3, int i11, Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function32, Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function33, Modifier modifier, Alignment alignment, ContentScale contentScale, String str, float f11, ColorFilter colorFilter, CircularReveal circularReveal, int i12) {
        super(3);
        this.f53038g = function3;
        this.f53039h = i11;
        this.f53040i = function32;
        this.f53041j = function33;
        this.f53042k = modifier;
        this.f53043l = alignment;
        this.f53044m = contentScale;
        this.f53045n = str;
        this.f53046o = f11;
        this.f53047p = colorFilter;
        this.f53048q = circularReveal;
        this.f53049r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ImageLoadState) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull ImageLoadState imageLoadState, @Nullable Composer composer, int i11) {
        int i12;
        Unit unit;
        ImageLoadState imageLoadState2 = imageLoadState;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(imageLoadState2, "imageState");
        if ((i11 & 14) == 0) {
            i12 = i11 | (composer2.changed((Object) imageLoadState2) ? 4 : 2);
        } else {
            i12 = i11;
        }
        if (((i12 & 91) ^ 18) != 0 || !composer.getSkipping()) {
            CoilImageState coilImageState = CoilImageStateKt.toCoilImageState(imageLoadState);
            if (coilImageState instanceof CoilImageState.None) {
                composer2.startReplaceableGroup(-2069177985);
                composer.endReplaceableGroup();
            } else if (coilImageState instanceof CoilImageState.Loading) {
                composer2.startReplaceableGroup(-2069177936);
                Function3<CoilImageState.Loading, Composer, Integer, Unit> function3 = this.f53038g;
                if (function3 == null) {
                    composer2.startReplaceableGroup(279993425);
                } else {
                    composer2.startReplaceableGroup(-2069177936);
                    function3.invoke(coilImageState, composer2, Integer.valueOf(CoilImageState.Loading.$stable | (this.f53039h & 112)));
                }
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            } else if (coilImageState instanceof CoilImageState.Failure) {
                composer2.startReplaceableGroup(-2069177869);
                Function3<CoilImageState.Failure, Composer, Integer, Unit> function32 = this.f53040i;
                if (function32 == null) {
                    composer2.startReplaceableGroup(279995502);
                } else {
                    composer2.startReplaceableGroup(-2069177869);
                    function32.invoke(coilImageState, composer2, Integer.valueOf(CoilImageState.Failure.$stable | ((this.f53039h >> 6) & 112)));
                }
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            } else if (coilImageState instanceof CoilImageState.Success) {
                composer2.startReplaceableGroup(-2069177811);
                Function3<CoilImageState.Success, Composer, Integer, Unit> function33 = this.f53041j;
                if (function33 == null) {
                    composer2.startReplaceableGroup(279997889);
                    composer.endReplaceableGroup();
                    unit = null;
                } else {
                    composer2.startReplaceableGroup(-2069177792);
                    function33.invoke(coilImageState, composer2, Integer.valueOf(CoilImageState.Success.$stable | ((this.f53039h >> 3) & 112)));
                    composer.endReplaceableGroup();
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    composer2.startReplaceableGroup(-2069177741);
                    Drawable drawable = ((CoilImageState.Success) coilImageState).getDrawable();
                    if (drawable == null) {
                        composer2.startReplaceableGroup(279999470);
                    } else {
                        composer2.startReplaceableGroup(-2069177741);
                        Modifier modifier = this.f53042k;
                        Alignment alignment = this.f53043l;
                        ContentScale contentScale = this.f53044m;
                        String str = this.f53045n;
                        float f11 = this.f53046o;
                        ColorFilter colorFilter = this.f53047p;
                        CircularReveal circularReveal = this.f53048q;
                        int i13 = this.f53049r;
                        CircularRevealedImage.CircularRevealedImage(AndroidImageBitmap_androidKt.asImageBitmap(DrawableKt.toBitmap$default(drawable, 0, 0, (Bitmap.Config) null, 7, (Object) null)), modifier, DrawablePainterKt.rememberDrawablePainter(drawable, composer2, 8), alignment, contentScale, str, f11, colorFilter, circularReveal, composer, (i13 & 234881024) | (i13 & 112) | 520 | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (29360128 & i13) | (CircularReveal.$stable << 24), 0);
                    }
                    composer.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-2069177801);
                }
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-2069177275);
                composer.endReplaceableGroup();
            }
        } else {
            composer.skipToGroupEnd();
        }
    }
}
