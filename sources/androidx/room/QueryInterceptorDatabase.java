package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import n2.c;

final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    public QueryInterceptorDatabase(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, @NonNull RoomDatabase.QueryCallback queryCallback, @NonNull Executor executor) {
        this.mDelegate = supportSQLiteDatabase;
        this.mQueryCallback = queryCallback;
        this.mQueryCallbackExecutor = executor;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$beginTransaction$0() {
        this.mQueryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$beginTransactionNonExclusive$1() {
        this.mQueryCallback.onQuery("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$beginTransactionWithListener$2() {
        this.mQueryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$beginTransactionWithListenerNonExclusive$3() {
        this.mQueryCallback.onQuery("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$endTransaction$4() {
        this.mQueryCallback.onQuery("END TRANSACTION", Collections.emptyList());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$execSQL$10(String str) {
        this.mQueryCallback.onQuery(str, new ArrayList(0));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$execSQL$11(String str, List list) {
        this.mQueryCallback.onQuery(str, list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$query$6(String str) {
        this.mQueryCallback.onQuery(str, Collections.emptyList());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$query$7(String str, List list) {
        this.mQueryCallback.onQuery(str, list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$query$8(SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.mQueryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$query$9(SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.mQueryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setTransactionSuccessful$5() {
        this.mQueryCallback.onQuery("TRANSACTION SUCCESSFUL", Collections.emptyList());
    }

    public void beginTransaction() {
        this.mQueryCallbackExecutor.execute(new z(this));
        this.mDelegate.beginTransaction();
    }

    public void beginTransactionNonExclusive() {
        this.mQueryCallbackExecutor.execute(new q(this));
        this.mDelegate.beginTransactionNonExclusive();
    }

    public void beginTransactionWithListener(@NonNull SQLiteTransactionListener sQLiteTransactionListener) {
        this.mQueryCallbackExecutor.execute(new t(this));
        this.mDelegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerNonExclusive(@NonNull SQLiteTransactionListener sQLiteTransactionListener) {
        this.mQueryCallbackExecutor.execute(new x(this));
        this.mDelegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    public void close() throws IOException {
        this.mDelegate.close();
    }

    @NonNull
    public SupportSQLiteStatement compileStatement(@NonNull String str) {
        return new QueryInterceptorStatement(this.mDelegate.compileStatement(str), this.mQueryCallback, str, this.mQueryCallbackExecutor);
    }

    public int delete(@NonNull String str, @NonNull String str2, @NonNull Object[] objArr) {
        return this.mDelegate.delete(str, str2, objArr);
    }

    @RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        this.mDelegate.disableWriteAheadLogging();
    }

    public boolean enableWriteAheadLogging() {
        return this.mDelegate.enableWriteAheadLogging();
    }

    public void endTransaction() {
        this.mQueryCallbackExecutor.execute(new b0(this));
        this.mDelegate.endTransaction();
    }

    public /* synthetic */ void execPerConnectionSQL(String str, Object[] objArr) {
        c.a(this, str, objArr);
    }

    public void execSQL(@NonNull String str) throws SQLException {
        this.mQueryCallbackExecutor.execute(new s(this, str));
        this.mDelegate.execSQL(str);
    }

    @NonNull
    public List<Pair<String, String>> getAttachedDbs() {
        return this.mDelegate.getAttachedDbs();
    }

    public long getMaximumSize() {
        return this.mDelegate.getMaximumSize();
    }

    public long getPageSize() {
        return this.mDelegate.getPageSize();
    }

    @NonNull
    public String getPath() {
        return this.mDelegate.getPath();
    }

    public int getVersion() {
        return this.mDelegate.getVersion();
    }

    public boolean inTransaction() {
        return this.mDelegate.inTransaction();
    }

    public long insert(@NonNull String str, int i11, @NonNull ContentValues contentValues) throws SQLException {
        return this.mDelegate.insert(str, i11, contentValues);
    }

    public boolean isDatabaseIntegrityOk() {
        return this.mDelegate.isDatabaseIntegrityOk();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.mDelegate.isDbLockedByCurrentThread();
    }

    public /* synthetic */ boolean isExecPerConnectionSQLSupported() {
        return c.b(this);
    }

    public boolean isOpen() {
        return this.mDelegate.isOpen();
    }

    public boolean isReadOnly() {
        return this.mDelegate.isReadOnly();
    }

    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return this.mDelegate.isWriteAheadLoggingEnabled();
    }

    public boolean needUpgrade(int i11) {
        return this.mDelegate.needUpgrade(i11);
    }

    @NonNull
    public Cursor query(@NonNull String str) {
        this.mQueryCallbackExecutor.execute(new a0(this, str));
        return this.mDelegate.query(str);
    }

    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean z11) {
        this.mDelegate.setForeignKeyConstraintsEnabled(z11);
    }

    public void setLocale(@NonNull Locale locale) {
        this.mDelegate.setLocale(locale);
    }

    public void setMaxSqlCacheSize(int i11) {
        this.mDelegate.setMaxSqlCacheSize(i11);
    }

    public long setMaximumSize(long j11) {
        return this.mDelegate.setMaximumSize(j11);
    }

    public void setPageSize(long j11) {
        this.mDelegate.setPageSize(j11);
    }

    public void setTransactionSuccessful() {
        this.mQueryCallbackExecutor.execute(new w(this));
        this.mDelegate.setTransactionSuccessful();
    }

    public void setVersion(int i11) {
        this.mDelegate.setVersion(i11);
    }

    public int update(@NonNull String str, int i11, @NonNull ContentValues contentValues, @NonNull String str2, @NonNull Object[] objArr) {
        return this.mDelegate.update(str, i11, contentValues, str2, objArr);
    }

    public boolean yieldIfContendedSafely() {
        return this.mDelegate.yieldIfContendedSafely();
    }

    public boolean yieldIfContendedSafely(long j11) {
        return this.mDelegate.yieldIfContendedSafely(j11);
    }

    public void execSQL(@NonNull String str, @NonNull Object[] objArr) throws SQLException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(objArr));
        this.mQueryCallbackExecutor.execute(new c0(this, str, arrayList));
        this.mDelegate.execSQL(str, arrayList.toArray());
    }

    @NonNull
    public Cursor query(@NonNull String str, @NonNull Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(objArr));
        this.mQueryCallbackExecutor.execute(new v(this, str, arrayList));
        return this.mDelegate.query(str, objArr);
    }

    @NonNull
    public Cursor query(@NonNull SupportSQLiteQuery supportSQLiteQuery) {
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        this.mQueryCallbackExecutor.execute(new y(this, supportSQLiteQuery, queryInterceptorProgram));
        return this.mDelegate.query(supportSQLiteQuery);
    }

    @NonNull
    public Cursor query(@NonNull SupportSQLiteQuery supportSQLiteQuery, @NonNull CancellationSignal cancellationSignal) {
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        this.mQueryCallbackExecutor.execute(new u(this, supportSQLiteQuery, queryInterceptorProgram));
        return this.mDelegate.query(supportSQLiteQuery);
    }
}
