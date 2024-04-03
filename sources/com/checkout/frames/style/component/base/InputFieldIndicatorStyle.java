package com.checkout.frames.style.component.base;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Shape;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;", "", "()V", "Border", "Underline", "Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle$Border;", "Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle$Underline;", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class InputFieldIndicatorStyle {
    public static final int $stable = 0;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BC\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006!"}, d2 = {"Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle$Underline;", "Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;", "focusedUnderlineThickness", "", "unfocusedUnderlineThickness", "focusedUnderlineColor", "", "unfocusedUnderlineColor", "disabledUnderlineColor", "errorUnderlineColor", "(IIJJJJ)V", "getDisabledUnderlineColor", "()J", "getErrorUnderlineColor", "getFocusedUnderlineColor", "getFocusedUnderlineThickness", "()I", "getUnfocusedUnderlineColor", "getUnfocusedUnderlineThickness", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Underline extends InputFieldIndicatorStyle {
        public static final int $stable = 0;
        private final long disabledUnderlineColor;
        private final long errorUnderlineColor;
        private final long focusedUnderlineColor;
        private final int focusedUnderlineThickness;
        private final long unfocusedUnderlineColor;
        private final int unfocusedUnderlineThickness;

        @JvmOverloads
        public Underline() {
            this(0, 0, 0, 0, 0, 0, 63, (DefaultConstructorMarker) null);
        }

        @JvmOverloads
        public Underline(int i11) {
            this(i11, 0, 0, 0, 0, 0, 62, (DefaultConstructorMarker) null);
        }

        @JvmOverloads
        public Underline(int i11, int i12) {
            this(i11, i12, 0, 0, 0, 0, 60, (DefaultConstructorMarker) null);
        }

        @JvmOverloads
        public Underline(int i11, int i12, long j11) {
            this(i11, i12, j11, 0, 0, 0, 56, (DefaultConstructorMarker) null);
        }

        @JvmOverloads
        public Underline(int i11, int i12, long j11, long j12) {
            this(i11, i12, j11, j12, 0, 0, 48, (DefaultConstructorMarker) null);
        }

        @JvmOverloads
        public Underline(int i11, int i12, long j11, long j12, long j13) {
            this(i11, i12, j11, j12, j13, 0, 32, (DefaultConstructorMarker) null);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Underline(int r12, int r13, long r14, long r16, long r18, long r20, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
            /*
                r11 = this;
                r0 = r22 & 1
                if (r0 == 0) goto L_0x0006
                r0 = 2
                goto L_0x0007
            L_0x0006:
                r0 = r12
            L_0x0007:
                r1 = r22 & 2
                if (r1 == 0) goto L_0x000d
                r1 = 1
                goto L_0x000e
            L_0x000d:
                r1 = r13
            L_0x000e:
                r2 = r22 & 4
                if (r2 == 0) goto L_0x0018
                r2 = 4287137928(0xff888888, double:2.118127569E-314)
                goto L_0x0019
            L_0x0018:
                r2 = r14
            L_0x0019:
                r4 = r22 & 8
                r5 = 4291611852(0xffcccccc, double:2.1203379814E-314)
                if (r4 == 0) goto L_0x0024
                r7 = r5
                goto L_0x0026
            L_0x0024:
                r7 = r16
            L_0x0026:
                r4 = r22 & 16
                if (r4 == 0) goto L_0x002b
                goto L_0x002d
            L_0x002b:
                r5 = r18
            L_0x002d:
                r4 = r22 & 32
                if (r4 == 0) goto L_0x0037
                r9 = 4294901760(0xffff0000, double:2.121963412E-314)
                goto L_0x0039
            L_0x0037:
                r9 = r20
            L_0x0039:
                r12 = r11
                r13 = r0
                r14 = r1
                r15 = r2
                r17 = r7
                r19 = r5
                r21 = r9
                r12.<init>(r13, r14, r15, r17, r19, r21)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldIndicatorStyle.Underline.<init>(int, int, long, long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public static /* synthetic */ Underline copy$default(Underline underline, int i11, int i12, long j11, long j12, long j13, long j14, int i13, Object obj) {
            Underline underline2 = underline;
            return underline.copy((i13 & 1) != 0 ? underline2.focusedUnderlineThickness : i11, (i13 & 2) != 0 ? underline2.unfocusedUnderlineThickness : i12, (i13 & 4) != 0 ? underline2.focusedUnderlineColor : j11, (i13 & 8) != 0 ? underline2.unfocusedUnderlineColor : j12, (i13 & 16) != 0 ? underline2.disabledUnderlineColor : j13, (i13 & 32) != 0 ? underline2.errorUnderlineColor : j14);
        }

        public final int component1() {
            return this.focusedUnderlineThickness;
        }

        public final int component2() {
            return this.unfocusedUnderlineThickness;
        }

        public final long component3() {
            return this.focusedUnderlineColor;
        }

        public final long component4() {
            return this.unfocusedUnderlineColor;
        }

        public final long component5() {
            return this.disabledUnderlineColor;
        }

        public final long component6() {
            return this.errorUnderlineColor;
        }

        @NotNull
        public final Underline copy(int i11, int i12, long j11, long j12, long j13, long j14) {
            return new Underline(i11, i12, j11, j12, j13, j14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Underline)) {
                return false;
            }
            Underline underline = (Underline) obj;
            return this.focusedUnderlineThickness == underline.focusedUnderlineThickness && this.unfocusedUnderlineThickness == underline.unfocusedUnderlineThickness && this.focusedUnderlineColor == underline.focusedUnderlineColor && this.unfocusedUnderlineColor == underline.unfocusedUnderlineColor && this.disabledUnderlineColor == underline.disabledUnderlineColor && this.errorUnderlineColor == underline.errorUnderlineColor;
        }

        public final long getDisabledUnderlineColor() {
            return this.disabledUnderlineColor;
        }

        public final long getErrorUnderlineColor() {
            return this.errorUnderlineColor;
        }

        public final long getFocusedUnderlineColor() {
            return this.focusedUnderlineColor;
        }

        public final int getFocusedUnderlineThickness() {
            return this.focusedUnderlineThickness;
        }

        public final long getUnfocusedUnderlineColor() {
            return this.unfocusedUnderlineColor;
        }

        public final int getUnfocusedUnderlineThickness() {
            return this.unfocusedUnderlineThickness;
        }

        public int hashCode() {
            return (((((((((this.focusedUnderlineThickness * 31) + this.unfocusedUnderlineThickness) * 31) + a.a(this.focusedUnderlineColor)) * 31) + a.a(this.unfocusedUnderlineColor)) * 31) + a.a(this.disabledUnderlineColor)) * 31) + a.a(this.errorUnderlineColor);
        }

        @NotNull
        public String toString() {
            int i11 = this.focusedUnderlineThickness;
            int i12 = this.unfocusedUnderlineThickness;
            long j11 = this.focusedUnderlineColor;
            long j12 = this.unfocusedUnderlineColor;
            long j13 = this.disabledUnderlineColor;
            long j14 = this.errorUnderlineColor;
            return "Underline(focusedUnderlineThickness=" + i11 + ", unfocusedUnderlineThickness=" + i12 + ", focusedUnderlineColor=" + j11 + ", unfocusedUnderlineColor=" + j12 + ", disabledUnderlineColor=" + j13 + ", errorUnderlineColor=" + j14 + ")";
        }

        @JvmOverloads
        public Underline(int i11, int i12, long j11, long j12, long j13, long j14) {
            super((DefaultConstructorMarker) null);
            this.focusedUnderlineThickness = i11;
            this.unfocusedUnderlineThickness = i12;
            this.focusedUnderlineColor = j11;
            this.unfocusedUnderlineColor = j12;
            this.disabledUnderlineColor = j13;
            this.errorUnderlineColor = j14;
        }
    }

    private InputFieldIndicatorStyle() {
    }

    public /* synthetic */ InputFieldIndicatorStyle(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BW\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\nHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0007HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006+"}, d2 = {"Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle$Border;", "Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;", "shape", "Lcom/checkout/frames/model/Shape;", "cornerRadius", "Lcom/checkout/frames/model/CornerRadius;", "focusedBorderThickness", "", "unfocusedBorderThickness", "focusedBorderColor", "", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "(Lcom/checkout/frames/model/Shape;Lcom/checkout/frames/model/CornerRadius;IIJJJJ)V", "getCornerRadius", "()Lcom/checkout/frames/model/CornerRadius;", "getDisabledBorderColor", "()J", "getErrorBorderColor", "getFocusedBorderColor", "getFocusedBorderThickness", "()I", "getShape", "()Lcom/checkout/frames/model/Shape;", "getUnfocusedBorderColor", "getUnfocusedBorderThickness", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Border extends InputFieldIndicatorStyle {
        public static final int $stable = 0;
        @NotNull
        private final CornerRadius cornerRadius;
        private final long disabledBorderColor;
        private final long errorBorderColor;
        private final long focusedBorderColor;
        private final int focusedBorderThickness;
        @NotNull
        private final Shape shape;
        private final long unfocusedBorderColor;
        private final int unfocusedBorderThickness;

        @JvmOverloads
        public Border() {
            this((Shape) null, (CornerRadius) null, 0, 0, 0, 0, 0, 0, 255, (DefaultConstructorMarker) null);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        @kotlin.jvm.JvmOverloads
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Border(@org.jetbrains.annotations.NotNull com.checkout.frames.model.Shape r17) {
            /*
                r16 = this;
                java.lang.String r0 = "shape"
                r2 = r17
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r8 = 0
                r10 = 0
                r12 = 0
                r14 = 254(0xfe, float:3.56E-43)
                r15 = 0
                r1 = r16
                r1.<init>(r2, r3, r4, r5, r6, r8, r10, r12, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldIndicatorStyle.Border.<init>(com.checkout.frames.model.Shape):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        @kotlin.jvm.JvmOverloads
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Border(@org.jetbrains.annotations.NotNull com.checkout.frames.model.Shape r17, @org.jetbrains.annotations.NotNull com.checkout.frames.model.CornerRadius r18) {
            /*
                r16 = this;
                java.lang.String r0 = "shape"
                r2 = r17
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "cornerRadius"
                r3 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r4 = 0
                r5 = 0
                r6 = 0
                r8 = 0
                r10 = 0
                r12 = 0
                r14 = 252(0xfc, float:3.53E-43)
                r15 = 0
                r1 = r16
                r1.<init>(r2, r3, r4, r5, r6, r8, r10, r12, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldIndicatorStyle.Border.<init>(com.checkout.frames.model.Shape, com.checkout.frames.model.CornerRadius):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        @kotlin.jvm.JvmOverloads
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Border(@org.jetbrains.annotations.NotNull com.checkout.frames.model.Shape r17, @org.jetbrains.annotations.NotNull com.checkout.frames.model.CornerRadius r18, int r19) {
            /*
                r16 = this;
                java.lang.String r0 = "shape"
                r2 = r17
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "cornerRadius"
                r3 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r5 = 0
                r6 = 0
                r8 = 0
                r10 = 0
                r12 = 0
                r14 = 248(0xf8, float:3.48E-43)
                r15 = 0
                r1 = r16
                r4 = r19
                r1.<init>(r2, r3, r4, r5, r6, r8, r10, r12, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldIndicatorStyle.Border.<init>(com.checkout.frames.model.Shape, com.checkout.frames.model.CornerRadius, int):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        @kotlin.jvm.JvmOverloads
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Border(@org.jetbrains.annotations.NotNull com.checkout.frames.model.Shape r17, @org.jetbrains.annotations.NotNull com.checkout.frames.model.CornerRadius r18, int r19, int r20) {
            /*
                r16 = this;
                java.lang.String r0 = "shape"
                r2 = r17
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "cornerRadius"
                r3 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r6 = 0
                r8 = 0
                r10 = 0
                r12 = 0
                r14 = 240(0xf0, float:3.36E-43)
                r15 = 0
                r1 = r16
                r4 = r19
                r5 = r20
                r1.<init>(r2, r3, r4, r5, r6, r8, r10, r12, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldIndicatorStyle.Border.<init>(com.checkout.frames.model.Shape, com.checkout.frames.model.CornerRadius, int, int):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        @kotlin.jvm.JvmOverloads
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Border(@org.jetbrains.annotations.NotNull com.checkout.frames.model.Shape r17, @org.jetbrains.annotations.NotNull com.checkout.frames.model.CornerRadius r18, int r19, int r20, long r21) {
            /*
                r16 = this;
                java.lang.String r0 = "shape"
                r2 = r17
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "cornerRadius"
                r3 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r8 = 0
                r10 = 0
                r12 = 0
                r14 = 224(0xe0, float:3.14E-43)
                r15 = 0
                r1 = r16
                r4 = r19
                r5 = r20
                r6 = r21
                r1.<init>(r2, r3, r4, r5, r6, r8, r10, r12, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldIndicatorStyle.Border.<init>(com.checkout.frames.model.Shape, com.checkout.frames.model.CornerRadius, int, int, long):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        @kotlin.jvm.JvmOverloads
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Border(@org.jetbrains.annotations.NotNull com.checkout.frames.model.Shape r17, @org.jetbrains.annotations.NotNull com.checkout.frames.model.CornerRadius r18, int r19, int r20, long r21, long r23) {
            /*
                r16 = this;
                java.lang.String r0 = "shape"
                r2 = r17
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "cornerRadius"
                r3 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r10 = 0
                r12 = 0
                r14 = 192(0xc0, float:2.69E-43)
                r15 = 0
                r1 = r16
                r4 = r19
                r5 = r20
                r6 = r21
                r8 = r23
                r1.<init>(r2, r3, r4, r5, r6, r8, r10, r12, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldIndicatorStyle.Border.<init>(com.checkout.frames.model.Shape, com.checkout.frames.model.CornerRadius, int, int, long, long):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        @kotlin.jvm.JvmOverloads
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Border(@org.jetbrains.annotations.NotNull com.checkout.frames.model.Shape r17, @org.jetbrains.annotations.NotNull com.checkout.frames.model.CornerRadius r18, int r19, int r20, long r21, long r23, long r25) {
            /*
                r16 = this;
                java.lang.String r0 = "shape"
                r2 = r17
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "cornerRadius"
                r3 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                r12 = 0
                r14 = 128(0x80, float:1.794E-43)
                r15 = 0
                r1 = r16
                r4 = r19
                r5 = r20
                r6 = r21
                r8 = r23
                r10 = r25
                r1.<init>(r2, r3, r4, r5, r6, r8, r10, r12, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldIndicatorStyle.Border.<init>(com.checkout.frames.model.Shape, com.checkout.frames.model.CornerRadius, int, int, long, long, long):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Border(com.checkout.frames.model.Shape r15, com.checkout.frames.model.CornerRadius r16, int r17, int r18, long r19, long r21, long r23, long r25, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
            /*
                r14 = this;
                r0 = r27
                r1 = r0 & 1
                if (r1 == 0) goto L_0x0009
                com.checkout.frames.model.Shape r1 = com.checkout.frames.model.Shape.RoundCorner
                goto L_0x000a
            L_0x0009:
                r1 = r15
            L_0x000a:
                r2 = r0 & 2
                if (r2 == 0) goto L_0x0016
                com.checkout.frames.model.CornerRadius r2 = new com.checkout.frames.model.CornerRadius
                r3 = 8
                r2.<init>(r3)
                goto L_0x0018
            L_0x0016:
                r2 = r16
            L_0x0018:
                r3 = r0 & 4
                if (r3 == 0) goto L_0x001e
                r3 = 2
                goto L_0x0020
            L_0x001e:
                r3 = r17
            L_0x0020:
                r4 = r0 & 8
                if (r4 == 0) goto L_0x0026
                r4 = 1
                goto L_0x0028
            L_0x0026:
                r4 = r18
            L_0x0028:
                r5 = r0 & 16
                if (r5 == 0) goto L_0x0032
                r5 = 4287269514(0xff8a8a8a, double:2.1181925813E-314)
                goto L_0x0034
            L_0x0032:
                r5 = r19
            L_0x0034:
                r7 = r0 & 32
                r8 = 4291611852(0xffcccccc, double:2.1203379814E-314)
                if (r7 == 0) goto L_0x003f
                r10 = r8
                goto L_0x0041
            L_0x003f:
                r10 = r21
            L_0x0041:
                r7 = r0 & 64
                if (r7 == 0) goto L_0x0046
                goto L_0x0048
            L_0x0046:
                r8 = r23
            L_0x0048:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x0052
                r12 = 4289538110(0xffad283e, double:2.1193134167E-314)
                goto L_0x0054
            L_0x0052:
                r12 = r25
            L_0x0054:
                r15 = r14
                r16 = r1
                r17 = r2
                r18 = r3
                r19 = r4
                r20 = r5
                r22 = r10
                r24 = r8
                r26 = r12
                r15.<init>(r16, r17, r18, r19, r20, r22, r24, r26)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldIndicatorStyle.Border.<init>(com.checkout.frames.model.Shape, com.checkout.frames.model.CornerRadius, int, int, long, long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public static /* synthetic */ Border copy$default(Border border, Shape shape2, CornerRadius cornerRadius2, int i11, int i12, long j11, long j12, long j13, long j14, int i13, Object obj) {
            Border border2 = border;
            int i14 = i13;
            return border.copy((i14 & 1) != 0 ? border2.shape : shape2, (i14 & 2) != 0 ? border2.cornerRadius : cornerRadius2, (i14 & 4) != 0 ? border2.focusedBorderThickness : i11, (i14 & 8) != 0 ? border2.unfocusedBorderThickness : i12, (i14 & 16) != 0 ? border2.focusedBorderColor : j11, (i14 & 32) != 0 ? border2.unfocusedBorderColor : j12, (i14 & 64) != 0 ? border2.disabledBorderColor : j13, (i14 & 128) != 0 ? border2.errorBorderColor : j14);
        }

        @NotNull
        public final Shape component1() {
            return this.shape;
        }

        @NotNull
        public final CornerRadius component2() {
            return this.cornerRadius;
        }

        public final int component3() {
            return this.focusedBorderThickness;
        }

        public final int component4() {
            return this.unfocusedBorderThickness;
        }

        public final long component5() {
            return this.focusedBorderColor;
        }

        public final long component6() {
            return this.unfocusedBorderColor;
        }

        public final long component7() {
            return this.disabledBorderColor;
        }

        public final long component8() {
            return this.errorBorderColor;
        }

        @NotNull
        public final Border copy(@NotNull Shape shape2, @NotNull CornerRadius cornerRadius2, int i11, int i12, long j11, long j12, long j13, long j14) {
            Intrinsics.checkNotNullParameter(shape2, "shape");
            CornerRadius cornerRadius3 = cornerRadius2;
            Intrinsics.checkNotNullParameter(cornerRadius3, "cornerRadius");
            return new Border(shape2, cornerRadius3, i11, i12, j11, j12, j13, j14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Border)) {
                return false;
            }
            Border border = (Border) obj;
            return this.shape == border.shape && Intrinsics.areEqual((Object) this.cornerRadius, (Object) border.cornerRadius) && this.focusedBorderThickness == border.focusedBorderThickness && this.unfocusedBorderThickness == border.unfocusedBorderThickness && this.focusedBorderColor == border.focusedBorderColor && this.unfocusedBorderColor == border.unfocusedBorderColor && this.disabledBorderColor == border.disabledBorderColor && this.errorBorderColor == border.errorBorderColor;
        }

        @NotNull
        public final CornerRadius getCornerRadius() {
            return this.cornerRadius;
        }

        public final long getDisabledBorderColor() {
            return this.disabledBorderColor;
        }

        public final long getErrorBorderColor() {
            return this.errorBorderColor;
        }

        public final long getFocusedBorderColor() {
            return this.focusedBorderColor;
        }

        public final int getFocusedBorderThickness() {
            return this.focusedBorderThickness;
        }

        @NotNull
        public final Shape getShape() {
            return this.shape;
        }

        public final long getUnfocusedBorderColor() {
            return this.unfocusedBorderColor;
        }

        public final int getUnfocusedBorderThickness() {
            return this.unfocusedBorderThickness;
        }

        public int hashCode() {
            return (((((((((((((this.shape.hashCode() * 31) + this.cornerRadius.hashCode()) * 31) + this.focusedBorderThickness) * 31) + this.unfocusedBorderThickness) * 31) + a.a(this.focusedBorderColor)) * 31) + a.a(this.unfocusedBorderColor)) * 31) + a.a(this.disabledBorderColor)) * 31) + a.a(this.errorBorderColor);
        }

        @NotNull
        public String toString() {
            Shape shape2 = this.shape;
            CornerRadius cornerRadius2 = this.cornerRadius;
            int i11 = this.focusedBorderThickness;
            int i12 = this.unfocusedBorderThickness;
            long j11 = this.focusedBorderColor;
            long j12 = this.unfocusedBorderColor;
            long j13 = this.disabledBorderColor;
            long j14 = this.errorBorderColor;
            return "Border(shape=" + shape2 + ", cornerRadius=" + cornerRadius2 + ", focusedBorderThickness=" + i11 + ", unfocusedBorderThickness=" + i12 + ", focusedBorderColor=" + j11 + ", unfocusedBorderColor=" + j12 + ", disabledBorderColor=" + j13 + ", errorBorderColor=" + j14 + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        @JvmOverloads
        public Border(@NotNull Shape shape2, @NotNull CornerRadius cornerRadius2, int i11, int i12, long j11, long j12, long j13, long j14) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(shape2, "shape");
            Intrinsics.checkNotNullParameter(cornerRadius2, "cornerRadius");
            this.shape = shape2;
            this.cornerRadius = cornerRadius2;
            this.focusedBorderThickness = i11;
            this.unfocusedBorderThickness = i12;
            this.focusedBorderColor = j11;
            this.unfocusedBorderColor = j12;
            this.disabledBorderColor = j13;
            this.errorBorderColor = j14;
        }
    }
}
