package com.designsystem.ds_input_field;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shadow;
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
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\r\u0010\t\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\r\u0010\f\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\n\u001a\u0015\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"bigHintTextStyle", "Landroidx/compose/ui/text/TextStyle;", "isEnabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "getInputTextColor", "Landroidx/compose/ui/graphics/Color;", "(ZLandroidx/compose/runtime/Composer;I)J", "getTextColor", "helperTextStyle", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "inputTextStyle", "prefixTextStyle", "smallHintTextStyle", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class InputFieldTextStyleComposablesKt {
    @NotNull
    @Composable
    public static final TextStyle bigHintTextStyle(boolean z11, @Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-722542054);
        TextStyle r12 = TextStyle.m5046copyHL5avdY$default(DSTheme.INSTANCE.getTypography(composer2, 0).getDsBody0(), getTextColor(z11, composer2, i11 & 14), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null);
        composer.endReplaceableGroup();
        return r12;
    }

    @Composable
    public static final long getInputTextColor(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(-115786787);
        if (z11) {
            composer.startReplaceableGroup(-115786710);
            j11 = DSTheme.INSTANCE.getColors(composer, 0).m8760getDsNeutral1000d7_KjU();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-115786661);
            j11 = DSTheme.INSTANCE.getColors(composer, 0).m8764getDsNeutral350d7_KjU();
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return j11;
    }

    @Composable
    public static final long getTextColor(boolean z11, @Nullable Composer composer, int i11) {
        long j11;
        composer.startReplaceableGroup(121487162);
        if (z11) {
            composer.startReplaceableGroup(121487234);
            j11 = DSTheme.INSTANCE.getColors(composer, 0).m8771getDsNeutral700d7_KjU();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(121487282);
            j11 = DSTheme.INSTANCE.getColors(composer, 0).m8764getDsNeutral350d7_KjU();
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return j11;
    }

    @NotNull
    @Composable
    public static final TextStyle helperTextStyle(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(1528372363);
        TextStyle dsCaption = DSTheme.INSTANCE.getTypography(composer, 0).getDsCaption();
        composer.endReplaceableGroup();
        return dsCaption;
    }

    @NotNull
    @Composable
    public static final TextStyle inputTextStyle(boolean z11, @Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(636093608);
        TextStyle r12 = TextStyle.m5046copyHL5avdY$default(DSTheme.INSTANCE.getTypography(composer2, 0).getDsBody0(), getInputTextColor(z11, composer2, i11 & 14), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null);
        composer.endReplaceableGroup();
        return r12;
    }

    @NotNull
    @Composable
    public static final TextStyle prefixTextStyle(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(364933441);
        DSTheme dSTheme = DSTheme.INSTANCE;
        TextStyle r12 = TextStyle.m5046copyHL5avdY$default(dSTheme.getTypography(composer2, 0).getDsBody0(), dSTheme.getColors(composer2, 0).m8764getDsNeutral350d7_KjU(), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null);
        composer.endReplaceableGroup();
        return r12;
    }

    @NotNull
    @Composable
    public static final TextStyle smallHintTextStyle(boolean z11, @Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1697114187);
        TextStyle r12 = TextStyle.m5046copyHL5avdY$default(DSTheme.INSTANCE.getTypography(composer2, 0).getDsCaption(), getTextColor(z11, composer2, i11 & 14), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (Object) null);
        composer.endReplaceableGroup();
        return r12;
    }
}
