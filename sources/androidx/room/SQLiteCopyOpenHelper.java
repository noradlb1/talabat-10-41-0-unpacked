package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.room.util.CopyLock;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    @NonNull
    private final Context mContext;
    @Nullable
    private final String mCopyFromAssetPath;
    @Nullable
    private final File mCopyFromFile;
    @Nullable
    private final Callable<InputStream> mCopyFromInputStream;
    @Nullable
    private DatabaseConfiguration mDatabaseConfiguration;
    private final int mDatabaseVersion;
    @NonNull
    private final SupportSQLiteOpenHelper mDelegate;
    private boolean mVerified;

    public SQLiteCopyOpenHelper(@NonNull Context context, @Nullable String str, @Nullable File file, @Nullable Callable<InputStream> callable, int i11, @NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.mContext = context;
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mCopyFromInputStream = callable;
        this.mDatabaseVersion = i11;
        this.mDelegate = supportSQLiteOpenHelper;
    }

    private void copyDatabaseFile(File file, boolean z11) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.mCopyFromAssetPath != null) {
            readableByteChannel = Channels.newChannel(this.mContext.getAssets().open(this.mCopyFromAssetPath));
        } else if (this.mCopyFromFile != null) {
            readableByteChannel = new FileInputStream(this.mCopyFromFile).getChannel();
        } else {
            Callable<InputStream> callable = this.mCopyFromInputStream;
            if (callable != null) {
                try {
                    readableByteChannel = Channels.newChannel(callable.call());
                } catch (Exception e11) {
                    throw new IOException("inputStreamCallable exception on call", e11);
                }
            } else {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.mContext.getCacheDir());
        createTempFile.deleteOnExit();
        FileUtil.copy(readableByteChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            dispatchOnOpenPrepackagedDatabase(createTempFile, z11);
            if (!createTempFile.renameTo(file)) {
                throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
            }
            return;
        }
        throw new IOException("Failed to create directories for " + file.getAbsolutePath());
    }

    private SupportSQLiteOpenHelper createFrameworkOpenHelper(File file) {
        try {
            return new FrameworkSQLiteOpenHelperFactory().create(SupportSQLiteOpenHelper.Configuration.builder(this.mContext).name(file.getAbsolutePath()).callback(new SupportSQLiteOpenHelper.Callback(Math.max(DBUtil.readVersion(file), 1)) {
                public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                }

                public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                    int i11 = this.version;
                    if (i11 < 1) {
                        supportSQLiteDatabase.setVersion(i11);
                    }
                }

                public void onUpgrade(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i11, int i12) {
                }
            }).build());
        } catch (IOException e11) {
            throw new RuntimeException("Malformed database file, unable to read version.", e11);
        }
    }

    private void dispatchOnOpenPrepackagedDatabase(File file, boolean z11) {
        SupportSQLiteDatabase supportSQLiteDatabase;
        DatabaseConfiguration databaseConfiguration = this.mDatabaseConfiguration;
        if (databaseConfiguration != null && databaseConfiguration.prepackagedDatabaseCallback != null) {
            SupportSQLiteOpenHelper createFrameworkOpenHelper = createFrameworkOpenHelper(file);
            if (z11) {
                try {
                    supportSQLiteDatabase = createFrameworkOpenHelper.getWritableDatabase();
                } catch (Throwable th2) {
                    createFrameworkOpenHelper.close();
                    throw th2;
                }
            } else {
                supportSQLiteDatabase = createFrameworkOpenHelper.getReadableDatabase();
            }
            this.mDatabaseConfiguration.prepackagedDatabaseCallback.onOpenPrepackagedDatabase(supportSQLiteDatabase);
            createFrameworkOpenHelper.close();
        }
    }

    private void verifyDatabaseFile(boolean z11) {
        boolean z12;
        String databaseName = getDatabaseName();
        File databasePath = this.mContext.getDatabasePath(databaseName);
        DatabaseConfiguration databaseConfiguration = this.mDatabaseConfiguration;
        if (databaseConfiguration == null || databaseConfiguration.multiInstanceInvalidation) {
            z12 = true;
        } else {
            z12 = false;
        }
        CopyLock copyLock = new CopyLock(databaseName, this.mContext.getFilesDir(), z12);
        try {
            copyLock.lock();
            if (!databasePath.exists()) {
                copyDatabaseFile(databasePath, z11);
                copyLock.unlock();
            } else if (this.mDatabaseConfiguration == null) {
                copyLock.unlock();
            } else {
                try {
                    int readVersion = DBUtil.readVersion(databasePath);
                    int i11 = this.mDatabaseVersion;
                    if (readVersion == i11) {
                        copyLock.unlock();
                    } else if (this.mDatabaseConfiguration.isMigrationRequired(readVersion, i11)) {
                        copyLock.unlock();
                    } else {
                        if (this.mContext.deleteDatabase(databaseName)) {
                            try {
                                copyDatabaseFile(databasePath, z11);
                            } catch (IOException e11) {
                                Log.w("ROOM", "Unable to copy database file.", e11);
                            }
                        } else {
                            Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                        }
                        copyLock.unlock();
                    }
                } catch (IOException e12) {
                    Log.w("ROOM", "Unable to read database version.", e12);
                    copyLock.unlock();
                }
            }
        } catch (IOException e13) {
            throw new RuntimeException("Unable to copy database file.", e13);
        } catch (Throwable th2) {
            copyLock.unlock();
            throw th2;
        }
    }

    public void a(@Nullable DatabaseConfiguration databaseConfiguration) {
        this.mDatabaseConfiguration = databaseConfiguration;
    }

    public synchronized void close() {
        this.mDelegate.close();
        this.mVerified = false;
    }

    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @NonNull
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegate;
    }

    public synchronized SupportSQLiteDatabase getReadableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile(false);
            this.mVerified = true;
        }
        return this.mDelegate.getReadableDatabase();
    }

    public synchronized SupportSQLiteDatabase getWritableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile(true);
            this.mVerified = true;
        }
        return this.mDelegate.getWritableDatabase();
    }

    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z11) {
        this.mDelegate.setWriteAheadLoggingEnabled(z11);
    }
}
