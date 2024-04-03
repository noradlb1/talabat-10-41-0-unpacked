package com.checkout.frames.style.component.billingformdetails;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.screen.billingaddress.billingaddressdetails.models.BillingFormFields;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B7\b\u0007\u0012$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ%\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J9\u0010\u0012\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/checkout/frames/style/component/billingformdetails/InputComponentsContainerStyle;", "", "inputComponentStyleValues", "Ljava/util/LinkedHashMap;", "Lcom/checkout/frames/screen/billingaddress/billingaddressdetails/models/BillingFormFields;", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "Lkotlin/collections/LinkedHashMap;", "containerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "(Ljava/util/LinkedHashMap;Lcom/checkout/frames/style/component/base/ContainerStyle;)V", "getContainerStyle", "()Lcom/checkout/frames/style/component/base/ContainerStyle;", "setContainerStyle", "(Lcom/checkout/frames/style/component/base/ContainerStyle;)V", "getInputComponentStyleValues", "()Ljava/util/LinkedHashMap;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputComponentsContainerStyle {
    public static final int $stable = 8;
    @NotNull
    private ContainerStyle containerStyle;
    @NotNull
    private final LinkedHashMap<BillingFormFields, InputComponentStyle> inputComponentStyleValues;

    @JvmOverloads
    public InputComponentsContainerStyle() {
        this((LinkedHashMap) null, (ContainerStyle) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InputComponentsContainerStyle(@NotNull LinkedHashMap<BillingFormFields, InputComponentStyle> linkedHashMap) {
        this(linkedHashMap, (ContainerStyle) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(linkedHashMap, "inputComponentStyleValues");
    }

    @JvmOverloads
    public InputComponentsContainerStyle(@NotNull LinkedHashMap<BillingFormFields, InputComponentStyle> linkedHashMap, @NotNull ContainerStyle containerStyle2) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "inputComponentStyleValues");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        this.inputComponentStyleValues = linkedHashMap;
        this.containerStyle = containerStyle2;
    }

    public static /* synthetic */ InputComponentsContainerStyle copy$default(InputComponentsContainerStyle inputComponentsContainerStyle, LinkedHashMap<BillingFormFields, InputComponentStyle> linkedHashMap, ContainerStyle containerStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            linkedHashMap = inputComponentsContainerStyle.inputComponentStyleValues;
        }
        if ((i11 & 2) != 0) {
            containerStyle2 = inputComponentsContainerStyle.containerStyle;
        }
        return inputComponentsContainerStyle.copy(linkedHashMap, containerStyle2);
    }

    @NotNull
    public final LinkedHashMap<BillingFormFields, InputComponentStyle> component1() {
        return this.inputComponentStyleValues;
    }

    @NotNull
    public final ContainerStyle component2() {
        return this.containerStyle;
    }

    @NotNull
    public final InputComponentsContainerStyle copy(@NotNull LinkedHashMap<BillingFormFields, InputComponentStyle> linkedHashMap, @NotNull ContainerStyle containerStyle2) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "inputComponentStyleValues");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        return new InputComponentsContainerStyle(linkedHashMap, containerStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputComponentsContainerStyle)) {
            return false;
        }
        InputComponentsContainerStyle inputComponentsContainerStyle = (InputComponentsContainerStyle) obj;
        return Intrinsics.areEqual((Object) this.inputComponentStyleValues, (Object) inputComponentsContainerStyle.inputComponentStyleValues) && Intrinsics.areEqual((Object) this.containerStyle, (Object) inputComponentsContainerStyle.containerStyle);
    }

    @NotNull
    public final ContainerStyle getContainerStyle() {
        return this.containerStyle;
    }

    @NotNull
    public final LinkedHashMap<BillingFormFields, InputComponentStyle> getInputComponentStyleValues() {
        return this.inputComponentStyleValues;
    }

    public int hashCode() {
        return (this.inputComponentStyleValues.hashCode() * 31) + this.containerStyle.hashCode();
    }

    public final void setContainerStyle(@NotNull ContainerStyle containerStyle2) {
        Intrinsics.checkNotNullParameter(containerStyle2, "<set-?>");
        this.containerStyle = containerStyle2;
    }

    @NotNull
    public String toString() {
        LinkedHashMap<BillingFormFields, InputComponentStyle> linkedHashMap = this.inputComponentStyleValues;
        ContainerStyle containerStyle2 = this.containerStyle;
        return "InputComponentsContainerStyle(inputComponentStyleValues=" + linkedHashMap + ", containerStyle=" + containerStyle2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InputComponentsContainerStyle(java.util.LinkedHashMap r15, com.checkout.frames.style.component.base.ContainerStyle r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r14 = this;
            r0 = r17 & 1
            if (r0 == 0) goto L_0x000a
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            goto L_0x000b
        L_0x000a:
            r0 = r15
        L_0x000b:
            r1 = r17 & 2
            if (r1 == 0) goto L_0x0023
            com.checkout.frames.style.component.base.ContainerStyle r1 = new com.checkout.frames.style.component.base.ContainerStyle
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 255(0xff, float:3.57E-43)
            r13 = 0
            r2 = r1
            r2.<init>(r3, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r2 = r14
            goto L_0x0026
        L_0x0023:
            r2 = r14
            r1 = r16
        L_0x0026:
            r14.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.billingformdetails.InputComponentsContainerStyle.<init>(java.util.LinkedHashMap, com.checkout.frames.style.component.base.ContainerStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
