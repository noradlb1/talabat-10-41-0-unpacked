package com.designsystem.ds_bottom_navigation_bar;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.RenderMode;
import com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCancellationBehavior;
import com.airbnb.lottie.compose.LottieClipSpec;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.LottieDynamicProperties;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.designsystem.ds_text.DSTextKt;
import com.designsystem.ds_theme.DSTheme;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.e;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u000f\u001a\u001d\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u0014\u001a\u001d\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u0018\u001aW\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b0\u001d2\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b ¢\u0006\u0002\b!H\u0003¢\u0006\u0002\u0010\"\u001aC\u0010#\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00170%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00172\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b0\u001dH\u0001¢\u0006\u0002\u0010(\u001a\u001d\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010+\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010,\u001a\u0015\u0010-\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010.\u001a\u001e\u0010/\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00170%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0017H\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"BottomNavigationAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomNavigationColorAnimationSpec", "Landroidx/compose/ui/graphics/Color;", "NavigationBarHeight", "", "NavigationBarItemContainerTestTag", "", "NavigationBarMaxNumberOfItems", "DynamicNavigationBarIcon", "", "animation", "isSelected", "", "(IZLandroidx/compose/runtime/Composer;I)V", "FixedFontScaleText", "text", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;I)V", "NavigationBarIcon", "item", "Lcom/designsystem/ds_bottom_navigation_bar/DSBottomNavigationBarItem;", "(Lcom/designsystem/ds_bottom_navigation_bar/DSBottomNavigationBarItem;ZLandroidx/compose/runtime/Composer;I)V", "NavigationBarItemContainer", "modifier", "Landroidx/compose/ui/Modifier;", "onNavigationItemSelected", "Lkotlin/Function1;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;ZLcom/designsystem/ds_bottom_navigation_bar/DSBottomNavigationBarItem;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "NavigationBarSurface", "items", "", "selectedItem", "onItemSelected", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Lcom/designsystem/ds_bottom_navigation_bar/DSBottomNavigationBarItem;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "StaticNavigationBarIcon", "icon", "getLabelTextStyle", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "overrideFontScale", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "indexOfOrFirst", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class BottomNavigationBarComposablesKt {
    @NotNull
    private static final TweenSpec<Float> BottomNavigationAnimationSpec = AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, (Object) null);
    @NotNull
    private static final TweenSpec<Color> BottomNavigationColorAnimationSpec = AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, (Object) null);
    private static final int NavigationBarHeight = 48;
    @NotNull
    public static final String NavigationBarItemContainerTestTag = "NavigationBarItemContainerTestTag";
    private static final int NavigationBarMaxNumberOfItems = 5;

    /* access modifiers changed from: private */
    @Composable
    public static final void DynamicNavigationBarIcon(int i11, boolean z11, Composer composer, int i12) {
        int i13;
        Composer composer2;
        float f11;
        float f12;
        int i14;
        int i15;
        int i16 = i11;
        boolean z12 = z11;
        int i17 = i12;
        Composer startRestartGroup = composer.startRestartGroup(1830851945);
        if ((i17 & 14) == 0) {
            if (startRestartGroup.changed(i16)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i13 = i15 | i17;
        } else {
            i13 = i17;
        }
        if ((i17 & 112) == 0) {
            if (startRestartGroup.changed(z12)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i13 |= i14;
        }
        if (((i13 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            LottieCompositionResult rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m9175boximpl(LottieCompositionSpec.RawRes.m9176constructorimpl(i11)), (String) null, (String) null, (String) null, (String) null, (Function3<? super Integer, ? super Throwable, ? super Continuation<? super Boolean>, ? extends Object>) null, startRestartGroup, 8, 62);
            LottieAnimationState animateLottieCompositionAsState = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(m8248DynamicNavigationBarIcon$lambda10(rememberLottieComposition), z11, false, (LottieClipSpec) null, 0.0f, 1, (LottieCancellationBehavior) null, false, startRestartGroup, (i13 & 112) | 196616, 220);
            if (z12) {
                f11 = 1.0f;
            } else {
                f11 = 0.0f;
            }
            TweenSpec<Float> tweenSpec = BottomNavigationAnimationSpec;
            State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(f11, tweenSpec, 0.0f, (Function1<? super Float, Unit>) null, startRestartGroup, 48, 12);
            if (z12) {
                f12 = 0.0f;
            } else {
                f12 = 1.0f;
            }
            State<Float> animateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f12, tweenSpec, 0.0f, (Function1<? super Float, Unit>) null, startRestartGroup, 48, 12);
            startRestartGroup.startReplaceableGroup(-1990474327);
            Modifier.Companion companion = Modifier.Companion;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r92 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r92, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r92, density, companion2.getSetDensity());
            Updater.m2543setimpl(r92, layoutDirection, companion2.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            LottieComposition r14 = m8248DynamicNavigationBarIcon$lambda10(rememberLottieComposition);
            DSTheme dSTheme = DSTheme.INSTANCE;
            Modifier alpha = AlphaKt.alpha(SizeKt.m558size3ABfNKs(companion, dSTheme.getDimens(startRestartGroup, 0).m8840getDsLD9Ej5fM()), m8251DynamicNavigationBarIcon$lambda13(animateFloatAsState2));
            composer2 = startRestartGroup;
            Composer composer3 = composer2;
            LottieAnimationKt.LottieAnimation(r14, 0.0f, alpha, false, false, false, (RenderMode) null, false, (LottieDynamicProperties) null, (Alignment) null, (ContentScale) null, false, composer3, 56, 0, 4088);
            LottieAnimationKt.LottieAnimation(m8248DynamicNavigationBarIcon$lambda10(rememberLottieComposition), m8249DynamicNavigationBarIcon$lambda11(animateLottieCompositionAsState), AlphaKt.alpha(SizeKt.m558size3ABfNKs(companion, dSTheme.getDimens(composer2, 0).m8840getDsLD9Ej5fM()), m8250DynamicNavigationBarIcon$lambda12(animateFloatAsState)), false, false, false, (RenderMode) null, false, (LottieDynamicProperties) null, (Alignment) null, (ContentScale) null, false, composer3, 8, 0, 4088);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BottomNavigationBarComposablesKt$DynamicNavigationBarIcon$2(i16, z12, i17));
        }
    }

    /* renamed from: DynamicNavigationBarIcon$lambda-10  reason: not valid java name */
    private static final LottieComposition m8248DynamicNavigationBarIcon$lambda10(LottieCompositionResult lottieCompositionResult) {
        return (LottieComposition) lottieCompositionResult.getValue();
    }

    /* renamed from: DynamicNavigationBarIcon$lambda-11  reason: not valid java name */
    private static final float m8249DynamicNavigationBarIcon$lambda11(LottieAnimationState lottieAnimationState) {
        return ((Number) lottieAnimationState.getValue()).floatValue();
    }

    /* renamed from: DynamicNavigationBarIcon$lambda-12  reason: not valid java name */
    private static final float m8250DynamicNavigationBarIcon$lambda12(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* renamed from: DynamicNavigationBarIcon$lambda-13  reason: not valid java name */
    private static final float m8251DynamicNavigationBarIcon$lambda13(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void FixedFontScaleText(String str, TextStyle textStyle, Composer composer, int i11) {
        int i12;
        Composer composer2;
        int i13;
        int i14;
        String str2 = str;
        TextStyle textStyle2 = textStyle;
        int i15 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-872846159);
        if ((i15 & 14) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i15;
        } else {
            i12 = i15;
        }
        if ((i15 & 112) == 0) {
            if (startRestartGroup.changed((Object) textStyle2)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        int i16 = i12;
        if (((i16 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            composer2 = startRestartGroup;
            String str3 = str2;
            DSTextKt.m8635DSTextqBUjsXY(str, (Modifier) null, 0.0f, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, TextOverflow.Companion.m5403getEllipsisgIe3tQ8(), false, 1, (Function1<? super TextLayoutResult, Unit>) null, textStyle, composer2, i16 & 14, ((i16 << 15) & 3670016) | 25088, 45054);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BottomNavigationBarComposablesKt$FixedFontScaleText$1(str, textStyle, i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void NavigationBarIcon(DSBottomNavigationBarItem dSBottomNavigationBarItem, boolean z11, Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(1130387584);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) dSBottomNavigationBarItem)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(z11)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else if (dSBottomNavigationBarItem.getAnimatedIcon() != null) {
            startRestartGroup.startReplaceableGroup(1130387707);
            DynamicNavigationBarIcon(dSBottomNavigationBarItem.getAnimatedIcon().intValue(), z11, startRestartGroup, i12 & 112);
            startRestartGroup.endReplaceableGroup();
        } else if (dSBottomNavigationBarItem.getIcon() != null) {
            startRestartGroup.startReplaceableGroup(1130387866);
            StaticNavigationBarIcon(dSBottomNavigationBarItem.getIcon().intValue(), z11, startRestartGroup, i12 & 112);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(1130387982);
            startRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BottomNavigationBarComposablesKt$NavigationBarIcon$1(dSBottomNavigationBarItem, z11, i11));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v0, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void NavigationBarItemContainer(androidx.compose.ui.Modifier r25, boolean r26, com.designsystem.ds_bottom_navigation_bar.DSBottomNavigationBarItem r27, kotlin.jvm.functions.Function1<? super com.designsystem.ds_bottom_navigation_bar.DSBottomNavigationBarItem, kotlin.Unit> r28, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.runtime.Composer r30, int r31) {
        /*
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r29
            r6 = r31
            r0 = 1213690512(0x48577290, float:220618.25)
            r1 = r30
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r6 & 14
            if (r1 != 0) goto L_0x0024
            r1 = r25
            boolean r8 = r0.changed((java.lang.Object) r1)
            if (r8 == 0) goto L_0x0021
            r8 = 4
            goto L_0x0022
        L_0x0021:
            r8 = 2
        L_0x0022:
            r8 = r8 | r6
            goto L_0x0027
        L_0x0024:
            r1 = r25
            r8 = r6
        L_0x0027:
            r9 = r6 & 112(0x70, float:1.57E-43)
            if (r9 != 0) goto L_0x0037
            boolean r9 = r0.changed((boolean) r2)
            if (r9 == 0) goto L_0x0034
            r9 = 32
            goto L_0x0036
        L_0x0034:
            r9 = 16
        L_0x0036:
            r8 = r8 | r9
        L_0x0037:
            r9 = r6 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0047
            boolean r9 = r0.changed((java.lang.Object) r3)
            if (r9 == 0) goto L_0x0044
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0046
        L_0x0044:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0046:
            r8 = r8 | r9
        L_0x0047:
            r9 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0057
            boolean r9 = r0.changed((java.lang.Object) r4)
            if (r9 == 0) goto L_0x0054
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0056
        L_0x0054:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0056:
            r8 = r8 | r9
        L_0x0057:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r6
            if (r9 != 0) goto L_0x0069
            boolean r9 = r0.changed((java.lang.Object) r5)
            if (r9 == 0) goto L_0x0066
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0068
        L_0x0066:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0068:
            r8 = r8 | r9
        L_0x0069:
            r15 = r8
            r8 = 46811(0xb6db, float:6.5596E-41)
            r8 = r8 & r15
            r8 = r8 ^ 9362(0x2492, float:1.3119E-41)
            if (r8 != 0) goto L_0x007e
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x0079
            goto L_0x007e
        L_0x0079:
            r0.skipToGroupEnd()
            goto L_0x01b4
        L_0x007e:
            r9 = 0
            com.designsystem.ds_theme.DSTheme r8 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r10 = 0
            com.designsystem.ds_theme.DSDimens r8 = r8.getDimens(r0, r10)
            float r10 = r8.m8846getDsXxsD9Ej5fM()
            r11 = 0
            r12 = 0
            r13 = 13
            r14 = 0
            r8 = r25
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r8, r9, r10, r11, r12, r13, r14)
            java.lang.String r9 = "NavigationBarItemContainerTestTag"
            androidx.compose.ui.Modifier r16 = androidx.compose.ui.platform.TestTagKt.testTag(r8, r9)
            r19 = r2 ^ 1
            androidx.compose.foundation.interaction.MutableInteractionSource r17 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r18 = 0
            r20 = 0
            r21 = 0
            int r8 = r15 >> 3
            r9 = -3686552(0xffffffffffc7bf68, float:NaN)
            r0.startReplaceableGroup(r9)
            boolean r9 = r0.changed((java.lang.Object) r4)
            boolean r10 = r0.changed((java.lang.Object) r3)
            r9 = r9 | r10
            java.lang.Object r10 = r0.rememberedValue()
            if (r9 != 0) goto L_0x00c6
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r10 != r9) goto L_0x00ce
        L_0x00c6:
            com.designsystem.ds_bottom_navigation_bar.BottomNavigationBarComposablesKt$NavigationBarItemContainer$1$1 r10 = new com.designsystem.ds_bottom_navigation_bar.BottomNavigationBarComposablesKt$NavigationBarItemContainer$1$1
            r10.<init>(r4, r3)
            r0.updateRememberedValue(r10)
        L_0x00ce:
            r0.endReplaceableGroup()
            r22 = r10
            kotlin.jvm.functions.Function0 r22 = (kotlin.jvm.functions.Function0) r22
            r23 = 24
            r24 = 0
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r10 = r10.getCenterHorizontally()
            r8 = r8 & 7168(0x1c00, float:1.0045E-41)
            r11 = -1113031299(0xffffffffbda87d7d, float:-0.0822706)
            r0.startReplaceableGroup(r11)
            androidx.compose.foundation.layout.Arrangement r11 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r11 = r11.getTop()
            int r12 = r8 >> 3
            r13 = r12 & 14
            r12 = r12 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r11, r10, r0, r12)
            int r11 = r8 << 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            r12 = 1376089335(0x520574f7, float:1.43298249E11)
            r0.startReplaceableGroup(r12)
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.ui.unit.LayoutDirection r13 = (androidx.compose.ui.unit.LayoutDirection) r13
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r9 = androidx.compose.ui.layout.LayoutKt.materializerOf(r9)
            int r11 = r11 << 9
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            androidx.compose.runtime.Applier r7 = r0.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x0133
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0133:
            r0.startReusableNode()
            boolean r7 = r0.getInserting()
            if (r7 == 0) goto L_0x0140
            r0.createNode(r15)
            goto L_0x0143
        L_0x0140:
            r0.useNode()
        L_0x0143:
            r0.disableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r15 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r10, r15)
            kotlin.jvm.functions.Function2 r10 = r14.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r12, r10)
            kotlin.jvm.functions.Function2 r10 = r14.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r7, r13, r10)
            r0.enableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r7)
            int r10 = r11 >> 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r9.invoke(r7, r0, r10)
            r7 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r7)
            int r7 = r11 >> 9
            r7 = r7 & 14
            r9 = 276693241(0x107e00f9, float:5.0093417E-29)
            r0.startReplaceableGroup(r9)
            r7 = r7 & 11
            r9 = 2
            r7 = r7 ^ r9
            if (r7 != 0) goto L_0x0196
            boolean r7 = r0.getSkipping()
            if (r7 != 0) goto L_0x0192
            goto L_0x0196
        L_0x0192:
            r0.skipToGroupEnd()
            goto L_0x01a5
        L_0x0196:
            androidx.compose.foundation.layout.ColumnScopeInstance r7 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            int r8 = r8 >> 6
            r8 = r8 & 112(0x70, float:1.57E-43)
            r8 = r8 | 6
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r5.invoke(r7, r0, r8)
        L_0x01a5:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x01b4:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x01bb
            goto L_0x01d0
        L_0x01bb:
            com.designsystem.ds_bottom_navigation_bar.BottomNavigationBarComposablesKt$NavigationBarItemContainer$2 r8 = new com.designsystem.ds_bottom_navigation_bar.BottomNavigationBarComposablesKt$NavigationBarItemContainer$2
            r0 = r8
            r1 = r25
            r2 = r26
            r3 = r27
            r4 = r28
            r5 = r29
            r6 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.updateScope(r8)
        L_0x01d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_bottom_navigation_bar.BottomNavigationBarComposablesKt.NavigationBarItemContainer(androidx.compose.ui.Modifier, boolean, com.designsystem.ds_bottom_navigation_bar.DSBottomNavigationBarItem, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int):void");
    }

    @Composable
    public static final void NavigationBarSurface(@NotNull Modifier modifier, @NotNull List<DSBottomNavigationBarItem> list, @Nullable DSBottomNavigationBarItem dSBottomNavigationBarItem, @NotNull Function1<? super DSBottomNavigationBarItem, Unit> function1, @Nullable Composer composer, int i11, int i12) {
        DSBottomNavigationBarItem dSBottomNavigationBarItem2;
        boolean z11;
        boolean z12;
        boolean z13;
        Modifier modifier2 = modifier;
        List<DSBottomNavigationBarItem> list2 = list;
        Function1<? super DSBottomNavigationBarItem, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(list2, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function12, "onItemSelected");
        Composer startRestartGroup = composer.startRestartGroup(1849812473);
        if ((i12 & 4) != 0) {
            dSBottomNavigationBarItem2 = null;
        } else {
            dSBottomNavigationBarItem2 = dSBottomNavigationBarItem;
        }
        if (!list2.isEmpty()) {
            int size = list.size();
        }
        Iterable<DSBottomNavigationBarItem> iterable = list2;
        boolean z14 = iterable instanceof Collection;
        if (!z14 || !((Collection) iterable).isEmpty()) {
            for (DSBottomNavigationBarItem dSBottomNavigationBarItem3 : iterable) {
                if (dSBottomNavigationBarItem3.getIcon() == null || dSBottomNavigationBarItem3.getAnimatedIcon() == null) {
                    z13 = true;
                    continue;
                } else {
                    z13 = false;
                    continue;
                }
                if (!z13) {
                    break;
                }
            }
        }
        if (!z14 || !((Collection) iterable).isEmpty()) {
            for (DSBottomNavigationBarItem dSBottomNavigationBarItem4 : iterable) {
                if (dSBottomNavigationBarItem4.getIcon() == null && dSBottomNavigationBarItem4.getAnimatedIcon() == null) {
                    z12 = true;
                    continue;
                } else {
                    z12 = false;
                    continue;
                }
                if (z12) {
                    break;
                }
            }
        }
        startRestartGroup.startReplaceableGroup(-3687241);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(indexOfOrFirst(list2, dSBottomNavigationBarItem2)), (SnapshotMutationPolicy) null, 2, (Object) null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null);
        DSTheme dSTheme = DSTheme.INSTANCE;
        Modifier r52 = SizeKt.m544height3ABfNKs(PaddingKt.m490paddingqDBjuR0$default(fillMaxWidth$default, dSTheme.getDimens(startRestartGroup, 0).m8842getDsSD9Ej5fM(), 0.0f, dSTheme.getDimens(startRestartGroup, 0).m8842getDsSD9Ej5fM(), dSTheme.getDimens(startRestartGroup, 0).m8842getDsSD9Ej5fM(), 2, (Object) null), Dp.m5478constructorimpl((float) 48));
        startRestartGroup.startReplaceableGroup(-1989997546);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(1376089335);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r52);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r11 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r11, rowMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r11, density, companion.getSetDensity());
        Updater.m2543setimpl(r11, layoutDirection, companion.getSetLayoutDirection());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-326682743);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        int i13 = 0;
        for (Object next : iterable) {
            int i14 = i13 + 1;
            if (i13 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            DSBottomNavigationBarItem dSBottomNavigationBarItem5 = (DSBottomNavigationBarItem) next;
            Modifier weight$default = e.a(rowScopeInstance, Modifier.Companion, 1.0f, false, 2, (Object) null);
            if (i13 == m8252NavigationBarSurface$lambda6(mutableState)) {
                z11 = true;
            } else {
                z11 = false;
            }
            NavigationBarItemContainer(weight$default, z11, dSBottomNavigationBarItem5, new BottomNavigationBarComposablesKt$NavigationBarSurface$6$1$1(list2, function12, mutableState), ComposableLambdaKt.composableLambda(startRestartGroup, -819893701, true, new BottomNavigationBarComposablesKt$NavigationBarSurface$6$1$2(dSBottomNavigationBarItem5, i13, mutableState)), startRestartGroup, CpioConstants.C_ISBLK);
            i13 = i14;
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BottomNavigationBarComposablesKt$NavigationBarSurface$7(modifier, list, dSBottomNavigationBarItem2, function1, i11, i12));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: NavigationBarSurface$lambda-6  reason: not valid java name */
    public static final int m8252NavigationBarSurface$lambda6(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: NavigationBarSurface$lambda-7  reason: not valid java name */
    public static final void m8253NavigationBarSurface$lambda7(MutableState<Integer> mutableState, int i11) {
        mutableState.setValue(Integer.valueOf(i11));
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void StaticNavigationBarIcon(int i11, boolean z11, Composer composer, int i12) {
        int i13;
        long j11;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-973580507);
        if ((i12 & 14) == 0) {
            if (startRestartGroup.changed(i11)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i13 = i15 | i12;
        } else {
            i13 = i12;
        }
        if ((i12 & 112) == 0) {
            if (startRestartGroup.changed(z11)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i13 |= i14;
        }
        if (((i13 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            if (z11) {
                startRestartGroup.startReplaceableGroup(-973580360);
                j11 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8793getDsPrimary1000d7_KjU();
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-973580303);
                j11 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8766getDsNeutral400d7_KjU();
                startRestartGroup.endReplaceableGroup();
            }
            State<Color> r12 = SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(j11, BottomNavigationColorAnimationSpec, (Function1<? super Color, Unit>) null, startRestartGroup, 48, 4);
            IconKt.m1278Iconww6aTOc(PainterResources_androidKt.painterResource(i11, startRestartGroup, i13 & 14), (String) null, SizeKt.m558size3ABfNKs(Modifier.Companion, DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8840getDsLD9Ej5fM()), m8254StaticNavigationBarIcon$lambda15(r12), startRestartGroup, 56, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BottomNavigationBarComposablesKt$StaticNavigationBarIcon$1(i11, z11, i12));
        }
    }

    /* renamed from: StaticNavigationBarIcon$lambda-15  reason: not valid java name */
    private static final long m8254StaticNavigationBarIcon$lambda15(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* access modifiers changed from: private */
    @Composable
    public static final TextStyle getLabelTextStyle(boolean z11, Composer composer, int i11) {
        float f11;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1607374105);
        DSTheme dSTheme = DSTheme.INSTANCE;
        TextStyle overrideFontScale = overrideFontScale(TextStyle.m5046copyHL5avdY$default(dSTheme.getTypography(composer2, 0).getDsSubheadingXSmall(), dSTheme.getColors(composer2, 0).m8773getDsNeutral800d7_KjU(), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null), composer2, 0);
        TextStyle overrideFontScale2 = overrideFontScale(TextStyle.m5046copyHL5avdY$default(dSTheme.getTypography(composer2, 0).getDsBodyXSmall(), dSTheme.getColors(composer2, 0).m8766getDsNeutral400d7_KjU(), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null), composer2, 0);
        if (z11) {
            f11 = 1.0f;
        } else {
            f11 = 0.0f;
        }
        TextStyle lerp = TextStyleKt.lerp(overrideFontScale2, overrideFontScale, m8257getLabelTextStyle$lambda18(AnimateAsStateKt.animateFloatAsState(f11, BottomNavigationAnimationSpec, 0.0f, (Function1<? super Float, Unit>) null, composer, 48, 12)));
        composer.endReplaceableGroup();
        return lerp;
    }

    /* renamed from: getLabelTextStyle$lambda-18  reason: not valid java name */
    private static final float m8257getLabelTextStyle$lambda18(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    public static final int indexOfOrFirst(List<DSBottomNavigationBarItem> list, DSBottomNavigationBarItem dSBottomNavigationBarItem) {
        int indexOf = CollectionsKt___CollectionsKt.indexOf(list, dSBottomNavigationBarItem);
        if (indexOf == -1) {
            return 0;
        }
        return indexOf;
    }

    @Composable
    private static final TextStyle overrideFontScale(TextStyle textStyle, Composer composer, int i11) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-924181038);
        Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
        TextStyle r12 = TextStyle.m5046copyHL5avdY$default(textStyle, 0, density.m5449toSp0xMU5do(Dp.m5478constructorimpl(TextUnit.m5659getValueimpl(textStyle.m5057getFontSizeXSAIIZE()))), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, density.m5449toSp0xMU5do(Dp.m5478constructorimpl(TextUnit.m5659getValueimpl(textStyle.m5061getLineHeightXSAIIZE()))), (TextIndent) null, 196605, (Object) null);
        composer.endReplaceableGroup();
        return r12;
    }
}
