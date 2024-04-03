package com.instabug.library.internal.storage.cache.db.migrations;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.settings.SettingsManager;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import org.json.JSONArray;

@Instrumented
public class g implements c {
    public void a(SQLiteDatabase sQLiteDatabase) {
        String str;
        String str2 = "ALTER TABLE session_table ADD COLUMN os TEXT DEFAULT \"SDK Level " + InstabugDeviceProperties.getCurrentOSLevel() + "\"";
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(str2);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str2);
        }
        String str3 = "ALTER TABLE session_table ADD COLUMN device TEXT DEFAULT \"" + InstabugDeviceProperties.getDeviceType() + "\"";
        if (!z11) {
            sQLiteDatabase.execSQL(str3);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str3);
        }
        if (!z11) {
            sQLiteDatabase.execSQL("ALTER TABLE session_table ADD COLUMN sdk_version TEXT DEFAULT \"11.7.0\"");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE session_table ADD COLUMN sdk_version TEXT DEFAULT \"11.7.0\"");
        }
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            str = null;
        } else {
            str = InstabugDeviceProperties.getAppVersion(applicationContext);
        }
        String str4 = "ALTER TABLE session_table ADD COLUMN app_version TEXT DEFAULT \"" + str + "\"";
        if (!z11) {
            sQLiteDatabase.execSQL(str4);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str4);
        }
        String str5 = "ALTER TABLE session_table ADD COLUMN crash_reporting_enabled INTEGER DEFAULT " + (InstabugCore.isCrashReportingEnabled() ? 1 : 0);
        if (!z11) {
            sQLiteDatabase.execSQL(str5);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str5);
        }
        if (!z11) {
            sQLiteDatabase.execSQL("ALTER TABLE session_table ADD COLUMN sync_status INTEGER DEFAULT 0");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE session_table ADD COLUMN sync_status INTEGER DEFAULT 0");
        }
        String str6 = "ALTER TABLE session_table ADD COLUMN app_token TEXT DEFAULT \"" + SettingsManager.getInstance().getAppToken() + "\"";
        if (!z11) {
            sQLiteDatabase.execSQL(str6);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str6);
        }
        String jSONArrayInstrumentation = JSONArrayInstrumentation.toString(new JSONArray());
        String str7 = "ALTER TABLE session_table ADD COLUMN user_attributes_keys TEXT DEFAULT \"" + jSONArrayInstrumentation + "\"";
        if (!z11) {
            sQLiteDatabase.execSQL(str7);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str7);
        }
        String str8 = "ALTER TABLE session_table ADD COLUMN user_events_keys TEXT DEFAULT \"" + jSONArrayInstrumentation + "\"";
        if (!z11) {
            sQLiteDatabase.execSQL(str8);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str8);
        }
        if (!z11) {
            sQLiteDatabase.execSQL("ALTER TABLE session_table ADD COLUMN users_page_enabled INTEGER DEFAULT 1");
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, "ALTER TABLE session_table ADD COLUMN users_page_enabled INTEGER DEFAULT 1");
        }
    }
}
