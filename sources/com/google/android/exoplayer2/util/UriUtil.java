package com.google.android.exoplayer2.util;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;

public final class UriUtil {
    private static final int FRAGMENT = 3;
    private static final int INDEX_COUNT = 4;
    private static final int PATH = 1;
    private static final int QUERY = 2;
    private static final int SCHEME_COLON = 0;

    private UriUtil() {
    }

    private static int[] getUriIndices(String str) {
        boolean z11;
        int i11;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i12 = indexOf4 + 2;
        if (i12 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i12) == '/') {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = str.indexOf(47, indexOf4 + 3);
            if (i11 == -1 || i11 > indexOf2) {
                i11 = indexOf2;
            }
        } else {
            i11 = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i11;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }

    public static boolean isAbsolute(@Nullable String str) {
        return (str == null || getUriIndices(str)[0] == -1) ? false : true;
    }

    private static String removeDotSegments(StringBuilder sb2, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        if (i11 >= i12) {
            return sb2.toString();
        }
        if (sb2.charAt(i11) == '/') {
            i11++;
        }
        int i16 = i11;
        int i17 = i16;
        while (i16 <= i12) {
            if (i16 == i12) {
                i13 = i16;
            } else if (sb2.charAt(i16) == '/') {
                i13 = i16 + 1;
            } else {
                i16++;
            }
            int i18 = i17 + 1;
            if (i16 == i18 && sb2.charAt(i17) == '.') {
                sb2.delete(i17, i13);
                i12 -= i13 - i17;
            } else {
                if (i16 == i17 + 2 && sb2.charAt(i17) == '.' && sb2.charAt(i18) == '.') {
                    i14 = sb2.lastIndexOf("/", i17 - 2) + 1;
                    if (i14 > i11) {
                        i15 = i14;
                    } else {
                        i15 = i11;
                    }
                    sb2.delete(i15, i13);
                    i12 -= i13 - i15;
                } else {
                    i14 = i16 + 1;
                }
                i17 = i14;
            }
            i16 = i17;
        }
        return sb2.toString();
    }

    public static Uri removeQueryParameter(Uri uri, String str) {
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.clearQuery();
        for (String next : uri.getQueryParameterNames()) {
            if (!next.equals(str)) {
                for (String appendQueryParameter : uri.getQueryParameters(next)) {
                    buildUpon.appendQueryParameter(next, appendQueryParameter);
                }
            }
        }
        return buildUpon.build();
    }

    public static String resolve(@Nullable String str, @Nullable String str2) {
        int i11;
        StringBuilder sb2 = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] uriIndices = getUriIndices(str2);
        if (uriIndices[0] != -1) {
            sb2.append(str2);
            removeDotSegments(sb2, uriIndices[1], uriIndices[2]);
            return sb2.toString();
        }
        int[] uriIndices2 = getUriIndices(str);
        if (uriIndices[3] == 0) {
            sb2.append(str, 0, uriIndices2[3]);
            sb2.append(str2);
            return sb2.toString();
        } else if (uriIndices[2] == 0) {
            sb2.append(str, 0, uriIndices2[2]);
            sb2.append(str2);
            return sb2.toString();
        } else {
            int i12 = uriIndices[1];
            if (i12 != 0) {
                int i13 = uriIndices2[0] + 1;
                sb2.append(str, 0, i13);
                sb2.append(str2);
                return removeDotSegments(sb2, uriIndices[1] + i13, i13 + uriIndices[2]);
            } else if (str2.charAt(i12) == '/') {
                sb2.append(str, 0, uriIndices2[1]);
                sb2.append(str2);
                int i14 = uriIndices2[1];
                return removeDotSegments(sb2, i14, uriIndices[2] + i14);
            } else {
                int i15 = uriIndices2[0] + 2;
                int i16 = uriIndices2[1];
                if (i15 >= i16 || i16 != uriIndices2[2]) {
                    int lastIndexOf = str.lastIndexOf(47, uriIndices2[2] - 1);
                    if (lastIndexOf == -1) {
                        i11 = uriIndices2[1];
                    } else {
                        i11 = lastIndexOf + 1;
                    }
                    sb2.append(str, 0, i11);
                    sb2.append(str2);
                    return removeDotSegments(sb2, uriIndices2[1], i11 + uriIndices[2]);
                }
                sb2.append(str, 0, i16);
                sb2.append('/');
                sb2.append(str2);
                int i17 = uriIndices2[1];
                return removeDotSegments(sb2, i17, uriIndices[2] + i17 + 1);
            }
        }
    }

    public static Uri resolveToUri(@Nullable String str, @Nullable String str2) {
        return Uri.parse(resolve(str, str2));
    }
}
