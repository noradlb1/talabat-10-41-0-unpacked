package j2;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

public final /* synthetic */ class k implements Function {
    public final Object apply(Object obj) {
        return Integer.valueOf(((SupportSQLiteStatement) obj).executeUpdateDelete());
    }
}
