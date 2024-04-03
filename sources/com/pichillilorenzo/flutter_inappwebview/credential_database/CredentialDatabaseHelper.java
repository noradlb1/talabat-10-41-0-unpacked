package com.pichillilorenzo.flutter_inappwebview.credential_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

@Instrumented
public class CredentialDatabaseHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_CREDENTIAL_TABLE = "CREATE TABLE credential (_id INTEGER PRIMARY KEY,username TEXT NOT NULL,password TEXT NOT NULL,protection_space_id INTEGER NOT NULL,UNIQUE(username, password, protection_space_id),FOREIGN KEY (protection_space_id) REFERENCES protection_space (_id) ON DELETE CASCADE);";
    private static final String SQL_CREATE_PROTECTION_SPACE_TABLE = "CREATE TABLE protection_space (_id INTEGER PRIMARY KEY,host TEXT NOT NULL,protocol TEXT,realm TEXT,port INTEGER,UNIQUE(host, protocol, realm, port));";
    private static final String SQL_DELETE_CREDENTIAL_TABLE = "DROP TABLE IF EXISTS credential";
    private static final String SQL_DELETE_PROTECTION_SPACE_TABLE = "DROP TABLE IF EXISTS protection_space";

    public CredentialDatabaseHelper(Context context) {
        super(context, CredentialDatabase.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 2);
    }

    public void clearAllTables(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(SQL_DELETE_PROTECTION_SPACE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, SQL_DELETE_PROTECTION_SPACE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(SQL_DELETE_CREDENTIAL_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, SQL_DELETE_CREDENTIAL_TABLE);
        }
        onCreate(sQLiteDatabase);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(SQL_CREATE_PROTECTION_SPACE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, SQL_CREATE_PROTECTION_SPACE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(SQL_CREATE_CREDENTIAL_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, SQL_CREATE_CREDENTIAL_TABLE);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        onUpgrade(sQLiteDatabase, i11, i12);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        boolean z11 = sQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            sQLiteDatabase.execSQL(SQL_DELETE_PROTECTION_SPACE_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, SQL_DELETE_PROTECTION_SPACE_TABLE);
        }
        if (!z11) {
            sQLiteDatabase.execSQL(SQL_DELETE_CREDENTIAL_TABLE);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, SQL_DELETE_CREDENTIAL_TABLE);
        }
        onCreate(sQLiteDatabase);
    }
}
