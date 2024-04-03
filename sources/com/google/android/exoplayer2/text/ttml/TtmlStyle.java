package com.google.android.exoplayer2.text.ttml;

import android.text.Layout;
import androidx.annotation.Nullable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

final class TtmlStyle {
    public static final int FONT_SIZE_UNIT_EM = 2;
    public static final int FONT_SIZE_UNIT_PERCENT = 3;
    public static final int FONT_SIZE_UNIT_PIXEL = 1;
    private static final int OFF = 0;
    private static final int ON = 1;
    public static final int RUBY_TYPE_BASE = 2;
    public static final int RUBY_TYPE_CONTAINER = 1;
    public static final int RUBY_TYPE_DELIMITER = 4;
    public static final int RUBY_TYPE_TEXT = 3;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_BOLD_ITALIC = 3;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int UNSPECIFIED = -1;
    public static final float UNSPECIFIED_SHEAR = Float.MAX_VALUE;
    private int backgroundColor;
    private int bold = -1;
    private int fontColor;
    @Nullable
    private String fontFamily;
    private float fontSize;
    private int fontSizeUnit = -1;
    private boolean hasBackgroundColor;
    private boolean hasFontColor;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private String f35054id;
    private int italic = -1;
    private int linethrough = -1;
    @Nullable
    private Layout.Alignment multiRowAlign;
    private int rubyPosition = -1;
    private int rubyType = -1;
    private float shearPercentage = Float.MAX_VALUE;
    @Nullable
    private Layout.Alignment textAlign;
    private int textCombine = -1;
    @Nullable
    private TextEmphasis textEmphasis;
    private int underline = -1;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RubyType {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    @CanIgnoreReturnValue
    public TtmlStyle chain(@Nullable TtmlStyle ttmlStyle) {
        return inherit(ttmlStyle, true);
    }

    public int getBackgroundColor() {
        if (this.hasBackgroundColor) {
            return this.backgroundColor;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int getFontColor() {
        if (this.hasFontColor) {
            return this.fontColor;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    @Nullable
    public String getFontFamily() {
        return this.fontFamily;
    }

    public float getFontSize() {
        return this.fontSize;
    }

    public int getFontSizeUnit() {
        return this.fontSizeUnit;
    }

    @Nullable
    public String getId() {
        return this.f35054id;
    }

    @Nullable
    public Layout.Alignment getMultiRowAlign() {
        return this.multiRowAlign;
    }

    public int getRubyPosition() {
        return this.rubyPosition;
    }

    public int getRubyType() {
        return this.rubyType;
    }

    public float getShearPercentage() {
        return this.shearPercentage;
    }

    public int getStyle() {
        int i11;
        int i12 = this.bold;
        if (i12 == -1 && this.italic == -1) {
            return -1;
        }
        int i13 = 0;
        if (i12 == 1) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        if (this.italic == 1) {
            i13 = 2;
        }
        return i11 | i13;
    }

    @Nullable
    public Layout.Alignment getTextAlign() {
        return this.textAlign;
    }

    public boolean getTextCombine() {
        return this.textCombine == 1;
    }

    @Nullable
    public TextEmphasis getTextEmphasis() {
        return this.textEmphasis;
    }

    public boolean hasBackgroundColor() {
        return this.hasBackgroundColor;
    }

    public boolean hasFontColor() {
        return this.hasFontColor;
    }

    @CanIgnoreReturnValue
    public TtmlStyle inherit(@Nullable TtmlStyle ttmlStyle) {
        return inherit(ttmlStyle, false);
    }

    public boolean isLinethrough() {
        return this.linethrough == 1;
    }

    public boolean isUnderline() {
        return this.underline == 1;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setBackgroundColor(int i11) {
        this.backgroundColor = i11;
        this.hasBackgroundColor = true;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setBold(boolean z11) {
        this.bold = z11 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setFontColor(int i11) {
        this.fontColor = i11;
        this.hasFontColor = true;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setFontFamily(@Nullable String str) {
        this.fontFamily = str;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setFontSize(float f11) {
        this.fontSize = f11;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setFontSizeUnit(int i11) {
        this.fontSizeUnit = i11;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setId(@Nullable String str) {
        this.f35054id = str;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setItalic(boolean z11) {
        this.italic = z11 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setLinethrough(boolean z11) {
        this.linethrough = z11 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setMultiRowAlign(@Nullable Layout.Alignment alignment) {
        this.multiRowAlign = alignment;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setRubyPosition(int i11) {
        this.rubyPosition = i11;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setRubyType(int i11) {
        this.rubyType = i11;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setShearPercentage(float f11) {
        this.shearPercentage = f11;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setTextAlign(@Nullable Layout.Alignment alignment) {
        this.textAlign = alignment;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setTextCombine(boolean z11) {
        this.textCombine = z11 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setTextEmphasis(@Nullable TextEmphasis textEmphasis2) {
        this.textEmphasis = textEmphasis2;
        return this;
    }

    @CanIgnoreReturnValue
    public TtmlStyle setUnderline(boolean z11) {
        this.underline = z11 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    private TtmlStyle inherit(@Nullable TtmlStyle ttmlStyle, boolean z11) {
        int i11;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (ttmlStyle != null) {
            if (!this.hasFontColor && ttmlStyle.hasFontColor) {
                setFontColor(ttmlStyle.fontColor);
            }
            if (this.bold == -1) {
                this.bold = ttmlStyle.bold;
            }
            if (this.italic == -1) {
                this.italic = ttmlStyle.italic;
            }
            if (this.fontFamily == null && (str = ttmlStyle.fontFamily) != null) {
                this.fontFamily = str;
            }
            if (this.linethrough == -1) {
                this.linethrough = ttmlStyle.linethrough;
            }
            if (this.underline == -1) {
                this.underline = ttmlStyle.underline;
            }
            if (this.rubyPosition == -1) {
                this.rubyPosition = ttmlStyle.rubyPosition;
            }
            if (this.textAlign == null && (alignment2 = ttmlStyle.textAlign) != null) {
                this.textAlign = alignment2;
            }
            if (this.multiRowAlign == null && (alignment = ttmlStyle.multiRowAlign) != null) {
                this.multiRowAlign = alignment;
            }
            if (this.textCombine == -1) {
                this.textCombine = ttmlStyle.textCombine;
            }
            if (this.fontSizeUnit == -1) {
                this.fontSizeUnit = ttmlStyle.fontSizeUnit;
                this.fontSize = ttmlStyle.fontSize;
            }
            if (this.textEmphasis == null) {
                this.textEmphasis = ttmlStyle.textEmphasis;
            }
            if (this.shearPercentage == Float.MAX_VALUE) {
                this.shearPercentage = ttmlStyle.shearPercentage;
            }
            if (z11 && !this.hasBackgroundColor && ttmlStyle.hasBackgroundColor) {
                setBackgroundColor(ttmlStyle.backgroundColor);
            }
            if (z11 && this.rubyType == -1 && (i11 = ttmlStyle.rubyType) != -1) {
                this.rubyType = i11;
            }
        }
        return this;
    }
}
