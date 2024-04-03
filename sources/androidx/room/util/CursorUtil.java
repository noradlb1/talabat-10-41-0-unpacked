package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class CursorUtil {
    private CursorUtil() {
    }

    @VisibleForTesting(otherwise = 2)
    public static int a(String[] strArr, String str) {
        String str2 = RealDiscoveryConfigurationRepository.VERSION_DELIMETER + str;
        String str3 = RealDiscoveryConfigurationRepository.VERSION_DELIMETER + str + "`";
        for (int i11 = 0; i11 < strArr.length; i11++) {
            String str4 = strArr[i11];
            if (str4.length() >= str.length() + 2) {
                if (str4.endsWith(str2)) {
                    return i11;
                }
                if (str4.charAt(0) == '`' && str4.endsWith(str3)) {
                    return i11;
                }
            }
        }
        return -1;
    }

    @NonNull
    public static Cursor copyAndClose(@NonNull Cursor cursor) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                for (int i11 = 0; i11 < cursor.getColumnCount(); i11++) {
                    int type = cursor.getType(i11);
                    if (type == 0) {
                        objArr[i11] = null;
                    } else if (type == 1) {
                        objArr[i11] = Long.valueOf(cursor.getLong(i11));
                    } else if (type == 2) {
                        objArr[i11] = Double.valueOf(cursor.getDouble(i11));
                    } else if (type == 3) {
                        objArr[i11] = cursor.getString(i11);
                    } else if (type == 4) {
                        objArr[i11] = cursor.getBlob(i11);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        } finally {
            cursor.close();
        }
    }

    private static int findColumnIndexBySuffix(@NonNull Cursor cursor, @NonNull String str) {
        if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
            return a(cursor.getColumnNames(), str);
        }
        return -1;
    }

    public static int getColumnIndex(@NonNull Cursor cursor, @NonNull String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex("`" + str + "`");
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        return findColumnIndexBySuffix(cursor, str);
    }

    public static int getColumnIndexOrThrow(@NonNull Cursor cursor, @NonNull String str) {
        String str2;
        int columnIndex = getColumnIndex(cursor, str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            str2 = Arrays.toString(cursor.getColumnNames());
        } catch (Exception unused) {
            str2 = "";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }
}
