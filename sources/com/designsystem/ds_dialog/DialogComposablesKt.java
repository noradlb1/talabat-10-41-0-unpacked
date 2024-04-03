package com.designsystem.ds_dialog;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_small_button.DSDestructiveSmallButtonKt;
import com.designsystem.ds_small_button.DSPrimarySmallButtonKt;
import com.designsystem.ds_small_button.DSTertiarySmallButtonKt;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a \u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u0007\u001a\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u000b\u001a#\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0001¢\u0006\u0002\u0010\u000f\u001a<\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0014\u001a#\u0010\u0015\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0001¢\u0006\u0002\u0010\u000f\u001a#\u0010\u0016\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0001¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"DialogCornerSize", "", "DialogButtons", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DialogContent", "content", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "DialogDestructiveButton", "text", "onTap", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DialogLayout", "modifier", "Landroidx/compose/ui/Modifier;", "title", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DialogPrimaryButton", "DialogSecondaryButton", "DialogTitle", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DialogComposablesKt {
    private static final int DialogCornerSize = 8;

    /* access modifiers changed from: private */
    @Composable
    public static final void DialogButtons(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-138588042);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if ((2 ^ (i12 & 11)) != 0 || !startRestartGroup.getSkipping()) {
            Modifier.Companion companion = Modifier.Companion;
            DSTheme dSTheme = DSTheme.INSTANCE;
            SpacerKt.Spacer(SizeKt.m544height3ABfNKs(companion, dSTheme.getDimens(startRestartGroup, 0).m8843getDsXlD9Ej5fM()), startRestartGroup, 0);
            Arrangement arrangement = Arrangement.INSTANCE;
            float r22 = dSTheme.getDimens(startRestartGroup, 0).m8840getDsLD9Ej5fM();
            Alignment.Companion companion2 = Alignment.Companion;
            Arrangement.Horizontal r23 = arrangement.m395spacedByD5KLDUw(r22, companion2.getEnd());
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(-1989997546);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(r23, companion2.getTop(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxWidth$default);
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
            Updater.m2543setimpl(r72, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m2543setimpl(r72, density, companion3.getSetDensity());
            Updater.m2543setimpl(r72, layoutDirection, companion3.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-326682743);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            function2.invoke(startRestartGroup, Integer.valueOf(i12 & 14));
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
            endRestartGroup.updateScope(new DialogComposablesKt$DialogButtons$2(function2, i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void DialogContent(String str, Composer composer, int i11) {
        int i12;
        Composer composer2;
        int i13;
        String str2 = str;
        int i14 = i11;
        Composer startRestartGroup = composer.startRestartGroup(402095753);
        if ((i14 & 14) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i14;
        } else {
            i12 = i14;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            Modifier.Companion companion = Modifier.Companion;
            DSTheme dSTheme = DSTheme.INSTANCE;
            SpacerKt.Spacer(SizeKt.m544height3ABfNKs(companion, dSTheme.getDimens(startRestartGroup, 0).m8846getDsXxsD9Ej5fM()), startRestartGroup, 0);
            composer2 = startRestartGroup;
            TextKt.m1461TextfLXpl1I(str, (Modifier) null, dSTheme.getColors(startRestartGroup, 0).m8771getDsNeutral700d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, dSTheme.getTypography(startRestartGroup, 0).getDsBody1(), composer2, i12 & 14, 64, 32762);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DialogComposablesKt$DialogContent$1(str, i11));
        }
    }

    @Composable
    public static final void DialogDestructiveButton(@NotNull String str, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, "onTap");
        Composer startRestartGroup = composer.startRestartGroup(1551361526);
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
            if (startRestartGroup.changed((Object) function0)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            DSDestructiveSmallButtonKt.DSDestructiveSmallButton(str, (Modifier) null, (Integer) null, false, false, false, function0, startRestartGroup, (i12 & 14) | ((i12 << 15) & 3670016), 62);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DialogComposablesKt$DialogDestructiveButton$1(str, function0, i11));
        }
    }

    @Composable
    public static final void DialogLayout(@NotNull Modifier modifier, @Nullable String str, @Nullable String str2, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        int i13;
        int i14;
        int i15;
        int i16;
        Modifier modifier2 = modifier;
        String str3 = str;
        String str4 = str2;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i17 = i11;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(function22, "buttons");
        Composer startRestartGroup = composer.startRestartGroup(1513639352);
        if ((i17 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i12 = i16 | i17;
        } else {
            i12 = i17;
        }
        if ((i17 & 112) == 0) {
            if (startRestartGroup.changed((Object) str3)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i12 |= i15;
        }
        if ((i17 & 896) == 0) {
            if (startRestartGroup.changed((Object) str4)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i12 |= i14;
        }
        if ((i17 & 7168) == 0) {
            if (startRestartGroup.changed((Object) function22)) {
                i13 = 2048;
            } else {
                i13 = 1024;
            }
            i12 |= i13;
        }
        if (((i12 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            int i18 = (i12 & 14) | 1572864;
            composer2 = startRestartGroup;
            SurfaceKt.m1384SurfaceFjzlyU(modifier, RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(Dp.m5478constructorimpl((float) 8)), DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8774getDsNeutralWhite0d7_KjU(), 0, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -819895703, true, new DialogComposablesKt$DialogLayout$1(str3, str4, function22, i12)), startRestartGroup, i18, 56);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DialogComposablesKt$DialogLayout$2(modifier, str, str2, function2, i11));
        }
    }

    @Composable
    public static final void DialogPrimaryButton(@NotNull String str, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, "onTap");
        Composer startRestartGroup = composer.startRestartGroup(-148224113);
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
            if (startRestartGroup.changed((Object) function0)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            DSPrimarySmallButtonKt.DSPrimarySmallButton(str, (Modifier) null, (Integer) null, false, false, false, function0, startRestartGroup, (i12 & 14) | ((i12 << 15) & 3670016), 62);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DialogComposablesKt$DialogPrimaryButton$1(str, function0, i11));
        }
    }

    @Composable
    public static final void DialogSecondaryButton(@NotNull String str, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(function0, "onTap");
        Composer startRestartGroup = composer.startRestartGroup(-302109997);
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
            if (startRestartGroup.changed((Object) function0)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            DSTertiarySmallButtonKt.DSTertiarySmallButton(str, (Modifier) null, (Integer) null, false, false, false, function0, startRestartGroup, (i12 & 14) | ((i12 << 15) & 3670016), 62);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DialogComposablesKt$DialogSecondaryButton$1(str, function0, i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void DialogTitle(String str, Composer composer, int i11) {
        int i12;
        Composer composer2;
        int i13;
        String str2 = str;
        int i14 = i11;
        Composer startRestartGroup = composer.startRestartGroup(8003601);
        if ((i14 & 14) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i14;
        } else {
            i12 = i14;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            DSTheme dSTheme = DSTheme.INSTANCE;
            composer2 = startRestartGroup;
            TextKt.m1461TextfLXpl1I(str, (Modifier) null, dSTheme.getColors(startRestartGroup, 0).m8760getDsNeutral1000d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, TextOverflow.Companion.m5403getEllipsisgIe3tQ8(), false, 2, (Function1<? super TextLayoutResult, Unit>) null, dSTheme.getTypography(startRestartGroup, 0).getDsHeading2(), composer2, i12 & 14, 3136, 22522);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DialogComposablesKt$DialogTitle$1(str, i11));
        }
    }
}
