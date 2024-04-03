package j2;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class f implements Function {
    public final Object apply(Object obj) {
        return Integer.valueOf(((SupportSQLiteDatabase) obj).getVersion());
    }
}
