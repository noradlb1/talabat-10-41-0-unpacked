package org.apache.commons.lang3;

import com.talabat.userandlocation.compliance.status.data.impl.UserStatusRepositoryImplKt;
import kotlinx.coroutines.DebugKt;
import org.apache.commons.lang3.math.NumberUtils;

public class BooleanUtils {
    public static boolean and(boolean... zArr) {
        if (zArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (zArr.length != 0) {
            for (boolean z11 : zArr) {
                if (!z11) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalArgumentException("Array is empty");
        }
    }

    public static boolean isFalse(Boolean bool) {
        return Boolean.FALSE.equals(bool);
    }

    public static boolean isNotFalse(Boolean bool) {
        return !isFalse(bool);
    }

    public static boolean isNotTrue(Boolean bool) {
        return !isTrue(bool);
    }

    public static boolean isTrue(Boolean bool) {
        return Boolean.TRUE.equals(bool);
    }

    public static Boolean negate(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
    }

    public static boolean or(boolean... zArr) {
        if (zArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (zArr.length != 0) {
            for (boolean z11 : zArr) {
                if (z11) {
                    return true;
                }
            }
            return false;
        } else {
            throw new IllegalArgumentException("Array is empty");
        }
    }

    public static boolean toBoolean(int i11) {
        return i11 != 0;
    }

    public static boolean toBoolean(Boolean bool) {
        return bool != null && bool.booleanValue();
    }

    public static boolean toBooleanDefaultIfNull(Boolean bool, boolean z11) {
        return bool == null ? z11 : bool.booleanValue();
    }

    public static Boolean toBooleanObject(int i11) {
        return i11 == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static int toInteger(Boolean bool, int i11, int i12, int i13) {
        return bool == null ? i13 : bool.booleanValue() ? i11 : i12;
    }

    public static int toInteger(boolean z11) {
        return z11 ? 1 : 0;
    }

    public static int toInteger(boolean z11, int i11, int i12) {
        return z11 ? i11 : i12;
    }

    public static Integer toIntegerObject(boolean z11) {
        return z11 ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
    }

    public static Integer toIntegerObject(boolean z11, Integer num, Integer num2) {
        return z11 ? num : num2;
    }

    public static String toString(Boolean bool, String str, String str2, String str3) {
        return bool == null ? str3 : bool.booleanValue() ? str : str2;
    }

    public static String toString(boolean z11, String str, String str2) {
        return z11 ? str : str2;
    }

    public static String toStringOnOff(Boolean bool) {
        return toString(bool, DebugKt.DEBUG_PROPERTY_VALUE_ON, DebugKt.DEBUG_PROPERTY_VALUE_OFF, (String) null);
    }

    public static String toStringTrueFalse(Boolean bool) {
        return toString(bool, "true", "false", (String) null);
    }

    public static String toStringYesNo(Boolean bool) {
        return toString(bool, UserStatusRepositoryImplKt.KEY_CALL_INVOKED, "no", (String) null);
    }

    public static boolean xor(boolean... zArr) {
        if (zArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (zArr.length != 0) {
            boolean z11 = false;
            for (boolean z12 : zArr) {
                z11 ^= z12;
            }
            return z11;
        } else {
            throw new IllegalArgumentException("Array is empty");
        }
    }

    public static boolean toBoolean(int i11, int i12, int i13) {
        if (i11 == i12) {
            return true;
        }
        if (i11 == i13) {
            return false;
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static Boolean toBooleanObject(Integer num) {
        if (num == null) {
            return null;
        }
        return num.intValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static Integer toIntegerObject(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
    }

    public static String toStringOnOff(boolean z11) {
        return toString(z11, DebugKt.DEBUG_PROPERTY_VALUE_ON, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
    }

    public static String toStringTrueFalse(boolean z11) {
        return toString(z11, "true", "false");
    }

    public static String toStringYesNo(boolean z11) {
        return toString(z11, UserStatusRepositoryImplKt.KEY_CALL_INVOKED, "no");
    }

    public static boolean toBoolean(Integer num, Integer num2, Integer num3) {
        if (num == null) {
            if (num2 == null) {
                return true;
            }
            if (num3 == null) {
                return false;
            }
        } else if (num.equals(num2)) {
            return true;
        } else {
            if (num.equals(num3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static Boolean toBooleanObject(int i11, int i12, int i13, int i14) {
        if (i11 == i12) {
            return Boolean.TRUE;
        }
        if (i11 == i13) {
            return Boolean.FALSE;
        }
        if (i11 == i14) {
            return null;
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static Integer toIntegerObject(Boolean bool, Integer num, Integer num2, Integer num3) {
        if (bool == null) {
            return num3;
        }
        return bool.booleanValue() ? num : num2;
    }

    public static Boolean and(Boolean... boolArr) {
        if (boolArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (boolArr.length != 0) {
            try {
                return and(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
            } catch (NullPointerException unused) {
                throw new IllegalArgumentException("The array must not contain any null elements");
            }
        } else {
            throw new IllegalArgumentException("Array is empty");
        }
    }

    public static Boolean or(Boolean... boolArr) {
        if (boolArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (boolArr.length != 0) {
            try {
                return or(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
            } catch (NullPointerException unused) {
                throw new IllegalArgumentException("The array must not contain any null elements");
            }
        } else {
            throw new IllegalArgumentException("Array is empty");
        }
    }

    public static Boolean xor(Boolean... boolArr) {
        if (boolArr == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (boolArr.length != 0) {
            try {
                return xor(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
            } catch (NullPointerException unused) {
                throw new IllegalArgumentException("The array must not contain any null elements");
            }
        } else {
            throw new IllegalArgumentException("Array is empty");
        }
    }

    public static boolean toBoolean(String str) {
        return toBooleanObject(str) == Boolean.TRUE;
    }

    public static Boolean toBooleanObject(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null) {
            if (num2 == null) {
                return Boolean.TRUE;
            }
            if (num3 == null) {
                return Boolean.FALSE;
            }
            if (num4 == null) {
                return null;
            }
        } else if (num.equals(num2)) {
            return Boolean.TRUE;
        } else {
            if (num.equals(num3)) {
                return Boolean.FALSE;
            }
            if (num.equals(num4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static boolean toBoolean(String str, String str2, String str3) {
        if (str == str2) {
            return true;
        }
        if (str == str3) {
            return false;
        }
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
            if (str.equals(str3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The String did not match either specified value");
    }

    public static Boolean toBooleanObject(String str) {
        String str2 = str;
        if (str2 == "true") {
            return Boolean.TRUE;
        }
        if (str2 == null) {
            return null;
        }
        int length = str.length();
        if (length == 1) {
            char charAt = str2.charAt(0);
            if (charAt == 'y' || charAt == 'Y' || charAt == 't' || charAt == 'T') {
                return Boolean.TRUE;
            }
            if (charAt == 'n' || charAt == 'N' || charAt == 'f' || charAt == 'F') {
                return Boolean.FALSE;
            }
            return null;
        } else if (length == 2) {
            char charAt2 = str2.charAt(0);
            char charAt3 = str2.charAt(1);
            if ((charAt2 == 'o' || charAt2 == 'O') && (charAt3 == 'n' || charAt3 == 'N')) {
                return Boolean.TRUE;
            }
            if (charAt2 != 'n' && charAt2 != 'N') {
                return null;
            }
            if (charAt3 == 'o' || charAt3 == 'O') {
                return Boolean.FALSE;
            }
            return null;
        } else if (length == 3) {
            char charAt4 = str2.charAt(0);
            char charAt5 = str2.charAt(1);
            char charAt6 = str2.charAt(2);
            if ((charAt4 == 'y' || charAt4 == 'Y') && ((charAt5 == 'e' || charAt5 == 'E') && (charAt6 == 's' || charAt6 == 'S'))) {
                return Boolean.TRUE;
            }
            if (charAt4 != 'o' && charAt4 != 'O') {
                return null;
            }
            if (charAt5 != 'f' && charAt5 != 'F') {
                return null;
            }
            if (charAt6 == 'f' || charAt6 == 'F') {
                return Boolean.FALSE;
            }
            return null;
        } else if (length == 4) {
            char charAt7 = str2.charAt(0);
            char charAt8 = str2.charAt(1);
            char charAt9 = str2.charAt(2);
            char charAt10 = str2.charAt(3);
            if (charAt7 != 't' && charAt7 != 'T') {
                return null;
            }
            if (charAt8 != 'r' && charAt8 != 'R') {
                return null;
            }
            if (charAt9 != 'u' && charAt9 != 'U') {
                return null;
            }
            if (charAt10 == 'e' || charAt10 == 'E') {
                return Boolean.TRUE;
            }
            return null;
        } else if (length != 5) {
            return null;
        } else {
            char charAt11 = str2.charAt(0);
            char charAt12 = str2.charAt(1);
            char charAt13 = str2.charAt(2);
            char charAt14 = str2.charAt(3);
            char charAt15 = str2.charAt(4);
            if (charAt11 != 'f' && charAt11 != 'F') {
                return null;
            }
            if (charAt12 != 'a' && charAt12 != 'A') {
                return null;
            }
            if (charAt13 != 'l' && charAt13 != 'L') {
                return null;
            }
            if (charAt14 != 's' && charAt14 != 'S') {
                return null;
            }
            if (charAt15 == 'e' || charAt15 == 'E') {
                return Boolean.FALSE;
            }
            return null;
        }
    }

    public static Boolean toBooleanObject(String str, String str2, String str3, String str4) {
        if (str == null) {
            if (str2 == null) {
                return Boolean.TRUE;
            }
            if (str3 == null) {
                return Boolean.FALSE;
            }
            if (str4 == null) {
                return null;
            }
        } else if (str.equals(str2)) {
            return Boolean.TRUE;
        } else {
            if (str.equals(str3)) {
                return Boolean.FALSE;
            }
            if (str.equals(str4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The String did not match any specified value");
    }
}
