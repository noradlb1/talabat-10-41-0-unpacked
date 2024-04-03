package com.designsystem.ds_branded_button.composables;

import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_branded_button.DSBrandedButtonStyle;
import com.designsystem.ds_button_v2.DSButtonDefaults;
import com.designsystem.ds_button_v2.DSButtonTheme;
import com.designsystem.ds_button_v2.composables.ButtonComposablesKt;
import com.designsystem.ds_spinner.DSSpinnerKt;
import com.designsystem.ds_spinner.DSSpinnerSize;
import com.designsystem.ds_theme.DSTheme;
import com.google.android.exoplayer2.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.e;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0001¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"DSBrandedButtonContent", "", "theme", "Lcom/designsystem/ds_button_v2/DSButtonTheme;", "title", "", "modifier", "Landroidx/compose/ui/Modifier;", "leadingIcon", "", "isEnabled", "", "isLoading", "isPressed", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "style", "Lcom/designsystem/ds_branded_button/DSBrandedButtonStyle;", "onTap", "Lkotlin/Function0;", "(Lcom/designsystem/ds_button_v2/DSButtonTheme;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/Integer;ZZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lcom/designsystem/ds_branded_button/DSBrandedButtonStyle;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSBrandedButtonContentKt {
    @Composable
    public static final void DSBrandedButtonContent(@NotNull DSButtonTheme dSButtonTheme, @NotNull String str, @NotNull Modifier modifier, @Nullable @DrawableRes Integer num, boolean z11, boolean z12, boolean z13, @NotNull MutableInteractionSource mutableInteractionSource, @NotNull DSBrandedButtonStyle dSBrandedButtonStyle, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        float f11;
        DSButtonTheme dSButtonTheme2 = dSButtonTheme;
        String str2 = str;
        Modifier modifier2 = modifier;
        Integer num2 = num;
        boolean z14 = z11;
        boolean z15 = z12;
        boolean z16 = z13;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        DSBrandedButtonStyle dSBrandedButtonStyle2 = dSBrandedButtonStyle;
        Function0<Unit> function02 = function0;
        int i13 = i11;
        Intrinsics.checkNotNullParameter(dSButtonTheme2, "theme");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(mutableInteractionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(dSBrandedButtonStyle2, "style");
        Intrinsics.checkNotNullParameter(function02, "onTap");
        Composer startRestartGroup = composer.startRestartGroup(90836641);
        if ((i13 & 14) == 0) {
            i12 = (startRestartGroup.changed((Object) dSButtonTheme2) ? 4 : 2) | i13;
        } else {
            i12 = i13;
        }
        if ((i13 & 112) == 0) {
            i12 |= startRestartGroup.changed((Object) str2) ? 32 : 16;
        }
        if ((i13 & 896) == 0) {
            i12 |= startRestartGroup.changed((Object) modifier2) ? 256 : 128;
        }
        if ((i13 & 7168) == 0) {
            i12 |= startRestartGroup.changed((Object) num2) ? 2048 : 1024;
        }
        if ((57344 & i13) == 0) {
            i12 |= startRestartGroup.changed(z14) ? 16384 : 8192;
        }
        if ((458752 & i13) == 0) {
            i12 |= startRestartGroup.changed(z15) ? 131072 : 65536;
        }
        if ((3670016 & i13) == 0) {
            i12 |= startRestartGroup.changed(z16) ? 1048576 : 524288;
        }
        if ((29360128 & i13) == 0) {
            i12 |= startRestartGroup.changed((Object) mutableInteractionSource2) ? 8388608 : 4194304;
        }
        if ((234881024 & i13) == 0) {
            i12 |= startRestartGroup.changed((Object) dSBrandedButtonStyle2) ? 67108864 : 33554432;
        }
        if ((1879048192 & i13) == 0) {
            i12 |= startRestartGroup.changed((Object) function02) ? 536870912 : 268435456;
        }
        int i14 = i12;
        if (((i14 & 1533916891) ^ 306783378) != 0 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startReplaceableGroup(-3687241);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            MutableState mutableState = (MutableState) rememberedValue;
            boolean z17 = z14 && !z16 && z15;
            MutableState mutableState2 = mutableState;
            Composer composer3 = startRestartGroup;
            Modifier tappable = ButtonComposablesKt.tappable(SizeKt.m543defaultMinSizeVpY3zN4$default(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null), 0.0f, DSButtonDefaults.INSTANCE.m8287getButtonMinHeightD9Ej5fM(), 1, (Object) null), function0, mutableInteractionSource, (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView()), z14 && !z15, dSBrandedButtonStyle.getHasHapticFeedback());
            DSTheme dSTheme = DSTheme.INSTANCE;
            Modifier r22 = PaddingKt.m488paddingVpY3zN4$default(tappable, dSTheme.getDimens(composer3, 0).m8842getDsSD9Ej5fM(), 0.0f, 2, (Object) null);
            Alignment.Companion companion2 = Alignment.Companion;
            Alignment center = companion2.getCenter();
            composer3.startReplaceableGroup(-1990474327);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer3, 0);
            composer3.startReplaceableGroup(1376089335);
            Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r22);
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            composer3.disableReusing();
            Composer r32 = Updater.m2536constructorimpl(composer3);
            Updater.m2543setimpl(r32, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r32, density, companion3.getSetDensity());
            Updater.m2543setimpl(r32, layoutDirection, companion3.getSetLayoutDirection());
            composer3.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer3)), composer3, 0);
            composer3.startReplaceableGroup(2058660585);
            composer3.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (z17) {
                composer3.startReplaceableGroup(-166192338);
                DSSpinnerKt.DSSpinner(SemanticsModifierKt.semantics$default(Modifier.Companion, false, DSBrandedButtonContentKt$DSBrandedButtonContent$1$1.INSTANCE, 1, (Object) null), dSButtonTheme2.loadingAnimationColor(composer3, i14 & 14), DSSpinnerSize.VerySmall, composer3, RendererCapabilities.MODE_SUPPORT_MASK, 0);
                composer3.endReplaceableGroup();
            } else {
                composer3.startReplaceableGroup(-166192049);
                composer3.endReplaceableGroup();
            }
            Modifier.Companion companion4 = Modifier.Companion;
            Modifier isVisible = ButtonComposablesKt.isVisible(companion4, !z17);
            Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            composer3.startReplaceableGroup(-1989997546);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center2, centerVertically, composer3, 0);
            composer3.startReplaceableGroup(1376089335);
            Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(isVisible);
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor2);
            } else {
                composer3.useNode();
            }
            composer3.disableReusing();
            Composer r23 = Updater.m2536constructorimpl(composer3);
            Updater.m2543setimpl(r23, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r23, density2, companion3.getSetDensity());
            Updater.m2543setimpl(r23, layoutDirection2, companion3.getSetLayoutDirection());
            composer3.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer3)), composer3, 0);
            composer3.startReplaceableGroup(2058660585);
            composer3.startReplaceableGroup(-326682743);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            if (num2 == null) {
                composer3.startReplaceableGroup(-507097555);
            } else {
                composer3.startReplaceableGroup(1784757332);
                int intValue = num.intValue();
                if (z14) {
                    f11 = 1.0f;
                } else {
                    f11 = dSBrandedButtonStyle.getDisabledIconAlpha();
                }
                ButtonComposablesKt.ButtonLeadingIcon(intValue, f11, composer3, 0);
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion4, dSTheme.getDimens(composer3, 0).m8842getDsSD9Ej5fM()), composer3, 0);
                Unit unit = Unit.INSTANCE;
            }
            composer3.endReplaceableGroup();
            Modifier weight$default = e.a(rowScopeInstance, companion4, 1.0f, false, 2, (Object) null);
            Boolean r33 = m8281DSBrandedButtonContent$lambda1(mutableState2);
            Boolean bool = Boolean.TRUE;
            Alignment centerStart = Intrinsics.areEqual((Object) r33, (Object) bool) ? companion2.getCenterStart() : companion2.getCenter();
            composer3.startReplaceableGroup(-1990474327);
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(centerStart, false, composer3, 0);
            composer3.startReplaceableGroup(1376089335);
            Density density3 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(weight$default);
            if (!(composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor3);
            } else {
                composer3.useNode();
            }
            composer3.disableReusing();
            Composer r62 = Updater.m2536constructorimpl(composer3);
            Updater.m2543setimpl(r62, rememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r62, density3, companion3.getSetDensity());
            Updater.m2543setimpl(r62, layoutDirection3, companion3.getSetLayoutDirection());
            composer3.enableReusing();
            materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer3)), composer3, 0);
            composer3.startReplaceableGroup(2058660585);
            composer3.startReplaceableGroup(-1253629305);
            long r34 = dSButtonTheme2.textColor(z14, composer3, ((i14 >> 12) & 14) | ((i14 << 3) & 112)).getValue().m2929unboximpl();
            TextStyle titleStyle = dSBrandedButtonStyle.getTitleStyle();
            composer3.startReplaceableGroup(-3686930);
            boolean changed = composer3.changed((Object) mutableState2);
            Object rememberedValue2 = composer3.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new DSBrandedButtonContentKt$DSBrandedButtonContent$1$2$2$1$1(mutableState2);
                composer3.updateRememberedValue(rememberedValue2);
            }
            composer3.endReplaceableGroup();
            DSTheme dSTheme2 = dSTheme;
            Composer composer4 = composer3;
            Modifier.Companion companion5 = companion4;
            ButtonComposablesKt.m8297ButtonTitleText8V94_ZQ(str, r34, (Modifier) null, titleStyle, (Function1) rememberedValue2, composer3, (i14 >> 3) & 14, 4);
            composer4.endReplaceableGroup();
            composer4.endReplaceableGroup();
            composer4.endNode();
            composer4.endReplaceableGroup();
            composer4.endReplaceableGroup();
            if (!Intrinsics.areEqual((Object) m8281DSBrandedButtonContent$lambda1(mutableState2), (Object) bool)) {
                composer2 = composer4;
                composer2.startReplaceableGroup(1784758256);
                DSTheme dSTheme3 = dSTheme2;
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion5, Dp.m5478constructorimpl(dSTheme3.getDimens(composer2, 0).m8841getDsMD9Ej5fM() + dSTheme3.getDimens(composer2, 0).m8842getDsSD9Ej5fM())), composer2, 0);
                composer2.endReplaceableGroup();
            } else {
                composer2 = composer4;
                composer2.startReplaceableGroup(1784758362);
                composer2.endReplaceableGroup();
            }
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
            DSBrandedButtonContentKt$DSBrandedButtonContent$2 dSBrandedButtonContentKt$DSBrandedButtonContent$2 = r0;
            DSBrandedButtonContentKt$DSBrandedButtonContent$2 dSBrandedButtonContentKt$DSBrandedButtonContent$22 = new DSBrandedButtonContentKt$DSBrandedButtonContent$2(dSButtonTheme, str, modifier, num, z11, z12, z13, mutableInteractionSource, dSBrandedButtonStyle, function0, i11);
            endRestartGroup.updateScope(dSBrandedButtonContentKt$DSBrandedButtonContent$2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: DSBrandedButtonContent$lambda-1  reason: not valid java name */
    public static final Boolean m8281DSBrandedButtonContent$lambda1(MutableState<Boolean> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DSBrandedButtonContent$lambda-2  reason: not valid java name */
    public static final void m8282DSBrandedButtonContent$lambda2(MutableState<Boolean> mutableState, Boolean bool) {
        mutableState.setValue(bool);
    }
}
