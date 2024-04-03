package org.greenrobot.greendao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.identityscope.IdentityScopeLong;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.internal.TableStatements;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxDao;
import rx.schedulers.Schedulers;

@Instrumented
public abstract class AbstractDao<T, K> {
    protected final DaoConfig config;

    /* renamed from: db  reason: collision with root package name */
    protected final Database f27858db;
    protected final IdentityScope<K, T> identityScope;
    protected final IdentityScopeLong<T> identityScopeLong;
    protected final boolean isStandardSQLite;
    protected final int pkOrdinal;
    private volatile RxDao<T, K> rxDao;
    private volatile RxDao<T, K> rxDaoPlain;
    protected final AbstractDaoSession session;
    protected final TableStatements statements;

    public AbstractDao(DaoConfig daoConfig) {
        this(daoConfig, (AbstractDaoSession) null);
    }

    private void deleteByKeyInsideSynchronized(K k11, DatabaseStatement databaseStatement) {
        if (k11 instanceof Long) {
            databaseStatement.bindLong(1, ((Long) k11).longValue());
        } else if (k11 != null) {
            databaseStatement.bindString(1, k11.toString());
        } else {
            throw new DaoException("Cannot delete entity, key is null");
        }
        databaseStatement.execute();
    }

    private void deleteInTxInternal(Iterable<T> iterable, Iterable<K> iterable2) {
        ArrayList arrayList;
        IdentityScope<K, T> identityScope2;
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        this.f27858db.beginTransaction();
        try {
            synchronized (deleteStatement) {
                IdentityScope<K, T> identityScope3 = this.identityScope;
                if (identityScope3 != null) {
                    identityScope3.lock();
                    arrayList = new ArrayList();
                } else {
                    arrayList = null;
                }
                if (iterable != null) {
                    try {
                        for (T keyVerified : iterable) {
                            Object keyVerified2 = getKeyVerified(keyVerified);
                            deleteByKeyInsideSynchronized(keyVerified2, deleteStatement);
                            if (arrayList != null) {
                                arrayList.add(keyVerified2);
                            }
                        }
                    } finally {
                        IdentityScope<K, T> identityScope4 = this.identityScope;
                        if (identityScope4 != null) {
                            identityScope4.unlock();
                        }
                    }
                }
                if (iterable2 != null) {
                    for (K next : iterable2) {
                        deleteByKeyInsideSynchronized(next, deleteStatement);
                        if (arrayList != null) {
                            arrayList.add(next);
                        }
                    }
                }
                IdentityScope<K, T> identityScope5 = this.identityScope;
                if (identityScope5 != null) {
                    identityScope5.unlock();
                }
            }
            this.f27858db.setTransactionSuccessful();
            if (!(arrayList == null || (identityScope2 = this.identityScope) == null)) {
                identityScope2.remove((Iterable<K>) arrayList);
            }
        } finally {
            this.f27858db.endTransaction();
        }
    }

    private long executeInsert(T t11, DatabaseStatement databaseStatement, boolean z11) {
        long j11;
        if (this.f27858db.isDbLockedByCurrentThread()) {
            j11 = insertInsideTx(t11, databaseStatement);
        } else {
            this.f27858db.beginTransaction();
            try {
                j11 = insertInsideTx(t11, databaseStatement);
                this.f27858db.setTransactionSuccessful();
            } finally {
                this.f27858db.endTransaction();
            }
        }
        if (z11) {
            updateKeyAfterInsertAndAttach(t11, j11, true);
        }
        return j11;
    }

    private void executeInsertInTx(DatabaseStatement databaseStatement, Iterable<T> iterable, boolean z11) {
        this.f27858db.beginTransaction();
        try {
            synchronized (databaseStatement) {
                IdentityScope<K, T> identityScope2 = this.identityScope;
                if (identityScope2 != null) {
                    identityScope2.lock();
                }
                try {
                    if (this.isStandardSQLite) {
                        SQLiteStatement sQLiteStatement = (SQLiteStatement) databaseStatement.getRawStatement();
                        for (T next : iterable) {
                            bindValues(sQLiteStatement, next);
                            if (z11) {
                                updateKeyAfterInsertAndAttach(next, sQLiteStatement.executeInsert(), false);
                            } else {
                                sQLiteStatement.execute();
                            }
                        }
                    } else {
                        for (T next2 : iterable) {
                            bindValues(databaseStatement, next2);
                            if (z11) {
                                updateKeyAfterInsertAndAttach(next2, databaseStatement.executeInsert(), false);
                            } else {
                                databaseStatement.execute();
                            }
                        }
                    }
                } finally {
                    IdentityScope<K, T> identityScope3 = this.identityScope;
                    if (identityScope3 != null) {
                        identityScope3.unlock();
                    }
                }
            }
            this.f27858db.setTransactionSuccessful();
        } finally {
            this.f27858db.endTransaction();
        }
    }

