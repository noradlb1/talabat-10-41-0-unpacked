package com.designsystem.ds_small_button.composables;

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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_button_v2.DSButtonTheme;
import com.designsystem.ds_button_v2.composables.ButtonComposablesKt;
import com.designsystem.ds_small_button.DSSmallButtonStyle;
import com.designsystem.ds_spinner.DSSpinnerKt;
import com.designsystem.ds_spinner.DSSpinnerSize;
import com.designsystem.ds_theme.DSTheme;
import com.google.android.exoplayer2.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ag\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0001¢\u0006\u0002\u0010\u0017\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"SmallButtonMinSize", "Landroidx/compose/ui/unit/Dp;", "F", "DSSmallButtonContent", "", "theme", "Lcom/designsystem/ds_button_v2/DSButtonTheme;", "title", "", "modifier", "Landroidx/compose/ui/Modifier;", "leadingIcon", "", "isEnabled", "", "isLoading", "isPressed", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "style", "Lcom/designsystem/ds_small_button/DSSmallButtonStyle;", "onTap", "Lkotlin/Function0;", "(Lcom/designsystem/ds_button_v2/DSButtonTheme;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/Integer;ZZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lcom/designsystem/ds_small_button/DSSmallButtonStyle;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSSmallButtonContentKt {
    private static final float SmallButtonMinSize = Dp.m5478constructorimpl((float) 36);

    @Composable
    public static final void DSSmallButtonContent(@NotNull DSButtonTheme dSButtonTheme, @NotNull String str, @NotNull Modifier modifier, @Nullable @DrawableRes Integer num, boolean z11, boolean z12, boolean z13, @NotNull MutableInteractionSource mutableInteractionSource, @NotNull DSSmallButtonStyle dSSmallButtonStyle, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        DSButtonTheme dSButtonTheme2 = dSButtonTheme;
        String str2 = str;
        Modifier modifier2 = modifier;
        Integer num2 = num;
        boolean z14 = z11;
        boolean z15 = z12;
        boolean z16 = z13;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        DSSmallButtonStyle dSSmallButtonStyle2 = dSSmallButtonStyle;
        Function0<Unit> function02 = function0;
        int i13 = i11;
        Intrinsics.checkNotNullParameter(dSButtonTheme2, "theme");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(mutableInteractionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(dSSmallButtonStyle2, "style");
        Intrinsics.checkNotNullParameter(function02, "onTap");
        Composer startRestartGroup = composer.startRestartGroup(-900624295);
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
            i12 |= startRestartGroup.changed((Object) dSSmallButtonStyle2) ? 67108864 : 33554432;
        }
        if ((1879048192 & i13) == 0) {
            i12 |= startRestartGroup.changed((Object) function02) ? 536870912 : 268435456;
        }
        int i14 = i12;
        if (((i14 & 1533916891) ^ 306783378) != 0 || !startRestartGroup.getSkipping()) {
            boolean z17 = z14 && !z16 && z15;
            Composer composer3 = startRestartGroup;
            Modifier tappable = ButtonComposablesKt.tappable(SizeKt.m543defaultMinSizeVpY3zN4$default(SizeKt.wrapContentWidth$default(modifier2, (Alignment.Horizontal) null, false, 3, (Object) null), 0.0f, SmallButtonMinSize, 1, (Object) null), function0, mutableInteractionSource, (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView()), z14 && !z15, dSSmallButtonStyle.getHasHapticFeedback());
            DSTheme dSTheme = DSTheme.INSTANCE;
            Modifier r22 = PaddingKt.m488paddingVpY3zN4$default(tappable, dSTheme.getDimens(composer3, 0).m8844getDsXsD9Ej5fM(), 0.0f, 2, (Object) null);
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
                composer3.startReplaceableGroup(-730706800);
                DSSpinnerKt.DSSpinner(SemanticsModifierKt.semantics$default(Modifier.Companion, false, DSSmallButtonContentKt$DSSmallButtonContent$1$1.INSTANCE, 1, (Object) null), dSButtonTheme2.loadingAnimationColor(composer3, i14 & 14), DSSpinnerSize.VerySmall, composer3, RendererCapabilities.MODE_SUPPORT_MASK, 0);
                composer3.endReplaceableGroup();
            } else {
                composer3.startReplaceableGroup(-730706518);
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
                composer3.startReplaceableGroup(-1726113742);
            } else {
                composer3.startReplaceableGroup(-609870417);
                num.intValue();
                ButtonComposablesKt.m8296ButtonLeadingIconRPmYEkk(num.intValue(), dSButtonTheme2.textColor(z14, composer3, ((i14 >> 12) & 14) | ((i14 << 3) & 112)).getValue().m2929unboximpl(), composer3, (i14 >> 9) & 14);
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion3, dSTheme.getDimens(composer3, 0).m8848getDsXxxsD9Ej5fM()), composer3, 0);
                Unit unit = Unit.INSTANCE;
            }
            composer3.endReplaceableGroup();
            composer2 = composer3;
            SmallButtonComposablesKt.m8576SmallButtonTitleText3IgeMak(str, dSButtonTheme2.textColor(z14, composer3, ((i14 >> 12) & 14) | ((i14 << 3) & 112)).getValue().m2929unboximpl(), dSSmallButtonStyle.getTitleStyle(), composer3, (i14 >> 3) & 14, 0);
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
            DSSmallButtonContentKt$DSSmallButtonContent$2 dSSmallButtonContentKt$DSSmallButtonContent$2 = r0;
            DSSmallButtonContentKt$DSSmallButtonContent$2 dSSmallButtonContentKt$DSSmallButtonContent$22 = new DSSmallButtonContentKt$DSSmallButtonContent$2(dSButtonTheme, str, modifier, num, z11, z12, z13, mutableInteractionSource, dSSmallButtonStyle, function0, i11);
            endRestartGroup.updateScope(dSSmallButtonContentKt$DSSmallButtonContent$2);
        }
    }
}
