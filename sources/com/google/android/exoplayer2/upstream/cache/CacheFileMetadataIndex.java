package com.google.android.exoplayer2.upstream.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.util.Assertions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Instrumented
final class CacheFileMetadataIndex {
    private static final String[] COLUMNS = {"name", COLUMN_LENGTH, COLUMN_LAST_TOUCH_TIMESTAMP};
    private static final int COLUMN_INDEX_LAST_TOUCH_TIMESTAMP = 2;
    private static final int COLUMN_INDEX_LENGTH = 1;
    private static final int COLUMN_INDEX_NAME = 0;
    private static final String COLUMN_LAST_TOUCH_TIMESTAMP = "last_touch_timestamp";
    private static final String COLUMN_LENGTH = "length";
    private static final String COLUMN_NAME = "name";
    private static final String TABLE_PREFIX = "ExoPlayerCacheFileMetadata";
    private static final String TABLE_SCHEMA = "(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)";
    private static final int TABLE_VERSION = 1;
    private static final String WHERE_NAME_EQUALS = "name = ?";
    private final DatabaseProvider databaseProvider;
    private String tableName;

    public CacheFileMetadataIndex(DatabaseProvider databaseProvider2) {
        this.databaseProvider = databaseProvider2;
    }

    @WorkerThread
    public static void delete(DatabaseProvider databaseProvider2, long j11) throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        String hexString = Long.toHexString(j11);
        try {
            String tableName2 = getTableName(hexString);
            writableDatabase = databaseProvider2.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            VersionTable.removeVersion(writableDatabase, 2, hexString);
            dropTable(writableDatabase, tableName2);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        } catch (Throwable th2) {
            writableDatabase.endTransaction();
            throw th2;
        }
    }

    private static void dropTable(SQLiteDatabase sQLiteDatabase, String str) {
        String str2 = "DROP TABLE IF EXISTS " + str;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str2);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str2);
        }
    }

    private Cursor getCursor() {
        Assertions.checkNotNull(this.tableName);
        SQLiteDatabase readableDatabase = this.databaseProvider.getReadableDatabase();
        String str = this.tableName;
        String[] strArr = COLUMNS;
        if (!(readableDatabase instanceof SQLiteDatabase)) {
            return readableDatabase.query(str, strArr, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        }
        return SQLiteInstrumentation.query(readableDatabase, str, strArr, (String) null, (String[]) null, (String) null, (String) null, (String) null);
    }

    private static String getTableName(String str) {
        return TABLE_PREFIX + str;
    }

    @WorkerThread
    public Map<String, CacheFileMetadata> getAll() throws DatabaseIOException {
        Cursor cursor;
        try {
            cursor = getCursor();
            HashMap hashMap = new HashMap(cursor.getCount());
            while (cursor.moveToNext()) {
                hashMap.put((String) Assertions.checkNotNull(cursor.getString(0)), new CacheFileMetadata(cursor.getLong(1), cursor.getLong(2)));
            }
            cursor.close();
            return hashMap;
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    @WorkerThread
    public void initialize(long j11) throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        try {
            String hexString = Long.toHexString(j11);
            this.tableName = getTableName(hexString);
            if (VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 2, hexString) != 1) {
                writableDatabase = this.databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                VersionTable.setVersion(writableDatabase, 2, hexString, 1);
                dropTable(writableDatabase, this.tableName);
                SQLiteInstrumentation.execSQL(writableDatabase, "CREATE TABLE " + this.tableName + " " + TABLE_SCHEMA);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        } catch (Throwable th2) {
            writableDatabase.endTransaction();
            throw th2;
        }
    }

    @WorkerThread
    public void remove(String str) throws DatabaseIOException {
        Assertions.checkNotNull(this.tableName);
        try {
            SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
            String str2 = this.tableName;
            String[] strArr = {str};
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.delete(str2, WHERE_NAME_EQUALS, strArr);
            } else {
                SQLiteInstrumentation.delete(writableDatabase, str2, WHERE_NAME_EQUALS, strArr);
            }
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    @WorkerThread
    public void removeAll(Set<String> set) throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        Assertions.checkNotNull(this.tableName);
        try {
            writableDatabase = this.databaseProvider.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            for (String str : set) {
                SQLiteInstrumentation.delete(writableDatabase, this.tableName, WHERE_NAME_EQUALS, new String[]{str});
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        } catch (Throwable th2) {
            writableDatabase.endTransaction();
            throw th2;
        }
    }

    @WorkerThread
    public void set(String str, long j11, long j12) throws DatabaseIOException {
        Assertions.checkNotNull(this.tableName);
        try {
            SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put(COLUMN_LENGTH, Long.valueOf(j11));
            contentValues.put(COLUMN_LAST_TOUCH_TIMESTAMP, Long.valueOf(j12));
            String str2 = this.tableName;
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.replaceOrThrow(str2, (String) null, contentValues);
            } else {
                SQLiteInstrumentation.replaceOrThrow(writableDatabase, str2, (String) null, contentValues);
            }
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }
}
