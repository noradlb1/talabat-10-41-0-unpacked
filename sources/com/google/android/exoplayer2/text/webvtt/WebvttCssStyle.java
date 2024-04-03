package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class WebvttCssStyle {
    public static final int FONT_SIZE_UNIT_EM = 2;
    public static final int FONT_SIZE_UNIT_PERCENT = 3;
    public static final int FONT_SIZE_UNIT_PIXEL = 1;
    private static final int OFF = 0;
    private static final int ON = 1;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_BOLD_ITALIC = 3;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_NORMAL = 0;
    public static final int UNSPECIFIED = -1;
    private int backgroundColor;
    private int bold = -1;
    private boolean combineUpright = false;
    @ColorInt
    private int fontColor;
    @Nullable
    private String fontFamily = null;
    private float fontSize;
    private int fontSizeUnit = -1;
    private boolean hasBackgroundColor = false;
    private boolean hasFontColor = false;
    private int italic = -1;
    private int linethrough = -1;
    private int rubyPosition = -1;
    private Set<String> targetClasses = Collections.emptySet();
    private String targetId = "";
    private String targetTag = "";
    private String targetVoice = "";
    private int underline = -1;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSizeUnit {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface StyleFlags {
    }

    private static int updateScoreForMatch(int i11, String str, @Nullable String str2, int i12) {
        if (str.isEmpty() || i11 == -1) {
            return i11;
        }
        if (str.equals(str2)) {
            return i11 + i12;
        }
        return -1;
    }

    public int getBackgroundColor() {
        if (this.hasBackgroundColor) {
            return this.backgroundColor;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean getCombineUpright() {
        return this.combineUpright;
    }

    public int getFontColor() {
        if (this.hasFontColor) {
            return this.fontColor;
        }
        throw new IllegalStateException("Font color not defined");
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

    public int getRubyPosition() {
        return this.rubyPosition;
    }

    public int getSpecificityScore(@Nullable String str, @Nullable String str2, Set<String> set, @Nullable String str3) {
        if (this.targetId.isEmpty() && this.targetTag.isEmpty() && this.targetClasses.isEmpty() && this.targetVoice.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int updateScoreForMatch = updateScoreForMatch(updateScoreForMatch(updateScoreForMatch(0, this.targetId, str, 1073741824), this.targetTag, str2, 2), this.targetVoice, str3, 4);
        if (updateScoreForMatch == -1 || !set.containsAll(this.targetClasses)) {
            return 0;
        }
        return updateScoreForMatch + (this.targetClasses.size() * 4);
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

    public boolean hasBackgroundColor() {
        return this.hasBackgroundColor;
    }

    public boolean hasFontColor() {
        return this.hasFontColor;
    }

    public boolean isLinethrough() {
        return this.linethrough == 1;
    }

    public boolean isUnderline() {
        return this.underline == 1;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle setBackgroundColor(int i11) {
        this.backgroundColor = i11;
        this.hasBackgroundColor = true;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle setBold(boolean z11) {
        this.bold = z11 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle setCombineUpright(boolean z11) {
        this.combineUpright = z11;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle setFontColor(int i11) {
        this.fontColor = i11;
        this.hasFontColor = true;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle setFontFamily(@Nullable String str) {
        this.fontFamily = str == null ? null : Ascii.toLowerCase(str);
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle setFontSize(float f11) {
        this.fontSize = f11;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle setFontSizeUnit(int i11) {
        this.fontSizeUnit = i11;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle setItalic(boolean z11) {
        this.italic = z11 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle setLinethrough(boolean z11) {
        this.linethrough = z11 ? 1 : 0;
        return this;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle setRubyPosition(int i11) {
        this.rubyPosition = i11;
        return this;
    }

    public void setTargetClasses(String[] strArr) {
        this.targetClasses = new HashSet(Arrays.asList(strArr));
    }

    public void setTargetId(String str) {
        this.targetId = str;
    }

    public void setTargetTagName(String str) {
        this.targetTag = str;
    }

    public void setTargetVoice(String str) {
        this.targetVoice = str;
    }

    @CanIgnoreReturnValue
    public WebvttCssStyle setUnderline(boolean z11) {
        this.underline = z11 ? 1 : 0;
        return this;
    }
}