    private long insertInsideTx(T t11, DatabaseStatement databaseStatement) {
        synchronized (databaseStatement) {
            if (this.isStandardSQLite) {
                SQLiteStatement sQLiteStatement = (SQLiteStatement) databaseStatement.getRawStatement();
                bindValues(sQLiteStatement, t11);
                long executeInsert = sQLiteStatement.executeInsert();
                return executeInsert;
            }
            bindValues(databaseStatement, t11);
            long executeInsert2 = databaseStatement.executeInsert();
            return executeInsert2;
        }
    }

    private void loadAllUnlockOnWindowBounds(Cursor cursor, CursorWindow cursorWindow, List<T> list) {
        int startPosition = cursorWindow.getStartPosition() + cursorWindow.getNumRows();
        int i11 = 0;
        while (true) {
            list.add(loadCurrent(cursor, 0, false));
            int i12 = i11 + 1;
            if (i12 >= startPosition) {
                CursorWindow moveToNextUnlocked = moveToNextUnlocked(cursor);
                if (moveToNextUnlocked != null) {
                    startPosition = moveToNextUnlocked.getStartPosition() + moveToNextUnlocked.getNumRows();
                } else {
                    return;
                }
            } else if (!cursor.moveToNext()) {
                return;
            }
            i11 = i12 + 1;
        }
    }

    private CursorWindow moveToNextUnlocked(Cursor cursor) {
        this.identityScope.unlock();
        try {
            if (cursor.moveToNext()) {
                return ((CrossProcessCursor) cursor).getWindow();
            }
            this.identityScope.lock();
            return null;
        } finally {
            this.identityScope.lock();
        }
    }

    public void assertSinglePk() {
        if (this.config.pkColumns.length != 1) {
            throw new DaoException(this + " (" + this.config.tablename + ") does not have a single-column primary key");
        }
    }

    public void attachEntity(T t11) {
    }

    public final void attachEntity(K k11, T t11, boolean z11) {
        attachEntity(t11);
        IdentityScope<K, T> identityScope2 = this.identityScope;
        if (identityScope2 != null && k11 != null) {
            if (z11) {
                identityScope2.put(k11, t11);
            } else {
                identityScope2.putNoLock(k11, t11);
            }
        }
    }

    public abstract void bindValues(SQLiteStatement sQLiteStatement, T t11);

    public abstract void bindValues(DatabaseStatement databaseStatement, T t11);

    public long count() {
        return this.statements.getCountStatement().simpleQueryForLong();
    }

    public void delete(T t11) {
        assertSinglePk();
        deleteByKey(getKeyVerified(t11));
    }

