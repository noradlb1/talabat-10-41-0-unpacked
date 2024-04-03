package com.talabat.feature.ridertips.presentation.view.mainview;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
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
import com.designsystem.ds_theme.DSTheme;
import com.talabat.feature.ridertips.presentation.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.e;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"HeaderView", "", "title", "", "subtitle", "onTap", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "com_talabat_feature_ridertips_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class HeaderViewKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void HeaderView(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        String str3 = str;
        String str4 = str2;
        Function0<Unit> function02 = function0;
        int i13 = i11;
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, "subtitle");
        Intrinsics.checkNotNullParameter(function02, "onTap");
        Composer startRestartGroup = composer.startRestartGroup(-85138015);
        if ((i13 & 14) == 0) {
            i12 = (startRestartGroup.changed((Object) str3) ? 4 : 2) | i13;
        } else {
            i12 = i13;
        }
        if ((i13 & 112) == 0) {
            i12 |= startRestartGroup.changed((Object) str4) ? 32 : 16;
        }
        if ((i13 & 896) == 0) {
            i12 |= startRestartGroup.changed((Object) function02) ? 256 : 128;
        }
        int i14 = i12;
        if ((i14 & 731) != 146 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startReplaceableGroup(693286680);
            Modifier.Companion companion = Modifier.Companion;
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Horizontal start = arrangement.getStart();
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion2.getTop(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Composer r62 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r62, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r62, density, companion3.getSetDensity());
            Updater.m2543setimpl(r62, layoutDirection, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r62, viewConfiguration, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-678309503);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion4 = companion;
            LottieCompositionResult rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m9175boximpl(LottieCompositionSpec.RawRes.m9176constructorimpl(R.raw.rider)), (String) null, (String) null, (String) null, (String) null, (Function3<? super Integer, ? super Throwable, ? super Continuation<? super Boolean>, ? extends Object>) null, startRestartGroup, 0, 62);
            int i15 = i14;
            LottieAnimationKt.LottieAnimation(m10288HeaderView$lambda5$lambda0(rememberLottieComposition), m10289HeaderView$lambda5$lambda1(AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(m10288HeaderView$lambda5$lambda0(rememberLottieComposition), true, false, (LottieClipSpec) null, 0.0f, Integer.MAX_VALUE, (LottieCancellationBehavior) null, false, startRestartGroup, 196664, 220)), SizeKt.m558size3ABfNKs(companion4, Dp.m5478constructorimpl((float) 76)), false, false, false, (RenderMode) null, false, (LottieDynamicProperties) null, (Alignment) null, (ContentScale) null, false, startRestartGroup, 392, 0, 4088);
            DSTheme dSTheme = DSTheme.INSTANCE;
            SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion4, dSTheme.getDimens(startRestartGroup, 8).m8846getDsXxsD9Ej5fM()), startRestartGroup, 0);
            Modifier r22 = PaddingKt.m490paddingqDBjuR0$default(companion4, 0.0f, dSTheme.getDimens(startRestartGroup, 8).m8842getDsSD9Ej5fM(), dSTheme.getDimens(startRestartGroup, 8).m8842getDsSD9Ej5fM(), dSTheme.getDimens(startRestartGroup, 8).m8842getDsSD9Ej5fM(), 1, (Object) null);
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(r22);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r72 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r72, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r72, density2, companion3.getSetDensity());
            Updater.m2543setimpl(r72, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r72, viewConfiguration2, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1163856341);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(companion4);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r63 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r63, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r63, density3, companion3.getSetDensity());
            Updater.m2543setimpl(r63, layoutDirection3, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r63, viewConfiguration3, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-678309503);
            Composer composer3 = startRestartGroup;
            DSTheme dSTheme2 = dSTheme;
            TextKt.m1461TextfLXpl1I(str, e.a(rowScopeInstance, companion4, 6.0f, false, 2, (Object) null), 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, true, 2, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m5046copyHL5avdY$default(dSTheme.getTypography(startRestartGroup, 8).getDsHeading2(), dSTheme.getColors(startRestartGroup, 8).m8760getDsNeutral1000d7_KjU(), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null), composer3, i15 & 14, 3456, 20476);
            Composer composer4 = composer3;
            DSTheme dSTheme3 = dSTheme2;
            Modifier.Companion companion5 = companion4;
            Modifier a11 = e.a(rowScopeInstance, ClickableKt.m196clickableXHw0xAI$default(SizeKt.m563width3ABfNKs(companion5, dSTheme3.getDimens(composer4, 8).m8845getDsXxlD9Ej5fM()), false, (String) null, (Role) null, function0, 7, (Object) null), 1.0f, false, 2, (Object) null);
            composer4.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, composer4, 0);
            composer4.startReplaceableGroup(-1323940314);
            Density density4 = (Density) composer4.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection4 = (LayoutDirection) composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration4 = (ViewConfiguration) composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf4 = LayoutKt.materializerOf(a11);
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor4);
            } else {
                composer4.useNode();
            }
            composer4.disableReusing();
            Composer r52 = Updater.m2536constructorimpl(composer4);
            Updater.m2543setimpl(r52, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r52, density4, companion3.getSetDensity());
            Updater.m2543setimpl(r52, layoutDirection4, companion3.getSetLayoutDirection());
            Updater.m2543setimpl(r52, viewConfiguration4, companion3.getSetViewConfiguration());
            composer4.enableReusing();
            materializerOf4.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer4)), composer4, 0);
            composer4.startReplaceableGroup(2058660585);
            composer4.startReplaceableGroup(-2137368960);
            DSTheme dSTheme4 = dSTheme3;
            Composer composer5 = composer4;
            SurfaceKt.m1384SurfaceFjzlyU(BoxScopeInstance.INSTANCE.align(ClipKt.clip(companion5, RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(dSTheme3.getDimens(composer4, 8).m8840getDsLD9Ej5fM())), companion2.getTopCenter()), (Shape) null, 0, 0, (BorderStroke) null, 0.0f, ComposableSingletons$HeaderViewKt.INSTANCE.m10287getLambda1$com_talabat_feature_ridertips_presentation_presentation(), composer4, 1572864, 62);
            composer5.endReplaceableGroup();
            composer5.endReplaceableGroup();
            composer5.endNode();
            composer5.endReplaceableGroup();
            composer5.endReplaceableGroup();
            composer5.endReplaceableGroup();
            composer5.endReplaceableGroup();
            composer5.endNode();
            composer5.endReplaceableGroup();
            composer5.endReplaceableGroup();
            Composer composer6 = composer5;
            SpacerKt.Spacer(SizeKt.m544height3ABfNKs(companion5, dSTheme4.getDimens(composer6, 8).m8848getDsXxxsD9Ej5fM()), composer6, 0);
            DSTheme dSTheme5 = dSTheme4;
            Composer composer7 = composer6;
            composer2 = composer7;
            TextKt.m1461TextfLXpl1I(str2, (Modifier) null, 0, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m5046copyHL5avdY$default(dSTheme5.getTypography(composer7, 8).getDsBody1(), dSTheme5.getColors(composer7, 8).m8769getDsNeutral550d7_KjU(), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null), composer7, (i15 >> 3) & 14, 0, 32766);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
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
            endRestartGroup.updateScope(new HeaderViewKt$HeaderView$2(str, str2, function0, i11));
        }
    }

    /* renamed from: HeaderView$lambda-5$lambda-0  reason: not valid java name */
    private static final LottieComposition m10288HeaderView$lambda5$lambda0(LottieCompositionResult lottieCompositionResult) {
        return (LottieComposition) lottieCompositionResult.getValue();
    }

    /* renamed from: HeaderView$lambda-5$lambda-1  reason: not valid java name */
    private static final float m10289HeaderView$lambda5$lambda1(LottieAnimationState lottieAnimationState) {
        return ((Number) lottieAnimationState.getValue()).floatValue();
    }
}
