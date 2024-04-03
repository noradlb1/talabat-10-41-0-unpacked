package j2;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class j implements Function {
    public final Object apply(Object obj) {
        return ((SupportSQLiteDatabase) obj).getAttachedDbs();
    }
}
