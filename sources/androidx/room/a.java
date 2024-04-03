package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return Boolean.valueOf(((SupportSQLiteDatabase) obj).isWriteAheadLoggingEnabled());
    }
}
