package j2;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class c implements Function {
    public final Object apply(Object obj) {
        return Long.valueOf(((SupportSQLiteDatabase) obj).getPageSize());
    }
}
