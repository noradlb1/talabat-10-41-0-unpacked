package com.skydoves.landscapist.coil;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.res.PainterResources_androidKt;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aá\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0003\u0010\u0018\u001a\u00020\u00192*\b\u0002\u0010\u001a\u001a$\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b 2*\b\u0002\u0010!\u001a$\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b H\u0007¢\u0006\u0002\u0010#\u001a\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0003\u0010\u0018\u001a\u00020\u00192*\b\u0002\u0010$\u001a$\u0012\u0013\u0012\u00110%¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b 2*\b\u0002\u0010\u001a\u001a$\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b 2*\b\u0002\u0010!\u001a$\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b H\u0007¢\u0006\u0002\u0010&\u001a_\u0010\u0000\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172&\u0010(\u001a\"\u0012\u0013\u0012\u00110)¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00010\u001b¢\u0006\u0002\b H\u0003¢\u0006\u0004\b*\u0010+\u001a÷\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010,\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0003\u0010\u0018\u001a\u00020\u00192*\b\u0002\u0010\u001a\u001a$\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b 2*\b\u0002\u0010!\u001a$\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b H\u0007¢\u0006\u0002\u00102\u001a\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010,\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0003\u0010\u0018\u001a\u00020\u00192*\b\u0002\u0010$\u001a$\u0012\u0013\u0012\u00110%¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b 2*\b\u0002\u0010\u001a\u001a$\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b 2*\b\u0002\u0010!\u001a$\u0012\u0013\u0012\u00110\"¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001b¢\u0006\u0002\b H\u0007¢\u0006\u0002\u00103\u001a«\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010,\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u00104\u001a\u0004\u0018\u00010-2\b\b\u0003\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u00105\u001a¯\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010,\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00106\u001a\u0004\u0018\u00010-2\n\b\u0002\u00104\u001a\u0004\u0018\u00010-2\b\b\u0003\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u00107¨\u00068"}, d2 = {"CoilImage", "", "imageRequest", "Lcoil/request/ImageRequest;", "modifier", "Landroidx/compose/ui/Modifier;", "imageLoader", "Lcoil/ImageLoader;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "contentDescription", "", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "circularReveal", "Lcom/skydoves/landscapist/CircularReveal;", "shimmerParams", "Lcom/skydoves/landscapist/ShimmerParams;", "bitmapPalette", "Lcom/skydoves/landscapist/palette/BitmapPalette;", "previewPlaceholder", "", "success", "Lkotlin/Function1;", "Lcom/skydoves/landscapist/coil/CoilImageState$Success;", "Lkotlin/ParameterName;", "name", "imageState", "Landroidx/compose/runtime/Composable;", "failure", "Lcom/skydoves/landscapist/coil/CoilImageState$Failure;", "(Lcoil/request/ImageRequest;Landroidx/compose/ui/Modifier;Lcoil/ImageLoader;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;FLandroidx/compose/ui/graphics/ColorFilter;Lcom/skydoves/landscapist/CircularReveal;Lcom/skydoves/landscapist/ShimmerParams;Lcom/skydoves/landscapist/palette/BitmapPalette;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "loading", "Lcom/skydoves/landscapist/coil/CoilImageState$Loading;", "(Lcoil/request/ImageRequest;Landroidx/compose/ui/Modifier;Lcoil/ImageLoader;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;FLandroidx/compose/ui/graphics/ColorFilter;Lcom/skydoves/landscapist/CircularReveal;Lcom/skydoves/landscapist/palette/BitmapPalette;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "recomposeKey", "content", "Lcom/skydoves/landscapist/ImageLoadState;", "CoilImage$CoilImage__CoilImageKt", "(Lcoil/request/ImageRequest;Landroidx/compose/ui/Modifier;Lcoil/ImageLoader;Lcom/skydoves/landscapist/palette/BitmapPalette;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "imageModel", "", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcoil/ImageLoader;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;FLandroidx/compose/ui/graphics/ColorFilter;Lcom/skydoves/landscapist/CircularReveal;Lcom/skydoves/landscapist/ShimmerParams;Lcom/skydoves/landscapist/palette/BitmapPalette;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcoil/ImageLoader;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;FLandroidx/compose/ui/graphics/ColorFilter;Lcom/skydoves/landscapist/CircularReveal;Lcom/skydoves/landscapist/palette/BitmapPalette;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "error", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcoil/ImageLoader;Landroidx/compose/ui/Alignment;FLandroidx/compose/ui/layout/ContentScale;Ljava/lang/String;Lcom/skydoves/landscapist/CircularReveal;Landroidx/compose/ui/graphics/ColorFilter;Lcom/skydoves/landscapist/ShimmerParams;Lcom/skydoves/landscapist/palette/BitmapPalette;Ljava/lang/Object;ILandroidx/compose/runtime/Composer;III)V", "placeHolder", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcoil/ImageLoader;Landroidx/compose/ui/Alignment;FLandroidx/compose/ui/layout/ContentScale;Ljava/lang/String;Lcom/skydoves/landscapist/CircularReveal;Lcom/skydoves/landscapist/palette/BitmapPalette;Landroidx/compose/ui/graphics/ColorFilter;Ljava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/Composer;III)V", "coil_release"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "com/skydoves/landscapist/coil/CoilImage")
final /* synthetic */ class CoilImage__CoilImageKt {
    @Composable
    public static final void CoilImage(@Nullable Object obj, @Nullable Modifier modifier, @Nullable Context context, @Nullable LifecycleOwner lifecycleOwner, @Nullable ImageLoader imageLoader, @Nullable Alignment alignment, float f11, @Nullable ContentScale contentScale, @Nullable String str, @Nullable CircularReveal circularReveal, @Nullable ColorFilter colorFilter, @NotNull ShimmerParams shimmerParams, @Nullable BitmapPalette bitmapPalette, @Nullable Object obj2, @DrawableRes int i11, @Nullable Composer composer, int i12, int i13, int i14) {
        Context context2;
        int i15;
        LifecycleOwner lifecycleOwner2;
        ImageLoader imageLoader2;
        Alignment alignment2;
        ContentScale contentScale2;
        int i16 = i13;
        int i17 = i14;
        Intrinsics.checkNotNullParameter(shimmerParams, "shimmerParams");
        Composer startRestartGroup = composer.startRestartGroup(1486255531);
        Modifier.Companion companion = (i17 & 2) != 0 ? Modifier.Companion : modifier;
        if ((i17 & 4) != 0) {
            i15 = i12 & -897;
            context2 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        } else {
            context2 = context;
            i15 = i12;
        }
        if ((i17 & 8) != 0) {
            i15 &= -7169;
            lifecycleOwner2 = (LifecycleOwner) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        } else {
            lifecycleOwner2 = lifecycleOwner;
        }
        if ((i17 & 16) != 0) {
            i15 &= -57345;
            imageLoader2 = LocalCoilProvider.INSTANCE.getCoilImageLoader(startRestartGroup, 8);
        } else {
            imageLoader2 = imageLoader;
        }
        if ((i17 & 32) != 0) {
            i15 &= -458753;
            alignment2 = Alignment.Companion.getCenter();
        } else {
            alignment2 = alignment;
        }
        float f12 = (i17 & 64) != 0 ? 1.0f : f11;
        if ((i17 & 128) != 0) {
            i15 &= -29360129;
            contentScale2 = ContentScale.Companion.getCrop();
        } else {
            contentScale2 = contentScale;
        }
        String str2 = (i17 & 256) != 0 ? null : str;
        CircularReveal circularReveal2 = (i17 & 512) != 0 ? null : circularReveal;
        ColorFilter colorFilter2 = (i17 & 1024) != 0 ? null : colorFilter;
        BitmapPalette bitmapPalette2 = (i17 & 4096) != 0 ? null : bitmapPalette;
        Object obj3 = (i17 & 8192) != 0 ? null : obj2;
        int i18 = (i17 & 16384) != 0 ? 0 : i11;
        CoilImage.CoilImage(obj, SizeKt.fillMaxWidth$default(companion, 0.0f, 1, (Object) null), context2, lifecycleOwner2, imageLoader2, alignment2, contentScale2, (String) null, f12, colorFilter2, circularReveal2, shimmerParams, bitmapPalette2, i18, (Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit>) null, (Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819892084, true, new CoilImage__CoilImageKt$CoilImage$1(obj3, companion, alignment2, contentScale2, str2, colorFilter2, f12, i15, i13)), startRestartGroup, (458752 & i15) | 37384 | ((i15 >> 3) & 3670016) | ((i15 << 6) & 234881024) | ((i16 << 27) & 1879048192), 196608 | CircularReveal.$stable | ((i15 >> 27) & 14) | (ShimmerParams.$stable << 3) | (i16 & 112) | (BitmapPalette.$stable << 6) | (i16 & 896) | ((i16 >> 3) & 7168), 16512);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            CoilImage__CoilImageKt$CoilImage$2 coilImage__CoilImageKt$CoilImage$2 = r0;
            CoilImage__CoilImageKt$CoilImage$2 coilImage__CoilImageKt$CoilImage$22 = new CoilImage__CoilImageKt$CoilImage$2(obj, companion, context2, lifecycleOwner2, imageLoader2, alignment2, f12, contentScale2, str2, circularReveal2, colorFilter2, shimmerParams, bitmapPalette2, obj3, i18, i12, i13, i14);
            endRestartGroup.updateScope(coilImage__CoilImageKt$CoilImage$2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: kotlinx.coroutines.flow.MutableStateFlow} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.compose.runtime.MutableState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: androidx.compose.ui.Modifier$Companion} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CoilImage$CoilImage__CoilImageKt(coil.request.ImageRequest r17, androidx.compose.ui.Modifier r18, coil.ImageLoader r19, com.skydoves.landscapist.palette.BitmapPalette r20, kotlin.jvm.functions.Function3<? super com.skydoves.landscapist.ImageLoadState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r8 = r17
            r0 = 1486276621(0x5896c80d, float:1.32628765E15)
            r1 = r22
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            r0 = r24 & 2
            if (r0 == 0) goto L_0x0013
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r10 = r0
            goto L_0x0015
        L_0x0013:
            r10 = r18
        L_0x0015:
            r0 = r24 & 4
            r11 = 8
            if (r0 == 0) goto L_0x0028
            com.skydoves.landscapist.coil.LocalCoilProvider r0 = com.skydoves.landscapist.coil.LocalCoilProvider.INSTANCE
            coil.ImageLoader r0 = r0.getCoilImageLoader(r9, r11)
            r12 = r23
            r1 = r12 & -897(0xfffffffffffffc7f, float:NaN)
            r14 = r0
            r13 = r1
            goto L_0x002d
        L_0x0028:
            r12 = r23
            r14 = r19
            r13 = r12
        L_0x002d:
            r0 = r24 & 8
            r1 = 0
            if (r0 == 0) goto L_0x0034
            r15 = r1
            goto L_0x0036
        L_0x0034:
            r15 = r20
        L_0x0036:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            java.lang.Object r0 = r9.consume(r0)
            r4 = r0
            android.content.Context r4 = (android.content.Context) r4
            r0 = -3686930(0xffffffffffc7bdee, float:NaN)
            r9.startReplaceableGroup(r0)
            boolean r2 = r9.changed((java.lang.Object) r8)
            java.lang.Object r3 = r9.rememberedValue()
            if (r2 != 0) goto L_0x0059
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x0062
        L_0x0059:
            com.skydoves.landscapist.ImageLoadState$None r2 = com.skydoves.landscapist.ImageLoadState.None.INSTANCE
            kotlinx.coroutines.flow.MutableStateFlow r3 = kotlinx.coroutines.flow.StateFlowKt.MutableStateFlow(r2)
            r9.updateRememberedValue(r3)
        L_0x0062:
            r9.endReplaceableGroup()
            r5 = r3
            kotlinx.coroutines.flow.MutableStateFlow r5 = (kotlinx.coroutines.flow.MutableStateFlow) r5
            r9.startReplaceableGroup(r0)
            boolean r0 = r9.changed((java.lang.Object) r8)
            java.lang.Object r2 = r9.rememberedValue()
            if (r0 != 0) goto L_0x007d
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r2 != r0) goto L_0x0085
        L_0x007d:
            r0 = 2
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r1, r0, r1)
            r9.updateRememberedValue(r2)
        L_0x0085:
            r9.endReplaceableGroup()
            r1 = r2
            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
            com.skydoves.landscapist.coil.CoilImage__CoilImageKt$CoilImage$14 r16 = new com.skydoves.landscapist.coil.CoilImage__CoilImageKt$CoilImage$14
            r7 = 0
            r0 = r16
            r2 = r14
            r3 = r17
            r6 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            int r0 = r13 << 3
            r0 = r0 & 896(0x380, float:1.256E-42)
            r0 = r0 | r11
            int r1 = r13 >> 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r5 = r0 | r1
            r6 = 0
            r0 = r17
            r1 = r16
            r2 = r10
            r3 = r21
            r4 = r9
            com.skydoves.landscapist.ImageLoad.ImageLoad(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.runtime.ScopeUpdateScope r9 = r9.endRestartGroup()
            if (r9 != 0) goto L_0x00b5
            goto L_0x00c9
        L_0x00b5:
            com.skydoves.landscapist.coil.CoilImage__CoilImageKt$CoilImage$15 r11 = new com.skydoves.landscapist.coil.CoilImage__CoilImageKt$CoilImage$15
            r0 = r11
            r1 = r17
            r2 = r10
            r3 = r14
            r4 = r15
            r5 = r21
            r6 = r23
            r7 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r9.updateScope(r11)
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.skydoves.landscapist.coil.CoilImage__CoilImageKt.CoilImage$CoilImage__CoilImageKt(coil.request.ImageRequest, androidx.compose.ui.Modifier, coil.ImageLoader, com.skydoves.landscapist.palette.BitmapPalette, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    @Composable
    public static final void CoilImage(@Nullable Object obj, @Nullable Modifier modifier, @Nullable Context context, @Nullable LifecycleOwner lifecycleOwner, @Nullable ImageLoader imageLoader, @Nullable Alignment alignment, float f11, @Nullable ContentScale contentScale, @Nullable String str, @Nullable CircularReveal circularReveal, @Nullable BitmapPalette bitmapPalette, @Nullable ColorFilter colorFilter, @Nullable Object obj2, @Nullable Object obj3, @DrawableRes int i11, @Nullable Composer composer, int i12, int i13, int i14) {
        Context context2;
        int i15;
        LifecycleOwner lifecycleOwner2;
        ImageLoader imageLoader2;
        Alignment alignment2;
        ContentScale contentScale2;
        int i16 = i14;
        Composer startRestartGroup = composer.startRestartGroup(1486259003);
        Modifier.Companion companion = (i16 & 2) != 0 ? Modifier.Companion : modifier;
        if ((i16 & 4) != 0) {
            i15 = i12 & -897;
            context2 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        } else {
            context2 = context;
            i15 = i12;
        }
        if ((i16 & 8) != 0) {
            i15 &= -7169;
            lifecycleOwner2 = (LifecycleOwner) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        } else {
            lifecycleOwner2 = lifecycleOwner;
        }
        if ((i16 & 16) != 0) {
            i15 &= -57345;
            imageLoader2 = LocalCoilProvider.INSTANCE.getCoilImageLoader(startRestartGroup, 8);
        } else {
            imageLoader2 = imageLoader;
        }
        if ((i16 & 32) != 0) {
            i15 &= -458753;
            alignment2 = Alignment.Companion.getCenter();
        } else {
            alignment2 = alignment;
        }
        float f12 = (i16 & 64) != 0 ? 1.0f : f11;
        if ((i16 & 128) != 0) {
            i15 &= -29360129;
            contentScale2 = ContentScale.Companion.getCrop();
        } else {
            contentScale2 = contentScale;
        }
        String str2 = (i16 & 256) != 0 ? null : str;
        CircularReveal circularReveal2 = (i16 & 512) != 0 ? null : circularReveal;
        BitmapPalette bitmapPalette2 = (i16 & 1024) != 0 ? null : bitmapPalette;
        ColorFilter colorFilter2 = (i16 & 2048) != 0 ? null : colorFilter;
        Object obj4 = (i16 & 4096) != 0 ? null : obj2;
        Object obj5 = (i16 & 8192) != 0 ? null : obj3;
        int i17 = (i16 & 16384) != 0 ? 0 : i11;
        Modifier modifier2 = companion;
        Alignment alignment3 = alignment2;
        ContentScale contentScale3 = contentScale2;
        String str3 = str2;
        ColorFilter colorFilter3 = colorFilter2;
        float f13 = f12;
        int i18 = i15;
        int i19 = i13;
        CoilImage.CoilImage(obj, SizeKt.fillMaxWidth$default(companion, 0.0f, 1, (Object) null), context2, lifecycleOwner2, imageLoader2, alignment2, contentScale2, (String) null, f12, colorFilter2, circularReveal2, bitmapPalette2, i17, (Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819903003, true, new CoilImage__CoilImageKt$CoilImage$3(obj4, modifier2, alignment3, contentScale3, str3, colorFilter3, f13, i18, i19)), (Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit>) null, (Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819903940, true, new CoilImage__CoilImageKt$CoilImage$4(obj5, modifier2, alignment3, contentScale3, str3, colorFilter3, f13, i18, i19)), startRestartGroup, (458752 & i15) | 37384 | ((i15 >> 3) & 3670016) | ((i15 << 6) & 234881024) | ((i13 << 24) & 1879048192), 199680 | CircularReveal.$stable | ((i15 >> 27) & 14) | (BitmapPalette.$stable << 3) | ((i13 << 3) & 112) | ((i13 >> 6) & 896), 16512);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoilImage__CoilImageKt$CoilImage$5(obj, companion, context2, lifecycleOwner2, imageLoader2, alignment2, f12, contentScale2, str2, circularReveal2, bitmapPalette2, colorFilter2, obj4, obj5, i17, i12, i13, i14));
        }
    }

    @Composable
    public static final void CoilImage(@Nullable Object obj, @Nullable Modifier modifier, @Nullable Context context, @Nullable LifecycleOwner lifecycleOwner, @Nullable ImageLoader imageLoader, @Nullable Alignment alignment, @Nullable ContentScale contentScale, @Nullable String str, float f11, @Nullable ColorFilter colorFilter, @Nullable CircularReveal circularReveal, @NotNull ShimmerParams shimmerParams, @Nullable BitmapPalette bitmapPalette, @DrawableRes int i11, @Nullable Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function3, @Nullable Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function32, @Nullable Composer composer, int i12, int i13, int i14) {
        Context context2;
        int i15;
        LifecycleOwner lifecycleOwner2;
        ImageLoader imageLoader2;
        Alignment alignment2;
        ContentScale contentScale2;
        int i16 = i14;
        Intrinsics.checkNotNullParameter(shimmerParams, "shimmerParams");
        Composer startRestartGroup = composer.startRestartGroup(1486262538);
        Modifier.Companion companion = (i16 & 2) != 0 ? Modifier.Companion : modifier;
        if ((i16 & 4) != 0) {
            i15 = i12 & -897;
            context2 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        } else {
            context2 = context;
            i15 = i12;
        }
        if ((i16 & 8) != 0) {
            i15 &= -7169;
            lifecycleOwner2 = (LifecycleOwner) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        } else {
            lifecycleOwner2 = lifecycleOwner;
        }
        if ((i16 & 16) != 0) {
            i15 &= -57345;
            imageLoader2 = LocalCoilProvider.INSTANCE.getCoilImageLoader(startRestartGroup, 8);
        } else {
            imageLoader2 = imageLoader;
        }
        if ((i16 & 32) != 0) {
            i15 &= -458753;
            alignment2 = Alignment.Companion.getCenter();
        } else {
            alignment2 = alignment;
        }
        if ((i16 & 64) != 0) {
            i15 &= -3670017;
            contentScale2 = ContentScale.Companion.getCrop();
        } else {
            contentScale2 = contentScale;
        }
        String str2 = (i16 & 128) != 0 ? null : str;
        float f12 = (i16 & 256) != 0 ? 1.0f : f11;
        ColorFilter colorFilter2 = (i16 & 512) != 0 ? null : colorFilter;
        CircularReveal circularReveal2 = (i16 & 1024) != 0 ? null : circularReveal;
        BitmapPalette bitmapPalette2 = (i16 & 4096) != 0 ? null : bitmapPalette;
        int i17 = (i16 & 8192) != 0 ? 0 : i11;
        Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function33 = (i16 & 16384) != 0 ? null : function3;
        Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function34 = (32768 & i16) != 0 ? null : function32;
        ImageRequest build = new ImageRequest.Builder(context2).data(obj).lifecycle(lifecycleOwner2).build();
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, (Object) null);
        int i18 = i15 >> 6;
        int i19 = i13 << 24;
        int i21 = (i18 & 29360128) | (i18 & 7168) | 520 | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (CircularReveal.$stable << 24) | (234881024 & i19) | (ShimmerParams.$stable << 27) | (i19 & 1879048192);
        int i22 = i13 >> 6;
        CoilImage.CoilImage(build, fillMaxWidth$default, imageLoader2, alignment2, contentScale2, str2, f12, colorFilter2, circularReveal2, shimmerParams, bitmapPalette2, i17, function33, function34, startRestartGroup, i21, BitmapPalette.$stable | (i22 & 14) | (i22 & 112) | (i22 & 896) | (i22 & 7168), 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoilImage__CoilImageKt$CoilImage$6(obj, companion, context2, lifecycleOwner2, imageLoader2, alignment2, contentScale2, str2, f12, colorFilter2, circularReveal2, shimmerParams, bitmapPalette2, i17, function33, function34, i12, i13, i14));
        }
    }

    @Composable
    public static final void CoilImage(@Nullable Object obj, @Nullable Modifier modifier, @Nullable Context context, @Nullable LifecycleOwner lifecycleOwner, @Nullable ImageLoader imageLoader, @Nullable Alignment alignment, @Nullable ContentScale contentScale, @Nullable String str, float f11, @Nullable ColorFilter colorFilter, @Nullable CircularReveal circularReveal, @Nullable BitmapPalette bitmapPalette, @DrawableRes int i11, @Nullable Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit> function3, @Nullable Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function32, @Nullable Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function33, @Nullable Composer composer, int i12, int i13, int i14) {
        Context context2;
        int i15;
        LifecycleOwner lifecycleOwner2;
        ImageLoader imageLoader2;
        Alignment alignment2;
        ContentScale contentScale2;
        int i16 = i14;
        Composer startRestartGroup = composer.startRestartGroup(1486266076);
        Modifier.Companion companion = (i16 & 2) != 0 ? Modifier.Companion : modifier;
        if ((i16 & 4) != 0) {
            i15 = i12 & -897;
            context2 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        } else {
            context2 = context;
            i15 = i12;
        }
        if ((i16 & 8) != 0) {
            i15 &= -7169;
            lifecycleOwner2 = (LifecycleOwner) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        } else {
            lifecycleOwner2 = lifecycleOwner;
        }
        if ((i16 & 16) != 0) {
            i15 &= -57345;
            imageLoader2 = LocalCoilProvider.INSTANCE.getCoilImageLoader(startRestartGroup, 8);
        } else {
            imageLoader2 = imageLoader;
        }
        if ((i16 & 32) != 0) {
            i15 &= -458753;
            alignment2 = Alignment.Companion.getCenter();
        } else {
            alignment2 = alignment;
        }
        if ((i16 & 64) != 0) {
            i15 &= -3670017;
            contentScale2 = ContentScale.Companion.getCrop();
        } else {
            contentScale2 = contentScale;
        }
        String str2 = (i16 & 128) != 0 ? null : str;
        float f12 = (i16 & 256) != 0 ? 1.0f : f11;
        ColorFilter colorFilter2 = (i16 & 512) != 0 ? null : colorFilter;
        CircularReveal circularReveal2 = (i16 & 1024) != 0 ? null : circularReveal;
        BitmapPalette bitmapPalette2 = (i16 & 2048) != 0 ? null : bitmapPalette;
        int i17 = (i16 & 4096) != 0 ? 0 : i11;
        Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit> function34 = (i16 & 8192) != 0 ? null : function3;
        Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function35 = (i16 & 16384) != 0 ? null : function32;
        Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function36 = (32768 & i16) != 0 ? null : function33;
        ImageRequest build = new ImageRequest.Builder(context2).data(obj).lifecycle(lifecycleOwner2).build();
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, (Object) null);
        int i18 = i15 >> 6;
        int i19 = i13 << 24;
        int i21 = (i18 & 29360128) | (i18 & 7168) | 520 | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (CircularReveal.$stable << 24) | (234881024 & i19) | (BitmapPalette.$stable << 27) | (i19 & 1879048192);
        int i22 = i13 >> 6;
        CoilImage.CoilImage(build, fillMaxWidth$default, imageLoader2, alignment2, contentScale2, str2, f12, colorFilter2, circularReveal2, bitmapPalette2, i17, function34, function35, function36, startRestartGroup, i21, (i22 & 14) | (i22 & 112) | (i22 & 896) | (i22 & 7168), 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            ColorFilter colorFilter3 = colorFilter2;
            CoilImage__CoilImageKt$CoilImage$7 coilImage__CoilImageKt$CoilImage$7 = r0;
            CoilImage__CoilImageKt$CoilImage$7 coilImage__CoilImageKt$CoilImage$72 = new CoilImage__CoilImageKt$CoilImage$7(obj, companion, context2, lifecycleOwner2, imageLoader2, alignment2, contentScale2, str2, f12, colorFilter3, circularReveal2, bitmapPalette2, i17, function34, function35, function36, i12, i13, i14);
            endRestartGroup.updateScope(coilImage__CoilImageKt$CoilImage$7);
        }
    }

    @Composable
    public static final void CoilImage(@NotNull ImageRequest imageRequest, @Nullable Modifier modifier, @Nullable ImageLoader imageLoader, @Nullable Alignment alignment, @Nullable ContentScale contentScale, @Nullable String str, float f11, @Nullable ColorFilter colorFilter, @Nullable CircularReveal circularReveal, @NotNull ShimmerParams shimmerParams, @Nullable BitmapPalette bitmapPalette, @DrawableRes int i11, @Nullable Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function3, @Nullable Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function32, @Nullable Composer composer, int i12, int i13, int i14) {
        ImageLoader imageLoader2;
        int i15;
        Alignment alignment2;
        ContentScale contentScale2;
        int i16 = i14;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Intrinsics.checkNotNullParameter(shimmerParams, "shimmerParams");
        Composer startRestartGroup = composer.startRestartGroup(1486269175);
        Modifier.Companion companion = (i16 & 2) != 0 ? Modifier.Companion : modifier;
        if ((i16 & 4) != 0) {
            i15 = i12 & -897;
            imageLoader2 = LocalCoilProvider.INSTANCE.getCoilImageLoader(startRestartGroup, 8);
        } else {
            imageLoader2 = imageLoader;
            i15 = i12;
        }
        if ((i16 & 8) != 0) {
            i15 &= -7169;
            alignment2 = Alignment.Companion.getCenter();
        } else {
            alignment2 = alignment;
        }
        if ((i16 & 16) != 0) {
            i15 &= -57345;
            contentScale2 = ContentScale.Companion.getCrop();
        } else {
            contentScale2 = contentScale;
        }
        int i17 = i15;
        String str2 = (i16 & 32) != 0 ? null : str;
        float f12 = (i16 & 64) != 0 ? 1.0f : f11;
        ColorFilter colorFilter2 = (i16 & 128) != 0 ? null : colorFilter;
        CircularReveal circularReveal2 = (i16 & 256) != 0 ? null : circularReveal;
        BitmapPalette bitmapPalette2 = (i16 & 1024) != 0 ? null : bitmapPalette;
        int i18 = (i16 & 2048) != 0 ? 0 : i11;
        Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function33 = (i16 & 4096) != 0 ? null : function3;
        Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function34 = (i16 & 8192) != 0 ? null : function32;
        if (!((Boolean) startRestartGroup.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue() || i18 == 0) {
            int i19 = i18;
            startRestartGroup.startReplaceableGroup(1486270199);
            startRestartGroup.endReplaceableGroup();
            CoilImage__CoilImageKt$CoilImage$9 coilImage__CoilImageKt$CoilImage$9 = r0;
            Modifier modifier2 = companion;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, (Object) null);
            Composer composer2 = startRestartGroup;
            CoilImage__CoilImageKt$CoilImage$9 coilImage__CoilImageKt$CoilImage$92 = new CoilImage__CoilImageKt$CoilImage$9(shimmerParams, function34, i13, function33, companion, alignment2, contentScale2, str2, f12, colorFilter2, circularReveal2, i17);
            CoilImage$CoilImage__CoilImageKt(imageRequest, fillMaxWidth$default, imageLoader2, bitmapPalette2, ComposableLambdaKt.composableLambda(composer2, -819909321, true, coilImage__CoilImageKt$CoilImage$9), composer2, (BitmapPalette.$stable << 9) | 25096 | ((i13 << 9) & 7168), 0);
            ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                CoilImage__CoilImageKt$CoilImage$10 coilImage__CoilImageKt$CoilImage$10 = r0;
                CoilImage__CoilImageKt$CoilImage$10 coilImage__CoilImageKt$CoilImage$102 = new CoilImage__CoilImageKt$CoilImage$10(imageRequest, modifier2, imageLoader2, alignment2, contentScale2, str2, f12, colorFilter2, circularReveal2, shimmerParams, bitmapPalette2, i19, function33, function34, i12, i13, i14);
                endRestartGroup.updateScope(coilImage__CoilImageKt$CoilImage$10);
                return;
            }
            return;
        }
        startRestartGroup.startReplaceableGroup(1486269902);
        int i21 = i17 >> 3;
        ImageKt.Image(PainterResources_androidKt.painterResource(i18, startRestartGroup, (i13 >> 3) & 14), str2, SizeKt.fillMaxWidth$default(companion, 0.0f, 1, (Object) null), alignment2, contentScale2, f12, colorFilter2, startRestartGroup, 8 | ((i17 >> 12) & 112) | (i17 & 7168) | (57344 & i17) | (458752 & i21) | (i21 & 3670016), 0);
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            CoilImage__CoilImageKt$CoilImage$8 coilImage__CoilImageKt$CoilImage$8 = r0;
            CoilImage__CoilImageKt$CoilImage$8 coilImage__CoilImageKt$CoilImage$82 = new CoilImage__CoilImageKt$CoilImage$8(imageRequest, companion, imageLoader2, alignment2, contentScale2, str2, f12, colorFilter2, circularReveal2, shimmerParams, bitmapPalette2, i18, function33, function34, i12, i13, i14);
            endRestartGroup2.updateScope(coilImage__CoilImageKt$CoilImage$8);
        }
    }

    @Composable
    public static final void CoilImage(@NotNull ImageRequest imageRequest, @Nullable Modifier modifier, @Nullable ImageLoader imageLoader, @Nullable Alignment alignment, @Nullable ContentScale contentScale, @Nullable String str, float f11, @Nullable ColorFilter colorFilter, @Nullable CircularReveal circularReveal, @Nullable BitmapPalette bitmapPalette, @DrawableRes int i11, @Nullable Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit> function3, @Nullable Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function32, @Nullable Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function33, @Nullable Composer composer, int i12, int i13, int i14) {
        int i15;
        ImageLoader imageLoader2;
        Alignment alignment2;
        int i16;
        ContentScale contentScale2;
        int i17 = i14;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Composer startRestartGroup = composer.startRestartGroup(1486273569);
        Modifier modifier2 = (i17 & 2) != 0 ? Modifier.Companion : modifier;
        if ((i17 & 4) != 0) {
            imageLoader2 = LocalCoilProvider.INSTANCE.getCoilImageLoader(startRestartGroup, 8);
            i15 = i12 & -897;
        } else {
            imageLoader2 = imageLoader;
            i15 = i12;
        }
        if ((i17 & 8) != 0) {
            alignment2 = Alignment.Companion.getCenter();
            i15 &= -7169;
        } else {
            alignment2 = alignment;
        }
        if ((i17 & 16) != 0) {
            i16 = i15 & -57345;
            contentScale2 = ContentScale.Companion.getCrop();
        } else {
            i16 = i15;
            contentScale2 = contentScale;
        }
        String str2 = (i17 & 32) != 0 ? null : str;
        float f12 = (i17 & 64) != 0 ? 1.0f : f11;
        ColorFilter colorFilter2 = (i17 & 128) != 0 ? null : colorFilter;
        CircularReveal circularReveal2 = (i17 & 256) != 0 ? null : circularReveal;
        BitmapPalette bitmapPalette2 = (i17 & 512) != 0 ? null : bitmapPalette;
        int i18 = (i17 & 1024) != 0 ? 0 : i11;
        Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit> function34 = (i17 & 2048) != 0 ? null : function3;
        Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function35 = (i17 & 4096) != 0 ? null : function32;
        Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function36 = (i17 & 8192) != 0 ? null : function33;
        if (!((Boolean) startRestartGroup.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue() || i18 == 0) {
            int i19 = i18;
            startRestartGroup.startReplaceableGroup(1486274640);
            startRestartGroup.endReplaceableGroup();
            CoilImage$CoilImage__CoilImageKt(imageRequest, SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null), imageLoader2, bitmapPalette2, ComposableLambdaKt.composableLambda(startRestartGroup, -819905636, true, new CoilImage__CoilImageKt$CoilImage$12(function34, i13, function36, function35, modifier2, alignment2, contentScale2, str2, f12, colorFilter2, circularReveal2, i16)), startRestartGroup, ((i16 >> 18) & 7168) | (BitmapPalette.$stable << 9) | 25096, 0);
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                CoilImage__CoilImageKt$CoilImage$13 coilImage__CoilImageKt$CoilImage$13 = r0;
                CoilImage__CoilImageKt$CoilImage$13 coilImage__CoilImageKt$CoilImage$132 = new CoilImage__CoilImageKt$CoilImage$13(imageRequest, modifier2, imageLoader2, alignment2, contentScale2, str2, f12, colorFilter2, circularReveal2, bitmapPalette2, i19, function34, function35, function36, i12, i13, i14);
                endRestartGroup.updateScope(coilImage__CoilImageKt$CoilImage$13);
                return;
            }
            return;
        }
        startRestartGroup.startReplaceableGroup(1486274343);
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null);
        Painter painterResource = PainterResources_androidKt.painterResource(i18, startRestartGroup, i13 & 14);
        int i21 = i18;
        int i22 = i16 & 7168;
        int i23 = i16 >> 3;
        ImageKt.Image(painterResource, str2, fillMaxWidth$default, alignment2, contentScale2, f12, colorFilter2, startRestartGroup, i22 | ((i16 >> 12) & 112) | 8 | (57344 & i16) | (458752 & i23) | (i23 & 3670016), 0);
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new CoilImage__CoilImageKt$CoilImage$11(imageRequest, modifier2, imageLoader2, alignment2, contentScale2, str2, f12, colorFilter2, circularReveal2, bitmapPalette2, i21, function34, function35, function36, i12, i13, i14));
        }
    }
}