    public void deleteAll() {
        Database database = this.f27858db;
        String str = "DELETE FROM '" + this.config.tablename + "'";
        if (!(database instanceof SQLiteDatabase)) {
            database.execSQL(str);
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) database, str);
        }
        IdentityScope<K, T> identityScope2 = this.identityScope;
        if (identityScope2 != null) {
            identityScope2.clear();
        }
    }

    public void deleteByKey(K k11) {
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        if (this.f27858db.isDbLockedByCurrentThread()) {
            synchronized (deleteStatement) {
                deleteByKeyInsideSynchronized(k11, deleteStatement);
            }
        } else {
            this.f27858db.beginTransaction();
            try {
                synchronized (deleteStatement) {
                    deleteByKeyInsideSynchronized(k11, deleteStatement);
                }
                this.f27858db.setTransactionSuccessful();
                this.f27858db.endTransaction();
            } catch (Throwable th2) {
                this.f27858db.endTransaction();
                throw th2;
            }
        }
        IdentityScope<K, T> identityScope2 = this.identityScope;
        if (identityScope2 != null) {
            identityScope2.remove(k11);
        }
    }

    public void deleteByKeyInTx(Iterable<K> iterable) {
        deleteInTxInternal((Iterable) null, iterable);
    }

    public void deleteInTx(Iterable<T> iterable) {
        deleteInTxInternal(iterable, (Iterable) null);
    }

    public boolean detach(T t11) {
        if (this.identityScope == null) {
            return false;
        }
        return this.identityScope.detach(getKeyVerified(t11), t11);
    }

    public void detachAll() {
        IdentityScope<K, T> identityScope2 = this.identityScope;
        if (identityScope2 != null) {
            identityScope2.clear();
        }
    }

    public String[] getAllColumns() {
        return this.config.allColumns;
    }

    public Database getDatabase() {
        return this.f27858db;
    }

    public abstract K getKey(T t11);

    public K getKeyVerified(T t11) {
        K key = getKey(t11);
        if (key != null) {
            return key;
        }
        if (t11 == null) {
            throw new NullPointerException("Entity may not be null");
        }
        throw new DaoException("Entity has no key");
    }

    public String[] getNonPkColumns() {
        return this.config.nonPkColumns;
    }

    public String[] getPkColumns() {
        return this.config.pkColumns;
    }

    public Property getPkProperty() {
        return this.config.pkProperty;
    }

    public Property[] getProperties() {
        return this.config.properties;
    }

    public AbstractDaoSession getSession() {
        return this.session;
    }

    public TableStatements getStatements() {
        return this.config.statements;
    }

    public String getTablename() {
        return this.config.tablename;
    }

    public abstract boolean hasKey(T t11);

    public long insert(T t11) {
        return executeInsert(t11, this.statements.getInsertStatement(), true);
    }

    public void insertInTx(Iterable<T> iterable) {
        insertInTx(iterable, isEntityUpdateable());
    }

    public long insertOrReplace(T t11) {
        return executeInsert(t11, this.statements.getInsertOrReplaceStatement(), true);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable, boolean z11) {
        executeInsertInTx(this.statements.getInsertOrReplaceStatement(), iterable, z11);
    }

    public long insertWithoutSettingPk(T t11) {
        return executeInsert(t11, this.statements.getInsertOrReplaceStatement(), false);
    }

    public abstract boolean isEntityUpdateable();

    public T load(K k11) {
        Cursor cursor;
        T t11;
        assertSinglePk();
        if (k11 == null) {
            return null;
        }
        IdentityScope<K, T> identityScope2 = this.identityScope;
        if (identityScope2 != null && (t11 = identityScope2.get(k11)) != null) {
            return t11;
        }
        String selectByKey = this.statements.getSelectByKey();
        String[] strArr = {k11.toString()};
        Database database = this.f27858db;
        if (!(database instanceof SQLiteDatabase)) {
            cursor = database.rawQuery(selectByKey, strArr);
        } else {
            cursor = SQLiteInstrumentation.rawQuery((SQLiteDatabase) database, selectByKey, strArr);
        }
        return loadUniqueAndCloseCursor(cursor);
    }

    public List<T> loadAll() {
        Cursor cursor;
        Database database = this.f27858db;
        String selectAll = this.statements.getSelectAll();
        if (!(database instanceof SQLiteDatabase)) {
            cursor = database.rawQuery(selectAll, (String[]) null);
        } else {
            cursor = SQLiteInstrumentation.rawQuery((SQLiteDatabase) database, selectAll, (String[]) null);
        }
        return loadAllAndCloseCursor(cursor);
    }

    public List<T> loadAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<T> loadAllFromCursor(android.database.Cursor r7) {
        /*
            r6 = this;
            int r0 = r7.getCount()
            if (r0 != 0) goto L_0x000c
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            return r7
        L_0x000c:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            boolean r2 = r7 instanceof android.database.CrossProcessCursor
            r3 = 0
            if (r2 == 0) goto L_0x004d
            r2 = r7
            android.database.CrossProcessCursor r2 = (android.database.CrossProcessCursor) r2
            android.database.CursorWindow r2 = r2.getWindow()
            if (r2 == 0) goto L_0x004e
            int r4 = r2.getNumRows()
            if (r4 != r0) goto L_0x002c
            org.greenrobot.greendao.internal.FastCursor r7 = new org.greenrobot.greendao.internal.FastCursor
            r7.<init>(r2)
            r4 = 1
            goto L_0x004f
        L_0x002c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Window vs. result size: "
            r4.append(r5)
            int r5 = r2.getNumRows()
            r4.append(r5)
            java.lang.String r5 = "/"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            org.greenrobot.greendao.DaoLog.d(r4)
            goto L_0x004e
        L_0x004d:
            r2 = 0
        L_0x004e:
            r4 = r3
        L_0x004f:
            boolean r5 = r7.moveToFirst()
            if (r5 == 0) goto L_0x008b
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r5 = r6.identityScope
            if (r5 == 0) goto L_0x0061
            r5.lock()
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r5 = r6.identityScope
            r5.reserveRoom(r0)
        L_0x0061:
            if (r4 != 0) goto L_0x006d
            if (r2 == 0) goto L_0x006d
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r0 = r6.identityScope     // Catch:{ all -> 0x0082 }
            if (r0 == 0) goto L_0x006d
            r6.loadAllUnlockOnWindowBounds(r7, r2, r1)     // Catch:{ all -> 0x0082 }
            goto L_0x007a
        L_0x006d:
            java.lang.Object r0 = r6.loadCurrent(r7, r3, r3)     // Catch:{ all -> 0x0082 }
            r1.add(r0)     // Catch:{ all -> 0x0082 }
            boolean r0 = r7.moveToNext()     // Catch:{ all -> 0x0082 }
            if (r0 != 0) goto L_0x006d
        L_0x007a:
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r7 = r6.identityScope
            if (r7 == 0) goto L_0x008b
            r7.unlock()
            goto L_0x008b
        L_0x0082:
            r7 = move-exception
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r0 = r6.identityScope
            if (r0 == 0) goto L_0x008a
            r0.unlock()
        L_0x008a:
            throw r7
        L_0x008b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.AbstractDao.loadAllFromCursor(android.database.Cursor):java.util.List");
    }

    public T loadByRowId(long j11) {
        Cursor cursor;
        String[] strArr = {Long.toString(j11)};
        Database database = this.f27858db;
        String selectByRowId = this.statements.getSelectByRowId();
        if (!(database instanceof SQLiteDatabase)) {
            cursor = database.rawQuery(selectByRowId, strArr);
        } else {
            cursor = SQLiteInstrumentation.rawQuery((SQLiteDatabase) database, selectByRowId, strArr);
        }
        return loadUniqueAndCloseCursor(cursor);
    }

    public final T loadCurrent(Cursor cursor, int i11, boolean z11) {
        T t11;
        T t12;
        if (this.identityScopeLong != null) {
            if (i11 != 0 && cursor.isNull(this.pkOrdinal + i11)) {
                return null;
            }
            long j11 = cursor.getLong(this.pkOrdinal + i11);
            IdentityScopeLong<T> identityScopeLong2 = this.identityScopeLong;
            if (z11) {
                t12 = identityScopeLong2.get2(j11);
            } else {
                t12 = identityScopeLong2.get2NoLock(j11);
            }
            if (t12 != null) {
                return t12;
            }
            T readEntity = readEntity(cursor, i11);
            attachEntity(readEntity);
            if (z11) {
                this.identityScopeLong.put2(j11, readEntity);
            } else {
                this.identityScopeLong.put2NoLock(j11, readEntity);
            }
            return readEntity;
        } else if (this.identityScope != null) {
            Object readKey = readKey(cursor, i11);
            if (i11 != 0 && readKey == null) {
                return null;
            }
            IdentityScope<K, T> identityScope2 = this.identityScope;
            if (z11) {
                t11 = identityScope2.get(readKey);
            } else {
                t11 = identityScope2.getNoLock(readKey);
            }
            if (t11 != null) {
                return t11;
            }
            T readEntity2 = readEntity(cursor, i11);
            attachEntity(readKey, readEntity2, z11);
            return readEntity2;
        } else if (i11 != 0 && readKey(cursor, i11) == null) {
            return null;
        } else {
            T readEntity3 = readEntity(cursor, i11);
            attachEntity(readEntity3);
            return readEntity3;
        }
    }

    public final <O> O loadCurrentOther(AbstractDao<O, ?> abstractDao, Cursor cursor, int i11) {
        return abstractDao.loadCurrent(cursor, i11, true);
    }

    public T loadUnique(Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return null;
        }
        if (cursor.isLast()) {
            return loadCurrent(cursor, 0, true);
        }
        throw new DaoException("Expected unique result, but count was " + cursor.getCount());
    }

    public T loadUniqueAndCloseCursor(Cursor cursor) {
        try {
            return loadUnique(cursor);
        } finally {
            cursor.close();
        }
    }

    public QueryBuilder<T> queryBuilder() {
        return QueryBuilder.internalCreate(this);
    }

    public List<T> queryRaw(String str, String... strArr) {
        Cursor cursor;
        Database database = this.f27858db;
        String str2 = this.statements.getSelectAll() + str;
        if (!(database instanceof SQLiteDatabase)) {
            cursor = database.rawQuery(str2, strArr);
        } else {
            cursor = SQLiteInstrumentation.rawQuery((SQLiteDatabase) database, str2, strArr);
        }
        return loadAllAndCloseCursor(cursor);
    }

    public Query<T> queryRawCreate(String str, Object... objArr) {
        return queryRawCreateListArgs(str, Arrays.asList(objArr));
    }

    public Query<T> queryRawCreateListArgs(String str, Collection<Object> collection) {
        return Query.internalCreate(this, this.statements.getSelectAll() + str, collection.toArray());
    }

    public abstract T readEntity(Cursor cursor, int i11);

    public abstract void readEntity(Cursor cursor, T t11, int i11);

    public abstract K readKey(Cursor cursor, int i11);

    public void refresh(T t11) {
        Cursor cursor;
        assertSinglePk();
        Object keyVerified = getKeyVerified(t11);
        String selectByKey = this.statements.getSelectByKey();
        String[] strArr = {keyVerified.toString()};
        Database database = this.f27858db;
        if (!(database instanceof SQLiteDatabase)) {
            cursor = database.rawQuery(selectByKey, strArr);
        } else {
            cursor = SQLiteInstrumentation.rawQuery((SQLiteDatabase) database, selectByKey, strArr);
        }
        try {
            if (!cursor.moveToFirst()) {
                throw new DaoException("Entity does not exist in the database anymore: " + t11.getClass() + " with key " + keyVerified);
            } else if (cursor.isLast()) {
                readEntity(cursor, t11, 0);
                attachEntity(keyVerified, t11, true);
            } else {
                throw new DaoException("Expected unique result, but count was " + cursor.getCount());
            }
        } finally {
            cursor.close();
        }
    }

    @Experimental
    public RxDao<T, K> rx() {
        if (this.rxDao == null) {
            this.rxDao = new RxDao<>(this, Schedulers.io());
        }
        return this.rxDao;
    }

    @Experimental
    public RxDao<T, K> rxPlain() {
        if (this.rxDaoPlain == null) {
            this.rxDaoPlain = new RxDao<>(this);
        }
        return this.rxDaoPlain;
    }

    public void save(T t11) {
        if (hasKey(t11)) {
            update(t11);
        } else {
            insert(t11);
        }
    }

    public void saveInTx(T... tArr) {
        saveInTx(Arrays.asList(tArr));
    }

    public void update(T t11) {
        assertSinglePk();
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        if (this.f27858db.isDbLockedByCurrentThread()) {
            synchronized (updateStatement) {
                if (this.isStandardSQLite) {
                    updateInsideSynchronized(t11, (SQLiteStatement) updateStatement.getRawStatement(), true);
                } else {
                    updateInsideSynchronized(t11, updateStatement, true);
                }
            }
            return;
        }
        this.f27858db.beginTransaction();
        try {
            synchronized (updateStatement) {
                updateInsideSynchronized(t11, updateStatement, true);
            }
            this.f27858db.setTransactionSuccessful();
            this.f27858db.endTransaction();
        } catch (Throwable th2) {
            this.f27858db.endTransaction();
            throw th2;
        }
    }

    public void updateInTx(Iterable<T> iterable) {
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        this.f27858db.beginTransaction();
        try {
            synchronized (updateStatement) {
                IdentityScope<K, T> identityScope2 = this.identityScope;
                if (identityScope2 != null) {
                    identityScope2.lock();
                }
                try {
                    if (this.isStandardSQLite) {
                        SQLiteStatement sQLiteStatement = (SQLiteStatement) updateStatement.getRawStatement();
                        for (T updateInsideSynchronized : iterable) {
                            updateInsideSynchronized(updateInsideSynchronized, sQLiteStatement, false);
                        }
                    } else {
                        for (T updateInsideSynchronized2 : iterable) {
                            updateInsideSynchronized(updateInsideSynchronized2, updateStatement, false);
                        }
                    }
                } finally {
                    IdentityScope<K, T> identityScope3 = this.identityScope;
                    if (identityScope3 != null) {
                        identityScope3.unlock();
                    }
                }
            }
            this.f27858db.setTransactionSuccessful();
            try {
                this.f27858db.endTransaction();
                e = null;
            } catch (RuntimeException e11) {
                throw e11;
            }
        } catch (RuntimeException e12) {
            e = e12;
            try {
                this.f27858db.endTransaction();
            } catch (RuntimeException e13) {
                DaoLog.w("Could not end transaction (rethrowing initial exception)", e13);
                throw e;
            }
        } catch (Throwable th2) {
            try {
                this.f27858db.endTransaction();
                throw th2;
            } catch (RuntimeException e14) {
                throw e14;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public void updateInsideSynchronized(T t11, DatabaseStatement databaseStatement, boolean z11) {
        bindValues(databaseStatement, t11);
        int length = this.config.allColumns.length + 1;
        Object key = getKey(t11);
        if (key instanceof Long) {
            databaseStatement.bindLong(length, ((Long) key).longValue());
        } else if (key != null) {
            databaseStatement.bindString(length, key.toString());
        } else {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        }
        databaseStatement.execute();
        attachEntity(key, t11, z11);
    }

    public abstract K updateKeyAfterInsert(T t11, long j11);

    public void updateKeyAfterInsertAndAttach(T t11, long j11, boolean z11) {
        if (j11 != -1) {
            attachEntity(updateKeyAfterInsert(t11, j11), t11, z11);
        } else {
            DaoLog.w("Could not insert row (executeInsert returned -1)");
        }
    }

    public AbstractDao(DaoConfig daoConfig, AbstractDaoSession abstractDaoSession) {
        this.config = daoConfig;
        this.session = abstractDaoSession;
        Database database = daoConfig.f27875db;
        this.f27858db = database;
        this.isStandardSQLite = database.getRawDatabase() instanceof SQLiteDatabase;
        IdentityScope<?, ?> identityScope2 = daoConfig.getIdentityScope();
        this.identityScope = identityScope2;
        if (identityScope2 instanceof IdentityScopeLong) {
            this.identityScopeLong = (IdentityScopeLong) identityScope2;
        } else {
            this.identityScopeLong = null;
        }
        this.statements = daoConfig.statements;
        Property property = daoConfig.pkProperty;
        this.pkOrdinal = property != null ? property.ordinal : -1;
    }

    public void deleteByKeyInTx(K... kArr) {
        deleteInTxInternal((Iterable) null, Arrays.asList(kArr));
    }

    public void deleteInTx(T... tArr) {
        deleteInTxInternal(Arrays.asList(tArr), (Iterable) null);
    }

    public void insertInTx(T... tArr) {
        insertInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    public void saveInTx(Iterable<T> iterable) {
        int i11 = 0;
        int i12 = 0;
        for (T hasKey : iterable) {
            if (hasKey(hasKey)) {
                i11++;
            } else {
                i12++;
            }
        }
        if (i11 > 0 && i12 > 0) {
            ArrayList arrayList = new ArrayList(i11);
            ArrayList arrayList2 = new ArrayList(i12);
            for (T next : iterable) {
                if (hasKey(next)) {
                    arrayList.add(next);
                } else {
                    arrayList2.add(next);
                }
            }
            this.f27858db.beginTransaction();
            try {
                updateInTx(arrayList);
                insertInTx(arrayList2);
                this.f27858db.setTransactionSuccessful();
            } finally {
                this.f27858db.endTransaction();
            }
        } else if (i12 > 0) {
            insertInTx(iterable);
        } else if (i11 > 0) {
            updateInTx(iterable);
        }
    }

    public void insertInTx(Iterable<T> iterable, boolean z11) {
        executeInsertInTx(this.statements.getInsertStatement(), iterable, z11);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable) {
        insertOrReplaceInTx(iterable, isEntityUpdateable());
    }

    public void insertOrReplaceInTx(T... tArr) {
        insertOrReplaceInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    public void updateInsideSynchronized(T t11, SQLiteStatement sQLiteStatement, boolean z11) {
        bindValues(sQLiteStatement, t11);
        int length = this.config.allColumns.length + 1;
        Object key = getKey(t11);
        if (key instanceof Long) {
            sQLiteStatement.bindLong(length, ((Long) key).longValue());
        } else if (key != null) {
            sQLiteStatement.bindString(length, key.toString());
        } else {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        }
        sQLiteStatement.execute();
        attachEntity(key, t11, z11);
    }

    public void updateInTx(T... tArr) {
        updateInTx(Arrays.asList(tArr));
    }
}
