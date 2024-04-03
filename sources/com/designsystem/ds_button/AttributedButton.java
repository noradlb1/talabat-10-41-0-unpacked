package com.designsystem.ds_button;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/designsystem/ds_button/AttributedButton;", "", "backgroundColor", "", "textColor", "borderColor", "(III)V", "getBackgroundColor", "()I", "getBorderColor", "getTextColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Deprecated(message = "This class has been replaced by buttons from package 'com.designsystem.ds_button_v2'")
public final class AttributedButton {
    public static final int $stable = 0;
    private final int backgroundColor;
    private final int borderColor;
    private final int textColor;

    public AttributedButton(int i11, int i12, int i13) {
        this.backgroundColor = i11;
        this.textColor = i12;
        this.borderColor = i13;
    }

    public static /* synthetic */ AttributedButton copy$default(AttributedButton attributedButton, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = attributedButton.backgroundColor;
        }
        if ((i14 & 2) != 0) {
            i12 = attributedButton.textColor;
        }
        if ((i14 & 4) != 0) {
            i13 = attributedButton.borderColor;
        }
        return attributedButton.copy(i11, i12, i13);
    }

    public final int component1() {
        return this.backgroundColor;
    }

    public final int component2() {
        return this.textColor;
    }

    public final int component3() {
        return this.borderColor;
    }

    @NotNull
    public final AttributedButton copy(int i11, int i12, int i13) {
        return new AttributedButton(i11, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AttributedButton)) {
            return false;
        }
        AttributedButton attributedButton = (AttributedButton) obj;
        return this.backgroundColor == attributedButton.backgroundColor && this.textColor == attributedButton.textColor && this.borderColor == attributedButton.borderColor;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public int hashCode() {
        return (((this.backgroundColor * 31) + this.textColor) * 31) + this.borderColor;
    }

    @NotNull
    public String toString() {
        return "AttributedButton(backgroundColor=" + this.backgroundColor + ", textColor=" + this.textColor + ", borderColor=" + this.borderColor + ')';
    }
}
