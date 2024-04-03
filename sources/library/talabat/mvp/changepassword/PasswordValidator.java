package library.talabat.mvp.changepassword;

import java.lang.Character;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\f\u0010\u0007\u001a\u00020\u0004*\u00020\u0006H\u0002J\f\u0010\b\u001a\u00020\u0004*\u00020\u0006H\u0002J\f\u0010\t\u001a\u00020\u0004*\u00020\u0006H\u0002J\f\u0010\n\u001a\u00020\u0004*\u00020\u0006H\u0002J\f\u0010\u000b\u001a\u00020\u0004*\u00020\u0006H\u0002J\f\u0010\f\u001a\u00020\u0004*\u00020\u0006H\u0002¨\u0006\r"}, d2 = {"Llibrary/talabat/mvp/changepassword/PasswordValidator;", "Llibrary/talabat/mvp/changepassword/Validator;", "()V", "validate", "", "value", "", "containsDigit", "containsLowerCaseCharacter", "containsNonBasicLatinCharacter", "containsSpecialCharacter", "containsUpperCaseCharacter", "isLengthValid", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PasswordValidator implements Validator {
    private final boolean containsDigit(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (Character.isDigit(str.charAt(i11))) {
                return true;
            }
        }
        return false;
    }

    private final boolean containsLowerCaseCharacter(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (Character.isLowerCase(str.charAt(i11))) {
                return true;
            }
        }
        return false;
    }

    private final boolean containsNonBasicLatinCharacter(String str) {
        boolean z11;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (Character.isDigit(charAt) || Intrinsics.areEqual((Object) Character.UnicodeBlock.of(charAt), (Object) Character.UnicodeBlock.BASIC_LATIN)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    private final boolean containsSpecialCharacter(String str) {
        boolean z11;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (Character.isLetterOrDigit(charAt) || CharsKt__CharJVMKt.isWhitespace(charAt)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    private final boolean containsUpperCaseCharacter(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (Character.isUpperCase(str.charAt(i11))) {
                return true;
            }
        }
        return false;
    }

    private final boolean isLengthValid(String str) {
        return str.length() >= 8;
    }

    public boolean validate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        if (!isLengthValid(str) || !containsDigit(str) || !containsSpecialCharacter(str)) {
            return false;
        }
        if (!containsNonBasicLatinCharacter(str) && (!containsUpperCaseCharacter(str) || !containsLowerCaseCharacter(str))) {
            return false;
        }
        return true;
    }
}
