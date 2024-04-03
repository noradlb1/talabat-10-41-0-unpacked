package com.designsystem.ds_button_v2.composables;

import android.view.View;
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
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_button_v2.DSButtonDefaults;
import com.designsystem.ds_button_v2.DSButtonTheme;
import com.designsystem.ds_spinner.DSSpinnerKt;
import com.designsystem.ds_spinner.DSSpinnerSize;
import com.designsystem.ds_theme.DSTheme;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.e;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001am\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0001¢\u0006\u0002\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0012H\u0001¢\u0006\u0002\u0010\u0017\u001a\u0015\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"DSButtonWithPriceContent", "", "theme", "Lcom/designsystem/ds_button_v2/DSButtonTheme;", "title", "", "price", "modifier", "Landroidx/compose/ui/Modifier;", "quantity", "", "isEnabled", "", "isLoading", "isPressed", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "style", "Lcom/designsystem/ds_button_v2/composables/DSButtonWithPriceStyle;", "onTap", "Lkotlin/Function0;", "(Lcom/designsystem/ds_button_v2/DSButtonTheme;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/Integer;ZZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lcom/designsystem/ds_button_v2/composables/DSButtonWithPriceStyle;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "buttonWithPriceMM1Style", "(Landroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_button_v2/composables/DSButtonWithPriceStyle;", "buttonWithPriceMM2Style", "isCounterVisible", "(ZLandroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_button_v2/composables/DSButtonWithPriceStyle;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSButtonWithPriceContentKt {
    @Composable
    public static final void DSButtonWithPriceContent(@NotNull DSButtonTheme dSButtonTheme, @NotNull String str, @NotNull String str2, @NotNull Modifier modifier, @Nullable Integer num, boolean z11, boolean z12, boolean z13, @NotNull MutableInteractionSource mutableInteractionSource, @NotNull DSButtonWithPriceStyle dSButtonWithPriceStyle, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11, int i12) {
        int i13;
        int i14;
        Composer composer2;
        int i15;
        DSButtonTheme dSButtonTheme2 = dSButtonTheme;
        String str3 = str;
        String str4 = str2;
        Modifier modifier2 = modifier;
        Integer num2 = num;
        boolean z14 = z11;
        boolean z15 = z12;
        boolean z16 = z13;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        DSButtonWithPriceStyle dSButtonWithPriceStyle2 = dSButtonWithPriceStyle;
        Function0<Unit> function02 = function0;
        int i16 = i11;
        Intrinsics.checkNotNullParameter(dSButtonTheme2, "theme");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, FirebaseAnalytics.Param.PRICE);
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(mutableInteractionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(dSButtonWithPriceStyle2, "style");
        Intrinsics.checkNotNullParameter(function02, "onTap");
        Composer startRestartGroup = composer.startRestartGroup(-1599707839);
        if ((i16 & 14) == 0) {
            i13 = (startRestartGroup.changed((Object) dSButtonTheme2) ? 4 : 2) | i16;
        } else {
            i13 = i16;
        }
        if ((i16 & 112) == 0) {
            i13 |= startRestartGroup.changed((Object) str3) ? 32 : 16;
        }
        if ((i16 & 896) == 0) {
            i13 |= startRestartGroup.changed((Object) str4) ? 256 : 128;
        }
        if ((i16 & 7168) == 0) {
            i13 |= startRestartGroup.changed((Object) modifier2) ? 2048 : 1024;
        }
        if ((57344 & i16) == 0) {
            i13 |= startRestartGroup.changed((Object) num2) ? 16384 : 8192;
        }
        if ((458752 & i16) == 0) {
            i13 |= startRestartGroup.changed(z14) ? 131072 : 65536;
        }
        if ((3670016 & i16) == 0) {
            i13 |= startRestartGroup.changed(z15) ? 1048576 : 524288;
        }
        if ((29360128 & i16) == 0) {
            i13 |= startRestartGroup.changed(z16) ? 8388608 : 4194304;
        }
        if ((234881024 & i16) == 0) {
            i13 |= startRestartGroup.changed((Object) mutableInteractionSource2) ? 67108864 : 33554432;
        }
        if ((1879048192 & i16) == 0) {
            i13 |= startRestartGroup.changed((Object) dSButtonWithPriceStyle2) ? 536870912 : 268435456;
        }
        int i17 = i13;
        if ((i12 & 14) == 0) {
            i14 = i12 | (startRestartGroup.changed((Object) function02) ? 4 : 2);
        } else {
            i14 = i12;
        }
        if (((i17 & 1533916891) ^ 306783378) == 0 && ((i14 & 11) ^ 2) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            boolean z17 = z14 && !z16 && z15;
            Modifier tappable = ButtonComposablesKt.tappable(SizeKt.m543defaultMinSizeVpY3zN4$default(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null), 0.0f, DSButtonDefaults.INSTANCE.m8287getButtonMinHeightD9Ej5fM(), 1, (Object) null), function0, mutableInteractionSource, (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView()), z14 && !z15, true);
            float r26 = dSButtonWithPriceStyle.m8307getStartPaddingD9Ej5fM();
            DSTheme dSTheme = DSTheme.INSTANCE;
            Composer composer3 = startRestartGroup;
            Modifier r22 = PaddingKt.m490paddingqDBjuR0$default(tappable, r26, 0.0f, dSTheme.getDimens(composer3, 0).m8842getDsSD9Ej5fM(), 0.0f, 10, (Object) null);
            Alignment.Companion companion = Alignment.Companion;
            Alignment center = companion.getCenter();
            composer3.startReplaceableGroup(-1990474327);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer3, 0);
            composer3.startReplaceableGroup(1376089335);
            Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            Composer r02 = Updater.m2536constructorimpl(composer3);
            Updater.m2543setimpl(r02, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r02, density, companion2.getSetDensity());
            Updater.m2543setimpl(r02, layoutDirection, companion2.getSetLayoutDirection());
            composer3.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer3)), composer3, 0);
            composer3.startReplaceableGroup(2058660585);
            composer3.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (z17) {
                composer3.startReplaceableGroup(1706236733);
                DSSpinnerKt.DSSpinner(SemanticsModifierKt.semantics$default(Modifier.Companion, false, DSButtonWithPriceContentKt$DSButtonWithPriceContent$1$1.INSTANCE, 1, (Object) null), dSButtonTheme2.loadingAnimationColor(composer3, i17 & 14), DSSpinnerSize.VerySmall, composer3, RendererCapabilities.MODE_SUPPORT_MASK, 0);
                composer3.endReplaceableGroup();
            } else {
                composer3.startReplaceableGroup(1706237022);
                composer3.endReplaceableGroup();
            }
            Modifier.Companion companion3 = Modifier.Companion;
            Modifier isVisible = ButtonComposablesKt.isVisible(companion3, !z17);
            Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            composer3.startReplaceableGroup(-1989997546);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center2, centerVertically, composer3, 0);
            composer3.startReplaceableGroup(1376089335);
            Density density2 = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
            Composer r03 = Updater.m2536constructorimpl(composer3);
            Updater.m2543setimpl(r03, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r03, density2, companion2.getSetDensity());
            Updater.m2543setimpl(r03, layoutDirection2, companion2.getSetLayoutDirection());
            composer3.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer3)), composer3, 0);
            composer3.startReplaceableGroup(2058660585);
            composer3.startReplaceableGroup(-326682743);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            if (num2 == null) {
                composer3.startReplaceableGroup(1928074785);
                composer3.endReplaceableGroup();
                i15 = 0;
            } else {
                composer3.startReplaceableGroup(-769088032);
                ButtonComposablesKt.m8295ButtonCounterBx497Mc(num.intValue(), dSButtonTheme2.shape(composer3, i17 & 14), dSButtonWithPriceStyle.getCounterStyle(), dSButtonTheme2.textColor(z14, composer3, ((i17 >> 15) & 14) | ((i17 << 3) & 112)).getValue().m2929unboximpl(), composer3, 0);
                i15 = 0;
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion3, dSTheme.getDimens(composer3, 0).m8846getDsXxsD9Ej5fM()), composer3, 0);
                Unit unit = Unit.INSTANCE;
                composer3.endReplaceableGroup();
            }
            int i18 = ((i17 >> 15) & 14) | ((i17 << 3) & 112);
            long r32 = dSButtonTheme2.textColor(z14, composer3, i18).getValue().m2929unboximpl();
            int i19 = i18;
            Modifier weight$default = e.a(rowScopeInstance, companion3, 1.0f, false, 2, (Object) null);
            composer2 = composer3;
            int i21 = i15;
            Composer composer4 = composer2;
            int i22 = i21;
            ButtonComposablesKt.m8297ButtonTitleText8V94_ZQ(str, r32, weight$default, dSButtonWithPriceStyle.getTitleStyle(), (Function1<? super TextLayoutResult, Unit>) null, composer4, (i17 >> 3) & 14, 16);
            SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion3, dSTheme.getDimens(composer2, i22).m8844getDsXsD9Ej5fM()), composer2, i22);
            ButtonComposablesKt.m8297ButtonTitleText8V94_ZQ(str2, dSButtonTheme2.textColor(z14, composer2, i19).getValue().m2929unboximpl(), (Modifier) null, dSButtonWithPriceStyle.getTitleStyle(), (Function1<? super TextLayoutResult, Unit>) null, composer4, (i17 >> 6) & 14, 20);
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
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            DSButtonWithPriceContentKt$DSButtonWithPriceContent$2 dSButtonWithPriceContentKt$DSButtonWithPriceContent$2 = r0;
            DSButtonWithPriceContentKt$DSButtonWithPriceContent$2 dSButtonWithPriceContentKt$DSButtonWithPriceContent$22 = new DSButtonWithPriceContentKt$DSButtonWithPriceContent$2(dSButtonTheme, str, str2, modifier, num, z11, z12, z13, mutableInteractionSource, dSButtonWithPriceStyle, function0, i11, i12);
            endRestartGroup.updateScope(dSButtonWithPriceContentKt$DSButtonWithPriceContent$2);
        }
    }

    @NotNull
    @Composable
    public static final DSButtonWithPriceStyle buttonWithPriceMM1Style(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1970963580);
        DSTheme dSTheme = DSTheme.INSTANCE;
        DSButtonWithPriceStyle dSButtonWithPriceStyle = new DSButtonWithPriceStyle(dSTheme.getTypography(composer, 0).getDsButton(), dSTheme.getTypography(composer, 0).getDsButton(), dSTheme.getDimens(composer, 0).m8842getDsSD9Ej5fM(), (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return dSButtonWithPriceStyle;
    }

    @NotNull
    @Composable
    public static final DSButtonWithPriceStyle buttonWithPriceMM2Style(boolean z11, @Nullable Composer composer, int i11) {
        float f11;
        composer.startReplaceableGroup(-1083459687);
        DSTheme dSTheme = DSTheme.INSTANCE;
        TextStyle dsSubheadingMedium = dSTheme.getTypography(composer, 0).getDsSubheadingMedium();
        TextStyle dsSubheadingMedium2 = dSTheme.getTypography(composer, 0).getDsSubheadingMedium();
        if (z11) {
            composer.startReplaceableGroup(-1083459430);
            f11 = dSTheme.getDimens(composer, 0).m8846getDsXxsD9Ej5fM();
        } else {
            composer.startReplaceableGroup(-1083459404);
            f11 = dSTheme.getDimens(composer, 0).m8842getDsSD9Ej5fM();
        }
        composer.endReplaceableGroup();
        DSButtonWithPriceStyle dSButtonWithPriceStyle = new DSButtonWithPriceStyle(dsSubheadingMedium, dsSubheadingMedium2, f11, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return dSButtonWithPriceStyle;
    }
}
