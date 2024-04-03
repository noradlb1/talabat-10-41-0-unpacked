package j2;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class i implements Function {
    public final Object apply(Object obj) {
        return Boolean.valueOf(((SupportSQLiteDatabase) obj).inTransaction());
    }
}
