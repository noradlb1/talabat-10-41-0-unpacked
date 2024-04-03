package com.checkout.frames.model;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B7\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/checkout/frames/model/ButtonElevation;", "", "elevation", "", "(I)V", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "(IIIII)V", "getDefaultElevation", "()I", "getDisabledElevation", "getFocusedElevation", "getHoveredElevation", "getPressedElevation", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ButtonElevation {
    public static final int $stable = 0;
    private final int defaultElevation;
    private final int disabledElevation;
    private final int focusedElevation;
    private final int hoveredElevation;
    private final int pressedElevation;

    public ButtonElevation() {
        this(0, 0, 0, 0, 0, 31, (DefaultConstructorMarker) null);
    }

    public ButtonElevation(int i11, int i12, int i13, int i14, int i15) {
        this.defaultElevation = i11;
        this.pressedElevation = i12;
        this.focusedElevation = i13;
        this.hoveredElevation = i14;
        this.disabledElevation = i15;
    }

    public static /* synthetic */ ButtonElevation copy$default(ButtonElevation buttonElevation, int i11, int i12, int i13, int i14, int i15, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i11 = buttonElevation.defaultElevation;
        }
        if ((i16 & 2) != 0) {
            i12 = buttonElevation.pressedElevation;
        }
        int i17 = i12;
        if ((i16 & 4) != 0) {
            i13 = buttonElevation.focusedElevation;
        }
        int i18 = i13;
        if ((i16 & 8) != 0) {
            i14 = buttonElevation.hoveredElevation;
        }
        int i19 = i14;
        if ((i16 & 16) != 0) {
            i15 = buttonElevation.disabledElevation;
        }
        return buttonElevation.copy(i11, i17, i18, i19, i15);
    }

    public final int component1() {
        return this.defaultElevation;
    }

    public final int component2() {
        return this.pressedElevation;
    }

    public final int component3() {
        return this.focusedElevation;
    }

    public final int component4() {
        return this.hoveredElevation;
    }

    public final int component5() {
        return this.disabledElevation;
    }

    @NotNull
    public final ButtonElevation copy(int i11, int i12, int i13, int i14, int i15) {
        return new ButtonElevation(i11, i12, i13, i14, i15);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonElevation)) {
            return false;
        }
        ButtonElevation buttonElevation = (ButtonElevation) obj;
        return this.defaultElevation == buttonElevation.defaultElevation && this.pressedElevation == buttonElevation.pressedElevation && this.focusedElevation == buttonElevation.focusedElevation && this.hoveredElevation == buttonElevation.hoveredElevation && this.disabledElevation == buttonElevation.disabledElevation;
    }

    public final int getDefaultElevation() {
        return this.defaultElevation;
    }

    public final int getDisabledElevation() {
        return this.disabledElevation;
    }

    public final int getFocusedElevation() {
        return this.focusedElevation;
    }

    public final int getHoveredElevation() {
        return this.hoveredElevation;
    }

    public final int getPressedElevation() {
        return this.pressedElevation;
    }

    public int hashCode() {
        return (((((((this.defaultElevation * 31) + this.pressedElevation) * 31) + this.focusedElevation) * 31) + this.hoveredElevation) * 31) + this.disabledElevation;
    }

    @NotNull
    public String toString() {
        int i11 = this.defaultElevation;
        int i12 = this.pressedElevation;
        int i13 = this.focusedElevation;
        int i14 = this.hoveredElevation;
        int i15 = this.disabledElevation;
        return "ButtonElevation(defaultElevation=" + i11 + ", pressedElevation=" + i12 + ", focusedElevation=" + i13 + ", hoveredElevation=" + i14 + ", disabledElevation=" + i15 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ButtonElevation(int r5, int r6, int r7, int r8, int r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.model.ButtonElevation.<init>(int, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public ButtonElevation(int i11) {
        this(i11, i11, i11, i11, i11);
    }
}
