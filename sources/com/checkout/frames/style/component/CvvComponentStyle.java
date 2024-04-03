package com.checkout.frames.style.component;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/checkout/frames/style/component/CvvComponentStyle;", "", "inputStyle", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "(Lcom/checkout/frames/style/component/base/InputComponentStyle;)V", "getInputStyle", "()Lcom/checkout/frames/style/component/base/InputComponentStyle;", "setInputStyle", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CvvComponentStyle {
    public static final int $stable = 8;
    @NotNull
    private InputComponentStyle inputStyle;

    public CvvComponentStyle() {
        this((InputComponentStyle) null, 1, (DefaultConstructorMarker) null);
    }

    public CvvComponentStyle(@NotNull InputComponentStyle inputComponentStyle) {
        Intrinsics.checkNotNullParameter(inputComponentStyle, "inputStyle");
        this.inputStyle = inputComponentStyle;
    }

    public static /* synthetic */ CvvComponentStyle copy$default(CvvComponentStyle cvvComponentStyle, InputComponentStyle inputComponentStyle, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            inputComponentStyle = cvvComponentStyle.inputStyle;
        }
        return cvvComponentStyle.copy(inputComponentStyle);
    }

    @NotNull
    public final InputComponentStyle component1() {
        return this.inputStyle;
    }

    @NotNull
    public final CvvComponentStyle copy(@NotNull InputComponentStyle inputComponentStyle) {
        Intrinsics.checkNotNullParameter(inputComponentStyle, "inputStyle");
        return new CvvComponentStyle(inputComponentStyle);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CvvComponentStyle) && Intrinsics.areEqual((Object) this.inputStyle, (Object) ((CvvComponentStyle) obj).inputStyle);
    }

    @NotNull
    public final InputComponentStyle getInputStyle() {
        return this.inputStyle;
    }

    public int hashCode() {
        return this.inputStyle.hashCode();
    }

    public final void setInputStyle(@NotNull InputComponentStyle inputComponentStyle) {
        Intrinsics.checkNotNullParameter(inputComponentStyle, "<set-?>");
        this.inputStyle = inputComponentStyle;
    }

    @NotNull
    public String toString() {
        InputComponentStyle inputComponentStyle = this.inputStyle;
        return "CvvComponentStyle(inputStyle=" + inputComponentStyle + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CvvComponentStyle(InputComponentStyle inputComponentStyle, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new InputComponentStyle((TextLabelStyle) null, (TextLabelStyle) null, (TextLabelStyle) null, (InputFieldStyle) null, (TextLabelStyle) null, (ContainerStyle) null, false, 127, (DefaultConstructorMarker) null) : inputComponentStyle);
    }
}
