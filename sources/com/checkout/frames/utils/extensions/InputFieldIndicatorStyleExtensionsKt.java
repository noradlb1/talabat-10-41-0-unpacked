package com.checkout.frames.utils.extensions;

import com.checkout.frames.style.component.base.InputFieldIndicatorStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0006"}, d2 = {"disabledIndicatorColor", "", "Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;", "errorIndicatorColor", "focusedIndicatorColor", "unfocusedIndicatorColor", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class InputFieldIndicatorStyleExtensionsKt {
    public static final long disabledIndicatorColor(@NotNull InputFieldIndicatorStyle inputFieldIndicatorStyle) {
        Intrinsics.checkNotNullParameter(inputFieldIndicatorStyle, "<this>");
        if (inputFieldIndicatorStyle instanceof InputFieldIndicatorStyle.Underline) {
            return ((InputFieldIndicatorStyle.Underline) inputFieldIndicatorStyle).getDisabledUnderlineColor();
        }
        if (inputFieldIndicatorStyle instanceof InputFieldIndicatorStyle.Border) {
            return ((InputFieldIndicatorStyle.Border) inputFieldIndicatorStyle).getDisabledBorderColor();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final long errorIndicatorColor(@NotNull InputFieldIndicatorStyle inputFieldIndicatorStyle) {
        Intrinsics.checkNotNullParameter(inputFieldIndicatorStyle, "<this>");
        if (inputFieldIndicatorStyle instanceof InputFieldIndicatorStyle.Underline) {
            return ((InputFieldIndicatorStyle.Underline) inputFieldIndicatorStyle).getErrorUnderlineColor();
        }
        if (inputFieldIndicatorStyle instanceof InputFieldIndicatorStyle.Border) {
            return ((InputFieldIndicatorStyle.Border) inputFieldIndicatorStyle).getErrorBorderColor();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final long focusedIndicatorColor(@NotNull InputFieldIndicatorStyle inputFieldIndicatorStyle) {
        Intrinsics.checkNotNullParameter(inputFieldIndicatorStyle, "<this>");
        if (inputFieldIndicatorStyle instanceof InputFieldIndicatorStyle.Underline) {
            return ((InputFieldIndicatorStyle.Underline) inputFieldIndicatorStyle).getFocusedUnderlineColor();
        }
        if (inputFieldIndicatorStyle instanceof InputFieldIndicatorStyle.Border) {
            return ((InputFieldIndicatorStyle.Border) inputFieldIndicatorStyle).getFocusedBorderColor();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final long unfocusedIndicatorColor(@NotNull InputFieldIndicatorStyle inputFieldIndicatorStyle) {
        Intrinsics.checkNotNullParameter(inputFieldIndicatorStyle, "<this>");
        if (inputFieldIndicatorStyle instanceof InputFieldIndicatorStyle.Underline) {
            return ((InputFieldIndicatorStyle.Underline) inputFieldIndicatorStyle).getUnfocusedUnderlineColor();
        }
        if (inputFieldIndicatorStyle instanceof InputFieldIndicatorStyle.Border) {
            return ((InputFieldIndicatorStyle.Border) inputFieldIndicatorStyle).getUnfocusedBorderColor();
        }
        throw new NoWhenBranchMatchedException();
    }
}
