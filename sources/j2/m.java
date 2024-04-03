package j2;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

public final /* synthetic */ class m implements Function {
    public final Object apply(Object obj) {
        return Long.valueOf(((SupportSQLiteStatement) obj).executeInsert());
    }
}
