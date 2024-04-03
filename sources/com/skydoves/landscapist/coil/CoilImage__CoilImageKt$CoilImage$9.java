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
import com.skydoves.landscapist.Shimmer;
import com.skydoves.landscapist.ShimmerParams;
import com.skydoves.landscapist.coil.CoilImageState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CoilImage__CoilImageKt$CoilImage$9 extends Lambda implements Function3<ImageLoadState, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ShimmerParams f53197g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Failure, Composer, Integer, Unit> f53198h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f53199i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Success, Composer, Integer, Unit> f53200j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Modifier f53201k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Alignment f53202l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ContentScale f53203m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f53204n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f53205o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ColorFilter f53206p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ CircularReveal f53207q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f53208r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoilImage__CoilImageKt$CoilImage$9(ShimmerParams shimmerParams, Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function3, int i11, Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function32, Modifier modifier, Alignment alignment, ContentScale contentScale, String str, float f11, ColorFilter colorFilter, CircularReveal circularReveal, int i12) {
        super(3);
        this.f53197g = shimmerParams;
        this.f53198h = function3;
        this.f53199i = i11;
        this.f53200j = function32;
        this.f53201k = modifier;
        this.f53202l = alignment;
        this.f53203m = contentScale;
        this.f53204n = str;
        this.f53205o = f11;
        this.f53206p = colorFilter;
        this.f53207q = circularReveal;
        this.f53208r = i12;
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
                composer2.startReplaceableGroup(-2069182426);
                composer.endReplaceableGroup();
            } else if (coilImageState instanceof CoilImageState.Loading) {
                composer2.startReplaceableGroup(-2069182386);
                Shimmer.m9399ShimmerK2djEUw((Modifier) null, this.f53197g.m9404getBaseColor0d7_KjU(), this.f53197g.m9405getHighlightColor0d7_KjU(), this.f53197g.getIntensity(), this.f53197g.getDropOff(), this.f53197g.getTilt(), this.f53197g.getDurationMillis(), composer, 0, 1);
                composer.endReplaceableGroup();
            } else if (coilImageState instanceof CoilImageState.Failure) {
                composer2.startReplaceableGroup(-2069182018);
                Function3<CoilImageState.Failure, Composer, Integer, Unit> function3 = this.f53198h;
                if (function3 == null) {
                    composer2.startReplaceableGroup(279866883);
                } else {
                    composer2.startReplaceableGroup(-2069182018);
                    function3.invoke(coilImageState, composer2, Integer.valueOf(CoilImageState.Failure.$stable | ((this.f53199i >> 6) & 112)));
                }
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            } else if (coilImageState instanceof CoilImageState.Success) {
                composer2.startReplaceableGroup(-2069181960);
                Function3<CoilImageState.Success, Composer, Integer, Unit> function32 = this.f53200j;
                if (function32 == null) {
                    composer2.startReplaceableGroup(279869270);
                    composer.endReplaceableGroup();
                    unit = null;
                } else {
                    composer2.startReplaceableGroup(-2069181941);
                    function32.invoke(coilImageState, composer2, Integer.valueOf(CoilImageState.Success.$stable | ((this.f53199i >> 3) & 112)));
                    composer.endReplaceableGroup();
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    composer2.startReplaceableGroup(-2069181890);
                    Drawable drawable = ((CoilImageState.Success) coilImageState).getDrawable();
                    if (drawable == null) {
                        composer2.startReplaceableGroup(279870851);
                    } else {
                        composer2.startReplaceableGroup(-2069181890);
                        Modifier modifier = this.f53201k;
                        Alignment alignment = this.f53202l;
                        ContentScale contentScale = this.f53203m;
                        String str = this.f53204n;
                        float f11 = this.f53205o;
                        ColorFilter colorFilter = this.f53206p;
                        CircularReveal circularReveal = this.f53207q;
                        int i13 = this.f53208r;
                        CircularRevealedImage.CircularRevealedImage(AndroidImageBitmap_androidKt.asImageBitmap(DrawableKt.toBitmap$default(drawable, 0, 0, (Bitmap.Config) null, 7, (Object) null)), modifier, DrawablePainterKt.rememberDrawablePainter(drawable, composer2, 8), alignment, contentScale, str, f11, colorFilter, circularReveal, composer, (i13 & 234881024) | (i13 & 112) | 520 | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (29360128 & i13) | (CircularReveal.$stable << 24), 0);
                    }
                    composer.endReplaceableGroup();
                } else {
                    composer2.startReplaceableGroup(-2069181950);
                }
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            } else {
                composer2.startReplaceableGroup(-2069181424);
                composer.endReplaceableGroup();
            }
        } else {
            composer.skipToGroupEnd();
        }
    }
}
