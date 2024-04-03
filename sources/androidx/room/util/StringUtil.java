package androidx.room.util;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import net.bytebuddy.description.type.TypeDescription;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    private StringUtil() {
    }

    public static void appendPlaceholders(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            sb2.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
            if (i12 < i11 - 1) {
                sb2.append(",");
            }
        }
    }

    @Nullable
    public static String joinIntoString(@Nullable List<Integer> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        if (size == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < size; i11++) {
            sb2.append(Integer.toString(list.get(i11).intValue()));
            if (i11 < size - 1) {
                sb2.append(",");
            }
        }
        return sb2.toString();
    }

    public static StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    @Nullable
    public static List<Integer> splitToIntList(@Nullable String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreElements()) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
            } catch (NumberFormatException e11) {
                Log.e("ROOM", "Malformed integer list", e11);
            }
        }
        return arrayList;
    }
}
