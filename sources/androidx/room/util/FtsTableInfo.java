package androidx.room.util;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.tekartik.sqflite.Constant;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class FtsTableInfo {
    private static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    public final Set<String> columns;

    /* renamed from: name  reason: collision with root package name */
    public final String f37543name;
    public final Set<String> options;

    public FtsTableInfo(String str, Set<String> set, Set<String> set2) {
        this.f37543name = str;
        this.columns = set;
        this.options = set2;
    }

    @VisibleForTesting
    public static Set<String> a(String str) {
        if (str.isEmpty()) {
            return new HashSet();
        }
        String substring = str.substring(str.indexOf(40) + 1, str.lastIndexOf(41));
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayDeque arrayDeque = new ArrayDeque();
        int i11 = -1;
        for (int i12 = 0; i12 < substring.length(); i12++) {
            char charAt = substring.charAt(i12);
            if (!(charAt == '\"' || charAt == '\'')) {
                if (charAt != ',') {
                    if (charAt != '[') {
                        if (charAt != ']') {
                            if (charAt != '`') {
                            }
                        } else if (!arrayDeque.isEmpty() && ((Character) arrayDeque.peek()).charValue() == '[') {
                            arrayDeque.pop();
                        }
                    } else if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(charAt));
                    }
                } else if (arrayDeque.isEmpty()) {
                    arrayList.add(substring.substring(i11 + 1, i12).trim());
                    i11 = i12;
                }
            }
            if (arrayDeque.isEmpty()) {
                arrayDeque.push(Character.valueOf(charAt));
            } else if (((Character) arrayDeque.peek()).charValue() == charAt) {
                arrayDeque.pop();
            }
        }
        arrayList.add(substring.substring(i11 + 1).trim());
        HashSet hashSet = new HashSet();
        for (String str2 : arrayList) {
            for (String startsWith : FTS_OPTIONS) {
                if (str2.startsWith(startsWith)) {
                    hashSet.add(str2);
                }
            }
        }
        return hashSet;
    }

    public static FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return new FtsTableInfo(str, readColumns(supportSQLiteDatabase, str), readOptions(supportSQLiteDatabase, str));
    }

    private static Set<String> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        HashSet hashSet = new HashSet();
        try {
            if (query.getColumnCount() > 0) {
                int columnIndex = query.getColumnIndex("name");
                while (query.moveToNext()) {
                    hashSet.add(query.getString(columnIndex));
                }
            }
            return hashSet;
        } finally {
            query.close();
        }
    }

    /* JADX INFO: finally extract failed */
    private static Set<String> readOptions(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        String str2;
        Cursor query = supportSQLiteDatabase.query("SELECT * FROM sqlite_master WHERE `name` = '" + str + "'");
        try {
            if (query.moveToFirst()) {
                str2 = query.getString(query.getColumnIndexOrThrow(Constant.PARAM_SQL));
            } else {
                str2 = "";
            }
            query.close();
            return a(str2);
        } catch (Throwable th2) {
            query.close();
            throw th2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FtsTableInfo)) {
            return false;
        }
        FtsTableInfo ftsTableInfo = (FtsTableInfo) obj;
        String str = this.f37543name;
        if (str == null ? ftsTableInfo.f37543name != null : !str.equals(ftsTableInfo.f37543name)) {
            return false;
        }
        Set<String> set = this.columns;
        if (set == null ? ftsTableInfo.columns != null : !set.equals(ftsTableInfo.columns)) {
            return false;
        }
        Set<String> set2 = this.options;
        Set<String> set3 = ftsTableInfo.options;
        if (set2 != null) {
            return set2.equals(set3);
        }
        if (set3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        int i12;
        String str = this.f37543name;
        int i13 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = i11 * 31;
        Set<String> set = this.columns;
        if (set != null) {
            i12 = set.hashCode();
        } else {
            i12 = 0;
        }
        int i15 = (i14 + i12) * 31;
        Set<String> set2 = this.options;
        if (set2 != null) {
            i13 = set2.hashCode();
        }
        return i15 + i13;
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.f37543name + '\'' + ", columns=" + this.columns + ", options=" + this.options + AbstractJsonLexerKt.END_OBJ;
    }

    public FtsTableInfo(String str, Set<String> set, String str2) {
        this.f37543name = str;
        this.columns = set;
        this.options = a(str2);
    }
}
