package com.designsystem.ds_image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.unit.Dp;
import coil.ImageLoader;
import coil.request.ImageRequest;
import coil.transform.BlurTransformation;
import com.designsystem.ds_theme.DSTheme;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import com.instabug.library.internal.video.RequestPermissionActivity;
import com.skydoves.landscapist.CircularReveal;
import com.skydoves.landscapist.DrawablePainterKt;
import com.skydoves.landscapist.coil.CoilImage;
import com.skydoves.landscapist.coil.CoilImageState;
import com.skydoves.landscapist.palette.BitmapPalette;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a«\u0001\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132*\b\u0002\u0010\u0014\u001a$\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015¢\u0006\u0002\b\u001a2*\b\u0002\u0010\u001b\u001a$\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015¢\u0006\u0002\b\u001a2*\b\u0002\u0010\u001d\u001a$\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015¢\u0006\u0002\b\u001aH\u0001¢\u0006\u0002\u0010\u001f\u001a\u001d\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0001¢\u0006\u0002\u0010\"\u001a\r\u0010#\u001a\u00020\rH\u0001¢\u0006\u0002\u0010$\u001a\r\u0010%\u001a\u00020\rH\u0001¢\u0006\u0002\u0010$\u001a%\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010)\u001aL\u0010*\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010\u00052\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020\r00¢\u0006\u0002\b\u001aH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\u001a\u001d\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0007\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\b\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\t\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"RatioImageAnimationDuration", "", "RatioImageBlurredPlaceholderTestTag", "", "RatioImageErrorIconBreakpointSize", "Landroidx/compose/ui/unit/Dp;", "F", "RatioImageErrorIconLargeSize", "RatioImageErrorIconSmallSize", "RatioImageErrorTestTag", "RatioImageLocalPlaceholderTestTag", "RatioImageTestTag", "CrossfadedRatioImage", "", "imageRequest", "Lcoil/request/ImageRequest;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "modifier", "Landroidx/compose/ui/Modifier;", "loading", "Lkotlin/Function1;", "Lcom/skydoves/landscapist/coil/CoilImageState$Loading;", "Lkotlin/ParameterName;", "name", "imageState", "Landroidx/compose/runtime/Composable;", "success", "Lcom/skydoves/landscapist/coil/CoilImageState$Success;", "failure", "Lcom/skydoves/landscapist/coil/CoilImageState$Failure;", "(Lcoil/request/ImageRequest;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "RatioImageBlurredPlaceholder", "placeholderImageUrl", "(Ljava/lang/String;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/runtime/Composer;I)V", "RatioImageError", "(Landroidx/compose/runtime/Composer;I)V", "RatioImageLocalPlaceholder", "RatioImageSuccess", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "RatioImageSurface", "cornerRadius", "borderColor", "Landroidx/compose/ui/graphics/Color;", "borderWidth", "content", "Lkotlin/Function0;", "RatioImageSurface-yVuOV74", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/unit/Dp;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "iconSize", "size", "iconSize-8Feqmps", "(FLandroidx/compose/runtime/Composer;I)F", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class RatioImageComposablesKt {
    public static final int RatioImageAnimationDuration = 150;
    @NotNull
    public static final String RatioImageBlurredPlaceholderTestTag = "RatioImageBlurredPlaceholderTestTag";
    private static final float RatioImageErrorIconBreakpointSize = Dp.m5478constructorimpl((float) 100);
    private static final float RatioImageErrorIconLargeSize = Dp.m5478constructorimpl((float) 46);
    private static final float RatioImageErrorIconSmallSize = Dp.m5478constructorimpl((float) 24);
    @NotNull
    public static final String RatioImageErrorTestTag = "RatioImageErrorTestTag";
    @NotNull
    public static final String RatioImageLocalPlaceholderTestTag = "RatioImageLocalPlaceholderTestTag";
    @NotNull
    public static final String RatioImageTestTag = "RatioImageTestTag";

    @Composable
    public static final void CrossfadedRatioImage(@NotNull ImageRequest imageRequest, @NotNull ContentScale contentScale, @Nullable Modifier modifier, @Nullable Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit> function3, @Nullable Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function32, @Nullable Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function33, @Nullable Composer composer, int i11, int i12) {
        Modifier.Companion companion;
        Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit> function34;
        Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function35;
        Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function36;
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Composer startRestartGroup = composer.startRestartGroup(673866156);
        if ((i12 & 4) != 0) {
            companion = Modifier.Companion;
        } else {
            companion = modifier;
        }
        if ((i12 & 8) != 0) {
            function34 = null;
        } else {
            function34 = function3;
        }
        if ((i12 & 16) != 0) {
            function35 = null;
        } else {
            function35 = function32;
        }
        if ((i12 & 32) != 0) {
            function36 = null;
        } else {
            function36 = function33;
        }
        startRestartGroup.startReplaceableGroup(-3687241);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CoilImageState.None.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        CoilImage.CoilImage(imageRequest, (Modifier) null, (ImageLoader) null, (Alignment) null, contentScale, (String) null, 0.0f, (ColorFilter) null, (CircularReveal) null, (BitmapPalette) null, 0, (Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819892704, true, new RatioImageComposablesKt$CrossfadedRatioImage$1(mutableState)), (Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819892342, true, new RatioImageComposablesKt$CrossfadedRatioImage$2(mutableState)), (Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819892649, true, new RatioImageComposablesKt$CrossfadedRatioImage$3(mutableState)), startRestartGroup, ((i11 << 9) & 57344) | 8, 3504, (int) RequestPermissionActivity.REQUEST_MEDIA_PROJECTION_PERMISSION);
        Composer composer2 = startRestartGroup;
        CrossfadeKt.Crossfade(m8362CrossfadedRatioImage$lambda1(mutableState), (Modifier) null, AnimationSpecKt.tween$default(150, 0, EasingKt.getLinearEasing(), 2, (Object) null), ComposableLambdaKt.composableLambda(composer2, -819892371, true, new RatioImageComposablesKt$CrossfadedRatioImage$4(function34, i11, function36, function35, contentScale, companion)), composer2, CoilImageState.$stable | KfsConstant.KFS_RSA_KEY_LEN_3072, 2);
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RatioImageComposablesKt$CrossfadedRatioImage$5(imageRequest, contentScale, companion, function34, function35, function36, i11, i12));
        }
    }

    /* renamed from: CrossfadedRatioImage$lambda-1  reason: not valid java name */
    private static final CoilImageState m8362CrossfadedRatioImage$lambda1(MutableState<CoilImageState> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: CrossfadedRatioImage$lambda-2  reason: not valid java name */
    public static final void m8363CrossfadedRatioImage$lambda2(MutableState<CoilImageState> mutableState, CoilImageState coilImageState) {
        mutableState.setValue(coilImageState);
    }

    @Composable
    public static final void RatioImageBlurredPlaceholder(@NotNull String str, @NotNull ContentScale contentScale, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Intrinsics.checkNotNullParameter(str, "placeholderImageUrl");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Composer startRestartGroup = composer.startRestartGroup(-688842975);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) str)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) contentScale)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            ImageRequest build = new ImageRequest.Builder((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())).data(str).transformations(new BlurTransformation((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), 0.0f, 0.0f, 6, (DefaultConstructorMarker) null)).build();
            Modifier testTag = TestTagKt.testTag(Modifier.Companion, RatioImageBlurredPlaceholderTestTag);
            ComposableSingletons$RatioImageComposablesKt composableSingletons$RatioImageComposablesKt = ComposableSingletons$RatioImageComposablesKt.INSTANCE;
            CrossfadedRatioImage(build, contentScale, testTag, composableSingletons$RatioImageComposablesKt.m8358getLambda1$marshmallow_release(), (Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit>) null, composableSingletons$RatioImageComposablesKt.m8359getLambda2$marshmallow_release(), startRestartGroup, (i12 & 112) | 392, 16);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RatioImageComposablesKt$RatioImageBlurredPlaceholder$1(str, contentScale, i11));
        }
    }

    @Composable
    public static final void RatioImageError(@Nullable Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-849320413);
        if (i11 != 0 || !startRestartGroup.getSkipping()) {
            BoxWithConstraintsKt.BoxWithConstraints(TestTagKt.testTag(SizeKt.fillMaxSize$default(BackgroundKt.m177backgroundbw27NRU$default(Modifier.Companion, DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8765getDsNeutral40d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null), RatioImageErrorTestTag), Alignment.Companion.getCenter(), false, ComposableSingletons$RatioImageComposablesKt.INSTANCE.m8360getLambda3$marshmallow_release(), startRestartGroup, 0, 4);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RatioImageComposablesKt$RatioImageError$1(i11));
        }
    }

    @Composable
    public static final void RatioImageLocalPlaceholder(@Nullable Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-2090968871);
        if (i11 != 0 || !startRestartGroup.getSkipping()) {
            BoxKt.Box(TestTagKt.testTag(SizeKt.fillMaxSize$default(BackgroundKt.m177backgroundbw27NRU$default(Modifier.Companion, DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8765getDsNeutral40d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null), RatioImageLocalPlaceholderTestTag), startRestartGroup, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RatioImageComposablesKt$RatioImageLocalPlaceholder$1(i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void RatioImageSuccess(Drawable drawable, ContentScale contentScale, Modifier modifier, Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(693908951);
        ImageKt.Image(DrawablePainterKt.rememberDrawablePainter(drawable, startRestartGroup, 8), (String) null, SizeKt.fillMaxSize$default(modifier, 0.0f, 1, (Object) null), Alignment.Companion.getCenter(), contentScale, 0.0f, (ColorFilter) null, startRestartGroup, ((i11 << 9) & 57344) | 56, 96);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RatioImageComposablesKt$RatioImageSuccess$1(drawable, contentScale, modifier, i11));
        }
    }

    @Composable
    /* renamed from: RatioImageSurface-yVuOV74  reason: not valid java name */
    public static final void m8364RatioImageSurfaceyVuOV74(@NotNull Modifier modifier, float f11, @Nullable Color color, @Nullable Dp dp2, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        BorderStroke borderStroke;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Modifier modifier2 = modifier;
        Color color2 = color;
        Dp dp3 = dp2;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i18 = i11;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(function22, "content");
        Composer startRestartGroup = composer.startRestartGroup(1125979932);
        if ((i18 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i12 = i17 | i18;
        } else {
            i12 = i18;
        }
        float f12 = f11;
        if ((i18 & 112) == 0) {
            if (startRestartGroup.changed(f12)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i12 |= i16;
        }
        if ((i18 & 896) == 0) {
            if (startRestartGroup.changed((Object) color2)) {
                i15 = 256;
            } else {
                i15 = 128;
            }
            i12 |= i15;
        }
        if ((i18 & 7168) == 0) {
            if (startRestartGroup.changed((Object) dp3)) {
                i14 = 2048;
            } else {
                i14 = 1024;
            }
            i12 |= i14;
        }
        if ((57344 & i18) == 0) {
            if (startRestartGroup.changed((Object) function22)) {
                i13 = 16384;
            } else {
                i13 = 8192;
            }
            i12 |= i13;
        }
        if (((46811 & i12) ^ 9362) != 0 || !startRestartGroup.getSkipping()) {
            if (color2 == null || dp3 == null) {
                borderStroke = null;
            } else {
                borderStroke = BorderStrokeKt.m191BorderStrokecXLIe8U(dp2.m5492unboximpl(), color.m2929unboximpl());
            }
            int i19 = (i12 & 14) | ((i12 << 6) & 3670016);
            Modifier modifier3 = modifier;
            composer2 = startRestartGroup;
            SurfaceKt.m1384SurfaceFjzlyU(modifier3, RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(f11), 0, 0, borderStroke, 0.0f, function2, startRestartGroup, i19, 44);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RatioImageComposablesKt$RatioImageSurface$1(modifier, f11, color, dp2, function2, i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    /* renamed from: iconSize-8Feqmps  reason: not valid java name */
    public static final float m8367iconSize8Feqmps(float f11, Composer composer, int i11) {
        float f12;
        composer.startReplaceableGroup(-808347396);
        if (Dp.m5477compareTo0680j_4(f11, RatioImageErrorIconBreakpointSize) <= 0) {
            f12 = RatioImageErrorIconSmallSize;
        } else {
            f12 = RatioImageErrorIconLargeSize;
        }
        composer.endReplaceableGroup();
        return f12;
    }
}
