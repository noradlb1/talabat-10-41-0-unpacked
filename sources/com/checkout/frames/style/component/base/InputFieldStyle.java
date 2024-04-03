package com.checkout.frames.style.component.base;

import androidx.annotation.StringRes;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bs\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0013HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010&J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\t\u00102\u001a\u00020\fHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0011HÆ\u0003Jz\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0007HÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001e¨\u0006="}, d2 = {"Lcom/checkout/frames/style/component/base/InputFieldStyle;", "", "textStyle", "Lcom/checkout/frames/style/component/base/TextStyle;", "placeholderText", "", "placeholderTextId", "", "placeholderStyle", "containerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "indicatorStyle", "Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;", "leadingIconStyle", "Lcom/checkout/frames/style/component/base/ImageStyle;", "trailingIconStyle", "cursorStyle", "Lcom/checkout/frames/style/component/base/CursorStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "(Lcom/checkout/frames/style/component/base/TextStyle;Ljava/lang/String;Ljava/lang/Integer;Lcom/checkout/frames/style/component/base/TextStyle;Lcom/checkout/frames/style/component/base/ContainerStyle;Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;Lcom/checkout/frames/style/component/base/ImageStyle;Lcom/checkout/frames/style/component/base/ImageStyle;Lcom/checkout/frames/style/component/base/CursorStyle;Landroidx/compose/foundation/text/KeyboardOptions;)V", "getContainerStyle", "()Lcom/checkout/frames/style/component/base/ContainerStyle;", "getCursorStyle", "()Lcom/checkout/frames/style/component/base/CursorStyle;", "getIndicatorStyle", "()Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "getLeadingIconStyle", "()Lcom/checkout/frames/style/component/base/ImageStyle;", "getPlaceholderStyle", "()Lcom/checkout/frames/style/component/base/TextStyle;", "getPlaceholderText", "()Ljava/lang/String;", "setPlaceholderText", "(Ljava/lang/String;)V", "getPlaceholderTextId", "()Ljava/lang/Integer;", "setPlaceholderTextId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTextStyle", "getTrailingIconStyle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/checkout/frames/style/component/base/TextStyle;Ljava/lang/String;Ljava/lang/Integer;Lcom/checkout/frames/style/component/base/TextStyle;Lcom/checkout/frames/style/component/base/ContainerStyle;Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;Lcom/checkout/frames/style/component/base/ImageStyle;Lcom/checkout/frames/style/component/base/ImageStyle;Lcom/checkout/frames/style/component/base/CursorStyle;Landroidx/compose/foundation/text/KeyboardOptions;)Lcom/checkout/frames/style/component/base/InputFieldStyle;", "equals", "", "other", "hashCode", "toString", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputFieldStyle {
    public static final int $stable = 8;
    @NotNull
    private final ContainerStyle containerStyle;
    @Nullable
    private final CursorStyle cursorStyle;
    @NotNull
    private final InputFieldIndicatorStyle indicatorStyle;
    @NotNull
    private final KeyboardOptions keyboardOptions;
    @Nullable
    private final ImageStyle leadingIconStyle;
    @NotNull
    private final TextStyle placeholderStyle;
    @NotNull
    private String placeholderText;
    @Nullable
    private Integer placeholderTextId;
    @NotNull
    private final TextStyle textStyle;
    @Nullable
    private final ImageStyle trailingIconStyle;

    @JvmOverloads
    public InputFieldStyle() {
        this((TextStyle) null, (String) null, (Integer) null, (TextStyle) null, (ContainerStyle) null, (InputFieldIndicatorStyle) null, (ImageStyle) null, (ImageStyle) null, (CursorStyle) null, (KeyboardOptions) null, 1023, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InputFieldStyle(@NotNull TextStyle textStyle2) {
        this(textStyle2, (String) null, (Integer) null, (TextStyle) null, (ContainerStyle) null, (InputFieldIndicatorStyle) null, (ImageStyle) null, (ImageStyle) null, (CursorStyle) null, (KeyboardOptions) null, 1022, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(textStyle2, "textStyle");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InputFieldStyle(@org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.TextStyle r15, @org.jetbrains.annotations.NotNull java.lang.String r16) {
        /*
            r14 = this;
            java.lang.String r0 = "textStyle"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "placeholderText"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 1020(0x3fc, float:1.43E-42)
            r13 = 0
            r1 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldStyle.<init>(com.checkout.frames.style.component.base.TextStyle, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InputFieldStyle(@org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.TextStyle r15, @org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.Nullable @androidx.annotation.StringRes java.lang.Integer r17) {
        /*
            r14 = this;
            java.lang.String r0 = "textStyle"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "placeholderText"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 1016(0x3f8, float:1.424E-42)
            r13 = 0
            r1 = r14
            r4 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldStyle.<init>(com.checkout.frames.style.component.base.TextStyle, java.lang.String, java.lang.Integer):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InputFieldStyle(@org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.TextStyle r15, @org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.Nullable @androidx.annotation.StringRes java.lang.Integer r17, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.TextStyle r18) {
        /*
            r14 = this;
            java.lang.String r0 = "textStyle"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "placeholderText"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "placeholderStyle"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 1008(0x3f0, float:1.413E-42)
            r13 = 0
            r1 = r14
            r4 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldStyle.<init>(com.checkout.frames.style.component.base.TextStyle, java.lang.String, java.lang.Integer, com.checkout.frames.style.component.base.TextStyle):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InputFieldStyle(@org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.TextStyle r15, @org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.Nullable @androidx.annotation.StringRes java.lang.Integer r17, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.TextStyle r18, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.ContainerStyle r19) {
        /*
            r14 = this;
            java.lang.String r0 = "textStyle"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "placeholderText"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "placeholderStyle"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "containerStyle"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 992(0x3e0, float:1.39E-42)
            r13 = 0
            r1 = r14
            r4 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldStyle.<init>(com.checkout.frames.style.component.base.TextStyle, java.lang.String, java.lang.Integer, com.checkout.frames.style.component.base.TextStyle, com.checkout.frames.style.component.base.ContainerStyle):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InputFieldStyle(@org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.TextStyle r15, @org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.Nullable @androidx.annotation.StringRes java.lang.Integer r17, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.TextStyle r18, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.ContainerStyle r19, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.InputFieldIndicatorStyle r20) {
        /*
            r14 = this;
            java.lang.String r0 = "textStyle"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "placeholderText"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "placeholderStyle"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "containerStyle"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "indicatorStyle"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 960(0x3c0, float:1.345E-42)
            r13 = 0
            r1 = r14
            r4 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldStyle.<init>(com.checkout.frames.style.component.base.TextStyle, java.lang.String, java.lang.Integer, com.checkout.frames.style.component.base.TextStyle, com.checkout.frames.style.component.base.ContainerStyle, com.checkout.frames.style.component.base.InputFieldIndicatorStyle):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InputFieldStyle(@org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.TextStyle r15, @org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.Nullable @androidx.annotation.StringRes java.lang.Integer r17, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.TextStyle r18, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.ContainerStyle r19, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.InputFieldIndicatorStyle r20, @org.jetbrains.annotations.Nullable com.checkout.frames.style.component.base.ImageStyle r21) {
        /*
            r14 = this;
            java.lang.String r0 = "textStyle"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "placeholderText"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "placeholderStyle"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "containerStyle"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "indicatorStyle"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 896(0x380, float:1.256E-42)
            r13 = 0
            r1 = r14
            r4 = r17
            r8 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldStyle.<init>(com.checkout.frames.style.component.base.TextStyle, java.lang.String, java.lang.Integer, com.checkout.frames.style.component.base.TextStyle, com.checkout.frames.style.component.base.ContainerStyle, com.checkout.frames.style.component.base.InputFieldIndicatorStyle, com.checkout.frames.style.component.base.ImageStyle):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InputFieldStyle(@org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.TextStyle r15, @org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.Nullable @androidx.annotation.StringRes java.lang.Integer r17, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.TextStyle r18, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.ContainerStyle r19, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.InputFieldIndicatorStyle r20, @org.jetbrains.annotations.Nullable com.checkout.frames.style.component.base.ImageStyle r21, @org.jetbrains.annotations.Nullable com.checkout.frames.style.component.base.ImageStyle r22) {
        /*
            r14 = this;
            java.lang.String r0 = "textStyle"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "placeholderText"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "placeholderStyle"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "containerStyle"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "indicatorStyle"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r10 = 0
            r11 = 0
            r12 = 768(0x300, float:1.076E-42)
            r13 = 0
            r1 = r14
            r4 = r17
            r8 = r21
            r9 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldStyle.<init>(com.checkout.frames.style.component.base.TextStyle, java.lang.String, java.lang.Integer, com.checkout.frames.style.component.base.TextStyle, com.checkout.frames.style.component.base.ContainerStyle, com.checkout.frames.style.component.base.InputFieldIndicatorStyle, com.checkout.frames.style.component.base.ImageStyle, com.checkout.frames.style.component.base.ImageStyle):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InputFieldStyle(@org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.TextStyle r15, @org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.Nullable @androidx.annotation.StringRes java.lang.Integer r17, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.TextStyle r18, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.ContainerStyle r19, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.InputFieldIndicatorStyle r20, @org.jetbrains.annotations.Nullable com.checkout.frames.style.component.base.ImageStyle r21, @org.jetbrains.annotations.Nullable com.checkout.frames.style.component.base.ImageStyle r22, @org.jetbrains.annotations.Nullable com.checkout.frames.style.component.base.CursorStyle r23) {
        /*
            r14 = this;
            java.lang.String r0 = "textStyle"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "placeholderText"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "placeholderStyle"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "containerStyle"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "indicatorStyle"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r11 = 0
            r12 = 512(0x200, float:7.175E-43)
            r13 = 0
            r1 = r14
            r4 = r17
            r8 = r21
            r9 = r22
            r10 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldStyle.<init>(com.checkout.frames.style.component.base.TextStyle, java.lang.String, java.lang.Integer, com.checkout.frames.style.component.base.TextStyle, com.checkout.frames.style.component.base.ContainerStyle, com.checkout.frames.style.component.base.InputFieldIndicatorStyle, com.checkout.frames.style.component.base.ImageStyle, com.checkout.frames.style.component.base.ImageStyle, com.checkout.frames.style.component.base.CursorStyle):void");
    }

    @JvmOverloads
    public InputFieldStyle(@NotNull TextStyle textStyle2, @NotNull String str, @Nullable @StringRes Integer num, @NotNull TextStyle textStyle3, @NotNull ContainerStyle containerStyle2, @NotNull InputFieldIndicatorStyle inputFieldIndicatorStyle, @Nullable ImageStyle imageStyle, @Nullable ImageStyle imageStyle2, @Nullable CursorStyle cursorStyle2, @NotNull KeyboardOptions keyboardOptions2) {
        Intrinsics.checkNotNullParameter(textStyle2, "textStyle");
        Intrinsics.checkNotNullParameter(str, "placeholderText");
        Intrinsics.checkNotNullParameter(textStyle3, "placeholderStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        Intrinsics.checkNotNullParameter(inputFieldIndicatorStyle, "indicatorStyle");
        Intrinsics.checkNotNullParameter(keyboardOptions2, "keyboardOptions");
        this.textStyle = textStyle2;
        this.placeholderText = str;
        this.placeholderTextId = num;
        this.placeholderStyle = textStyle3;
        this.containerStyle = containerStyle2;
        this.indicatorStyle = inputFieldIndicatorStyle;
        this.leadingIconStyle = imageStyle;
        this.trailingIconStyle = imageStyle2;
        this.cursorStyle = cursorStyle2;
        this.keyboardOptions = keyboardOptions2;
    }

    public static /* synthetic */ InputFieldStyle copy$default(InputFieldStyle inputFieldStyle, TextStyle textStyle2, String str, Integer num, TextStyle textStyle3, ContainerStyle containerStyle2, InputFieldIndicatorStyle inputFieldIndicatorStyle, ImageStyle imageStyle, ImageStyle imageStyle2, CursorStyle cursorStyle2, KeyboardOptions keyboardOptions2, int i11, Object obj) {
        InputFieldStyle inputFieldStyle2 = inputFieldStyle;
        int i12 = i11;
        return inputFieldStyle.copy((i12 & 1) != 0 ? inputFieldStyle2.textStyle : textStyle2, (i12 & 2) != 0 ? inputFieldStyle2.placeholderText : str, (i12 & 4) != 0 ? inputFieldStyle2.placeholderTextId : num, (i12 & 8) != 0 ? inputFieldStyle2.placeholderStyle : textStyle3, (i12 & 16) != 0 ? inputFieldStyle2.containerStyle : containerStyle2, (i12 & 32) != 0 ? inputFieldStyle2.indicatorStyle : inputFieldIndicatorStyle, (i12 & 64) != 0 ? inputFieldStyle2.leadingIconStyle : imageStyle, (i12 & 128) != 0 ? inputFieldStyle2.trailingIconStyle : imageStyle2, (i12 & 256) != 0 ? inputFieldStyle2.cursorStyle : cursorStyle2, (i12 & 512) != 0 ? inputFieldStyle2.keyboardOptions : keyboardOptions2);
    }

    @NotNull
    public final TextStyle component1() {
        return this.textStyle;
    }

    @NotNull
    public final KeyboardOptions component10() {
        return this.keyboardOptions;
    }

    @NotNull
    public final String component2() {
        return this.placeholderText;
    }

    @Nullable
    public final Integer component3() {
        return this.placeholderTextId;
    }

    @NotNull
    public final TextStyle component4() {
        return this.placeholderStyle;
    }

    @NotNull
    public final ContainerStyle component5() {
        return this.containerStyle;
    }

    @NotNull
    public final InputFieldIndicatorStyle component6() {
        return this.indicatorStyle;
    }

    @Nullable
    public final ImageStyle component7() {
        return this.leadingIconStyle;
    }

    @Nullable
    public final ImageStyle component8() {
        return this.trailingIconStyle;
    }

    @Nullable
    public final CursorStyle component9() {
        return this.cursorStyle;
    }

    @NotNull
    public final InputFieldStyle copy(@NotNull TextStyle textStyle2, @NotNull String str, @Nullable @StringRes Integer num, @NotNull TextStyle textStyle3, @NotNull ContainerStyle containerStyle2, @NotNull InputFieldIndicatorStyle inputFieldIndicatorStyle, @Nullable ImageStyle imageStyle, @Nullable ImageStyle imageStyle2, @Nullable CursorStyle cursorStyle2, @NotNull KeyboardOptions keyboardOptions2) {
        Intrinsics.checkNotNullParameter(textStyle2, "textStyle");
        Intrinsics.checkNotNullParameter(str, "placeholderText");
        TextStyle textStyle4 = textStyle3;
        Intrinsics.checkNotNullParameter(textStyle4, "placeholderStyle");
        ContainerStyle containerStyle3 = containerStyle2;
        Intrinsics.checkNotNullParameter(containerStyle3, "containerStyle");
        InputFieldIndicatorStyle inputFieldIndicatorStyle2 = inputFieldIndicatorStyle;
        Intrinsics.checkNotNullParameter(inputFieldIndicatorStyle2, "indicatorStyle");
        KeyboardOptions keyboardOptions3 = keyboardOptions2;
        Intrinsics.checkNotNullParameter(keyboardOptions3, "keyboardOptions");
        return new InputFieldStyle(textStyle2, str, num, textStyle4, containerStyle3, inputFieldIndicatorStyle2, imageStyle, imageStyle2, cursorStyle2, keyboardOptions3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputFieldStyle)) {
            return false;
        }
        InputFieldStyle inputFieldStyle = (InputFieldStyle) obj;
        return Intrinsics.areEqual((Object) this.textStyle, (Object) inputFieldStyle.textStyle) && Intrinsics.areEqual((Object) this.placeholderText, (Object) inputFieldStyle.placeholderText) && Intrinsics.areEqual((Object) this.placeholderTextId, (Object) inputFieldStyle.placeholderTextId) && Intrinsics.areEqual((Object) this.placeholderStyle, (Object) inputFieldStyle.placeholderStyle) && Intrinsics.areEqual((Object) this.containerStyle, (Object) inputFieldStyle.containerStyle) && Intrinsics.areEqual((Object) this.indicatorStyle, (Object) inputFieldStyle.indicatorStyle) && Intrinsics.areEqual((Object) this.leadingIconStyle, (Object) inputFieldStyle.leadingIconStyle) && Intrinsics.areEqual((Object) this.trailingIconStyle, (Object) inputFieldStyle.trailingIconStyle) && Intrinsics.areEqual((Object) this.cursorStyle, (Object) inputFieldStyle.cursorStyle) && Intrinsics.areEqual((Object) this.keyboardOptions, (Object) inputFieldStyle.keyboardOptions);
    }

    @NotNull
    public final ContainerStyle getContainerStyle() {
        return this.containerStyle;
    }

    @Nullable
    public final CursorStyle getCursorStyle() {
        return this.cursorStyle;
    }

    @NotNull
    public final InputFieldIndicatorStyle getIndicatorStyle() {
        return this.indicatorStyle;
    }

    @NotNull
    public final KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    @Nullable
    public final ImageStyle getLeadingIconStyle() {
        return this.leadingIconStyle;
    }

    @NotNull
    public final TextStyle getPlaceholderStyle() {
        return this.placeholderStyle;
    }

    @NotNull
    public final String getPlaceholderText() {
        return this.placeholderText;
    }

    @Nullable
    public final Integer getPlaceholderTextId() {
        return this.placeholderTextId;
    }

    @NotNull
    public final TextStyle getTextStyle() {
        return this.textStyle;
    }

    @Nullable
    public final ImageStyle getTrailingIconStyle() {
        return this.trailingIconStyle;
    }

    public int hashCode() {
        int hashCode = ((this.textStyle.hashCode() * 31) + this.placeholderText.hashCode()) * 31;
        Integer num = this.placeholderTextId;
        int i11 = 0;
        int hashCode2 = (((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.placeholderStyle.hashCode()) * 31) + this.containerStyle.hashCode()) * 31) + this.indicatorStyle.hashCode()) * 31;
        ImageStyle imageStyle = this.leadingIconStyle;
        int hashCode3 = (hashCode2 + (imageStyle == null ? 0 : imageStyle.hashCode())) * 31;
        ImageStyle imageStyle2 = this.trailingIconStyle;
        int hashCode4 = (hashCode3 + (imageStyle2 == null ? 0 : imageStyle2.hashCode())) * 31;
        CursorStyle cursorStyle2 = this.cursorStyle;
        if (cursorStyle2 != null) {
            i11 = cursorStyle2.hashCode();
        }
        return ((hashCode4 + i11) * 31) + this.keyboardOptions.hashCode();
    }

    public final void setPlaceholderText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.placeholderText = str;
    }

    public final void setPlaceholderTextId(@Nullable Integer num) {
        this.placeholderTextId = num;
    }

    @NotNull
    public String toString() {
        TextStyle textStyle2 = this.textStyle;
        String str = this.placeholderText;
        Integer num = this.placeholderTextId;
        TextStyle textStyle3 = this.placeholderStyle;
        ContainerStyle containerStyle2 = this.containerStyle;
        InputFieldIndicatorStyle inputFieldIndicatorStyle = this.indicatorStyle;
        ImageStyle imageStyle = this.leadingIconStyle;
        ImageStyle imageStyle2 = this.trailingIconStyle;
        CursorStyle cursorStyle2 = this.cursorStyle;
        KeyboardOptions keyboardOptions2 = this.keyboardOptions;
        return "InputFieldStyle(textStyle=" + textStyle2 + ", placeholderText=" + str + ", placeholderTextId=" + num + ", placeholderStyle=" + textStyle3 + ", containerStyle=" + containerStyle2 + ", indicatorStyle=" + inputFieldIndicatorStyle + ", leadingIconStyle=" + imageStyle + ", trailingIconStyle=" + imageStyle2 + ", cursorStyle=" + cursorStyle2 + ", keyboardOptions=" + keyboardOptions2 + ")";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.checkout.frames.style.component.base.InputFieldIndicatorStyle$Border} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: com.checkout.frames.style.component.base.InputFieldIndicatorStyle$Border} */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InputFieldStyle(com.checkout.frames.style.component.base.TextStyle r24, java.lang.String r25, java.lang.Integer r26, com.checkout.frames.style.component.base.TextStyle r27, com.checkout.frames.style.component.base.ContainerStyle r28, com.checkout.frames.style.component.base.InputFieldIndicatorStyle r29, com.checkout.frames.style.component.base.ImageStyle r30, com.checkout.frames.style.component.base.ImageStyle r31, com.checkout.frames.style.component.base.CursorStyle r32, androidx.compose.foundation.text.KeyboardOptions r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r23 = this;
            r0 = r34
            r1 = r0 & 1
            if (r1 == 0) goto L_0x001a
            com.checkout.frames.style.component.base.TextStyle r1 = new com.checkout.frames.style.component.base.TextStyle
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 511(0x1ff, float:7.16E-43)
            r14 = 0
            r2 = r1
            r2.<init>(r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x001c
        L_0x001a:
            r1 = r24
        L_0x001c:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0023
            java.lang.String r2 = ""
            goto L_0x0025
        L_0x0023:
            r2 = r25
        L_0x0025:
            r3 = r0 & 4
            r4 = 0
            if (r3 == 0) goto L_0x002c
            r3 = r4
            goto L_0x002e
        L_0x002c:
            r3 = r26
        L_0x002e:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0048
            com.checkout.frames.style.component.base.TextStyle r5 = new com.checkout.frames.style.component.base.TextStyle
            r7 = 0
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 511(0x1ff, float:7.16E-43)
            r18 = 0
            r6 = r5
            r6.<init>(r7, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x004a
        L_0x0048:
            r5 = r27
        L_0x004a:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0063
            com.checkout.frames.style.component.base.ContainerStyle r6 = new com.checkout.frames.style.component.base.ContainerStyle
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 255(0xff, float:3.57E-43)
            r18 = 0
            r7 = r6
            r7.<init>(r8, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x0065
        L_0x0063:
            r6 = r28
        L_0x0065:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0080
            com.checkout.frames.style.component.base.InputFieldIndicatorStyle$Border r7 = new com.checkout.frames.style.component.base.InputFieldIndicatorStyle$Border
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r21 = 255(0xff, float:3.57E-43)
            r22 = 0
            r8 = r7
            r8.<init>(r9, r10, r11, r12, r13, r15, r17, r19, r21, r22)
            goto L_0x0082
        L_0x0080:
            r7 = r29
        L_0x0082:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0088
            r8 = r4
            goto L_0x008a
        L_0x0088:
            r8 = r30
        L_0x008a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0090
            r9 = r4
            goto L_0x0092
        L_0x0090:
            r9 = r31
        L_0x0092:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0097
            goto L_0x0099
        L_0x0097:
            r4 = r32
        L_0x0099:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x00a4
            androidx.compose.foundation.text.KeyboardOptions$Companion r0 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r0 = r0.getDefault()
            goto L_0x00a6
        L_0x00a4:
            r0 = r33
        L_0x00a6:
            r24 = r23
            r25 = r1
            r26 = r2
            r27 = r3
            r28 = r5
            r29 = r6
            r30 = r7
            r31 = r8
            r32 = r9
            r33 = r4
            r34 = r0
            r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputFieldStyle.<init>(com.checkout.frames.style.component.base.TextStyle, java.lang.String, java.lang.Integer, com.checkout.frames.style.component.base.TextStyle, com.checkout.frames.style.component.base.ContainerStyle, com.checkout.frames.style.component.base.InputFieldIndicatorStyle, com.checkout.frames.style.component.base.ImageStyle, com.checkout.frames.style.component.base.ImageStyle, com.checkout.frames.style.component.base.CursorStyle, androidx.compose.foundation.text.KeyboardOptions, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
