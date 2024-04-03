package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/codeless/internal/SensitiveUserDataUtils;", "", "()V", "isCreditCard", "", "view", "Landroid/widget/TextView;", "isEmail", "isPassword", "isPersonName", "isPhoneNumber", "isPostalAddress", "isSensitiveUserData", "Landroid/view/View;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class SensitiveUserDataUtils {
    @NotNull
    public static final SensitiveUserDataUtils INSTANCE = new SensitiveUserDataUtils();

    private SensitiveUserDataUtils() {
    }

    private final boolean isCreditCard(TextView textView) {
        int i11;
        String replace = new Regex("\\s").replace((CharSequence) ViewHierarchy.getTextOfView(textView), "");
        int length = replace.length();
        if (length < 12 || length > 19) {
            return false;
        }
        int i12 = length - 1;
        if (i12 >= 0) {
            boolean z11 = false;
            i11 = 0;
            while (true) {
                int i13 = i12 - 1;
                char charAt = replace.charAt(i12);
                if (!Character.isDigit(charAt)) {
                    return false;
                }
                int digitToInt = CharsKt__CharKt.digitToInt(charAt);
                if (z11 && (digitToInt = digitToInt * 2) > 9) {
                    digitToInt = (digitToInt % 10) + 1;
                }
                i11 += digitToInt;
                z11 = !z11;
                if (i13 < 0) {
                    break;
                }
                i12 = i13;
            }
        } else {
            i11 = 0;
        }
        if (i11 % 10 == 0) {
            return true;
        }
        return false;
    }

    private final boolean isEmail(TextView textView) {
        boolean z11 = true;
        if (textView.getInputType() == 32) {
            return true;
        }
        String textOfView = ViewHierarchy.getTextOfView(textView);
        if (textOfView == null) {
            return false;
        }
        if (textOfView.length() != 0) {
            z11 = false;
        }
        if (z11) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(textOfView).matches();
    }

    private final boolean isPassword(TextView textView) {
        if (textView.getInputType() == 128) {
            return true;
        }
        return textView.getTransformationMethod() instanceof PasswordTransformationMethod;
    }

    private final boolean isPersonName(TextView textView) {
        return textView.getInputType() == 96;
    }

    private final boolean isPhoneNumber(TextView textView) {
        return textView.getInputType() == 3;
    }

    private final boolean isPostalAddress(TextView textView) {
        return textView.getInputType() == 112;
    }

    @JvmStatic
    public static final boolean isSensitiveUserData(@Nullable View view) {
        if (!(view instanceof TextView)) {
            return false;
        }
        SensitiveUserDataUtils sensitiveUserDataUtils = INSTANCE;
        TextView textView = (TextView) view;
        if (sensitiveUserDataUtils.isPassword(textView) || sensitiveUserDataUtils.isCreditCard(textView) || sensitiveUserDataUtils.isPersonName(textView) || sensitiveUserDataUtils.isPostalAddress(textView) || sensitiveUserDataUtils.isPhoneNumber(textView) || sensitiveUserDataUtils.isEmail(textView)) {
            return true;
        }
        return false;
    }
}
