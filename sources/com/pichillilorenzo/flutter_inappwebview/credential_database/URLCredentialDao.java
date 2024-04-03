package com.pichillilorenzo.flutter_inappwebview.credential_database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLCredentialContract;
import com.pichillilorenzo.flutter_inappwebview.types.URLCredential;
import java.util.ArrayList;
import java.util.List;

@Instrumented
public class URLCredentialDao {
    CredentialDatabaseHelper credentialDatabaseHelper;
    String[] projection = {InstabugDbContract.FeatureRequestEntry.COLUMN_ID, "username", "password", URLCredentialContract.FeedEntry.COLUMN_NAME_PROTECTION_SPACE_ID};

    public URLCredentialDao(CredentialDatabaseHelper credentialDatabaseHelper2) {
        this.credentialDatabaseHelper = credentialDatabaseHelper2;
    }

    public long delete(URLCredential uRLCredential) {
        String[] strArr = {uRLCredential.getId().toString()};
        SQLiteDatabase writableDatabase = this.credentialDatabaseHelper.getWritableDatabase();
        return (long) (!(writableDatabase instanceof SQLiteDatabase) ? writableDatabase.delete(URLCredentialContract.FeedEntry.TABLE_NAME, "_id = ?", strArr) : SQLiteInstrumentation.delete(writableDatabase, URLCredentialContract.FeedEntry.TABLE_NAME, "_id = ?", strArr));
    }

    public URLCredential find(String str, String str2, Long l11) {
        String[] strArr = {str, str2, l11.toString()};
        SQLiteDatabase readableDatabase = this.credentialDatabaseHelper.getReadableDatabase();
        String[] strArr2 = this.projection;
        Cursor query = !(readableDatabase instanceof SQLiteDatabase) ? readableDatabase.query(URLCredentialContract.FeedEntry.TABLE_NAME, strArr2, "username = ? AND password = ? AND protection_space_id = ?", strArr, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query(readableDatabase, URLCredentialContract.FeedEntry.TABLE_NAME, strArr2, "username = ? AND password = ? AND protection_space_id = ?", strArr, (String) null, (String) null, (String) null);
        URLCredential uRLCredential = query.moveToNext() ? new URLCredential(Long.valueOf(query.getLong(query.getColumnIndexOrThrow(InstabugDbContract.FeatureRequestEntry.COLUMN_ID))), query.getString(query.getColumnIndexOrThrow("username")), query.getString(query.getColumnIndexOrThrow("password")), l11) : null;
        query.close();
        return uRLCredential;
    }

    public List<URLCredential> getAllByProtectionSpaceId(Long l11) {
        String[] strArr = {l11.toString()};
        SQLiteDatabase readableDatabase = this.credentialDatabaseHelper.getReadableDatabase();
        String[] strArr2 = this.projection;
        Cursor query = !(readableDatabase instanceof SQLiteDatabase) ? readableDatabase.query(URLCredentialContract.FeedEntry.TABLE_NAME, strArr2, "protection_space_id = ?", strArr, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query(readableDatabase, URLCredentialContract.FeedEntry.TABLE_NAME, strArr2, "protection_space_id = ?", strArr, (String) null, (String) null, (String) null);
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            arrayList.add(new URLCredential(Long.valueOf(query.getLong(query.getColumnIndexOrThrow(InstabugDbContract.FeatureRequestEntry.COLUMN_ID))), query.getString(query.getColumnIndexOrThrow("username")), query.getString(query.getColumnIndexOrThrow("password")), l11));
        }
        query.close();
        return arrayList;
    }

    public long insert(URLCredential uRLCredential) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", uRLCredential.getUsername());
        contentValues.put("password", uRLCredential.getPassword());
        contentValues.put(URLCredentialContract.FeedEntry.COLUMN_NAME_PROTECTION_SPACE_ID, uRLCredential.getProtectionSpaceId());
        SQLiteDatabase writableDatabase = this.credentialDatabaseHelper.getWritableDatabase();
        return !(writableDatabase instanceof SQLiteDatabase) ? writableDatabase.insert(URLCredentialContract.FeedEntry.TABLE_NAME, (String) null, contentValues) : SQLiteInstrumentation.insert(writableDatabase, URLCredentialContract.FeedEntry.TABLE_NAME, (String) null, contentValues);
    }

    public long update(URLCredential uRLCredential) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", uRLCredential.getUsername());
        contentValues.put("password", uRLCredential.getPassword());
        String[] strArr = {uRLCredential.getProtectionSpaceId().toString()};
        SQLiteDatabase writableDatabase = this.credentialDatabaseHelper.getWritableDatabase();
        return (long) (!(writableDatabase instanceof SQLiteDatabase) ? writableDatabase.update(URLCredentialContract.FeedEntry.TABLE_NAME, contentValues, "protection_space_id = ?", strArr) : SQLiteInstrumentation.update(writableDatabase, URLCredentialContract.FeedEntry.TABLE_NAME, contentValues, "protection_space_id = ?", strArr));
    }
}
