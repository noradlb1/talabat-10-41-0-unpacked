package com.pichillilorenzo.flutter_inappwebview.credential_database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import com.pichillilorenzo.flutter_inappwebview.types.URLProtectionSpace;
import java.util.ArrayList;
import java.util.List;

@Instrumented
public class URLProtectionSpaceDao {
    CredentialDatabaseHelper credentialDatabaseHelper;
    String[] projection = {InstabugDbContract.FeatureRequestEntry.COLUMN_ID, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT};

    public URLProtectionSpaceDao(CredentialDatabaseHelper credentialDatabaseHelper2) {
        this.credentialDatabaseHelper = credentialDatabaseHelper2;
    }

    public long delete(URLProtectionSpace uRLProtectionSpace) {
        String[] strArr = {uRLProtectionSpace.getId().toString()};
        SQLiteDatabase writableDatabase = this.credentialDatabaseHelper.getWritableDatabase();
        return (long) (!(writableDatabase instanceof SQLiteDatabase) ? writableDatabase.delete(URLProtectionSpaceContract.FeedEntry.TABLE_NAME, "_id = ?", strArr) : SQLiteInstrumentation.delete(writableDatabase, URLProtectionSpaceContract.FeedEntry.TABLE_NAME, "_id = ?", strArr));
    }

    public URLProtectionSpace find(String str, String str2, String str3, Integer num) {
        SQLiteDatabase readableDatabase = this.credentialDatabaseHelper.getReadableDatabase();
        String[] strArr = {str, str2, str3, num.toString()};
        String[] strArr2 = this.projection;
        Cursor query = !(readableDatabase instanceof SQLiteDatabase) ? readableDatabase.query(URLProtectionSpaceContract.FeedEntry.TABLE_NAME, strArr2, "host = ? AND protocol = ? AND realm = ? AND port = ?", strArr, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query(readableDatabase, URLProtectionSpaceContract.FeedEntry.TABLE_NAME, strArr2, "host = ? AND protocol = ? AND realm = ? AND port = ?", strArr, (String) null, (String) null, (String) null);
        URLProtectionSpace uRLProtectionSpace = query.moveToNext() ? new URLProtectionSpace(Long.valueOf(query.getLong(query.getColumnIndexOrThrow(InstabugDbContract.FeatureRequestEntry.COLUMN_ID))), query.getString(query.getColumnIndexOrThrow(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST)), query.getString(query.getColumnIndexOrThrow(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL)), query.getString(query.getColumnIndexOrThrow(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM)), Integer.valueOf(query.getInt(query.getColumnIndexOrThrow(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT))).intValue()) : null;
        query.close();
        return uRLProtectionSpace;
    }

    public List<URLProtectionSpace> getAll() {
        SQLiteDatabase readableDatabase = this.credentialDatabaseHelper.getReadableDatabase();
        String[] strArr = this.projection;
        Cursor query = !(readableDatabase instanceof SQLiteDatabase) ? readableDatabase.query(URLProtectionSpaceContract.FeedEntry.TABLE_NAME, strArr, (String) null, (String[]) null, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query(readableDatabase, URLProtectionSpaceContract.FeedEntry.TABLE_NAME, strArr, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            arrayList.add(new URLProtectionSpace(Long.valueOf(query.getLong(query.getColumnIndexOrThrow(InstabugDbContract.FeatureRequestEntry.COLUMN_ID))), query.getString(query.getColumnIndexOrThrow(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST)), query.getString(query.getColumnIndexOrThrow(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL)), query.getString(query.getColumnIndexOrThrow(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM)), Integer.valueOf(query.getInt(query.getColumnIndexOrThrow(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT))).intValue()));
        }
        query.close();
        return arrayList;
    }

    public long insert(URLProtectionSpace uRLProtectionSpace) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST, uRLProtectionSpace.getHost());
        contentValues.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PROTOCOL, uRLProtectionSpace.getProtocol());
        contentValues.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_REALM, uRLProtectionSpace.getRealm());
        contentValues.put(URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_PORT, Integer.valueOf(uRLProtectionSpace.getPort()));
        SQLiteDatabase writableDatabase = this.credentialDatabaseHelper.getWritableDatabase();
        return !(writableDatabase instanceof SQLiteDatabase) ? writableDatabase.insert(URLProtectionSpaceContract.FeedEntry.TABLE_NAME, (String) null, contentValues) : SQLiteInstrumentation.insert(writableDatabase, URLProtectionSpaceContract.FeedEntry.TABLE_NAME, (String) null, contentValues);
    }
}
