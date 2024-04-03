package com.designsystem.ds_navigation_bar;

import android.content.Context;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.behaviour.base.DSNavigationBarAnimationBehaviour;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.e;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\t\u001a\u0017\u0010\n\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0001¢\u0006\u0002\u0010\r\u001ai\u0010\u000e\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u00162\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a#\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001bH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"NavigationBarContent", "", "title", "", "subtitle", "content", "Landroidx/compose/foundation/layout/RowScope;", "behaviour", "Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/foundation/layout/RowScope;Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;Landroidx/compose/runtime/Composer;I)V", "NavigationBarElevation", "elevationOpacity", "", "(Ljava/lang/Float;Landroidx/compose/runtime/Composer;I)V", "NavigationBarSurface", "modifier", "Landroidx/compose/ui/Modifier;", "leadingIcon", "Lcom/designsystem/ds_icon_button/DSIconButtonModel;", "trailingContainer", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/runtime/Composable;", "backgroundOpacity", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lcom/designsystem/ds_icon_button/DSIconButtonModel;Lkotlin/jvm/functions/Function3;Lcom/designsystem/ds_navigation_bar/behaviour/base/DSNavigationBarAnimationBehaviour;Ljava/lang/Float;Ljava/lang/Float;Landroidx/compose/runtime/Composer;I)V", "animateChipColorAsState", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "targetValue", "animateChipColorAsState-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class NavigationBarComposablesKt {
    @Composable
    public static final void NavigationBarContent(@Nullable String str, @Nullable String str2, @NotNull RowScope rowScope, @NotNull DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        float f11;
        String str3;
        boolean z11;
        int i13;
        int i14;
        int i15;
        int i16;
        String str4 = str;
        String str5 = str2;
        RowScope rowScope2 = rowScope;
        DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour2 = dSNavigationBarAnimationBehaviour;
        int i17 = i11;
        Intrinsics.checkNotNullParameter(rowScope2, "content");
        Intrinsics.checkNotNullParameter(dSNavigationBarAnimationBehaviour2, "behaviour");
        Composer startRestartGroup = composer.startRestartGroup(-169443999);
        if ((i17 & 14) == 0) {
            if (startRestartGroup.changed((Object) str4)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i12 = i16 | i17;
        } else {
            i12 = i17;
        }
        if ((i17 & 112) == 0) {
            if (startRestartGroup.changed((Object) str5)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i12 |= i15;
        }
        if ((i17 & 896) == 0) {
            if (startRestartGroup.changed((Object) rowScope2)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i12 |= i14;
        }
        if ((i17 & 7168) == 0) {
            if (startRestartGroup.changed((Object) dSNavigationBarAnimationBehaviour2)) {
                i13 = 2048;
            } else {
                i13 = 1024;
            }
            i12 |= i13;
        }
        int i18 = i12;
        if (((i18 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            State<Float> observeAsState = LiveDataAdapterKt.observeAsState(dSNavigationBarAnimationBehaviour.getOpacity(), startRestartGroup, 8);
            float f12 = ((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getConfiguration().fontScale;
            DSTheme dSTheme = DSTheme.INSTANCE;
            long r16 = dSTheme.getColors(startRestartGroup, 0).m8760getDsNeutral1000d7_KjU();
            Float value = observeAsState.getValue();
            if (value == null) {
                f11 = 1.0f;
            } else {
                f11 = value.floatValue();
            }
            State<Color> r162 = m8503animateChipColorAsStateek8zF_U(Color.m2918copywmQWz5c$default(r16, f11, 0.0f, 0.0f, 0.0f, 14, (Object) null), startRestartGroup, 0);
            Modifier.Companion companion = Modifier.Companion;
            Modifier.Companion companion2 = companion;
            Modifier weight$default = e.a(rowScope, companion, 1.0f, false, 2, (Object) null);
            startRestartGroup.startReplaceableGroup(-1113031299);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(weight$default);
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
            Composer r72 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r72, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r72, density, companion3.getSetDensity());
            Updater.m2543setimpl(r72, layoutDirection, companion3.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(276693241);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (str4 != null) {
                str3 = str4;
            } else {
                str3 = "";
            }
            TextStyle dsHeading2 = dSTheme.getTypography(startRestartGroup, 0).getDsHeading2();
            long r18 = m8501NavigationBarContent$lambda4(r162);
            TextOverflow.Companion companion4 = TextOverflow.Companion;
            Modifier.Companion companion5 = companion2;
            TextKt.m1461TextfLXpl1I(str3, SemanticsModifierKt.semantics$default(companion5, false, NavigationBarComposablesKt$NavigationBarContent$1$1$1.INSTANCE, 1, (Object) null), r18, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, companion4.m5403getEllipsisgIe3tQ8(), false, 1, (Function1<? super TextLayoutResult, Unit>) null, dsHeading2, startRestartGroup, 0, 3136, 22520);
            if (f12 <= 1.0f) {
                if (str5 == null || str2.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    startRestartGroup.startReplaceableGroup(-673601609);
                    SpacerKt.Spacer(SizeKt.m544height3ABfNKs(companion5, dSTheme.getDimens(startRestartGroup, 0).m8848getDsXxxsD9Ej5fM()), startRestartGroup, 0);
                    Composer composer3 = startRestartGroup;
                    String str6 = str2;
                    TextKt.m1461TextfLXpl1I(str6, SemanticsModifierKt.semantics$default(companion5, false, NavigationBarComposablesKt$NavigationBarContent$1$1$2.INSTANCE, 1, (Object) null), dSTheme.getColors(startRestartGroup, 0).m8771getDsNeutral700d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, companion4.m5403getEllipsisgIe3tQ8(), false, 1, (Function1<? super TextLayoutResult, Unit>) null, dSTheme.getTypography(startRestartGroup, 0).getDsCaption(), composer3, (i18 >> 3) & 14, 3136, 22520);
                    composer3.endReplaceableGroup();
                    composer2 = composer3;
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                }
            }
            composer2 = startRestartGroup;
            composer2.startReplaceableGroup(-673601058);
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
            endRestartGroup.updateScope(new NavigationBarComposablesKt$NavigationBarContent$2(str, str2, rowScope, dSNavigationBarAnimationBehaviour, i11));
        }
    }

    /* renamed from: NavigationBarContent$lambda-4  reason: not valid java name */
    private static final long m8501NavigationBarContent$lambda4(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    @Composable
    public static final void NavigationBarElevation(@Nullable Float f11, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-31531873);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) f11)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            Modifier r02 = SizeKt.m544height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), NavigationBar.INSTANCE.m8499getNavigationBarElevationD9Ej5fM());
            startRestartGroup.startReplaceableGroup(-3686930);
            boolean changed = startRestartGroup.changed((Object) f11);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new NavigationBarComposablesKt$NavigationBarElevation$1$1(f11);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier drawBehind = DrawModifierKt.drawBehind(r02, (Function1) rememberedValue);
            startRestartGroup.startReplaceableGroup(-1990474327);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(drawBehind);
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
            Updater.m2543setimpl(r62, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r62, density, companion.getSetDensity());
            Updater.m2543setimpl(r62, layoutDirection, companion.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new NavigationBarComposablesKt$NavigationBarElevation$3(f11, i11));
        }
    }

    @Composable
    public static final void NavigationBarSurface(@Nullable String str, @Nullable String str2, @NotNull Modifier modifier, @NotNull DSIconButtonModel dSIconButtonModel, @NotNull Function3<? super Dp, ? super Composer, ? super Integer, Unit> function3, @NotNull DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour, @Nullable Float f11, @Nullable Float f12, @Nullable Composer composer, int i11) {
        int i12;
        float f13;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        Modifier modifier2 = modifier;
        DSIconButtonModel dSIconButtonModel2 = dSIconButtonModel;
        Function3<? super Dp, ? super Composer, ? super Integer, Unit> function32 = function3;
        DSNavigationBarAnimationBehaviour dSNavigationBarAnimationBehaviour2 = dSNavigationBarAnimationBehaviour;
        Float f14 = f11;
        Float f15 = f12;
        int i22 = i11;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(dSIconButtonModel2, "leadingIcon");
        Intrinsics.checkNotNullParameter(function32, "trailingContainer");
        Intrinsics.checkNotNullParameter(dSNavigationBarAnimationBehaviour2, "behaviour");
        Composer startRestartGroup = composer.startRestartGroup(-1217740151);
        if ((i22 & 14) == 0) {
            if (startRestartGroup.changed((Object) str)) {
                i21 = 4;
            } else {
                i21 = 2;
            }
            i12 = i21 | i22;
        } else {
            String str3 = str;
            i12 = i22;
        }
        String str4 = str2;
        if ((i22 & 112) == 0) {
            if (startRestartGroup.changed((Object) str4)) {
                i19 = 32;
            } else {
                i19 = 16;
            }
            i12 |= i19;
        }
        if ((i22 & 896) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i18 = 256;
            } else {
                i18 = 128;
            }
            i12 |= i18;
        }
        if ((i22 & 7168) == 0) {
            if (startRestartGroup.changed((Object) dSIconButtonModel2)) {
                i17 = 2048;
            } else {
                i17 = 1024;
            }
            i12 |= i17;
        }
        if ((57344 & i22) == 0) {
            if (startRestartGroup.changed((Object) function32)) {
                i16 = 16384;
            } else {
                i16 = 8192;
            }
            i12 |= i16;
        }
        if ((458752 & i22) == 0) {
            if (startRestartGroup.changed((Object) dSNavigationBarAnimationBehaviour2)) {
                i15 = 131072;
            } else {
                i15 = 65536;
            }
            i12 |= i15;
        }
        if ((3670016 & i22) == 0) {
            if (startRestartGroup.changed((Object) f14)) {
                i14 = 1048576;
            } else {
                i14 = 524288;
            }
            i12 |= i14;
        }
        if ((29360128 & i22) == 0) {
            if (startRestartGroup.changed((Object) f15)) {
                i13 = 8388608;
            } else {
                i13 = 4194304;
            }
            i12 |= i13;
        }
        int i23 = i12;
        if (((i23 & 23967451) ^ 4793490) != 0 || !startRestartGroup.getSkipping()) {
            long r16 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8774getDsNeutralWhite0d7_KjU();
            if (f14 == null) {
                f13 = 1.0f;
            } else {
                f13 = f11.floatValue();
            }
            State<Color> r52 = m8503animateChipColorAsStateek8zF_U(Color.m2918copywmQWz5c$default(r16, f13, 0.0f, 0.0f, 0.0f, 14, (Object) null), startRestartGroup, 0);
            int i24 = (i23 >> 6) & 14;
            startRestartGroup.startReplaceableGroup(-1113031299);
            int i25 = i24 >> 3;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), startRestartGroup, (i25 & 14) | (i25 & 112));
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i26 = (((i24 << 3) & 112) << 9) & 7168;
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
            Composer r12 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r12, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r12, density, companion.getSetDensity());
            Updater.m2543setimpl(r12, layoutDirection, companion.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i26 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(276693241);
            if (((((i26 >> 9) & 14) & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                if ((((((i24 >> 6) & 112) | 6) & 81) ^ 16) != 0 || !startRestartGroup.getSkipping()) {
                    SurfaceKt.m1384SurfaceFjzlyU(SemanticsModifierKt.semantics$default(SizeKt.m544height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), NavigationBar.INSTANCE.m8500getNavigationBarHeightD9Ej5fM()), false, NavigationBarComposablesKt$NavigationBarSurface$1$1.INSTANCE, 1, (Object) null), (Shape) null, m8502NavigationBarSurface$lambda0(r52), 0, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -819892929, true, new NavigationBarComposablesKt$NavigationBarSurface$1$2(dSIconButtonModel, str, str2, dSNavigationBarAnimationBehaviour, i23, function3)), startRestartGroup, 1572864, 58);
                    NavigationBarElevation(f15, startRestartGroup, (i23 >> 21) & 14);
                } else {
                    startRestartGroup.skipToGroupEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            NavigationBarComposablesKt$NavigationBarSurface$2 navigationBarComposablesKt$NavigationBarSurface$2 = r0;
            NavigationBarComposablesKt$NavigationBarSurface$2 navigationBarComposablesKt$NavigationBarSurface$22 = new NavigationBarComposablesKt$NavigationBarSurface$2(str, str2, modifier, dSIconButtonModel, function3, dSNavigationBarAnimationBehaviour, f11, f12, i11);
            endRestartGroup.updateScope(navigationBarComposablesKt$NavigationBarSurface$2);
        }
    }

    /* renamed from: NavigationBarSurface$lambda-0  reason: not valid java name */
    private static final long m8502NavigationBarSurface$lambda0(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    @Composable
    /* renamed from: animateChipColorAsState-ek8zF_U  reason: not valid java name */
    private static final State<Color> m8503animateChipColorAsStateek8zF_U(long j11, Composer composer, int i11) {
        composer.startReplaceableGroup(-1523188567);
        State<Color> r11 = SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(j11, AnimationSpecKt.tween$default(50, 0, (Easing) null, 6, (Object) null), (Function1<? super Color, Unit>) null, composer, (i11 & 14) | 48, 4);
        composer.endReplaceableGroup();
        return r11;
    }
}
