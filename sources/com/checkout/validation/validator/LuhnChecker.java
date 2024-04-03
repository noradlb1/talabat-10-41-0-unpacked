package com.checkout.validation.validator;

import com.checkout.validation.validator.contract.Checker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002¨\u0006\t"}, d2 = {"Lcom/checkout/validation/validator/LuhnChecker;", "Lcom/checkout/validation/validator/contract/Checker;", "", "()V", "check", "", "data", "checkLuhn", "number", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LuhnChecker implements Checker<String> {
    private final boolean checkLuhn(String str) {
        String obj = StringsKt___StringsKt.reversed((CharSequence) str).toString();
        int length = obj.length();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            Integer digitToIntOrNull = CharsKt__CharKt.digitToIntOrNull(obj.charAt(i13));
            if (digitToIntOrNull == null) {
                return false;
            }
            int intValue = digitToIntOrNull.intValue();
            if (i13 % 2 == 0) {
                i11 += intValue;
            } else {
                i12 += (intValue / 5) + ((intValue * 2) % 10);
            }
        }
        if ((i11 + i12) % 10 == 0) {
            return true;
        }
        return false;
    }

    public boolean check(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        return checkLuhn(str);
    }
}
