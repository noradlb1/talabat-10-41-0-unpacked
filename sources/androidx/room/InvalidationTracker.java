package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import j2.o;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import net.bytebuddy.utility.JavaConstant;

public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Integer> f37421a;

    /* renamed from: b  reason: collision with root package name */
    public final String[] f37422b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public AutoCloser f37423c;

    /* renamed from: d  reason: collision with root package name */
    public final RoomDatabase f37424d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f37425e;

    /* renamed from: f  reason: collision with root package name */
    public volatile SupportSQLiteStatement f37426f;
    @VisibleForTesting
    @SuppressLint({"RestrictedApi"})

    /* renamed from: g  reason: collision with root package name */
    public final SafeIterableMap<Observer, ObserverWrapper> f37427g;
    @VisibleForTesting

    /* renamed from: h  reason: collision with root package name */
    public Runnable f37428h;
    private volatile boolean mInitialized;
    private final InvalidationLiveDataContainer mInvalidationLiveDataContainer;
    private MultiInstanceInvalidationClient mMultiInstanceInvalidationClient;
    private final ObservedTableTracker mObservedTableTracker;
    private final Object mSyncTriggersLock;
    @NonNull
    private Map<String, Set<String>> mViewTables;

    public static class ObservedTableTracker {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f37430a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f37431b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f37432c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f37433d;

        public ObservedTableTracker(int i11) {
            long[] jArr = new long[i11];
            this.f37430a = jArr;
            boolean[] zArr = new boolean[i11];
            this.f37431b = zArr;
            this.f37432c = new int[i11];
            Arrays.fill(jArr, 0);
            Arrays.fill(zArr, false);
        }

        @Nullable
        public int[] a() {
            boolean z11;
            synchronized (this) {
                if (!this.f37433d) {
                    return null;
                }
                int length = this.f37430a.length;
                for (int i11 = 0; i11 < length; i11++) {
                    int i12 = 1;
                    if (this.f37430a[i11] > 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    boolean[] zArr = this.f37431b;
                    if (z11 != zArr[i11]) {
                        int[] iArr = this.f37432c;
                        if (!z11) {
                            i12 = 2;
                        }
                        iArr[i11] = i12;
                    } else {
                        this.f37432c[i11] = 0;
                    }
                    zArr[i11] = z11;
                }
                this.f37433d = false;
                int[] iArr2 = (int[]) this.f37432c.clone();
                return iArr2;
            }
        }

        public boolean b(int... iArr) {
            boolean z11;
            synchronized (this) {
                z11 = false;
                for (int i11 : iArr) {
                    long[] jArr = this.f37430a;
                    long j11 = jArr[i11];
                    jArr[i11] = 1 + j11;
                    if (j11 == 0) {
                        z11 = true;
                        this.f37433d = true;
                    }
                }
            }
            return z11;
        }

        public boolean c(int... iArr) {
            boolean z11;
            synchronized (this) {
                z11 = false;
                for (int i11 : iArr) {
                    long[] jArr = this.f37430a;
                    long j11 = jArr[i11];
                    jArr[i11] = j11 - 1;
                    if (j11 == 1) {
                        z11 = true;
                        this.f37433d = true;
                    }
                }
            }
            return z11;
        }

        public void d() {
            synchronized (this) {
                Arrays.fill(this.f37431b, false);
                this.f37433d = true;
            }
        }
    }

    public static abstract class Observer {

        /* renamed from: a  reason: collision with root package name */
        public final String[] f37434a;

        public Observer(@NonNull String[] strArr) {
            this.f37434a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        public boolean a() {
            return false;
        }

        public abstract void onInvalidated(@NonNull Set<String> set);
    }

    public static class ObserverWrapper {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f37435a;

        /* renamed from: b  reason: collision with root package name */
        public final Observer f37436b;
        private final Set<String> mSingleTableSet;
        private final String[] mTableNames;

        public ObserverWrapper(Observer observer, int[] iArr, String[] strArr) {
            this.f37436b = observer;
            this.f37435a = iArr;
            this.mTableNames = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                this.mSingleTableSet = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.mSingleTableSet = null;
        }

        public void a(Set<Integer> set) {
            int length = this.f37435a.length;
            Set set2 = null;
            for (int i11 = 0; i11 < length; i11++) {
                if (set.contains(Integer.valueOf(this.f37435a[i11]))) {
                    if (length == 1) {
                        set2 = this.mSingleTableSet;
                    } else {
                        if (set2 == null) {
                            set2 = new HashSet(length);
                        }
                        set2.add(this.mTableNames[i11]);
                    }
                }
            }
            if (set2 != null) {
                this.f37436b.onInvalidated(set2);
            }
        }

        public void b(String[] strArr) {
            Set<String> set = null;
            if (this.mTableNames.length == 1) {
                int length = strArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    } else if (strArr[i11].equalsIgnoreCase(this.mTableNames[0])) {
                        set = this.mSingleTableSet;
                        break;
                    } else {
                        i11++;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.mTableNames;
                    int length2 = strArr2.length;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= length2) {
                            break;
                        }
                        String str2 = strArr2[i12];
                        if (str2.equalsIgnoreCase(str)) {
                            hashSet.add(str2);
                            break;
                        }
                        i12++;
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f37436b.onInvalidated(set);
            }
        }
    }

    public static class WeakObserver extends Observer {

        /* renamed from: b  reason: collision with root package name */
        public final InvalidationTracker f37437b;

        /* renamed from: c  reason: collision with root package name */
        public final WeakReference<Observer> f37438c;

        public WeakObserver(InvalidationTracker invalidationTracker, Observer observer) {
            super(observer.f37434a);
            this.f37437b = invalidationTracker;
            this.f37438c = new WeakReference<>(observer);
        }

        public void onInvalidated(@NonNull Set<String> set) {
            Observer observer = this.f37438c.get();
            if (observer == null) {
                this.f37437b.removeObserver(this);
            } else {
                observer.onInvalidated(set);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, String... strArr) {
        this(roomDatabase, new HashMap(), Collections.emptyMap(), strArr);
    }

    private static void appendTriggerName(StringBuilder sb2, String str, String str2) {
        sb2.append("`");
        sb2.append("room_table_modification_trigger_");
        sb2.append(str);
        sb2.append(JavaConstant.Dynamic.DEFAULT_NAME);
        sb2.append(str2);
        sb2.append("`");
    }

    private static void beginTransactionInternal(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (supportSQLiteDatabase.isWriteAheadLoggingEnabled()) {
            supportSQLiteDatabase.beginTransactionNonExclusive();
        } else {
            supportSQLiteDatabase.beginTransaction();
        }
    }

    private String[] resolveViews(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.mViewTables.containsKey(lowerCase)) {
                hashSet.addAll(this.mViewTables.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i11) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i11 + ", 0)");
        String str = this.f37422b[i11];
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : TRIGGERS) {
            sb2.setLength(0);
            sb2.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            appendTriggerName(sb2, str, str2);
            sb2.append(" AFTER ");
            sb2.append(str2);
            sb2.append(" ON `");
            sb2.append(str);
            sb2.append("` BEGIN UPDATE ");
            sb2.append(UPDATE_TABLE_NAME);
            sb2.append(" SET ");
            sb2.append(INVALIDATED_COLUMN_NAME);
            sb2.append(" = 1");
            sb2.append(" WHERE ");
            sb2.append(TABLE_ID_COLUMN_NAME);
            sb2.append(" = ");
            sb2.append(i11);
            sb2.append(" AND ");
            sb2.append(INVALIDATED_COLUMN_NAME);
            sb2.append(" = 0");
            sb2.append("; END");
            supportSQLiteDatabase.execSQL(sb2.toString());
        }
    }

    private void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i11) {
        String str = this.f37422b[i11];
        StringBuilder sb2 = new StringBuilder();
        for (String appendTriggerName : TRIGGERS) {
            sb2.setLength(0);
            sb2.append("DROP TRIGGER IF EXISTS ");
            appendTriggerName(sb2, str, appendTriggerName);
            supportSQLiteDatabase.execSQL(sb2.toString());
        }
    }

    private String[] validateAndResolveTableNames(String[] strArr) {
        String[] resolveViews = resolveViews(strArr);
        int length = resolveViews.length;
        int i11 = 0;
        while (i11 < length) {
            String str = resolveViews[i11];
            if (this.f37421a.containsKey(str.toLowerCase(Locale.US))) {
                i11++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        return resolveViews;
    }

    public boolean a() {
        if (!this.f37424d.isOpen()) {
            return false;
        }
        if (!this.mInitialized) {
            this.f37424d.getOpenHelper().getWritableDatabase();
        }
        if (this.mInitialized) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    @WorkerThread
    @SuppressLint({"RestrictedApi"})
    public void addObserver(@NonNull Observer observer) {
        ObserverWrapper putIfAbsent;
        String[] resolveViews = resolveViews(observer.f37434a);
        int[] iArr = new int[resolveViews.length];
        int length = resolveViews.length;
        int i11 = 0;
        while (i11 < length) {
            Integer num = this.f37421a.get(resolveViews[i11].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i11] = num.intValue();
                i11++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + resolveViews[i11]);
            }
        }
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArr, resolveViews);
        synchronized (this.f37427g) {
            putIfAbsent = this.f37427g.putIfAbsent(observer, observerWrapper);
        }
        if (putIfAbsent == null && this.mObservedTableTracker.b(iArr)) {
            g();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(Observer observer) {
        addObserver(new WeakObserver(this, observer));
    }

    public void b(SupportSQLiteDatabase supportSQLiteDatabase) {
        synchronized (this) {
            if (this.mInitialized) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            supportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
            supportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
            supportSQLiteDatabase.execSQL(CREATE_TRACKING_TABLE_SQL);
            h(supportSQLiteDatabase);
            this.f37426f = supportSQLiteDatabase.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.mInitialized = true;
        }
    }

    public void c() {
        synchronized (this) {
            this.mInitialized = false;
            this.mObservedTableTracker.d();
        }
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, Callable<T> callable) {
        return createLiveData(strArr, false, callable);
    }

    public void d(AutoCloser autoCloser) {
        this.f37423c = autoCloser;
        autoCloser.setAutoCloseCallback(new o(this));
    }

    public void e(Context context, String str, Intent intent) {
        this.mMultiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, str, intent, this, this.f37424d.getQueryExecutor());
    }

    public void f() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.mMultiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.a();
            this.mMultiInstanceInvalidationClient = null;
        }
    }

    public void g() {
        if (this.f37424d.isOpen()) {
            h(this.f37424d.getOpenHelper().getWritableDatabase());
        }
    }

    public void h(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (!supportSQLiteDatabase.inTransaction()) {
            try {
                Lock closeLock = this.f37424d.getCloseLock();
                closeLock.lock();
                try {
                    synchronized (this.mSyncTriggersLock) {
                        int[] a11 = this.mObservedTableTracker.a();
                        if (a11 != null) {
                            int length = a11.length;
                            beginTransactionInternal(supportSQLiteDatabase);
                            int i11 = 0;
                            while (i11 < length) {
                                try {
                                    int i12 = a11[i11];
                                    if (i12 == 1) {
                                        startTrackingTable(supportSQLiteDatabase, i11);
                                    } else if (i12 == 2) {
                                        stopTrackingTable(supportSQLiteDatabase, i11);
                                    }
                                    i11++;
                                } catch (Throwable th2) {
                                    supportSQLiteDatabase.endTransaction();
                                    throw th2;
                                }
                            }
                            supportSQLiteDatabase.setTransactionSuccessful();
                            supportSQLiteDatabase.endTransaction();
                            closeLock.unlock();
                        }
                    }
                } finally {
                    closeLock.unlock();
                }
            } catch (SQLiteException | IllegalStateException e11) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e11);
            }
        }
    }

    @VisibleForTesting(otherwise = 3)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void notifyObserversByTableNames(String... strArr) {
        synchronized (this.f37427g) {
            Iterator<Map.Entry<Observer, ObserverWrapper>> it = this.f37427g.iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (!((Observer) next.getKey()).a()) {
                    ((ObserverWrapper) next.getValue()).b(strArr);
                }
            }
        }
    }

    public void refreshVersionsAsync() {
        if (this.f37425e.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.f37423c;
            if (autoCloser != null) {
                autoCloser.incrementCountAndEnsureDbIsOpen();
            }
            this.f37424d.getQueryExecutor().execute(this.f37428h);
        }
    }

    @WorkerThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void refreshVersionsSync() {
        AutoCloser autoCloser = this.f37423c;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        g();
        this.f37428h.run();
    }

    @WorkerThread
    @SuppressLint({"RestrictedApi"})
    public void removeObserver(@NonNull Observer observer) {
        ObserverWrapper remove;
        synchronized (this.f37427g) {
            remove = this.f37427g.remove(observer);
        }
        if (remove != null && this.mObservedTableTracker.c(remove.f37435a)) {
            g();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f37423c = null;
        this.f37425e = new AtomicBoolean(false);
        this.mInitialized = false;
        this.f37427g = new SafeIterableMap<>();
        this.mSyncTriggersLock = new Object();
        this.f37428h = new Runnable() {
            /* JADX INFO: finally extract failed */
            private Set<Integer> checkUpdatedTable() {
                HashSet hashSet = new HashSet();
                Cursor query = InvalidationTracker.this.f37424d.query(new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
                while (query.moveToNext()) {
                    try {
                        hashSet.add(Integer.valueOf(query.getInt(0)));
                    } catch (Throwable th2) {
                        query.close();
                        throw th2;
                    }
                }
                query.close();
                if (!hashSet.isEmpty()) {
                    InvalidationTracker.this.f37426f.executeUpdateDelete();
                }
                return hashSet;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
                if (r0 != null) goto L_0x0073;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
                r0.decrementCountAndScheduleClose();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:0x008f, code lost:
                if (r0 == null) goto L_0x0092;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x0092, code lost:
                if (r1 == null) goto L_?;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x0098, code lost:
                if (r1.isEmpty() != false) goto L_?;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x009a, code lost:
                r0 = r5.f37429b.f37427g;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x009e, code lost:
                monitor-enter(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
                r2 = r5.f37429b.f37427g.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ab, code lost:
                if (r2.hasNext() == false) goto L_0x00bd;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ad, code lost:
                ((androidx.room.InvalidationTracker.ObserverWrapper) r2.next().getValue()).a(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bd, code lost:
                monitor-exit(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.room.RoomDatabase r0 = r0.f37424d
                    java.util.concurrent.locks.Lock r0 = r0.getCloseLock()
                    r0.lock()
                    r1 = 0
                    androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    boolean r2 = r2.a()     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    if (r2 != 0) goto L_0x0021
                    r0.unlock()
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.room.AutoCloser r0 = r0.f37423c
                    if (r0 == 0) goto L_0x0020
                    r0.decrementCountAndScheduleClose()
                L_0x0020:
                    return
                L_0x0021:
                    androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    java.util.concurrent.atomic.AtomicBoolean r2 = r2.f37425e     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    r3 = 1
                    r4 = 0
                    boolean r2 = r2.compareAndSet(r3, r4)     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    if (r2 != 0) goto L_0x003a
                    r0.unlock()
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.room.AutoCloser r0 = r0.f37423c
                    if (r0 == 0) goto L_0x0039
                    r0.decrementCountAndScheduleClose()
                L_0x0039:
                    return
                L_0x003a:
                    androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    androidx.room.RoomDatabase r2 = r2.f37424d     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    boolean r2 = r2.inTransaction()     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    if (r2 == 0) goto L_0x0051
                    r0.unlock()
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.room.AutoCloser r0 = r0.f37423c
                    if (r0 == 0) goto L_0x0050
                    r0.decrementCountAndScheduleClose()
                L_0x0050:
                    return
                L_0x0051:
                    androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    androidx.room.RoomDatabase r2 = r2.f37424d     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    androidx.sqlite.db.SupportSQLiteOpenHelper r2 = r2.getOpenHelper()     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    androidx.sqlite.db.SupportSQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    r2.beginTransactionNonExclusive()     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    java.util.Set r1 = r5.checkUpdatedTable()     // Catch:{ all -> 0x0077 }
                    r2.setTransactionSuccessful()     // Catch:{ all -> 0x0077 }
                    r2.endTransaction()     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    r0.unlock()
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.room.AutoCloser r0 = r0.f37423c
                    if (r0 == 0) goto L_0x0092
                L_0x0073:
                    r0.decrementCountAndScheduleClose()
                    goto L_0x0092
                L_0x0077:
                    r3 = move-exception
                    r2.endTransaction()     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                    throw r3     // Catch:{ IllegalStateException -> 0x0080, SQLiteException -> 0x007e }
                L_0x007c:
                    r1 = move-exception
                    goto L_0x00c3
                L_0x007e:
                    r2 = move-exception
                    goto L_0x0081
                L_0x0080:
                    r2 = move-exception
                L_0x0081:
                    java.lang.String r3 = "ROOM"
                    java.lang.String r4 = "Cannot run invalidation tracker. Is the db closed?"
                    android.util.Log.e(r3, r4, r2)     // Catch:{ all -> 0x007c }
                    r0.unlock()
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.room.AutoCloser r0 = r0.f37423c
                    if (r0 == 0) goto L_0x0092
                    goto L_0x0073
                L_0x0092:
                    if (r1 == 0) goto L_0x00c2
                    boolean r0 = r1.isEmpty()
                    if (r0 != 0) goto L_0x00c2
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker$Observer, androidx.room.InvalidationTracker$ObserverWrapper> r0 = r0.f37427g
                    monitor-enter(r0)
                    androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch:{ all -> 0x00bf }
                    androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker$Observer, androidx.room.InvalidationTracker$ObserverWrapper> r2 = r2.f37427g     // Catch:{ all -> 0x00bf }
                    java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00bf }
                L_0x00a7:
                    boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00bf }
                    if (r3 == 0) goto L_0x00bd
                    java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00bf }
                    java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x00bf }
                    java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x00bf }
                    androidx.room.InvalidationTracker$ObserverWrapper r3 = (androidx.room.InvalidationTracker.ObserverWrapper) r3     // Catch:{ all -> 0x00bf }
                    r3.a(r1)     // Catch:{ all -> 0x00bf }
                    goto L_0x00a7
                L_0x00bd:
                    monitor-exit(r0)     // Catch:{ all -> 0x00bf }
                    goto L_0x00c2
                L_0x00bf:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x00bf }
                    throw r1
                L_0x00c2:
                    return
                L_0x00c3:
                    r0.unlock()
                    androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                    androidx.room.AutoCloser r0 = r0.f37423c
                    if (r0 == 0) goto L_0x00cf
                    r0.decrementCountAndScheduleClose()
                L_0x00cf:
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.AnonymousClass1.run():void");
            }
        };
        this.f37424d = roomDatabase;
        this.mObservedTableTracker = new ObservedTableTracker(strArr.length);
        this.f37421a = new HashMap<>();
        this.mViewTables = map2;
        this.mInvalidationLiveDataContainer = new InvalidationLiveDataContainer(roomDatabase);
        int length = strArr.length;
        this.f37422b = new String[length];
        for (int i11 = 0; i11 < length; i11++) {
            String str = strArr[i11];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f37421a.put(lowerCase, Integer.valueOf(i11));
            String str2 = map.get(strArr[i11]);
            if (str2 != null) {
                this.f37422b[i11] = str2.toLowerCase(locale);
            } else {
                this.f37422b[i11] = lowerCase;
            }
        }
        for (Map.Entry next : map.entrySet()) {
            Locale locale2 = Locale.US;
            String lowerCase2 = ((String) next.getValue()).toLowerCase(locale2);
            if (this.f37421a.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) next.getKey()).toLowerCase(locale2);
                HashMap<String, Integer> hashMap = this.f37421a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, boolean z11, Callable<T> callable) {
        return this.mInvalidationLiveDataContainer.a(validateAndResolveTableNames(strArr), z11, callable);
    }
}
