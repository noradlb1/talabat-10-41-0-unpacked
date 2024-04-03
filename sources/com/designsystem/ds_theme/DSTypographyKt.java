package com.designsystem.ds_theme;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import com.designsystem.marshmallow.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u000fH\u0002\u001a!\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0014\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"CircularXXFamily", "Landroidx/compose/ui/text/font/FontFamily;", "DMSansFamily", "GEDinarOneFamily", "LocalDSTypography", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcom/designsystem/ds_theme/DSTypography;", "getLocalDSTypography", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "arabicDSTypography", "getArabicDSTypography", "()Lcom/designsystem/ds_theme/DSTypography;", "englishDSTypography", "getEnglishDSTypography", "toArabic", "Landroidx/compose/ui/text/TextStyle;", "lineHeight", "Landroidx/compose/ui/unit/TextUnit;", "toArabic-mpE4wyQ", "(Landroidx/compose/ui/text/TextStyle;J)Landroidx/compose/ui/text/TextStyle;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSTypographyKt {
    @NotNull
    private static final FontFamily CircularXXFamily;
    @NotNull
    private static final FontFamily DMSansFamily;
    @NotNull
    private static final FontFamily GEDinarOneFamily;
    @NotNull
    private static final ProvidableCompositionLocal<DSTypography> LocalDSTypography = CompositionLocalKt.staticCompositionLocalOf(DSTypographyKt$LocalDSTypography$1.INSTANCE);
    @NotNull
    private static final DSTypography arabicDSTypography;
    @NotNull
    private static final DSTypography englishDSTypography;

    static {
        int i11 = R.font.dmsans_regular;
        FontWeight.Companion companion = FontWeight.Companion;
        FontFamily FontFamily = FontFamilyKt.FontFamily((List<? extends Font>) CollectionsKt__CollectionsKt.listOf(FontKt.m5105FontRetOiIg$default(i11, companion.getNormal(), 0, 4, (Object) null), FontKt.m5105FontRetOiIg$default(R.font.dmsans_bold, companion.getBold(), 0, 4, (Object) null), FontKt.m5105FontRetOiIg$default(R.font.dmsans_medium, companion.getMedium(), 0, 4, (Object) null)));
        FontFamily fontFamily = FontFamily;
        FontFamily fontFamily2 = FontFamily;
        FontFamily fontFamily3 = FontFamily;
        FontFamily fontFamily4 = FontFamily;
        FontFamily fontFamily5 = FontFamily;
        FontFamily fontFamily6 = FontFamily;
        FontFamily fontFamily7 = FontFamily;
        FontFamily fontFamily8 = FontFamily;
        FontFamily fontFamily9 = FontFamily;
        FontFamily fontFamily10 = FontFamily;
        FontFamily fontFamily11 = FontFamily;
        FontFamily fontFamily12 = FontFamily;
        FontFamily fontFamily13 = FontFamily;
        FontFamily fontFamily14 = FontFamily;
        DMSansFamily = FontFamily;
        GEDinarOneFamily = FontFamilyKt.FontFamily((List<? extends Font>) CollectionsKt__CollectionsKt.listOf(FontKt.m5105FontRetOiIg$default(R.font.gedinarone_regular, companion.getNormal(), 0, 4, (Object) null), FontKt.m5105FontRetOiIg$default(R.font.gedinarone_bold, companion.getBold(), 0, 4, (Object) null), FontKt.m5105FontRetOiIg$default(R.font.gedinarone_medium, companion.getMedium(), 0, 4, (Object) null)));
        FontFamily FontFamily2 = FontFamilyKt.FontFamily((List<? extends Font>) CollectionsKt__CollectionsKt.listOf(FontKt.m5105FontRetOiIg$default(R.font.circularxx_regular, companion.getNormal(), 0, 4, (Object) null), FontKt.m5105FontRetOiIg$default(R.font.circularxx_medium, companion.getMedium(), 0, 4, (Object) null), FontKt.m5105FontRetOiIg$default(R.font.circularxx_light, companion.getLight(), 0, 4, (Object) null), FontKt.m5105FontRetOiIg$default(R.font.circularxx_bold, companion.getBold(), 0, 4, (Object) null), FontKt.m5105FontRetOiIg$default(R.font.circularxx_black, companion.getBlack(), 0, 4, (Object) null)));
        CircularXXFamily = FontFamily2;
        long sp2 = TextUnitKt.getSp(24);
        long sp3 = TextUnitKt.getSp(32);
        TextStyle textStyle = r9;
        TextStyle textStyle2 = new TextStyle(0, sp2, companion.getBold(), (FontStyle) null, (FontSynthesis) null, fontFamily14, (String) null, TextUnitKt.getEm(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp3, (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        long sp4 = TextUnitKt.getSp(20);
        long sp5 = TextUnitKt.getSp(28);
        TextStyle textStyle3 = r35;
        TextStyle textStyle4 = new TextStyle(0, sp4, companion.getBold(), (FontStyle) null, (FontSynthesis) null, fontFamily13, (String) null, TextUnitKt.getEm(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp5, (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        long sp6 = TextUnitKt.getSp(16);
        long sp7 = TextUnitKt.getSp(20);
        TextStyle textStyle5 = r61;
        TextStyle textStyle6 = new TextStyle(0, sp6, companion.getBold(), (FontStyle) null, (FontSynthesis) null, fontFamily12, (String) null, TextUnitKt.getEm(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp7, (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        long sp8 = TextUnitKt.getSp(16);
        long sp9 = TextUnitKt.getSp(20);
        TextStyle textStyle7 = r87;
        TextStyle textStyle8 = new TextStyle(0, sp8, companion.getMedium(), (FontStyle) null, (FontSynthesis) null, fontFamily11, (String) null, TextUnitKt.getEm(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp9, (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        long sp10 = TextUnitKt.getSp(14);
        long sp11 = TextUnitKt.getSp(16);
        TextStyle textStyle9 = r113;
        TextStyle textStyle10 = new TextStyle(0, sp10, companion.getMedium(), (FontStyle) null, (FontSynthesis) null, fontFamily10, (String) null, TextUnitKt.getEm(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp11, (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        long sp12 = TextUnitKt.getSp(16);
        long sp13 = TextUnitKt.getSp(24);
        TextStyle textStyle11 = r139;
        TextStyle textStyle12 = new TextStyle(0, sp12, companion.getNormal(), (FontStyle) null, (FontSynthesis) null, fontFamily9, (String) null, TextUnitKt.getEm(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp13, (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        long sp14 = TextUnitKt.getSp(14);
        long sp15 = TextUnitKt.getSp(24);
        TextStyle textStyle13 = r165;
        TextStyle textStyle14 = new TextStyle(0, sp14, companion.getBold(), (FontStyle) null, (FontSynthesis) null, fontFamily8, (String) null, TextUnitKt.getEm(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp15, (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        long sp16 = TextUnitKt.getSp(14);
        long sp17 = TextUnitKt.getSp(20);
        TextStyle textStyle15 = r191;
        TextStyle textStyle16 = new TextStyle(0, sp16, companion.getNormal(), (FontStyle) null, (FontSynthesis) null, fontFamily7, (String) null, TextUnitKt.getEm(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp17, (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        long sp18 = TextUnitKt.getSp(14);
        long sp19 = TextUnitKt.getSp(20);
        TextStyle textStyle17 = r217;
        TextStyle textStyle18 = new TextStyle(0, sp18, companion.getBold(), (FontStyle) null, (FontSynthesis) null, fontFamily6, (String) null, TextUnitKt.getEm(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp19, (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        long em2 = TextUnitKt.getEm(0);
        TextStyle textStyle19 = r243;
        TextStyle textStyle20 = new TextStyle(0, TextUnitKt.getSp(14), companion.getNormal(), (FontStyle) null, (FontSynthesis) null, fontFamily5, (String) null, em2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(16), (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        long sp20 = TextUnitKt.getSp(14);
        long sp21 = TextUnitKt.getSp(20);
        TextStyle textStyle21 = r269;
        TextStyle textStyle22 = new TextStyle(0, sp20, companion.getMedium(), (FontStyle) null, (FontSynthesis) null, fontFamily4, (String) null, TextUnitKt.getEm(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp21, (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        long sp22 = TextUnitKt.getSp(16);
        long sp23 = TextUnitKt.getSp(20);
        TextStyle textStyle23 = r295;
        TextStyle textStyle24 = new TextStyle(0, sp22, companion.getMedium(), (FontStyle) null, (FontSynthesis) null, fontFamily3, (String) null, TextUnitKt.getEm(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp23, (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        long sp24 = TextUnitKt.getSp(12);
        long sp25 = TextUnitKt.getSp(16);
        TextStyle textStyle25 = r321;
        TextStyle textStyle26 = new TextStyle(0, sp24, companion.getNormal(), (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, TextUnitKt.getEm(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp25, (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        long sp26 = TextUnitKt.getSp(12);
        long sp27 = TextUnitKt.getSp(16);
        TextStyle textStyle27 = r347;
        TextStyle textStyle28 = new TextStyle(0, sp26, companion.getBold(), (FontStyle) null, (FontSynthesis) null, fontFamily, (String) null, TextUnitKt.getEm(0.02d), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp27, (TextIndent) null, 196441, (DefaultConstructorMarker) null);
        TextStyle textStyle29 = r373;
        TextStyle textStyle30 = new TextStyle(0, TextUnitKt.getSp(28), companion.getBold(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(32), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        TextStyle textStyle31 = r399;
        TextStyle textStyle32 = new TextStyle(0, TextUnitKt.getSp(24), companion.getBold(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(28), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        TextStyle textStyle33 = r425;
        TextStyle textStyle34 = new TextStyle(0, TextUnitKt.getSp(20), companion.getBold(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(24), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        long sp28 = TextUnitKt.getSp(18);
        long sp29 = TextUnitKt.getSp(20);
        TextStyle textStyle35 = r451;
        TextStyle textStyle36 = new TextStyle(0, sp28, companion.getBold(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, sp29, (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        TextStyle textStyle37 = r477;
        TextStyle textStyle38 = new TextStyle(0, TextUnitKt.getSp(18), companion.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(24), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        TextStyle textStyle39 = r503;
        TextStyle textStyle40 = new TextStyle(0, TextUnitKt.getSp(16), companion.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(20), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        TextStyle textStyle41 = r529;
        TextStyle textStyle42 = new TextStyle(0, TextUnitKt.getSp(14), companion.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(16), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        TextStyle textStyle43 = r555;
        TextStyle textStyle44 = new TextStyle(0, TextUnitKt.getSp(12), companion.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(16), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        TextStyle textStyle45 = r581;
        TextStyle textStyle46 = new TextStyle(0, TextUnitKt.getSp(16), companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(24), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        TextStyle textStyle47 = r607;
        TextStyle textStyle48 = new TextStyle(0, TextUnitKt.getSp(16), companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(20), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        TextStyle textStyle49 = r633;
        TextStyle textStyle50 = new TextStyle(0, TextUnitKt.getSp(14), companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(20), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        TextStyle textStyle51 = r659;
        TextStyle textStyle52 = new TextStyle(0, TextUnitKt.getSp(14), companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(16), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        TextStyle textStyle53 = r685;
        TextStyle textStyle54 = new TextStyle(0, TextUnitKt.getSp(12), companion.getNormal(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(16), (TextIndent) null, 196569, (DefaultConstructorMarker) null);
        long sp30 = TextUnitKt.getSp(16);
        long sp31 = TextUnitKt.getSp(24);
        FontWeight medium = companion.getMedium();
        TextDecoration.Companion companion2 = TextDecoration.Companion;
        TextStyle textStyle55 = r711;
        TextStyle textStyle56 = new TextStyle(0, sp30, medium, (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, companion2.getUnderline(), (Shadow) null, (TextAlign) null, (TextDirection) null, sp31, (TextIndent) null, 192473, (DefaultConstructorMarker) null);
        long sp32 = TextUnitKt.getSp(16);
        long sp33 = TextUnitKt.getSp(20);
        TextStyle textStyle57 = r737;
        TextStyle textStyle58 = new TextStyle(0, sp32, companion.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, companion2.getUnderline(), (Shadow) null, (TextAlign) null, (TextDirection) null, sp33, (TextIndent) null, 192473, (DefaultConstructorMarker) null);
        TextStyle textStyle59 = r763;
        TextStyle textStyle60 = new TextStyle(0, TextUnitKt.getSp(14), companion.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, companion2.getUnderline(), (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(20), (TextIndent) null, 192473, (DefaultConstructorMarker) null);
        TextStyle textStyle61 = r789;
        TextStyle textStyle62 = new TextStyle(0, TextUnitKt.getSp(12), companion.getMedium(), (FontStyle) null, (FontSynthesis) null, FontFamily2, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, companion2.getUnderline(), (Shadow) null, (TextAlign) null, (TextDirection) null, TextUnitKt.getSp(16), (TextIndent) null, 192473, (DefaultConstructorMarker) null);
        DSTypography dSTypography = new DSTypography(textStyle, textStyle3, textStyle5, textStyle7, textStyle9, textStyle11, textStyle13, textStyle15, textStyle17, textStyle19, textStyle21, textStyle23, textStyle25, textStyle27, textStyle29, textStyle31, textStyle33, textStyle35, textStyle37, textStyle39, textStyle41, textStyle43, textStyle45, textStyle47, textStyle49, textStyle51, textStyle53, textStyle55, textStyle57, textStyle59, textStyle61);
        englishDSTypography = dSTypography;
        arabicDSTypography = new DSTypography(m8850toArabicmpE4wyQ(dSTypography.getDsHeading0(), TextUnitKt.getSp(36)), m8850toArabicmpE4wyQ(dSTypography.getDsHeading1(), TextUnitKt.getSp(32)), m8850toArabicmpE4wyQ(dSTypography.getDsHeading2(), TextUnitKt.getSp(24)), m8850toArabicmpE4wyQ(dSTypography.getDsSubheading1(), TextUnitKt.getSp(24)), m8850toArabicmpE4wyQ(dSTypography.getDsSubheading2(), TextUnitKt.getSp(20)), m8850toArabicmpE4wyQ(dSTypography.getDsBody0(), TextUnitKt.getSp(28)), m8850toArabicmpE4wyQ(dSTypography.getDsBody0Bold(), TextUnitKt.getSp(28)), m8850toArabicmpE4wyQ(dSTypography.getDsBody1(), TextUnitKt.getSp(24)), m8850toArabicmpE4wyQ(dSTypography.getDsBody1Bold(), TextUnitKt.getSp(24)), m8850toArabicmpE4wyQ(dSTypography.getDsBody1Compact(), TextUnitKt.getSp(20)), m8850toArabicmpE4wyQ(dSTypography.getDsLink(), TextUnitKt.getSp(20)), m8850toArabicmpE4wyQ(dSTypography.getDsButton(), TextUnitKt.getSp(20)), m8850toArabicmpE4wyQ(dSTypography.getDsCaption(), TextUnitKt.getSp(16)), m8850toArabicmpE4wyQ(dSTypography.getDsTag(), TextUnitKt.getSp(16)), toArabic(dSTypography.getDsHeadingXXLarge()), toArabic(dSTypography.getDsHeadingXLarge()), toArabic(dSTypography.getDsHeadingLarge()), toArabic(dSTypography.getDsHeadingMedium()), toArabic(dSTypography.getDsSubheadingLarge()), toArabic(dSTypography.getDsSubheadingMedium()), toArabic(dSTypography.getDsSubheadingSmall()), toArabic(dSTypography.getDsSubheadingXSmall()), toArabic(dSTypography.getDsBodyMedium()), toArabic(dSTypography.getDsBodyMediumCompact()), toArabic(dSTypography.getDsBodySmall()), toArabic(dSTypography.getDsBodySmallCompact()), toArabic(dSTypography.getDsBodyXSmall()), toArabic(dSTypography.getDsLinkMedium()), toArabic(dSTypography.getDsLinkMediumCompact()), toArabic(dSTypography.getDsLinkSmall()), toArabic(dSTypography.getDsLinkXSmall()));
    }

    @NotNull
    public static final DSTypography getArabicDSTypography() {
        return arabicDSTypography;
    }

    @NotNull
    public static final DSTypography getEnglishDSTypography() {
        return englishDSTypography;
    }

    @NotNull
    public static final ProvidableCompositionLocal<DSTypography> getLocalDSTypography() {
        return LocalDSTypography;
    }

    private static final TextStyle toArabic(TextStyle textStyle) {
        return TextStyle.m5046copyHL5avdY$default(textStyle, 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, GEDinarOneFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262111, (Object) null);
    }

    /* renamed from: toArabic-mpE4wyQ  reason: not valid java name */
    private static final TextStyle m8850toArabicmpE4wyQ(TextStyle textStyle, long j11) {
        return TextStyle.m5046copyHL5avdY$default(textStyle, 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, GEDinarOneFamily, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, j11, (TextIndent) null, 196575, (Object) null);
    }
}
