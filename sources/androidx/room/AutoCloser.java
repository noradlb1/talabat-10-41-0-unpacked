package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

final class AutoCloser {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public Runnable f37409a = null;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Object f37410b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final long f37411c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Executor f37412d;
    @GuardedBy("mLock")

    /* renamed from: e  reason: collision with root package name */
    public int f37413e = 0;
    @GuardedBy("mLock")

    /* renamed from: f  reason: collision with root package name */
    public long f37414f = SystemClock.uptimeMillis();
    @GuardedBy("mLock")
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public SupportSQLiteDatabase f37415g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f37416h = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                androidx.room.AutoCloser r0 = androidx.room.AutoCloser.this
                java.lang.Object r0 = r0.f37410b
                monitor-enter(r0)
                long r1 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x004a }
                androidx.room.AutoCloser r3 = androidx.room.AutoCloser.this     // Catch:{ all -> 0x004a }
                long r4 = r3.f37414f     // Catch:{ all -> 0x004a }
                long r1 = r1 - r4
                long r4 = r3.f37411c     // Catch:{ all -> 0x004a }
                int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r1 >= 0) goto L_0x0016
                monitor-exit(r0)     // Catch:{ all -> 0x004a }
                return
            L_0x0016:
                int r1 = r3.f37413e     // Catch:{ all -> 0x004a }
                if (r1 == 0) goto L_0x001c
                monitor-exit(r0)     // Catch:{ all -> 0x004a }
                return
            L_0x001c:
                java.lang.Runnable r1 = r3.f37409a     // Catch:{ all -> 0x004a }
                if (r1 == 0) goto L_0x0042
                r1.run()     // Catch:{ all -> 0x004a }
                androidx.room.AutoCloser r1 = androidx.room.AutoCloser.this     // Catch:{ all -> 0x004a }
                androidx.sqlite.db.SupportSQLiteDatabase r1 = r1.f37415g     // Catch:{ all -> 0x004a }
                if (r1 == 0) goto L_0x0040
                boolean r1 = r1.isOpen()     // Catch:{ all -> 0x004a }
                if (r1 == 0) goto L_0x0040
                androidx.room.AutoCloser r1 = androidx.room.AutoCloser.this     // Catch:{ IOException -> 0x0037 }
                androidx.sqlite.db.SupportSQLiteDatabase r1 = r1.f37415g     // Catch:{ IOException -> 0x0037 }
                r1.close()     // Catch:{ IOException -> 0x0037 }
                goto L_0x003b
            L_0x0037:
                r1 = move-exception
                androidx.room.util.SneakyThrow.reThrow(r1)     // Catch:{ all -> 0x004a }
            L_0x003b:
                androidx.room.AutoCloser r1 = androidx.room.AutoCloser.this     // Catch:{ all -> 0x004a }
                r2 = 0
                r1.f37415g = r2     // Catch:{ all -> 0x004a }
            L_0x0040:
                monitor-exit(r0)     // Catch:{ all -> 0x004a }
                return
            L_0x0042:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004a }
                java.lang.String r2 = "mOnAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568"
                r1.<init>(r2)     // Catch:{ all -> 0x004a }
                throw r1     // Catch:{ all -> 0x004a }
            L_0x004a:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x004a }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.AutoCloser.AnonymousClass2.run():void");
        }
    };
    @Nullable
    private SupportSQLiteOpenHelper mDelegateOpenHelper = null;
    private final Runnable mExecuteAutoCloser = new Runnable() {
        public void run() {
            AutoCloser autoCloser = AutoCloser.this;
            autoCloser.f37412d.execute(autoCloser.f37416h);
        }
    };
    @NonNull
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mManuallyClosed = false;

    public AutoCloser(long j11, @NonNull TimeUnit timeUnit, @NonNull Executor executor) {
        this.f37411c = timeUnit.toMillis(j11);
        this.f37412d = executor;
    }

    public void closeDatabaseIfOpen() throws IOException {
        synchronized (this.f37410b) {
            this.mManuallyClosed = true;
            SupportSQLiteDatabase supportSQLiteDatabase = this.f37415g;
            if (supportSQLiteDatabase != null) {
                supportSQLiteDatabase.close();
            }
            this.f37415g = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decrementCountAndScheduleClose() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f37410b
            monitor-enter(r0)
            int r1 = r5.f37413e     // Catch:{ all -> 0x0026 }
            if (r1 <= 0) goto L_0x001e
            int r1 = r1 + -1
            r5.f37413e = r1     // Catch:{ all -> 0x0026 }
            if (r1 != 0) goto L_0x001c
            androidx.sqlite.db.SupportSQLiteDatabase r1 = r5.f37415g     // Catch:{ all -> 0x0026 }
            if (r1 != 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return
        L_0x0013:
            android.os.Handler r1 = r5.mHandler     // Catch:{ all -> 0x0026 }
            java.lang.Runnable r2 = r5.mExecuteAutoCloser     // Catch:{ all -> 0x0026 }
            long r3 = r5.f37411c     // Catch:{ all -> 0x0026 }
            r1.postDelayed(r2, r3)     // Catch:{ all -> 0x0026 }
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return
        L_0x001e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0026 }
            java.lang.String r2 = "ref count is 0 or lower but we're supposed to decrement"
            r1.<init>(r2)     // Catch:{ all -> 0x0026 }
            throw r1     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.AutoCloser.decrementCountAndScheduleClose():void");
    }

    @Nullable
    public <V> V executeRefCountingFunction(@NonNull Function<SupportSQLiteDatabase, V> function) {
        try {
            return function.apply(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    @Nullable
    public SupportSQLiteDatabase getDelegateDatabase() {
        SupportSQLiteDatabase supportSQLiteDatabase;
        synchronized (this.f37410b) {
            supportSQLiteDatabase = this.f37415g;
        }
        return supportSQLiteDatabase;
    }

    @VisibleForTesting
    public int getRefCountForTest() {
        int i11;
        synchronized (this.f37410b) {
            i11 = this.f37413e;
        }
        return i11;
    }

    @NonNull
    public SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        synchronized (this.f37410b) {
            this.mHandler.removeCallbacks(this.mExecuteAutoCloser);
            this.f37413e++;
            if (!this.mManuallyClosed) {
                SupportSQLiteDatabase supportSQLiteDatabase = this.f37415g;
                if (supportSQLiteDatabase == null || !supportSQLiteDatabase.isOpen()) {
                    SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.mDelegateOpenHelper;
                    if (supportSQLiteOpenHelper != null) {
                        SupportSQLiteDatabase writableDatabase = supportSQLiteOpenHelper.getWritableDatabase();
                        this.f37415g = writableDatabase;
                        return writableDatabase;
                    }
                    throw new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                SupportSQLiteDatabase supportSQLiteDatabase2 = this.f37415g;
                return supportSQLiteDatabase2;
            }
            throw new IllegalStateException("Attempting to open already closed database.");
        }
    }

    public void init(@NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (this.mDelegateOpenHelper != null) {
            Log.e("ROOM", "AutoCloser initialized multiple times. Please file a bug against room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
        } else {
            this.mDelegateOpenHelper = supportSQLiteOpenHelper;
        }
    }

    public boolean isActive() {
        return !this.mManuallyClosed;
    }

    public void setAutoCloseCallback(Runnable runnable) {
        this.f37409a = runnable;
    }
}
