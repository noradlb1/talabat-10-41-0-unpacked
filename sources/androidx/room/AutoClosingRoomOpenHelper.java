package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.arch.core.util.Function;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import j2.a;
import j2.b;
import j2.d;
import j2.e;
import j2.f;
import j2.g;
import j2.h;
import j2.i;
import j2.j;
import j2.k;
import j2.l;
import j2.m;
import j2.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import n2.c;

final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    @NonNull
    private final AutoCloser mAutoCloser;
    @NonNull
    private final AutoClosingSupportSQLiteDatabase mAutoClosingDb;
    @NonNull
    private final SupportSQLiteOpenHelper mDelegateOpenHelper;

    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {
        @NonNull
        private final AutoCloser mAutoCloser;

        public AutoClosingSupportSQLiteDatabase(@NonNull AutoCloser autoCloser) {
            this.mAutoCloser = autoCloser;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ Object lambda$pokeOpen$0(SupportSQLiteDatabase supportSQLiteDatabase) {
            return null;
        }

        public void beginTransaction() {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();
            } catch (Throwable th2) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th2;
            }
        }

        public void beginTransactionNonExclusive() {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();
            } catch (Throwable th2) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th2;
            }
        }

        public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(sQLiteTransactionListener);
            } catch (Throwable th2) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th2;
            }
        }

        public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
            } catch (Throwable th2) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th2;
            }
        }

        public void close() throws IOException {
            this.mAutoCloser.closeDatabaseIfOpen();
        }

        public SupportSQLiteStatement compileStatement(String str) {
            return new AutoClosingSupportSqliteStatement(str, this.mAutoCloser);
        }

        public int delete(String str, String str2, Object[] objArr) {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new e(str, str2, objArr))).intValue();
        }

        public void disableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        public boolean enableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        public void endTransaction() {
            if (this.mAutoCloser.getDelegateDatabase() != null) {
                try {
                    this.mAutoCloser.getDelegateDatabase().endTransaction();
                } finally {
                    this.mAutoCloser.decrementCountAndScheduleClose();
                }
            } else {
                throw new IllegalStateException("End transaction called but delegateDb is null");
            }
        }

        public /* synthetic */ void execPerConnectionSQL(String str, Object[] objArr) {
            c.a(this, str, objArr);
        }

        public void execSQL(String str) throws SQLException {
            this.mAutoCloser.executeRefCountingFunction(new c(str));
        }

        public List<Pair<String, String>> getAttachedDbs() {
            return (List) this.mAutoCloser.executeRefCountingFunction(new j());
        }

        public long getMaximumSize() {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new a())).longValue();
        }

        public long getPageSize() {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new j2.c())).longValue();
        }

        public String getPath() {
            return (String) this.mAutoCloser.executeRefCountingFunction(new d());
        }

        public int getVersion() {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new f())).intValue();
        }

        public boolean inTransaction() {
            if (this.mAutoCloser.getDelegateDatabase() == null) {
                return false;
            }
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new i())).booleanValue();
        }

        public long insert(String str, int i11, ContentValues contentValues) throws SQLException {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new k(str, i11, contentValues))).longValue();
        }

        public boolean isDatabaseIntegrityOk() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new b())).booleanValue();
        }

        public boolean isDbLockedByCurrentThread() {
            if (this.mAutoCloser.getDelegateDatabase() == null) {
                return false;
            }
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new g())).booleanValue();
        }

        public /* synthetic */ boolean isExecPerConnectionSQLSupported() {
            return c.b(this);
        }

        public boolean isOpen() {
            SupportSQLiteDatabase delegateDatabase = this.mAutoCloser.getDelegateDatabase();
            if (delegateDatabase == null) {
                return false;
            }
            return delegateDatabase.isOpen();
        }

        public boolean isReadOnly() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new h())).booleanValue();
        }

        @RequiresApi(api = 16)
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new a())).booleanValue();
        }

        public boolean needUpgrade(int i11) {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new g(i11))).booleanValue();
        }

        public void o() {
            this.mAutoCloser.executeRefCountingFunction(new b());
        }

        public Cursor query(String str) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(str), this.mAutoCloser);
            } catch (Throwable th2) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th2;
            }
        }

        @RequiresApi(api = 16)
        public void setForeignKeyConstraintsEnabled(boolean z11) {
            this.mAutoCloser.executeRefCountingFunction(new i(z11));
        }

        public void setLocale(Locale locale) {
            this.mAutoCloser.executeRefCountingFunction(new n(locale));
        }

        public void setMaxSqlCacheSize(int i11) {
            this.mAutoCloser.executeRefCountingFunction(new l(i11));
        }

        public long setMaximumSize(long j11) {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new f(j11))).longValue();
        }

        public void setPageSize(long j11) {
            this.mAutoCloser.executeRefCountingFunction(new h(j11));
        }

        public void setTransactionSuccessful() {
            SupportSQLiteDatabase delegateDatabase = this.mAutoCloser.getDelegateDatabase();
            if (delegateDatabase != null) {
                delegateDatabase.setTransactionSuccessful();
                return;
            }
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
        }

        public void setVersion(int i11) {
            this.mAutoCloser.executeRefCountingFunction(new d(i11));
        }

        public int update(String str, int i11, ContentValues contentValues, String str2, Object[] objArr) {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new m(str, i11, contentValues, str2, objArr))).intValue();
        }

        public boolean yieldIfContendedSafely() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new e())).booleanValue();
        }

        public void execSQL(String str, Object[] objArr) throws SQLException {
            this.mAutoCloser.executeRefCountingFunction(new j(str, objArr));
        }

        public boolean yieldIfContendedSafely(long j11) {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new e())).booleanValue();
        }

        public Cursor query(String str, Object[] objArr) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(str, objArr), this.mAutoCloser);
            } catch (Throwable th2) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th2;
            }
        }

        public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery), this.mAutoCloser);
            } catch (Throwable th2) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th2;
            }
        }

        @RequiresApi(api = 24)
        public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery, cancellationSignal), this.mAutoCloser);
            } catch (Throwable th2) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th2;
            }
        }
    }

    public static class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {
        private final AutoCloser mAutoCloser;
        private final ArrayList<Object> mBinds = new ArrayList<>();
        private final String mSql;

        public AutoClosingSupportSqliteStatement(String str, AutoCloser autoCloser) {
            this.mSql = str;
            this.mAutoCloser = autoCloser;
        }

        private void doBinds(SupportSQLiteStatement supportSQLiteStatement) {
            int i11 = 0;
            while (i11 < this.mBinds.size()) {
                int i12 = i11 + 1;
                Object obj = this.mBinds.get(i11);
                if (obj == null) {
                    supportSQLiteStatement.bindNull(i12);
                } else if (obj instanceof Long) {
                    supportSQLiteStatement.bindLong(i12, ((Long) obj).longValue());
                } else if (obj instanceof Double) {
                    supportSQLiteStatement.bindDouble(i12, ((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    supportSQLiteStatement.bindString(i12, (String) obj);
                } else if (obj instanceof byte[]) {
                    supportSQLiteStatement.bindBlob(i12, (byte[]) obj);
                }
                i11 = i12;
            }
        }

        private <T> T executeSqliteStatementWithRefCount(Function<SupportSQLiteStatement, T> function) {
            return this.mAutoCloser.executeRefCountingFunction(new o(this, function));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object lambda$executeSqliteStatementWithRefCount$0(Function function, SupportSQLiteDatabase supportSQLiteDatabase) {
            SupportSQLiteStatement compileStatement = supportSQLiteDatabase.compileStatement(this.mSql);
            doBinds(compileStatement);
            return function.apply(compileStatement);
        }

        private void saveBinds(int i11, Object obj) {
            int i12 = i11 - 1;
            if (i12 >= this.mBinds.size()) {
                for (int size = this.mBinds.size(); size <= i12; size++) {
                    this.mBinds.add((Object) null);
                }
            }
            this.mBinds.set(i12, obj);
        }

        public void bindBlob(int i11, byte[] bArr) {
            saveBinds(i11, bArr);
        }

        public void bindDouble(int i11, double d11) {
            saveBinds(i11, Double.valueOf(d11));
        }

        public void bindLong(int i11, long j11) {
            saveBinds(i11, Long.valueOf(j11));
        }

        public void bindNull(int i11) {
            saveBinds(i11, (Object) null);
        }

        public void bindString(int i11, String str) {
            saveBinds(i11, str);
        }

        public void clearBindings() {
            this.mBinds.clear();
        }

        public void close() throws IOException {
        }

        public void execute() {
            executeSqliteStatementWithRefCount(new p());
        }

        public long executeInsert() {
            return ((Long) executeSqliteStatementWithRefCount(new m())).longValue();
        }

        public int executeUpdateDelete() {
            return ((Integer) executeSqliteStatementWithRefCount(new k())).intValue();
        }

        public long simpleQueryForLong() {
            return ((Long) executeSqliteStatementWithRefCount(new n())).longValue();
        }

        public String simpleQueryForString() {
            return (String) executeSqliteStatementWithRefCount(new l());
        }
    }

    public static final class KeepAliveCursor implements Cursor {
        private final AutoCloser mAutoCloser;
        private final Cursor mDelegate;

        public KeepAliveCursor(Cursor cursor, AutoCloser autoCloser) {
            this.mDelegate = cursor;
            this.mAutoCloser = autoCloser;
        }

        public void close() {
            this.mDelegate.close();
            this.mAutoCloser.decrementCountAndScheduleClose();
        }

        public void copyStringToBuffer(int i11, CharArrayBuffer charArrayBuffer) {
            this.mDelegate.copyStringToBuffer(i11, charArrayBuffer);
        }

        @Deprecated
        public void deactivate() {
            this.mDelegate.deactivate();
        }

        public byte[] getBlob(int i11) {
            return this.mDelegate.getBlob(i11);
        }

        public int getColumnCount() {
            return this.mDelegate.getColumnCount();
        }

        public int getColumnIndex(String str) {
            return this.mDelegate.getColumnIndex(str);
        }

        public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
            return this.mDelegate.getColumnIndexOrThrow(str);
        }

        public String getColumnName(int i11) {
            return this.mDelegate.getColumnName(i11);
        }

        public String[] getColumnNames() {
            return this.mDelegate.getColumnNames();
        }

        public int getCount() {
            return this.mDelegate.getCount();
        }

        public double getDouble(int i11) {
            return this.mDelegate.getDouble(i11);
        }

        public Bundle getExtras() {
            return this.mDelegate.getExtras();
        }

        public float getFloat(int i11) {
            return this.mDelegate.getFloat(i11);
        }

        public int getInt(int i11) {
            return this.mDelegate.getInt(i11);
        }

        public long getLong(int i11) {
            return this.mDelegate.getLong(i11);
        }

        @RequiresApi(api = 19)
        public Uri getNotificationUri() {
            return SupportSQLiteCompat.Api19Impl.getNotificationUri(this.mDelegate);
        }

        @RequiresApi(api = 29)
        @Nullable
        public List<Uri> getNotificationUris() {
            return SupportSQLiteCompat.Api29Impl.getNotificationUris(this.mDelegate);
        }

        public int getPosition() {
            return this.mDelegate.getPosition();
        }

        public short getShort(int i11) {
            return this.mDelegate.getShort(i11);
        }

        public String getString(int i11) {
            return this.mDelegate.getString(i11);
        }

        public int getType(int i11) {
            return this.mDelegate.getType(i11);
        }

        public boolean getWantsAllOnMoveCalls() {
            return this.mDelegate.getWantsAllOnMoveCalls();
        }

        public boolean isAfterLast() {
            return this.mDelegate.isAfterLast();
        }

        public boolean isBeforeFirst() {
            return this.mDelegate.isBeforeFirst();
        }

        public boolean isClosed() {
            return this.mDelegate.isClosed();
        }

        public boolean isFirst() {
            return this.mDelegate.isFirst();
        }

        public boolean isLast() {
            return this.mDelegate.isLast();
        }

        public boolean isNull(int i11) {
            return this.mDelegate.isNull(i11);
        }

        public boolean move(int i11) {
            return this.mDelegate.move(i11);
        }

        public boolean moveToFirst() {
            return this.mDelegate.moveToFirst();
        }

        public boolean moveToLast() {
            return this.mDelegate.moveToLast();
        }

        public boolean moveToNext() {
            return this.mDelegate.moveToNext();
        }

        public boolean moveToPosition(int i11) {
            return this.mDelegate.moveToPosition(i11);
        }

        public boolean moveToPrevious() {
            return this.mDelegate.moveToPrevious();
        }

        public void registerContentObserver(ContentObserver contentObserver) {
            this.mDelegate.registerContentObserver(contentObserver);
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDelegate.registerDataSetObserver(dataSetObserver);
        }

        @Deprecated
        public boolean requery() {
            return this.mDelegate.requery();
        }

        public Bundle respond(Bundle bundle) {
            return this.mDelegate.respond(bundle);
        }

        @RequiresApi(api = 23)
        public void setExtras(Bundle bundle) {
            SupportSQLiteCompat.Api23Impl.setExtras(this.mDelegate, bundle);
        }

        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.mDelegate.setNotificationUri(contentResolver, uri);
        }

        @RequiresApi(api = 29)
        public void setNotificationUris(@NonNull ContentResolver contentResolver, @NonNull List<Uri> list) {
            SupportSQLiteCompat.Api29Impl.setNotificationUris(this.mDelegate, contentResolver, list);
        }

        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.mDelegate.unregisterContentObserver(contentObserver);
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDelegate.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public AutoClosingRoomOpenHelper(@NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper, @NonNull AutoCloser autoCloser) {
        this.mDelegateOpenHelper = supportSQLiteOpenHelper;
        this.mAutoCloser = autoCloser;
        autoCloser.init(supportSQLiteOpenHelper);
        this.mAutoClosingDb = new AutoClosingSupportSQLiteDatabase(autoCloser);
    }

    @NonNull
    public AutoCloser a() {
        return this.mAutoCloser;
    }

    public void close() {
        try {
            this.mAutoClosingDb.close();
        } catch (IOException e11) {
            SneakyThrow.reThrow(e11);
        }
    }

    @Nullable
    public String getDatabaseName() {
        return this.mDelegateOpenHelper.getDatabaseName();
    }

    @NonNull
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegateOpenHelper;
    }

    @RequiresApi(api = 24)
    @NonNull
    public SupportSQLiteDatabase getReadableDatabase() {
        this.mAutoClosingDb.o();
        return this.mAutoClosingDb;
    }

    @RequiresApi(api = 24)
    @NonNull
    public SupportSQLiteDatabase getWritableDatabase() {
        this.mAutoClosingDb.o();
        return this.mAutoClosingDb;
    }

    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z11) {
        this.mDelegateOpenHelper.setWriteAheadLoggingEnabled(z11);
    }
}
