package com.checkout.frames.style.component.base;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.BorderStroke;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.Shape;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Ba\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jh\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u000bHÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b!\u0010\u0019¨\u00062"}, d2 = {"Lcom/checkout/frames/style/component/base/ContainerStyle;", "", "color", "", "shape", "Lcom/checkout/frames/model/Shape;", "cornerRadius", "Lcom/checkout/frames/model/CornerRadius;", "borderStroke", "Lcom/checkout/frames/model/BorderStroke;", "width", "", "height", "padding", "Lcom/checkout/frames/model/Padding;", "margin", "Lcom/checkout/frames/model/Margin;", "(JLcom/checkout/frames/model/Shape;Lcom/checkout/frames/model/CornerRadius;Lcom/checkout/frames/model/BorderStroke;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/checkout/frames/model/Padding;Lcom/checkout/frames/model/Margin;)V", "getBorderStroke", "()Lcom/checkout/frames/model/BorderStroke;", "getColor", "()J", "getCornerRadius", "()Lcom/checkout/frames/model/CornerRadius;", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMargin", "()Lcom/checkout/frames/model/Margin;", "getPadding", "()Lcom/checkout/frames/model/Padding;", "getShape", "()Lcom/checkout/frames/model/Shape;", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLcom/checkout/frames/model/Shape;Lcom/checkout/frames/model/CornerRadius;Lcom/checkout/frames/model/BorderStroke;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/checkout/frames/model/Padding;Lcom/checkout/frames/model/Margin;)Lcom/checkout/frames/style/component/base/ContainerStyle;", "equals", "", "other", "hashCode", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContainerStyle {
    public static final int $stable = 0;
    @Nullable
    private final BorderStroke borderStroke;
    private final long color;
    @NotNull
    private final CornerRadius cornerRadius;
    @Nullable
    private final Integer height;
    @Nullable
    private final Margin margin;
    @Nullable
    private final Padding padding;
    @NotNull
    private final Shape shape;
    @Nullable
    private final Integer width;

    @JvmOverloads
    public ContainerStyle() {
        this(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, (Padding) null, (Margin) null, 255, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ContainerStyle(long j11) {
        this(j11, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, (Padding) null, (Margin) null, 254, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ContainerStyle(long r14, @org.jetbrains.annotations.NotNull com.checkout.frames.model.Shape r16) {
        /*
            r13 = this;
            java.lang.String r0 = "shape"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 252(0xfc, float:3.53E-43)
            r12 = 0
            r1 = r13
            r2 = r14
            r1.<init>(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.ContainerStyle.<init>(long, com.checkout.frames.model.Shape):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ContainerStyle(long r14, @org.jetbrains.annotations.NotNull com.checkout.frames.model.Shape r16, @org.jetbrains.annotations.NotNull com.checkout.frames.model.CornerRadius r17) {
        /*
            r13 = this;
            java.lang.String r0 = "shape"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "cornerRadius"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 248(0xf8, float:3.48E-43)
            r12 = 0
            r1 = r13
            r2 = r14
            r1.<init>(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.ContainerStyle.<init>(long, com.checkout.frames.model.Shape, com.checkout.frames.model.CornerRadius):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ContainerStyle(long r14, @org.jetbrains.annotations.NotNull com.checkout.frames.model.Shape r16, @org.jetbrains.annotations.NotNull com.checkout.frames.model.CornerRadius r17, @org.jetbrains.annotations.Nullable com.checkout.frames.model.BorderStroke r18) {
        /*
            r13 = this;
            java.lang.String r0 = "shape"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "cornerRadius"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 240(0xf0, float:3.36E-43)
            r12 = 0
            r1 = r13
            r2 = r14
            r6 = r18
            r1.<init>(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.ContainerStyle.<init>(long, com.checkout.frames.model.Shape, com.checkout.frames.model.CornerRadius, com.checkout.frames.model.BorderStroke):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ContainerStyle(long r14, @org.jetbrains.annotations.NotNull com.checkout.frames.model.Shape r16, @org.jetbrains.annotations.NotNull com.checkout.frames.model.CornerRadius r17, @org.jetbrains.annotations.Nullable com.checkout.frames.model.BorderStroke r18, @org.jetbrains.annotations.Nullable java.lang.Integer r19) {
        /*
            r13 = this;
            java.lang.String r0 = "shape"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "cornerRadius"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 224(0xe0, float:3.14E-43)
            r12 = 0
            r1 = r13
            r2 = r14
            r6 = r18
            r7 = r19
            r1.<init>(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.ContainerStyle.<init>(long, com.checkout.frames.model.Shape, com.checkout.frames.model.CornerRadius, com.checkout.frames.model.BorderStroke, java.lang.Integer):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ContainerStyle(long r14, @org.jetbrains.annotations.NotNull com.checkout.frames.model.Shape r16, @org.jetbrains.annotations.NotNull com.checkout.frames.model.CornerRadius r17, @org.jetbrains.annotations.Nullable com.checkout.frames.model.BorderStroke r18, @org.jetbrains.annotations.Nullable java.lang.Integer r19, @org.jetbrains.annotations.Nullable java.lang.Integer r20) {
        /*
            r13 = this;
            java.lang.String r0 = "shape"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "cornerRadius"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r9 = 0
            r10 = 0
            r11 = 192(0xc0, float:2.69E-43)
            r12 = 0
            r1 = r13
            r2 = r14
            r6 = r18
            r7 = r19
            r8 = r20
            r1.<init>(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.ContainerStyle.<init>(long, com.checkout.frames.model.Shape, com.checkout.frames.model.CornerRadius, com.checkout.frames.model.BorderStroke, java.lang.Integer, java.lang.Integer):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ContainerStyle(long r14, @org.jetbrains.annotations.NotNull com.checkout.frames.model.Shape r16, @org.jetbrains.annotations.NotNull com.checkout.frames.model.CornerRadius r17, @org.jetbrains.annotations.Nullable com.checkout.frames.model.BorderStroke r18, @org.jetbrains.annotations.Nullable java.lang.Integer r19, @org.jetbrains.annotations.Nullable java.lang.Integer r20, @org.jetbrains.annotations.Nullable com.checkout.frames.model.Padding r21) {
        /*
            r13 = this;
            java.lang.String r0 = "shape"
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "cornerRadius"
            r5 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r10 = 0
            r11 = 128(0x80, float:1.794E-43)
            r12 = 0
            r1 = r13
            r2 = r14
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r1.<init>(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.ContainerStyle.<init>(long, com.checkout.frames.model.Shape, com.checkout.frames.model.CornerRadius, com.checkout.frames.model.BorderStroke, java.lang.Integer, java.lang.Integer, com.checkout.frames.model.Padding):void");
    }

    @JvmOverloads
    public ContainerStyle(long j11, @NotNull Shape shape2, @NotNull CornerRadius cornerRadius2, @Nullable BorderStroke borderStroke2, @Nullable Integer num, @Nullable Integer num2, @Nullable Padding padding2, @Nullable Margin margin2) {
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius2, "cornerRadius");
        this.color = j11;
        this.shape = shape2;
        this.cornerRadius = cornerRadius2;
        this.borderStroke = borderStroke2;
        this.width = num;
        this.height = num2;
        this.padding = padding2;
        this.margin = margin2;
    }

    public static /* synthetic */ ContainerStyle copy$default(ContainerStyle containerStyle, long j11, Shape shape2, CornerRadius cornerRadius2, BorderStroke borderStroke2, Integer num, Integer num2, Padding padding2, Margin margin2, int i11, Object obj) {
        ContainerStyle containerStyle2 = containerStyle;
        int i12 = i11;
        return containerStyle.copy((i12 & 1) != 0 ? containerStyle2.color : j11, (i12 & 2) != 0 ? containerStyle2.shape : shape2, (i12 & 4) != 0 ? containerStyle2.cornerRadius : cornerRadius2, (i12 & 8) != 0 ? containerStyle2.borderStroke : borderStroke2, (i12 & 16) != 0 ? containerStyle2.width : num, (i12 & 32) != 0 ? containerStyle2.height : num2, (i12 & 64) != 0 ? containerStyle2.padding : padding2, (i12 & 128) != 0 ? containerStyle2.margin : margin2);
    }

    public final long component1() {
        return this.color;
    }

    @NotNull
    public final Shape component2() {
        return this.shape;
    }

    @NotNull
    public final CornerRadius component3() {
        return this.cornerRadius;
    }

    @Nullable
    public final BorderStroke component4() {
        return this.borderStroke;
    }

    @Nullable
    public final Integer component5() {
        return this.width;
    }

    @Nullable
    public final Integer component6() {
        return this.height;
    }

    @Nullable
    public final Padding component7() {
        return this.padding;
    }

    @Nullable
    public final Margin component8() {
        return this.margin;
    }

    @NotNull
    public final ContainerStyle copy(long j11, @NotNull Shape shape2, @NotNull CornerRadius cornerRadius2, @Nullable BorderStroke borderStroke2, @Nullable Integer num, @Nullable Integer num2, @Nullable Padding padding2, @Nullable Margin margin2) {
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius2, "cornerRadius");
        return new ContainerStyle(j11, shape2, cornerRadius2, borderStroke2, num, num2, padding2, margin2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContainerStyle)) {
            return false;
        }
        ContainerStyle containerStyle = (ContainerStyle) obj;
        return this.color == containerStyle.color && this.shape == containerStyle.shape && Intrinsics.areEqual((Object) this.cornerRadius, (Object) containerStyle.cornerRadius) && Intrinsics.areEqual((Object) this.borderStroke, (Object) containerStyle.borderStroke) && Intrinsics.areEqual((Object) this.width, (Object) containerStyle.width) && Intrinsics.areEqual((Object) this.height, (Object) containerStyle.height) && Intrinsics.areEqual((Object) this.padding, (Object) containerStyle.padding) && Intrinsics.areEqual((Object) this.margin, (Object) containerStyle.margin);
    }

    @Nullable
    public final BorderStroke getBorderStroke() {
        return this.borderStroke;
    }

    public final long getColor() {
        return this.color;
    }

    @NotNull
    public final CornerRadius getCornerRadius() {
        return this.cornerRadius;
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    public final Margin getMargin() {
        return this.margin;
    }

    @Nullable
    public final Padding getPadding() {
        return this.padding;
    }

    @NotNull
    public final Shape getShape() {
        return this.shape;
    }

    @Nullable
    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        int a11 = ((((a.a(this.color) * 31) + this.shape.hashCode()) * 31) + this.cornerRadius.hashCode()) * 31;
        BorderStroke borderStroke2 = this.borderStroke;
        int i11 = 0;
        int hashCode = (a11 + (borderStroke2 == null ? 0 : borderStroke2.hashCode())) * 31;
        Integer num = this.width;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.height;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Padding padding2 = this.padding;
        int hashCode4 = (hashCode3 + (padding2 == null ? 0 : padding2.hashCode())) * 31;
        Margin margin2 = this.margin;
        if (margin2 != null) {
            i11 = margin2.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        long j11 = this.color;
        Shape shape2 = this.shape;
        CornerRadius cornerRadius2 = this.cornerRadius;
        BorderStroke borderStroke2 = this.borderStroke;
        Integer num = this.width;
        Integer num2 = this.height;
        Padding padding2 = this.padding;
        Margin margin2 = this.margin;
        return "ContainerStyle(color=" + j11 + ", shape=" + shape2 + ", cornerRadius=" + cornerRadius2 + ", borderStroke=" + borderStroke2 + ", width=" + num + ", height=" + num2 + ", padding=" + padding2 + ", margin=" + margin2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ContainerStyle(long r11, com.checkout.frames.model.Shape r13, com.checkout.frames.model.CornerRadius r14, com.checkout.frames.model.BorderStroke r15, java.lang.Integer r16, java.lang.Integer r17, com.checkout.frames.model.Padding r18, com.checkout.frames.model.Margin r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0015
            com.checkout.frames.utils.constants.ContainerConstants r3 = com.checkout.frames.utils.constants.ContainerConstants.INSTANCE
            com.checkout.frames.model.Shape r3 = r3.getShape()
            goto L_0x0016
        L_0x0015:
            r3 = r13
        L_0x0016:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0021
            com.checkout.frames.model.CornerRadius r4 = new com.checkout.frames.model.CornerRadius
            r5 = 0
            r4.<init>(r5)
            goto L_0x0022
        L_0x0021:
            r4 = r14
        L_0x0022:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L_0x0029
            r5 = r6
            goto L_0x002a
        L_0x0029:
            r5 = r15
        L_0x002a:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0030
            r7 = r6
            goto L_0x0032
        L_0x0030:
            r7 = r16
        L_0x0032:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0038
            r8 = r6
            goto L_0x003a
        L_0x0038:
            r8 = r17
        L_0x003a:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0040
            r9 = r6
            goto L_0x0042
        L_0x0040:
            r9 = r18
        L_0x0042:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r6 = r19
        L_0x0049:
            r11 = r10
            r12 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r7
            r18 = r8
            r19 = r9
            r20 = r6
            r11.<init>(r12, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.ContainerStyle.<init>(long, com.checkout.frames.model.Shape, com.checkout.frames.model.CornerRadius, com.checkout.frames.model.BorderStroke, java.lang.Integer, java.lang.Integer, com.checkout.frames.model.Padding, com.checkout.frames.model.Margin, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
