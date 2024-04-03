package com.checkout.frames.style.component.base;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.checkout.frames.model.TextAlign;
import com.checkout.frames.model.font.Font;
import com.checkout.frames.model.font.FontStyle;
import com.checkout.frames.model.font.FontWeight;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Be\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJl\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u000205HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00066"}, d2 = {"Lcom/checkout/frames/style/component/base/TextStyle;", "", "size", "", "color", "", "textAlign", "Lcom/checkout/frames/model/TextAlign;", "font", "Lcom/checkout/frames/model/font/Font;", "fontStyle", "Lcom/checkout/frames/model/font/FontStyle;", "fontWeight", "Lcom/checkout/frames/model/font/FontWeight;", "maxLines", "maxLength", "lineHeight", "(IJLcom/checkout/frames/model/TextAlign;Lcom/checkout/frames/model/font/Font;Lcom/checkout/frames/model/font/FontStyle;Lcom/checkout/frames/model/font/FontWeight;ILjava/lang/Integer;Ljava/lang/Integer;)V", "getColor", "()J", "getFont", "()Lcom/checkout/frames/model/font/Font;", "getFontStyle", "()Lcom/checkout/frames/model/font/FontStyle;", "getFontWeight", "()Lcom/checkout/frames/model/font/FontWeight;", "getLineHeight", "()Ljava/lang/Integer;", "setLineHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMaxLength", "getMaxLines", "()I", "getSize", "getTextAlign", "()Lcom/checkout/frames/model/TextAlign;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IJLcom/checkout/frames/model/TextAlign;Lcom/checkout/frames/model/font/Font;Lcom/checkout/frames/model/font/FontStyle;Lcom/checkout/frames/model/font/FontWeight;ILjava/lang/Integer;Ljava/lang/Integer;)Lcom/checkout/frames/style/component/base/TextStyle;", "equals", "", "other", "hashCode", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextStyle {
    public static final int $stable = 8;
    private final long color;
    @NotNull
    private final Font font;
    @NotNull
    private final FontStyle fontStyle;
    @NotNull
    private final FontWeight fontWeight;
    @Nullable
    private Integer lineHeight;
    @Nullable
    private final Integer maxLength;
    private final int maxLines;
    private final int size;
    @NotNull
    private final TextAlign textAlign;

    @JvmOverloads
    public TextStyle() {
        this(0, 0, (TextAlign) null, (Font) null, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 511, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public TextStyle(int i11) {
        this(i11, 0, (TextAlign) null, (Font) null, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, TypedValues.PositionType.TYPE_POSITION_TYPE, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public TextStyle(int i11, long j11) {
        this(i11, j11, (TextAlign) null, (Font) null, (FontStyle) null, (FontWeight) null, 0, (Integer) null, (Integer) null, 508, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextStyle(int r15, long r16, @org.jetbrains.annotations.NotNull com.checkout.frames.model.TextAlign r18) {
        /*
            r14 = this;
            java.lang.String r0 = "textAlign"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 504(0x1f8, float:7.06E-43)
            r13 = 0
            r1 = r14
            r2 = r15
            r3 = r16
            r1.<init>(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.TextStyle.<init>(int, long, com.checkout.frames.model.TextAlign):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextStyle(int r15, long r16, @org.jetbrains.annotations.NotNull com.checkout.frames.model.TextAlign r18, @org.jetbrains.annotations.NotNull com.checkout.frames.model.font.Font r19) {
        /*
            r14 = this;
            java.lang.String r0 = "textAlign"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "font"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 496(0x1f0, float:6.95E-43)
            r13 = 0
            r1 = r14
            r2 = r15
            r3 = r16
            r1.<init>(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.TextStyle.<init>(int, long, com.checkout.frames.model.TextAlign, com.checkout.frames.model.font.Font):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextStyle(int r15, long r16, @org.jetbrains.annotations.NotNull com.checkout.frames.model.TextAlign r18, @org.jetbrains.annotations.NotNull com.checkout.frames.model.font.Font r19, @org.jetbrains.annotations.NotNull com.checkout.frames.model.font.FontStyle r20) {
        /*
            r14 = this;
            java.lang.String r0 = "textAlign"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "font"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "fontStyle"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 480(0x1e0, float:6.73E-43)
            r13 = 0
            r1 = r14
            r2 = r15
            r3 = r16
            r1.<init>(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.TextStyle.<init>(int, long, com.checkout.frames.model.TextAlign, com.checkout.frames.model.font.Font, com.checkout.frames.model.font.FontStyle):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextStyle(int r15, long r16, @org.jetbrains.annotations.NotNull com.checkout.frames.model.TextAlign r18, @org.jetbrains.annotations.NotNull com.checkout.frames.model.font.Font r19, @org.jetbrains.annotations.NotNull com.checkout.frames.model.font.FontStyle r20, @org.jetbrains.annotations.NotNull com.checkout.frames.model.font.FontWeight r21) {
        /*
            r14 = this;
            java.lang.String r0 = "textAlign"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "font"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "fontStyle"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "fontWeight"
            r8 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 448(0x1c0, float:6.28E-43)
            r13 = 0
            r1 = r14
            r2 = r15
            r3 = r16
            r1.<init>(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.TextStyle.<init>(int, long, com.checkout.frames.model.TextAlign, com.checkout.frames.model.font.Font, com.checkout.frames.model.font.FontStyle, com.checkout.frames.model.font.FontWeight):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextStyle(int r15, long r16, @org.jetbrains.annotations.NotNull com.checkout.frames.model.TextAlign r18, @org.jetbrains.annotations.NotNull com.checkout.frames.model.font.Font r19, @org.jetbrains.annotations.NotNull com.checkout.frames.model.font.FontStyle r20, @org.jetbrains.annotations.NotNull com.checkout.frames.model.font.FontWeight r21, int r22) {
        /*
            r14 = this;
            java.lang.String r0 = "textAlign"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "font"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "fontStyle"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "fontWeight"
            r8 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r10 = 0
            r11 = 0
            r12 = 384(0x180, float:5.38E-43)
            r13 = 0
            r1 = r14
            r2 = r15
            r3 = r16
            r9 = r22
            r1.<init>(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.TextStyle.<init>(int, long, com.checkout.frames.model.TextAlign, com.checkout.frames.model.font.Font, com.checkout.frames.model.font.FontStyle, com.checkout.frames.model.font.FontWeight, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextStyle(int r15, long r16, @org.jetbrains.annotations.NotNull com.checkout.frames.model.TextAlign r18, @org.jetbrains.annotations.NotNull com.checkout.frames.model.font.Font r19, @org.jetbrains.annotations.NotNull com.checkout.frames.model.font.FontStyle r20, @org.jetbrains.annotations.NotNull com.checkout.frames.model.font.FontWeight r21, int r22, @org.jetbrains.annotations.Nullable java.lang.Integer r23) {
        /*
            r14 = this;
            java.lang.String r0 = "textAlign"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "font"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "fontStyle"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "fontWeight"
            r8 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r11 = 0
            r12 = 256(0x100, float:3.59E-43)
            r13 = 0
            r1 = r14
            r2 = r15
            r3 = r16
            r9 = r22
            r10 = r23
            r1.<init>(r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.TextStyle.<init>(int, long, com.checkout.frames.model.TextAlign, com.checkout.frames.model.font.Font, com.checkout.frames.model.font.FontStyle, com.checkout.frames.model.font.FontWeight, int, java.lang.Integer):void");
    }

    @JvmOverloads
    public TextStyle(int i11, long j11, @NotNull TextAlign textAlign2, @NotNull Font font2, @NotNull FontStyle fontStyle2, @NotNull FontWeight fontWeight2, int i12, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkNotNullParameter(textAlign2, TtmlNode.ATTR_TTS_TEXT_ALIGN);
        Intrinsics.checkNotNullParameter(font2, "font");
        Intrinsics.checkNotNullParameter(fontStyle2, TtmlNode.ATTR_TTS_FONT_STYLE);
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        this.size = i11;
        this.color = j11;
        this.textAlign = textAlign2;
        this.font = font2;
        this.fontStyle = fontStyle2;
        this.fontWeight = fontWeight2;
        this.maxLines = i12;
        this.maxLength = num;
        this.lineHeight = num2;
    }

    public static /* synthetic */ TextStyle copy$default(TextStyle textStyle, int i11, long j11, TextAlign textAlign2, Font font2, FontStyle fontStyle2, FontWeight fontWeight2, int i12, Integer num, Integer num2, int i13, Object obj) {
        TextStyle textStyle2 = textStyle;
        int i14 = i13;
        return textStyle.copy((i14 & 1) != 0 ? textStyle2.size : i11, (i14 & 2) != 0 ? textStyle2.color : j11, (i14 & 4) != 0 ? textStyle2.textAlign : textAlign2, (i14 & 8) != 0 ? textStyle2.font : font2, (i14 & 16) != 0 ? textStyle2.fontStyle : fontStyle2, (i14 & 32) != 0 ? textStyle2.fontWeight : fontWeight2, (i14 & 64) != 0 ? textStyle2.maxLines : i12, (i14 & 128) != 0 ? textStyle2.maxLength : num, (i14 & 256) != 0 ? textStyle2.lineHeight : num2);
    }

    public final int component1() {
        return this.size;
    }

    public final long component2() {
        return this.color;
    }

    @NotNull
    public final TextAlign component3() {
        return this.textAlign;
    }

    @NotNull
    public final Font component4() {
        return this.font;
    }

    @NotNull
    public final FontStyle component5() {
        return this.fontStyle;
    }

    @NotNull
    public final FontWeight component6() {
        return this.fontWeight;
    }

    public final int component7() {
        return this.maxLines;
    }

    @Nullable
    public final Integer component8() {
        return this.maxLength;
    }

    @Nullable
    public final Integer component9() {
        return this.lineHeight;
    }

    @NotNull
    public final TextStyle copy(int i11, long j11, @NotNull TextAlign textAlign2, @NotNull Font font2, @NotNull FontStyle fontStyle2, @NotNull FontWeight fontWeight2, int i12, @Nullable Integer num, @Nullable Integer num2) {
        TextAlign textAlign3 = textAlign2;
        Intrinsics.checkNotNullParameter(textAlign3, TtmlNode.ATTR_TTS_TEXT_ALIGN);
        Font font3 = font2;
        Intrinsics.checkNotNullParameter(font3, "font");
        FontStyle fontStyle3 = fontStyle2;
        Intrinsics.checkNotNullParameter(fontStyle3, TtmlNode.ATTR_TTS_FONT_STYLE);
        FontWeight fontWeight3 = fontWeight2;
        Intrinsics.checkNotNullParameter(fontWeight3, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        return new TextStyle(i11, j11, textAlign3, font3, fontStyle3, fontWeight3, i12, num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) obj;
        return this.size == textStyle.size && this.color == textStyle.color && this.textAlign == textStyle.textAlign && Intrinsics.areEqual((Object) this.font, (Object) textStyle.font) && this.fontStyle == textStyle.fontStyle && this.fontWeight == textStyle.fontWeight && this.maxLines == textStyle.maxLines && Intrinsics.areEqual((Object) this.maxLength, (Object) textStyle.maxLength) && Intrinsics.areEqual((Object) this.lineHeight, (Object) textStyle.lineHeight);
    }

    public final long getColor() {
        return this.color;
    }

    @NotNull
    public final Font getFont() {
        return this.font;
    }

    @NotNull
    public final FontStyle getFontStyle() {
        return this.fontStyle;
    }

    @NotNull
    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    @Nullable
    public final Integer getLineHeight() {
        return this.lineHeight;
    }

    @Nullable
    public final Integer getMaxLength() {
        return this.maxLength;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final int getSize() {
        return this.size;
    }

    @NotNull
    public final TextAlign getTextAlign() {
        return this.textAlign;
    }

    public int hashCode() {
        int a11 = ((((((((((((this.size * 31) + a.a(this.color)) * 31) + this.textAlign.hashCode()) * 31) + this.font.hashCode()) * 31) + this.fontStyle.hashCode()) * 31) + this.fontWeight.hashCode()) * 31) + this.maxLines) * 31;
        Integer num = this.maxLength;
        int i11 = 0;
        int hashCode = (a11 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.lineHeight;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode + i11;
    }

    public final void setLineHeight(@Nullable Integer num) {
        this.lineHeight = num;
    }

    @NotNull
    public String toString() {
        int i11 = this.size;
        long j11 = this.color;
        TextAlign textAlign2 = this.textAlign;
        Font font2 = this.font;
        FontStyle fontStyle2 = this.fontStyle;
        FontWeight fontWeight2 = this.fontWeight;
        int i12 = this.maxLines;
        Integer num = this.maxLength;
        Integer num2 = this.lineHeight;
        return "TextStyle(size=" + i11 + ", color=" + j11 + ", textAlign=" + textAlign2 + ", font=" + font2 + ", fontStyle=" + fontStyle2 + ", fontWeight=" + fontWeight2 + ", maxLines=" + i12 + ", maxLength=" + num + ", lineHeight=" + num2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(int r12, long r13, com.checkout.frames.model.TextAlign r15, com.checkout.frames.model.font.Font r16, com.checkout.frames.model.font.FontStyle r17, com.checkout.frames.model.font.FontWeight r18, int r19, java.lang.Integer r20, java.lang.Integer r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r1 = 14
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0014
            r2 = 4278190080(0xff000000, double:2.113706745E-314)
            goto L_0x0015
        L_0x0014:
            r2 = r13
        L_0x0015:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001c
            com.checkout.frames.model.TextAlign r4 = com.checkout.frames.model.TextAlign.Start
            goto L_0x001d
        L_0x001c:
            r4 = r15
        L_0x001d:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0024
            com.checkout.frames.model.font.Font$Default r5 = com.checkout.frames.model.font.Font.Default.INSTANCE
            goto L_0x0026
        L_0x0024:
            r5 = r16
        L_0x0026:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002d
            com.checkout.frames.model.font.FontStyle r6 = com.checkout.frames.model.font.FontStyle.Normal
            goto L_0x002f
        L_0x002d:
            r6 = r17
        L_0x002f:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0036
            com.checkout.frames.model.font.FontWeight r7 = com.checkout.frames.model.font.FontWeight.Normal
            goto L_0x0038
        L_0x0036:
            r7 = r18
        L_0x0038:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0040
            r8 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0042
        L_0x0040:
            r8 = r19
        L_0x0042:
            r9 = r0 & 128(0x80, float:1.794E-43)
            r10 = 0
            if (r9 == 0) goto L_0x0049
            r9 = r10
            goto L_0x004b
        L_0x0049:
            r9 = r20
        L_0x004b:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r10 = r21
        L_0x0052:
            r12 = r11
            r13 = r1
            r14 = r2
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r9
            r22 = r10
            r12.<init>(r13, r14, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.TextStyle.<init>(int, long, com.checkout.frames.model.TextAlign, com.checkout.frames.model.font.Font, com.checkout.frames.model.font.FontStyle, com.checkout.frames.model.font.FontWeight, int, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
