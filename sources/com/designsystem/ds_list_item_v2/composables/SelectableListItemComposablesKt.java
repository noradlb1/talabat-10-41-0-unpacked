package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.designsystem.ds_checkbox_v2.DSCheckboxKt;
import com.designsystem.ds_radio_button.DSRadioButtonKt;
import com.designsystem.ds_switch.DSSwitchKt;
import com.designsystem.ds_theme.DSTheme;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0005\u001a%\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u000b\u001a-\u0010\f\u001a\u00020\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u000e\u001a%\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u000b\u001a\u001d\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0005\u001ae\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001aH\u0001¢\u0006\u0002\u0010\u001b\u001aT\u0010\u001c\u001a\u00020\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00032\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010 ¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001a\u001d\u0010#\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0005\u001a)\u0010$\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010%\u001aß\u0001\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0003\u0010,\u001a\u0004\u0018\u00010+2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010.\u001a\u00020\u001e2\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010/\u001a\u00020\u00032*\b\u0002\u00100\u001a$\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\u001aF\u00105\u001a\u00020\b*\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00106\u001a\u0002072\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0003\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00068"}, d2 = {"ListItemCheckbox", "", "isSelected", "", "isEnabled", "(ZZLandroidx/compose/runtime/Composer;I)V", "ListItemOldPriceText", "modifier", "Landroidx/compose/ui/Modifier;", "oldPrice", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "ListItemPriceContainer", "price", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;II)V", "ListItemPriceText", "ListItemRadioButton", "ListItemSelectableSurface", "onChanged", "Lkotlin/Function1;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/runtime/MutableState;", "content", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLandroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "ListItemSelectableTrailingContainer", "width", "Landroidx/compose/ui/unit/Dp;", "trailingComposable", "Lkotlin/Function0;", "ListItemSelectableTrailingContainer-TN_CM5M", "(Ljava/lang/String;Ljava/lang/String;FZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ListItemSwitch", "SelectionIndicator", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/runtime/Composer;II)V", "SelectionListItem", "label", "descriptor", "secondaryLabel", "descriptorColor", "", "leadingIcon", "leadingImage", "imageCornerRadius", "showSelectionIndicator", "trailingView", "Lkotlin/ParameterName;", "name", "SelectionListItem-_zuB-KE", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;FZLjava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "selectable", "indication", "Landroidx/compose/foundation/Indication;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SelectableListItemComposablesKt {
    @Composable
    public static final void ListItemCheckbox(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(-1541936464);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed(z11)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(z12)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            int i15 = i12 << 3;
            DSCheckboxKt.DSCheckbox(TestTagKt.testTag(Modifier.Companion, SelectableListItem.SelectableListItemCheckboxTestTag), z11, z12, (Function1<? super Boolean, Unit>) null, startRestartGroup, (i15 & 112) | 6 | (i15 & 896), 8);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SelectableListItemComposablesKt$ListItemCheckbox$1(z11, z12, i11));
        }
    }

    @Composable
    public static final void ListItemOldPriceText(@NotNull Modifier modifier, @NotNull String str, boolean z11, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        long j11;
        int i13;
        int i14;
        int i15;
        Modifier modifier2 = modifier;
        String str2 = str;
        boolean z12 = z11;
        int i16 = i11;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(str2, "oldPrice");
        Composer startRestartGroup = composer.startRestartGroup(-1450781236);
        if ((i16 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i12 = i15 | i16;
        } else {
            i12 = i16;
        }
        if ((i16 & 112) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i12 |= i14;
        }
        if ((i16 & 896) == 0) {
            if (startRestartGroup.changed(z12)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        int i17 = i12;
        if (((i17 & 731) ^ Opcodes.I2C) != 0 || !startRestartGroup.getSkipping()) {
            if (z12) {
                startRestartGroup.startReplaceableGroup(-1450781091);
                j11 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8769getDsNeutral550d7_KjU();
            } else {
                startRestartGroup.startReplaceableGroup(-1450781059);
                j11 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8764getDsNeutral350d7_KjU();
            }
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            String str3 = str;
            long j12 = j11;
            TextKt.m1461TextfLXpl1I(str3, ComposedModifierKt.composed$default(SemanticsModifierKt.semantics$default(Modifier.Companion, false, SelectableListItemComposablesKt$ListItemOldPriceText$1.INSTANCE, 1, (Object) null), (Function1) null, new SelectableListItemComposablesKt$ListItemOldPriceText$2(modifier2), 1, (Object) null), j12, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, TextOverflow.Companion.m5403getEllipsisgIe3tQ8(), false, 1, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m5046copyHL5avdY$default(DSTheme.INSTANCE.getTypography(startRestartGroup, 0).getDsCaption(), 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, TextDecoration.Companion.getLineThrough(), (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 258047, (Object) null), composer2, (i17 >> 3) & 14, 3136, 22520);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SelectableListItemComposablesKt$ListItemOldPriceText$3(modifier2, str, z11, i11));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ListItemPriceContainer(@org.jetbrains.annotations.Nullable java.lang.String r16, @org.jetbrains.annotations.Nullable java.lang.String r17, boolean r18, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r3 = r18
            r4 = r20
            r0 = -1623227857(0xffffffff9f3f822f, float:-4.055351E-20)
            r1 = r19
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r21 & 1
            if (r1 == 0) goto L_0x0017
            r2 = r4 | 6
            r5 = r2
            r2 = r16
            goto L_0x002b
        L_0x0017:
            r2 = r4 & 14
            if (r2 != 0) goto L_0x0028
            r2 = r16
            boolean r5 = r0.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x0025
            r5 = 4
            goto L_0x0026
        L_0x0025:
            r5 = 2
        L_0x0026:
            r5 = r5 | r4
            goto L_0x002b
        L_0x0028:
            r2 = r16
            r5 = r4
        L_0x002b:
            r6 = r21 & 2
            if (r6 == 0) goto L_0x0032
            r5 = r5 | 48
            goto L_0x0045
        L_0x0032:
            r7 = r4 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0045
            r7 = r17
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0041
            r8 = 32
            goto L_0x0043
        L_0x0041:
            r8 = 16
        L_0x0043:
            r5 = r5 | r8
            goto L_0x0047
        L_0x0045:
            r7 = r17
        L_0x0047:
            r8 = r21 & 4
            if (r8 == 0) goto L_0x004e
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004e:
            r8 = r4 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x005e
            boolean r8 = r0.changed((boolean) r3)
            if (r8 == 0) goto L_0x005b
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r5 = r5 | r8
        L_0x005e:
            r8 = r5 & 731(0x2db, float:1.024E-42)
            r8 = r8 ^ 146(0x92, float:2.05E-43)
            if (r8 != 0) goto L_0x0072
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x006b
            goto L_0x0072
        L_0x006b:
            r0.skipToGroupEnd()
        L_0x006e:
            r1 = r2
            r2 = r7
            goto L_0x0164
        L_0x0072:
            r8 = 0
            if (r1 == 0) goto L_0x0076
            r2 = r8
        L_0x0076:
            if (r6 == 0) goto L_0x0079
            r7 = r8
        L_0x0079:
            r1 = -1113031299(0xffffffffbda87d7d, float:-0.0822706)
            r0.startReplaceableGroup(r1)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.layout.Arrangement r6 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r6 = r6.getTop()
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r9 = r8.getStart()
            r10 = 0
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r6, r9, r0, r10)
            r9 = 1376089335(0x520574f7, float:1.43298249E11)
            r0.startReplaceableGroup(r9)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r14 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x00c1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00c1:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x00ce
            r0.createNode(r13)
            goto L_0x00d1
        L_0x00ce:
            r0.useNode()
        L_0x00d1:
            r0.disableReusing()
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r15 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r13, r6, r15)
            kotlin.jvm.functions.Function2 r6 = r12.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r13, r9, r6)
            kotlin.jvm.functions.Function2 r6 = r12.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r13, r11, r6)
            r0.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r6)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)
            r14.invoke(r6, r0, r9)
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r6)
            r6 = 276693241(0x107e00f9, float:5.0093417E-29)
            r0.startReplaceableGroup(r6)
            androidx.compose.foundation.layout.ColumnScopeInstance r6 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            if (r2 != 0) goto L_0x0116
            r9 = -572547931(0xffffffffdddf9ca5, float:-2.01411687E18)
            r0.startReplaceableGroup(r9)
            goto L_0x012e
        L_0x0116:
            r9 = 120078044(0x7283edc, float:1.2657388E-34)
            r0.startReplaceableGroup(r9)
            androidx.compose.ui.Alignment$Horizontal r9 = r8.getEnd()
            androidx.compose.ui.Modifier r9 = r6.align(r1, r9)
            int r10 = r5 << 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r11 = r5 & 896(0x380, float:1.256E-42)
            r10 = r10 | r11
            ListItemPriceText(r9, r2, r3, r0, r10)
        L_0x012e:
            r0.endReplaceableGroup()
            if (r7 != 0) goto L_0x013a
            r1 = -572542475(0xffffffffdddfb1f5, float:-2.01486674E18)
            r0.startReplaceableGroup(r1)
            goto L_0x0150
        L_0x013a:
            r9 = 120078220(0x7283f8c, float:1.265759E-34)
            r0.startReplaceableGroup(r9)
            androidx.compose.ui.Alignment$Horizontal r8 = r8.getEnd()
            androidx.compose.ui.Modifier r1 = r6.align(r1, r8)
            r6 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 & 896(0x380, float:1.256E-42)
            r5 = r5 | r6
            ListItemOldPriceText(r1, r7, r3, r0, r5)
        L_0x0150:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            goto L_0x006e
        L_0x0164:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x016b
            goto L_0x017a
        L_0x016b:
            com.designsystem.ds_list_item_v2.composables.SelectableListItemComposablesKt$ListItemPriceContainer$2 r7 = new com.designsystem.ds_list_item_v2.composables.SelectableListItemComposablesKt$ListItemPriceContainer$2
            r0 = r7
            r3 = r18
            r4 = r20
            r5 = r21
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_list_item_v2.composables.SelectableListItemComposablesKt.ListItemPriceContainer(java.lang.String, java.lang.String, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    @Composable
    public static final void ListItemPriceText(@NotNull Modifier modifier, @NotNull String str, boolean z11, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        long j11;
        int i13;
        int i14;
        int i15;
        Modifier modifier2 = modifier;
        String str2 = str;
        boolean z12 = z11;
        int i16 = i11;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(str2, FirebaseAnalytics.Param.PRICE);
        Composer startRestartGroup = composer.startRestartGroup(-1513732970);
        if ((i16 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i12 = i15 | i16;
        } else {
            i12 = i16;
        }
        if ((i16 & 112) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i12 |= i14;
        }
        if ((i16 & 896) == 0) {
            if (startRestartGroup.changed(z12)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        int i17 = i12;
        if (((i17 & 731) ^ Opcodes.I2C) != 0 || !startRestartGroup.getSkipping()) {
            if (z12) {
                startRestartGroup.startReplaceableGroup(-1513732831);
                j11 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8771getDsNeutral700d7_KjU();
            } else {
                startRestartGroup.startReplaceableGroup(-1513732799);
                j11 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8764getDsNeutral350d7_KjU();
            }
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            String str3 = str;
            long j12 = j11;
            TextKt.m1461TextfLXpl1I(str3, ComposedModifierKt.composed$default(SemanticsModifierKt.semantics$default(Modifier.Companion, false, SelectableListItemComposablesKt$ListItemPriceText$1.INSTANCE, 1, (Object) null), (Function1) null, new SelectableListItemComposablesKt$ListItemPriceText$2(modifier2), 1, (Object) null), j12, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, TextOverflow.Companion.m5403getEllipsisgIe3tQ8(), false, 1, (Function1<? super TextLayoutResult, Unit>) null, DSTheme.INSTANCE.getTypography(startRestartGroup, 0).getDsBody1(), composer2, (i17 >> 3) & 14, 3136, 22520);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SelectableListItemComposablesKt$ListItemPriceText$3(modifier2, str, z11, i11));
        }
    }

    @Composable
    public static final void ListItemRadioButton(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(-1628432851);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed(z11)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(z12)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            int i15 = i12 << 3;
            DSRadioButtonKt.DSRadioButton(TestTagKt.testTag(Modifier.Companion, SelectableListItem.SelectableListItemRadioButtonTestTag), z11, z12, (Function0<Unit>) null, startRestartGroup, (i15 & 112) | 6 | (i15 & 896), 8);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SelectableListItemComposablesKt$ListItemRadioButton$1(z11, z12, i11));
        }
    }

    @Composable
    public static final void ListItemSelectableSurface(@NotNull Modifier modifier, @NotNull Function1<? super Boolean, Unit> function1, @NotNull MutableInteractionSource mutableInteractionSource, boolean z11, @NotNull MutableState<Boolean> mutableState, @NotNull Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Modifier modifier2 = modifier;
        Function1<? super Boolean, Unit> function12 = function1;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        MutableState<Boolean> mutableState2 = mutableState;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        int i19 = i11;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(function12, "onChanged");
        Intrinsics.checkNotNullParameter(mutableInteractionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(mutableState2, "isSelected");
        Intrinsics.checkNotNullParameter(function32, "content");
        Composer startRestartGroup = composer.startRestartGroup(664610563);
        if ((i19 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier2)) {
                i18 = 4;
            } else {
                i18 = 2;
            }
            i12 = i18 | i19;
        } else {
            i12 = i19;
        }
        if ((i19 & 112) == 0) {
            if (startRestartGroup.changed((Object) function12)) {
                i17 = 32;
            } else {
                i17 = 16;
            }
            i12 |= i17;
        }
        if ((i19 & 896) == 0) {
            if (startRestartGroup.changed((Object) mutableInteractionSource2)) {
                i16 = 256;
            } else {
                i16 = 128;
            }
            i12 |= i16;
        }
        boolean z12 = z11;
        if ((i19 & 7168) == 0) {
            if (startRestartGroup.changed(z12)) {
                i15 = 2048;
            } else {
                i15 = 1024;
            }
            i12 |= i15;
        }
        if ((57344 & i19) == 0) {
            if (startRestartGroup.changed((Object) mutableState2)) {
                i14 = 16384;
            } else {
                i14 = 8192;
            }
            i12 |= i14;
        }
        if ((458752 & i19) == 0) {
            if (startRestartGroup.changed((Object) function32)) {
                i13 = 131072;
            } else {
                i13 = 65536;
            }
            i12 |= i13;
        }
        int i21 = i12;
        if (((374491 & i21) ^ 74898) != 0 || !startRestartGroup.getSkipping()) {
            SelectableListItemComposablesKt$ListItemSelectableSurface$1 selectableListItemComposablesKt$ListItemSelectableSurface$1 = r2;
            SelectableListItemComposablesKt$ListItemSelectableSurface$1 selectableListItemComposablesKt$ListItemSelectableSurface$12 = new SelectableListItemComposablesKt$ListItemSelectableSurface$1(mutableInteractionSource, function1, z11, mutableState, function3, i21);
            CommonListItemComposablesKt.ListItemBackground(modifier2, ComposableLambdaKt.composableLambda(startRestartGroup, -819903940, true, selectableListItemComposablesKt$ListItemSelectableSurface$1), startRestartGroup, (i21 & 14) | 48);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SelectableListItemComposablesKt$ListItemSelectableSurface$2(modifier, function1, mutableInteractionSource, z11, mutableState, function3, i11));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* renamed from: ListItemSelectableTrailingContainer-TN_CM5M  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8491ListItemSelectableTrailingContainerTN_CM5M(@org.jetbrains.annotations.Nullable java.lang.String r24, @org.jetbrains.annotations.Nullable java.lang.String r25, float r26, boolean r27, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r3 = r26
            r6 = r30
            r0 = -123540117(0xfffffffff8a2ed6b, float:-2.6436484E34)
            r1 = r29
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r31 & 1
            if (r1 == 0) goto L_0x0017
            r2 = r6 | 6
            r4 = r2
            r2 = r24
            goto L_0x002b
        L_0x0017:
            r2 = r6 & 14
            if (r2 != 0) goto L_0x0028
            r2 = r24
            boolean r4 = r0.changed((java.lang.Object) r2)
            if (r4 == 0) goto L_0x0025
            r4 = 4
            goto L_0x0026
        L_0x0025:
            r4 = 2
        L_0x0026:
            r4 = r4 | r6
            goto L_0x002b
        L_0x0028:
            r2 = r24
            r4 = r6
        L_0x002b:
            r5 = r31 & 2
            if (r5 == 0) goto L_0x0032
            r4 = r4 | 48
            goto L_0x0045
        L_0x0032:
            r7 = r6 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0045
            r7 = r25
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0041
            r8 = 32
            goto L_0x0043
        L_0x0041:
            r8 = 16
        L_0x0043:
            r4 = r4 | r8
            goto L_0x0047
        L_0x0045:
            r7 = r25
        L_0x0047:
            r8 = r31 & 4
            if (r8 == 0) goto L_0x004e
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004e:
            r8 = r6 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x005e
            boolean r8 = r0.changed((float) r3)
            if (r8 == 0) goto L_0x005b
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r4 = r4 | r8
        L_0x005e:
            r8 = r31 & 8
            if (r8 == 0) goto L_0x0067
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            r13 = r27
            goto L_0x0079
        L_0x0067:
            r8 = r6 & 7168(0x1c00, float:1.0045E-41)
            r13 = r27
            if (r8 != 0) goto L_0x0079
            boolean r8 = r0.changed((boolean) r13)
            if (r8 == 0) goto L_0x0076
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r4 = r4 | r8
        L_0x0079:
            r8 = r31 & 16
            if (r8 == 0) goto L_0x0080
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0095
        L_0x0080:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r6
            if (r9 != 0) goto L_0x0095
            r9 = r28
            boolean r10 = r0.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0091
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0093
        L_0x0091:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0093:
            r4 = r4 | r10
            goto L_0x0097
        L_0x0095:
            r9 = r28
        L_0x0097:
            r10 = 46811(0xb6db, float:6.5596E-41)
            r10 = r10 & r4
            r10 = r10 ^ 9362(0x2492, float:1.3119E-41)
            if (r10 != 0) goto L_0x00ae
            boolean r10 = r0.getSkipping()
            if (r10 != 0) goto L_0x00a6
            goto L_0x00ae
        L_0x00a6:
            r0.skipToGroupEnd()
            r1 = r2
            r2 = r7
            r5 = r9
            goto L_0x028c
        L_0x00ae:
            r10 = 0
            if (r1 == 0) goto L_0x00b2
            r2 = r10
        L_0x00b2:
            if (r5 == 0) goto L_0x00b6
            r1 = r10
            goto L_0x00b7
        L_0x00b6:
            r1 = r7
        L_0x00b7:
            if (r8 == 0) goto L_0x00bb
            r5 = r10
            goto L_0x00bc
        L_0x00bb:
            r5 = r9
        L_0x00bc:
            if (r5 != 0) goto L_0x00c9
            r4 = 465230552(0x1bbadad8, float:3.0912543E-22)
            r0.startReplaceableGroup(r4)
        L_0x00c4:
            r0.endReplaceableGroup()
            goto L_0x0287
        L_0x00c9:
            r7 = -123539895(0xfffffffff8a2ee49, float:-2.6437034E34)
            r0.startReplaceableGroup(r7)
            androidx.compose.ui.Modifier$Companion r14 = androidx.compose.ui.Modifier.Companion
            r7 = 0
            r8 = 1
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m565widthInVpY3zN4$default(r14, r7, r3, r8, r10)
            androidx.compose.ui.Alignment$Companion r15 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r8 = r15.getCenterVertically()
            r12 = -1989997546(0xffffffff89630c16, float:-2.7329814E-33)
            r0.startReplaceableGroup(r12)
            androidx.compose.foundation.layout.Arrangement r16 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r9 = r16.getStart()
            r11 = 0
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r9, r8, r0, r11)
            r10 = 1376089335(0x520574f7, float:1.43298249E11)
            r0.startReplaceableGroup(r10)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r7 = androidx.compose.ui.layout.LayoutKt.materializerOf(r7)
            androidx.compose.runtime.Applier r11 = r0.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x011d
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x011d:
            r0.startReusableNode()
            boolean r11 = r0.getInserting()
            if (r11 == 0) goto L_0x012a
            r0.createNode(r12)
            goto L_0x012d
        L_0x012a:
            r0.useNode()
        L_0x012d:
            r0.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r12 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r8, r12)
            kotlin.jvm.functions.Function2 r8 = r17.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r9, r8)
            kotlin.jvm.functions.Function2 r8 = r17.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r10, r8)
            r0.enableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r8)
            r9 = 0
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
            r7.invoke(r8, r0, r10)
            r12 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r12)
            r11 = -326682743(0xffffffffec873789, float:-1.307738E27)
            r0.startReplaceableGroup(r11)
            androidx.compose.foundation.layout.RowScopeInstance r10 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            com.designsystem.ds_theme.DSTheme r9 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r8 = 0
            com.designsystem.ds_theme.DSDimens r7 = r9.getDimens(r0, r8)
            float r7 = r7.m8844getDsXsD9Ej5fM()
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r14, r7)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r7, r0, r8)
            r7 = r4 & 14
            r18 = r4 & 112(0x70, float:1.57E-43)
            r7 = r7 | r18
            int r8 = r4 >> 3
            r8 = r8 & 896(0x380, float:1.256E-42)
            r18 = r7 | r8
            r19 = 0
            r7 = r2
            r20 = 0
            r8 = r1
            r21 = r9
            r9 = r27
            r22 = r10
            r10 = r0
            r3 = r20
            r11 = r18
            r12 = r19
            ListItemPriceContainer(r7, r8, r9, r10, r11, r12)
            if (r2 != 0) goto L_0x01ad
            if (r1 == 0) goto L_0x01a3
            goto L_0x01ad
        L_0x01a3:
            r7 = -1953506329(0xffffffff8b8fdbe7, float:-5.541247E-32)
            r0.startReplaceableGroup(r7)
            r0.endReplaceableGroup()
            goto L_0x01c7
        L_0x01ad:
            r7 = -1953506416(0xffffffff8b8fdb90, float:-5.541196E-32)
            r0.startReplaceableGroup(r7)
            r7 = r21
            com.designsystem.ds_theme.DSDimens r7 = r7.getDimens(r0, r3)
            float r7 = r7.m8846getDsXxsD9Ej5fM()
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r14, r7)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r7, r0, r3)
            r0.endReplaceableGroup()
        L_0x01c7:
            androidx.compose.ui.Alignment$Vertical r7 = r15.getCenterVertically()
            r8 = r22
            androidx.compose.ui.Modifier r7 = r8.align(r14, r7)
            r8 = -1989997546(0xffffffff89630c16, float:-2.7329814E-33)
            r0.startReplaceableGroup(r8)
            androidx.compose.foundation.layout.Arrangement$Horizontal r8 = r16.getStart()
            androidx.compose.ui.Alignment$Vertical r9 = r15.getTop()
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r8, r9, r0, r3)
            r9 = 1376089335(0x520574f7, float:1.43298249E11)
            r0.startReplaceableGroup(r9)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            kotlin.jvm.functions.Function0 r11 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r7 = androidx.compose.ui.layout.LayoutKt.materializerOf(r7)
            androidx.compose.runtime.Applier r12 = r0.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x0210
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0210:
            r0.startReusableNode()
            boolean r12 = r0.getInserting()
            if (r12 == 0) goto L_0x021d
            r0.createNode(r11)
            goto L_0x0220
        L_0x021d:
            r0.useNode()
        L_0x0220:
            r0.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r12 = r17.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r8, r12)
            kotlin.jvm.functions.Function2 r8 = r17.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r9, r8)
            kotlin.jvm.functions.Function2 r8 = r17.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r11, r10, r8)
            r0.enableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r8)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r7.invoke(r8, r0, r3)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r3)
            r3 = -326682743(0xffffffffec873789, float:-1.307738E27)
            r0.startReplaceableGroup(r3)
            int r3 = r4 >> 12
            r3 = r3 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r5.invoke(r0, r3)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            goto L_0x00c4
        L_0x0287:
            r23 = r2
            r2 = r1
            r1 = r23
        L_0x028c:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x0293
            goto L_0x02a4
        L_0x0293:
            com.designsystem.ds_list_item_v2.composables.SelectableListItemComposablesKt$ListItemSelectableTrailingContainer$2 r9 = new com.designsystem.ds_list_item_v2.composables.SelectableListItemComposablesKt$ListItemSelectableTrailingContainer$2
            r0 = r9
            r3 = r26
            r4 = r27
            r6 = r30
            r7 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.updateScope(r9)
        L_0x02a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_list_item_v2.composables.SelectableListItemComposablesKt.m8491ListItemSelectableTrailingContainerTN_CM5M(java.lang.String, java.lang.String, float, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    @Composable
    public static final void ListItemSwitch(boolean z11, boolean z12, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(728197990);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed(z11)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(z12)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            int i15 = i12 << 3;
            DSSwitchKt.DSSwitch(TestTagKt.testTag(Modifier.Companion, SelectableListItem.SelectableListItemSwitchTestTag), z11, z12, (Function1<? super Boolean, Unit>) null, startRestartGroup, (i15 & 112) | 6 | (i15 & 896), 8);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SelectableListItemComposablesKt$ListItemSwitch$1(z11, z12, i11));
        }
    }

    @Composable
    public static final void SelectionIndicator(@Nullable Modifier modifier, boolean z11, boolean z12, @Nullable Composer composer, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-1423976361);
        int i17 = i12 & 1;
        if (i17 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i13 = i16 | i11;
        } else {
            i13 = i11;
        }
        int i18 = i12 & 2;
        if (i18 != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(z11)) {
                i15 = 32;
            } else {
                i15 = 16;
            }
            i13 |= i15;
        }
        if ((i12 & 4) != 0) {
            i13 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i11 & 896) == 0) {
            if (startRestartGroup.changed(z12)) {
                i14 = 256;
            } else {
                i14 = 128;
            }
            i13 |= i14;
        }
        if (((i13 & 731) ^ Opcodes.I2C) != 0 || !startRestartGroup.getSkipping()) {
            if (i17 != 0) {
                modifier = Modifier.Companion;
            }
            if (i18 != 0) {
                z11 = true;
            }
            if (z11) {
                startRestartGroup.startReplaceableGroup(-1423976223);
                DSTheme dSTheme = DSTheme.INSTANCE;
                Modifier semantics$default = SemanticsModifierKt.semantics$default(PaddingKt.m487paddingVpY3zN4(modifier, dSTheme.getDimens(startRestartGroup, 0).m8849getDsZeroD9Ej5fM(), dSTheme.getDimens(startRestartGroup, 0).m8842getDsSD9Ej5fM()), false, SelectableListItemComposablesKt$SelectionIndicator$1.INSTANCE, 1, (Object) null);
                SelectableListItemComposablesKt$SelectionIndicator$2 selectableListItemComposablesKt$SelectionIndicator$2 = SelectableListItemComposablesKt$SelectionIndicator$2.INSTANCE;
                Boolean valueOf = Boolean.valueOf(z12);
                startRestartGroup.startReplaceableGroup(-3686930);
                boolean changed = startRestartGroup.changed((Object) valueOf);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new SelectableListItemComposablesKt$SelectionIndicator$3$1(z12);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                AndroidView_androidKt.AndroidView(selectableListItemComposablesKt$SelectionIndicator$2, semantics$default, (Function1) rememberedValue, startRestartGroup, 0, 0);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-1423975673);
                startRestartGroup.endReplaceableGroup();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        boolean z13 = z11;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SelectableListItemComposablesKt$SelectionIndicator$4(modifier2, z13, z12, i11, i12));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:215:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* renamed from: SelectionListItem-_zuB-KE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8492SelectionListItem_zuBKE(@org.jetbrains.annotations.NotNull java.lang.String r36, boolean r37, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r38, @org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r39, @org.jetbrains.annotations.Nullable java.lang.String r40, @org.jetbrains.annotations.Nullable java.lang.String r41, @org.jetbrains.annotations.Nullable @androidx.annotation.ColorRes java.lang.Integer r42, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r43, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r44, float r45, boolean r46, @org.jetbrains.annotations.Nullable java.lang.String r47, @org.jetbrains.annotations.Nullable java.lang.String r48, boolean r49, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super java.lang.Boolean, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r51, int r52, int r53, int r54) {
        /*
            r15 = r36
            r14 = r38
            r13 = r39
            r12 = r52
            r11 = r53
            r10 = r54
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onChanged"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -1825257773(0xffffffff9334c6d3, float:-2.2817222E-27)
            r1 = r51
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            r0 = r10 & 1
            if (r0 == 0) goto L_0x002b
            r0 = r12 | 6
            goto L_0x003b
        L_0x002b:
            r0 = r12 & 14
            if (r0 != 0) goto L_0x003a
            boolean r0 = r9.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0037
            r0 = 4
            goto L_0x0038
        L_0x0037:
            r0 = 2
        L_0x0038:
            r0 = r0 | r12
            goto L_0x003b
        L_0x003a:
            r0 = r12
        L_0x003b:
            r3 = r10 & 2
            if (r3 == 0) goto L_0x0044
            r0 = r0 | 48
            r8 = r37
            goto L_0x0056
        L_0x0044:
            r3 = r12 & 112(0x70, float:1.57E-43)
            r8 = r37
            if (r3 != 0) goto L_0x0056
            boolean r3 = r9.changed((boolean) r8)
            if (r3 == 0) goto L_0x0053
            r3 = 32
            goto L_0x0055
        L_0x0053:
            r3 = 16
        L_0x0055:
            r0 = r0 | r3
        L_0x0056:
            r3 = r10 & 4
            if (r3 == 0) goto L_0x005d
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005d:
            r3 = r12 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x006d
            boolean r3 = r9.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x006a
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x006c
        L_0x006a:
            r3 = 128(0x80, float:1.794E-43)
        L_0x006c:
            r0 = r0 | r3
        L_0x006d:
            r3 = r10 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0078
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0088
        L_0x0078:
            r3 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0088
            boolean r3 = r9.changed((java.lang.Object) r13)
            if (r3 == 0) goto L_0x0085
            r3 = r16
            goto L_0x0087
        L_0x0085:
            r3 = r17
        L_0x0087:
            r0 = r0 | r3
        L_0x0088:
            r3 = r10 & 16
            r18 = 57344(0xe000, float:8.0356E-41)
            r19 = 16384(0x4000, float:2.2959E-41)
            r20 = 8192(0x2000, float:1.14794E-41)
            if (r3 == 0) goto L_0x0098
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r1 = r40
            goto L_0x00ab
        L_0x0098:
            r21 = r12 & r18
            r1 = r40
            if (r21 != 0) goto L_0x00ab
            boolean r21 = r9.changed((java.lang.Object) r1)
            if (r21 == 0) goto L_0x00a7
            r21 = r19
            goto L_0x00a9
        L_0x00a7:
            r21 = r20
        L_0x00a9:
            r0 = r0 | r21
        L_0x00ab:
            r21 = r10 & 32
            if (r21 == 0) goto L_0x00b6
            r22 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r22
            r4 = r41
            goto L_0x00cb
        L_0x00b6:
            r22 = 458752(0x70000, float:6.42848E-40)
            r22 = r12 & r22
            r4 = r41
            if (r22 != 0) goto L_0x00cb
            boolean r23 = r9.changed((java.lang.Object) r4)
            if (r23 == 0) goto L_0x00c7
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r23 = 65536(0x10000, float:9.18355E-41)
        L_0x00c9:
            r0 = r0 | r23
        L_0x00cb:
            r23 = r10 & 64
            if (r23 == 0) goto L_0x00d6
            r24 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r24
            r5 = r42
            goto L_0x00eb
        L_0x00d6:
            r24 = 3670016(0x380000, float:5.142788E-39)
            r24 = r12 & r24
            r5 = r42
            if (r24 != 0) goto L_0x00eb
            boolean r25 = r9.changed((java.lang.Object) r5)
            if (r25 == 0) goto L_0x00e7
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e9
        L_0x00e7:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x00e9:
            r0 = r0 | r25
        L_0x00eb:
            r6 = r10 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00f6
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r26
            r7 = r43
            goto L_0x010b
        L_0x00f6:
            r26 = 29360128(0x1c00000, float:7.052966E-38)
            r26 = r12 & r26
            r7 = r43
            if (r26 != 0) goto L_0x010b
            boolean r27 = r9.changed((java.lang.Object) r7)
            if (r27 == 0) goto L_0x0107
            r27 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0109
        L_0x0107:
            r27 = 4194304(0x400000, float:5.877472E-39)
        L_0x0109:
            r0 = r0 | r27
        L_0x010b:
            r2 = r10 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0116
            r28 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r28
            r1 = r44
            goto L_0x012b
        L_0x0116:
            r28 = 234881024(0xe000000, float:1.5777218E-30)
            r28 = r12 & r28
            r1 = r44
            if (r28 != 0) goto L_0x012b
            boolean r28 = r9.changed((java.lang.Object) r1)
            if (r28 == 0) goto L_0x0127
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0129
        L_0x0127:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0129:
            r0 = r0 | r28
        L_0x012b:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r12 & r28
            if (r28 != 0) goto L_0x0147
            r1 = r10 & 512(0x200, float:7.175E-43)
            if (r1 != 0) goto L_0x0140
            r1 = r45
            boolean r28 = r9.changed((float) r1)
            if (r28 == 0) goto L_0x0142
            r28 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0144
        L_0x0140:
            r1 = r45
        L_0x0142:
            r28 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0144:
            r0 = r0 | r28
            goto L_0x0149
        L_0x0147:
            r1 = r45
        L_0x0149:
            r1 = r10 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0152
            r28 = r11 | 6
            r4 = r46
            goto L_0x0168
        L_0x0152:
            r28 = r11 & 14
            r4 = r46
            if (r28 != 0) goto L_0x0166
            boolean r28 = r9.changed((boolean) r4)
            if (r28 == 0) goto L_0x0161
            r28 = 4
            goto L_0x0163
        L_0x0161:
            r28 = 2
        L_0x0163:
            r28 = r11 | r28
            goto L_0x0168
        L_0x0166:
            r28 = r11
        L_0x0168:
            r4 = r10 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x016f
            r28 = r28 | 48
            goto L_0x0182
        L_0x016f:
            r29 = r11 & 112(0x70, float:1.57E-43)
            r5 = r47
            if (r29 != 0) goto L_0x0182
            boolean r29 = r9.changed((java.lang.Object) r5)
            if (r29 == 0) goto L_0x017e
            r22 = 32
            goto L_0x0180
        L_0x017e:
            r22 = 16
        L_0x0180:
            r28 = r28 | r22
        L_0x0182:
            r5 = r28
            r7 = r10 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x018b
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x019f
        L_0x018b:
            r8 = r11 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x019f
            r8 = r48
            boolean r22 = r9.changed((java.lang.Object) r8)
            if (r22 == 0) goto L_0x019a
            r25 = 256(0x100, float:3.59E-43)
            goto L_0x019c
        L_0x019a:
            r25 = 128(0x80, float:1.794E-43)
        L_0x019c:
            r5 = r5 | r25
            goto L_0x01a1
        L_0x019f:
            r8 = r48
        L_0x01a1:
            r8 = r10 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x01a8
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x01ba
        L_0x01a8:
            r13 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r13 != 0) goto L_0x01ba
            r13 = r49
            boolean r22 = r9.changed((boolean) r13)
            if (r22 == 0) goto L_0x01b5
            goto L_0x01b7
        L_0x01b5:
            r16 = r17
        L_0x01b7:
            r5 = r5 | r16
            goto L_0x01bc
        L_0x01ba:
            r13 = r49
        L_0x01bc:
            r13 = r10 & 16384(0x4000, float:2.2959E-41)
            if (r13 == 0) goto L_0x01c5
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r11 = r50
            goto L_0x01d6
        L_0x01c5:
            r16 = r11 & r18
            r11 = r50
            if (r16 != 0) goto L_0x01d6
            boolean r16 = r9.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x01d2
            goto L_0x01d4
        L_0x01d2:
            r19 = r20
        L_0x01d4:
            r5 = r5 | r19
        L_0x01d6:
            r16 = r5
            r5 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r5 = r5 & r0
            r17 = 306783378(0x12492492, float:6.3469493E-28)
            r5 = r5 ^ r17
            if (r5 != 0) goto L_0x020e
            r5 = 46811(0xb6db, float:6.5596E-41)
            r5 = r16 & r5
            r5 = r5 ^ 9362(0x2492, float:1.3119E-41)
            if (r5 != 0) goto L_0x020e
            boolean r5 = r9.getSkipping()
            if (r5 != 0) goto L_0x01f3
            goto L_0x020e
        L_0x01f3:
            r9.skipToGroupEnd()
            r5 = r40
            r6 = r41
            r7 = r42
            r8 = r43
            r10 = r45
            r12 = r47
            r13 = r48
            r14 = r49
            r1 = r9
            r15 = r11
            r9 = r44
            r11 = r46
            goto L_0x0363
        L_0x020e:
            r5 = r12 & 1
            if (r5 == 0) goto L_0x023e
            boolean r5 = r9.getDefaultsInvalid()
            if (r5 == 0) goto L_0x0219
            goto L_0x023e
        L_0x0219:
            r9.skipCurrentGroup()
            r1 = r10 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0224
            r1 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r0 = r0 & r1
        L_0x0224:
            r17 = r40
            r19 = r41
            r20 = r42
            r21 = r43
            r22 = r44
            r23 = r45
            r24 = r46
            r25 = r47
            r26 = r48
            r28 = r49
            r29 = r50
            r30 = r0
            goto L_0x02b3
        L_0x023e:
            r9.startDefaults()
            if (r3 == 0) goto L_0x0245
            r3 = 0
            goto L_0x0247
        L_0x0245:
            r3 = r40
        L_0x0247:
            if (r21 == 0) goto L_0x024b
            r5 = 0
            goto L_0x024d
        L_0x024b:
            r5 = r41
        L_0x024d:
            if (r23 == 0) goto L_0x0252
            r17 = 0
            goto L_0x0254
        L_0x0252:
            r17 = r42
        L_0x0254:
            if (r6 == 0) goto L_0x0258
            r6 = 0
            goto L_0x025a
        L_0x0258:
            r6 = r43
        L_0x025a:
            if (r2 == 0) goto L_0x025e
            r2 = 0
            goto L_0x0260
        L_0x025e:
            r2 = r44
        L_0x0260:
            r11 = r10 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0276
            com.designsystem.ds_theme.DSTheme r11 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r40 = r2
            r2 = 0
            com.designsystem.ds_theme.DSDimens r2 = r11.getDimens(r9, r2)
            float r2 = r2.m8841getDsMD9Ej5fM()
            r11 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r0 = r0 & r11
            goto L_0x027a
        L_0x0276:
            r40 = r2
            r2 = r45
        L_0x027a:
            if (r1 == 0) goto L_0x027e
            r1 = 1
            goto L_0x0280
        L_0x027e:
            r1 = r46
        L_0x0280:
            if (r4 == 0) goto L_0x0284
            r4 = 0
            goto L_0x0286
        L_0x0284:
            r4 = r47
        L_0x0286:
            if (r7 == 0) goto L_0x028a
            r7 = 0
            goto L_0x028c
        L_0x028a:
            r7 = r48
        L_0x028c:
            if (r8 == 0) goto L_0x0290
            r8 = 1
            goto L_0x0292
        L_0x0290:
            r8 = r49
        L_0x0292:
            if (r13 == 0) goto L_0x0296
            r11 = 0
            goto L_0x0298
        L_0x0296:
            r11 = r50
        L_0x0298:
            r9.endDefaults()
            r22 = r40
            r30 = r0
            r24 = r1
            r23 = r2
            r25 = r4
            r19 = r5
            r21 = r6
            r26 = r7
            r28 = r8
            r29 = r11
            r20 = r17
            r17 = r3
        L_0x02b3:
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r9.startReplaceableGroup(r0)
            java.lang.Object r0 = r9.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r1.getEmpty()
            if (r0 != r2) goto L_0x02cc
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r9.updateRememberedValue(r0)
        L_0x02cc:
            r9.endReplaceableGroup()
            r31 = r0
            androidx.compose.foundation.interaction.MutableInteractionSource r31 = (androidx.compose.foundation.interaction.MutableInteractionSource) r31
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r9.startReplaceableGroup(r0)
            java.lang.Object r0 = r9.rememberedValue()
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x02f0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r37)
            r1 = 2
            r2 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r2, r1, r2)
            r9.updateRememberedValue(r0)
        L_0x02f0:
            r9.endReplaceableGroup()
            r27 = r0
            androidx.compose.runtime.MutableState r27 = (androidx.compose.runtime.MutableState) r27
            com.designsystem.ds_list_item_v2.composables.SelectableListItemComposablesKt$SelectionListItem$1 r13 = new com.designsystem.ds_list_item_v2.composables.SelectableListItemComposablesKt$SelectionListItem$1
            r0 = r13
            r1 = r21
            r2 = r22
            r3 = r28
            r4 = r27
            r5 = r24
            r6 = r16
            r7 = r30
            r8 = r25
            r11 = r9
            r9 = r26
            r10 = r23
            r32 = r11
            r11 = r36
            r12 = r19
            r33 = r13
            r13 = r17
            r14 = r20
            r15 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0 = -819893709(0xffffffffcf216a33, float:-2.70809165E9)
            r1 = r32
            r2 = r33
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r3, r2)
            int r2 = r30 >> 9
            r2 = r2 & 14
            r3 = 221568(0x36180, float:3.10483E-40)
            r2 = r2 | r3
            int r3 = r30 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            int r3 = r16 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            r40 = r39
            r41 = r38
            r42 = r31
            r43 = r24
            r44 = r27
            r45 = r0
            r46 = r1
            r47 = r2
            ListItemSelectableSurface(r40, r41, r42, r43, r44, r45, r46, r47)
            r5 = r17
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r11 = r24
            r12 = r25
            r13 = r26
            r14 = r28
        L_0x0363:
            androidx.compose.runtime.ScopeUpdateScope r4 = r1.endRestartGroup()
            if (r4 != 0) goto L_0x036a
            goto L_0x0389
        L_0x036a:
            com.designsystem.ds_list_item_v2.composables.SelectableListItemComposablesKt$SelectionListItem$2 r3 = new com.designsystem.ds_list_item_v2.composables.SelectableListItemComposablesKt$SelectionListItem$2
            r0 = r3
            r1 = r36
            r2 = r37
            r34 = r3
            r3 = r38
            r35 = r4
            r4 = r39
            r16 = r52
            r17 = r53
            r18 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r1 = r34
            r0 = r35
            r0.updateScope(r1)
        L_0x0389:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_list_item_v2.composables.SelectableListItemComposablesKt.m8492SelectionListItem_zuBKE(java.lang.String, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, float, boolean, java.lang.String, java.lang.String, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    @Stable
    public static final Modifier selectable(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, Function1<? super Boolean, Unit> function1, boolean z11, MutableState<Boolean> mutableState) {
        if (!z11) {
            return modifier;
        }
        return modifier.then(ClickableKt.m194clickableO2vRcR0$default(modifier, mutableInteractionSource, indication, false, (String) null, Role.m4904boximpl(Role.Companion.m4911getButtono7Vup1c()), new SelectableListItemComposablesKt$selectable$1(mutableState, function1), 12, (Object) null));
    }
}
