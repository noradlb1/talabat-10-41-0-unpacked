package androidx.room;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;

final class QueryInterceptorOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final SupportSQLiteOpenHelper mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    public QueryInterceptorOpenHelper(@NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper, @NonNull RoomDatabase.QueryCallback queryCallback, @NonNull Executor executor) {
        this.mDelegate = supportSQLiteOpenHelper;
        this.mQueryCallback = queryCallback;
        this.mQueryCallbackExecutor = executor;
    }

    public void close() {
        this.mDelegate.close();
    }

    @Nullable
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @NonNull
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegate;
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        return new QueryInterceptorDatabase(this.mDelegate.getReadableDatabase(), this.mQueryCallback, this.mQueryCallbackExecutor);
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        return new QueryInterceptorDatabase(this.mDelegate.getWritableDatabase(), this.mQueryCallback, this.mQueryCallbackExecutor);
    }

    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z11) {
        this.mDelegate.setWriteAheadLoggingEnabled(z11);
    }
}
