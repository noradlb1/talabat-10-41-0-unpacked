package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import j$.util.DesugarCollections;
import j2.p;
import j2.q;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class RoomDatabase {
    private static final String DB_IMPL_SUFFIX = "_Impl";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;
    @Nullable
    private AutoCloser mAutoCloser;
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> mAutoMigrationSpecs = new HashMap();
    private final Map<String, Object> mBackingFieldMap = DesugarCollections.synchronizedMap(new HashMap());
    /* access modifiers changed from: protected */
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public List<Callback> mCallbacks;
    private final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    /* access modifiers changed from: protected */
    @Deprecated
    public volatile SupportSQLiteDatabase mDatabase;
    private final InvalidationTracker mInvalidationTracker = createInvalidationTracker();
    private SupportSQLiteOpenHelper mOpenHelper;
    private Executor mQueryExecutor;
    private final ThreadLocal<Integer> mSuspendingTransactionId = new ThreadLocal<>();
    private Executor mTransactionExecutor;
    private final Map<Class<?>, Object> mTypeConverters = new HashMap();
    boolean mWriteAheadLoggingEnabled;

    public static class Builder<T extends RoomDatabase> {
        private boolean mAllowDestructiveMigrationOnDowngrade;
        private boolean mAllowMainThreadQueries;
        private TimeUnit mAutoCloseTimeUnit;
        private long mAutoCloseTimeout = -1;
        private List<AutoMigrationSpec> mAutoMigrationSpecs;
        private ArrayList<Callback> mCallbacks;
        private final Context mContext;
        private String mCopyFromAssetPath;
        private File mCopyFromFile;
        private Callable<InputStream> mCopyFromInputStream;
        private final Class<T> mDatabaseClass;
        private SupportSQLiteOpenHelper.Factory mFactory;
        private JournalMode mJournalMode;
        private final MigrationContainer mMigrationContainer;
        private Set<Integer> mMigrationStartAndEndVersions;
        private Set<Integer> mMigrationsNotRequiredFrom;
        private Intent mMultiInstanceInvalidationIntent;
        private final String mName;
        private PrepackagedDatabaseCallback mPrepackagedDatabaseCallback;
        private QueryCallback mQueryCallback;
        private Executor mQueryCallbackExecutor;
        private Executor mQueryExecutor;
        private boolean mRequireMigration;
        private Executor mTransactionExecutor;
        private List<Object> mTypeConverters;

        public Builder(@NonNull Context context, @NonNull Class<T> cls, @Nullable String str) {
            this.mContext = context;
            this.mDatabaseClass = cls;
            this.mName = str;
            this.mJournalMode = JournalMode.AUTOMATIC;
            this.mRequireMigration = true;
            this.mMigrationContainer = new MigrationContainer();
        }

        @NonNull
        public Builder<T> addAutoMigrationSpec(@NonNull AutoMigrationSpec autoMigrationSpec) {
            if (this.mAutoMigrationSpecs == null) {
                this.mAutoMigrationSpecs = new ArrayList();
            }
            this.mAutoMigrationSpecs.add(autoMigrationSpec);
            return this;
        }

        @NonNull
        public Builder<T> addCallback(@NonNull Callback callback) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new ArrayList<>();
            }
            this.mCallbacks.add(callback);
            return this;
        }

        @NonNull
        public Builder<T> addMigrations(@NonNull Migration... migrationArr) {
            if (this.mMigrationStartAndEndVersions == null) {
                this.mMigrationStartAndEndVersions = new HashSet();
            }
            for (Migration migration : migrationArr) {
                this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
                this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
            }
            this.mMigrationContainer.addMigrations(migrationArr);
            return this;
        }

        @NonNull
        public Builder<T> addTypeConverter(@NonNull Object obj) {
            if (this.mTypeConverters == null) {
                this.mTypeConverters = new ArrayList();
            }
            this.mTypeConverters.add(obj);
            return this;
        }

        @NonNull
        public Builder<T> allowMainThreadQueries() {
            this.mAllowMainThreadQueries = true;
            return this;
        }

        @SuppressLint({"RestrictedApi"})
        @NonNull
        public T build() {
            QueryInterceptorOpenHelperFactory queryInterceptorOpenHelperFactory;
            int i11;
            int i12;
            Executor executor;
            if (this.mContext == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            } else if (this.mDatabaseClass != null) {
                Executor executor2 = this.mQueryExecutor;
                if (executor2 == null && this.mTransactionExecutor == null) {
                    Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
                    this.mTransactionExecutor = iOThreadExecutor;
                    this.mQueryExecutor = iOThreadExecutor;
                } else if (executor2 != null && this.mTransactionExecutor == null) {
                    this.mTransactionExecutor = executor2;
                } else if (executor2 == null && (executor = this.mTransactionExecutor) != null) {
                    this.mQueryExecutor = executor;
                }
                Set<Integer> set = this.mMigrationStartAndEndVersions;
                if (!(set == null || this.mMigrationsNotRequiredFrom == null)) {
                    for (Integer next : set) {
                        if (this.mMigrationsNotRequiredFrom.contains(next)) {
                            throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + next);
                        }
                    }
                }
                AutoClosingRoomOpenHelperFactory autoClosingRoomOpenHelperFactory = this.mFactory;
                if (autoClosingRoomOpenHelperFactory == null) {
                    autoClosingRoomOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
                }
                long j11 = this.mAutoCloseTimeout;
                if (j11 > 0) {
                    if (this.mName != null) {
                        autoClosingRoomOpenHelperFactory = new AutoClosingRoomOpenHelperFactory(autoClosingRoomOpenHelperFactory, new AutoCloser(j11, this.mAutoCloseTimeUnit, this.mTransactionExecutor));
                    } else {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                }
                String str = this.mCopyFromAssetPath;
                if (!(str == null && this.mCopyFromFile == null && this.mCopyFromInputStream == null)) {
                    if (this.mName != null) {
                        int i13 = 0;
                        if (str == null) {
                            i11 = 0;
                        } else {
                            i11 = 1;
                        }
                        File file = this.mCopyFromFile;
                        if (file == null) {
                            i12 = 0;
                        } else {
                            i12 = 1;
                        }
                        int i14 = i11 + i12;
                        Callable<InputStream> callable = this.mCopyFromInputStream;
                        if (callable != null) {
                            i13 = 1;
                        }
                        if (i14 + i13 == 1) {
                            autoClosingRoomOpenHelperFactory = new SQLiteCopyOpenHelperFactory(str, file, callable, autoClosingRoomOpenHelperFactory);
                        } else {
                            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                }
                QueryCallback queryCallback = this.mQueryCallback;
                if (queryCallback != null) {
                    queryInterceptorOpenHelperFactory = new QueryInterceptorOpenHelperFactory(autoClosingRoomOpenHelperFactory, queryCallback, this.mQueryCallbackExecutor);
                } else {
                    queryInterceptorOpenHelperFactory = autoClosingRoomOpenHelperFactory;
                }
                Context context = this.mContext;
                DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, this.mName, queryInterceptorOpenHelperFactory, this.mMigrationContainer, (List<Callback>) this.mCallbacks, this.mAllowMainThreadQueries, this.mJournalMode.a(context), this.mQueryExecutor, this.mTransactionExecutor, this.mMultiInstanceInvalidationIntent, this.mRequireMigration, this.mAllowDestructiveMigrationOnDowngrade, this.mMigrationsNotRequiredFrom, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, this.mPrepackagedDatabaseCallback, this.mTypeConverters, this.mAutoMigrationSpecs);
                T t11 = (RoomDatabase) Room.getGeneratedImplementation(this.mDatabaseClass, RoomDatabase.DB_IMPL_SUFFIX);
                t11.init(databaseConfiguration);
                return t11;
            } else {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
        }

        @NonNull
        public Builder<T> createFromAsset(@NonNull String str) {
            this.mCopyFromAssetPath = str;
            return this;
        }

        @NonNull
        public Builder<T> createFromFile(@NonNull File file) {
            this.mCopyFromFile = file;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder<T> createFromInputStream(@NonNull Callable<InputStream> callable) {
            this.mCopyFromInputStream = callable;
            return this;
        }

        @NonNull
        public Builder<T> enableMultiInstanceInvalidation() {
            Intent intent;
            if (this.mName != null) {
                intent = new Intent(this.mContext, MultiInstanceInvalidationService.class);
            } else {
                intent = null;
            }
            this.mMultiInstanceInvalidationIntent = intent;
            return this;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigration() {
            this.mRequireMigration = false;
            this.mAllowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigrationFrom(int... iArr) {
            if (this.mMigrationsNotRequiredFrom == null) {
                this.mMigrationsNotRequiredFrom = new HashSet(iArr.length);
            }
            for (int valueOf : iArr) {
                this.mMigrationsNotRequiredFrom.add(Integer.valueOf(valueOf));
            }
            return this;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.mRequireMigration = true;
            this.mAllowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @NonNull
        public Builder<T> openHelperFactory(@Nullable SupportSQLiteOpenHelper.Factory factory) {
            this.mFactory = factory;
            return this;
        }

        @ExperimentalRoomApi
        @NonNull
        public Builder<T> setAutoCloseTimeout(@IntRange(from = 0) long j11, @NonNull TimeUnit timeUnit) {
            if (j11 >= 0) {
                this.mAutoCloseTimeout = j11;
                this.mAutoCloseTimeUnit = timeUnit;
                return this;
            }
            throw new IllegalArgumentException("autoCloseTimeout must be >= 0");
        }

        @NonNull
        public Builder<T> setJournalMode(@NonNull JournalMode journalMode) {
            this.mJournalMode = journalMode;
            return this;
        }

        @ExperimentalRoomApi
        @NonNull
        public Builder<T> setMultiInstanceInvalidationServiceIntent(@NonNull Intent intent) {
            if (this.mName == null) {
                intent = null;
            }
            this.mMultiInstanceInvalidationIntent = intent;
            return this;
        }

        @NonNull
        public Builder<T> setQueryCallback(@NonNull QueryCallback queryCallback, @NonNull Executor executor) {
            this.mQueryCallback = queryCallback;
            this.mQueryCallbackExecutor = executor;
            return this;
        }

        @NonNull
        public Builder<T> setQueryExecutor(@NonNull Executor executor) {
            this.mQueryExecutor = executor;
            return this;
        }

        @NonNull
        public Builder<T> setTransactionExecutor(@NonNull Executor executor) {
            this.mTransactionExecutor = executor;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @NonNull
        public Builder<T> createFromAsset(@NonNull String str, @NonNull PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            this.mPrepackagedDatabaseCallback = prepackagedDatabaseCallback;
            this.mCopyFromAssetPath = str;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "StreamFiles"})
        @NonNull
        public Builder<T> createFromFile(@NonNull File file, @NonNull PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            this.mPrepackagedDatabaseCallback = prepackagedDatabaseCallback;
            this.mCopyFromFile = file;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "LambdaLast"})
        @NonNull
        public Builder<T> createFromInputStream(@NonNull Callable<InputStream> callable, @NonNull PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            this.mPrepackagedDatabaseCallback = prepackagedDatabaseCallback;
            this.mCopyFromInputStream = callable;
            return this;
        }
    }

    public static abstract class Callback {
        public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onDestructiveMigration(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean isLowRamDevice(@NonNull ActivityManager activityManager) {
            return SupportSQLiteCompat.Api19Impl.isLowRamDevice(activityManager);
        }

        public JournalMode a(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || isLowRamDevice(activityManager)) {
                return TRUNCATE;
            }
            return WRITE_AHEAD_LOGGING;
        }
    }

    public static abstract class PrepackagedDatabaseCallback {
        public void onOpenPrepackagedDatabase(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }

    public interface QueryCallback {
        void onQuery(@NonNull String str, @NonNull List<Object> list);
    }

    private void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        this.mInvalidationTracker.h(writableDatabase);
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    private void internalEndTransaction() {
        this.mOpenHelper.getWritableDatabase().endTransaction();
        if (!inTransaction()) {
            this.mInvalidationTracker.refreshVersionsAsync();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$beginTransaction$0(SupportSQLiteDatabase supportSQLiteDatabase) {
        internalBeginTransaction();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$endTransaction$1(SupportSQLiteDatabase supportSQLiteDatabase) {
        internalEndTransaction();
        return null;
    }

    @Nullable
    private <T> T unwrapOpenHelper(Class<T> cls, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (cls.isInstance(supportSQLiteOpenHelper)) {
            return supportSQLiteOpenHelper;
        }
        if (supportSQLiteOpenHelper instanceof DelegatingOpenHelper) {
            return unwrapOpenHelper(cls, ((DelegatingOpenHelper) supportSQLiteOpenHelper).getDelegate());
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (!this.mAllowMainThreadQueries && isMainThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser == null) {
            internalBeginTransaction();
        } else {
            autoCloser.executeRefCountingFunction(new p(this));
        }
    }

    @WorkerThread
    public abstract void clearAllTables();

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.mCloseLock.writeLock();
            writeLock.lock();
            try {
                this.mInvalidationTracker.f();
                this.mOpenHelper.close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public SupportSQLiteStatement compileStatement(@NonNull String str) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.getWritableDatabase().compileStatement(str);
    }

    @NonNull
    public abstract InvalidationTracker createInvalidationTracker();

    @NonNull
    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration);

    @Deprecated
    public void endTransaction() {
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser == null) {
            internalEndTransaction();
        } else {
            autoCloser.executeRefCountingFunction(new q(this));
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Collections.emptyList();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    public Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    @NonNull
    public InvalidationTracker getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    @NonNull
    public SupportSQLiteOpenHelper getOpenHelper() {
        return this.mOpenHelper;
    }

    @NonNull
    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return Collections.emptySet();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return Collections.emptyMap();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    @NonNull
    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    @Nullable
    public <T> T getTypeConverter(@NonNull Class<T> cls) {
        return this.mTypeConverters.get(cls);
    }

    public boolean inTransaction() {
        return this.mOpenHelper.getWritableDatabase().inTransaction();
    }

    @CallSuper
    public void init(@NonNull DatabaseConfiguration databaseConfiguration) {
        boolean z11;
        this.mOpenHelper = createOpenHelper(databaseConfiguration);
        Set<Class<? extends AutoMigrationSpec>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        BitSet bitSet = new BitSet();
        Iterator<Class<? extends AutoMigrationSpec>> it = requiredAutoMigrationSpecs.iterator();
        while (true) {
            int i11 = -1;
            if (it.hasNext()) {
                Class next = it.next();
                int size = databaseConfiguration.autoMigrationSpecs.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    } else if (next.isAssignableFrom(databaseConfiguration.autoMigrationSpecs.get(size).getClass())) {
                        bitSet.set(size);
                        i11 = size;
                        break;
                    } else {
                        size--;
                    }
                }
                if (i11 >= 0) {
                    this.mAutoMigrationSpecs.put(next, databaseConfiguration.autoMigrationSpecs.get(i11));
                } else {
                    throw new IllegalArgumentException("A required auto migration spec (" + next.getCanonicalName() + ") is missing in the database configuration.");
                }
            } else {
                int size2 = databaseConfiguration.autoMigrationSpecs.size() - 1;
                while (size2 >= 0) {
                    if (bitSet.get(size2)) {
                        size2--;
                    } else {
                        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                    }
                }
                Iterator<Migration> it2 = getAutoMigrations(this.mAutoMigrationSpecs).iterator();
                while (true) {
                    z11 = false;
                    if (!it2.hasNext()) {
                        break;
                    }
                    Migration next2 = it2.next();
                    if (!databaseConfiguration.migrationContainer.getMigrations().containsKey(Integer.valueOf(next2.startVersion))) {
                        databaseConfiguration.migrationContainer.addMigrations(next2);
                    }
                }
                SQLiteCopyOpenHelper sQLiteCopyOpenHelper = (SQLiteCopyOpenHelper) unwrapOpenHelper(SQLiteCopyOpenHelper.class, this.mOpenHelper);
                if (sQLiteCopyOpenHelper != null) {
                    sQLiteCopyOpenHelper.a(databaseConfiguration);
                }
                AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (AutoClosingRoomOpenHelper) unwrapOpenHelper(AutoClosingRoomOpenHelper.class, this.mOpenHelper);
                if (autoClosingRoomOpenHelper != null) {
                    AutoCloser a11 = autoClosingRoomOpenHelper.a();
                    this.mAutoCloser = a11;
                    this.mInvalidationTracker.d(a11);
                }
                if (databaseConfiguration.journalMode == JournalMode.WRITE_AHEAD_LOGGING) {
                    z11 = true;
                }
                this.mOpenHelper.setWriteAheadLoggingEnabled(z11);
                this.mCallbacks = databaseConfiguration.callbacks;
                this.mQueryExecutor = databaseConfiguration.queryExecutor;
                this.mTransactionExecutor = new TransactionExecutor(databaseConfiguration.transactionExecutor);
                this.mAllowMainThreadQueries = databaseConfiguration.allowMainThreadQueries;
                this.mWriteAheadLoggingEnabled = z11;
                Intent intent = databaseConfiguration.multiInstanceInvalidationServiceIntent;
                if (intent != null) {
                    this.mInvalidationTracker.e(databaseConfiguration.context, databaseConfiguration.f37419name, intent);
                }
                Map<Class<?>, List<Class<?>>> requiredTypeConverters = getRequiredTypeConverters();
                BitSet bitSet2 = new BitSet();
                for (Map.Entry next3 : requiredTypeConverters.entrySet()) {
                    Class cls = (Class) next3.getKey();
                    Iterator it3 = ((List) next3.getValue()).iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            Class cls2 = (Class) it3.next();
                            int size3 = databaseConfiguration.typeConverters.size() - 1;
                            while (true) {
                                if (size3 < 0) {
                                    size3 = -1;
                                    break;
                                } else if (cls2.isAssignableFrom(databaseConfiguration.typeConverters.get(size3).getClass())) {
                                    bitSet2.set(size3);
                                    break;
                                } else {
                                    size3--;
                                }
                            }
                            if (size3 >= 0) {
                                this.mTypeConverters.put(cls2, databaseConfiguration.typeConverters.get(size3));
                            } else {
                                throw new IllegalArgumentException("A required type converter (" + cls2 + ") for " + cls.getCanonicalName() + " is missing in the database configuration.");
                            }
                        }
                    }
                }
                int size4 = databaseConfiguration.typeConverters.size() - 1;
                while (size4 >= 0) {
                    if (bitSet2.get(size4)) {
                        size4--;
                    } else {
                        throw new IllegalArgumentException("Unexpected type converter " + databaseConfiguration.typeConverters.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                    }
                }
                return;
            }
        }
    }

    public void internalInitInvalidationTracker(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        this.mInvalidationTracker.b(supportSQLiteDatabase);
    }

    public boolean isOpen() {
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser != null) {
            return autoCloser.isActive();
        }
        SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase;
        if (supportSQLiteDatabase == null || !supportSQLiteDatabase.isOpen()) {
            return false;
        }
        return true;
    }

    @NonNull
    public Cursor query(@NonNull String str, @Nullable Object[] objArr) {
        return this.mOpenHelper.getWritableDatabase().query((SupportSQLiteQuery) new SimpleSQLiteQuery(str, objArr));
    }

    public void runInTransaction(@NonNull Runnable runnable) {
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Deprecated
    public void setTransactionSuccessful() {
        this.mOpenHelper.getWritableDatabase().setTransactionSuccessful();
    }

    public static class MigrationContainer {
        private HashMap<Integer, TreeMap<Integer, Migration>> mMigrations = new HashMap<>();

        private void addMigration(Migration migration) {
            int i11 = migration.startVersion;
            int i12 = migration.endVersion;
            TreeMap treeMap = this.mMigrations.get(Integer.valueOf(i11));
            if (treeMap == null) {
                treeMap = new TreeMap();
                this.mMigrations.put(Integer.valueOf(i11), treeMap);
            }
            Migration migration2 = (Migration) treeMap.get(Integer.valueOf(i12));
            if (migration2 != null) {
                Log.w("ROOM", "Overriding migration " + migration2 + " with " + migration);
            }
            treeMap.put(Integer.valueOf(i12), migration);
        }

        private List<Migration> findUpMigrationPath(List<Migration> list, boolean z11, int i11, int i12) {
            Set set;
            boolean z12;
            do {
                if (z11) {
                    if (i11 >= i12) {
                        return list;
                    }
                } else if (i11 <= i12) {
                    return list;
                }
                TreeMap treeMap = this.mMigrations.get(Integer.valueOf(i11));
                if (treeMap != null) {
                    if (z11) {
                        set = treeMap.descendingKeySet();
                    } else {
                        set = treeMap.keySet();
                    }
                    Iterator it = set.iterator();
                    while (true) {
                        z12 = false;
                        if (!it.hasNext()) {
                            break;
                        }
                        int intValue = ((Integer) it.next()).intValue();
                        if (!z11 ? !(intValue < i12 || intValue >= i11) : !(intValue > i12 || intValue <= i11)) {
                            z12 = true;
                            continue;
                        }
                        if (z12) {
                            list.add((Migration) treeMap.get(Integer.valueOf(intValue)));
                            i11 = intValue;
                            z12 = true;
                            continue;
                            break;
                        }
                    }
                } else {
                    return null;
                }
            } while (z12);
            return null;
        }

        public void addMigrations(@NonNull Migration... migrationArr) {
            for (Migration addMigration : migrationArr) {
                addMigration(addMigration);
            }
        }

        @Nullable
        public List<Migration> findMigrationPath(int i11, int i12) {
            boolean z11;
            if (i11 == i12) {
                return Collections.emptyList();
            }
            if (i12 > i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            return findUpMigrationPath(new ArrayList(), z11, i11, i12);
        }

        @NonNull
        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return Collections.unmodifiableMap(this.mMigrations);
        }

        public void addMigrations(@NonNull List<Migration> list) {
            for (Migration addMigration : list) {
                addMigration(addMigration);
            }
        }
    }

    @NonNull
    public Cursor query(@NonNull SupportSQLiteQuery supportSQLiteQuery) {
        return query(supportSQLiteQuery, (CancellationSignal) null);
    }

    @NonNull
    public Cursor query(@NonNull SupportSQLiteQuery supportSQLiteQuery, @Nullable CancellationSignal cancellationSignal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery, cancellationSignal);
        }
        return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery);
    }

    public <V> V runInTransaction(@NonNull Callable<V> callable) {
        beginTransaction();
        try {
            V call = callable.call();
            setTransactionSuccessful();
            endTransaction();
            return call;
        } catch (RuntimeException e11) {
            throw e11;
        } catch (Exception e12) {
            SneakyThrow.reThrow(e12);
            endTransaction();
            return null;
        } catch (Throwable th2) {
            endTransaction();
            throw th2;
        }
    }
}
