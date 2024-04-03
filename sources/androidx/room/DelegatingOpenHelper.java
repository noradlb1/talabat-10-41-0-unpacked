package androidx.room;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

interface DelegatingOpenHelper {
    @NonNull
    SupportSQLiteOpenHelper getDelegate();
}
