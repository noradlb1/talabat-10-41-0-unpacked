package com.checkout.frames.style.view;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BÀ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0002\u0010!J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\u0019\u0010F\u001a\u00020\u0007HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010#J\u0019\u0010H\u001a\u00020\u0015HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u00101J\t\u0010J\u001a\u00020\u0017HÆ\u0003J\t\u0010K\u001a\u00020\u0019HÆ\u0003J\u0015\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\t\u0010N\u001a\u00020\u0017HÆ\u0003J\u0019\u0010O\u001a\u00020\u0005HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010#J\u0019\u0010Q\u001a\u00020\u0007HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010#J\u0019\u0010S\u001a\u0004\u0018\u00010\tHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\bTJ\u000b\u0010U\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0019\u0010W\u001a\u00020\u0007HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010#J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0019\u0010Z\u001a\u0004\u0018\u00010\u0012HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b[JÎ\u0001\u0010\\\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u0017HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b]\u0010^J\u0013\u0010_\u001a\u00020\u00172\b\u0010`\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010a\u001a\u00020\u0019HÖ\u0001J\t\u0010b\u001a\u00020cHÖ\u0001R%\u0010\u0004\u001a\u00020\u0005X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010&\u001a\u0004\b)\u0010#R\u001c\u0010\b\u001a\u0004\u0018\u00010\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001c\u0010\u000e\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010&\u001a\u0004\b.\u0010#R\u001c\u0010\u0013\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010&\u001a\u0004\b/\u0010#R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001c\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u00109\u001a\u0004\b8\u00101R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001a\u0010 \u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010;\"\u0004\bC\u0010D\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006d"}, d2 = {"Lcom/checkout/frames/style/view/TextLabelViewStyle;", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "style", "Landroidx/compose/ui/text/TextStyle;", "textMaxWidth", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "J", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontSize-XSAIIZE", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getLetterSpacing-XSAIIZE", "getLineHeight-XSAIIZE", "getMaxLines", "()I", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "getOnTextLayout", "()Lkotlin/jvm/functions/Function1;", "getOverflow-gIe3tQ8", "I", "getSoftWrap", "()Z", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getTextMaxWidth", "setTextMaxWidth", "(Z)V", "component1", "component10", "component10-XSAIIZE", "component11", "component11-gIe3tQ8", "component12", "component13", "component14", "component15", "component16", "component2", "component2-0d7_KjU", "component3", "component3-XSAIIZE", "component4", "component4-4Lr2A7w", "component5", "component6", "component7", "component7-XSAIIZE", "component8", "component9", "component9-buA522U", "copy", "copy-M3jlewk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Z)Lcom/checkout/frames/style/view/TextLabelViewStyle;", "equals", "other", "hashCode", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextLabelViewStyle {
    private long color;
    @Nullable
    private final FontFamily fontFamily;
    private final long fontSize;
    @Nullable
    private final FontStyle fontStyle;
    @Nullable
    private final FontWeight fontWeight;
    private final long letterSpacing;
    private final long lineHeight;
    private final int maxLines;
    @NotNull
    private Modifier modifier;
    @NotNull
    private final Function1<TextLayoutResult, Unit> onTextLayout;
    private final int overflow;
    private final boolean softWrap;
    @Nullable
    private final TextStyle style;
    @Nullable
    private final TextAlign textAlign;
    @Nullable
    private final TextDecoration textDecoration;
    private boolean textMaxWidth;

    private TextLabelViewStyle(Modifier modifier2, long j11, long j12, FontStyle fontStyle2, FontWeight fontWeight2, FontFamily fontFamily2, long j13, TextDecoration textDecoration2, TextAlign textAlign2, long j14, int i11, boolean z11, int i12, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, boolean z12) {
        this.modifier = modifier2;
        this.color = j11;
        this.fontSize = j12;
        this.fontStyle = fontStyle2;
        this.fontWeight = fontWeight2;
        this.fontFamily = fontFamily2;
        this.letterSpacing = j13;
        this.textDecoration = textDecoration2;
        this.textAlign = textAlign2;
        this.lineHeight = j14;
        this.overflow = i11;
        this.softWrap = z11;
        this.maxLines = i12;
        this.onTextLayout = function1;
        this.style = textStyle;
        this.textMaxWidth = z12;
    }

    public /* synthetic */ TextLabelViewStyle(Modifier modifier2, long j11, long j12, FontStyle fontStyle2, FontWeight fontWeight2, FontFamily fontFamily2, long j13, TextDecoration textDecoration2, TextAlign textAlign2, long j14, int i11, boolean z11, int i12, Function1 function1, TextStyle textStyle, boolean z12, DefaultConstructorMarker defaultConstructorMarker) {
        this(modifier2, j11, j12, fontStyle2, fontWeight2, fontFamily2, j13, textDecoration2, textAlign2, j14, i11, z11, i12, function1, textStyle, z12);
    }

    /* renamed from: copy-M3jlewk$default  reason: not valid java name */
    public static /* synthetic */ TextLabelViewStyle m9300copyM3jlewk$default(TextLabelViewStyle textLabelViewStyle, Modifier modifier2, long j11, long j12, FontStyle fontStyle2, FontWeight fontWeight2, FontFamily fontFamily2, long j13, TextDecoration textDecoration2, TextAlign textAlign2, long j14, int i11, boolean z11, int i12, Function1 function1, TextStyle textStyle, boolean z12, int i13, Object obj) {
        TextLabelViewStyle textLabelViewStyle2 = textLabelViewStyle;
        int i14 = i13;
        return textLabelViewStyle.m9308copyM3jlewk((i14 & 1) != 0 ? textLabelViewStyle2.modifier : modifier2, (i14 & 2) != 0 ? textLabelViewStyle2.color : j11, (i14 & 4) != 0 ? textLabelViewStyle2.fontSize : j12, (i14 & 8) != 0 ? textLabelViewStyle2.fontStyle : fontStyle2, (i14 & 16) != 0 ? textLabelViewStyle2.fontWeight : fontWeight2, (i14 & 32) != 0 ? textLabelViewStyle2.fontFamily : fontFamily2, (i14 & 64) != 0 ? textLabelViewStyle2.letterSpacing : j13, (i14 & 128) != 0 ? textLabelViewStyle2.textDecoration : textDecoration2, (i14 & 256) != 0 ? textLabelViewStyle2.textAlign : textAlign2, (i14 & 512) != 0 ? textLabelViewStyle2.lineHeight : j14, (i14 & 1024) != 0 ? textLabelViewStyle2.overflow : i11, (i14 & 2048) != 0 ? textLabelViewStyle2.softWrap : z11, (i14 & 4096) != 0 ? textLabelViewStyle2.maxLines : i12, (i14 & 8192) != 0 ? textLabelViewStyle2.onTextLayout : function1, (i14 & 16384) != 0 ? textLabelViewStyle2.style : textStyle, (i14 & 32768) != 0 ? textLabelViewStyle2.textMaxWidth : z12);
    }

    @NotNull
    public final Modifier component1() {
        return this.modifier;
    }

    /* renamed from: component10-XSAIIZE  reason: not valid java name */
    public final long m9301component10XSAIIZE() {
        return this.lineHeight;
    }

    /* renamed from: component11-gIe3tQ8  reason: not valid java name */
    public final int m9302component11gIe3tQ8() {
        return this.overflow;
    }

    public final boolean component12() {
        return this.softWrap;
    }

    public final int component13() {
        return this.maxLines;
    }

    @NotNull
    public final Function1<TextLayoutResult, Unit> component14() {
        return this.onTextLayout;
    }

    @Nullable
    public final TextStyle component15() {
        return this.style;
    }

    public final boolean component16() {
        return this.textMaxWidth;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    public final long m9303component20d7_KjU() {
        return this.color;
    }

    /* renamed from: component3-XSAIIZE  reason: not valid java name */
    public final long m9304component3XSAIIZE() {
        return this.fontSize;
    }

    @Nullable
    /* renamed from: component4-4Lr2A7w  reason: not valid java name */
    public final FontStyle m9305component44Lr2A7w() {
        return this.fontStyle;
    }

    @Nullable
    public final FontWeight component5() {
        return this.fontWeight;
    }

    @Nullable
    public final FontFamily component6() {
        return this.fontFamily;
    }

    /* renamed from: component7-XSAIIZE  reason: not valid java name */
    public final long m9306component7XSAIIZE() {
        return this.letterSpacing;
    }

    @Nullable
    public final TextDecoration component8() {
        return this.textDecoration;
    }

    @Nullable
    /* renamed from: component9-buA522U  reason: not valid java name */
    public final TextAlign m9307component9buA522U() {
        return this.textAlign;
    }

    @NotNull
    /* renamed from: copy-M3jlewk  reason: not valid java name */
    public final TextLabelViewStyle m9308copyM3jlewk(@NotNull Modifier modifier2, long j11, long j12, @Nullable FontStyle fontStyle2, @Nullable FontWeight fontWeight2, @Nullable FontFamily fontFamily2, long j13, @Nullable TextDecoration textDecoration2, @Nullable TextAlign textAlign2, long j14, int i11, boolean z11, int i12, @NotNull Function1<? super TextLayoutResult, Unit> function1, @Nullable TextStyle textStyle, boolean z12) {
        Modifier modifier3 = modifier2;
        Intrinsics.checkNotNullParameter(modifier3, "modifier");
        Intrinsics.checkNotNullParameter(function1, "onTextLayout");
        return new TextLabelViewStyle(modifier3, j11, j12, fontStyle2, fontWeight2, fontFamily2, j13, textDecoration2, textAlign2, j14, i11, z11, i12, function1, textStyle, z12, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextLabelViewStyle)) {
            return false;
        }
        TextLabelViewStyle textLabelViewStyle = (TextLabelViewStyle) obj;
        return Intrinsics.areEqual((Object) this.modifier, (Object) textLabelViewStyle.modifier) && Color.m2920equalsimpl0(this.color, textLabelViewStyle.color) && TextUnit.m5656equalsimpl0(this.fontSize, textLabelViewStyle.fontSize) && Intrinsics.areEqual((Object) this.fontStyle, (Object) textLabelViewStyle.fontStyle) && Intrinsics.areEqual((Object) this.fontWeight, (Object) textLabelViewStyle.fontWeight) && Intrinsics.areEqual((Object) this.fontFamily, (Object) textLabelViewStyle.fontFamily) && TextUnit.m5656equalsimpl0(this.letterSpacing, textLabelViewStyle.letterSpacing) && Intrinsics.areEqual((Object) this.textDecoration, (Object) textLabelViewStyle.textDecoration) && Intrinsics.areEqual((Object) this.textAlign, (Object) textLabelViewStyle.textAlign) && TextUnit.m5656equalsimpl0(this.lineHeight, textLabelViewStyle.lineHeight) && TextOverflow.m5395equalsimpl0(this.overflow, textLabelViewStyle.overflow) && this.softWrap == textLabelViewStyle.softWrap && this.maxLines == textLabelViewStyle.maxLines && Intrinsics.areEqual((Object) this.onTextLayout, (Object) textLabelViewStyle.onTextLayout) && Intrinsics.areEqual((Object) this.style, (Object) textLabelViewStyle.style) && this.textMaxWidth == textLabelViewStyle.textMaxWidth;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m9309getColor0d7_KjU() {
        return this.color;
    }

    @Nullable
    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    /* renamed from: getFontSize-XSAIIZE  reason: not valid java name */
    public final long m9310getFontSizeXSAIIZE() {
        return this.fontSize;
    }

    @Nullable
    /* renamed from: getFontStyle-4Lr2A7w  reason: not valid java name */
    public final FontStyle m9311getFontStyle4Lr2A7w() {
        return this.fontStyle;
    }

    @Nullable
    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* renamed from: getLetterSpacing-XSAIIZE  reason: not valid java name */
    public final long m9312getLetterSpacingXSAIIZE() {
        return this.letterSpacing;
    }

    /* renamed from: getLineHeight-XSAIIZE  reason: not valid java name */
    public final long m9313getLineHeightXSAIIZE() {
        return this.lineHeight;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    @NotNull
    public final Modifier getModifier() {
        return this.modifier;
    }

    @NotNull
    public final Function1<TextLayoutResult, Unit> getOnTextLayout() {
        return this.onTextLayout;
    }

    /* renamed from: getOverflow-gIe3tQ8  reason: not valid java name */
    public final int m9314getOverflowgIe3tQ8() {
        return this.overflow;
    }

    public final boolean getSoftWrap() {
        return this.softWrap;
    }

    @Nullable
    public final TextStyle getStyle() {
        return this.style;
    }

    @Nullable
    /* renamed from: getTextAlign-buA522U  reason: not valid java name */
    public final TextAlign m9315getTextAlignbuA522U() {
        return this.textAlign;
    }

    @Nullable
    public final TextDecoration getTextDecoration() {
        return this.textDecoration;
    }

    public final boolean getTextMaxWidth() {
        return this.textMaxWidth;
    }

    public int hashCode() {
        int hashCode = ((((this.modifier.hashCode() * 31) + Color.m2926hashCodeimpl(this.color)) * 31) + TextUnit.m5660hashCodeimpl(this.fontSize)) * 31;
        FontStyle fontStyle2 = this.fontStyle;
        int i11 = 0;
        int r02 = (hashCode + (fontStyle2 == null ? 0 : FontStyle.m5125hashCodeimpl(fontStyle2.m5127unboximpl()))) * 31;
        FontWeight fontWeight2 = this.fontWeight;
        int hashCode2 = (r02 + (fontWeight2 == null ? 0 : fontWeight2.hashCode())) * 31;
        FontFamily fontFamily2 = this.fontFamily;
        int hashCode3 = (((hashCode2 + (fontFamily2 == null ? 0 : fontFamily2.hashCode())) * 31) + TextUnit.m5660hashCodeimpl(this.letterSpacing)) * 31;
        TextDecoration textDecoration2 = this.textDecoration;
        int hashCode4 = (hashCode3 + (textDecoration2 == null ? 0 : textDecoration2.hashCode())) * 31;
        TextAlign textAlign2 = this.textAlign;
        int r03 = (((((hashCode4 + (textAlign2 == null ? 0 : TextAlign.m5363hashCodeimpl(textAlign2.m5365unboximpl()))) * 31) + TextUnit.m5660hashCodeimpl(this.lineHeight)) * 31) + TextOverflow.m5396hashCodeimpl(this.overflow)) * 31;
        boolean z11 = this.softWrap;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int hashCode5 = (((((r03 + (z11 ? 1 : 0)) * 31) + this.maxLines) * 31) + this.onTextLayout.hashCode()) * 31;
        TextStyle textStyle = this.style;
        if (textStyle != null) {
            i11 = textStyle.hashCode();
        }
        int i12 = (hashCode5 + i11) * 31;
        boolean z13 = this.textMaxWidth;
        if (!z13) {
            z12 = z13;
        }
        return i12 + (z12 ? 1 : 0);
    }

    /* renamed from: setColor-8_81llA  reason: not valid java name */
    public final void m9316setColor8_81llA(long j11) {
        this.color = j11;
    }

    public final void setModifier(@NotNull Modifier modifier2) {
        Intrinsics.checkNotNullParameter(modifier2, "<set-?>");
        this.modifier = modifier2;
    }

    public final void setTextMaxWidth(boolean z11) {
        this.textMaxWidth = z11;
    }

    @NotNull
    public String toString() {
        Modifier modifier2 = this.modifier;
        String r22 = Color.m2927toStringimpl(this.color);
        String r32 = TextUnit.m5666toStringimpl(this.fontSize);
        FontStyle fontStyle2 = this.fontStyle;
        FontWeight fontWeight2 = this.fontWeight;
        FontFamily fontFamily2 = this.fontFamily;
        String r72 = TextUnit.m5666toStringimpl(this.letterSpacing);
        TextDecoration textDecoration2 = this.textDecoration;
        TextAlign textAlign2 = this.textAlign;
        String r102 = TextUnit.m5666toStringimpl(this.lineHeight);
        String r11 = TextOverflow.m5397toStringimpl(this.overflow);
        boolean z11 = this.softWrap;
        int i11 = this.maxLines;
        Function1<TextLayoutResult, Unit> function1 = this.onTextLayout;
        TextStyle textStyle = this.style;
        boolean z12 = this.textMaxWidth;
        return "TextLabelViewStyle(modifier=" + modifier2 + ", color=" + r22 + ", fontSize=" + r32 + ", fontStyle=" + fontStyle2 + ", fontWeight=" + fontWeight2 + ", fontFamily=" + fontFamily2 + ", letterSpacing=" + r72 + ", textDecoration=" + textDecoration2 + ", textAlign=" + textAlign2 + ", lineHeight=" + r102 + ", overflow=" + r11 + ", softWrap=" + z11 + ", maxLines=" + i11 + ", onTextLayout=" + function1 + ", style=" + textStyle + ", textMaxWidth=" + z12 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextLabelViewStyle(androidx.compose.ui.Modifier r22, long r23, long r25, androidx.compose.ui.text.font.FontStyle r27, androidx.compose.ui.text.font.FontWeight r28, androidx.compose.ui.text.font.FontFamily r29, long r30, androidx.compose.ui.text.style.TextDecoration r32, androidx.compose.ui.text.style.TextAlign r33, long r34, int r36, boolean r37, int r38, kotlin.jvm.functions.Function1 r39, androidx.compose.ui.text.TextStyle r40, boolean r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r21 = this;
            r0 = r42
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x000b
        L_0x0009:
            r1 = r22
        L_0x000b:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0016
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r2 = r2.m2955getUnspecified0d7_KjU()
            goto L_0x0018
        L_0x0016:
            r2 = r23
        L_0x0018:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0023
            androidx.compose.ui.unit.TextUnit$Companion r4 = androidx.compose.ui.unit.TextUnit.Companion
            long r4 = r4.m5670getUnspecifiedXSAIIZE()
            goto L_0x0025
        L_0x0023:
            r4 = r25
        L_0x0025:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x002b
            r6 = 0
            goto L_0x002d
        L_0x002b:
            r6 = r27
        L_0x002d:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0033
            r8 = 0
            goto L_0x0035
        L_0x0033:
            r8 = r28
        L_0x0035:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003b
            r9 = 0
            goto L_0x003d
        L_0x003b:
            r9 = r29
        L_0x003d:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0048
            androidx.compose.ui.unit.TextUnit$Companion r10 = androidx.compose.ui.unit.TextUnit.Companion
            long r10 = r10.m5670getUnspecifiedXSAIIZE()
            goto L_0x004a
        L_0x0048:
            r10 = r30
        L_0x004a:
            r12 = r0 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0050
            r12 = 0
            goto L_0x0052
        L_0x0050:
            r12 = r32
        L_0x0052:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0058
            r13 = 0
            goto L_0x005a
        L_0x0058:
            r13 = r33
        L_0x005a:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x0065
            androidx.compose.ui.unit.TextUnit$Companion r14 = androidx.compose.ui.unit.TextUnit.Companion
            long r14 = r14.m5670getUnspecifiedXSAIIZE()
            goto L_0x0067
        L_0x0065:
            r14 = r34
        L_0x0067:
            r7 = r0 & 1024(0x400, float:1.435E-42)
            if (r7 == 0) goto L_0x0072
            androidx.compose.ui.text.style.TextOverflow$Companion r7 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r7 = r7.m5402getClipgIe3tQ8()
            goto L_0x0074
        L_0x0072:
            r7 = r36
        L_0x0074:
            r16 = r7
            r7 = r0 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x007c
            r7 = 1
            goto L_0x007e
        L_0x007c:
            r7 = r37
        L_0x007e:
            r17 = r7
            r7 = r0 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x0088
            r7 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x008a
        L_0x0088:
            r7 = r38
        L_0x008a:
            r18 = r7
            r7 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x0093
            com.checkout.frames.style.view.TextLabelViewStyle$1 r7 = com.checkout.frames.style.view.TextLabelViewStyle.AnonymousClass1.INSTANCE
            goto L_0x0095
        L_0x0093:
            r7 = r39
        L_0x0095:
            r19 = r7
            r7 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r7 == 0) goto L_0x009d
            r7 = 0
            goto L_0x009f
        L_0x009d:
            r7 = r40
        L_0x009f:
            r20 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r20
            if (r0 == 0) goto L_0x00a8
            r0 = 0
            goto L_0x00aa
        L_0x00a8:
            r0 = r41
        L_0x00aa:
            r20 = 0
            r43 = r20
            r22 = r21
            r23 = r1
            r24 = r2
            r26 = r4
            r28 = r6
            r29 = r8
            r30 = r9
            r31 = r10
            r33 = r12
            r34 = r13
            r35 = r14
            r37 = r16
            r38 = r17
            r39 = r18
            r40 = r19
            r41 = r7
            r42 = r0
            r22.<init>(r23, r24, r26, r28, r29, r30, r31, r33, r34, r35, r37, r38, r39, r40, r41, r42, r43)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.view.TextLabelViewStyle.<init>(androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
