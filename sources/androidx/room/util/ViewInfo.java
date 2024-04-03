package androidx.room.util;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewInfo {

    /* renamed from: name  reason: collision with root package name */
    public final String f37551name;
    public final String sql;

    public ViewInfo(String str, String str2) {
        this.f37551name = str;
        this.sql = str2;
    }

    public static ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Cursor query = supportSQLiteDatabase.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + str + "'");
        try {
            if (query.moveToFirst()) {
                return new ViewInfo(query.getString(0), query.getString(1));
            }
            ViewInfo viewInfo = new ViewInfo(str, (String) null);
            query.close();
            return viewInfo;
        } finally {
            query.close();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        String str = this.f37551name;
        if (str == null ? viewInfo.f37551name == null : str.equals(viewInfo.f37551name)) {
            String str2 = this.sql;
            if (str2 != null) {
                if (str2.equals(viewInfo.sql)) {
                    return true;
                }
            } else if (viewInfo.sql == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i11;
        String str = this.f37551name;
        int i12 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        String str2 = this.sql;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return i13 + i12;
    }

    public String toString() {
        return "ViewInfo{name='" + this.f37551name + '\'' + ", sql='" + this.sql + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
