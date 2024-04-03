package com.skydoves.landscapist.coil;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.lifecycle.LifecycleOwner;
import coil.ImageLoader;
import coil.request.ImageRequest;
import com.skydoves.landscapist.CircularReveal;
import com.skydoves.landscapist.ShimmerParams;
import com.skydoves.landscapist.coil.CoilImageState;
import com.skydoves.landscapist.palette.BitmapPalette;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"com/skydoves/landscapist/coil/CoilImage__CoilImageKt"}, k = 4, mv = {1, 5, 1}, xi = 48)
public final class CoilImage {
    @Composable
    public static final void CoilImage(@NotNull ImageRequest imageRequest, @Nullable Modifier modifier, @Nullable ImageLoader imageLoader, @Nullable Alignment alignment, @Nullable ContentScale contentScale, @Nullable String str, float f11, @Nullable ColorFilter colorFilter, @Nullable CircularReveal circularReveal, @NotNull ShimmerParams shimmerParams, @Nullable BitmapPalette bitmapPalette, @DrawableRes int i11, @Nullable Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function3, @Nullable Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function32, @Nullable Composer composer, int i12, int i13, int i14) {
        CoilImage__CoilImageKt.CoilImage(imageRequest, modifier, imageLoader, alignment, contentScale, str, f11, colorFilter, circularReveal, shimmerParams, bitmapPalette, i11, function3, function32, composer, i12, i13, i14);
    }

    @Composable
    public static final void CoilImage(@NotNull ImageRequest imageRequest, @Nullable Modifier modifier, @Nullable ImageLoader imageLoader, @Nullable Alignment alignment, @Nullable ContentScale contentScale, @Nullable String str, float f11, @Nullable ColorFilter colorFilter, @Nullable CircularReveal circularReveal, @Nullable BitmapPalette bitmapPalette, @DrawableRes int i11, @Nullable Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit> function3, @Nullable Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function32, @Nullable Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function33, @Nullable Composer composer, int i12, int i13, int i14) {
        CoilImage__CoilImageKt.CoilImage(imageRequest, modifier, imageLoader, alignment, contentScale, str, f11, colorFilter, circularReveal, bitmapPalette, i11, function3, function32, function33, composer, i12, i13, i14);
    }

    @Composable
    public static final void CoilImage(@Nullable Object obj, @Nullable Modifier modifier, @Nullable Context context, @Nullable LifecycleOwner lifecycleOwner, @Nullable ImageLoader imageLoader, @Nullable Alignment alignment, float f11, @Nullable ContentScale contentScale, @Nullable String str, @Nullable CircularReveal circularReveal, @Nullable ColorFilter colorFilter, @NotNull ShimmerParams shimmerParams, @Nullable BitmapPalette bitmapPalette, @Nullable Object obj2, @DrawableRes int i11, @Nullable Composer composer, int i12, int i13, int i14) {
        CoilImage__CoilImageKt.CoilImage(obj, modifier, context, lifecycleOwner, imageLoader, alignment, f11, contentScale, str, circularReveal, colorFilter, shimmerParams, bitmapPalette, obj2, i11, composer, i12, i13, i14);
    }

    @Composable
    public static final void CoilImage(@Nullable Object obj, @Nullable Modifier modifier, @Nullable Context context, @Nullable LifecycleOwner lifecycleOwner, @Nullable ImageLoader imageLoader, @Nullable Alignment alignment, float f11, @Nullable ContentScale contentScale, @Nullable String str, @Nullable CircularReveal circularReveal, @Nullable BitmapPalette bitmapPalette, @Nullable ColorFilter colorFilter, @Nullable Object obj2, @Nullable Object obj3, @DrawableRes int i11, @Nullable Composer composer, int i12, int i13, int i14) {
        CoilImage__CoilImageKt.CoilImage(obj, modifier, context, lifecycleOwner, imageLoader, alignment, f11, contentScale, str, circularReveal, bitmapPalette, colorFilter, obj2, obj3, i11, composer, i12, i13, i14);
    }

    @Composable
    public static final void CoilImage(@Nullable Object obj, @Nullable Modifier modifier, @Nullable Context context, @Nullable LifecycleOwner lifecycleOwner, @Nullable ImageLoader imageLoader, @Nullable Alignment alignment, @Nullable ContentScale contentScale, @Nullable String str, float f11, @Nullable ColorFilter colorFilter, @Nullable CircularReveal circularReveal, @NotNull ShimmerParams shimmerParams, @Nullable BitmapPalette bitmapPalette, @DrawableRes int i11, @Nullable Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function3, @Nullable Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function32, @Nullable Composer composer, int i12, int i13, int i14) {
        CoilImage__CoilImageKt.CoilImage(obj, modifier, context, lifecycleOwner, imageLoader, alignment, contentScale, str, f11, colorFilter, circularReveal, shimmerParams, bitmapPalette, i11, function3, function32, composer, i12, i13, i14);
    }

    @Composable
    public static final void CoilImage(@Nullable Object obj, @Nullable Modifier modifier, @Nullable Context context, @Nullable LifecycleOwner lifecycleOwner, @Nullable ImageLoader imageLoader, @Nullable Alignment alignment, @Nullable ContentScale contentScale, @Nullable String str, float f11, @Nullable ColorFilter colorFilter, @Nullable CircularReveal circularReveal, @Nullable BitmapPalette bitmapPalette, @DrawableRes int i11, @Nullable Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit> function3, @Nullable Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function32, @Nullable Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function33, @Nullable Composer composer, int i12, int i13, int i14) {
        CoilImage__CoilImageKt.CoilImage(obj, modifier, context, lifecycleOwner, imageLoader, alignment, contentScale, str, f11, colorFilter, circularReveal, bitmapPalette, i11, function3, function32, function33, composer, i12, i13, i14);
    }
}
