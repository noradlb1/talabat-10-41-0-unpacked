package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material3.tokens.FilledAutocompleteTokens;
import androidx.compose.material3.tokens.OutlinedAutocompleteTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u0002\u0010*\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010+\u001a\u00020\u000f2\b\b\u0002\u0010,\u001a\u00020\u000f2\b\b\u0002\u0010-\u001a\u00020\u000f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010)R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuDefaults;", "", "()V", "ItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "TrailingIcon", "", "expanded", "", "(ZLandroidx/compose/runtime/Composer;I)V", "outlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "containerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-St-qZLY", "(JJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-St-qZLY", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    @NotNull
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();
    @NotNull
    private static final PaddingValues ItemContentPadding = PaddingKt.m480PaddingValuesYgX7TsA(ExposedDropdownMenuKt.ExposedDropdownMenuItemHorizontalPadding, Dp.m5478constructorimpl((float) 0));

    private ExposedDropdownMenuDefaults() {
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @ExperimentalMaterial3Api
    @Composable
    public final void TrailingIcon(boolean z11, @Nullable Composer composer, int i11) {
        int i12;
        float f11;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-1803742020);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed(z11)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1803742020, i11, -1, "androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon (ExposedDropdownMenu.kt:298)");
            }
            ImageVector arrowDropDown = ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE);
            Modifier.Companion companion = Modifier.Companion;
            if (z11) {
                f11 = 180.0f;
            } else {
                f11 = 0.0f;
            }
            IconKt.m1718Iconww6aTOc(arrowDropDown, (String) null, RotateKt.rotate(companion, f11), 0, startRestartGroup, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ExposedDropdownMenuDefaults$TrailingIcon$1(this, z11, i11));
        }
    }

    @NotNull
    public final PaddingValues getItemContentPadding() {
        return ItemContentPadding;
    }

    @NotNull
    @Composable
    /* renamed from: outlinedTextFieldColors-St-qZLY  reason: not valid java name */
    public final TextFieldColors m1669outlinedTextFieldColorsStqZLY(long j11, long j12, long j13, long j14, long j15, @Nullable TextSelectionColors textSelectionColors, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, long j35, @Nullable Composer composer, int i11, int i12, int i13, int i14) {
        Composer composer2 = composer;
        int i15 = i11;
        int i16 = i12;
        int i17 = i13;
        int i18 = i14;
        composer2.startReplaceableGroup(-83147315);
        long color = (i18 & 1) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer2, 6) : j11;
        long r92 = (i18 & 2) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j12;
        long r11 = (i18 & 4) != 0 ? Color.Companion.m2954getTransparent0d7_KjU() : j13;
        long color2 = (i18 & 8) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer2, 6) : j14;
        long color3 = (i18 & 16) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer2, 6) : j15;
        TextSelectionColors textSelectionColors2 = (i18 & 32) != 0 ? (TextSelectionColors) composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors()) : textSelectionColors;
        long color4 = (i18 & 64) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusOutlineColor(), composer2, 6) : j16;
        long color5 = (i18 & 128) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldOutlineColor(), composer2, 6) : j17;
        long r23 = (i18 & 256) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledOutlineColor(), composer2, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j18;
        long color6 = (i18 & 512) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorOutlineColor(), composer2, 6) : j19;
        long color7 = (i18 & 1024) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer2, 6) : j21;
        long color8 = (i18 & 2048) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer2, 6) : j22;
        long r31 = (i18 & 4096) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j23;
        long color9 = (i18 & 8192) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer2, 6) : j24;
        long color10 = (i18 & 16384) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer2, 6) : j25;
        long color11 = (32768 & i18) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer2, 6) : j26;
        long r39 = (65536 & i18) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j27;
        long color12 = (131072 & i18) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer2, 6) : j28;
        long color13 = (262144 & i18) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer2, 6) : j29;
        long color14 = (524288 & i18) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer2, 6) : j31;
        long r61 = (1048576 & i18) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j32;
        long color15 = (2097152 & i18) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer2, 6) : j33;
        long color16 = (4194304 & i18) != 0 ? ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j34;
        long r67 = (i18 & 8388608) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(OutlinedAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j35;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-83147315, i15, i16, "androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors (ExposedDropdownMenu.kt:440)");
        }
        TextFieldColors r02 = TextFieldDefaults.INSTANCE.m1914outlinedTextFieldColorsl59Burw(color, r92, r11, color2, color3, textSelectionColors2, color4, color5, r23, color6, color7, color8, r31, color9, color10, color11, r39, color12, color13, color14, r61, color15, color16, r67, 0, 0, 0, 0, composer, (i15 & 14) | (i15 & 112) | (i15 & 896) | (i15 & 7168) | (i15 & 57344) | (i15 & Opcodes.ASM7) | (i15 & 3670016) | (i15 & 29360128) | (i15 & 234881024) | (i15 & 1879048192), (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (i16 & 57344) | (i16 & Opcodes.ASM7) | (i16 & 3670016) | (i16 & 29360128) | (i16 & 234881024) | (i16 & 1879048192), 100663296 | (i17 & 14) | (i17 & 112) | (i17 & 896) | (i17 & 7168), 251658240);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r02;
    }

    @NotNull
    @Composable
    /* renamed from: textFieldColors-St-qZLY  reason: not valid java name */
    public final TextFieldColors m1670textFieldColorsStqZLY(long j11, long j12, long j13, long j14, long j15, @Nullable TextSelectionColors textSelectionColors, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j31, long j32, long j33, long j34, long j35, @Nullable Composer composer, int i11, int i12, int i13, int i14) {
        Composer composer2 = composer;
        int i15 = i11;
        int i16 = i12;
        int i17 = i13;
        int i18 = i14;
        composer2.startReplaceableGroup(-2013303349);
        long color = (i18 & 1) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldInputTextColor(), composer2, 6) : j11;
        long r92 = (i18 & 2) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j12;
        long color2 = (i18 & 4) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldContainerColor(), composer2, 6) : j13;
        long color3 = (i18 & 8) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldCaretColor(), composer2, 6) : j14;
        long color4 = (i18 & 16) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorFocusCaretColor(), composer2, 6) : j15;
        TextSelectionColors textSelectionColors2 = (i18 & 32) != 0 ? (TextSelectionColors) composer2.consume(TextSelectionColorsKt.getLocalTextSelectionColors()) : textSelectionColors;
        long color5 = (i18 & 64) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusActiveIndicatorColor(), composer2, 6) : j16;
        long color6 = (i18 & 128) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldActiveIndicatorColor(), composer2, 6) : j17;
        long r23 = (i18 & 256) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledActiveIndicatorColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j18;
        long color7 = (i18 & 512) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorActiveIndicatorColor(), composer2, 6) : j19;
        long color8 = (i18 & 1024) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusLeadingIconColor(), composer2, 6) : j21;
        long color9 = (i18 & 2048) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldLeadingIconColor(), composer2, 6) : j22;
        long r31 = (i18 & 4096) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledLeadingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j23;
        long color10 = (i18 & 8192) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorLeadingIconColor(), composer2, 6) : j24;
        long color11 = (i18 & 16384) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldFocusTrailingIconColor(), composer2, 6) : j25;
        long color12 = (32768 & i18) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldTrailingIconColor(), composer2, 6) : j26;
        long r39 = (65536 & i18) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldDisabledTrailingIconColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j27;
        long color13 = (131072 & i18) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getTextFieldErrorTrailingIconColor(), composer2, 6) : j28;
        long color14 = (262144 & i18) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldFocusLabelTextColor(), composer2, 6) : j29;
        long color15 = (524288 & i18) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldLabelTextColor(), composer2, 6) : j31;
        long color16 = (1048576 & i18) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledLabelTextColor(), composer2, 6) : j32;
        long color17 = (2097152 & i18) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldErrorLabelTextColor(), composer2, 6) : j33;
        long color18 = (4194304 & i18) != 0 ? ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldSupportingTextColor(), composer2, 6) : j34;
        long r67 = (i18 & 8388608) != 0 ? Color.m2918copywmQWz5c$default(ColorSchemeKt.toColor(FilledAutocompleteTokens.INSTANCE.getFieldDisabledInputTextColor(), composer2, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j35;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013303349, i15, i16, "androidx.compose.material3.ExposedDropdownMenuDefaults.textFieldColors (ExposedDropdownMenu.kt:338)");
        }
        TextFieldColors r02 = TextFieldDefaults.INSTANCE.m1917textFieldColorsl59Burw(color, r92, color2, color3, color4, textSelectionColors2, color5, color6, r23, color7, color8, color9, r31, color10, color11, color12, r39, color13, color14, color15, color16, color17, color18, r67, 0, 0, 0, 0, composer, (i15 & 14) | (i15 & 112) | (i15 & 896) | (i15 & 7168) | (i15 & 57344) | (i15 & Opcodes.ASM7) | (i15 & 3670016) | (i15 & 29360128) | (i15 & 234881024) | (i15 & 1879048192), (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168) | (i16 & 57344) | (i16 & Opcodes.ASM7) | (i16 & 3670016) | (i16 & 29360128) | (i16 & 234881024) | (i16 & 1879048192), 100663296 | (i17 & 14) | (i17 & 112) | (i17 & 896) | (i17 & 7168), 251658240);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r02;
    }
}
