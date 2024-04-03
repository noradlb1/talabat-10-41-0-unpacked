package com.huawei.hms.analytics;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.m;

public final class af extends ah {
    public af(Context context, m.lmn lmn) {
        super(context, lmn, new z(context, lmn));
    }

    private String ijk() {
        int columnIndex;
        Cursor cursor = null;
        try {
            cursor = this.klm.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), (String[]) null, (String) null, new String[]{"oaid"}, (String) null);
            if (cursor == null || !cursor.moveToFirst() || (columnIndex = cursor.getColumnIndex("value")) < 0) {
                if (cursor == null) {
                    return "";
                }
                cursor.close();
                return "";
            }
            String string = cursor.getString(columnIndex);
            cursor.close();
            return string;
        } catch (Exception unused) {
            HiLog.w("MeizHelper", "contentResolver query exception");
            if (cursor == null) {
                return "";
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final boolean klm() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public final void lmn() {
        String ijk = ijk();
        if (TextUtils.isEmpty(ijk)) {
            lmn("meiz oid is empty, begin get gaid");
        } else {
            this.lmn.lmn(ijk, "", "oaid");
        }
    }
}
