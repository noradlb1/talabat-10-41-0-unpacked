package com.checkout.frames.style.component;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.style.component.base.InputComponentStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/checkout/frames/style/component/ExpiryDateComponentStyle;", "", "inputStyle", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "(Lcom/checkout/frames/style/component/base/InputComponentStyle;)V", "getInputStyle", "()Lcom/checkout/frames/style/component/base/InputComponentStyle;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExpiryDateComponentStyle {
    public static final int $stable = 8;
    @NotNull
    private final InputComponentStyle inputStyle;

    public ExpiryDateComponentStyle(@NotNull InputComponentStyle inputComponentStyle) {
        Intrinsics.checkNotNullParameter(inputComponentStyle, "inputStyle");
        this.inputStyle = inputComponentStyle;
    }

    public static /* synthetic */ ExpiryDateComponentStyle copy$default(ExpiryDateComponentStyle expiryDateComponentStyle, InputComponentStyle inputComponentStyle, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            inputComponentStyle = expiryDateComponentStyle.inputStyle;
        }
        return expiryDateComponentStyle.copy(inputComponentStyle);
    }

    @NotNull
    public final InputComponentStyle component1() {
        return this.inputStyle;
    }

    @NotNull
    public final ExpiryDateComponentStyle copy(@NotNull InputComponentStyle inputComponentStyle) {
        Intrinsics.checkNotNullParameter(inputComponentStyle, "inputStyle");
        return new ExpiryDateComponentStyle(inputComponentStyle);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ExpiryDateComponentStyle) && Intrinsics.areEqual((Object) this.inputStyle, (Object) ((ExpiryDateComponentStyle) obj).inputStyle);
    }

    @NotNull
    public final InputComponentStyle getInputStyle() {
        return this.inputStyle;
    }

    public int hashCode() {
        return this.inputStyle.hashCode();
    }

    @NotNull
    public String toString() {
        InputComponentStyle inputComponentStyle = this.inputStyle;
        return "ExpiryDateComponentStyle(inputStyle=" + inputComponentStyle + ")";
    }
}
