package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;

class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    private final SupportSQLiteOpenHelper.Callback mCallback;
    private final Context mContext;
    private OpenHelper mDelegate;
    private final Object mLock = new Object();
    private final String mName;
    private final boolean mUseNoBackupDirectory;
    private boolean mWriteAheadLoggingEnabled;

    public static class OpenHelper extends SQLiteOpenHelper {

        /* renamed from: b  reason: collision with root package name */
        public final FrameworkSQLiteDatabase[] f37624b;

        /* renamed from: c  reason: collision with root package name */
        public final SupportSQLiteOpenHelper.Callback f37625c;
        private boolean mMigrated;

        public OpenHelper(Context context, String str, final FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, final SupportSQLiteOpenHelper.Callback callback) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, callback.version, new DatabaseErrorHandler() {
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    SupportSQLiteOpenHelper.Callback.this.onCorruption(OpenHelper.c(frameworkSQLiteDatabaseArr, sQLiteDatabase));
                }
            });
            this.f37625c = callback;
            this.f37624b = frameworkSQLiteDatabaseArr;
        }

        public static FrameworkSQLiteDatabase c(FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, SQLiteDatabase sQLiteDatabase) {
            FrameworkSQLiteDatabase frameworkSQLiteDatabase = frameworkSQLiteDatabaseArr[0];
            if (frameworkSQLiteDatabase == null || !frameworkSQLiteDatabase.a(sQLiteDatabase)) {
                frameworkSQLiteDatabaseArr[0] = new FrameworkSQLiteDatabase(sQLiteDatabase);
            }
            return frameworkSQLiteDatabaseArr[0];
        }

        public synchronized SupportSQLiteDatabase a() {
            this.mMigrated = false;
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            if (this.mMigrated) {
                close();
                return a();
            }
            return b(readableDatabase);
        }

        public FrameworkSQLiteDatabase b(SQLiteDatabase sQLiteDatabase) {
            return c(this.f37624b, sQLiteDatabase);
        }

        public synchronized void close() {
            super.close();
            this.f37624b[0] = null;
        }

        public synchronized SupportSQLiteDatabase d() {
            this.mMigrated = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.mMigrated) {
                close();
                return d();
            }
            return b(writableDatabase);
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f37625c.onConfigure(b(sQLiteDatabase));
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f37625c.onCreate(b(sQLiteDatabase));
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
            this.mMigrated = true;
            this.f37625c.onDowngrade(b(sQLiteDatabase), i11, i12);
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.mMigrated) {
                this.f37625c.onOpen(b(sQLiteDatabase));
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
            this.mMigrated = true;
            this.f37625c.onUpgrade(b(sQLiteDatabase), i11, i12);
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z11) {
        this.mContext = context;
        this.mName = str;
        this.mCallback = callback;
        this.mUseNoBackupDirectory = z11;
    }

    private OpenHelper getDelegate() {
        OpenHelper openHelper;
        synchronized (this.mLock) {
            if (this.mDelegate == null) {
                FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr = new FrameworkSQLiteDatabase[1];
                if (this.mName == null || !this.mUseNoBackupDirectory) {
                    this.mDelegate = new OpenHelper(this.mContext, this.mName, frameworkSQLiteDatabaseArr, this.mCallback);
                } else {
                    this.mDelegate = new OpenHelper(this.mContext, new File(SupportSQLiteCompat.Api21Impl.getNoBackupFilesDir(this.mContext), this.mName).getAbsolutePath(), frameworkSQLiteDatabaseArr, this.mCallback);
                }
                SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(this.mDelegate, this.mWriteAheadLoggingEnabled);
            }
            openHelper = this.mDelegate;
        }
        return openHelper;
    }

    public void close() {
        getDelegate().close();
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().a();
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().d();
    }

    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z11) {
        synchronized (this.mLock) {
            OpenHelper openHelper = this.mDelegate;
            if (openHelper != null) {
                SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(openHelper, z11);
            }
            this.mWriteAheadLoggingEnabled = z11;
        }
    }
}
