package com.checkout.frames.model.font;

import androidx.annotation.FontRes;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/checkout/frames/model/font/Font;", "", "()V", "Cursive", "Custom", "Default", "Monospace", "SansSerif", "Serif", "Lcom/checkout/frames/model/font/Font$Cursive;", "Lcom/checkout/frames/model/font/Font$Custom;", "Lcom/checkout/frames/model/font/Font$Default;", "Lcom/checkout/frames/model/font/Font$Monospace;", "Lcom/checkout/frames/model/font/Font$SansSerif;", "Lcom/checkout/frames/model/font/Font$Serif;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class Font {
    public static final int $stable = 0;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/checkout/frames/model/font/Font$Cursive;", "Lcom/checkout/frames/model/font/Font;", "()V", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Cursive extends Font {
        public static final int $stable = 0;
        @NotNull
        public static final Cursive INSTANCE = new Cursive();

        private Cursive() {
            super((DefaultConstructorMarker) null);
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BY\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ`\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\f¨\u0006%"}, d2 = {"Lcom/checkout/frames/model/font/Font$Custom;", "Lcom/checkout/frames/model/font/Font;", "normalFont", "", "normalItalicFont", "lightFont", "mediumFont", "semiBold", "boldFont", "extraBoldFont", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBoldFont", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExtraBoldFont", "getLightFont", "getMediumFont", "getNormalFont", "()I", "getNormalItalicFont", "getSemiBold", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/checkout/frames/model/font/Font$Custom;", "equals", "", "other", "", "hashCode", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Custom extends Font {
        public static final int $stable = 0;
        @Nullable
        private final Integer boldFont;
        @Nullable
        private final Integer extraBoldFont;
        @Nullable
        private final Integer lightFont;
        @Nullable
        private final Integer mediumFont;
        private final int normalFont;
        @Nullable
        private final Integer normalItalicFont;
        @Nullable
        private final Integer semiBold;

        @JvmOverloads
        public Custom(@FontRes int i11) {
            this(i11, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 126, (DefaultConstructorMarker) null);
        }

        @JvmOverloads
        public Custom(@FontRes int i11, @FontRes @Nullable Integer num) {
            this(i11, num, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 124, (DefaultConstructorMarker) null);
        }

        @JvmOverloads
        public Custom(@FontRes int i11, @FontRes @Nullable Integer num, @FontRes @Nullable Integer num2) {
            this(i11, num, num2, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 120, (DefaultConstructorMarker) null);
        }

        @JvmOverloads
        public Custom(@FontRes int i11, @FontRes @Nullable Integer num, @FontRes @Nullable Integer num2, @FontRes @Nullable Integer num3) {
            this(i11, num, num2, num3, (Integer) null, (Integer) null, (Integer) null, 112, (DefaultConstructorMarker) null);
        }

        @JvmOverloads
        public Custom(@FontRes int i11, @FontRes @Nullable Integer num, @FontRes @Nullable Integer num2, @FontRes @Nullable Integer num3, @FontRes @Nullable Integer num4) {
            this(i11, num, num2, num3, num4, (Integer) null, (Integer) null, 96, (DefaultConstructorMarker) null);
        }

        @JvmOverloads
        public Custom(@FontRes int i11, @FontRes @Nullable Integer num, @FontRes @Nullable Integer num2, @FontRes @Nullable Integer num3, @FontRes @Nullable Integer num4, @FontRes @Nullable Integer num5) {
            this(i11, num, num2, num3, num4, num5, (Integer) null, 64, (DefaultConstructorMarker) null);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Custom(int r8, java.lang.Integer r9, java.lang.Integer r10, java.lang.Integer r11, java.lang.Integer r12, java.lang.Integer r13, java.lang.Integer r14, int r15, kotlin.jvm.internal.DefaultConstructorMarker r16) {
            /*
                r7 = this;
                r0 = r15 & 2
                r1 = 0
                if (r0 == 0) goto L_0x0007
                r0 = r1
                goto L_0x0008
            L_0x0007:
                r0 = r9
            L_0x0008:
                r2 = r15 & 4
                if (r2 == 0) goto L_0x000e
                r2 = r1
                goto L_0x000f
            L_0x000e:
                r2 = r10
            L_0x000f:
                r3 = r15 & 8
                if (r3 == 0) goto L_0x0015
                r3 = r1
                goto L_0x0016
            L_0x0015:
                r3 = r11
            L_0x0016:
                r4 = r15 & 16
                if (r4 == 0) goto L_0x001c
                r4 = r1
                goto L_0x001d
            L_0x001c:
                r4 = r12
            L_0x001d:
                r5 = r15 & 32
                if (r5 == 0) goto L_0x0023
                r5 = r1
                goto L_0x0024
            L_0x0023:
                r5 = r13
            L_0x0024:
                r6 = r15 & 64
                if (r6 == 0) goto L_0x0029
                goto L_0x002a
            L_0x0029:
                r1 = r14
            L_0x002a:
                r9 = r7
                r10 = r8
                r11 = r0
                r12 = r2
                r13 = r3
                r14 = r4
                r15 = r5
                r16 = r1
                r9.<init>(r10, r11, r12, r13, r14, r15, r16)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.model.font.Font.Custom.<init>(int, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public static /* synthetic */ Custom copy$default(Custom custom, int i11, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = custom.normalFont;
            }
            if ((i12 & 2) != 0) {
                num = custom.normalItalicFont;
            }
            Integer num7 = num;
            if ((i12 & 4) != 0) {
                num2 = custom.lightFont;
            }
            Integer num8 = num2;
            if ((i12 & 8) != 0) {
                num3 = custom.mediumFont;
            }
            Integer num9 = num3;
            if ((i12 & 16) != 0) {
                num4 = custom.semiBold;
            }
            Integer num10 = num4;
            if ((i12 & 32) != 0) {
                num5 = custom.boldFont;
            }
            Integer num11 = num5;
            if ((i12 & 64) != 0) {
                num6 = custom.extraBoldFont;
            }
            return custom.copy(i11, num7, num8, num9, num10, num11, num6);
        }

        public final int component1() {
            return this.normalFont;
        }

        @Nullable
        public final Integer component2() {
            return this.normalItalicFont;
        }

        @Nullable
        public final Integer component3() {
            return this.lightFont;
        }

        @Nullable
        public final Integer component4() {
            return this.mediumFont;
        }

        @Nullable
        public final Integer component5() {
            return this.semiBold;
        }

        @Nullable
        public final Integer component6() {
            return this.boldFont;
        }

        @Nullable
        public final Integer component7() {
            return this.extraBoldFont;
        }

        @NotNull
        public final Custom copy(@FontRes int i11, @FontRes @Nullable Integer num, @FontRes @Nullable Integer num2, @FontRes @Nullable Integer num3, @FontRes @Nullable Integer num4, @FontRes @Nullable Integer num5, @FontRes @Nullable Integer num6) {
            return new Custom(i11, num, num2, num3, num4, num5, num6);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Custom)) {
                return false;
            }
            Custom custom = (Custom) obj;
            return this.normalFont == custom.normalFont && Intrinsics.areEqual((Object) this.normalItalicFont, (Object) custom.normalItalicFont) && Intrinsics.areEqual((Object) this.lightFont, (Object) custom.lightFont) && Intrinsics.areEqual((Object) this.mediumFont, (Object) custom.mediumFont) && Intrinsics.areEqual((Object) this.semiBold, (Object) custom.semiBold) && Intrinsics.areEqual((Object) this.boldFont, (Object) custom.boldFont) && Intrinsics.areEqual((Object) this.extraBoldFont, (Object) custom.extraBoldFont);
        }

        @Nullable
        public final Integer getBoldFont() {
            return this.boldFont;
        }

        @Nullable
        public final Integer getExtraBoldFont() {
            return this.extraBoldFont;
        }

        @Nullable
        public final Integer getLightFont() {
            return this.lightFont;
        }

        @Nullable
        public final Integer getMediumFont() {
            return this.mediumFont;
        }

        public final int getNormalFont() {
            return this.normalFont;
        }

        @Nullable
        public final Integer getNormalItalicFont() {
            return this.normalItalicFont;
        }

        @Nullable
        public final Integer getSemiBold() {
            return this.semiBold;
        }

        public int hashCode() {
            int i11 = this.normalFont * 31;
            Integer num = this.normalItalicFont;
            int i12 = 0;
            int hashCode = (i11 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.lightFont;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.mediumFont;
            int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.semiBold;
            int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.boldFont;
            int hashCode5 = (hashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Integer num6 = this.extraBoldFont;
            if (num6 != null) {
                i12 = num6.hashCode();
            }
            return hashCode5 + i12;
        }

        @NotNull
        public String toString() {
            int i11 = this.normalFont;
            Integer num = this.normalItalicFont;
            Integer num2 = this.lightFont;
            Integer num3 = this.mediumFont;
            Integer num4 = this.semiBold;
            Integer num5 = this.boldFont;
            Integer num6 = this.extraBoldFont;
            return "Custom(normalFont=" + i11 + ", normalItalicFont=" + num + ", lightFont=" + num2 + ", mediumFont=" + num3 + ", semiBold=" + num4 + ", boldFont=" + num5 + ", extraBoldFont=" + num6 + ")";
        }

        @JvmOverloads
        public Custom(@FontRes int i11, @FontRes @Nullable Integer num, @FontRes @Nullable Integer num2, @FontRes @Nullable Integer num3, @FontRes @Nullable Integer num4, @FontRes @Nullable Integer num5, @FontRes @Nullable Integer num6) {
            super((DefaultConstructorMarker) null);
            this.normalFont = i11;
            this.normalItalicFont = num;
            this.lightFont = num2;
            this.mediumFont = num3;
            this.semiBold = num4;
            this.boldFont = num5;
            this.extraBoldFont = num6;
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/checkout/frames/model/font/Font$Default;", "Lcom/checkout/frames/model/font/Font;", "()V", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Default extends Font {
        public static final int $stable = 0;
        @NotNull
        public static final Default INSTANCE = new Default();

        private Default() {
            super((DefaultConstructorMarker) null);
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/checkout/frames/model/font/Font$Monospace;", "Lcom/checkout/frames/model/font/Font;", "()V", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Monospace extends Font {
        public static final int $stable = 0;
        @NotNull
        public static final Monospace INSTANCE = new Monospace();

        private Monospace() {
            super((DefaultConstructorMarker) null);
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/checkout/frames/model/font/Font$SansSerif;", "Lcom/checkout/frames/model/font/Font;", "()V", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SansSerif extends Font {
        public static final int $stable = 0;
        @NotNull
        public static final SansSerif INSTANCE = new SansSerif();

        private SansSerif() {
            super((DefaultConstructorMarker) null);
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/checkout/frames/model/font/Font$Serif;", "Lcom/checkout/frames/model/font/Font;", "()V", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Serif extends Font {
        public static final int $stable = 0;
        @NotNull
        public static final Serif INSTANCE = new Serif();

        private Serif() {
            super((DefaultConstructorMarker) null);
        }
    }

    private Font() {
    }

    public /* synthetic */ Font(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
