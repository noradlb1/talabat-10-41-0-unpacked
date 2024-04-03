package com.google.android.exoplayer2.offline;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.huawei.hms.flutter.map.constants.Param;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import z7.a;

@Instrumented
public final class DefaultDownloadIndex implements WritableDownloadIndex {
    private static final String[] COLUMNS = {"id", COLUMN_MIME_TYPE, "uri", COLUMN_STREAM_KEYS, COLUMN_CUSTOM_CACHE_KEY, "data", "state", COLUMN_START_TIME_MS, COLUMN_UPDATE_TIME_MS, "content_length", "stop_reason", COLUMN_FAILURE_REASON, COLUMN_PERCENT_DOWNLOADED, COLUMN_BYTES_DOWNLOADED, COLUMN_KEY_SET_ID};
    private static final String COLUMN_BYTES_DOWNLOADED = "bytes_downloaded";
    private static final String COLUMN_CONTENT_LENGTH = "content_length";
    private static final String COLUMN_CUSTOM_CACHE_KEY = "custom_cache_key";
    private static final String COLUMN_DATA = "data";
    private static final String COLUMN_FAILURE_REASON = "failure_reason";
    private static final String COLUMN_ID = "id";
    private static final int COLUMN_INDEX_BYTES_DOWNLOADED = 13;
    private static final int COLUMN_INDEX_CONTENT_LENGTH = 9;
    private static final int COLUMN_INDEX_CUSTOM_CACHE_KEY = 4;
    private static final int COLUMN_INDEX_DATA = 5;
    private static final int COLUMN_INDEX_FAILURE_REASON = 11;
    private static final int COLUMN_INDEX_ID = 0;
    private static final int COLUMN_INDEX_KEY_SET_ID = 14;
    private static final int COLUMN_INDEX_MIME_TYPE = 1;
    private static final int COLUMN_INDEX_PERCENT_DOWNLOADED = 12;
    private static final int COLUMN_INDEX_START_TIME_MS = 7;
    private static final int COLUMN_INDEX_STATE = 6;
    private static final int COLUMN_INDEX_STOP_REASON = 10;
    private static final int COLUMN_INDEX_STREAM_KEYS = 3;
    private static final int COLUMN_INDEX_UPDATE_TIME_MS = 8;
    private static final int COLUMN_INDEX_URI = 2;
    private static final String COLUMN_KEY_SET_ID = "key_set_id";
    private static final String COLUMN_MIME_TYPE = "mime_type";
    private static final String COLUMN_PERCENT_DOWNLOADED = "percent_downloaded";
    private static final String COLUMN_START_TIME_MS = "start_time_ms";
    private static final String COLUMN_STATE = "state";
    private static final String COLUMN_STOP_REASON = "stop_reason";
    private static final String COLUMN_STREAM_KEYS = "stream_keys";
    private static final String COLUMN_UPDATE_TIME_MS = "update_time_ms";
    private static final String COLUMN_URI = "uri";
    private static final String TABLE_PREFIX = "ExoPlayerDownloads";
    private static final String TABLE_SCHEMA = "(id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)";
    @VisibleForTesting
    static final int TABLE_VERSION = 3;
    private static final String TRUE = "1";
    private static final String WHERE_ID_EQUALS = "id = ?";
    private static final String WHERE_STATE_IS_DOWNLOADING = "state = 2";
    private static final String WHERE_STATE_IS_TERMINAL = getStateQuery(3, 4);
    private final DatabaseProvider databaseProvider;
    private final Object initializationLock;
    @GuardedBy("initializationLock")
    private boolean initialized;

    /* renamed from: name  reason: collision with root package name */
    private final String f34975name;
    private final String tableName;

    public static final class DownloadCursorImpl implements DownloadCursor {
        private final Cursor cursor;

        public void close() {
            this.cursor.close();
        }

        public int getCount() {
            return this.cursor.getCount();
        }

        public Download getDownload() {
            return DefaultDownloadIndex.getDownloadForCurrentRow(this.cursor);
        }

        public int getPosition() {
            return this.cursor.getPosition();
        }

        public /* synthetic */ boolean isAfterLast() {
            return a.a(this);
        }

