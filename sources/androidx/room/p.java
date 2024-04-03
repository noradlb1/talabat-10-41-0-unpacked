package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteStatement;

public final /* synthetic */ class p implements Function {
    public final Object apply(Object obj) {
        return ((SupportSQLiteStatement) obj).execute();
    }
}