        public /* synthetic */ boolean isBeforeFirst() {
            return a.b(this);
        }

        public boolean isClosed() {
            return this.cursor.isClosed();
        }

        public /* synthetic */ boolean isFirst() {
            return a.c(this);
        }

        public /* synthetic */ boolean isLast() {
            return a.d(this);
        }

        public /* synthetic */ boolean moveToFirst() {
            return a.e(this);
        }

        public /* synthetic */ boolean moveToLast() {
            return a.f(this);
        }

        public /* synthetic */ boolean moveToNext() {
            return a.g(this);
        }

        public boolean moveToPosition(int i11) {
            return this.cursor.moveToPosition(i11);
        }

        public /* synthetic */ boolean moveToPrevious() {
            return a.h(this);
        }

        private DownloadCursorImpl(Cursor cursor2) {
            this.cursor = cursor2;
        }
    }

    public DefaultDownloadIndex(DatabaseProvider databaseProvider2) {
        this(databaseProvider2, "");
    }

    private static List<StreamKey> decodeStreamKeys(@Nullable String str) {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String split : Util.split(str, ",")) {
            String[] split2 = Util.split(split, "\\.");
            if (split2.length == 3) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkState(z11);
            arrayList.add(new StreamKey(Integer.parseInt(split2[0]), Integer.parseInt(split2[1]), Integer.parseInt(split2[2])));
        }
        return arrayList;
    }

    @VisibleForTesting
    public static String encodeStreamKeys(List<StreamKey> list) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < list.size(); i11++) {
            StreamKey streamKey = list.get(i11);
            sb2.append(streamKey.periodIndex);
            sb2.append('.');
            sb2.append(streamKey.groupIndex);
            sb2.append('.');
            sb2.append(streamKey.streamIndex);
            sb2.append(AbstractJsonLexerKt.COMMA);
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2.toString();
    }

    private void ensureInitialized() throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        List<Download> list;
        synchronized (this.initializationLock) {
            if (!this.initialized) {
                try {
                    int version = VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 0, this.f34975name);
                    if (version != 3) {
                        writableDatabase = this.databaseProvider.getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        VersionTable.setVersion(writableDatabase, 0, this.f34975name, 3);
                        if (version == 2) {
                            list = loadDownloadsFromVersion2(writableDatabase);
                        } else {
                            list = new ArrayList<>();
                        }
                        SQLiteInstrumentation.execSQL(writableDatabase, "DROP TABLE IF EXISTS " + this.tableName);
                        SQLiteInstrumentation.execSQL(writableDatabase, "CREATE TABLE " + this.tableName + " " + TABLE_SCHEMA);
                        for (Download putDownloadInternal : list) {
                            putDownloadInternal(putDownloadInternal, writableDatabase);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    }
                    this.initialized = true;
                } catch (SQLException e11) {
                    throw new DatabaseIOException(e11);
                } catch (Throwable th2) {
                    writableDatabase.endTransaction();
                    throw th2;
                }
            }
        }
    }

    private Cursor getCursor(String str, @Nullable String[] strArr) throws DatabaseIOException {
        try {
            SQLiteDatabase readableDatabase = this.databaseProvider.getReadableDatabase();
            String str2 = this.tableName;
            String[] strArr2 = COLUMNS;
            if (!(readableDatabase instanceof SQLiteDatabase)) {
                return readableDatabase.query(str2, strArr2, str, strArr, (String) null, (String) null, "start_time_ms ASC");
            }
            return SQLiteInstrumentation.query(readableDatabase, str2, strArr2, str, strArr, (String) null, (String) null, "start_time_ms ASC");
        } catch (SQLiteException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    /* access modifiers changed from: private */
    public static Download getDownloadForCurrentRow(Cursor cursor) {
        byte[] blob = cursor.getBlob(14);
        int i11 = 0;
        DownloadRequest.Builder streamKeys = new DownloadRequest.Builder((String) Assertions.checkNotNull(cursor.getString(0)), Uri.parse((String) Assertions.checkNotNull(cursor.getString(2)))).setMimeType(cursor.getString(1)).setStreamKeys(decodeStreamKeys(cursor.getString(3)));
        if (blob.length <= 0) {
            blob = null;
        }
        DownloadRequest build = streamKeys.setKeySetId(blob).setCustomCacheKey(cursor.getString(4)).setData(cursor.getBlob(5)).build();
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.bytesDownloaded = cursor.getLong(13);
        downloadProgress.percentDownloaded = cursor.getFloat(12);
        int i12 = cursor.getInt(6);
        if (i12 == 4) {
            i11 = cursor.getInt(11);
        }
        return new Download(build, i12, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i11, downloadProgress);
    }

    private static Download getDownloadForCurrentRowV2(Cursor cursor) {
        int i11 = 0;
        DownloadRequest build = new DownloadRequest.Builder((String) Assertions.checkNotNull(cursor.getString(0)), Uri.parse((String) Assertions.checkNotNull(cursor.getString(2)))).setMimeType(inferMimeType(cursor.getString(1))).setStreamKeys(decodeStreamKeys(cursor.getString(3))).setCustomCacheKey(cursor.getString(4)).setData(cursor.getBlob(5)).build();
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.bytesDownloaded = cursor.getLong(13);
        downloadProgress.percentDownloaded = cursor.getFloat(12);
        int i12 = cursor.getInt(6);
        if (i12 == 4) {
            i11 = cursor.getInt(11);
        }
        return new Download(build, i12, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i11, downloadProgress);
    }

    private static String getStateQuery(int... iArr) {
        if (iArr.length == 0) {
            return "1";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("state");
        sb2.append(" IN (");
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (i11 > 0) {
                sb2.append(AbstractJsonLexerKt.COMMA);
            }
            sb2.append(iArr[i11]);
        }
        sb2.append(')');
        return sb2.toString();
    }

    private static String inferMimeType(@Nullable String str) {
        if (Param.DASH.equals(str)) {
            return MimeTypes.APPLICATION_MPD;
        }
        if ("hls".equals(str)) {
            return MimeTypes.APPLICATION_M3U8;
        }
        if ("ss".equals(str)) {
            return MimeTypes.APPLICATION_SS;
        }
        return MimeTypes.VIDEO_UNKNOWN;
    }

    private List<Download> loadDownloadsFromVersion2(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Throwable th2;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        ArrayList arrayList = new ArrayList();
        if (!Util.tableExists(sQLiteDatabase2, this.tableName)) {
            return arrayList;
        }
        String[] strArr = {"id", "title", "uri", COLUMN_STREAM_KEYS, COLUMN_CUSTOM_CACHE_KEY, "data", "state", COLUMN_START_TIME_MS, COLUMN_UPDATE_TIME_MS, "content_length", "stop_reason", COLUMN_FAILURE_REASON, COLUMN_PERCENT_DOWNLOADED, COLUMN_BYTES_DOWNLOADED};
        String str = this.tableName;
        if (!(sQLiteDatabase2 instanceof SQLiteDatabase)) {
            cursor = sQLiteDatabase.query(str, strArr, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        } else {
            cursor = SQLiteInstrumentation.query(sQLiteDatabase, str, strArr, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        }
        Cursor cursor2 = cursor;
        while (cursor2.moveToNext()) {
            try {
                arrayList.add(getDownloadForCurrentRowV2(cursor2));
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
        }
        cursor2.close();
        return arrayList;
        throw th2;
    }

    private void putDownloadInternal(Download download, SQLiteDatabase sQLiteDatabase) {
        byte[] bArr = download.request.keySetId;
        if (bArr == null) {
            bArr = Util.EMPTY_BYTE_ARRAY;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", download.request.f34976id);
        contentValues.put(COLUMN_MIME_TYPE, download.request.mimeType);
        contentValues.put("uri", download.request.uri.toString());
        contentValues.put(COLUMN_STREAM_KEYS, encodeStreamKeys(download.request.streamKeys));
        contentValues.put(COLUMN_CUSTOM_CACHE_KEY, download.request.customCacheKey);
        contentValues.put("data", download.request.data);
        contentValues.put("state", Integer.valueOf(download.state));
        contentValues.put(COLUMN_START_TIME_MS, Long.valueOf(download.startTimeMs));
        contentValues.put(COLUMN_UPDATE_TIME_MS, Long.valueOf(download.updateTimeMs));
        contentValues.put("content_length", Long.valueOf(download.contentLength));
        contentValues.put("stop_reason", Integer.valueOf(download.stopReason));
        contentValues.put(COLUMN_FAILURE_REASON, Integer.valueOf(download.failureReason));
        contentValues.put(COLUMN_PERCENT_DOWNLOADED, Float.valueOf(download.getPercentDownloaded()));
        contentValues.put(COLUMN_BYTES_DOWNLOADED, Long.valueOf(download.getBytesDownloaded()));
        contentValues.put(COLUMN_KEY_SET_ID, bArr);
        String str = this.tableName;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.replaceOrThrow(str, (String) null, contentValues);
        } else {
            SQLiteInstrumentation.replaceOrThrow(sQLiteDatabase, str, (String) null, contentValues);
        }
    }

    @Nullable
    public Download getDownload(String str) throws DatabaseIOException {
        Cursor cursor;
        ensureInitialized();
        try {
            cursor = getCursor(WHERE_ID_EQUALS, new String[]{str});
            if (cursor.getCount() == 0) {
                cursor.close();
                return null;
            }
            cursor.moveToNext();
            Download downloadForCurrentRow = getDownloadForCurrentRow(cursor);
            cursor.close();
            return downloadForCurrentRow;
        } catch (SQLiteException e11) {
            throw new DatabaseIOException(e11);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public DownloadCursor getDownloads(int... iArr) throws DatabaseIOException {
        ensureInitialized();
        return new DownloadCursorImpl(getCursor(getStateQuery(iArr), (String[]) null));
    }

    public void putDownload(Download download) throws DatabaseIOException {
        ensureInitialized();
        try {
            putDownloadInternal(download, this.databaseProvider.getWritableDatabase());
        } catch (SQLiteException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public void removeDownload(String str) throws DatabaseIOException {
        ensureInitialized();
        try {
            SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
            String str2 = this.tableName;
            String[] strArr = {str};
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.delete(str2, WHERE_ID_EQUALS, strArr);
            } else {
                SQLiteInstrumentation.delete(writableDatabase, str2, WHERE_ID_EQUALS, strArr);
            }
        } catch (SQLiteException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public void setDownloadingStatesToQueued() throws DatabaseIOException {
        ensureInitialized();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", 0);
            SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
            String str = this.tableName;
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.update(str, contentValues, WHERE_STATE_IS_DOWNLOADING, (String[]) null);
            } else {
                SQLiteInstrumentation.update(writableDatabase, str, contentValues, WHERE_STATE_IS_DOWNLOADING, (String[]) null);
            }
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public void setStatesToRemoving() throws DatabaseIOException {
        ensureInitialized();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", 5);
            contentValues.put(COLUMN_FAILURE_REASON, 0);
            SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
            String str = this.tableName;
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.update(str, contentValues, (String) null, (String[]) null);
            } else {
                SQLiteInstrumentation.update(writableDatabase, str, contentValues, (String) null, (String[]) null);
            }
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public void setStopReason(int i11) throws DatabaseIOException {
        ensureInitialized();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i11));
            SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
            String str = this.tableName;
            String str2 = WHERE_STATE_IS_TERMINAL;
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.update(str, contentValues, str2, (String[]) null);
            } else {
                SQLiteInstrumentation.update(writableDatabase, str, contentValues, str2, (String[]) null);
            }
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public DefaultDownloadIndex(DatabaseProvider databaseProvider2, String str) {
        this.f34975name = str;
        this.databaseProvider = databaseProvider2;
        this.tableName = TABLE_PREFIX + str;
        this.initializationLock = new Object();
    }

    public void setStopReason(String str, int i11) throws DatabaseIOException {
        ensureInitialized();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i11));
            SQLiteDatabase writableDatabase = this.databaseProvider.getWritableDatabase();
            String str2 = this.tableName;
            String str3 = WHERE_STATE_IS_TERMINAL + " AND " + WHERE_ID_EQUALS;
            String[] strArr = {str};
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.update(str2, contentValues, str3, strArr);
            } else {
                SQLiteInstrumentation.update(writableDatabase, str2, contentValues, str3, strArr);
            }
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }
}
